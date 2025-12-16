package ph.com.bpi.hello.M3_Act3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 
**Map Interface**

**Activity #3: Practice Map Operations (M3\_ACTIVITY3)**

*   **Goal:** Practice **Map** Operations
*   **Task:**
    1.  **Create a Map of products** with 5 initial records  
        ● (Key = product name, Value = product price)

    2.  **Display a menu repeatedly** until user chooses to exit.

        Select an option:

        1.  Search a product
        2.  Add a product
        3.  Print all products and prices
        4.  Find the cheapest product
        5.  Exit

    3.  Create implementation for each options.

		  */
public class MyApplication {


public static void main(String[] args) {
        //     1.  **Create a Map of products** with 5 initial records  
    	//		● (Key = product name, Value = product price)
	
        Map<String, Double> products = new HashMap<>();
        products.put("Brush", 50.0);
        products.put("Broom", 120.0);
        products.put("Mop", 150.0);
        products.put("Dustpan", 30.0);
        products.put("Bucket", 80.0);

        Scanner sc = new Scanner(System.in);
        int choice;

        /*  
         *     2.  **Display a menu repeatedly** until user chooses to exit.

        Select an option:

        1.  Search a product
        2.  Add a product
        3.  Print all products and prices
        4.  Find the cheapest product
        5.  Exit

         */
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and prices");
            System.out.println("4. Find the cheapest product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    // Search a product
                    System.out.print("Search a product: ");
                    String searchProduct = sc.nextLine();
                    if (products.containsKey(searchProduct)) {
                        System.out.println(searchProduct + " price: " + products.get(searchProduct));
                    }  
                    break;

                case 2:
                    // 2.  Add a product
                    System.out.print("Enter product name: ");
                    String newProduct = sc.nextLine();
                    System.out.print("Enter product price: ");
                    double newPrice = sc.nextDouble();
                    products.put(newProduct, newPrice);
                    System.out.println("Product added successfully!");
                    break;

                case 3:
                    // 3.  Print all products and prices
                    System.out.println("\nProducts and Prices:");
                    for (Map.Entry<String, Double> entry : products.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                    break;

                case 4:
                    // 4.  Find the cheapest product
                    String cheapestProduct = null;
                    double minPrice = Double.MAX_VALUE;
                    for (Map.Entry<String, Double> entry : products.entrySet()) {
                                               if (entry.getValue() < minPrice) {
                            minPrice = entry.getValue();
                            cheapestProduct = entry.getKey();
                        }
                    }
                    System.out.println("Cheapest product: " + cheapestProduct + " (Price: " + minPrice + ")");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("1 to 5 only.");
            }
        } while (choice != 5);

        sc.close();
    }


}
