/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3_fall2014;

/**
   This class models a tally counter.
*/
public class Counter
{
   private int value;

   /**
      Gets the current value of this counter.
      @return the current value
   */
   public int getValue()
   {
      return value;
   }

   /**
      Advances the value of this counter by 1.
   */
   public void click() 
   {
      value = value + 1;
   }

   /**
      Resets the value of this counter to 0.
   */
   public void reset()
   {
      value = 0;
   }
} // end of class Counter



// * * * * * * * * * * * * * * * * DEMO CLASS * * * * * * * * * * * * * * 
// I just added the demo class here but removed the public accessor specifier. 

class CounterDemo
{
   public static void main(String[] args)
   {
      Counter tally = new Counter();
      
      System.out.println("\nThis program tests a simple COUNTER with click function.\n");

      System.out.println("Let's click the tally counter twice.");
      tally.click();   System.out.print("\tclick");
      tally.click();   System.out.print("\tclick");
      
      int result = tally.getValue(); // Sets result to 2
      System.out.print("\nHere is the result: ");
      System.out.println(result);
      
      System.out.println("\nLet's click the tally counter three more times!");
      tally.click();   System.out.print("\tclick");
      tally.click();   System.out.print("\tclick");
      tally.click();   System.out.print("\tclick");
      
      result = tally.getValue(); // Sets result to 5
      System.out.print("\nHere is the new result: ");
      System.out.println(result);
      
      
      System.out.println("\nOK, now press the reset button.");
      tally.reset();    System.out.print("\treset\n");
      result = tally.getValue(); // Sets result to 0
      System.out.print("\nHere is the final result: ");
      System.out.println(result);
      
   } // end of main
} // end of class 

