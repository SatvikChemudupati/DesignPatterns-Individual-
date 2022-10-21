public class Buyer extends Person {  	//Implements the Buyer class extending the Person in the factory design pattern


	Buyer() {
		super(productMenu);
	}

	Buyer(ProductMenu theProductMenu) {
		super(productMenu);
	}


	@Override
	public void showMenu() {
		System.out.println("Buyer Menu items....");	//Shows the menu items of the buyer
	}

	@Override
	public ProductMenu CreateProductMenu() {
		int offer = 0;
		if (offer == 0) {
			return new MeatProductMenu();
		} else {
			return new ProduceProductMenu();
		}
	}

}
