package hw2_fall2014;

import java.awt.Rectangle;
import java.util.Scanner;


public class HerbGardenDesign {
    
   public static void main(String[] args) {
       
    // Construct a Scanner object named keyboard. 
     Scanner keyboard = new Scanner(System.in);  
     String introMessage = "Build the largest enclosed \"medicinal herb\" garden you can afford.\n";  
     introMessage += "The crop is legal and each foot of secure fencing costs twenty dollars.\n";
     introMessage += "How much can you spend? Legal Max is $1000.00\n";
     
     // The fencing consists of individual one-foot sections that snap together. 
     // So you cannot buy half a foot for example. Only an integer number is allowed. 
     
     System.out.println(introMessage);
     
     double dollarInvestment = 0.00; // Dollars
     
     // Use a while loop to assure a valid investment. Must be non-negative and not exceed 1000 dollars!
     boolean done = false;
     int fenceFootage = 0; // The number of 1-foot fence segments that can be purchased. 
     
     while( ! done)  {
         System.out.print("Enter investment: ");
         dollarInvestment = keyboard.nextDouble();
     
     // First handle the vlaid case. 
     if( ! (dollarInvestment < 0.00 || dollarInvestment > 1000.00)  ) 
     {
             done = true;
             fenceFootage  = (int) (dollarInvestment / 20) ; // Cast to type integer. 
             System.out.printf("Congratulations! You have purchased %d feet of secure fencing from Acme Enclosures.\n", fenceFootage);
             double change = dollarInvestment - fenceFootage * 20;
             System.out.println("Here's your change! $" + String.format("%.2f", change)  );

     } // end of if block
     
     // Sorry, that investment is not valid. 
     else {
         System.out.println("Sorry,  that choice is not valid. ");
         System.out.println("Investment must be positive and not exceed $1000. Try again!");
     } // end of else block
     
     
     } // end of while
     
     
     // Add code to find the biggest rectangular garden possible
     // The for loop below finds the area of all possible enclosures. 
     // Set up some variables here to keep track of the biggest garden. 
     
     
     int maxWidth = fenceFootage/2;
     int height = 0;
     
     // Labels for the columns
     System.out.printf("\n\n%8s %8s %8s", "Width", "Height", "Area" );

     int centerX = 300;  int centerY = 300;  // In pixels
     int resolution = 20; // 20 pixels per foot. 

     for(int width = 0; width <= maxWidth; width++) {
         
         height = (fenceFootage - 2*width)/2;
         
         // Construct the next Rectangle here.          
        int topLeftX = centerX - width*10;  int topLeftY = centerY - height*10; // in pixels!
        Rectangle herbGarden = new Rectangle(topLeftX, topLeftY, width*20, height*20);
         
    int area = getArea( herbGarden );
    // Add some statements here to help find the biggest herb garden. 
    
     System.out.printf("\n%8d %8d %8d", width, height, area );
     } // end of for loop
     
System.out.println("\n\n");

         
         
         
     
     
   } // end of main
    
  
   
 public static int getArea(Rectangle myRectangle)  {
     double area =  myRectangle.getWidth() * myRectangle.getHeight(); // In square pixels
     return (int) area/400; // Convert to square feet and cast as integer.
 } // end of method getArea
 
    
    
} // end of class
