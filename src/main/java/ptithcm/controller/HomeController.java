package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ptithcm.entity.CTHoaDon;
import ptithcm.entity.SanPham;

@Controller
public class HomeController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("home")
	public String home() {
		return "Authority/homepage";
	}
	@RequestMapping("/login")
	public String login() {
		return "Authority/login";
	}
	@RequestMapping("forget")
	public String matKhau() {
		return "Authority/forget";
	}
	@RequestMapping("dashboard")
	public String dashboard() {
		return "Manager/Dashboard";
	}
	
//	@RequestMapping(value = "{masanpham}", method = RequestMethod.GET)
//	public String hat2(ModelMap model, @PathVariable("masanpham") String masanpham, HttpSession httpSession) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM SanPham WHERE masanpham = '" + masanpham + "'";
//		Query query = session.createQuery(hql);
//		if(query.list().size()==0)
//			return "404";
//		SanPham seed = (SanPham) query.list().get(0);
//		model.addAttribute("Seed", seed);
//		CTHoaDon orderDetail = new CTHoaDon();
//		model.addAttribute("orderDetail", orderDetail);
//		model.addAttribute("themgiohang", new OrderDTO());
//		return "Authority/homepage";
//	}
}
