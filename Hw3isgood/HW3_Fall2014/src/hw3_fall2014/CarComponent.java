
package hw3_fall2014;


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import java.awt.Color;

/**
   This component draws two car shapes.
*/
public class CarComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
       Color[] paintColor = {Color.RED, Color.BLUE, Color.yellow, Color.green, Color.pink, Color.cyan};  
      for (int i=0;i<6;i++)
        {for (int j=0; j<4;j++)
            {
                int x = 150, y = 100;
                Car car = new Car(10+j*140, 10+i*80); // Indent the car just a tad. 
                
                g2.setColor(paintColor[i]); // Should not affect the tires which are always in black and light gray. 
                car.draw(g2);
             }
        } 
      
      
     /* 
      // Construct and draw the first car. 
      Car car1 = new Car(10, 10); // Indent the car just a tad. 
      g2.setColor(Color.BLUE); // Should not affect the tires which are always in black and light gray. 
      car1.draw(g2);
           
      // Now add a second car near the bottom right of the frame. 
      int x = getWidth() - 130;  // Gets the width of the drawing frame. 
      int y = getHeight() - 70;  // Gets the height of the drawing frame.

      Car car2 = new Car(x, y);
      g2.setColor(Color.red); // All small letters is also fine. Use RED or red. 
      car2.draw(g2);
      
      
      // Now add a third car near the bottom left of the frame.
      Car car3 = new Car(10, y);
      g2.setColor(Color.green); 
      car3.draw(g2);
      
       // Now add a fourth car near the top right of the frame.
      Car car4 = new Car(x, 10);
      g2.setColor(Color.orange); 
      car4.draw(g2);
             
     */
           
 // Comment out all four cars above and draw in the six rows of cars here. 
 // Use for loops.  If you are comfy with arrays, you might use this color array. 
 // Otherwise ignore it. 
      
      
     
  
   } // end of method paintComponent
   
   
   
   
} // end of class


