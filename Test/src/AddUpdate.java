import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUpdate")

public class AddUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* User Information(username,password,usertype) is obtained from HttpServletRequest,
		Based on the Type of user(customer,retailer,manager) respective hashmap is called and the username and 
		password are validated and added to session variable and display Login Function is called */

		String id = request.getParameter("id");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		String image = request.getParameter("image");
		String maker = request.getParameter("maker");
		String condition = request.getParameter("condition");
		String discount = request.getParameter("discount");
		boolean update = false;
		boolean add = true;
		//HashMap<String, Phone> hm=new HashMap<String, Phone>();
		HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
//		Order order = new Order();
//		OrdersHashMap order = new OrdersHashMap();
//		order.setOrderId(id);
//		order.setName(name);
//		order.setPrice(Double.parseDouble(price));
//		order.setImage(image);
//		order.setRetailer(maker);
//		order.setCondition(condition);
//		order.setDiscount(Double.parseDouble(discount));
//		hm.putAll(SaxParserDataStore.phones);
//		Iterator keys = hm.keySet().iterator();
//		while(keys.hasNext()){
//			String key = (String)keys.next();
//			if(id.equals(key)){
//				System.out.println("This product has been updated successfully!");
//				update = true;
//				add = false;
//			}
//		}
//		SaxParserDataStore.phones.put(phone.getId(), phone);
		
//		String TOMCAT_HOME = System.getProperty("catalina.home");
//		//user details are validated using a file 
//		//if the file containts username and passoword user entered user will be directed to home page
//		//else error message will be shown
//		try
//		{		
//          FileInputStream fileInputStream = new FileInputStream(new File("\\Users\\sanchuanjiang\\Desktop\\UserDetails.txt"));
//          ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);	      
//		  hm = (HashMap)objectInputStream.readObject();
//		}
//		catch(Exception e)
//		{
//				
//		}
//		User user = hm.get(username);
//		if(user!=null)
//		{
//		 String user_password = user.getPassword();
//		 String user_type = user.getUsertype();
//		 if (password.equals(user_password) && usertype.equals(user_type)) 
//			{
//			HttpSession session = request.getSession(true);
//			session.setAttribute("username", user.getName());
//			session.setAttribute("usertype", user.getUsertype());
//			response.sendRedirect("Home");
//			return;
//			}
//		}
		
		displayLogin(request, response, pw, add, update);
	}
	
	
//	public void storePayment(int orderId, String username,
//			String orderName,double orderPrice,String userAddress,String creditCardNo){
//			HashMap<Integer, ArrayList<OrderPayment>> orderPayments= new HashMap<Integer, ArrayList<OrderPayment>>();
//			String TOMCAT_HOME = System.getProperty("catalina.home");
//				// get the payment details file 
//				try
//				{
//					FileInputStream fileInputStream = new FileInputStream(new File("\\Users\\sanchuanjiang\\Desktop\\PaymentDetails.txt"));
//					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);	      
//					orderPayments = (HashMap)objectInputStream.readObject();
//				}
//				catch(Exception e)
//				{
//				}
//				if(orderPayments==null)
//				{
//					orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
//				}
//				// if there exist order id already add it into same list for order id or create a new record with order id
//				
//				if(!orderPayments.containsKey(orderId)){	
//					ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
//					orderPayments.put(orderId, arr);
//				}
//			ArrayList<OrderPayment> listOrderPayment = orderPayments.get(orderId);
//			//String username;
//			OrderPayment orderpayment = new OrderPayment(orderId,username,orderName,orderPrice,userAddress,creditCardNo);
//			listOrderPayment.add(orderpayment);	
//				
//				// add order details into file
//
//				try
//				{	
//					FileOutputStream fileOutputStream = new FileOutputStream(new File("\\Users\\sanchuanjiang\\Desktop\\PaymentDetails.txt"));
//					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//	            	objectOutputStream.writeObject(orderPayments);
//					objectOutputStream.flush();
//					objectOutputStream.close();       
//					fileOutputStream.close();
//				}
//				catch(Exception e)
//				{
//					System.out.println("inside exception file not written properly");
//				}	
//		}

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		displayLogin(request, response, pw, false, false);
	}

	
	/*  Login Screen is Displayed, Registered User specifies credentials and logins into the Game Speed Application. */
	protected void displayLogin(HttpServletRequest request, HttpServletResponse response, PrintWriter pw, boolean add, boolean update) //更新在此处修改
			throws ServletException, IOException {

		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		pw.print("<div class='post' style='float: none; width: 100%'>");
		pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Add/Update</a></h2>"
				+ "<div class='entry'>"
				+ "<div style='width:400px; margin:25px; margin-left: auto;margin-right: auto;'>");
		if (add == true)
			pw.print("<h4 style='color:red'>Add success!</h4>");
		if (update == true) {
			pw.print("<h4 style='color:red'>Update success!</h4>");
		}
//		HttpSession session = request.getSession(true);
//		if(session.getAttribute("login_msg")!=null){			
//			pw.print("<h4 style='color:red'>"+session.getAttribute("login_msg")+"</h4>");
//			session.removeAttribute("login_msg");
//		}
		
		pw.print("<form method='post' action='Addphone'>"
				+ "<table style='width:100%'><tr><td>"
				+ "<h3>ID</h3></td><td><input type='text' name='id' value='' class='input' required></input>"
				+ "</td></tr><tr><td>"
				+ "<h3>name</h3></td><td><input type='text' name='name' value='' class='input' required></input>"
				+ "</td></tr><tr><td>"
				//+ "<h3>User Type</h3></td><td><select name='usertype' class='input'><option value='customer' selected>Customer</option><option value='storemanager'>Store Manager</option><option value='salesman'>Salesman</option></select>"
				//+ "</td></tr><tr><td></td><td>"
				+ "<h3>price</h3></td><td><input type='text' name='price' value='' class='input' required></input>"
				+ "</td></tr><tr><td>"
				+ "<h3>image</h3></td><td><input type='text' name='image' value='' class='input' required></input>"
				+ "</td></tr><tr><td>"
				+ "<h3>maker</h3></td><td><input type='text' name='maker' value='' class='input' required></input>"
				+ "</td></tr><tr><td>"
				+ "<h3>condition</h3></td><td><input type='text' name='condition' value='' class='input' required></input>"
				+ "</td></tr><tr><td>"
				+ "<h3>discount</h3></td><td><input type='text' name='discount' value='' class='input' required></input>"
				+ "</td></tr><tr><td>"
				+ "<input type='submit' class='btnbuy' value='Add/Update' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>"
				+ "</td></tr><tr><td></td><td>"
				+ "</form>" + "</div></div></div>");
		
		utility.printHtml("Footer.html");
	}

}
