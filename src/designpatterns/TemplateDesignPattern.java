package designpatterns;
/*
 * http://javatechig.com/design-patterns/strategy-design-pattern-in-java
 */
public class TemplateDesignPattern {
	public static void main(String[] args) {
		SweetCornPizza pizza1 = new SweetCornPizza();
		pizza1.preparePizza();

		System.out.println("**********");

		MexicanPizza pizza2 = new MexicanPizza();
		pizza2.preparePizza();
	}
}

abstract class Pizza {
	public abstract void chooseBread();

	public abstract void addIngredients();

	public void heating() {
		System.out.println("Heating for 10 minutes!");
	}

	public void addTopinngs() {
		System.out.println("Adding Topinngs!");
	}

	public void addCheese() {
		System.out.println("Adding Cheese!");
	}

	// Template method
	public final void preparePizza() {
		chooseBread();
		addIngredients();
		heating();
		addCheese();
		addTopinngs();
	}

	public final void preparePizza2() {
		chooseBread();
		addIngredients();
		heating();
		if (isCheese()) {
			addCheese();
		}
		addTopinngs();
	}

	public boolean isCheese() {
		return true;
	}

}

class MexicanPizza extends Pizza {
	@Override
	public void chooseBread() {
		System.out.println("Choosing Mexican Pizza Bread!");
	}

	@Override
	public void addIngredients() {
		System.out.println("Adding Mexican Pizza Ingredients!");
	}
}

class SweetCornPizza extends Pizza {
	@Override
	public void chooseBread() {
		System.out.println("Choosing SweetCorn Pizza Bread!");
	}

	@Override
	public void addIngredients() {
		System.out.println("Adding SweetCorn Pizza Ingredients!");
	}
}

class DoubleCheesePizza extends Pizza {
	@Override
	public void chooseBread() {
		System.out.println("Choosing DoubleCheese Pizza Bread!");
	}

	@Override
	public void addIngredients() {
		System.out.println("Adding DoubleCheese Pizza Ingredients!");
	}

	@Override
	public void addCheese() {
		System.out.println("Adding Double Cheese!");
	}

	public class NoCheesePizza extends Pizza {
		@Override
		public void chooseBread() {
			System.out.println("Choosing SweetCorn Pizza Bread!");
		}

		@Override
		public void addIngredients() {
			System.out.println("Adding SweetCorn Pizza Ingredients!");
		}

		@Override
		public boolean isCheese() {
			return false;
		}
	}

}
