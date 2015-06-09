import g4p_controls.*;
import java.util.Random;
import javax.swing.*;
import processing.core.*;

//change name of class:
public class PennyPitch extends PApplet
{
    GButton btntoss;
    prizebox p[][] = new prizebox[5][5];
    int xloc=50, yloc=50;
    String prize[]={"BALL","MUG","DOLL","HAT","POSTER"};
    
	public void setup()
	{
		size(600, 600, JAVA2D);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        p[i][j]=new prizebox(xloc,yloc);
                        xloc+=100;
                    }
                    xloc=50;
                    yloc+=100;
            }
            setprizes();
	}

	public void handleButtonEvents(GButton button, GEvent event) 
	{

		//code for buttons goes here
	}		

	public void setprizes(){
            Random r = new Random();
            int rx,ry;
            for(int x=0; x<5; x++){
            int count=0;
            while(true){
                rx=r.nextInt(5);
                ry=r.nextInt(5);
                if (p[rx][ry].hasPrize()==false){
                    p[rx][ry].setPrize(prize[x]);
                    count++;
                }
                if (count==3) break;
            }
            }
        }
        
        public void draw()
	{
		background(255); //white
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        p[i][j].drawbox();
                        
                    }
                }
	}

    class prizebox{

     int xloc, yloc;
     String prize;
     String p;
      prizebox(int x, int y)
      {
       xloc=x;
       yloc=y;
       prize="";
       p="";
      }

      void setPrize(String p)
      {
       prize=p;
      }

      String getPrize()
      {
       return prize;
      }

      boolean hasPrize()
      {
         if (prize != "") return true;
         else return false;
      }

      void tossPenny()
      {
        p+="X";
      }

      boolean hasPenny()
      {
       if (p.length() > 0) return true;
       else return false;
      }

      void drawbox()
      {
         fill(0);
         stroke(255);
         strokeWeight(5);
         rect(xloc, yloc, 80,80);
         fill(255);
         text(prize, xloc+10, yloc+30);
         fill(255,0,0);
         text(p, xloc+10, yloc+55);
      }

    }


}