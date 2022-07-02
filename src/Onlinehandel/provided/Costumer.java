package Onlinehandel.provided;

/**
 * A Costumer in the Onlinehandel.<br>
 * <br>
 * 
 * Skeleton implementation - no argument checking.
 *
 */
public class Costumer {
	private String name;
	private String addres;
	private boolean isPremium;

	public Costumer(String name, String addres, boolean isPremium) {
		super();
		this.name = name;
		this.addres = addres;
		this.isPremium = isPremium;

	}

	public Costumer(Costumer orig) {
		this.name = orig.name;
		this.addres = orig.addres;
		this.isPremium = orig.isPremium;
	}

	public boolean isPremium() {
		return isPremium;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", name, addres, isPremium);
	}

}
