import java.util.*;
import java.io.*;

@SuppressWarnings("rawtypes")

public class Product extends Reminder{		// Implements the iterator pattern diagram

	private String path = System.getProperty("user.dir");

	private String str = path + "\\ProductInfo.txt";

	Scanner sc;

	String y;
	char c;

	ArrayList<String> prod = new ArrayList<>();

	Product(MeatProductMenu m){
		System.out.println("Elements in meat product menu is/are");
		try {
			sc = new Scanner(new File(str));
			while (sc.hasNextLine()) {
				y=y+c;
				String st[]= sc.next().split(":");
				
				if(st[0].equals("Meat")) {
					System.out.println(st[1]);
					prod.add("Meat:"+st[1]);			// Calling the iterator pattern diagram object
				}
				if(sc.nextLine() == null)
					break;
			}
		} catch (FileNotFoundException f) {
			System.out.println("Error finding the Meat Product menu");
		}
	}
	Product(ProduceProductMenu p){
		System.out.println("Elements in Produce product menu is/are");
		try {
			sc = new Scanner(new File(str));
			while (sc.hasNextLine()) {
				y=y+c;
				if(sc.next() == null)
					break;
				String st[]= sc.next().split(":");
				
				if(st[0].equals("Produce")) {
					System.out.println(st[1]);
					prod.add("Produce:"+st[1]);
				}
				if(sc.nextLine() == null)
					break;
			}
		} catch (FileNotFoundException f) {
			System.out.println("Error finding the Produce Product menu");
		}
	}

	public Iterator createIterator() {
		return this.prod.iterator();
	}

	public Reminder accept(NodeVisitor nodeVisitor) {
		System.out.println("Product List Reminder ...");
		return nodeVisitor.visitProduct(this);
	}

}

