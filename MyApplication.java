package ph.com.bpi.hello.M4_Act1;

/*
  
**SEATWORK #1: Your Turn to Try! (Branch: M4\_Activity1)**

Time: 10 minutes

Your Task: Display account name safely

**Instructions:**

1.  Create a class called **BankAccount**
2.  Create a method: **getAccountName(String accountNumber)**
    • If accountNumber equals "ACC-001", return "Juan Dela Cruz"  
    • If accountNumber equals "ACC-002", return "Maria Santos"  
    • Otherwise, return null
3.  Create the **testCase** method:  
    • Method signature: **public static void testCase(String accountNumber)**  
    • Print which account is being looked up  
    • Inside a try block:  
    • Call **getAccountName(accountNumber)** and assign to variable **String name**  
    • Convert name to uppercase using **name.toUpperCase()**  
    • Print the uppercase name  
    • Inside a catch block:  
    • Catch NullPointerException  
    • Print *"Error: Account not found!"*
4.  In the main method:  
    • Print a header message  
    • Call **testCase("ACC-001")** to test a valid account  
    • Call **testCase("ACC-999")** to test an invalid account (triggers exception)  
    • Print a completion message

Expected Output:
=== Bank Account Name Display ===

Looking up account: ACC-001
Account holder: JUAN DELA CRUZ

Looking up account: ACC-999
Error: Account not found!

=== Program completed successfully! ===
 
		  */
public class MyApplication {


 
    public static void main(String[] args) {
        System.out.println("=== Bank Account Name Display ===\n");
        BankAccount bankAccount = new BankAccount();
        bankAccount.testCase("ACC-001");  
        bankAccount.testCase("ACC-999");  

        System.out.println("=== Program completed successfully! ===");
    }

}
