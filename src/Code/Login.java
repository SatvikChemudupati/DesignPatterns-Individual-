import java.util.*;
import java.io.*;

public class Login{		//Creates the login options with writing the username and password into the database in Facade design pattern

    private String username;

    private String password, y;

	private String path = System.getProperty("user.dir");

	char c;

    public String login( int userType) {
		System.out.println("Enter Username ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		username = scan.next();
		System.out.println("Enter Password ");
		password = scan.next();
		boolean success = false;
        if(userType == 0) {
			success = validation(path + "\\BuyerInfo.txt");
		}
		
		else {
			success = validation(path + "\\SellerInfo.txt");
		}
		if(success)
			return username;
		else
			return null;
	}

    public boolean validation(String str) {
		Scanner sc;
		try {
			sc = new Scanner(new File(str));
			while (sc.hasNextLine()) {
				y=y+c;
				String st[]= sc.next().split(":");
				
				if(st[0].equals(username)&&st[1].equals(password)) {
					return true;
				}
			}
		} catch (FileNotFoundException f) {
			System.out.println("Error finding the user");
		}
		return false;
	}
	
	
}


