package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.entity.NhanVien;
import ptithcm.entity.TaiKhoan;

@Controller
@Transactional
@RequestMapping("/manager/employee")
public class EplyController {
	private String s="btnAdd";
	
	//----------------------------KHỞI ĐẦU----------------------------
	@RequestMapping("")
	public String employee(ModelMap model) {
		System.out.println("Khong lam gi ca");
		List<NhanVien> DS = this.getNhanViens();
		s="btnAdd";
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("nv", new NhanVien());
		model.addAttribute("nvs", DS);
		return "Manager/employee";
	}

	private String ma;

	@Autowired
	SessionFactory factory;

	public List<NhanVien> getNhanViens() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		return list;
	}
	//----------------------------THÊM----------------------------
	public int insertNhanVien(NhanVien us) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(us);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@ModelAttribute("accounts")
	public List<TaiKhoan> getTaiKhoan() {
		Session session = factory.getCurrentSession();
		String hql="FROM TaiKhoan A WHERE A.Stts=True";
		System.out.println("MA: "+ma);
		if(s=="btnAdd")
		{
			hql = "FROM TaiKhoan A WHERE A.Stts=True";
		}
		/*
		 * else if(s=="btnEdit") { hql =
		 * "FROM TaiKhoan A WHERE A.Username= :ma OR A.Stts=False";
		 * query.setParameter("ma", ma); }
		 */
		Query query = session.createQuery(hql);
		List<TaiKhoan> list = query.list();
		return list;
	}

	@RequestMapping(value = "/edit", params = "btnAdd")
	public String addUser(ModelMap model, @ModelAttribute("nv") NhanVien nv) {
		System.out.println("btnAdd");
		int check = this.insertNhanVien(nv);
		if (check != 0) {
			model.addAttribute("message1", "Add success!");
			model.addAttribute("nv", new NhanVien());
		} else {
			model.addAttribute("message0", "Add fail!");
		}
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nvs", DS);
		s="btnAdd";
		model.addAttribute("btnStatus", "btnAdd");
		return "Manager/employee";
	}
	//----------------------------SỬA----------------------------
	public int updateUser(NhanVien user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "/edit", params = "btnEdit")
	public String edit_User(ModelMap model, @ModelAttribute("nv") NhanVien nv) {
		System.out.println("btnEdit");
		nv.setMaNV(ma);
		int check = this.updateUser(nv);
		if (check != 0) {
			model.addAttribute("message1", "Edit success!");
			s="btnAdd";
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("nv", new NhanVien());
		} else {
			model.addAttribute("message0", "Edit fail!");
			s="btnEdit";
			model.addAttribute("btnStatus", "btnEdit");
		}
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nvs", DS);

		return "Manager/employee";
	}

	public NhanVien get1NhanVien(String ma) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where maNV = :ma";
		Query query = session.createQuery(hql);
		query.setParameter("ma", ma);
		NhanVien list = (NhanVien) query.list().get(0);
		return list;
	}

	@RequestMapping(value = "/edit/{maNV}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("nv") NhanVien nv, @PathVariable("maNV") String maNV) {
		System.out.println("linkEdit");
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nvs", DS);
		ma = maNV;
		s="btnEdit";
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("nv", this.get1NhanVien(ma));
		
		return "Manager/employee";
	}
	//----------------------------XÓA----------------------------
	public int deleteNhanVien(NhanVien us) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(us);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "/edit/{maNV}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("nv") NhanVien nv/* , @PathVariable("maNV") String maNV */) {
		System.out.println("linkDelete");
		int check = this.deleteNhanVien(nv);
		if (check != 0) {
			model.addAttribute("message1", "Delete success");
		} else {
			model.addAttribute("message0", "Delete fail");
		}
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nvs", DS);

		return "Manager/employee";
	}

}
