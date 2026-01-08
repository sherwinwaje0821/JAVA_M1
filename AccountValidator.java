package ph.com.bpi.hello.M4_Act5;

public class AccountValidator {

public void validateAccountNumber(String accountNumber)
            throws InvalidAccountNumberException {

         
        if (accountNumber == null) {
            throw new NullPointerException("Account number cannot be null");
        }

        
        for (char c : accountNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidAccountFormatException("Account number must contain only digits");
            }
        }

       
        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
        }

       
        System.out.println("Valid account number: " + accountNumber);
    }

    
    public void testValidation(String testName, String accountNumber) {
        System.out.println("\n" + testName);

        try {
            validateAccountNumber(accountNumber);

        } catch (InvalidAccountNumberException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAccountFormatException e) {
            System.out.println("Warning: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}


