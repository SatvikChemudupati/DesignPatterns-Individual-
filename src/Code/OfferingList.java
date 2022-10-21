import java.util.*;

public class OfferingList {	 // Implements the Offering List class that connects with the Offering Iterator of the Iterator Design Pattern.

	ArrayList<String> offering = new ArrayList<>();

	OfferingList(MeatProductMenu m) {	 // Displaying the lists of things offered.
		offering.add("Offering for Beef are");
		offering.add("Offering for Pork are");
		offering.add("Offering for Mutton are");
	}
	
	OfferingList(ProduceProductMenu p) {
		offering.add("Offering for Tomato are");
		offering.add("Offering for Onion are");
	}

	@SuppressWarnings("rawtypes")
	public Iterator createIterator() {
		return this.offering.iterator();
	}

}
