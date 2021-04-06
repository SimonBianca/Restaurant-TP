package bll;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	private long orderId;
	private Date date;
	private String tableName;
	private double orderTotalPrice;
	
	
	public Order(String tableName) {
		this.date = new Date();
		this.tableName = tableName;
		this.orderTotalPrice=0;
		this.orderId = hashCode();
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTableName() {
		return tableName;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}


	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	@Override
	public int hashCode() {
		int hash=7;
		hash=11*hash+(int)orderId;
		hash=3*hash+(date == null ? 0 : date.hashCode());
		hash=13*hash+(tableName == null ? 0 : tableName.hashCode());
		hash=hash%100000;
		if(hash<0) {
			hash=hash*(-1);
		}
		return hash;
	}
	
	
	

}
