/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7_fall2014;


public class Alphabet {
    
// Note this time the array indicator [ ] appears after the name "args". Either location is fine. 
public static void main(String  args []) {
    
   char [] smallLetter = new char[26];  // An array to hold all the small letters. 
   char [] capLetter = new char[26];  // An array to hold all the capital letters. 
   char [] digit = new char[10];  // An array to hold all the digits 0 - 9

   
System.out.printf("\fThe capital letters %s-%s have ASCII indices in the range: %d-%d\n" ,   (char) 65, (char) 90 , 65 , 90 );
System.out.printf("\fThe   small letters %s-%s have ASCII indices in the range: %d-%d\n" ,   (char) 97, (char) 122 , 97 , 122 );
   
    
System.out.println("\nFortunately, there is no need to remember these special values as we can always look them up using type casting. "  );
System.out.printf("The ASCII integers representing capital A-Z are in the range: %d-%d.\n",  (int)  'A',  (int)  'Z' );
System.out.printf("The ASCII integers representing   small a-z are in the range: %d-%d.\n",  (int)  'a',  (int)  'z' );
System.out.printf("And the ASCII integers representing the digits 0-9 are in the range: %d-%d.\n" ,  (int)  '0' , (int)  '9' );

// Now let's use  type conversion to initialize the array of capital letters.  
       
int numberOfLetters = 26; // there are 26 letetrs in the English alphabet. 
int numberOfDigits = 10; // there are 10 digits base 10.

for(int i = 0; i< numberOfLetters; i++)  
    {   capLetter[i] = (char) ( 'A'+i); 
      smallLetter[i] = (char) ('a'+i); 
   } // Stuff the arrays with all the letters.

for(int i = 0; i< numberOfDigits; i++)  
    {   digit[i] = (char) ( '0'+i); 
   } // Stuff the array with all the digits

System.out.println("\nThe capital letters are: " + toString(capLetter)  );
System.out.println("\nThe   small letters are: " + toString(smallLetter)  );
System.out.println("\nThe digits in base 10 are: " + toString(digit)  );

// a. Sobriety Test!
// You have been stopped by the Highway Patrol at a Sobriety Check. Have you been drinking? 
// The officer is suspicious and asks you to say the entire alphabet backwards from Z to A to see if you are as sober as you claim. 
// You must use conversion of types.  
System.out.println("\nPart a: Sobriety Test" );

System.out.println("\nOfficer: Recite the letters of the alphabet backwards! Let's see if you are sober or not! " );
System.out.println("Driver:  No problem officer." );

char [] backwardsAlphabet = new char[26];  

// Add code here to populate the letters in reverse order. Use a minus sign in a for loop !

for(int i = 0; i< numberOfLetters; i++)  
    {   backwardsAlphabet[i] = (char) ( 'Z'-i); 

   } 


System.out.println("Driver:  The letters in backwards order are:\n\t" + toString(backwardsAlphabet)  );
System.out.println("Officer: Great, have a pleasant evening!" );



// Part b. Capital Consonants

// Create a new array named capConsonant that contains just the 21 capital consonants and skips the vowels A, E, I, O and  U.  
// Treat Y as a consonant. Use a for loop, that goes from 0 to 25. 
// Add an if statement to test if the generated letter is a vowel. If it is, don't add it. Skip and move to the next index. 
//  
System.out.println("\n\n\nPart b: CONSONANTS" );

char [] capConsonant = new char[21];
int count=0;
// Add code here. 
int indexForConsonant = 0;
for(int i = 0; i < numberOfLetters ; i++)  // Generate all 26 letters. 
  { // Add code here inside the for loop. 
    // Generate the letters from A to Z
   
    char nextLetter=(char) ( 'A'+i);
    // Do nothing if the letter is a vowel.
   	
   boolean isVowel = nextLetter=='A' || nextLetter=='E' || nextLetter=='I' || nextLetter=='O' || nextLetter=='U';
    // If it is a consonant, place it in the array and increment the counter for the consonants named indexForConsonant.   
      if(isVowel==false)         
      { 
      capConsonant[count]=nextLetter;
      count++;
      }
  } // end of for loop

// Print out the consonants using the toString method to help. 

System.out.println("The consonants (all capitalized) are:\n\t" + toString(capConsonant)  );





// Now let's explore some other ASCII charaacters. 
System.out.println("\n\nHere are the characters with int values from 0 to 999."  );
int N1 = 0;  int N2 = 0; // Change these both to zero to supress the character dumps. 
// Default values were N1 = 1000 and N2 = 10000

for(int i = 0; i< N1; i++)  
    {   char nextCharacter = (char) (i); 
        if( (i%10) ==0) System.out.println(""); // Start a new line after every 10 conversions

    System.out.printf("\t%3d --> [%s]", i, nextCharacter);
   } // end of for loop

System.out.println("\n\nHere are the first 10000 characters all compressed together."  );


for(int i = 0; i< N2; i++)  
    {   char nextCharacter = (char) (i); 
        if( (i%100) ==0) System.out.printf("\n%4d: ", i); // Start a new line after every 100 conversions

    System.out.print( nextCharacter );
   } // end of for loop


System.out.println("\n\nYou can copy any character(s) and use them like this: - - - - ▀▁▂▃▄▅▆▇█▉▊▋▌▍▎▏▐░▒▓▔▕▖▗▘▙▚▛▜▝▞▟■□▢▣▤▥▦▧▨▩▪▫▬▭▮▯");

}   // end of main  
     
    
    
   // A custom toString method so we can easily print out a char array.  
    public static String toString(char[] myCharArray) {
        String result = "{"; // Start with an opening brace.
                
        int numberOfElements =  myCharArray.length;
        String suffix = null;
              for(int i = 0; i < numberOfElements; i++)  
              {   suffix = (  i!=(numberOfElements-1)  ) ? ", ": "}"; // Each char is followed by either ", " or "}" if it's last.
                  result += myCharArray[i] + suffix; }
        return result;
    } // end of method
    
    
   
    
    
} // end of class
