import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;



@WebServlet("/Phone")


/* 
	Console class contains class variables name,price,image,retailer,condition,discount and Accessories Hashmap.

	Console class constructor with Arguments name,price,image,retailer,condition,discount and Accessories .
	  
	Accessory class contains getters and setters for name,price,image,retailer,condition,discount and Accessories .

*/

public class Phone extends HttpServlet{
	private String id;
	private String name;
	private double price;
	private String image;
	private String maker;
	private String condition;
	private double discount;
	HashMap<String,String> accessories;
	public Phone(String name, double price, String image, String maker,String condition,double discount){
		this.name=name;
		this.price=price;
		this.image=image;
		this.maker = maker;
		this.condition=condition;
		this.discount = discount;
        this.accessories=new HashMap<String,String>();
        //System.out.println("11111111111111111111111111111111111111111111111111");
	}
	
    HashMap<String,String> getAccessories() {
		return accessories;
		}

	public Phone(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRetailer() {
		return maker;
	}
	public void setRetailer(String retailer) {
		this.maker = retailer;
	}

	public void setAccessories( HashMap<String,String> accessories) {
		this.accessories = accessories;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
