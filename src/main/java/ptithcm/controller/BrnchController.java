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

import ptithcm.entity.DiaDiem;

@Controller
@Transactional
@RequestMapping("/manager/branch")
public class BrnchController {
	@Autowired
	SessionFactory factory;
	private String ma;
	
	//----------------------------KHỞI ĐẦU----------------------------
	public List<DiaDiem> getDiaDiems() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiaDiem"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<DiaDiem> list = query.list();
		return list;
	}
	
	@RequestMapping("")
	public String branch(ModelMap model) {
		model.addAttribute("btnStatus", "btnAdd");
		List<DiaDiem> DS = this.getDiaDiems();
		model.addAttribute("cn", new DiaDiem());
		model.addAttribute("cns", DS);
		return "Manager/branch";
	}
	//----------------------------XÓA----------------------------
	public int deleteDiaDiem(DiaDiem cn) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(cn);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	@RequestMapping(value = "/edit/{maDiaDiem}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("cn") DiaDiem cn) {
		System.out.print("linkDelete");
		int check = this.deleteDiaDiem(cn);
		if (check != 0) {
			model.addAttribute("message1", "Delete success");
		}
		else {
			model.addAttribute("message0", "Delete fail");
		}
		List<DiaDiem> DS = this.getDiaDiems();
		model.addAttribute("cns", DS);
		model.addAttribute("cn", new DiaDiem());
		return "Manager/branch";
	}
	//----------------------------THÊM----------------------------
	public int insertDiaDiem(DiaDiem cn) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(cn);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "/edit", params = "btnAdd")
	public String addUser(ModelMap model, @ModelAttribute("cn") DiaDiem cn) {
		System.out.println("btnAdd");
		int check = this.insertDiaDiem(cn);
		if (check != 0) {
			model.addAttribute("message1", "Add success!");
			model.addAttribute("cn", new DiaDiem());
		} else {
			model.addAttribute("message0", "Add fail!");
		}
		List<DiaDiem> DS = this.getDiaDiems();
		model.addAttribute("cns", DS);
		model.addAttribute("btnStatus", "btnAdd");
		return "Manager/branch";
	}
	//----------------------------SỬA----------------------------
	public int updateChiNhanh(DiaDiem cn) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(cn);
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
	public String edit_User(ModelMap model, @ModelAttribute("cn") DiaDiem cn) {
		System.out.println("btnEdit");
		cn.setMaDiaDiem(ma);
		int check = this.updateChiNhanh(cn);
		if (check != 0) {
			model.addAttribute("message1", "Edit success!");
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("cn", new DiaDiem());
		} else {
			model.addAttribute("message0", "Edit fail!");
			model.addAttribute("btnStatus", "btnEdit");
		}
		List<DiaDiem> DS = this.getDiaDiems();
		model.addAttribute("cns", DS);

		return "Manager/branch";
	}

	public DiaDiem get1DiaDiem(String ma) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiaDiem where maDiaDiem = :ma";
		Query query = session.createQuery(hql);
		query.setParameter("ma", ma);
		DiaDiem list = (DiaDiem) query.list().get(0);
		return list;
	}

	@RequestMapping(value = "/edit/{maDiaDiem}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("cn") DiaDiem cn, @PathVariable("maDiaDiem") String maDiaDiem) {
		System.out.println("linkEdit");
		List<DiaDiem> DS = this.getDiaDiems();
		model.addAttribute("cns", DS);
		ma = maDiaDiem;
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("cn", this.get1DiaDiem(ma));

		return "Manager/branch";
	}

}
