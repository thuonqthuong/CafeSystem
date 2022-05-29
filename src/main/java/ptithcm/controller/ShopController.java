package ptithcm.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.dto.GiaDTO;
import ptithcm.dto.checkoutDTO;
import ptithcm.entity.CTHoaDon;
import ptithcm.entity.CTNguyenLieu;
import ptithcm.entity.DiaDiem;
import ptithcm.entity.Gia;
import ptithcm.entity.HoaDon;
import ptithcm.entity.NguyenLieu;
import ptithcm.entity.NhanVien;
import ptithcm.entity.SanPham;
import shop.entity.Bicycle;

@Transactional
@Controller
@RequestMapping("/cart")
public class ShopController {
	static int soluongsp = 0;
	Double sum = (double) 0;
	// Bang gia tat ca san pham trong CSDL
	public static List<GiaDTO> banggiasp = new ArrayList<GiaDTO>();
	// Danh sach san pham, so luong, don gia mua, tong tien nuas
	public static List<checkoutDTO> chitietmuahang = new ArrayList<checkoutDTO>();

	@Autowired
	SessionFactory factory;

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
			GiaDTO temp = new GiaDTO();
			sp1 = DS.get(i).getMasanpham();
			for (int j = 0; j < Intrgr.size(); j++) {
				sp2 = Intrgr.get(j).getGia_sanpham().getMasanpham();
				if (sp1.equals(sp2)) {
					myList.add(Intrgr.get(j).getGia());
					temp.setCongthuc(DS.get(i).getCongthuc());
					temp.setGhichu(DS.get(i).getGhichu());
					temp.setMasanpham(sp1);
					temp.setTensanpham(DS.get(i).getTensanpham());
					temp.setGia(Intrgr.get(j).getGia());
					banggiasp.add(temp);
					temp = null;
					break;
				}
			}
		}
		return myList;
	}

	public int insert(Object cn) {
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

	@RequestMapping("main")
	public String index(ModelMap model, HttpServletRequest request) {
		List<SanPham> list = this.getSanPhams();
		model.addAttribute("products", list);
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(2);
		pagedListHolder.setPageSize(12);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("products", list);
		return "Staff/main";
	}

	@RequestMapping("buymore")
	public String muahang(ModelMap model) {
		String user = LoginController.tendn;
		model.addAttribute("userLogin", user);
		model.addAttribute("soluongsp", soluongsp);
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("products", DS);
		model.addAttribute("price", getGias());
		return "Authority/buylist";
	}

	@RequestMapping("deleteAll")
	public String xoagiohang(ModelMap model) {
		soluongsp = 0;
		chitietmuahang = new ArrayList<checkoutDTO>();
		String user = LoginController.tendn;
		model.addAttribute("userLogin", user);
		model.addAttribute("soluongsp", soluongsp);
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("products", DS);
		model.addAttribute("price", getGias());
		return "redirect:/cart/insert.htm";
	}

	@RequestMapping(value = "insert/{masanpham}")
	public String cartInsert(ModelMap model, @ModelAttribute("masanpham") String masanpham,
			HttpServletRequest request) {
		String user = LoginController.tendn;
		model.addAttribute("userLogin", user);
		soluongsp++;
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham where masanpham = :masanpham";
		Query query = session.createQuery(hql);
		query.setParameter("masanpham", masanpham);
		SanPham sp = (SanPham) query.list().get(0);
		checkoutDTO temp = new checkoutDTO();
		temp.setCongthuc(sp.getCongthuc());
		temp.setGhichu(sp.getGhichu());
		List<Double> myList = getGias();
		List<Double> myGia = new ArrayList<Double>();
		for (GiaDTO i : banggiasp) {
			if (i.getMasanpham().equals(sp.getMasanpham()))
				temp.setGia(i.getGia());
		}
		temp.setMasanpham(sp.getMasanpham());
		temp.setSoluong(1);// Chua xet so luong chinh sua, nhap vao
		temp.setTensanpham(sp.getTensanpham());
		int flag = 0;
		int pos = -1;
		if (chitietmuahang != null) {
			for (int i = 0; i < chitietmuahang.size(); i++) {
				if (chitietmuahang.get(i).getMasanpham().equals(temp.getMasanpham())) {
					flag = 1;
					chitietmuahang.get(i).setSoluong(chitietmuahang.get(i).getSoluong() + 1);
					soluongsp--;
					pos = i;
					temp.setSoluong(chitietmuahang.get(i).getSoluong());
					break;
					// Chưa xét trường hợp số lượng lớn hơn 1 được thêm vào giỏ hàng nha
				}
			}
		}
		temp.setTongtien(temp.getGia() * temp.getSoluong());
		if (pos != -1) {
			chitietmuahang.remove(pos);
			chitietmuahang.add(temp);
		}
		if (flag == 0 || chitietmuahang == null) {
			chitietmuahang.add(temp);
		}
		sum = (double) 0;
		for (checkoutDTO i : chitietmuahang) {
			sum += (double) (i.getTongtien());
		}
		model.addAttribute("subTotal", sum);
		model.addAttribute("soluongsp", soluongsp);
		model.addAttribute("themgiohang", new checkoutDTO());
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("products", DS);
		checkoutDTO t = new checkoutDTO();
		model.addAttribute("price", myList);
		temp = null;
		return "Authority/buylist";
	}

	@RequestMapping(value = "/insert")
	public String addUser(ModelMap model) {
		String user = LoginController.tendn;
		model.addAttribute("subTotal", sum);
		model.addAttribute("userLogin", user);
		List<Double> myGia = new ArrayList<Double>();
		List<String> tenSP = new ArrayList<String>();
		for (checkoutDTO i : chitietmuahang) {
			myGia.add(i.getGia());
			tenSP.add(i.getTensanpham());
		}
		model.addAttribute("gia", myGia);

		model.addAttribute("carts", chitietmuahang);
		return "Staff/cart";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String cartUpdate(ModelMap model, HttpServletRequest request) {
		String user = LoginController.tendn;
		model.addAttribute("userLogin", user);
		model.addAttribute("subTotal", sum);
		sum = (double) 0;
		for (checkoutDTO i : chitietmuahang) {
			int sl = Integer.parseInt(request.getParameter("qtt" + i.getMasanpham()));
			i.setSoluong(sl);
			i.setTongtien(i.getGia() * sl);
			sum += i.getTongtien();
		}
		return "redirect:/cart/insert.htm";
	}

	@RequestMapping(value = "/delete/{masanpham}", method = RequestMethod.GET)
	public String cartDelete(ModelMap model, @PathVariable("masanpham") String masanpham, HttpServletRequest request) {
		String user = LoginController.tendn;
		model.addAttribute("userLogin", user);
		// check delete true user
		sum = (double) 0;
		for (int i = 0; i < chitietmuahang.size(); i++) {
			if (masanpham.equals(chitietmuahang.get(i).getMasanpham())) {
				chitietmuahang.remove(i);
				soluongsp--;
			}
		}
		for (int i = 0; i < chitietmuahang.size(); i++) {
			sum += chitietmuahang.get(i).getTongtien();
		}
		model.addAttribute("subTotal", sum);
		return "redirect:/cart/insert.htm";
	}

	@RequestMapping(value = "/checkout")
	public String thanhtoan(ModelMap model) {
		String user = LoginController.tendn;
		model.addAttribute("userLogin", user);
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where username = :usn";
		Query query = session.createQuery(hql);
		query.setParameter("usn", user);
		NhanVien nvban = (NhanVien) query.list().get(0);
		// check delete true user
		// Them vao bang HoaDon
		HoaDon hoadon = new HoaDon();
		hoadon.setMahoadon(1);
		hoadon.setHoadon_nhanvien(nvban);
		Date localDate = new Date();
		Timestamp timestamp = new Timestamp(localDate.getTime());
		hoadon.setNgaylap(timestamp);
		hoadon.setTongtien(sum);
		int check = this.insert(hoadon);
		if (check != 0) {
//			model.addAttribute("message1", "Add success!");
		} else {
//			model.addAttribute("message0", "Add fail!");
		}

		// Them chi tiet hoa don
		CTHoaDon cthoadon = new CTHoaDon();
		for (checkoutDTO i : chitietmuahang) {
			// San pham mua ne!
			SanPham temp = new SanPham();
			temp.setCongthuc(i.getCongthuc());
			temp.setGhichu(i.getGhichu());
			temp.setMasanpham(i.getMasanpham());
			temp.setTensanpham(i.getTensanpham());

			cthoadon.setId(1);
			cthoadon.setSoluong(i.getSoluong());
			cthoadon.setHoadon(hoadon);
			cthoadon.setCthoadon_sanpham(temp);
			int check1 = this.insert(cthoadon);
			if (check1 != 0) {
				model.addAttribute("message1", "Mua hàng thành công");
			} else {
				model.addAttribute("message0","Mua hàng thất bại");
			}

			model.addAttribute("carts", chitietmuahang);
		}
		return "Staff/checkout";
	}

	@RequestMapping("new")
	public String muamoi(ModelMap model) throws InterruptedException {
		String user = LoginController.tendn;
		model.addAttribute("userLogin", user);
		model.addAttribute("carts", chitietmuahang);
		soluongsp = 0;
		Thread.sleep(1000);
		chitietmuahang = new ArrayList<checkoutDTO>();
		List<SanPham> DS = this.getSanPhams();
		model.addAttribute("products", DS);
		model.addAttribute("price", getGias());
		return "Authority/buylist";
	}
	@RequestMapping(value="details/{masanpham}",method = RequestMethod.GET)
	public String detail(ModelMap model, @PathVariable("masanpham") String masanpham) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham where masanpham = :masanpham";
		Query query = session.createQuery(hql);
		query.setParameter("masanpham", masanpham);
		SanPham sp = (SanPham) query.list().get(0);
		model.addAttribute("bicycle", flo);
		return "shop/product_detail";
	}
}
