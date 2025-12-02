
/**
 * 
 */
package ph.com.bpi.hello.activity5;
import java.util.Scanner;
/**
 * 
 */
public class Activity5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		/*
		 * ACTIVITY 5 - LOOP
Objective: Practice creating methods and using operators
Write a Java program that prints the sum of numbers from 1 to 50.
		 */
		int sum=0;
		 for(int i=1;i<=50;i++) {
			 sum += incrementNum(i);
		 }
		 
		 System.out.println("Sum = " + sum );
	}
 
 public static int incrementNum(int num) {
	 return num++;
 }
}
