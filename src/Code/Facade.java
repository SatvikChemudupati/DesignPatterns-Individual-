
import java.util.Scanner;

public class Facade {		//The facade class diagram is implemented with connecting multiple classes including Login and Registration

	private int userType;

	private Product productList;

	private int selectedProduct;

	private int menuType;

	private Login login = new Login();

	private String success;

	private int option;

	private UserInfoItem userInfo = new UserInfoItem();

	private Register register = new Register();


	public void startFacade() {			// This function initiates the program
		Scanner sc = new Scanner(System.in);
		System.out.println("---WELCOME!!---");
		System.out.println("Enter 0 to Login");
		System.out.println("Enter 1 to Register");
		option = sc.nextInt();
		if(option == 0)					// The Login information is displayed and the input is verified
		{
			System.out.println("----------Facade Pattern has been Implemented---------");
			System.out.println("---LOGIN---");
			System.out.println("Enter 0 for Buyer");
			System.out.println("Enter 1 for Seller");
			userType = sc.nextInt();
			if(userType != 1 && userType != 0){
				System.out.println("User Not Found");
				sc.close();
			}
			success = login.login(userType);
			if(success == null)
			{
				System.out.println("Invalid credentials");
				sc.close();
			}
		}
		if(option == 1)				// The registration information is displayed and the input is stored
		{
			System.out.println("----------Facade Pattern has been Implemented---------");
			System.out.println("---REGISTER---");
			System.out.println("Enter 0 for Buyer");
			System.out.println("Enter 1 for Seller");
			userType = sc.nextInt();
			try{
				register.Registration(userType);			// The user option is passed as an argument for registration in the register class
			}	
			catch(Exception e){
				System.out.println("Unable to register at this moment");
				sc.close();
			}
		}
		
		System.out.println("Select an option(Number) from Product Menu \n 1. Meat Product Menu \n 2. Produce Product Menu ");
		selectedProduct = sc.nextInt();			// The user option is selected for creating a meat or produce product menu options
		if (selectedProduct == 1) {
			SelectProduct(new MeatProductMenu(), userType);
		} else if (selectedProduct == 2) {
			SelectProduct(new ProduceProductMenu(), userType);
			menuType = 1;
		} else {
			System.out.println("Wrong Selection");
			System.exit(-1);
		}	
		System.out.println("Implementing the Visitor Pattern....");			// Implementing the Visitor pattern function
		remind(menuType);
		System.out.println("Implementing the Iterator pattern ....");		// Implementing the Visitor pattern function
		if(menuType == 1){
			try{
				productList = new Product(new ProduceProductMenu());
			}
			catch(Exception e){
				System.out.println("");
			}
		}
		
		else{
			try{
				productList = new Product(new MeatProductMenu());
			}
			catch(Exception e){
				System.out.println("");
			}
		}
		
		System.out.println("Obtaining elements from Present user......");
		userInfo.getUserProducts(success);
		int opinio;
		System.out.print("Want to add items (1/0)");
		opinio = sc.nextInt();
		if(opinio == 1)
		{
			System.out.println("Enter Product Name");
			String name = sc.next();
			userInfo.addUserProducts(success, name);
		}
		System.out.println("Obtaining elements from Present user......");
		userInfo.getUserProducts(success);
		sc.close();
		
	}


	public void addTrading(Trading t) {
		t.addTrading();
	}

	public void viewTrading(Trading t) {
		t.viewTrading();
	}

	public void decideBidding(Offering o) {
		o.decideBidding();
	}

	public void discussBidding(Offering o) {
		o.discussBidding();
	}

	public void submitBidding(Offering o) {
		o.submitBidding();
	}

	public void remind(int menu) {
		ReminderVisitor remind = new ReminderVisitor();
		if(menuType == 0)
			productList = new Product(new MeatProductMenu());
		else
			productList = new Product(new ProduceProductMenu());
			productList.accept(remind);

	}

	public void createUser(UserInfoItem userinfoitem) {
		userinfoitem.createUSer();
	}

	public void createProductList(ProductMenu prodMenu) {
		prodMenu.createProductList();
	}

	public void AttachProductToUser(ProductMenu prodMenu) {
		prodMenu.AttachProductToUser();
	}

	public void SelectProduct(ProductMenu prodMenu, int userType) {
		prodMenu.SelectProduct(userType);
	}

	public void productOperation(ProductMenu prodMenu) {
		prodMenu.productOperation();
	}

}
