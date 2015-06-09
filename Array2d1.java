// The "Array2d1" class.
import java.awt.*;
import hsa.Console;

public class Array2d1
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	int time[][] = new int[4][3];
	String ath[] = {"Sue", "Joe", "Mary", "Sam"};
	for (int x=0; x<4; x++){
	    for (int y=0; y<3; y++){
		c.print("Enter time " + (y+1) + " for " + ath[x] + ": ");
		time[x][y] = c.readInt();
	    }
	}
	for (int x=0; x<4; x++){
	    c.print(ath[x] + "\t\t");    
	    for (int y=0; y<3; y++){
		c.print(time[x][y] + "\t");
	    }
	    c.println("|" + (time[x][0] + time[x][1] + time[x][2])/3);
	}
	
	
	// Place your program here.  'c' is the output console
    } // main method
} // Array2d1 class
