package ph.com.bpi.hello.M3_Act1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MyApplication {

	/*
		**List**
		
		**Activity #1: Product List (M3\_ACTIVITY1)**
		
		*   **Goal:** Practice **List** Operations
		*   **Task:**
		    1.  **Create a List of Products with 5 records**
		        *   Laptop, Mouse, Keyboard, Monitor, Printer
		    2.  **Print all products**
		    3.  **Add a new product (Webcam) and remove one product (Mouse) and print the updated list.**
		    4.  **Find a product by name using two ways. You can use either**  
		        4.1. Traditional for-loop  
		        4.2. contains() method	 
	 */
	public static void main(String[] args) {
		 
		/*
		 * 1.  **Create a List of Products with 5 records**
		        *   Laptop, Mouse, Keyboard, Monitor, Printer
		 */
		String[] listOfGadgets = new String[] {"Laptop", "Mouse", "Keyboard", "Monitor", "Printer"};
        List<String> techGadgets = new ArrayList<>(Arrays.asList(listOfGadgets));
        /*
         * 2.  **Print all products**
         */
        for (String gadget : techGadgets) {
                            System.out.println(gadget);
             }
        /*
         *  3.  **Add a new product (Webcam) and remove one product (Mouse) and print the updated list.**
         */
        System.out.println("Add a new product (Webcam) and remove one product (Mouse) and print the updated list.");
        techGadgets.add("Webcam");       
        techGadgets.remove("Mouse");     

        for (String gadget : techGadgets) {
             System.out.println(gadget);
        }
        
        /*
         *    4.  **Find a product by name using two ways. You can use either**  
		        4.1. Traditional for-loop  
		        4.2. contains() method	 
         */
        
        System.out.println("Find a product by name - Keyboard");

		if (techGadgets.contains("Keyboard")) {
		    System.out.println("Found... " );
		}

	}
	
}
