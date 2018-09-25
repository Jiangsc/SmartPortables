//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/AddUpdateOrder")
//
//public class AddUpdateOrder extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		storeOrders(request, response);
//
//		/* User Information(username,password,usertype) is obtained from HttpServletRequest,
//		Based on the Type of user(customer,retailer,manager) respective hashmap is called and the username and 
//		password are validated and added to session variable and display Login Function is called */
//
//		//String id = request.getParameter("id");
//		//String name = request.getParameter("name");
//		String price = request.getParameter("price");
//		//String image = request.getParameter("image");
//		//String maker = request.getParameter("maker");
//		//String condition = request.getParameter("condition");
//		//String discount = request.getParameter("discount");
//		int orderId = Integer.parseInt(request.getParameter("orderId"));
//		
//		boolean update = false;
//		boolean add = true;
//		HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
//		//Phone phone = new Phone();
//	    //orderPayments.setOrdertId((orderid);
//		//phone.setName(name);
//		//orderPayments.setOrderPrice(Double.parseDouble(price));
//		//phone.setImage(image);
//		//phone.setRetailer(maker);
//		//phone.setCondition(condition);
//		//phone.setDiscount(Double.parseDouble(discount));
//		//orderPayments.putAll();
//		//HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
//		String TOMCAT_HOME = System.getProperty("catalina.home");
//
//		try {
//			FileInputStream fileInputStream = new FileInputStream(
//					new File("\\Users\\sanchuanjiang\\Desktop\\PaymentDetails.txt"));
//			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//			orderPayments = (HashMap) objectInputStream.readObject();
//		} catch (Exception e) {
//			// System.out.println("wrong!!!!!!!");
//		}
//		Iterator keys = orderPayments.keySet().iterator();
//		while(keys.hasNext()){
//			int key = (int)keys.next();
//			if(orderId == key){
//				System.out.println("This product has been updated successfully!");
//				update = true;
//				add = false;
//			}
//		}
//		//SaxParserDataStore.phones.put(phone.getId(), phone);
//		
////		String TOMCAT_HOME = System.getProperty("catalina.home");
////		//user details are validated using a file 
////		//if the file containts username and passoword user entered user will be directed to home page
////		//else error message will be shown
////		try
////		{		
////          FileInputStream fileInputStream = new FileInputStream(new File("\\Users\\sanchuanjiang\\Desktop\\UserDetails.txt"));
////          ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);	      
////		  hm = (HashMap)objectInputStream.readObject();
////		}
////		catch(Exception e)
////		{
////				
////		}
////		User user = hm.get(username);
////		if(user!=null)
////		{
////		 String user_password = user.getPassword();
////		 String user_type = user.getUsertype();
////		 if (password.equals(user_password) && usertype.equals(user_type)) 
////			{
////			HttpSession session = request.getSession(true);
////			session.setAttribute("username", user.getName());
////			session.setAttribute("usertype", user.getUsertype());
////			response.sendRedirect("Home");
////			return;
////			}
////		}
//		
//		displayLogin(request, response, pw, add, update);
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		displayLogin(request, response, pw, false, false);
//	}
//
//	
//	/*  Login Screen is Displayed, Registered User specifies credentials and logins into the Game Speed Application. */
//	protected void displayLogin(HttpServletRequest request, HttpServletResponse response, PrintWriter pw, boolean done, boolean update) //更新在此处修改
//			throws ServletException, IOException {
//
//		Utilities utility = new Utilities(request, pw);
//		utility.printHtml("Header.html");
//		pw.print("<div class='post' style='float: none; width: 100%'>");
//		pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Add/Update</a></h2>"
//				+ "<div class='entry'>"
//				+ "<div style='width:400px; margin:25px; margin-left: auto;margin-right: auto;'>");
//		if (done)
//			pw.print("<h4 style='color:red'>Add success!</h4>");
//		if (update == true) {
//			pw.print("<h4 style='color:red'>Update success!</h4>");
//		}
////		HttpSession session = request.getSession(true);
////		if(session.getAttribute("login_msg")!=null){			
////			pw.print("<h4 style='color:red'>"+session.getAttribute("login_msg")+"</h4>");
////			session.removeAttribute("login_msg");
////		}
//		
//		pw.print("<form method='post' action='Addphone'>"
//				+ "<table style='width:100%'><tr><td>"
//				+ "<h3>ID</h3></td><td><input type='text' name='id' value='' class='input' required></input>"
//				+ "</td></tr><tr><td>"
//				+ "<h3>name</h3></td><td><input type='text' name='name' value='' class='input' required></input>"
//				+ "</td></tr><tr><td>"
//				//+ "<h3>User Type</h3></td><td><select name='usertype' class='input'><option value='customer' selected>Customer</option><option value='storemanager'>Store Manager</option><option value='salesman'>Salesman</option></select>"
//				//+ "</td></tr><tr><td></td><td>"
//				+ "<h3>price</h3></td><td><input type='text' name='price' value='' class='input' required></input>"
//				+ "</td></tr><tr><td>"
//				+ "<h3>image</h3></td><td><input type='text' name='image' value='' class='input' required></input>"
//				+ "</td></tr><tr><td>"
//				+ "<h3>maker</h3></td><td><input type='text' name='maker' value='' class='input' required></input>"
//				+ "</td></tr><tr><td>"
//				+ "<h3>condition</h3></td><td><input type='text' name='condition' value='' class='input' required></input>"
//				+ "</td></tr><tr><td>"
//				+ "<h3>discount</h3></td><td><input type='text' name='discount' value='' class='input' required></input>"
//				+ "</td></tr><tr><td>"
//				+ "<input type='submit' class='btnbuy' value='Add/Update' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>"
//				+ "</td></tr><tr><td></td><td>"
//				+ "</form>" + "</div></div></div>");
//		
//		utility.printHtml("Footer.html");
//	}
//	
//	protected void storeOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    try
//        {
//        response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//        Utilities utility = new Utilities(request,pw);
//		if(!utility.isLoggedin())
//		{
//			HttpSession session = request.getSession(true);				
//			session.setAttribute("login_msg", "Please Login to add/update orders");
//			response.sendRedirect("Login");
//			return;
//		}
//        HttpSession session=request.getSession(); 
//
//		//get the order product details	on clicking submit the form will be passed to submitorder page	
//		
////	    String userName = session.getAttribute("username").toString();
//		int orderId = Integer.parseInt(request.getParameter("orderId"));
//        String orderTotal = request.getParameter("orderTotal");
////		utility.printHtml("Header.html");
////		utility.printHtml("LeftNavigationBar.html");
////		pw.print("<form name ='CheckOut' action='Payment' method='post'>");
////        pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
////		pw.print("<a style='font-size: 24px;'>Order</a>");
////		pw.print("</h2><div class='entry'>");
////		pw.print("<table  class='gridtable'><tr><td>Customer Name:</td><td>");
////		pw.print(userName);
////		pw.print("</td></tr>");
//		// for each order iterate and display the order name price
//		for (OrderItem oi : utility.getCustomerOrders()) 
//		{
//			pw.print("<tr><td> Product Purchased:</td><td>");
//			pw.print(oi.getName()+"</td></tr><tr><td>");
//			pw.print("<input type='hidden' name='orderPrice' value='"+oi.getPrice()+"'>");
//			pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+"'>");
//			pw.print("Product Price:</td><td>"+ oi.getPrice());
//			pw.print("</td></tr>");
//		}
//		pw.print("<tr><td>");
//        pw.print("Total Order Cost</td><td>"+orderTotal);
//		pw.print("<input type='hidden' name='orderTotal' value='"+orderTotal+"'>");
//		pw.print("</td></tr></table><table><tr></tr><tr></tr>");	
//		pw.print("<tr><td>");
//     	pw.print("NewOrderTotal</td>");
//		pw.print("<td><input type='text' name='NewOrderTotal'>");
//		pw.print("</td></tr>");
//		pw.print("<tr><td>");
//	    pw.print("Customer Address</td>");
//    	pw.print("<td><input type='text' name='userAddress'>");
//        pw.print("</td></tr>");
//		pw.print("<tr><td colspan='2'>");
//		pw.print("<input type='submit' name='submit' class='btnbuy'>");
//        pw.print("</td></tr></table></form>");
//		pw.print("</div></div></div>");	
//		HashMap<Integer, ArrayList<OrderPayment>> orderPayments= new HashMap<Integer, ArrayList<OrderPayment>>();
//		ArrayList<OrderPayment> listOrderPayment = orderPayments.get(orderId);	
//		
//		try
//		{
//			FileInputStream fileInputStream = new FileInputStream(new File("\\Users\\sanchuanjiang\\Desktop\\PaymentDetails.txt"));
//			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);	      
//			orderPayments = (HashMap)objectInputStream.readObject();
//		}
//		catch(Exception e)
//		{
//		}
//		if(orderPayments==null)
//		{
//			orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
//		}
//		if(!orderPayments.containsKey(orderId)){	
//			ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
//			orderPayments.put(orderId, arr);
//		}
//		
//		
//		//分段
//		utility.printHtml("Footer.html");
//	    }
//        catch(Exception e)
//		{
//         System.out.println(e.getMessage());
//		}  			
//	}
//	
//  
//
//}
