package ph.com.bpi.hello.M4_Act3;

/*
 
 SEATWORK #3: Your Turn to Try! (Branch: M4_Activity3)
 Time: 10 minutes
Your Task: ATM Balance Check with Receipt Printing
Instructions:
1. Create a class called ATMTransaction
2. Create method: checkBalance(String accountNumber, double balance)
• Inside the method:
• Try Block:
• Print "Processing balance inquiry..."
• Validate account number format by converting to integer:
Integer.parseInt(accountNumber)
• Get account type from first character: char accountType = accountNumber.charAt(0)
• Determine account type name:
• If accountType == '1' → Print "Account Type: Savings"
• If accountType == '2' → Print "Account Type: Checking"
• Otherwise → Print "Account Type: Unknown"
• Print "Account Number: " + accountNumber
• Print "Current Balance: ₱" + balance
• Print "Balance inquiry successful!"
• Write TWO catch blocks:
• catch (NumberFormatException e) → Print "Error: Invalid account number format!
Account numbers must be numeric."
• catch (StringIndexOutOfBoundsException e) → Print "Error: Account number is
empty or invalid!"
• Write finally block (ALWAYS executes):
• Print "\n========== RECEIPT =========="
• Print "Transaction Date: December 3, 2025"
• Print "Transaction Type: Balance Inquiry"
• Print "ATM Location: Main Branch"
• Print "Thank you for banking with us!"
• Print "==============================\n"
3. In main method, test FOUR scenarios:
• checkBalance("100123456", 15000.00) → Valid Savings account
(success)
• checkBalance("200987654", 25000.00) → Valid Checking account
(success)
• checkBalance("ABC12345", 15000.00) → NumberFormatException
(invalid format)
• checkBalance("", 15000.00) → StringIndexOutOfBoundsException
(empty string)

Expected Output:
=== ATM BALANCE INQUIRY SYSTEM ===
--- Test Case 1: Valid Savings Account ---
Processing balance inquiry...
Account Type: Savings
Account Number: 100123456
Current Balance: ₱15000.0
Balance inquiry successful!
========== RECEIPT ==========
Transaction Date: December 3, 2025
Transaction Type: Balance Inquiry
ATM Location: Main Branch
Thank you for banking with us!
==============================
--- Test Case 2: Valid Checking Account ---
Processing balance inquiry...
Account Type: Checking
Account Number: 200987654
Current Balance: ₱25000.0
Balance inquiry successful!
========== RECEIPT ==========
Transaction Date: December 3, 2025
Transaction Type: Balance Inquiry
ATM Location: Main Branch
Thank you for banking with us!
==============================
--- Test Case 3: Invalid Account Number Format ---
Processing balance inquiry...
Error: Invalid account number format! Account numbers must be
numeric.
========== RECEIPT ==========
Transaction Date: December 3, 2025
Transaction Type: Balance Inquiry
ATM Location: Main Branch
Thank you for banking with us!
==============================
--- Test Case 4: Empty Account Number ---
Processing balance inquiry...
Error: Invalid account number format! Account numbers must be
numeric.
========== RECEIPT ==========
Transaction Date: December 3, 2025
Transaction Type: Balance Inquiry
ATM Location: Main Branch
Thank you for banking with us!
==============================
 
		  */
public class MyApplication {


 
	 
	 public static void main(String[] args) {

	        ATMTransaction atm = new ATMTransaction();

	        System.out.println("=== ATM BALANCE INQUIRY SYSTEM ===");

	        System.out.println("--- Test Case 1: Valid Savings Account ---");
	        atm.checkBalance("100123456", 15000.00);

	        System.out.println("--- Test Case 2: Valid Checking Account ---");
	        atm.checkBalance("200987654", 25000.00);

	        System.out.println("--- Test Case 3: Invalid Account Number Format ---");
	        atm.checkBalance("ABC12345", 15000.00);

	        System.out.println("--- Test Case 4: Empty Account Number ---");
	        atm.checkBalance("", 15000.00);
	    }

}
