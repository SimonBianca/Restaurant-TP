package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bll.BaseProduct;
import bll.MenuItem;
import bll.Restaurant;

public class RestaurantSerializator implements Serializable{
	
	private String fileName;
	
	public RestaurantSerializator(String fileName) {
		this.fileName=fileName;
	}
	
	public void serializatorRestaurant(Restaurant restaurant) {
		try {
			FileOutputStream file=new FileOutputStream(fileName);
			ObjectOutputStream obj=new ObjectOutputStream(file);
			obj.writeObject(restaurant);
			obj.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Restaurant deserializatorRestaurant() {
		Restaurant newRestaurant=null;
		try {
			FileInputStream file=new FileInputStream(fileName);
			ObjectInputStream obj=new ObjectInputStream(file);
			newRestaurant=(Restaurant) obj.readObject();
			obj.close();
			file.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newRestaurant;
	}

}
