package tunehubproject.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;
import tunehubproject.entity.users;
import tunehubproject.services.usersservices;

@Controller
public class paymentcontroller {
	@Autowired
	usersservices service;

	@GetMapping("/makepayment")
	public String makepayment() {
		return "makepayment";
	}

	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(HttpSession session) {

		int  amount  = 5000;
		Order order=null;
		try {
			RazorpayClient razorpay=new RazorpayClient("rzp_test_QydBx8Co2aJBP5", "7ARq6EGPiZdSRLWfBSLax4LX");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amount*100); // amount in the smallest currency unit
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_11");

			order = razorpay.orders.create(orderRequest);

			String mail =  (String) session.getAttribute("email");

			users u = service.getuser(mail);
			u.setIspremium(true);
			service.updateuser(u);

		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		finally {
			return order.toString();
		}
	}	
}