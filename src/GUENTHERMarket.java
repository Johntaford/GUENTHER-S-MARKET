import java.util.*;


public class GUENTHERMarket {

	private static Scanner scan;
	private static Map<String, Double> items = new TreeMap<>();
	private static List<String> orderNames = new ArrayList<>();
	private static List<Double> orderPrices = new ArrayList<>();
	
	public static void main(String[] args) {
	scan = new Scanner(System.in);
	fillItemsMap();
	printMenu();
	System.out.println();
	userOrder(orderNames, orderPrices);
	receipt();
	
	
	
	
	}
	
	private static void fillItemsMap() {
		items.put("Eggs", 2.89);
		items.put("Ground Turkey", 13.99);
		items.put("Chicken", 14.99);
		items.put("Milk", 2.99);
		items.put("lemon", .89);
		items.put("Bread", 2.99);
		items.put("Cereal", 3.99);
		items.put("Orange", .89);
		
	}
	
	private static void printMenu() {
		//Add formating here 
		System.out.printf("%-15s%-15s%n","Item", "Price");
		System.out.println("=====================");
		
		
		for(Map.Entry<String, Double> entry : items.entrySet()) {
			System.out.printf("%-15s%-15s%n",entry.getKey(),  "$"+entry.getValue());
	}
	System.out.println("What item would you like to order? ");
}	
	private static void userOrder (List<String> orderNames, List<Double> orderPrices) {
		while (items != null) {
		String itemName = scan.nextLine();	
		Double itemPrice = items.get(itemName);
		
		if(items.containsKey(itemName)) {
			orderNames.add(itemName);
			orderPrices.add(itemPrice);
			System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
			System.out.println("Would you like to order anything else? (y/n)");
		} else {
			System.out.println("Item not available.");
			System.out.println("What item would you like to order? ");
			userOrder(orderNames, orderPrices);
		}
		String answer = scan.next();
		
		if(answer.equalsIgnoreCase("y")) {
			printMenu();
			continue;
		}
		else if(answer.equalsIgnoreCase("n")) {
			
		}
		else {
			System.out.println("Great, now you have to restart. Please follow the directions");
			break;
		}
		}
	}
	private static void receipt() {
		System.out.println("Thanks for your order! \n Here's what your ordered: ");
		for (int i = 0; i < orderNames.size(); i++) {
			System.out.printf("%-15s%-15s%n",orderNames.get(i), "$"+orderPrices.get(i));
		}
		average();
		max();
		min();
	}
	private static void average() {
		double sum = 0;
		
		for (int i = 0; i < orderPrices.size(); i++) {
			sum += orderPrices.get(i);
			
			double avg = (sum / orderNames.size());
			
			System.out.println("Average price per item in order was $:" + avg);
		}
	}
	private static void max() {
		double max = Collections.max(orderPrices);
		System.out.println("Highest priced item is $" + max);
	}
	private static void min() {
		double min = Collections.min(orderPrices);
		System.out.println("Lowest Priced item is $" + min);
	}
	
	
}