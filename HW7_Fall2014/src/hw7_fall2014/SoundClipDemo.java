/*
 * Example from our text
 */
package hw7_fall2014;

public class SoundClipDemo
{
   public static void main(String[] args)
   {
      SoundClip clip = new SoundClip();
      clip.pick();
      clip.show();    

      int[] samples = clip.getSampleValues();

      // In this example, we don't need the sample rate.
      // If you do, call clip.getSampleRate();

      for (int i = 0; i < samples.length; i++)
      {
         samples[i] = 3 * samples[i];
      }
      
      clip.show();
      
      
   } // end of main
} // end of class
