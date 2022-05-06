package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
