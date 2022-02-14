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

import ptithcm.entity.DonVi;
import ptithcm.entity.NguyenLieu;

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

	@RequestMapping("")
	public String employee(ModelMap model) {
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

	@RequestMapping(value = "/edit/{maNguyenLieu}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("nl") NguyenLieu nl) {
		System.out.println("linkDelete");
		int check = this.deleteNguyenLieu(nl);
		System.out.print("check: " + check);
		if (check != 0) {
			model.addAttribute("message1", "Delete success");
		} else {
			model.addAttribute("message0", "Delete fail");
		}
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
		System.out.print("btnAdd");
		int check = this.insertNguyenLieu(nl);
		if (check != 0) {
			model.addAttribute("message1", "Add success!");
			model.addAttribute(new NguyenLieu());
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
		System.out.print("btnEdit");
		nl.setMaNguyenLieu(ma);
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
		String hql = "FROM NguyenLieu where maNguyenLieu = :maNguyenLieu";
		Query query = session.createQuery(hql);
		query.setParameter("maNguyenLieu", maNguyenLieu);
		NguyenLieu list = (NguyenLieu) query.list().get(0);
		System.out.println(list.getTenNguyenLieu());
		return list;
	}

	@RequestMapping(value = "edit/{maNguyenLieu}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("nl") NguyenLieu nl, @PathVariable("maNguyenLieu") String maNguyenLieu) {
		System.out.print("linkEdit");
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("nls", DS);
		ma = maNguyenLieu;
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("nl", this.get1NguyenLieu(ma));

		return "Manager/materials";
	}
}
