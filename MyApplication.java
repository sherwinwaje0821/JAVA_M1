package ph.com.bpi.hello.M4_Act2;

/*
 
**SEATWORK #2: Your Turn to Try! (Branch: M4\_Activity2)**

Time: 10 minutes

Your Task: Create a simple ATM withdrawal system

Instructions:

1.  Create a class called **ATMSystem**
2.  Create an array of account balances:  
    `double[] accounts = {10000, 15000, 20000};`
3.  Create method: **processWithdrawal(String accountIndex, String amountInput)**  
    Use try with TWO catch blocks
4.  Inside try:  
    • Parse accountIndex to int (use Integer.parseInt)  
    • Get balance from array: accounts\[index]  
    • Parse amountInput to double (use Double.parseDouble)  
    • Check if amount > balance, print “Insufficient funds”  
    • Otherwise, calculate new balance and print success
5.  Use TWO catch blocks:  
    • catch (NumberFormatException e) ⇒ “Invalid input”  
    • catch (ArrayIndexOutOfBoundsException e) ⇒ “Account not found”  
    • catch (Exception e) ⇒ “Transaction failed” (catch all for unexpected errors)
6.  Test FOUR scenarios in main:  
    • Account “1”, Amount “5000” ⇒ Success  
    • Account “abc”, Amount “5000” ⇒ NumberFormatException  
    • Account “10”, Amount “5000” ⇒ ArrayIndexOutOfBoundsException  
    • Account “1”, Amount “20000” ⇒ Insufficient funds

***
 
 
**Expected Output:**

    === ATM Withdrawal System ===

    --- Test 1: Valid Withdrawal ---
    Account=1, Amount=5000
    Current balance: P15000.00
    Withdrawal: P5000.00
    New balance: P10000.00
    Withdrawal successful!

    --- Test 2: Invalid Account Index ---
    Account=abc, Amount=5000
    Error: Invalid input!
    Please enter valid numbers.

    --- Test 3: Account Not Found ---
    Account=10, Amount=5000
    Error: Account not found!
    Invalid account index.

    --- Test 4: Insufficient Funds ---
    Account=1, Amount=20000
    Current balance: P15000.00
    Withdrawal: P20000.00
    Insufficient funds! Cannot withdraw P20000.00

    === All tests completed! ===

 
 
		  */
public class MyApplication {


 
	 
    public static void main(String[] args) {

        ATMSystem atm = new ATMSystem();

        System.out.println("=== ATM Withdrawal System ===\n");

        
        System.out.println("--- Test 1: Valid Withdrawal ---");
        System.out.println("Account=1, Amount=5000");
        atm.processWithdrawal("1", "5000");
        System.out.println();

     
        System.out.println("--- Test 2: Invalid Account Index ---");
        System.out.println("Account=abc, Amount=5000");
        atm.processWithdrawal("abc", "5000");
        System.out.println();

      
        System.out.println("--- Test 3: Account Not Found ---");
        System.out.println("Account=10, Amount=5000");
        atm.processWithdrawal("10", "5000");
        System.out.println();

         
        System.out.println("--- Test 4: Insufficient Funds ---");
        System.out.println("Account=1, Amount=20000");
        atm.processWithdrawal("1", "20000");
        System.out.println();

        System.out.println("=== All tests completed! ===");
    }

}
