
package hw7_fall2014;

// Practice using nested for loops. 

/**
 *
 * This program reads in an image, and pixelates it 
 * so that the new image is composed of many small rectangles or tiles similar to a mosaic. 
 * This might be useful in an art program or to obscure part of an image say 
 * for a license late or face, that  should remain private. 
 * It could also be used as part of a game to guess a famous person 
 * whose likeness is partially obscured by this technique. 
 * Be sure to focus on all uses of nested for loops, switch statements and if/else statements. 
 * 
 */



import java.awt.Color;
import java.awt.Rectangle;


// import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
// import java.awt.image.ColorModel;

import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;



import javax.swing.JFrame; // Let's also pop up a frame to show the finished image. 
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import javax.swing.JFileChooser;




public class Pixelate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

 
// * * * * * * * * * * * * * * * * * * * * 
//1. Let's get an image loaded in. Choose any of these, or choose your own. 
// This time, let's learn how to pick a file. 
        
JFileChooser chooser = new JFileChooser("./images");

File file1 = null;
if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
      {
          file1 = chooser.getSelectedFile();
      }
 

 
// Load the  selected image.
// We need to catch an IOExeption, in case the file cannot be read. 
BufferedImage sourceImage = null;   // Declaration scope must be outside the try block
try{
     // sourceImage = ImageIO.read(new File(fileName)); 
      sourceImage = ImageIO.read( file1 ); 
    }

catch( IOException e) 
    {   System.out.println("Sorry! The file could not be read. Check the file name is exactly correct!");
        System.exit(0); 
    }    
          
// Report on progress to the console window.   
System.out.println("1. We have successfully loaded the chosen image.");
    
int width = sourceImage.getWidth(); int height = sourceImage.getHeight(); 
System.out.println("The dimensions of the picture are: " + width +  " by " + height + "\n");


 
// Specify where to write the  Image.     
 String mergedImageName = "images/PixelatedImage.png";


// * * * * * * * * * * * * * * * * * * * * 
//2a. Create a BufferedImage for the modified pixelated image. 
   
// Get the dimensions of the image. 
BufferedImage pixelatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

// Get the raster and ColorModel  with the color info, for the original image.
 WritableRaster raster = sourceImage.getRaster();
 ColorModel model =      sourceImage.getColorModel();
 System.out.println("The ColorModel for the source image is:  " + model + "\n");
  
      
      
      
//2b. We wouold like to draw directly into the BufferedImage for the pixelated image
// Get a Graphics object so we can draw the image. 
Graphics2D g2 = (Graphics2D) pixelatedImage.getGraphics();
g2.drawImage(sourceImage, 0,0,null) ; // Drop the original image into the background. We'll write directly on top of it.  


// Set the width and height for each tile. 
int tileWidth = 10; int  tileHeight = 10;

// Now use nested for loops, to sample the color at the top/left point of each tile.  
// Then draw a tile (Rectangle) at tha point with the sampled color. 

// We will sample the color in the original image at these sample points. 
 int sampleX = 0, sampleY = 0;
 Rectangle colorTile = null;
 
 System.out.println("Number of row tiles: " + width/tileWidth);
  System.out.println("Number of column tiles: " + height/tileHeight);

 for(int rowTile = 0; rowTile <= (width-1)/tileWidth; rowTile++)  {
 for(int columnTile = 0; columnTile <= (height-1)/tileHeight; columnTile++)  {
   
    // Get the color at the point: x = rowTile*tileWidth and y = columnTile*columnWidth
    sampleX = rowTile*tileWidth;  sampleY = columnTile*tileHeight; 

    // Get the color at the specified point.   
    // Use the true option to preserve any alpha component info, or else it will get tossed!
    int argb = model.getRGB(raster.getDataElements(sampleX, sampleY, null));
    // Color originalColor = new Color( argb, true  ); // Get the color at each point
    
    Color originalColor = new Color( argb, true  ); // Get the color at each point
    Color newColor = new Color( originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue(), 128); // Let's make the tiles translucent, as an artistic effect. 
    
    g2.setColor(newColor);
    // Draw the tile at the sample point. 
    colorTile = new Rectangle(sampleX - tileWidth/2, sampleY-tileHeight/2, tileWidth, tileHeight);
    g2.fill(colorTile);

 } // end of inner for loop for the column tiles
} // end of outer for loop for the row tiles. 


// Let's create a color tile. 
// Rectangle colorTile  = new Rectangle(0, 0, width, height)  ;  

// g2.setColor(Color.MAGENTA);
// g2.fill(colorTile);


//4. Display the source image and pixelated image in a Frame. 






// * * * This code added so the images also pop up in a frame or window. 
 
 System.out.println("Images being added to a Frame." );    
//1. Create the frame, and optionally give it a title. 
 JFrame frame = new JFrame();
 frame.setTitle("Pixelization of an Image");

//2. Optional: What happens when the frame closes?
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // We will be done, so just exit. 

//3. I'd like to show both source and target image in the same frame this time. 
// We can use the FlowLayout to help us. 

frame.getContentPane().setLayout( new FlowLayout() );


//4. Now add the images as ImageIcons for JLabel(s)
frame.getContentPane().add( new JLabel(  new  ImageIcon(sourceImage ) )  );
 System.out.println("1. Source image successfully added. " );    

frame.getContentPane().add( new JLabel(  new  ImageIcon( pixelatedImage ) )  );
 System.out.println("2. Pixelated image successfully added. " );    


//4. Size the frame. 
frame.pack();

//5. Show it.
frame.setVisible(true);









    
    } // end of main
    
    
    
    
    
    
} // end of  class
