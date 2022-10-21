import java.util.*;
import java.io.*;

public class UserInfoItem {   // Implements the class that displayes the info of the items of the user or add new items.

    private String path = System.getProperty("user.dir");

	private String str = path + "\\UserProduct.txt";

    Scanner sc;
    String y;
    char c;

    
    public void createUSer() {
		System.out.println(" User Created ....");
	}

    public void getUserProducts(String username){
		try {
			sc = new Scanner(new File(str));
			while (sc.hasNextLine()) {
				y=y+c;
				String st[]= sc.next().split(":");
				
				if(st[0].equals(username)) {
					System.out.println(st[1]);
				}
				if(sc.nextLine() == null)
					break;
			}
		} catch (FileNotFoundException f) {
			System.out.println("Error finding the Meat Product menu");
		}
    }

    public void addUserProducts(String username, String Productcat){

        try{
            FileWriter fw =new FileWriter(str, true);
            fw.write(username);
            fw.write(":");
            fw.write(Productcat);
            fw.write("\n");
            fw.close();
            }
            catch(IOException e)
            {
                System.out.println("File not found");
            }  
    }
        
    }

