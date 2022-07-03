package Onlinehandel.entities;

import java.util.HashSet;
import java.util.Set;

import Onlinehandel.provided.*;

/**
 * An order within the Onlinehandel.<br>
 * <br>
 * 
 * An order holds information on the costumer placing the order, the items
 * ordered and the status of the order which captures collection and delivery
 * date and time.<br>
 * <br>
 * 
 * The usual life cycle is
 * <ul>
 * <li>create an order with id, costumer and at least one item</li>
 * <li>add items</li>
 * <li>collect</li>
 * <li>deliver</li>
 * </ul>
 *
 */
public abstract class Order{

	private DateTime collected;
	private Costumer costumer;
	private DateTime delivered;
	private Set<Item> goods;
	private long id;


	public Order(long id, Costumer customer, Iterable<Item> items) {
		this.costumer = customer;
		if(items !=null){
			for(Item i:items){
				if(i!=null){
					goods = new HashSet<>();
					goods.add(i);
				}
			}
		}
		if(id>0) {
			this.id = id;
		}
	}

	public Order(Order orig){
		this.collected= new DateTime(orig.collected);
		this.costumer = new Costumer(orig.costumer);
		this.delivered =new DateTime(orig.delivered);
		this.goods =orig.goods;
		this.id=orig.id;
	}

	public boolean isCollected(){
		return collected!=null;
	}
	public boolean isDelivered(){
		return delivered!=null;
	}
	private String ensureNotNullNonEmpty(String str){
		if(str != null&&!str.isEmpty()){
			return str;
		}
		throw new IllegalArgumentException();
	}


	/**
	 * creates a string representation of this delivery.<br>
	 * 
	 * @ProgrammingProblem.Hint provided
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%d " + "[%scollected, %sdelivered] (EUR %.2f)\n" + "%s", //
				id, isCollected() ? "" : "not ", isDelivered() ? "" : "not ", getTotal() / 100.,
				goods == null ? "no stock" : goods);
	}

}
