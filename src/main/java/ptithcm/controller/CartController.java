package ptithcm.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.SanPham;

@Controller
@Transactional
@RequestMapping("/cart")
public class CartController {
	@Autowired
	SessionFactory factory;
	public static List<SanPham> cart;

	@RequestMapping(value = "cart/insert/{masanpham}", method = RequestMethod.GET)
	public String cartInsert(ModelMap model, @PathVariable("masanpham") String id, HttpServletRequest request) {
		HttpSession sessionhttp = request.getSession();
		String tendangnhap = LoginController.tendn;
		model.addAttribute("userLogin", tendangnhap);
		int sl;
		if (request.getParameter("qtt") == null)
			sl = 1;
		else
			sl = Integer.parseInt(request.getParameter("qtt"));
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPham WHERE masanpham = id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<SanPham> lst = query.list();
		if (lst != null) {
			cart.add(lst.get(sl));
		}
		/*
		 * if (lst!=null) { lst.get(0).set(cartCopy.getQuantity()+sl);
		 * System.out.println(sl+" - "+cartCopy.getQuantity());
		 * cartDao.createOrUpdate(cartCopy); } else { Bicycle flo=
		 * bicycleDao.getBicycleById(floId); if (flo.getDiscount()==null)
		 * flo.setDiscount(0); BigDecimal
		 * sale=(flo.getPrice().multiply(BigDecimal.valueOf(flo.getDiscount()))).divide(
		 * BigDecimal.valueOf(100)); ShopCart cart=new
		 * ShopCart(0,sl,flo.getPrice().add(sale.multiply(BigDecimal.valueOf(-1))),false
		 * ,user,flo); cartDao.createOrUpdate(cart); }
		 */
		return "Staff/cart";
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

	public int delete(Object cn) {
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

	public int update(Object cn) {
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
}
