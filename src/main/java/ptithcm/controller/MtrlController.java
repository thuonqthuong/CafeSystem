package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ptithcm.entity.CTPhieuNhap;
import ptithcm.entity.DiaDiem;
import ptithcm.entity.DonVi;
import ptithcm.entity.NguyenLieu;
import ptithcm.entity.NhanVien;
import ptithcm.entity.PhieuNhap;
import ptithcm.entity.SanPham;
import ptithcm.entity.TaiKhoan;

@Controller
@Transactional
@RequestMapping("/manager/material")
public class MtrlController {
	@Autowired
	SessionFactory factory;
	private String ma;
	//----------------------------KHỞI ĐẦU----------------------------
	
	public List<NguyenLieu> getNguyenLieus() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NguyenLieu"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<NguyenLieu> list = query.list();
		return list;
	}
	
	@ModelAttribute("cnselect")
	public List<DiaDiem> getDiaDiem() {
		Session session = factory.getCurrentSession();
		String hql="FROM DiaDiem";
		Query query = session.createQuery(hql);
		List<DiaDiem> list = query.list();
		return list;
	}
	
	@ModelAttribute("nlselect")
	public List<NguyenLieu> getNguyenLieu() {
		Session session = factory.getCurrentSession();
		String hql="FROM NguyenLieu";
		Query query = session.createQuery(hql);
		List<NguyenLieu> list = query.list();
		return list;
	}
	
	public List<CTPhieuNhap> getCTNhaps() {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTPhieuNhap"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<CTPhieuNhap> list = query.list();
		return list;
	}
	
	public List<PhieuNhap> getPhieuNhaps() {
		Session session = factory.getCurrentSession();
		String hql = "FROM PhieuNhap"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<PhieuNhap> list = query.list();
		return list;
	}

	@RequestMapping("/CTPN")
	public String CTPN(ModelMap model) {
		List<CTPhieuNhap> DS = this.getCTNhaps();
		model.addAttribute("ctpns", DS);
		return "Manager/material_details";
	}
	
	@RequestMapping("/PN")
	public String PN(ModelMap model) {
		List<PhieuNhap> DS = this.getPhieuNhaps();
		model.addAttribute("ctpns", DS);
		return "Manager/phieunhap";
	}

	@RequestMapping("")
	public String employee(ModelMap model, NguyenLieu nguyenlieu) {
		System.out.println("No mapping");
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("nl", new NguyenLieu());
		model.addAttribute("nls", DS);
		return "Manager/materials";
	}

	@ModelAttribute("units")
	public List<DonVi> getDonVi() {
		Session session = factory.getCurrentSession();
		String hql="FROM DonVi";
		Query query = session.createQuery(hql);
		List<DonVi> list = query.list();
		return list;
	}
	//----------------------------XÓA----------------------------
	public int deleteNguyenLieu(NguyenLieu nl) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(nl);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("exception: "+e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "/edit/{manguyenlieu}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("nl") NguyenLieu nl, @PathVariable("manguyenlieu") String maNguyenLieu) {
		System.out.println("linkDelete ");
		int check = this.deleteNguyenLieu(nl);
		System.out.print("check: " + check);
		if (check == 1) {
			model.addAttribute("message1", "Delete success");
		} else {
			model.addAttribute("message0", "Delete fail");
		}
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("nl", new NguyenLieu());
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("nls", DS);

		return "Manager/materials";
	}
	//----------------------------THÊM----------------------------
	public int insertNguyenLieu(NguyenLieu nl) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(nl);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("exception: "+e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "edit", params = "btnAdd")
	public String addUser(ModelMap model, @ModelAttribute("nl") NguyenLieu nl) {
		System.out.println("btnAdd");
		int check = this.insertNguyenLieu(nl);
		if (check != 0) {
			model.addAttribute("message1", "Add success!");
			model.addAttribute("nl", new NguyenLieu());
		} else {
			model.addAttribute("message0", "Add fail!");
		}
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("nls", DS);
		model.addAttribute("btnStatus", "btnAdd");
		return "Manager/materials";
	}
	//----------------------------SỬA----------------------------
	public int updateUser(NguyenLieu nl) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(nl);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("exception: "+e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "edit", params = "btnEdit")
	public String edit_User(ModelMap model, @ModelAttribute("nl") NguyenLieu nl) {
		System.out.println("btnEdit");
		nl.setManguyenlieu(ma);
		int check = this.updateUser(nl);
		if (check != 0) {
			model.addAttribute("message1", "Edit success!");
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("nl", new NguyenLieu());
		} else {
			model.addAttribute("message0", "Edit fail!");
			model.addAttribute("btnStatus", "btnEdit");
		}
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("nls", DS);

		return "Manager/materials";
	}

	public NguyenLieu get1NguyenLieu(String maNguyenLieu) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NguyenLieu where manguyenlieu = :maNguyenLieu";
		Query query = session.createQuery(hql);
		query.setParameter("maNguyenLieu", maNguyenLieu);
		NguyenLieu list = (NguyenLieu) query.list().get(0);
		System.out.println(list.getTennguyenlieu());
		return list;
	}

	@RequestMapping(value = "edit/{manguyenlieu}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("nl") NguyenLieu nl, @PathVariable("manguyenlieu") String maNguyenLieu) {
		System.out.println("linkEdit");
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("nls", DS);
		ma = maNguyenLieu;
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("nl", this.get1NguyenLieu(ma));

		return "Manager/materials";
	}

	//----------------------------PHIẾU NHẬP----------------------------
	@RequestMapping("import")
	public String NhapNL(ModelMap model, HttpServletRequest request, @ModelAttribute("nhanvien") NhanVien nhanvien) {
//		model.addAttribute("btnStatus", "btnAdd");
//		List<NguyenLieu> DS = this.getNguyenLieus();

		HttpSession ss = request.getSession();
		String usn = (String) ss.getAttribute("nhanvien");
		System.out.println("Username"+usn);
//		model.addAttribute("nhanvien", usn);
		
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where username = :usn";
		Query query = session.createQuery(hql);
		query.setParameter("usn", usn);
		List<NhanVien> list = query.list();
		
//		System.out.println(list.get(0).getTen());
		model.addAttribute("pn", new PhieuNhap());
		model.addAttribute("cnselect", new DiaDiem());
		for(NhanVien nv: list) {
			System.out.println(nv.getTen());
		}
		model.addAttribute("pns", this.getPhieuNhaps());

		return "Manager/nhapNL";
	}
}
