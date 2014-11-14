package hw7_fall2014;

public class PartyInvitations {
    
  public static void main(String [] args) {
      
  System.out.println("Ada wanted to invite all her friends over for a party, but there has been an unfortunate incident.");
   
  String [] friend  = {"Anna", "Brian", "Charlene", "David", "Edward", "Frank", "George", "Harriet"} ; 
   System.out.printf("Before the 'incident', Ada had %d friends.\n", friend.length );

  System.out.println("Here is her array of friends.\n\t" + toString(friend));

  // Oh no! There's trouble!
  // Ada has had a big fight with some friends over a stolen dirt bike. (An ATV)
  // Ada suspects these former friends of helping steal her ATV. They are all kids in the same family.
  
   String [] suspect  = {"Anna", "David", "George"} ; // These three might have her ATV! 
   System.out.println("\nNow Ada thinks these three people stole her dirt bike!\n\t" + toString(suspect));

   // Print out the following party invitation to each of her friends,
   // but do NOT include those she suspects stole her dirt bike!
   // Add code here, to print the following message to each friend who is NOT a suspect. 
   // Use a single classical for loop.  
   // Hi _ _ _. Please come to my party this weekend. 
   
   System.out.println("\n* * * PARTY INVITATIONS * * * ");

   for(int i=0; i< friend.length; i++) 
   {   String nextFriend = friend[i];
       if( ! contains(suspect, nextFriend)   ) 
           { System.out.printf( "Hi %s. Please come to my party this weekend.\n", nextFriend); }
   } // end of for
   
      
  }  // end of class
    
   
 // Returns true, if the array contains the searchTerm. 
 public static boolean contains( String[] myArray, String searchTerm) {
   boolean searchResult   = false;
   for( String element : myArray)  
   {  // Check if the element matches the searchTerm. 
       if( searchTerm.equals(element) ) 
             { searchResult = true;
                break; // Done! We found it!        
              }
       
   } // end of for loop
     
    return searchResult;  // True or false
 }  // end of method
  
 
  // Converts an array to a big long String so it can be printed. 
 public static String toString( String[] myArray) {
    int numberOfElements =  myArray.length;
    String result = "{"; // Start with an opening brace. 
    String separator;
   for( int i=0; i < numberOfElements; i++)  // Step through the array.
   {  // Append each term, separated by a comma and space, except for the last which needs a closing brace. 
      separator = ( i == (numberOfElements-1))   ? "}": ", " ;
      result = result + myArray[i] + separator;
   } // end of for loop
     
    return result;  
 }  // end of method
    
} // end of class
