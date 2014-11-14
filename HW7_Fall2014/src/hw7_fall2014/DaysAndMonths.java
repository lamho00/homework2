package hw7_fall2014;


public class DaysAndMonths {
    
 public static void main(String [] args) {
     
  // Intro to arrays   
     
   // * * * * * * * * * *   DAYS   * * * * * * * * * *
     
   // A1. Arrays can be declared and initialized all at once using curly brackets on the RHS. 
     
   String []  day = {"Sunday", "Monday",  "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
   // Singular or plural name? Rule: Name should match the number for an individual element.
   // So "day" is singular, since each element holds just ONE day. 
   
   // A2. Get the number of elements in an array using the length instance variable.   
   // Note it is not a method so you never type length() for an array, as you would for a String.   
    
   int daysPerWeek = day.length; // Do not use length(), that is do not incude the ( and ). !!!!!
   System.out.printf("There are %d days in one week.\n", daysPerWeek);
     
   
   // A3. Array indexing starts at zero, not 1. 
   // A student's birthday is on Sunday. Use index 0, not 1. 
   System.out.printf("Joe, wishing you a Happy Birthday this %s.\n", day[0]); // Index 0 gives the first element!

   // A4. You can step through all the elements of an array using either a classical or an enhanced for loop. 
   // Change all the names to caps. 
   
   // i. Classical for loop.
   for(int i = 0; i <day.length;  i++ ) 
       {  day[i] = day[i].toUpperCase();    //  Notice the use of array indexing with the square brackets [ ] 
        } // end of for loop
   
   // Let's print them out see if they are all in caps now. 
   // This time, we will use an enhanced for loop 
   
   // ii. Enhanced for loop.
   System.out.println("The days of the week in caps are: ");
   for(String theDay: day ) 
       {  System.out.println("\t" + theDay);    //  Notice the use of array indexing with the square brackets [ ] 
        } // end of for loop
    
   
   
   
// * * * * * * * * * *   MONTHS   * * * * * * * * * *
    
// B1. You can also declare an array, and then initialize each component with array indexing. 
   // Notice also on the LHS, that the array declaration [ ] can go either before or after the name of the variable. 
   // Here it is after, while for days it was before. See above. 
   String month [] = new String[12]; // There are 12 months in the year. 
   month[0] = "January";   // Initialize the first month. 
   month[1] = "Feb"; 
   month[2] = "Mar";
   month[3] = "Apil";
   month[4] = "Mayy";
   month[5] = "Jun";
   month[6] = "July";
   month[7] = "Aug";
   month[8] = "Sep";
   month[9] = "Oct";
   month[10] = "Nov";
   month[11] = "December";
   
   
   
   // Add code here. 
   // a. Add the missing 11 months using [] and not {}.
   
   
   
   // B2. Print out the number of months in one year.

      int monthsPerYear = month.length; // Fix this stub. Must use the length instance variable.  
      System.out.printf("There are %d months in one year.\n", monthsPerYear);
   
    // B3. 
    // A student's birthday is in December. 
    // Print out the message. "Happy birthday in December." Use must use array indexing to get the December name. 
      System.out.printf("Happy birthday in .%s\n", month[11]);

   // B4. You can step through all the elements of an array using either a classical or an enhanced for loop. 
   // i. Change all the month names to caps. 
   // Must use a classical for loop.
    
      for(int i=0; i<monthsPerYear;i++)
      {        
   month[i]=month[i].toUpperCase();
   System.out.printf("%s\n", month[i]);
      }
   
   // B5. Let's print out the month names an d see if they are all in caps now. 
   // This time, use an enhanced for loop 

   // ii. Must use an Enhanced for loop.
      System.out.println("The months of the year in caps are: ");
   // Add code here.
      
    for(String theMonth: month ) 
       {  System.out.println("\t" + theMonth);    //  Notice the use of array indexing with the square brackets [ ] 
        } // end of for loop  
      
      
      
 }    // end of main
    
    
    
} // end of class
