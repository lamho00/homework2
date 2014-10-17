package hw3_fall2014;

/**
   A class to test the BankAccount class.
*/
public class BankAccountTester
{
   /**
      Tests the methods of the BankAccount class.
      @param args not used
   */
   public static void main(String[] args)
   {
      BankAccount harrysChecking = new BankAccount();
      harrysChecking.deposit(2000);
      harrysChecking.withdraw(500);
      System.out.println("Harry's balance is: $" + String.format("%.2f",harrysChecking.getBalance() )    );
      System.out.println("If all went according to plan, we expect: $1500.00");      
   } // end of main
   
   
} // end of class