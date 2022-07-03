package Onlinehandel.entities;

import java.util.Collection;
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
public abstract class Order implements Comparable<Order>{

	private DateTime collected;
	private Costumer costumer;
	private DateTime delivered;
	private Set<Item> goods;
	private long id;


	public Order(long id, Costumer customer, Iterable<Item> items) {
		if(customer == null){
			throw new IllegalArgumentException();
		}else {
			this.costumer = customer;
		}

		if(items !=null){
			for(Item i:items){
				if(i!=null){
					goods = new HashSet<>();
					goods.add(i);
				}else {
					throw new IllegalArgumentException();
				}
			}
		}
		if(id>0) {
			this.id = id;
		}else{
			throw new IllegalArgumentException();
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

	public boolean addItems(Iterable<Item> items){
		if(!isCollected()&&!isCollected()){
			if(items!=null) {
				goods = new HashSet<>();
				goods.addAll((Collection<? extends Item>) items);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean addItems(Item item){
		if(!isCollected()&&!isCollected()){
			if(item!=null) {
				goods = new HashSet<>();
				goods.add(item);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean collect(DateTime toc){
		if(!isCollected()){
			collected = new DateTime(toc);
			return true;
		}
		return false;
	}

	public int compareTo(Order arg0){
		return Long.compare(this.id,arg0.id);
	}

	public boolean deliver(DateTime tod){
		if(!isDelivered()&&isCollected()){
			delivered = new DateTime(tod);
			return true;
		}
		return false;
	}

	public Costumer getCostumer(){
		return new Costumer(costumer);
	}

	public Set<Item> getItems(){
		return goods;
	}

	abstract int getTotal();


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
