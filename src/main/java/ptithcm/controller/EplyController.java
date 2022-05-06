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
	@Autowired
	SessionFactory factory;
	private String s = "btnAdd";
	private String ma;
//	List<TaiKhoan> listht = null;

	// ----------------------------KHỞI ĐẦU----------------------------
	public List<NhanVien> getNhanViens() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		return list;
	}

	@RequestMapping("")
	public String product(ModelMap model) {
		System.out.println("No mapping Emply");
		model.addAttribute("btnStatus", "btnAdd");
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nv", new NhanVien());
		model.addAttribute("nvs", DS);
		return "Manager/employee";
	}
	
	@RequestMapping(value = "/edit", params = "reload")
	public String addUser(ModelMap model) {
		model.addAttribute("btnStatus", "btnAdd");
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nv", new NhanVien());
		model.addAttribute("nvs", DS);
		return "Manager/employee";
	}

	// ----------------------------THÊM----------------------------
	public int insertNhanVien(NhanVien us) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(us);
			t.commit();
		} catch (Exception e) {
			System.out.println("Ex add: " + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@ModelAttribute("accounts")
	public List<TaiKhoan> getTaiKhoan() {
		ModelMap model = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan A WHERE A.stts=True";
		System.out.println("MA HIEN THI: " + ma);
		Query query = session.createQuery(hql);
		NhanVien nvtemp = new NhanVien();
		if (s == "btnAdd") {
			hql = "FROM TaiKhoan A WHERE A.stts=True";
		}
		else if (s == "btnEdit") {
			hql = "FROM TaiKhoan A WHERE A.stts=False";
			nvtemp = get1NhanVien(ma);
			System.out.println(nvtemp.getTaikhoan().getUsername());
		}
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
		model.addAttribute("btnStatus", "btnAdd");
		return "Manager/employee";
	}
	// ----------------------------SỬA----------------------------
	public int updateUser(NhanVien user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(user);
			t.commit();
		} catch (Exception e) {
			System.out.println("Ex update: " + e);
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
		nv.setManv(ma);
		int check = this.updateUser(nv);
		if (check != 0) {
			model.addAttribute("message1", "Edit success!");
			s = "btnAdd";
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("nv", new NhanVien());
		} else {
			model.addAttribute("message0", "Edit fail!");
			s = "btnEdit";
			model.addAttribute("btnStatus", "btnEdit");
		}
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nvs", DS);

		return "Manager/employee";
	}

	public NhanVien get1NhanVien(String manv) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where manv = :manv";
		Query query = session.createQuery(hql);
		query.setParameter("manv", manv);
		NhanVien list = (NhanVien) query.list().get(0);
		return list;
	}

	@RequestMapping(value = "/edit/{manv}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("nv") NhanVien nv, @PathVariable("manv") String maNV) {
		NhanVien nvtemp = new NhanVien();
		nvtemp = get1NhanVien(maNV);
		System.out.println(nvtemp.getTaikhoan().getUsername());
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nvs", DS);
		ma = maNV;
		s = "btnEdit";
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("nv", this.get1NhanVien(ma));
		return "Manager/employee";
	}

	// ----------------------------XÓA----------------------------
	public int deleteNhanVien(NhanVien nv) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(nv);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "/edit/{manv}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("nv") NhanVien nv) {
		System.out.print("linkDelete");
		int check = this.deleteNhanVien(nv);
		if (check != 0) {
			model.addAttribute("message1", "Delete success");
		} else {
			model.addAttribute("message0", "Delete fail");
		}
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("nv", new NhanVien());
		List<NhanVien> DS = this.getNhanViens();
		model.addAttribute("nvs", DS);

		return "Manager/employee";
	}

}
