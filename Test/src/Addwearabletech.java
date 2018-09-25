import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addwearabletech")

public class Addwearabletech extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* User Information(username,password,usertype) is obtained from HttpServletRequest,
		Based on the Type of user(customer,retailer,manager) respective hashmap is called and the username and 
		password are validated and added to session variable and display Login Function is called */

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String image = request.getParameter("image");
		String maker = request.getParameter("maker");
		String condition = request.getParameter("condition");
		String discount = request.getParameter("discount");
		boolean update = false;
		boolean add = true;
		HashMap<String, WearableTech> hm=new HashMap<String, WearableTech>();
		WearableTech wearabletech = new WearableTech();
		wearabletech.setId(id);
		wearabletech.setName(name);
		wearabletech.setPrice(Double.parseDouble(price));
		wearabletech.setImage(image);
		wearabletech.setRetailer(maker);
		wearabletech.setCondition(condition);
		wearabletech.setDiscount(Double.parseDouble(discount));
		hm.putAll(SaxParserDataStore.wearabletechs);
		Iterator keys = hm.keySet().iterator();
		while(keys.hasNext()){
			String key = (String)keys.next();
			if(id.equals(key)){
				System.out.println("This product has been updated successfully!");
				update = true;
				add = false;
			}
		}
		SaxParserDataStore.wearabletechs.put(wearabletech.getId(), wearabletech);
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

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		displayLogin(request, response, pw, false, false);
	}

	
	/*  Login Screen is Displayed, Registered User specifies credentials and logins into the Game Speed Application. */
	protected void displayLogin(HttpServletRequest request, HttpServletResponse response, PrintWriter pw, boolean done, boolean update)
			throws ServletException, IOException {

		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		pw.print("<div class='post' style='float: none; width: 100%'>");
		pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Add/Update</a></h2>"
				+ "<div class='entry'>"
				+ "<div style='width:400px; margin:25px; margin-left: auto;margin-right: auto;'>");
		if (done)
			pw.print("<h4 style='color:red'>Add success!</h4>");
		if (update == true) {
			pw.print("<h4 style='color:red'>Update success!</h4>");
		}
//		HttpSession session = request.getSession(true);
//		if(session.getAttribute("login_msg")!=null){			
//			pw.print("<h4 style='color:red'>"+session.getAttribute("login_msg")+"</h4>");
//			session.removeAttribute("login_msg");
//		}
		
		pw.print("<form method='post' action='Addwearabletech'>"
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
