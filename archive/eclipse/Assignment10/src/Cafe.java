
public class Cafe {

	private double coffeePrice;
	
	private double teaPrice;
	
	private double donutPrice;
	
	private int coffeeTotQty;
	
	private int teaTotQty;
	
	private int donutTotQty;
	
	private double discount;
	
	private double subtotal;
	
	private double discountedPrice;
	
	private double total;
	
	
	public Cafe() { }
	
	public void setCoffeePrice(double coffeePrice) {
		if(coffeePrice>=0)
		this.coffeePrice=coffeePrice;
	}
	
	public void setTeaPrice(double teaPrice) {
		if(teaPrice>=0)
		this.teaPrice=teaPrice;
	}
	
	public void setDonutPrice(double donutPrice) {
		if(donutPrice>=0)
		this.donutPrice=donutPrice;
	}
	
	public void setCoffeeTotQty(int coffeeTotQty) {
		if(coffeeTotQty>=0)
		this.coffeeTotQty=coffeeTotQty;
	}
	
	public void setTeaTotQty(int teaTotQty) {
		if(teaTotQty>=0)
		this.teaTotQty=teaTotQty;
	}
		
	public void setDonutTotQty(int donutTotQty) {
		if(donutTotQty>=0)
		this.donutTotQty=donutTotQty;
	}
	
	public void setDiscount(double discount) {
		if(discount>=0)
		this.discount=discount;
	}
	public double getCoffeePrice() {
		return coffeePrice;
	}
	
	public double getTeaPrice() {
		return teaPrice;
	}
	
	public double getDonutPrice() {
		return donutPrice;
	}
	
	public int getCoffeeTotQty() {
		return coffeeTotQty;
	}
	
	public int getTeaTotQty() {
		return teaTotQty;
	}
	
	public int getdonutTotQty() {
		return donutTotQty;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public double getSubtotal() {
		return subtotal;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}
	
	public double getTotal() {
		return total;
	}
	
	private double calculateSubTotal(int coffeeQty,  int  teaQty,int donutQty) {
		
		subtotal = (coffeeQty*coffeePrice)+( teaQty*teaPrice) + (donutQty*donutPrice);
		
		
		return subtotal;
	}
	
	private double calculateTotal(int coffeeQty , int teaQty , int donutQty) {
		
		calculateSubTotal(coffeeQty, teaQty, donutQty);
		
		discountedPrice= subtotal*(discount/100);
		
		total = subtotal*( 1 - (discount/100) ) ;
		
		
		return total;
	}
	
	public double order(int coffeeQty, int teaQty, int donutQty) {
		
		if (this.coffeeTotQty > coffeeQty && this.teaTotQty>teaQty && this.donutTotQty>donutQty) {
			this.coffeeTotQty-=coffeeQty; this.teaTotQty-=teaQty; this.donutTotQty-=donutQty;
			
			 calculateTotal( coffeeQty ,  teaQty ,  donutQty);
		
			 display( coffeeQty,  teaQty,  donutQty);
			 
			 return total;
		}
		
		else {
			System.out.println("Error: no enough cup and/or donuts");
			
			System.exit(0);
	}
		return 0;
	}
	
	public void display(int coffeeQty, int teaQty, int donutQty) {
		
		System.out.println("------------------------------------------------------------------\n" + 
				           "Item                       Quantity                       Price   \n" + 
				           "------------------------------------------------------------------\n" + 
				           "Coffee                       "+coffeeQty+"                         "+(coffeeQty*coffeePrice)+"   \n" + 
				           "Tea                           "+teaQty+"                         "+(teaQty*teaPrice)+"   \n" + 
				           "Donuts                        "+donutQty+"                         "+(donutQty*donutPrice)+"   \n" + 
				           "------------------------------------------------------------------\n" + 
				           "Sub total                                                  "+subtotal+"   \n" + 
				           "Discount                   "+discount+"                         "+discountedPrice+"   \n" + 
				           "------------------------------------------------------------------\n" + 
				           "Total                                                     "+total+"     ");
	}
	
	
	
	
	
	
}

