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
     
    private static int coin[]= {1,5,10,25,50,100};
    private static int bill[]= {1, 2, 5, 10, 20, 50, 100, 500, 1000, 5000, 10000, 100000 };
    private static  String[] coinPerson = {"President Abraham Lincoln", "President Thomas Jefferson", "President Franklin D. Roosevelt",
        "President George Washington", "President John F. Kennedy", "President Dwight D. Eisenhower from 1971 to 1978" }; 
    private static  String[] billPerson = {"President George Washington","President Thomas Jefferson","President  Abraham Lincoln",
        "President  Alexander Hamilton","President Andrew Jacksonn","President Ulysses S. Grant","Benjamin Franklint","President William McKinley"
        ,"President Grover Cleveland","President James Madison","President Grover Cleveland","President Woodrow Wilson","Does not exist - only promotional bills "};
    private static int RealAnswer;
    private static boolean isPaperBill;
    private static  String userInput;

     
     
    public static void  randomAnswer(){ //Create a random answer
        Random r = new Random(); //Create a random # generator   
        isPaperBill=r.nextBoolean(); //random coin or bill.
        if (isPaperBill==false){RealAnswer=r.nextInt()*6;}//random coin value0-6          
        else  { RealAnswer=r.nextInt()*12;}//random coin value0-6          
    }//end of method randomAnswer
     
    public static boolean checkAnswer(String input){ 
        boolean correctAnswer=true; 
        if(isPaperBill==true){
            correctAnswer=(input.equals(billPerson[RealAnswer]))?true:false; 
        } 
        else{correctAnswer=(input.equals(coinPerson[RealAnswer]))?true:false;}
        return correctAnswer;
    }//end of method checkAnswer
     
    public static void question(){ //Create a question
        String BillOrCoin=(isPaperBill==true)?" dollar bill":" cent coin";
        int value =(isPaperBill==true)?bill[RealAnswer]:coin[RealAnswer];
        System.out.printf("What is the person on the"+value+BillOrCoin+"?"); 
    }//end of method question        
     
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
         frame.setVisible(true); 
         randomAnswer();
         question();

    }//end of main
    
    

    
   
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
