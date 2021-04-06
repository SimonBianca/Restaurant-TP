package bll;

import java.io.Serializable;

public class MenuItem implements Serializable{
	
	private String name;
	private double price;
	private CompositeProduct compositeProduct;
	
	public MenuItem(String name,double price) {
		this.name=name;
		this.price=price;
	}
	
	public MenuItem(String name) {
		this.name=name;
	}
	
	public MenuItem(CompositeProduct compositeProduct) {
		this.compositeProduct = compositeProduct;
		this.name=compositeProduct.getName();
		this.price=compositeProduct.getPrice();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double computePrice() {
		double finalPrice = 0;
		for(BaseProduct item:compositeProduct.getBaseProducts()) {
			finalPrice+=item.getPrice();
		}
		return finalPrice;
	}

	public CompositeProduct getCompositeProduct() {
		return compositeProduct;
	}

	public void setCompositeProduct(CompositeProduct compositeProduct) {
		this.compositeProduct = compositeProduct;
	}

}
