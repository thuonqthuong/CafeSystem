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
import ptithcm.entity.SanPham;

@Controller
@Transactional
@RequestMapping("/manager/product")
public class PrdctController {
	@Autowired
	SessionFactory factory;
	private String ma;

	// ----------------------------KHỞI ĐẦU----------------------------
	public List<SanPham> getSanPhams() {
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();
		return list;
	}

	@RequestMapping("")
	public String product(ModelMap model) {
		model.addAttribute("btnStatus", "btnAdd");
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("sp", new SanPham());
		model.addAttribute("sps", DS);
		return "Manager/product";
	}

	// ----------------------------XÓA----------------------------
	public int deleteSanPham(SanPham sp) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(sp);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "/edit/{maSanPham}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("sp") SanPham sp,
			@PathVariable("maSanPham") String maSanPham) {
		System.out.print("linkDelete");
		int check = this.deleteSanPham(sp);
		if (check != 0) {
			model.addAttribute("message1", "Delete success");
		} else {
			model.addAttribute("message0", "Delete fail");
		}
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("sps", DS);

		return "Manager/product";
	}

	// ----------------------------THÊM----------------------------
	public int insertSanPham(SanPham sp) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(sp);
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
	public String addUser(ModelMap model, @ModelAttribute("sp") SanPham sp) {
		System.out.println("btnAdd");
		int check = this.insertSanPham(sp);
		if (check != 0) {
			model.addAttribute("message1", "Add success!");
			model.addAttribute("sp", new SanPham());
		} else {
			model.addAttribute("message0", "Add fail!");
		}
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("sps", DS);
		model.addAttribute("btnStatus", "btnAdd");
		return "Manager/product";
	}

	// ----------------------------SỬA----------------------------
	public int updateSanPham(SanPham sp) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(sp);
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
	public String edit_SanPham(ModelMap model, @ModelAttribute("sp") SanPham sp) {
		System.out.println("btnEdit");
		sp.setMaSanPham(ma);
		int check = this.updateSanPham(sp);
		if (check != 0) {
			model.addAttribute("message1", "Edit success!");
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("sp", new SanPham());
		} else {
			model.addAttribute("message0", "Edit fail!");
			model.addAttribute("btnStatus", "btnEdit");
		}
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("sps", DS);

		return "Manager/product";
	}

	public SanPham get1SanPham(String ma) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham where maSanPham = :ma";
		Query query = session.createQuery(hql);
		query.setParameter("ma", ma);
		SanPham list = (SanPham) query.list().get(0);
		return list;
	}

	@RequestMapping(value = "/edit/{maSanPham}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("sp") SanPham sp,
			@PathVariable("maSanPham") String maSanPham) {
		System.out.println("linkEdit");
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("sps", DS);
		ma = maSanPham;
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("sp", this.get1SanPham(ma));

		return "Manager/product";
	}
}
