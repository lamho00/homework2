
package hw7_fall2014;

public class AnimalElection {
    
 public static void main(String[] args) {
     
 // Note how the array marker [ ] can be in either of two places, - before or after the name. 
String [] vote = { "Pig", "Wolf", "Pig", "Pig", "Sheep", "Sheep", "Sheep" , "Sheep" , "Skunk", "Skunk",  "Chupacabra" };  // Contains repetitions 
    
String candidatesFullName [] = {"Mr. Wolf", "Mrs. Pig", "Miss Sheep", "Mademoiselle Skunk", "Count Chupacabra" };    // Contains no repetitions
 
String message = "The full names (including titles) of the candidates are: ";
print(candidatesFullName, message, true);


// Ouch! The names on the ballots and on the official election registry are slightly different. 
// We will have to handle this carefully, by dropping the title from each name. 
// That is we will need to drop the titles Mr., Mrs., Miss, Mademoiselle and Count. 

//1. Using a for loop, create a String [], holding just each candidates's last name. 

int numberOfCandidates = candidatesFullName.length;  // Use length instance variable to size the array correctly. 
String []  candidatesLastName  = new String [ numberOfCandidates ] ; 

for ( int i = 0; i < numberOfCandidates; i++ )    
    {String fullName = candidatesFullName[i];  // We can find each element using array indexing!
       // We need to extract the title from each candidate. 
     String lastName = fullName.substring( fullName.indexOf(" ")+1   );  // We can find each element using array indexing!
     candidatesLastName[i] = lastName;
    
    
    } // end of for block

// 2. OK, print out just the last names for each candidate. 
message = "\nThe last names of the candidates are: " ;
print(candidatesLastName, message, true);

// We can also print out the last names all on one line. 
message = "\nHere are the last names of the candidates conveniently all in one line. " ;
print(candidatesLastName, message, false);
System.out.println("\nELECTION RESULTS ARE IN!!");

 
// 3. It's time to count the votes!
// Note we also use an enhanced for loop here! 

for(String candidate : candidatesFullName)  {
   int numberOfVotes = count(vote,    candidate.substring( candidate.indexOf(" ")+1)  ); // We need to grab just the last name again. 
   String pluralSuffix = ( numberOfVotes!=1 )  ? "votes" : "vote"; // Decide if we need to use "vote" in the singular or plural. 
   
  System.out.printf("\t%s has received %2d %s.\n", candidate , numberOfVotes, pluralSuffix);

} // end of enhanced for loop



// c. Help Count Chupacabtra steal the election. 
// First complete the replace() method below. 

// i. In the array named vote, replace every vote for Skunk with a vote for Chupacabra. 
// Add code here.


// ii. In the array named vote, replace every vote for Pig with a vote for Chupacabra. 
// Add code here.

// Output the new election results after Count Chupacabra's blatent theft of the election. 
System.out.println("\nTAMPERED ELECTION RESULTS!!");
// Add a for loop here to printout the new (tampered) results. 





}   // end of main 
 
 
 
 // A method that takes an array for its explicit parameter.
 // The boolean option allows you to specify whether each element is printed on a separate line or not. 
 public static void print( String[] theStringArray , String message, boolean printOneELementPerLine) {
      int numberOfElements = theStringArray.length; 
      System.out.println( message );
     if( printOneELementPerLine ) {
         
         for(int i = 0; i < numberOfElements; i++)  {System.out.printf( "\tElement %2d:  %s\n", i, theStringArray[i] );}
     }
     
     // or print them ALL on one line. 
     else{   System.out.print( "\t{" ); // Type a { to start the printout of the array.
             String suffix = null;
              for(int i = 0; i < numberOfElements; i++)  
              {   suffix = (i!=(numberOfElements-1)) ? ", ": "}\n";
                  System.out.printf("%s"+suffix,  theStringArray[i] ); }
              

     } // end of else block
     
 } // end of method
 
 
 
 // * * * * * * a. Fix this stub method. Now, it always just returns zero!
 
 // A method that counts the number of times a String array contains a given testWord. 
 public static int count( String[] theStringArray , String itemToCount) {
      int numberOfElements = theStringArray.length; 
      int theCount = 0; // Number of times item has been found as an element in the array. 
      
      // Add missing code here. A for loop would be a great way to update the count variable. 
      // For now, it just returns zero!
      
      
      
      
    return theCount;
 } // end of method
 
 
// * * * * * * b. Fix this stub method. 
 // Find every occurrence in the Array of the String target, and replace it with the String replacement. 
// This is a wicked method to help Count Chupacabra steal the election. 
// So far, this stub does nothing!
 
 public static void replace(String[] theArray, String target, String replacement)  {
   int N =   theArray.length; // NUmber of elements in the array. 
   // Add a classical for loop here. 

   
   // Check each element using the array index of the for loop. 
   // If the element equals the target, replace it!

      
   
   
     
 } // end of replace method
 
    
} // end of class
