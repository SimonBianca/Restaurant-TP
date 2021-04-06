package bll;

public class BaseProduct extends MenuItem{

	
	public BaseProduct(String name, double price) {
		super(name,price);
	}

	@Override
	public double computePrice() {
		return BaseProduct.super.getPrice();
	}
	

	public void changePrice(double newPrice) {
		super.setPrice(newPrice);
	}
	
	
	
	
	
}
