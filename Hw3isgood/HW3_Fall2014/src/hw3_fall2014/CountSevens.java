/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3_fall2014;


public class CountSevens {
    
 // Add a main method here.    
    
    
    
    
    
    
    
public static int countSevens(int n) {
// 0. Clean-up. Get rid of any minus signs as that is not a digit. 
        n = Math.abs(n);
        
// 1. Stopping condition. Just one digit.
        if(n < 10) {   return (n==7) ?1:0;    } // Conditional operator!
        
// 2. Else apply recursion if there are two or more digits. 
        else    { return (n%10==7)? 1+ countSevens(n/10): countSevens(n/10);}    
         
}   // end of method 

    
} // end of class
