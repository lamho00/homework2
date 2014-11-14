
package hw7_fall2014;


public class Turkey {
    
public static void main(String [] args) {
    
// Happy Thanksgiving!
    
String turkey = "" + 
"                                      XXXX"+     // Row 0
"\n                             #####   X:::XX"+ // Row 1
"\n                            ###########:::XX XXXXX"+  // Row 2
"\n                            ###########::::XXX:::XX"+
"\n                    XXXXXXX ###########*:::XX:::::XX"+
"\n                    X::::::X############***X**:::::X"+
"\n                   XX:::::*:#############**X***::::X"+
"\n                   X:::*****#############::X::***:X  XXXXXX"+
"\n            XXXXXXXX::***::X##############:X::::**XXXX::::XX"+
"\n            X::::::XX***::::##################:::*X**::::::X"+
"\n            X:::::::X:::::::##################:::XX****::::X"+
"\n            X:::****XX::::### XXXXXXXX   X ##::::X::****:::X"+
"\n            X:::***::X::#### X   XXXX    X #:::::X:::****::X"+
"\n            X:*****::X##### XX    XXX o  X::::::XX::::****XX"+
"\n      XXXXXXXX***:::::X:::::XX  o XXXXX  X:::::XX:::::::*XXXXXXXXX"+
"\n     XX:::::*X**::::::XX::::XX  XX   XXXX:::::XX::::::::XX*::::::X"+
"\n    XX::::::*XXX:::::::XX::::XXXX     XX::::::X::::::::XX***:::::X"+
"\n    X:::::****:X::::::::XX::::XX       XX::::XX::::::::X::***::::X"+
"\n    XX::::**:::XX::::::::X:::XXX       XXX::XX:::::::XXX:::***::XX"+
"\n     XX::***:::::XX::::::XX::XXXXXXXXXXXXX:XX:::::::X::::::***:XX"+
"\n      X::***::::::XX::::::XX::XXX     XX::XX:::::::XX::::::***XX"+
"\n      XXX:**:::::::XX::::::XX::XXXXXXXXX::XX:::::XXX:::::::*XXXXX"+
"\n         X**::::::::XX::::::XX::XX:::XX::XXX::::XX:::::::::XX:::XX"+
"\n  XXXXXXXXXX::::::::XXX::::XXXXXX:::XX::X::::XXX::::::XXXXX***:::XXX"+
"\n   X::::***:XXX::::::::XXXXXX***X::::X****XXXXX::::::XXX:::::***::::X"+
"\n   X:::***::::XXXXXX:::::XX****XXXXXXX*****XXX:::XXXXX:::::::***::::X"+
"\n   X:::***:::::::::XXX:::XX****************XXXXXXX:::::::::::****:::X"+
"\n   X:::***:::::::::::XXXXXXX**************.XXXX::::::::::::::***::XXX"+
"\n   XX::***::::::::::::XX   X*************..X  X::::::::::::::***:X"+
"\n    XXX:**::::::::::::XX   XX***********..XX  XXX::::::::::::XXXXX"+
"\n      XXXX::::::::::::X     X***********..X    XXXXXXXXXXXXXXX:XXX"+
"\n     XXXXXXXXXXXXXXXXXX     X***********..X     XXXXX::::::::***:XXXX"+
"\n    XX:***::::::::XXXX      XX*******....XX        XX:::::::::***:::X"+
"\n   XX::***::::::XXXX         XXX........XX      XX  X:::::::::***:::X"+
"\n   X:::***::::::X      X        XXXXXXXXX        XXXXX:::::::***::::X"+
"\n   X:::***::::XXXXXXXXXX      XX              X     XXXX:::::**:::::X"+
"\n   X::::***::XX:X             X               XXXX XXX:XXX::***::::XX"+
"\n   XXXX:::*XXX::XXX   XXXXX XX:X  X  X  XXXXXX   XXXX:::::XXXXXXXXX"+
"\n       XXXX::::::XXXXXX  X  X::XXXXXXXXXX XX XX    XX::::::*XXX"+
"\n         X:**::::::X    XX XX::::::::::::::X  XXXXXX:::::::**:X"+
"\n        XX***::::::XXXXXXXXX:::::::::::::::XXXXXXX::::::::***:XX"+
"\n       XX::***::::::::XXX::::::::::XXXX.X:::::XXX::::::::****::XX"+
"\n       X::::***:::::XXXXXX:::X::::::XXXXX::::XX XXX::::::***::::X"+
"\n       X::::****:::XX    X:::XXX.X.X::::::::X     XXX:::***:::::X"+
"\n       XX::::::XXXXX     XXXX::XXXXX::::::XX        XXXX*::::::XX"+
"\n        XX:::XXX            XXX:::::::::XX             XXXXXXXX"+
"\n         XXXX                 XXXXXXXXXXX                 XX"+
"\n                               X..X X..X"+
"\n                               X.XX XXXX"+
"\n                               X.X   XX"+
"\n                               XXX   XXX"+
"\n                       XXXX   X.X    X..X   XXX"+
"\n                     XXXXXXXXXX.X    X..XXXXXXXXXX"+
"\n                     X...XXXX...X    X...XX......X"+
"\n                     XXXXX..XXXXX    XXXXXXXXXXXXX"+
"\n                         XXXX             XXXXX"+
"\n                          X                 X";

System.out.println("Happy Thanksgiving!");
System.out.println("Here's your free turkey!\n\n");
System.out.println(turkey);

    
 // Find the number of rows in the  ASCII image for the turkey. 
// Our method just counts the numebr of newLine characters. 
 int numberOfRows = numberOfRows(turkey);
 System.out.printf("\nThe  turkey image has a total of %d rows.\n", numberOfRows );
    
 
 // Convert the big long String with the turkey image into a more convenient String array. 
 // Stuff the entire turkey into the new array.
 
  String[] turkeyArray = new String[numberOfRows]; // This will be just the right size to hold each row. 
 
 String row = ""; int rowNumber = 0; // Start with the first row of the image. 
 char newLine = '\n';
 for (int i = 0; i < turkey.length() ; i++)
 {  char nextCharacter = turkey.charAt(i);
    if(  nextCharacter != newLine)  {row+=nextCharacter;}
    else{ // Place the finished row into the array. 
          turkeyArray[rowNumber] = row;
        // Start a new row. 
        rowNumber++; row = ""; // Wipe out the previous row info. Start fresh!
    
    } //  end of else block
   } // end of for loop

 
 
 
 // Print out the new String array. Does it still look like a turkey?    
 System.out.println("\nHere is the same turkey image using the String array!\n"); 
 for(String oneLine : turkeyArray)   { System.out.println(oneLine); }
    
    
 // The big problem, before we can create the mirror image, is that the rows do not hold the same number of characters. 
 
 // To see this let's print out the number of characters in each row. 
 // This time we'll use the classical for loop. 
 
  System.out.println("\nThe rows in the turkey image do not have the same length!" ); 
  for(int i = 0; i<turkeyArray.length; i++)   
  {   if(i%5 == 0) {System.out.printf("\n%3d\t", i);  }
      System.out.print( "\t" +turkeyArray[i].length() ); 
  }

 
         
        
  // To fix this, we need to find the maximum length of a row, and pad all the other rows with trailing spaces, so they all have the same length.   
  // Then we can reflect just by flipping each row from right to left!
 
 int maxLength = 0; // This will hold the length of the longest row in the image. 
 for(String oneLine : turkeyArray)   { if (maxLength < oneLine.length() ) {maxLength = oneLine.length();}  }
 System.out.printf("\nThe longest row in the turkey image has %d characters.\n", maxLength); 

 // OK, now pad each row with trailing spaces so they all have the same width of maxLength. 
 System.out.println("\nNext we'll pad them all with trailing spaces so they all have this same length." ); 
 for(int i = 0; i < turkeyArray.length; i++)   
      {  
          while(turkeyArray[i].length()< maxLength ) 
              { turkeyArray[i] += " "; }  // Add trailing spaces on the right until each row has teh same length
      }

  
 System.out.println("\nAwesome! Now the rows in the image all have the same length!" ); 
  for(int i = 0; i<turkeyArray.length; i++)   
  {   if(i%5 == 0) {System.out.printf("\n%3d\t", i);  }
      System.out.print( "\t" +turkeyArray[i].length() ); 
  }
 
  
  // * * * * REVERSED IMAGE
  
 System.out.println("\n\nNow we can easily print out a mirror image of the holiday turkey!"); 
 System.out.println("Here we see the turkey's doppelgänger! Gobble, gobble!!\n"); 

 for(String oneLine : turkeyArray)   
 {   String reversedLine = "";
     String goodLine = "";
     for(int i=oneLine.length()-1; i>=0; i-- ) 
     { 
         reversedLine+=oneLine.charAt(i);           
     }
     for(int j=0;j<=oneLine.length()-1;j++)
         { 
             goodLine+=oneLine.charAt(j); 
         }
     System.out.println(reversedLine+"\t\t"); 
     System.out.println(goodLine); 
     
 }
// * * * * Doppelganger * * * *
// Add code here to print out both images side by side, separated by two tabs. 
  
 
 
}   // end of main




  

// A method to count the number of rows or newline characters in an ASCII String image,
// which consists of a single long String for the entire image. 

public static int numberOfRows(String myASCII_Art) {
    
int numberCharacters =   myASCII_Art.length();  // Total number of characters in all the rows combined. 
int numberRows = 0; // Let's get ready to count the '\n' characters.   
char newLine = '\n'; // Note the use of single quotes since this is a char, not a String. 

for(int i = 0; i < numberCharacters; i++)  {
    char nextCharacter = myASCII_Art.charAt(i);
    if( nextCharacter==newLine ) {numberRows++;}
} // end of for loop


return numberRows;
} // end of method  



  
    
} // end of class
