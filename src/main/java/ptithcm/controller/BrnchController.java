package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import ptithcm.entity.CTCaLamViec;
import ptithcm.entity.CaLamViec;
import ptithcm.entity.DiaDiem;
import ptithcm.entity.NguyenLieu;
import ptithcm.entity.NhanVien;
import ptithcm.entity.PhieuNhap;

@Controller
@Transactional
@RequestMapping("/manager/branch")
public class BrnchController {
	@Autowired
	SessionFactory factory;
	public static NhanVien nvt = new NhanVien();
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
	
	@RequestMapping(value = "/edit/{madiadiem}.htm", params = "linkDelete")
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
		cn.setMadiadiem(ma);
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
		String hql = "FROM DiaDiem where madiadiem = :ma";
		Query query = session.createQuery(hql);
		query.setParameter("ma", ma);
		DiaDiem list = (DiaDiem) query.list().get(0);
		return list;
	}

	@RequestMapping(value = "/edit/{madiadiem}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("cn") DiaDiem cn, @PathVariable("madiadiem") String maDiaDiem) {
		System.out.println("linkEdit");
		List<DiaDiem> DS = this.getDiaDiems();
		model.addAttribute("cns", DS);
		ma = maDiaDiem;
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("cn", this.get1DiaDiem(ma));

		return "Manager/branch";
	}
	@RequestMapping("shifts")
	public String product(ModelMap model, @ModelAttribute("nhanviennhap") NhanVien nv) {
		String tdn = LoginController.tendn;
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where username = :usn";
		Query query = session.createQuery(hql);
		query.setParameter("usn", tdn);
		List<NhanVien> lst = query.list();
		nvt = lst.get(0);
		model.addAttribute("nhanviennhap", lst.get(0));
		model.addAttribute("clv", new DiaDiem());
//		model.addAttribute("clv", new CTCaLamViec());
		model.addAttribute("nhanvien", new NhanVien());
		model.addAttribute("chinhanh", new DiaDiem());
		//
		model.addAttribute("chonnhanvien", new NhanVien());
		return "Staff/shifts";
	}
	
	@ModelAttribute("cnselect")
	public List<DiaDiem> getDiaDiem() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiaDiem WHERE trangthai = true";
		Query query = session.createQuery(hql);
		List<DiaDiem> list = query.list();
		return list;
	}
	
	@ModelAttribute("nvselect")
	public List<NhanVien> getNhanVien() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		return list;
	}
	
	@RequestMapping(value = "shifts", params="XacNhanCN")
	public String DiaDiem(ModelMap model, @ModelAttribute("madiadiem") String madiadiem) {
		DiaDiem chinhanh = new DiaDiem();
		System.out.println(madiadiem);
		Session session = factory.getCurrentSession();
		String hql = "FROM DiaDiem WHERE madiadiem = madiadiem";
		Query query = session.createQuery(hql);
		chinhanh = (DiaDiem) query.list().get(0);
		model.addAttribute("nhanviennhap", nvt);
		//Hiển thị giờ làm việc tương ứng
		Session session1 = factory.getCurrentSession();
		String hql1 = "SELECT U FROM CaLamViec U";
		Query query1 = session1.createQuery(hql1);
		List<CaLamViec> DS = query1.list();
		List<CaLamViec> DSCLV = new ArrayList<>();;
		for(CaLamViec i: DS) {
			if((i.getCalamviec_diadiem().getMadiadiem()).equals(madiadiem)) {
				DSCLV.add(i);
			}
		}
		model.addAttribute("clvs", DSCLV);
		model.addAttribute("clv", new DiaDiem());
//		model.addAttribute("clv", new CTCaLamViec());
		model.addAttribute("chinhanh", new DiaDiem());
		model.addAttribute("nhanvien", new NhanVien());
		//cmt
		model.addAttribute("chonnhanvien", new NhanVien());
		return "Staff/shifts";
	}
}
