/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyquiz;
import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.io.*;
import java.util.*;
/**
 *
 * @author Lamho
 */


public class CurrencyQuiz {
    
    
    // INSTANCE VARIABLES
     // The frame and label for the histogram will be accessible anywhere in the program. 
     public static JFrame frame = new JFrame();
     public static JLabel label = new JLabel(  ); // Will show a text message and in Image Icon with the results. 
    

     
     
     
     
     
     
     
     
     
     // This method begins to set up our user interface. 
// Call it first in the main() method. 
    public static void createGUI() {
        
// 1. Set up the frame. 
      int frameWidth = 680, frameHeight = 820; // Size of the frame.
      frame.setSize(frameWidth, frameHeight);      
      frame.setTitle("Benford First-Digit Experiment");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout( new FlowLayout() );    
      
// 2. Add the main label with introductory text and an image of Frank Benford.    
 
    BufferedImage dollarbil500 = readImage( "images/500dollarbill.png" ); 

    label.setIcon(new ImageIcon( dollarbil500) );
   // Now specify the text field for the label. Notice the use of HTML to  format the text!
    
    String message = "<html>Wellcome to currency quiz.<br>This is a $500 bill<br>";

     label.setText( message );
    
    // Position the text of the label to be centered at the bottom of the image.  
      label.setHorizontalTextPosition(JLabel.CENTER);
      label.setVerticalTextPosition(JLabel.BOTTOM);
      frame.getContentPane().add(label );
     
        
    } // end of GUI method
     
     
     
     
     
     
     
     
     
     
    public static void main(String[] args) {
        // TODO code application logic here
         createGUI();   
         String randomAnswer[]=randomAnswer();
       
           System.out.printf(randomAnswer[3]);
          
         
         frame.setVisible(true); 
    }//end of main
    
    
public static String[]  randomAnswer(){
    int answer[]= {0,0};// [value, (0coin) (1bill)]
    
    Random r = new Random(); //Create a random # generator
    
     boolean isPaperBill=r.nextBoolean(); //random coin or bill.
     
     //coins are 1, 5, 10, 25, 50 and 100 for the dollar coin.
    if (isPaperBill==false){
         answer[1]=0;
         double random=r.nextDouble()*6;//random coin value0-6
         
         if(random>5){answer[0]=1;
         }//1 coin
         else if(random>4){answer[0]=5;
         }//5 coin
         else if(random>3){answer[0]=10;
         }//10 coin
         else if(random>2){answer[0]=25;
         }//25 coin
         else if(random>1){answer[0]=50;
         }//50 coin
         else{answer[0]=100;
         }//100 coin
         
         
     }// if it is a coin
    
           
  // Bill denminations include 1, 2, 5, 10, 20, 50, 100, 500, 1000, 5000, 10,000, 100,000 
    else  {
         answer[1]=1;
         double random=r.nextDouble()*12;//random bill value 0-12
         
         if(random>(11)){answer[0]=1;
         }//1 coin
         else if(random>(10)){answer[0]=2;
         }//2 coin
         else if(random>9){answer[0]=5;
         }//5 coin
         else if(random>8){answer[0]=10;
         }//10
         else if(random>7){answer[0]=20;
         }//20
         else if(random>6){answer[0]=50;
         }//50
         else if(random>5){answer[0]=100;
         }//100
         else if(random>4){answer[0]=500;
         }//500
         else if(random>3){answer[0]=1000;
         }//1000
         else if(random>2){answer[0]=5000;
         }//5000
         else if(random>1){answer[0]=10000;
         }//10,000
         else{answer[0]=100000;
         }//100,000 
     };// if it is a bill   
     
     
    String answer2[]= {Integer.toString(answer[0]),Integer.toString(answer[1]),getPerson(answer[0],isPaperBill)};
     
    return answer2;         

     
}//end of method randomAnswer
    
    
    
