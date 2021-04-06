package presentation;

import java.util.List;
import java.util.Map.Entry;

import bll.BaseProduct;
import bll.IRestaurantProcessing;
import bll.MenuItem;
import bll.Order;
import bll.Restaurant;
import dao.RestaurantSerializator;

public class RestaurantLogicController implements IRestaurantProcessing{
	
	private Restaurant restaurant;
	private RestaurantSerializator restaurantSerializator;
	
	public RestaurantLogicController(String fileName) {
		restaurantSerializator=new RestaurantSerializator(fileName);
		restaurant=restaurantSerializator.deserializatorRestaurant();
	}
	
	public String[][] extractBaseProductsData(){
		String[][] data = new String[restaurant.getBaseProductsList().size()][2];
		int index=0;
		for(BaseProduct item:restaurant.getBaseProductsList()) {
			data[index][0]=item.getName();
			String price=String.valueOf(item.getPrice());
			data[index][1]=price;
			index++;
		}
		return data;
	}
	
	public String[][] extractCompositeProductsData(){
		String[][] data=new String[restaurant.getMenu().size()][3];
		int index=0;
		for(MenuItem item:restaurant.getMenu()) {
			data[index][0]=item.getName();
			String listOfBaseProducts="";
			for(BaseProduct item1:item.getCompositeProduct().getBaseProducts()) {
				listOfBaseProducts=listOfBaseProducts+item1.getName()+",";
			}
			listOfBaseProducts=listOfBaseProducts.substring(0, listOfBaseProducts.length()-1);
			data[index][1]=listOfBaseProducts;
			String price=String.valueOf(item.getPrice());
			data[index][2]=price;
			index++;
		}
		return data;
	}
	public String[][] extractOrdersData(){
		String[][] data=new String[restaurant.getOrders().size()][5];
		int index=0;
		for(Entry<Order, List<MenuItem>> item: restaurant.getOrders().entrySet()) {
			String orderId=String.valueOf(item.getKey().getOrderId());
			data[index][0]=orderId;
			String orderDate=String.valueOf(item.getKey().getDate());
			data[index][1]=orderDate;
			data[index][2]=item.getKey().getTableName();
			List<MenuItem> orderedProducts=item.getValue();
			String listOfOrderedProducts="";
			for(MenuItem item1:orderedProducts) {
				listOfOrderedProducts=listOfOrderedProducts+item1.getName();
				listOfOrderedProducts+=",";
			}
			listOfOrderedProducts=listOfOrderedProducts.substring(0, listOfOrderedProducts.length()-1);
			data[index][3]=listOfOrderedProducts;
			String totalPrice=String.valueOf(item.getKey().getOrderTotalPrice());
			data[index][4]=totalPrice;
			index++;
		}
		return data;
	}
	

	@Override
	public boolean deleteBaseProduct(String itemName) {
		if(itemName!=null) {
			BaseProduct toFind=restaurant.findBaseProductByName(itemName);
			if(toFind!=null) {
				if(restaurant.deleteBaseProduct(itemName)) {
					restaurantSerializator.serializatorRestaurant(restaurant);
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean deleteCompositeProduct(String itemName) {
		if(itemName!=null) {
			MenuItem toFind=restaurant.findCompositeProductByName(itemName);
			if(toFind!=null) {
				if(restaurant.deleteCompositeProduct(itemName)) {
					restaurantSerializator.serializatorRestaurant(restaurant);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public double computeOrderPrice(String tableName) {
		double totalPrice=0;
		if(tableName!=null) {
			totalPrice=restaurant.computeOrderPrice(tableName);
			if(totalPrice>0) {
				Entry<Order,List<MenuItem>> order=restaurant.findOrderByTableName(tableName);
				order.getKey().setOrderTotalPrice(totalPrice);
				restaurantSerializator.serializatorRestaurant(restaurant);
			}
		}
		return totalPrice;
	}

	@Override
	public boolean generateBill(String tableName) {
		if(tableName!=null) {
			if(restaurant.generateBill(tableName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addBaseProduct(String name, double price) {
		if(name!=null && price>0) {
			if(restaurant.addBaseProduct(name, price)) {
				restaurantSerializator.serializatorRestaurant(restaurant);
				return true;
				}
			}
		return false;
	}
	@Override
	public boolean addCompositeProduct(String name, List<String> baseProducts) {
		if(name!=null && (baseProducts.size()>0)) {
			if(restaurant.addCompositeProduct(name, baseProducts)) {
				restaurantSerializator.serializatorRestaurant(restaurant);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean createOrder(String tableName,List<String> orderedProducts) {
		if(tableName!=null && (orderedProducts.size()>0)) {
			if(restaurant.createOrder(tableName, orderedProducts)) {
				restaurantSerializator.serializatorRestaurant(restaurant);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean changePrice(String name, double price) {
		if(name!=null && (price>0)) {
			if(restaurant.changePrice(name, price)) {
				restaurantSerializator.serializatorRestaurant(restaurant);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addBPToCP(String name, String toAdd) {
		if(name!=null && toAdd!=null) {
			if(restaurant.addBPToCP(name, toAdd)) {
				restaurantSerializator.serializatorRestaurant(restaurant);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteBPFromCP(String name, String toDelete) {
		if(name!=null && toDelete!=null) {
			if(restaurant.deleteBPFromCP(name, toDelete)) {
				restaurantSerializator.serializatorRestaurant(restaurant);
				return true;
			}
		}
		return false;
	}


}
