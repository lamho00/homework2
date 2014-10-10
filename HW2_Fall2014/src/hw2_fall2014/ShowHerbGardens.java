/*
 * This example is a modification of an example in chapter 2 of your text. 
 */
package hw2_fall2014;

import javax.swing.JFrame;

public class ShowHerbGardens
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      // Available land is 60 by 60 feet. 
      frame.setSize(600, 600); // Ten pixels per foot. 
      
      frame.setTitle("Enclosed Rectangular Herb Gardens");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      RectangleComponent component = new RectangleComponent();
      frame.add(component);

      frame.setVisible(true);
   } // end of main
   
   
} // end of class