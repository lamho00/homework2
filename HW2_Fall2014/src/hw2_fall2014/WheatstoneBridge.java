/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2_fall2014;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon; // Used to show the image of the Wheatstone bridge
import javax.swing.JOptionPane; 

/**
 *
 * @author robincarr
 */
public class WheatstoneBridge {

   // See this Wikipedia article:  http://en.wikipedia.org/wiki/Wheatstone_bridge
     
   // The unknown resistor Rx is defined randomly below. 
   // First we must construct a random generator. 
   
    // A Wheatstone bridge has four resistors. 
    private double R1;
    private double R2;  // The variable resistor.
    private double R3;
    private double R4;  // The unknown resistor.
    
    
    // Constructor to build a bridge!
    WheatstoneBridge(double r1, double r2, double r3, double r4)  {R1 = r1; R2 = r2; R3 = r3;R4 = r4;}
    
   // Mutators
   public void setR1(double r) {R1 = r;}
   public void setR2(double r) {R2 = r;}
   public void setR3(double r) {R3 = r;}
   public void setR4(double r) {R4 = r;}
    
    
   
   public static void main(String[] args) {
       
   ImageIcon bridgeIcon = new ImageIcon(   "images/WheatstoneBridge4.png"  );
   ImageIcon variableResistorIcon = new ImageIcon(   "images/VariableResistor.gif"  );
   ImageIcon awardIcon = new ImageIcon(   "images/Award.jpg"  );

   String title = "Wheatstone Bridge";
        
   printIntroduction();  
   
   // Let's build our Wheatstone bridge!
   Random randomGenerator = new Random(12345678910L); // Note the seed is a long!
   int Rmin = 1000;     int Rmax = 100000;    int range = Rmax - Rmin;  // Possible range for the unknown resistor. 
   double R_Unknown =   Rmin + randomGenerator.nextInt( range +1 ); // Could be anywhere Rmin up to Rmax. 
   double R_Variable = 1000.0;  // Starter value for R2. Will be adjusted until balanced.  
   
   double R1 =  1000.0;  // Known resistor =  One Kilo-Ohm
   double R3 =  5000.0;  // Known resistor = Five Kilo-Ohms
   WheatstoneBridge myBridge = new WheatstoneBridge(R1,  R_Variable, R3, R_Unknown);
   double voltage = myBridge.bridgeVoltage();
   
    boolean done = false;
   // Now you must find the unknown resistor by adjusting the variable resistor R_Variable.   (also called R2) 

   /* Set tolerance to one microvolt! You should be able to get the unknown resistance exactly, 
    * by adjusting the variable resistance to one tenth of an Ohm. 
    */
    double tolerance = 0.000001;  // Must be this close to consider the bridge balanced. 
    
    Scanner keyboard = new Scanner(System.in);
    while( ! done )  {
      
        String adjustVariableResistorMessage = "\nThe voltage across the galvanometer is " + String.format("%.6f",voltage) + " when the variable resistor is " + String.format("%.2f",R_Variable) + "\n";  
        adjustVariableResistorMessage += "Enter a new value for the variable resistor to balance the bridge.";
        // showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue)
        String variableResistor = (String) JOptionPane.showInputDialog(null, adjustVariableResistorMessage, "Adjust the Variable Resistor", JOptionPane.DEFAULT_OPTION, variableResistorIcon, null, null);  
        // JOptionPane.INFORMATION_MESSAGE   DEFAULT_OPTION
        R_Variable = Double.parseDouble(variableResistor); 
        
        
        // System.out.printf("\nThe voltage across the galvanometer is %f when the variable resistor is %f\n",  voltage, R_Variable);
        // System.out.println("Enter a new value for the variable resistor to balance the bridge.");
        // System.out.print("New value for R_Variable: ");
        // R_Variable = keyboard.nextDouble(); // Adjust the variable resistor R2!
        myBridge.setR2(R_Variable);
        voltage = myBridge.bridgeVoltage(); // Update the voltage
        
        if( -tolerance < voltage  && voltage < tolerance )  
            {done = true;
             title = "Wheatstone Bridge";
             String awardMessage = "CONGRATULATIONS!!\n\nThe unknown resistance is " + String.format("%.2f",myBridge.R4) + " Ohms.\n\n\n";
             awardMessage += "The balanced Wheatstone Bridge gives a value of " + String.format("%.2f", myBridge.R3 * myBridge.R2 /myBridge.R1) + " Ohms.\n";
             JOptionPane.showMessageDialog(null, awardMessage, title, JOptionPane.INFORMATION_MESSAGE, awardIcon);  

                System.out.printf("The unknown resistance is %.2f Ohms.\n", myBridge.R4);
                System.out.printf("The balanced Wheatstone Bridge gives a value of %.2f Ohms.\n", myBridge.R3 * myBridge.R2 /myBridge.R1);
            }
    } // end of while loop to balance the bridge.
     
        
    } // end of main
    
    
    
    public static void printIntroduction() {
        String introductionMessage;
        introductionMessage = "Find the unknown resistor by adjusting the variable resistor until the bridge is balanced.\n";
        introductionMessage += "The bridge is balanced, when the voltage is zero.\n";
        
        ImageIcon bridgeIcon = new ImageIcon(   "images/WheatstoneBridge4.png"  );
        String title = "Wheatstone Bridge";
        JOptionPane.showMessageDialog(null, introductionMessage, title, JOptionPane.INFORMATION_MESSAGE, bridgeIcon);  

        System.out.println("WHEATSTONE BRIDGE");
        System.out.println("Find the unknown resistor by adjusting the variable resistor until the bridge is balanced.");
        System.out.println("The bridge is balanced, when the voltage is zero.");  
        
    } // end of method
    
    
    
    public  double bridgeVoltage() {
       double voltageSource = 6.0; // Apply six volts!
       double voltageGalvanometer = voltageSource * ( R2 /(R1 + R2)   - R4 / (R3 + R4)  ); 
       return voltageGalvanometer;
    } // end of method
    
} // end of class
