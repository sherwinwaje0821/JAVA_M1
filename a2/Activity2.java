
/**
 * 
 */
package ph.com.bpi.hello.activity2;
import java.util.Scanner;
/**
 * 
 */
public class Activity2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Enter your age:");
Scanner input = new Scanner(System.in);
int intAge = Integer.parseInt(input.nextLine());
System.out.println("Your age as int: " + intAge);
double doubleAge = intAge;
System.out.println("Your age as int: " + doubleAge);

	}

}
