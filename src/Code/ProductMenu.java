public interface ProductMenu {		// Implements the Product Menu of the Factory Method.

	//private Person person;

	public abstract void showMenu();

	public abstract void showAddButton();

	public abstract void showViewButton();

	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

	public abstract void SelectProduct(int UserType);

	public abstract void createProductList();

	public abstract void AttachProductToUser();

	public abstract void productOperation();

}
