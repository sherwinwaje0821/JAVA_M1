/**
* 
 */
package ph.com.bpi.hello.activity3;
import java.util.Scanner;
/**
* 
 */
public class Activity3 {

                /**
                * @param args
                */
                public static void main(String[] args) {

                                // TODO Auto-generated method stub
                                
                                Scanner input = new Scanner(System.in);
                                
System.out.print("Enter first integer:");
int num1=input.nextInt();

System.out.print("Enter second integer:");
int num2=input.nextInt();

System.out.println("Sum " +computeSum(num1,num2));
System.out.println("Difference " +computeDiff(num1,num2));
System.out.println("Product " +computeProd(num1,num2));


input.close();

                }
public static int computeSum(int addNum1,int addNum2) {
                                
                                return addNum1+addNum2;
                }

public static int computeDiff(int addNum1,int addNum2) {
                
                return addNum1-addNum2;
}

public static int computeProd(int addNum1,int addNum2) {
                
                return addNum1*addNum2;
}


}
