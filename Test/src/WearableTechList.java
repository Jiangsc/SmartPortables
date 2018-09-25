import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WearableTechList")

public class WearableTechList extends HttpServlet {

	/* Games Page Displays all the Games and their Information in Game Speed */

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* Checks the Games type whether it is electronicArts or activision or takeTwoInteractive */
				
		String name = null;
		String CategoryName = request.getParameter("maker");
		HashMap<String, WearableTech> hm = new HashMap<String, WearableTech>();
		
		if(CategoryName==null)
		{
			hm.putAll(SaxParserDataStore.wearabletechs);
			name = "";
		}
		else
		{
		  if(CategoryName.equals("FitnessWatches"))
		  {
			for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				if(entry.getValue().getRetailer().equals("FitnessWatches"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "FitnessWatches";
		  }
		  else if(CategoryName.equals("SmartWatches"))
		  {
			for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				if(entry.getValue().getRetailer().equals("SmartWatches"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}	
			name = "SmartWatches";
		  }
		  else if(CategoryName.equals("Headphones"))
		  {
			for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				if(entry.getValue().getRetailer().equals("Headphones"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "Headphones";
		  }
		  else if(CategoryName.equals("VirtualReality"))
		  {
			for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				if(entry.getValue().getRetailer().equals("VirtualReality"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "VirtualReality";
		  }
		  else if(CategoryName.equals("PetTracker"))
		  {
			for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
				{
				if(entry.getValue().getRetailer().equals("PetTracker"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "PetTracker";
		  }
		}

		/* Header, Left Navigation Bar are Printed.

		All the Games and Games information are dispalyed in the Content Section

		and then Footer is Printed*/
		
		Utilities utility = new Utilities(request,pw);
		HttpSession session=request.getSession();
		String userType = session.getAttribute("usertype").toString();
		
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" wearabletechs</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, WearableTech> entry : hm.entrySet()){
			WearableTech wearabletech = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+wearabletech.getName()+"</h3>");
			pw.print("<strong>"+ "$" + wearabletech.getPrice() + "</strong><ul>");
			pw.print("<li id='item'><img src='images/wearabletechs/"+wearabletech.getImage()+"' alt='' /></li>");
			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wearabletechs'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wearabletechs'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wearabletechs'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");

			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}
		if(userType.equalsIgnoreCase("storemanager")) {
			pw.print("<li><form method='get' action='Addwearabletech'>"+"<input type='hidden' name='name' value='abe'>"+
		
				"<input type='hidden' name='type' value='wearabletech'>"+
				"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
				"<input type='hidden' name='access' value=''>"+
			    "<input type='submit' value='Add/Update' class='btnreview'></input></form></li>");
			pw.print("<li><form method='get' action='Delwearabletech'>"+"<input type='hidden' name='name' value='abe'>"+
					
				"<input type='hidden' name='type' value='wearabletech'>"+
				"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
				"<input type='hidden' name='access' value=''>"+
			    "<input type='submit' value='Delete' class='btnreview'></input></form></li>");
			
		}
		pw.print("</table></div></div></div>");		
		utility.printHtml("Footer.html");
		
	}

}
