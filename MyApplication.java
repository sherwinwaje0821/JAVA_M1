package ph.com.bpi.hello.M4_Act5;

 /*
  
**SEATWORK #5: Your Turn to Try! (Branch: M4\_Activity5)**  
**Time:** 10 minutes  
**Your Task:** Create an account number validator using TWO different custom exceptions  
**Instructions:**  
**Step 1:** Create TWO Custom Exception Classes  
• Exception 1 **InvalidAccountNumberException** – CHECKED Exception (extends Exception)  
• Exception 2 **InvalidAccountFormatException** – UNCHECKED Exception (extends RuntimeException)

**Step 2:** Create a class named **AccountValidator**

**Step 3:** Create method **validateAccountNumber(String accountNumber)**  
• In method signature, add: **throws InvalidAccountNumberException**  
• Note: Only InvalidAccountNumberException is declared in throws (checked exception). The unchecked exceptions don’t need to be declared!

• Inside method, implement these validations IN ORDER:

1.  **Check for null:**  
    • If accountNumber is null → throw NullPointerException("Account number cannot be null")
2.  **Check format:**  
    • If contains non-digits → throw InvalidAccountFormatException("Account number must contain only digits")  
    • Hint: Use for loop (for (char c : accountNumber.toCharArray()) with if (!Character.isDigit(c)) then throw
3.  **Check length:** If length != 10 → throw InvalidAccountNumberException("Account number must be exactly 10 digits")
4.  **If valid:**  
    • Print: "Valid account number: \[accountNumber]"

**Step 4:** Create helper method **testValidation(String testName, String accountNumber)** to avoid repeating try‑catch blocks  
• Inside method:

1.  Print the test name
2.  Call validateAccountNumber inside try block
3.  Catch three exceptions: **InvalidAccountNumberException, InvalidAccountFormatException, NullPointerException**
4.  Print error messages

**Step 5:** In main method, test FIVE cases  
Use the testValidation helper method to test:

1.  `"1234567890"` → valid (10 digits)
2.  `"123A567890"` → contains letter
3.  `"1234"` → too short
4.  `"1234 567890"` → contains space
5.  **null** → null value

 
**Expected Output:**  
\=== Account Number Validation Test ===

Test 1: Valid account (1234567890)  
Valid account number: 1234567890

Test 2: Too short (123)  
Error: Account number must be exactly 10 digits

Test 3: Contains letters (12345ABC90)  
Warning: Account number must contain only digits

Test 4: Contains space (1234 567890)  
Warning: Account number must contain only digits

Test 5: Null value  
Warning: Account number cannot be null

***
 
  */
public class MyApplication {

 

public static void main(String[] args) {

        AccountValidator validator = new AccountValidator();

        System.out.println("=== Account Number Validation Test ===");

        validator.testValidation("Test 1: Valid account (1234567890)", "1234567890");
        validator.testValidation("Test 2: Contains letters (123A567890)", "123A567890");
        validator.testValidation("Test 3: Too short (1234)", "1234");
        validator.testValidation("Test 4: Contains space (1234 567890)", "1234 567890");
        validator.testValidation("Test 5: Null value", null);
    }



}
