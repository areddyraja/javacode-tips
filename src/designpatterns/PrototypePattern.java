package designpatterns;

public class PrototypePattern {
	public static void main(String[] args) {

		/* Cheese cake preparation */
		CheeseCake cake = new CheeseCake();
		cake.addSugar("100g");
		cake.addButter("200g");
		cake.addCheese("Acapella");
		System.out.println("Cake = " + cake.toString());

		/* Order with custom name */
		CheeseCake cake1 = (CheeseCake) cake.prepareCake();
		cake1.setName("Bastien");
		System.out.println("Cake1 = " + cake1.toString());

		/* Order with custom name and customized cheese */
		CheeseCake cake2 = (CheeseCake) cake.prepareCake();
		cake2.addCheese("Extra Cheese");
		cake2.setName("Adams");
		System.out.println("Cake3 = " + cake2.toString());

	}
}

interface Cake extends Cloneable {

	public Cake prepareCake();
}

class CheeseCake implements Cake {

	private String sugar;
	private String butter;
	private String cheese;
	private String name;

	public Cake prepareCake() {
		Cake cake = null;
		try {
			cake = (Cake) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cake;
	}

	void addSugar(String sugar) {
		this.sugar = sugar;
	}

	void addButter(String butter) {
		this.butter = butter;
	}

	public void addCheese(String cheese) {
		this.cheese = cheese;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sugar:" + sugar + ", Butter:" + butter + ", Name:" + name + ", Cheese:" + cheese;
	}

}
