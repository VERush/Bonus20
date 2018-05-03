import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Bonus-20 Lab by Victoria Rush
 *   May 2, 2018
 */
public class ShoppingList {

	public static void main(String[] args) {
		HashMap<String, Double> products = new HashMap<>();
		ArrayList<String> items = new ArrayList<>();
		ArrayList<Double> prices = new ArrayList<>();
		String cont = "y";
		String tempItem = "";
		int index;
		Scanner scan = new Scanner(System.in);

		products.put("apple", 0.99);
		products.put("banana", 0.59);
		products.put("cauliflower", 1.59);
		products.put("dragonfruit", 2.19);
		products.put("Elderberry", 1.79);
		products.put("figs", 2.09);
		products.put("grapefruit", 1.99);
		products.put("honeydew", 3.49);

		System.out.println("Welcome to Guenther's Market!");

		do {
			// Display Menu
			System.out.printf("%1$-18s %2$-18s%n", "Item", "Price");
			System.out.println("===============================");
			System.out.println();

			for (String product : products.keySet()) {
				System.out.printf("%1$-18s %2$-18s%n", product, products.get(product));
			}

			// Query Item to Order
			System.out.println("What would you like to order? ");
			tempItem = scan.nextLine();

			// Validate input
			while (products.get(tempItem) == null) {
				System.out.println("Sorry, we don't have those. Please try again.");
				System.out.printf("%1$-18s %2$-18s%n", "Item", "Price");
				System.out.println("===============================");
				System.out.println();
				for (String product : products.keySet()) {
					System.out.printf("%1$-18s %2$-18s%n", product, products.get(product));
				}
				tempItem = scan.nextLine();
			}

			// Add item & price to shopping lists
			items.add(tempItem);
			prices.add(products.get(tempItem));
			System.out.println("Adding " + tempItem + " to cart at $" + products.get(tempItem));

			// Keep going?
			System.out.println("Would you like to order anything else (y/n)? ");
			cont = scan.nextLine();
		} while (cont.equalsIgnoreCase("y"));

		// Display shopping list with prices in columns
		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got:");
		for (int i = 0; i < items.size(); i++) {
			System.out.printf("%1$-18s %2$1s %3$-18s%n", items.get(i), "$", prices.get(i));
		}

		// Calculate Average
		System.out.println("Average price is: " + calcAvg(prices));

		// Determine Highest and Lowest Price and display
		index = findHighest(prices);
		System.out.println("Highest priced item is: " + items.get(index) + " at $" + prices.get(index));
		index = findLowest(prices);
		System.out.println("Lowest priced item is: " + items.get(index) + " at $" + prices.get(index));

		scan.close();
	}

	public static double calcAvg(ArrayList<Double> prices) {
		double sum = 0;
		double avg;
		int total = 0;
		for (int i = 0; i < prices.size(); i++) {
			sum += prices.get(i);
			total++;
		}

		avg = sum / total;
		return avg;
	}

	public static int findHighest(ArrayList<Double> prices) {

		int keepIndex = 0;
		double keepHigh = 0;
		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) > keepHigh) {
				keepHigh = prices.get(i);
				keepIndex = i;
			}
		}
		return keepIndex;
	}

	public static int findLowest(ArrayList<Double> prices) {

		int keepIndex = 0;
		double keepLow = 1000;
		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) < keepLow) {
				keepLow = prices.get(i);
				keepIndex = i;
			}
		}
		return keepIndex;
	}
}
