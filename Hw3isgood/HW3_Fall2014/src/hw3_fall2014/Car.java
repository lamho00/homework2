package hw3_fall2014;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.awt.Color;

/**
   A car shape that can be positioned anywhere on the screen.
*/
public class Car
{
   private int xLeft;
   private int yTop;

   /**
      Constructs a car with a given top left corner.
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
   */
   public Car(int x, int y)
   {
      xLeft = x;
      yTop = y;
   }

   /**
      Draws the car.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
           
   {  int unit = 20; // Added by Dr. C to allow scaling later. Default value is 20.
   
      Rectangle body = new Rectangle(xLeft, yTop + unit, 6*unit, unit);      
      Ellipse2D.Double frontTire 
         = new Ellipse2D.Double(xLeft + unit, yTop + 2*unit, unit, unit);
      Ellipse2D.Double rearTire 
         = new Ellipse2D.Double(xLeft + 4*unit, yTop + 2*unit, unit, unit);
    Ellipse2D.Double frontTireHubCap 
         = new Ellipse2D.Double((xLeft + unit)+unit/2-unit/6, (yTop + 2*unit)+unit/2-unit/6, unit/3, unit/3);
      Ellipse2D.Double rearTireHubCap 
         = new Ellipse2D.Double((xLeft + 4*unit)+unit/2-unit/6, (yTop + 2*unit)+unit/2-unit/6, unit/3, unit/3);
      
      // The bottom of the front windshield
      Point2D.Double r1 = new Point2D.Double(xLeft + unit, yTop + unit);
      // The front of the roof
      Point2D.Double r2 = new Point2D.Double(xLeft + unit*2, yTop);
      // The rear of the roof
      Point2D.Double r3 = new Point2D.Double(xLeft + unit*4, yTop);
      // The bottom of the rear windshield
      Point2D.Double r4 = new Point2D.Double(xLeft + unit*5, yTop + unit);

      Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
      Line2D.Double roofTop = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
   
      g2.draw(frontWindshield);      
      g2.draw(roofTop);      
      g2.draw(rearWindshield);  
      g2.draw(body); // Adjust the body so it is filled.
      g2.fill(body);
      

      // Adjust the tires so they are always filled in black. 
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontTireHubCap);
      g2.draw(rearTireHubCap);
      
      g2.setColor(Color.black);
      g2.fill(frontTire);
      g2.fill(rearTire);
      
      g2.setColor(Color.lightGray);
      g2.fill(frontTireHubCap);
      g2.fill(rearTireHubCap);

      // Add smaller ellipses here to represent the frontHubcap and rearHubcap. 
      
     
      
      // Fill the hubcaps in light gray here. 
       
      
      
      
   } // end of draw method
} // end of class
