package ph.com.bpi.hello.M4_Act2;


public class ATMSystem {

    
    double[] accounts = {10000, 15000, 20000};

    
    public void processWithdrawal(String accountIndex, String amountInput) {
        try {
            
            int index = Integer.parseInt(accountIndex);

           
            double balance = accounts[index];

          
            double amount = Double.parseDouble(amountInput);

            
            System.out.printf("Current balance: P%.2f%n", balance);
            System.out.printf("Withdrawal: P%.2f%n", amount);

           
            if (amount > balance) {
                System.out.printf("Insufficient funds! Cannot withdraw P%.2f%n", amount);
                return;
            }

             
            double newBalance = balance - amount;
            accounts[index] = newBalance;

            
            System.out.printf("New balance: P%.2f%n", newBalance);
            System.out.println("Withdrawal successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input!");
            System.out.println("Please enter valid numbers.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Account not found!");
            System.out.println("Invalid account index.");

        } catch (Exception e) {
            System.out.println("Transaction failed!");
        }
    }

    
}

