package ph.com.bpi.hello.M4_Act4;

 /*
  
***

**SEATWORK #4: Your Turn to Try! (Branch: M4\_Activity4)**

Time: 10 minutes

Your Task: Create account number validator

Instructions:

1.  Create a *class* **AccountValidator**
2.  Create method: **validateAccountNumber(String accountNumber)**  
    • In method signature, add: *throws Exception*  
    • Inside method:  
    • If *accountNumber is null* → throw NullPointerException  
    "Cannot be null"  
    • If length is *not 10* → throw Exception "Must be 10 digits"  
    • If valid → print "Valid account: \[number]"
3.  In main, test **THREE** cases:  
    • `"1234567890"` (valid – should pass)  
    • `"123"` (invalid – too short)  
    • *null* (invalid – null)
4.  Use **try-catch** to handle exceptions

***

**Expected Output:**  
Valid account: 1234567890  
Error: Must be 10 digits  
Error: Cannot be null

***
 
  */
public class MyApplication {

 
	 

public static void main(String[] args) {

        AccountValidator validator = new AccountValidator();

         
        try {
            validator.validateAccountNumber("1234567890");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        
        try {
            validator.validateAccountNumber("123");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        
        try {
            validator.validateAccountNumber(null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
