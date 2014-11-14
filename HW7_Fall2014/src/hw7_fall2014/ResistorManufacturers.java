/*
  * Borg Conglomerate produces precision 1 kilo-Ohm resistors with a stated tolerance of 1% . 
  * However, the company has been losing sales to a new company Human Enterprise which produces the same resistor. 
  * To test whose resistors are better, each company produces a run of 100 resistors 
  * and submits them for testing. We will populate each array of resistors using a Random generator. 

 */
package hw7_fall2014;

import java.util.Random;


public class ResistorManufacturers {
    
  public static void main(String[] args)  {
      
  //1. Let's collect the test resistors into arrays. One hundred for each manufacturer.     
  //   Resistors ar all supposed to be within 1% of 1000 Ohms. (So the allowed error is ±10 Ohms)
  
  int numberOfTestResistors = 100;
  double [] humanResistor = new double[numberOfTestResistors]   ; 
  double []  borgResistor = new double[numberOfTestResistors]   ; 
  
  Random rg = new Random( 100100100100100100L ); // Seed is the long 100 ^6
  
  // Collect all the test resistors into two arrays
  for (int i = 0; i < numberOfTestResistors; i++) {
      borgResistor[i]  = 1000.0 + (-50 + 150*rg.nextDouble() );
      humanResistor[i] = 1000.0 + (-10 + 20*rg.nextDouble() );
  }
     
  // Test the resistors from each manufacturer.    
  // a. Complete the mean() method and report who has a mean closer to 1000 Ohms. 
   System.out.println("* * * * * Quality Control Tests * * * * * ");
   
   System.out.println("\n* * * * * Testing the Mean * * * * * ");

   System.out.println("The mean for the  Borg sample is:  " + String.format("%9.3f", mean(borgResistor)) );
   System.out.println("The mean for the Humam sample is:  " + String.format("%9.3f", mean(humanResistor)) );
   System.out.println("The Human resistors have a closer mean to the stated specifications.\n\n");

   // Test the resistors from each manufacturer to see if they lie in the stated range from 990.0 to 1010.0   
  // b. Complete the numberOutsideTolerance() method and report who has more bad resistors. 
 
   System.out.println("* * * * * Testing # Outside Tolerance * * * * * ");

   double minAllowed = 990.0, maxAllowed = 1010.0; 
   int numberBadFromBorg = numberOutsideTolerance(borgResistor, minAllowed, maxAllowed);
   int numberBadFromHumans = numberOutsideTolerance(humanResistor, minAllowed, maxAllowed);

    System.out.printf( "The number of bad  Borg resistors (outside the stated tolerance) is %d.\n", numberBadFromBorg);
    System.out.printf( "The number of bad Human resistors (outside the stated tolerance) is %d.\n", numberBadFromHumans);

    
  // c. Create from scratch a min and a max method.  (Go way below)
  //  Report the min and the max resistance values for both the Borgs and the Humans. 
  // Add code here. 
  System.out.println("\n* * * * * Testing Min and Max * * * * * ");
  
  double borgMin = min(borgResistor), borgMax =max(borgResistor), humanMin = min(humanResistor), humanMax = max(humanResistor); // Fix these stub values. Use your min & max methods. 
  
  
  System.out.printf("The  Borg resistors vary from a minimum of %9.3f to a maximum of %9.3f\n", borgMin, borgMax);
  System.out.printf("The Human resistors vary from a minimum of %9.3f to a maximum of %9.3f\n", humanMin, humanMax);

    
    
    
  }  // end of main
    
  
  // Fix this stub which just returns zero at first. 
  public static double mean(double[] theData) {
      int numberOfDataPoints = theData.length;
      double total = 0;
      for(int i=0;i<numberOfDataPoints;i++)
      {total=total+theData[i];
      }
      
      
      
      return total / numberOfDataPoints;
     
  } // end of method
  
  
   // Fix this stub which just returns zero at first. 
  // It is supposed to count how many items are outside the allowed range. 
  // which in this case will be from 990.0 to 1010.0 Ohms. 
  public static int numberOutsideTolerance(double[] theData, double minAllowed, double maxAllowed) {
      int numberOutsideRange = 0;
      // Use a for loop to check if each resistor is in range.
      // Add code here. 
     int numberOfDataPoints = theData.length;
     
      for(int i=0;i<numberOfDataPoints;i++)
      {
         
          if(theData[i]>maxAllowed || theData[i]<minAllowed)
          {
              numberOutsideRange++;
          }
      }
      
      return numberOutsideRange;
     
  } // end of method
  
  
  
  
// c1. Add a min method here. 

  public static double min(double[] theData) 
  {
       double minValue =9999999;
       int numberOfDataPoints = theData.length;
        for(int i=0;i<numberOfDataPoints;i++)
      {
         
          if( theData[i]<minValue)
          {
              minValue=theData[i];
          }
      }
      return minValue;
  }
  
  
  
  
  
  
  
 // c2. Add a max method here. 
   
  public static double max(double[] theData) 
  {
       double maxValue = 0;
       int numberOfDataPoints = theData.length;
        for(int i=0;i<numberOfDataPoints;i++)
      {
         
          if( theData[i]>maxValue)
          {
              maxValue=theData[i];
          }
      }
      return maxValue;
  }
  
} // end of class
