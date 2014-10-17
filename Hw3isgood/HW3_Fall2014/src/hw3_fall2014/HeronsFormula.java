/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3_fall2014;

import javax.swing.JOptionPane; // So we can use Message, Option and Input Dialogs.
import javax.swing.ImageIcon;   // To add some nice images!

import java.util.Scanner;   // Optional use of Scanner to enter sides instead. 


// Finds the area of a triangle using Heron's formula. 


public class HeronsFormula {
    
// Add a main method here.   
// Tip: Allow the user to enter a, b and c at the keyboard first and then output the area of the triangle.     
// Then convert the whole program to use JOptionPane instead.    
    
    public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.printf("input a");
      Double a = keyboard.nextDouble();
      System.out.printf("input b");
      Double b = keyboard.nextDouble();
      System.out.printf("input c");
      Double c = keyboard.nextDouble();
      
   }
    
    
    
    
 // Complete this area method. It is just a stub for now.
 
    public static double area(double a, double b,double c) {
    
        double area  = 0.0;
        double P = a+b+c;
        double P4= P/2*(P/2-a)*(P/2-b)*(P/2-c);
        double AA=Math.sqrt(P4);
        // Calculate the correct area here using Heron's formula. 
        
     
        
       return AA; 
    } // end of area method
    
    
} // end of class
