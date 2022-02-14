package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.entity.TaiKhoan;

@Controller
@Transactional
@RequestMapping("/login")
public class LoginController {
	TaiKhoan taikhoan = new TaiKhoan();
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("logout")
	public String logout(HttpSession ss) {
		taikhoan.setUsername("");
		taikhoan.setPassword("");
		return "Authority/logout";
	}
	
	@RequestMapping("logininfo")
	public String login(HttpServletRequest rq, ModelMap model, HttpSession ss) {
		String username = rq.getParameter("username");
		String password = rq.getParameter("password");
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan WHERE Username = :username AND Password = :password";
		/*
		 * = '" + username + "' AND password = '" + password + "'";
		 */ 
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<TaiKhoan> list = query.list();
		if (list.size() == 0) {
			return "Authority/login";
		}
		else {
			taikhoan = list.get(0);
//			ss.setAttribute("myLogin", taikhoan);
//			ss.setAttribute("dn", taikhoan.getAdmin());
			if (taikhoan.getQuyen().getMaQuyen().equals("QL")){
//				List<Seed> list1 = getSeed();
//				model.addAttribute("Seed", list1);
				return "Manager/Dashboard";
			}
			else
				return "Authority/homepage";
		}
	}
}
