
/**
 * 
 */
package ph.com.bpi.hello.activity4;
import java.util.Scanner;
/**
 * 
 */
public class Activity4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
System.out.print("Enter age:");

int num1=input.nextInt();
 
 
switch(num1) {
case 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17:
	System.out.println("Minor");
break;
 
case 18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59:
	System.out.println("Adult");
break;
default:
	System.out.println("Senior");
}

input.close();

	}
 
 
}
