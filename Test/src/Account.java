import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;

@WebServlet("/Account")

public class Account extends HttpServlet {
	private String error_msg;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		displayAccount(request, response);
	}

	/* Display Account Details of the Customer (Name and Usertype) */

	protected void displayAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);

		try {
			response.setContentType("text/html");
			if (!utility.isLoggedin()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("login_msg", "Please Login to add items to cart");
				response.sendRedirect("Login");
				return;
			}
			HttpSession session = request.getSession();
			// HttpSession session=request.getSession();
			// String username = session.getAttribute("userName").toString();
			String userType = session.getAttribute("usertype").toString();
			utility.printHtml("Header.html");
			utility.printHtml("LeftNavigationBar.html");
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Account</a>");
			pw.print("</h2><div class='entry'>");
			User user = utility.getUser();
			pw.print("<table class='gridtable'>");
			pw.print("<tr>");
			pw.print("<td> User Name: </td>");
			pw.print("<td>" + user.getName() + "</td>");
			pw.print("</tr>");
			pw.print("<tr>");
			pw.print("<td> User Type: </td>");
			pw.print("<td>" + user.getUsertype() + "</td>");
			pw.print("</tr>");

			if (userType.equalsIgnoreCase("customer")) {
				// String username = session.getAttribute("userName").toString();//zhuyi
				// xinjiarude
				HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
				String TOMCAT_HOME = System.getProperty("catalina.home");
				try {
					FileInputStream fileInputStream = new FileInputStream(
							new File("\\Users\\sanchuanjiang\\Desktop\\PaymentDetails.txt"));
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					orderPayments = (HashMap) objectInputStream.readObject();
				} catch (Exception e) {

				}
			    int size = 0;
				//boolean flag = false;
				for (Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()) {
					for (OrderPayment od : entry.getValue()) {
						// pw.print("<input type='text' name='userName' value='"+od.getUserName()+"'>");
						// pw.print("<td><input type='radio' name='oigetUserName'
						// value='"+od.getUserName()+"'></td>");
						if (od.getUserName() != null && od.getUserName().equals(user.getName())) {// 原来是user.getName()
							// pw.print("<input type='text' name='userName' value='"+size+"'><br>");
							 size = size + 1;
							
						}
					}
				}
				//pw.print("<input type='text' name='userName' value='" + flag + "'><br>");
				if (size > 0) {
					// pw.print("<input type='text' name='userName' value='" + + "'><br>");
					pw.print("<tr><td></td>");
					pw.print("<td>OrderId:</td>");
					pw.print("<td>UserName:</td>");
					pw.print("<td>productOrdered:</td>");
					pw.print("<td>productPrice:</td></tr>");
					for (Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()) {
						// System.out.println(user.getName());//
						// pw.print("<td><input type='radio' name='userName'
						// value='"+user.getName()+"'></td>");
						for (OrderPayment oi : entry.getValue()) {
							// pw.print("<td><input type='radio' name='oigetUserName'
							// value='"+oi.getUserName()+"'></td>");
							// System.out.println(oi.getUserName());//
							// System.out.println(user.getName());//

							if (oi.getUserName() != null && oi.getUserName().equals(user.getName())) {
								pw.print("<form method='get' action='ViewOrder'>");
								pw.print("<tr>");
								pw.print("<td><input type='radio' name='orderName' value='" + oi.getOrderName()
										+ "'></td>");
								pw.print("<td>" + oi.getOrderId() + ".</td><td>" + oi.getUserName() + "</td><td>"
										+ oi.getOrderName() + "</td><td>Price: " + oi.getOrderPrice() + "</td>");
								pw.print("<td><input type='hidden' name='orderId' value='" + oi.getOrderId()
										+ "'></td>");
								pw.print(
										"<td><input type='submit' name='Order' value='CancelOrder' class='btnbuy'></td>");
								pw.print("</tr>");
								pw.print("</form>");

							}
						}

					}

					pw.print("</table>");
				} else {
					pw.print("<h4 style='color:red'>You have not placed any order with this order id</h4>");
				}

				pw.print("</table>");
				pw.print("</h2></div></div></div>");
				utility.printHtml("Footer.html");
			}

			// salesman
			if (userType.equalsIgnoreCase("salesman")) {
				pw.print("<li><form method='get' action='CreateAccount'>"
						+ "<input type='hidden' name='name' value='abe'>"
						+ "<input type='submit' value='Creat Account' class='btnreview'></input></form></li>");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
