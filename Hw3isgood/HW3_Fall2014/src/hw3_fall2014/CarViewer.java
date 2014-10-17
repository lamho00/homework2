/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3_fall2014;

import javax.swing.JFrame;

public class CarViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      // frame.setSize(300, 400);
      frame.setSize(600, 600); // Let's use a larger frame than in the text.
      
      
      frame.setTitle("Beep Beep Parking Garage");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CarComponent component = new CarComponent();
      frame.add(component);

      frame.setVisible(true);
      
   } // end of main
   
   
} // end of class
