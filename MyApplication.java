package ph.com.bpi.hello.M3_Act2;


import java.util.HashSet;
import java.util.Scanner;

/*
**Set Interface**

**Activity #2: Practice Set Operations (M3\_ACTIVITY2)**

*   **Goal:** Practice Set Operations
*   **Task:**
    1.  Create a HashSet of Products with **5 initial data**
    2.  Display the menu repeatedly until the user choose to exit.  
        Select an option:
        1.  Search a product
        2.  Add a product
        3.  Print all products and count
        4.  Exit
    3.  Provide implementation for each options

***
		  */
public class MyApplication {

	 

public static void main(String[] args) {
        //  1.  Create a HashSet of Products with **5 initial data**
        HashSet<String> products = new HashSet<>();
        products.add("broom");
        products.add("paint brush");
        products.add("mop");
        products.add("bucket");
        products.add("dustpan");

        Scanner sc = new Scanner(System.in);
        int choice;

        // 2.  Display the menu repeatedly until the user choose to exit. 
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    // 1.  Search a product
                    System.out.print("Search a product: ");
                    String searchProduct = sc.nextLine().toLowerCase();
                    if (products.contains(searchProduct)) {
                        System.out.println(searchProduct + " is available.");
                    }
                    break;

                case 2:
                    // 2.  Add a product
                    System.out.print("Enter product to add: ");
                    String newProduct = sc.nextLine().toLowerCase();
                    if (products.add(newProduct)) {
                        System.out.println(newProduct + " added successfully.");
                    }  
                    break;

                case 3:
                    // 3.  Print all products and count
                    System.out.println("Products: " + products);
                    System.out.println("Total count: " + products.size());
                    break;

                case 4:
                    System.out.println("Exit...");
                    break;

                default:
                	System.out.println("1 to 4 only...");
            }
        } while (choice != 4);

        sc.close();
    }

}