        public static String getPerson(int denomination, boolean isPaperBill) {
     String person = "Adam"; // A stub default value
     
     String moneyType = (isPaperBill) ? "bill" : "coin";
     
     int value = denomination; // The value of the coin or bill. 
     
      switch(moneyType) {
          
          // See this link for whose on each coin.
          // http://www.marshu.com/articles/presidents-on-us-united-states-coins.php
              
          case "coin": // Valid coins are 1, 5, 10, 25, 50 and 100 for the dollar coin. 
               
              switch(value) { // All values in **cents** for the coin switch.
                  
                  case 1: // Handles the American penny or 1¢ coin. 
                      person = "President Abraham Lincoln";
                      break;
                  case 5: // Handles the American nickel or 5¢ coin. 
                      person = "President Thomas Jefferson";
                      break;
                  
                      
                  // Complete these additional cases for coins.     
                  case 10: // The dime features President Franklin D. Roosevelt 
                         person = "President Franklin D. Roosevelt";
                      break;
                      
                      
                  case 25:  // The quarter or features President Abraham Lincoln. 
                         person = "President George Washington";
                      break;
                      
                  case 50: // President on current Half-Dollar coin is John F. Kennedy
                         person = "President John F. Kennedy";
                      break;
                      
                    case 100: // The dollar coin is unusual. Done for you. 
                        person = "President Dwight D. Eisenhower from 1971 to 1978";
                        person += "\nOther years commemorative. ";

                    default: 
                        person = "Invalid"; // No such coin
                  
              } // end inner switch statement for coins. 
             
              break; // end of the coin cases
             
              
 // * * * Find the  person on each paper bill in this switch stament. 
 case "bill":  
  
  // Bill denminations include 1, 2, 5, 10, 20, 50, 100, 500, 1000, 5000, 10,000, 100,000 
  switch(value) {
                  
  case 1: // Handles the 1 dollar bill.  
                      person = "President George Washington";
                      break;                
                
  case 2: // Handles the 2 dollar bill.  
                      person = "President Thomas Jefferson";
                      break;  
  case 5: // Handles the 2 dollar bill.  
                      person = "President  Abraham Lincoln";
                      break;        
  case 10: // Handles the 2 dollar bill.  
                      person = "President  Alexander Hamilton";
                      break;  
  case 20: // Handles the 2 dollar bill.  
                      person = "President Andrew Jacksonn";
                      break;        
  case 50: // Handles the 2 dollar bill.  
                      person = "President Ulysses S. Grant";
                      break;       
  case 100: // Handles the 2 dollar bill.  
                      person = "Benjamin Franklint";
                      break;   
  case 500: // Handles the 2 dollar bill.  
                      person = "President William McKinley";
                      break;      
  case 1000: // Handles the 2 dollar bill.  
                      person = "President Grover Cleveland";
                      break;     
  case 5000: // Handles the 2 dollar bill.  
                      person = "President James Madison";
                      break;  
  case 10000: // Handles the 2 dollar bill.  
                      person = "President Grover Cleveland";
                      break;      
  case 100000: // Handles the 2 dollar bill.  
                      person = "President Woodrow Wilson";
                      break; 
  case 1000000: // Handles the 2 dollar bill.  
                      person = "Does not exist - only promotional bills ";
                      break;       
  // Add cases here to handle the missing bills. 
  // Must inclue all these missing cases.   5, 10, 20, 50, 100, 500, 1000, 5000, 10,000, 100,000  
  // Start with the 5 dollar bill. Consult the references mentioned agt the top.                
                             
  default:              
             person = "Invalid"; // No such bill
      
    } // Switch statement for paper bills           
              break;          
          default: break;           
      } // end of outer switch - coin or bill.    
     return person;
     } // end of method getPerson  
    
    
    

        
    
    
    
    
    
    
    
    
    
/**
Adds a button to a container. 
@param c the container
@param title the button title
@param listener the action listener for the button
 */
   // -----------------------------Button start------------------------    
public static JButton addButton(Container c, String title, ActionListener listener)
{
JButton button = new JButton(title);
c.add(button);
button.addActionListener(listener);
return button;

} // end of method
  
 // A version for RadioButtons so you can also add them to their ButtonGroup 
// We also return the button in case you wish to alter its settings. 
    public static JRadioButton addRadioButton(Container c, ButtonGroup theGroup, String title, ActionListener listener)
{
JRadioButton radioButton = new JRadioButton(title);


c.add(radioButton); theGroup.add(radioButton);
radioButton.addActionListener(listener);
return radioButton;

} // end of method-----------------------------Buttons End------------------------    
  
// Method to load a background image that catches the possible IOException
   public static BufferedImage readImage(String fileLocation) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileLocation));
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
 
        return img;
 
    } // end of readImage method
    
}//end of class
