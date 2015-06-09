import g4p_controls.*;
import java.util.Random;
import javax.swing.*;
import processing.core.*;

//change name of class:
public class PennyPitch extends PApplet
{
    GButton btntoss, btnnew;
    GLabel lblpen;
    prizebox p[][] = new prizebox[5][5];
    int xloc=50, yloc=50, pen = 20;
    String prize[]={"BALL","MUG","DOLL","HAT","POSTER"};
    
	public void setup()
	{
		size(600, 600, JAVA2D);
                btntoss = new GButton(this,50,550,100,30);
                btntoss.setText("Toss Penny");
                btnnew = new GButton(this,150,550,100,30);
                btnnew.setText("New Game");
                btnnew.setEnabled(false);
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
            if(button==btntoss){
                pen--;
                int rx,ry;
                rx=(int)random(0,5);
                ry=(int)random(0,5);
                p[rx][ry].tossPenny();
                
                String won="";
                if (pen==0){
                    btntoss.setEnabled(false);
                    btnnew.setEnabled(true);
                    for (int x = 0; x < 5; x++) {
                            if(checkwin(prize[x])==true) won+=prize[x] + " ";
                        }
                    if (won=="") won="nothing";
                    JOptionPane.showMessageDialog(this, "Prizes won: " + won);
                }
            }
            if(button==btnnew) {
                btntoss.setEnabled(true);
                btnnew.setEnabled(false);
                boxclear();
                setprizes();
                pen=20;
            }
		//code for buttons goes here
	}	
        
        public void boxclear(){
            for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        p[i][j].setPrize("");
                        p[i][j].clearPenny();
                    }
                }
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
        
        boolean checkwin(String prize)
        {
            int count=0;
            for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (p[i][j].hasPenny() && p[i][j].getPrize().equals(prize)) count++;
                    }
                }
            return count>=3;
        }
        
        public void draw()
	{
		background(255); //white
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        p[i][j].drawbox();
                        
                    }
                }
                text(pen + " pennies left.",260,570);
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
      
      void clearPenny()
      {
          p="";
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