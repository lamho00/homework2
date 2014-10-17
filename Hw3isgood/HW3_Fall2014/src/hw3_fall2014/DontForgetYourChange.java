
package hw3_fall2014;

import java.util.Random;
import java.util.Scanner;


// Returns your change for a random bill at the checkout line. 
// See the file ChangeMaker in Lecture2.pdf on which this is based. 

public class DontForgetYourChange {
    
 public static void main(String[] args) {
     
 Random randomGenerator     = new Random();
  Scanner keyboard = new Scanner(System.in); 

 // Generates a random bill from 0 to 2000 cents. Then converts that to dollars and cents. 
 
  int totalBill =     randomGenerator.nextInt(2001); // In cents!! Max of $20
  int totalDollars = totalBill/100; // 0 to 20 dollars. 
  int totalCents = totalBill % 100; // and 0 to 99 cents
  String centsString = (totalCents<10? "0"+totalCents: totalCents+""); // Conditional operator
  String cost  = "$" + totalDollars + "." + centsString; // always use two spots for cents. 
  String message1 = "Thanks for shopping at BEST_STORE_IN_THE_WHOLE_GALAXY!\n\n";
  message1  += "Your bill is: " + cost;
  message1  += "\nPlease pay using a $1, $5, $10, $20 or $50 bill only.";
  System.out.println(message1);
   
  
  // While loop verifies a proper payment has been received. 
   boolean done = false;
   int dollarsPaid=0; // The bill the customer hands over. 
   while( !done)
   {
       
         System.out.println("Enter value of bill. Must be a 1, 5, 10, 20 or 50 dollar bill.");
         System.out.print("Denomination of Bill: ");
         dollarsPaid = keyboard.nextInt();
         
     // Add code here to make sure payment is sufficient and proper. 
     // Test if the bill is a $1, $5, $10, $20 or $50. 
      if( ! (dollarsPaid== 1 || dollarsPaid== 5 || dollarsPaid== 10  || dollarsPaid== 20 || dollarsPaid== 50) )     
          {         System.out.println("Sorry, we can only handle $5, $10, $20 or $50 bills. Try again."); continue;}
     
      // Test if the bill is sufficient to pay the bill. 
      if( dollarsPaid *100 < totalBill  )    // Both in cents  
          {         System.out.println("Sorry, that is not enough! Try again.");  continue; }
       
     done = true; // Payment is valid and sufficient. 
      
     System.out.print("\nOK, thanks! ");
 
   } // end of while for payment
  
   int change = dollarsPaid*100 - totalBill; // In cents!
   System.out.println("Your change due is: $" + change/100.); // Using 100 with a dot means we don't toss the pennies thru integer division.

  // Now print out their change using the least number of each coin or dollar bill. 
   String changeMessage = makeChange(change);
   
   System.out.println(changeMessage);
      System.out.println("Please shop again soon! We *LOVE* our customers!");

 }    // end of main
    
    
   // Program returns a String stating the number of pennies, nickels, dimes, quarters, and assorted paper dollar bills for your change.  
  public static String makeChange(int changeDueInCents ) {
    String changeMessage  = "Here is your change!\n";  
     
    
    // Expand the calculational heart from the old ChangeMaker in Lecture2.pdf to include bills and not just coins. 
        int amountDue = changeDueInCents; 
        
      // Add twentyDollarBills, tenDollarBills, fiveDollarBills and oneDollarBills here. 
      //  Here are the twenties done for you. 
        
        int twentyDollarBills = amountDue/2000; // Two thousand pennies in a twenty.
        if (twentyDollarBills > 0 )  {changeMessage += twentyDollarBills + " Twenty Dollar Bill(s)\n";     } // Only add to message if you indeed get some twenties. 
        amountDue = changeDueInCents % 2000;  // Amount still owed after any twenties have been returned. 
        
         // Add the other bills here. Use tenDollarBills, fiveDollarBills and oneDollarBills as variables.
        int tenDollarBills = amountDue/1000; // One thousand pennies in a ten dollar bill.
        if (tenDollarBills > 0 )  {changeMessage += tenDollarBills + " tenDollarBills(s)\n";     }
        amountDue = changeDueInCents % 1000;
        
        int FiveDollarBills = amountDue/500; // One thousand pennies in a ten dollar bill.
        if (FiveDollarBills > 0 )  {changeMessage += FiveDollarBills + " FiveDollarBills(s)\n";     }
        amountDue = changeDueInCents % 500;
        
        int DollarBills = amountDue/100; // One thousand pennies in a ten dollar bill.
        if (DollarBills > 0 )  {changeMessage += DollarBills + " DollarBills(s)\n";     }
        amountDue = changeDueInCents % 100;
        
        int Quarters = amountDue/25; // One thousand pennies in a ten dollar bill.
        if (Quarters > 0 )  {changeMessage += Quarters + " Quarters(s)\n";     }
        amountDue = changeDueInCents % 25;
       
        int Dimes = amountDue/10; // One thousand pennies in a ten dollar bill.
        if (Dimes > 0 )  {changeMessage += Dimes + " Dimes(s)\n";     }
        amountDue = changeDueInCents % 10;
        
        int Nickels = amountDue/5; // One thousand pennies in a ten dollar bill.
        if (Nickels > 0 )  {changeMessage += Nickels + " Nickels(s)\n";     }
        amountDue = changeDueInCents % 5;
        
        int Pennies;
        Pennies = amountDue;
        if (Pennies > 0 )  {changeMessage += Pennies + " Pennies(s)\n";     }
        
        // Now process the coins. Use quarters, dimes, nickels and pennies as the variables. 
        // For each coin, only add to the message if you actually receive at least one of that coin. 
        

        
        
        
        
        
      
    return changeMessage; 
  } // end of method
   
    
    
    
} // end of class
