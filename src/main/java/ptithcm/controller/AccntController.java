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
import ptithcm.entity.Quyen;
import ptithcm.entity.TaiKhoan;

@Controller
@Transactional
@RequestMapping("/manager/account")
public class AccntController {
	@Autowired
	SessionFactory factory;
	private String ma;
	
	//----------------------------KHỞI ĐẦU----------------------------
	public List<TaiKhoan> getTaiKhoans() {
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan"; /* as us order by us.idUser desc */
		Query query = session.createQuery(hql);
		List<TaiKhoan> list = query.list();
		return list;
	}
	
	@RequestMapping("")
	public String branch(ModelMap model) {
		model.addAttribute("btnStatus", "btnAdd");
		List<TaiKhoan> DS = this.getTaiKhoans();
		model.addAttribute("tk", new TaiKhoan());
		model.addAttribute("tks", DS);
		return "Manager/account";
	}
	@ModelAttribute("aus")
	public List<Quyen> getQuyen() {
		Session session = factory.getCurrentSession();
		String hql="FROM Quyen";
		Query query = session.createQuery(hql);
		List<Quyen> list = query.list();
		return list;
	}
	//----------------------------XÓA----------------------------
	public int deleteTaiKhoan(TaiKhoan tk) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(tk);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			System.out.println("exception: "+e);
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "/edit/{username}.htm", params = "linkDelete")
	public String delete(ModelMap model, @ModelAttribute("tk") TaiKhoan tk, @PathVariable("username") String username) {
		System.out.print("linkDelete");
		int check = this.deleteTaiKhoan(tk);
		if (check != 0) {
			model.addAttribute("message1", "Delete success");
		}
		else {
			model.addAttribute("message0", "Delete fail");
		}
		List<TaiKhoan> DS = this.getTaiKhoans();
		model.addAttribute("tks", DS);
		model.addAttribute("btnStatus", "btnAdd");
		return "Manager/account";
	}
	//----------------------------THÊM----------------------------
		public int insertTaiKhoan(TaiKhoan tk) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				tk.setStts(true);
				session.save(tk);
				t.commit();
			} catch (Exception e) {
				t.rollback();
				System.out.println("exception: "+e);
				return 0;
			} finally {
				session.close();
			}
			return 1;
		}

		@RequestMapping(value = "/edit", params = "btnAdd")
		public String addAccount(ModelMap model, @ModelAttribute("tk") TaiKhoan tk) {
			System.out.println("btnAdd");
			int check = this.insertTaiKhoan(tk);
			if (check != 0) {
				model.addAttribute("message1", "Add success!");
				model.addAttribute("tk", new TaiKhoan());
			} else {
				model.addAttribute("message0", "Add fail!");
			}
			List<TaiKhoan> DS = this.getTaiKhoans();
			model.addAttribute("tks", DS);
			model.addAttribute("btnStatus", "btnAdd");
			return "Manager/account";
		}
		//----------------------------SỬA----------------------------
		public int updateTaiKhoan(TaiKhoan tk) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(tk);
				t.commit();
			} catch (Exception e) {
				t.rollback();
				System.out.println("exception: "+e);
				return 0;
			} finally {
				session.close();
			}
			return 1;
		}

		@RequestMapping(value = "/edit", params = "btnEdit")
		public String edit_Account(ModelMap model, @ModelAttribute("tk") TaiKhoan tk) {
			System.out.println("btnEdit");
			tk.setUsername(ma);
			int check = this.updateTaiKhoan(tk);
			if (check != 0) {
				model.addAttribute("message1", "Edit success!");
				model.addAttribute("btnStatus", "btnAdd");
				model.addAttribute("tk", new TaiKhoan());
			} else {
				model.addAttribute("message0", "Edit fail!");
				model.addAttribute("btnStatus", "btnEdit");
			}
			List<TaiKhoan> DS = this.getTaiKhoans();
			model.addAttribute("tks", DS);

			return "Manager/account";
		}

		public TaiKhoan get1TaiKhoan(String ma) {
			Session session = factory.getCurrentSession();
			String hql = "FROM TaiKhoan where username = :ma";
			Query query = session.createQuery(hql);
			query.setParameter("ma", ma);
			TaiKhoan list = (TaiKhoan) query.list().get(0);
			return list;
		}

		@RequestMapping(value = "/edit/{username}.htm", params = "linkEdit")
		public String editAccount(ModelMap model, @ModelAttribute("tk") TaiKhoan tk, @PathVariable("username") String username) {
			System.out.println("linkEdit");
			List<TaiKhoan> DS = this.getTaiKhoans();
			model.addAttribute("tks", DS);
			ma = username;
			model.addAttribute("btnStatus", "btnEdit");
			model.addAttribute("tk", this.get1TaiKhoan(ma));

			return "Manager/account";
		}
}
