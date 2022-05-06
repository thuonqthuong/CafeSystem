package ptithcm.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	private int idEdit;
	public static int id = 0;
	public static NhanVien nvt = new NhanVien();
	public static PhieuNhap phieunhaptemp;
	public static DiaDiem postion;
	public static Timestamp thoigiannhap;
	public static List<CTPhieuNhap> ctphieunhaplst = new LinkedList<CTPhieuNhap>();
	// ----------------------------KHỞI ĐẦU----------------------------

	@RequestMapping("")
	public String product(ModelMap model) {
		model.addAttribute("btnStatus", "btnAdd");
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("nl", new NguyenLieu());
		model.addAttribute("nls", DS);
		return "Manager/materials";
	}

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
		String hql = "FROM DiaDiem WHERE trangthai = true";
		Query query = session.createQuery(hql);
		List<DiaDiem> list = query.list();
		return list;
	}

	@ModelAttribute("nlselect")
	public List<NguyenLieu> getNguyenLieu() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NguyenLieu";
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

	public DiaDiem layDiaDiem(String ma) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiaDiem where madiadiem = :ma";
		Query query = session.createQuery(hql);
		query.setParameter("ma", ma);
		List<DiaDiem> lstpos = query.list();
		return lstpos.get(0);
	}

	public NguyenLieu layNguyenLieu(String tennguyenlieu) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NguyenLieu where tennguyenlieu = :ten";
		Query query = session.createQuery(hql);
		query.setParameter("ten", tennguyenlieu);
		return (NguyenLieu) query.list().get(0);
	}

	public CTPhieuNhap layPhieuNhap(int ma) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTPhieuNhap where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", ma);
		System.out.println("id truy van: " + ma);
		return (CTPhieuNhap) query.list().get(0);
	}

	public DonVi layDonVi(String madonvi) {
		Session session1 = factory.getCurrentSession();
		String hql1 = "FROM DonVi where tendonvi = :donvi";
		Query query1 = session1.createQuery(hql1);
		query1.setParameter("donvi", madonvi);
		return (DonVi) query1.list().get(0);
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

	@ModelAttribute("donvi")
	public List<DonVi> getDonVi() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DonVi";
		Query query = session.createQuery(hql);
		List<DonVi> list = query.list();
		return list;
	}

	public int insertObject(Object object) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(object);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("exception: " + e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public int updateObject(Object object) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(object);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("exception: " + e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public int deleteObject(Object object) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(object);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("exception: " + e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public NguyenLieu get1NguyenLieu(String maNguyenLieu) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NguyenLieu where manguyenlieu = :maNguyenLieu";
		Query query = session.createQuery(hql);
		query.setParameter("maNguyenLieu", maNguyenLieu);
		NguyenLieu list = (NguyenLieu) query.list().get(0);
		return list;
	}

	// ----------------------------XÓA----------------------------
	@RequestMapping(value = "/edit/{manguyenlieu}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("nl") NguyenLieu nl,
			@PathVariable("manguyenlieu") String maNguyenLieu) {
		System.out.println("linkDelete ");
		int check = this.deleteObject(nl);
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

	// ----------------------------THÊM----------------------------
	@RequestMapping(value = "edit", params = "btnAdd")
	public String addUser(ModelMap model, @ModelAttribute("nl") NguyenLieu nl) {
		System.out.println("btnAdd");
		int check = this.insertObject(nl);
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

	// ----------------------------SỬA----------------------------
	@RequestMapping(value = "edit", params = "btnEdit")
	public String edit_User(ModelMap model, @ModelAttribute("nl") NguyenLieu nl) {
		System.out.println("btnEdit");
		nl.setManguyenlieu(ma);
		int check = this.updateObject(nl);
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

	@RequestMapping(value = "edit/{manguyenlieu}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @ModelAttribute("nl") NguyenLieu nl,
			@PathVariable("manguyenlieu") String maNguyenLieu) {
		System.out.println("linkEdit");
		List<NguyenLieu> DS = this.getNguyenLieus();
		model.addAttribute("nls", DS);
		ma = maNguyenLieu;
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("nl", this.get1NguyenLieu(ma));

		return "Manager/materials";
	}

	// ----------------------------PHIẾU NHẬP----------------------------
	// ----------------------------phieu nhap----------------------------
	@RequestMapping("import")
	public String NhapNL(ModelMap model, @ModelAttribute("nhanviennhap") NhanVien nv) {
		model.addAttribute("btnStatus", "btnAdd");
		String tdn = LoginController.tendn;
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where username = :usn";
		Query query = session.createQuery(hql);
		query.setParameter("usn", tdn);
		List<NhanVien> lst = query.list();
		nvt = lst.get(0);
		model.addAttribute("nhanviennhap", lst.get(0));
		model.addAttribute("pn", new PhieuNhap());
		model.addAttribute("pns", this.getPhieuNhaps());

		Date localDate = new Date();
		Timestamp timestamp2 = new Timestamp(localDate.getTime());
		return "Manager/nhapNL";
	}

	@RequestMapping(value = "import", params = "btnAdd")
	public String addPhieuNhap(ModelMap model, @ModelAttribute("pn") PhieuNhap pn, HttpServletRequest request) {
		String nvtemp = request.getParameter("nhanvientemp");
		pn.setPhieunhap_nhanvien(nvt);
		pn.setMaphieunhap(1);
		Date localDate = new Date();
		Timestamp timestamp = new Timestamp(localDate.getTime());
		pn.setNgaygio(timestamp);
		phieunhaptemp = pn;
		thoigiannhap = phieunhaptemp.getNgaygio();
		return "redirect:http://localhost:8080/CoffeeHouse/manager/material/importdetails.htm";
	}

	// ----------------------------ctnl----------------------------

	@RequestMapping("importdetails")
	public String CtNhapNL(ModelMap model) {
		model.addAttribute("confirmnhanvien", nvt);
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("ctpn", new CTPhieuNhap());
		model.addAttribute("ctpns", ctphieunhaplst);
		postion = layDiaDiem(phieunhaptemp.getPhieunhap_diadiem().getMadiadiem());
		phieunhaptemp.setPhieunhap_diadiem(postion);
		model.addAttribute("confirmchinhanh", postion);
		model.addAttribute("confirmthoigian", phieunhaptemp.getNgaygio());
		System.out.println();
		return "Manager/ctpn";
	}

	@RequestMapping(value = "importdetails", params = "btnAdd")
	public String addCTPhieuNhap(ModelMap model, HttpServletRequest request) {
		NguyenLieu nl = layNguyenLieu(request.getParameter("nguyenlieu"));
		DonVi dv = layDonVi(request.getParameter("donvi"));
		CTPhieuNhap t = new CTPhieuNhap();
		t.setId(id++);
		t.setCtphieunhap_donvi(dv);
		t.setCtphieunhap_nguyenlieu(nl);
		t.setDongia(Double.valueOf(request.getParameter("dongia")));
		boolean flag = false;
		for (CTPhieuNhap ct : ctphieunhaplst) {
			if ((ct.getCtphieunhap_nguyenlieu().getManguyenlieu()).equals(nl.getManguyenlieu())
					&& ((ct.getCtphieunhap_donvi()).equals(nl.getNguyenlieu_donvi()))
					&& ((ct.getDongia() - t.getDongia()) == 0)) {
				t.setSoluong(t.getSoluong() + Float.valueOf(request.getParameter("soluong")));
				flag = true;
			}
		}
		if (flag = true) {
			t.setSoluong(Float.valueOf(request.getParameter("soluong")));
		}
		ctphieunhaplst.add(t);
		model.addAttribute("ctpns", ctphieunhaplst);
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("confirmnhanvien", nvt);
		model.addAttribute("confirmchinhanh", postion);
		model.addAttribute("confirmthoigian", thoigiannhap);
		return "Manager/ctpn";
	}

	@RequestMapping(value = "/importdetails/{id}.htm", params = "linkEdit")
	public String editUser(ModelMap model, @PathVariable("id") int ide, HttpServletRequest request) {
		System.out.print("linkEdit");
		model.addAttribute("confirmnhanvien", nvt);
		model.addAttribute("confirmchinhanh", postion);
		model.addAttribute("confirmthoigian", thoigiannhap);
		idEdit = ide;
		for (CTPhieuNhap n : ctphieunhaplst) {
			System.out.println(n.getId());
			System.out.println(n.getCtphieunhap_nguyenlieu().getTennguyenlieu());
			System.out.println(n.getDongia());
			System.out.println(n.getSoluong());
		}
		request.setAttribute("editsoluong", ctphieunhaplst.get(ide).getSoluong());
		request.setAttribute("editdongia", ctphieunhaplst.get(ide).getDongia());
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("ctpns", ctphieunhaplst);
		return "Manager/ctpn";
	}

	@RequestMapping(value = "/importdetails/edit", params = "btnEdit")
	public String edit_CTPhieuNhap(ModelMap model, HttpServletRequest request) {
		System.out.print("btnEdit");
		model.addAttribute("confirmnhanvien", nvt);
		model.addAttribute("confirmchinhanh", postion);
		model.addAttribute("confirmthoigian", thoigiannhap);
		ctphieunhaplst.get(idEdit).setDongia(Double.valueOf(request.getParameter("dongia")));
		ctphieunhaplst.get(idEdit).setSoluong(Float.valueOf(request.getParameter("soluong")));
		model.addAttribute("btnStatus", "btnAdd");
		for (CTPhieuNhap n : ctphieunhaplst) {
			System.out.println(n.getId());
			System.out.println(n.getCtphieunhap_nguyenlieu().getTennguyenlieu());
			System.out.println(n.getDongia());
			System.out.println(n.getSoluong());
		}
		model.addAttribute("ctpns", ctphieunhaplst);
		return "Manager/ctpn";
	}

	@RequestMapping(value = "/importdetails/{id}.htm", params = "linkDelete")
	public String deleteCTPN(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("confirmnhanvien", nvt);
		model.addAttribute("confirmchinhanh", postion);
		model.addAttribute("confirmthoigian", thoigiannhap);
		ctphieunhaplst.remove(Integer.parseInt(id));
		model.addAttribute("ctpns", ctphieunhaplst);
		model.addAttribute("btnStatus", "btnAdd");
		return "Manager/ctpn";
	}

	@RequestMapping(value = "importdetails", params = "btnDeleteAll")
	public String deleteAll(ModelMap model) {
		id = 0;
		model.addAttribute("confirmnhanvien", nvt);
		model.addAttribute("confirmchinhanh", postion);
		model.addAttribute("confirmthoigian", thoigiannhap);
		ctphieunhaplst = new LinkedList<CTPhieuNhap>();
		model.addAttribute("ctpns", ctphieunhaplst);
		return "Manager/ctpn";
	}

	@RequestMapping(value = "importdetails", params = "btnSave")
	public String confirm(ModelMap model) {
		model.addAttribute("confirmnhanvien", nvt);
		model.addAttribute("confirmchinhanh", postion);
		model.addAttribute("confirmthoigian", thoigiannhap);
		model.addAttribute("ctpns", ctphieunhaplst);
		int check = this.insertObject(phieunhaptemp);
		if (check != 0) {
			if (ctphieunhaplst.isEmpty()) {
				model.addAttribute("message0", "Thêm thất bại!");
			} else {
				for (CTPhieuNhap ctpn : ctphieunhaplst) {
					ctpn.setId(1);
					ctpn.setPhieunhap(phieunhaptemp);
					int check1 = this.insertObject(ctpn);
					if (check1 == 0) {
						model.addAttribute("message0", "Thêm thất bại!");
						break;
					}
				}
				model.addAttribute("message1", "Thêm thành công!");
			}
			return "Manager/ctpn";
		} else {
			model.addAttribute("message0", "Thêm thất bại!");
		}
		return "Manager/ctpn";
	}
}
