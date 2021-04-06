package bll;

import java.util.List;

public class CompositeProduct extends MenuItem{
	
	private List<BaseProduct> baseProducts;
	
	public CompositeProduct(String name, List<BaseProduct> baseProducts) {
		super(name);
		this.baseProducts=baseProducts;
		super.setPrice(computePrice());
	}

	@Override
	public double computePrice() {
		double finalPrice = 0;
		for(BaseProduct item:baseProducts) {
			finalPrice+=item.getPrice();
		}
		return finalPrice;
	}


	public List<BaseProduct> getBaseProducts() {
		return baseProducts;
	}

	public void setBaseProducts(List<BaseProduct> baseProducts) {
		this.baseProducts = baseProducts;
	}
	
	public void addBaseProduct(BaseProduct baseProduct) {
		for(BaseProduct item:baseProducts) {
			if(item.equals(baseProduct)) {
				return;
			}
		}
		baseProducts.add(baseProduct);
		super.setPrice(computePrice());
	}
	public void deleteBaseProduct(BaseProduct baseProduct) {
		baseProducts.remove(baseProduct);
		super.setPrice(computePrice());
	}
	
	
	
	
}
