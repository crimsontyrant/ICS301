import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

//change name of class:
public class Bowling extends PApplet
{
    int scores[][] = new int[4][10];
    int totals[] = new int[4];
    String bowlers[]={"Andy", "Khal", "Nick", "Dill"};
    GLabel lblbowlers[] = new GLabel[4];
    GLabel lbltotals[] = new GLabel[4];
    GButton btnscore[][] = new GButton[4][10];
    int pnum=0,fnum=0;
    int xloc=100, yloc=50;
	public void setup()
	{
		size(800, 300, JAVA2D);
                for (int i=0;i<4;i++){
                    lblbowlers[i] = new GLabel(this,50,(yloc-20),40,80);
                    lblbowlers[i].setText(bowlers[i]);
                    for(int j=0;j<10;j++){
                        btnscore[i][j]=new GButton(this,xloc,yloc,40,40);
                        btnscore[i][j].setText("Frame " + (j+1));
                        btnscore[i][j].setEnabled(false);
                        xloc+=50;
                    }//done one player's frames
                    lbltotals[i] = new GLabel(this,600,(yloc-20),40,80);
                    lbltotals[i].setText("0");
                    yloc+=50;
                    xloc=100;
                } //end of all frames
                btnscore[0][0].setEnabled(true);
                btnscore[0][0].setLocalColorScheme(0);
	}

	public void handleButtonEvents(GButton button, GEvent event) 
	{
                String score = JOptionPane.showInputDialog("Enter Points");
                btnscore[pnum][fnum].setText(score);
                totals[pnum] += Integer.parseInt(score);
                lbltotals[pnum].setText("" + totals[pnum]);
		btnscore[pnum][fnum].setEnabled(false);
                btnscore[pnum][fnum].setLocalColorScheme(6);
                pnum++;
                if(pnum==4)
                {
                    pnum=0;
                    fnum++;
                }
                btnscore[pnum][fnum].setEnabled(true);
                btnscore[pnum][fnum].setLocalColorScheme(0);
	}		

	public void draw()
	{
		background(255); //white
	}



}