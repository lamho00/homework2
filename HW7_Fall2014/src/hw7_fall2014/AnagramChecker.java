
package hw7_fall2014;


import javax.swing.JOptionPane; // Adjust program to allow dialog windows. 
import javax.swing.JTextArea; //  <-- New!!! Used later to help create a monospaced display. 
import java.awt.Font;        // <-- New!! Needed for font control later
import java.util.Scanner;    // You won't need this import in the modified program. 


public class AnagramChecker
{
public static void main(String[] args)
{ // Enter two phrases to test if they are anagrams. 
    
Scanner keyboard = new Scanner(System.in);   
String message = "* * * ANAGRAM CHECKER * * * \nThis program checks if two phrases are anagrams.\n";    
message += "Enter the first phrase to test. Example: Western Union";


//System.out.println(message);
//System.out.print("First Phrase: ");
//String phrase1 = keyboard.nextLine();

JOptionPane.showMessageDialog(null, message);
String phrase1 = JOptionPane.showInputDialog("First Phrase: ");
   
message = "Enter the second phrase to test. Example: No Wire Unsent Union";
 
//System.out.println(message);
//System.out.print("Second Phrase: ");
//String phrase2 = keyboard.nextLine();

JOptionPane.showMessageDialog(null, message);
String phrase2 = JOptionPane.showInputDialog("First Phrase: ");


// Convert to capital letters. 
phrase1 = phrase1.toUpperCase();  
phrase2 = phrase2.toUpperCase(); 

int [] tally1 = tallyEachLetter(phrase1);	
int [] tally2 = tallyEachLetter(phrase2);	

// Compare the tallies for all 26 letters A-Z
boolean areAnagrams = true;
for ( int letter = 1; letter <= 26; letter++)
		if ( tally1[letter] != tally2[letter] )  areAnagrams = false;

// Output the results both at the keyboard and in a Message Dialog
String message3 = "\nYes! The phrases " + phrase1 + " and " +phrase2 + " are anagrams!\n";
String message3no = "\nNo! The phrases " + phrase1 + " and " +phrase2 + " are not anagrams!\n";

if ( areAnagrams )
    {System.out.printf("\nYes! The phrases %s and %s are anagrams!\n",phrase1, phrase2);
     JOptionPane.showMessageDialog(null, message3);
    }
else
    {
    System.out.printf( "\nSorry! The phrases %s and %s are not anagrams.\n", phrase1, phrase2);
     JOptionPane.showMessageDialog(null, message3no);
    message3 = "\nSorry! The phrases " + phrase1 + " and " +phrase2 + " are not anagrams!\n";
    }

String message4 = "\nLETTER:   ? A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
System.out.print(message4);	
message4 += "\nPHRASE1: ";
System.out.printf("\nPHRASE1: ");

for (int count1: tally1) {System.out.printf( "%2d", count1 );   message4 += " " + count1;  }

message4 += "\nPHRASE2: ";

System.out.printf("\nPHRASE2: ");
for (int count2: tally2) { System.out.printf( "%2d", count2 );  message4 +=  " " + count2;}

String finalMessage = message3 + message4;

   JTextArea textArea = new JTextArea(finalMessage); // New!! Construct a JTextArea
   textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
   JOptionPane.showMessageDialog(null, textArea); // Now show the JTextArea with desired mesage. 

System.out.println("\n");


} //end of main method
  





// Definition of the method tallyEachLetter
public static int[] tallyEachLetter(String phrase)  {
  // Non-letters such as spaces and punctuation will be tallied at index 0.
  // The tally for 'A' is at index 1, and so forth to 'Z' at index 26.
  	int[] tally = new int[27];
    int lengthOfPhrase = phrase.length();
    int letterNumber;  //'A' is 1, 'B' is 2 up to 'Z' is 26
    boolean isALetter = true;
  	for ( int i = 0; i < lengthOfPhrase; i++ )  
		{// Tally each letter A-Z. 
		 // Non-letters like spaces, punctuations are tallied at index 0.
		letterNumber = phrase.charAt( i ) - 'A' + 1;
		isALetter = letterNumber >=1  &&   letterNumber <= 26 ;
		if (isALetter)  tally[letterNumber]++;  else tally[0]++;
		}	// end of for loop
	return tally;	
} //end of tallyEachLetter method
  
}  //end of class

