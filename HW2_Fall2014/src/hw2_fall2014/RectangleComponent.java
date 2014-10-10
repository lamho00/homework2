/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2_fall2014;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D; // Added to draw the center point. 
import javax.swing.JComponent;

import java.awt.Color;

/*
   A component that draws two rectangles. From your text.
*/
public class RectangleComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;

      // Construct a rectangle (herb garden) and draw it
      // All gardens will be centered on the point (300,300) in pixels. 
      int centerX = 300;  int centerY = 300; // In pixels, not feet.
      int resolution = 20; // 20 pixels per foot. 
      
      
      // Use a for loop to show the possible herb gardens using 40 of the 1-foot fence segments. 
      int maxWidthInFeet = 20;
      
      for(int width = 0; width <= maxWidthInFeet; width++)  {
                 int height = maxWidthInFeet - width;  
        
                  if(width ==height) {g2.setColor(Color.RED);}   // Draw the square in red. It's special!
                  if(width > height) {g2.setColor(Color.BLUE);}  //  Wide rectangles
                  if(width < height) {g2.setColor(Color.GREEN);}  // Tall and narrow rectangles.

        int topLeftX = centerX - width*10;  int topLeftY = centerY - height*10; // in pixels!
        Rectangle herbGarden = new Rectangle(topLeftX, topLeftY, width*20, height*20);
        g2.draw(herbGarden);

     
      } // end of for loop
      
// Draw some text messages.
g2.setColor(Color.BLACK);
g2.drawString("Possible rectangular herb gardens using available fencing.", 5, 40);
g2.drawString("Which has the greatest area?", 5, 60);

// Add the message in red here. Use setColor()
// The square garden shown in red, will grow the most herb.





// Draw the center point (300,300) here using an ellipse in magenta. 
// Use the fill command so the dot is solid. First construct a 2D Ellipse. 





   }
} // end of class

