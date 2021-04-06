package bll;

import java.util.List;

public interface IRestaurantProcessing {
	/**
	 * @pre (name != null) &amp;&amp; (price &gt; 0.0)
	 * @param name is the base product name
	 * @param price of the base product
	 * @return true if the base product hasn't already exists
	 */
	public boolean addBaseProduct(String name, double price);
	/**
	 * @pre (name!=null)  &amp;&amp; (baseProducts.size() &gt; 0)
	 * @param name is the composite product name
	 * @param baseProducts is a list of base products which are included in the composite product
	 * @return true if composite product hasn't already exists and if all of the base products are in the menu
	 */
	public boolean addCompositeProduct(String name, List<String> baseProducts);
	/**
	 * @pre productName!=null
	 * @param productName is the name of the deleted base product
	 * @return true if the base product is in the menu list
	 */
	public boolean deleteBaseProduct(String productName);
	/**
	 * @pre productName!=null
	 * @param productName is the name of the deleted composite product
	 * @return true if the composite product was found in the menu 
	 */
	public boolean deleteCompositeProduct(String productName);
	/**
	 * @pre (tableName!=null)  &amp;&amp; (orderedProducts.size() &gt; 0)
	 * @param tableName is the name of the table where an order was taken
	 * @param orderedProducts is a list of the ordered products
	 * @return true if no order was taken at that table before and if the ordered products exist
	 */
	public boolean createOrder(String tableName,List<String> orderedProducts);
	/**
	 * @pre tableName!=null
	 * @param tableName is the name of the table whose order price is calculate
	 * @return the total order of the order
	 * @post the return value should be &gt; 0
	 */
	public double computeOrderPrice(String tableName);
	/**
	 * @pre tableName!=null
	 * @param tableName the name of the table where a bill is generated
	 * @return true if the table take an order before
	 */
	public boolean generateBill(String tableName);
	/**
	 * @pre (name!=null)  &amp;&amp; (price &gt; 0)
	 * @param name represents the product name whose price is trying to be changed
	 * @param price the new price of the product
	 * @return true if the product exists
	 */
	public boolean changePrice(String name, double price);
	/**
	 * @pre (name!=null)  &amp;&amp; (toAdd!=null)
	 * @param name is the name of the composite product where a base product is added
	 * @param toAdd is the name of the base product 
	 * @return true if both base product and composite product exists in the menu list
	 * @post the composite product price, must have changed 
	 */
	public boolean addBPToCP(String name,String toAdd);
	/**
	 * @pre (name!=null)  &amp;&amp; (toDelete!=null)
	 * @param name is the name of the composite product from where is trying to delete a base product
	 * @param toDelete is the name of the base product which must be deleted
	 * @return true if both base product and composite product exist in menu
	 */
	public boolean deleteBPFromCP(String name, String toDelete);
	
	

}
