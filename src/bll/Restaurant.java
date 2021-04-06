package bll;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Restaurant implements Serializable,IRestaurantProcessing{
	
	List<MenuItem> menu;
	List<BaseProduct> baseProductsList;
	private HashMap<Order,List<MenuItem>> orders;
	
	public Restaurant() {
		this.menu=new ArrayList<MenuItem>();
		this.orders= new HashMap<Order,List<MenuItem>>();
		this.baseProductsList=new ArrayList<BaseProduct>();
	}
	
	public MenuItem findCompositeProductByName(String name) {
		for(MenuItem item:menu) {
			if(item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}
	public BaseProduct findBaseProductByName(String name) {
		for(BaseProduct item:baseProductsList) {
			if(item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}
	
	@Override
	public boolean changePrice(String name,double price) {
		assert name!=null;
		assert price>0;
		BaseProduct product=findBaseProductByName(name);
		if(product!=null) {
			for(BaseProduct item:baseProductsList) {
				if(item.getName().equalsIgnoreCase(name)) {
					item.setPrice(price);
				}
			}
			for(MenuItem item1:menu) {
				if(item1.getCompositeProduct().getBaseProducts().contains(product)) {
					item1.setPrice(item1.computePrice());
				}
			}
		return true;
		}
		return false;
	}

	@Override
	public boolean addBaseProduct(String name, double price) {
		assert name!=null;
		assert price>0;
		BaseProduct product=new BaseProduct(name,price);
		if(baseProductsList.size()>0) {
			if(baseProductsList.contains(product)) {
				return false;
			}
			else {
				for(BaseProduct item:baseProductsList) {
					if(item.getName().equalsIgnoreCase(product.getName()) && (item.getPrice()!=product.getPrice())) {
						return false;
					}
				}
			}
		}
		baseProductsList.add(product);
		return true;
	}
	
	@Override
	public boolean addCompositeProduct(String name, List<String> baseProducts) {
		assert name!=null;
		assert baseProducts.size()>0;
		List<BaseProduct> list=new ArrayList<BaseProduct>();
		if(menu.contains(findCompositeProductByName(name))) {
			return false;
		}
		for(String item:baseProducts) {
			if(baseProductsList.contains(findBaseProductByName(item))) {
				list.add(findBaseProductByName(item));
					continue;
				}
			else {
				return false;
			}
		}
		CompositeProduct product=new CompositeProduct(name,list);
		MenuItem menuItem=new MenuItem(product);
		menu.add(menuItem);
		return true;
	}
	@Override
	public boolean deleteBaseProduct(String productName) {
		assert productName!=null;
		BaseProduct product=findBaseProductByName(productName);
		for(BaseProduct item: baseProductsList) {
			if(item.getName().equals(productName)) {
				for(MenuItem item1:menu) {
					if(item1.getCompositeProduct().getBaseProducts().contains(product)) {
						deleteBPFromCP(item1.getName(),productName);
					}
				}
				baseProductsList.remove(item);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCompositeProduct(String productName) {
		assert productName!=null;
		for(MenuItem item:menu) {
			if(item.getName().equalsIgnoreCase(productName)) {
				menu.remove(item);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean createOrder(String tableName,List<String> orderedProducts) {
		assert tableName!=null;
		assert orderedProducts.size()>0;
		for(Entry<Order, List<MenuItem>> item: orders.entrySet()) {
			if(item.getKey().getTableName().equalsIgnoreCase(tableName)) {
				return false;
			}
		}
		List<MenuItem> orderedList=new ArrayList<MenuItem>();
		for(String item1:orderedProducts) {
			MenuItem product=findCompositeProductByName(item1);
			if(product!=null) {
				orderedList.add(product);
			}
			else {
				return false;
			}
		}
		Order order=new Order(tableName);
		orders.put(order, orderedList);
		if(wellFormed(order)) {
			return true;
		}
		return false;
	}
	
	public boolean wellFormed(Order order) {
		if(orders.get(order).size()>0) {
			System.out.println(orders.get(order).size());
			return true;
		}
		return false;
	}
	public Entry<Order,List <MenuItem>> findOrderByTableName(String tableName){
		for(Entry<Order,List<MenuItem>> item:orders.entrySet()) {
			if(item.getKey().getTableName().equalsIgnoreCase(tableName)) {
				return item;
			}
		}
		return null;
	}
	@Override
	public double computeOrderPrice(String tableName) {
		assert tableName!=null;
		assert tableName!=null;
		Entry<Order,List<MenuItem>> order=findOrderByTableName(tableName);
		double totalPrice=0;
		if(order!=null) {
			List<MenuItem> products=order.getValue();
			for(MenuItem item:products) {
				totalPrice+=item.getPrice();
			}
		}
		assert totalPrice>0;
		return totalPrice;
	}

	@Override
	public boolean generateBill(String tableName) {
		assert tableName!=null;
		Entry<Order,List<MenuItem>> order=findOrderByTableName(tableName);
		if(order!=null) {
			String fileName="BillFor"+tableName+".txt";
			try {
				PrintWriter newFile=new PrintWriter(fileName);
				newFile.print(" ");
				newFile.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			writeData(fileName,order);
			return true;
		}
		return false;
	}
	public void writeData(String fileName,Entry<Order,List<MenuItem>> order) {
		try {
			FileWriter file=new FileWriter(fileName,true);
			file.append(" Bill for "+order.getKey().getTableName()+"\n\n");
			file.append("Ordered menu items:\n");
			for(MenuItem listOfProducts: order.getValue()) {
				file.append(listOfProducts.getName()+"  "+listOfProducts.getPrice()+"\n");
			}
			file.append("\nTotal price:");
			String totalOrder=String.valueOf(order.getKey().getOrderTotalPrice());
			file.append(totalOrder);
			file.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addBPToCP(String name, String toAdd) {
		assert name!=null;
		assert toAdd!=null;
		MenuItem menuItem=findCompositeProductByName(name);
		BaseProduct baseProduct=findBaseProductByName(toAdd);
		if(menuItem!=null && baseProduct!=null) {
				menuItem.getCompositeProduct().getBaseProducts().add(baseProduct);
				menuItem.setPrice(menuItem.computePrice());
				return true;
		}
		return false;
	}

	@Override
	public boolean deleteBPFromCP(String name, String toDelete) {
		assert name!=null;
		assert toDelete!=null;
		MenuItem menuItem=findCompositeProductByName(name);
		BaseProduct baseProduct=findBaseProductByName(toDelete);
		if(menuItem!=null && baseProduct!=null) {
			while(menuItem.getCompositeProduct().getBaseProducts().contains(baseProduct)) {
				menuItem.getCompositeProduct().getBaseProducts().remove(baseProduct);
				menuItem.setPrice(menuItem.computePrice());
			}
			return true;
		}
		return false;
	}
	public List<BaseProduct> getBaseProductsList() {
		return baseProductsList;
	}


	public void setBaseProductsList(List<BaseProduct> baseProductsList) {
		this.baseProductsList = baseProductsList;
	}


	public void setMenu(List<MenuItem> menu) {
		this.menu = menu;
	}


	public List<MenuItem> getMenu() {
		return menu;
	}

	public HashMap<Order, List<MenuItem>> getOrders() {
		return orders;
	}


	public void setOrders(HashMap<Order, List<MenuItem>> orders) {
		this.orders = orders;
	}
	

}
