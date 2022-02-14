package ptithcm.controller;

import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.bean.Mailer;

@Controller
public class HomeController {
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
}
