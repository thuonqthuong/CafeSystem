package ptithcm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.dto.GiaDTO;
import ptithcm.dto.checkoutDTO;
import ptithcm.entity.CTHoaDon;
import ptithcm.entity.DiaDiem;
import ptithcm.entity.Gia;
import ptithcm.entity.NguyenLieu;
import ptithcm.entity.NhanVien;
import ptithcm.entity.SanPham;
import ptithcm.entity.TaiKhoan;

@Controller
@Transactional
@RequestMapping("/login")
public class LoginController {
	TaiKhoan taikhoan = new TaiKhoan();
	public static String tendn;
	public GiaDTO banggia;

	@Autowired
	SessionFactory factory;

	@RequestMapping("logout")
	public String logout(HttpSession ss) {
		taikhoan.setUsername("");
		taikhoan.setPassword("");
		return "Authority/logout";
	}

	public List<SanPham> getSanPhams() {
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();
		return list;
	}

	public List getGias() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Gia p ORDER BY p.thoigian"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<Double> myList = new ArrayList<Double>();
		List<Gia> Intrgr = query.list();
		List<Gia> list = query.list();
		String sp1, sp2;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				sp1 = list.get(i).getGia_sanpham().getMasanpham();
				sp2 = list.get(j).getGia_sanpham().getMasanpham();
				if (sp1.equals(sp2)) {
					if (list.get(i).getThoigian().before(list.get(j).getThoigian())) {
						Intrgr.remove(i);
					}
				}
			}
		}
		List<SanPham> DS = this.getSanPhams();
		for (int i = 0; i < DS.size(); i++) {
			sp1 = DS.get(i).getMasanpham();
			for (int j = 0; j < Intrgr.size(); j++) {
				sp2 = Intrgr.get(j).getGia_sanpham().getMasanpham();
				if (sp1.equals(sp2)) {
					myList.add(Intrgr.get(j).getGia());
					break;
				}
			}
		}
		return myList;
	}

	@RequestMapping("logininfo")
	public String login(HttpServletRequest rq, ModelMap model, HttpSession ss) {
		String username = rq.getParameter("username");
		String password = rq.getParameter("password");
		model.addAttribute("userLogin", username);
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan WHERE username = :username AND password = :password";
		/*
		 * = '" + username + "' AND password = '" + password + "'";
		 */
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<TaiKhoan> list = query.list();

		if (list.size() == 0) {
			return "Authority/login";
		} else {
			taikhoan = list.get(0);
			tendn = taikhoan.getUsername();
			String hql1 = "FROM NhanVien where username = :tendn";
			Query query1 = session.createQuery(hql1);
			query1.setParameter("tendn", tendn);
			List<NhanVien> lst = query1.list();
			String name = lst.get(0).getHo() + " " + lst.get(0).getTen();
			model.addAttribute("name", name);
			ss.setAttribute("nhanvien", taikhoan.getUsername());
			if (taikhoan.getQuyen().getMaquyen().equals("QL")) {
				return "Manager/Dashboard";
			} else {
				List<SanPham> DS = this.getSanPhams();
				model.addAttribute("products", DS);
				model.addAttribute("themgiohang" ,new checkoutDTO());
				model.addAttribute("price", getGias());
				return "Authority/homepage";
			}
		}
	}
}
