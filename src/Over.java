import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;


import java.awt.event.MouseListener;

public class Over implements MouseListener{
	public static void render(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
	        
	        Font fnt = new Font("Comic Sans MS", Font.BOLD, 40);//font of the options
	        
	      //  g.setColor(Color.DARK_GRAY);// background color of the buttons
	        
	      
	        g.setColor(Color.BLUE);//font color
	        g.setFont(fnt);
	        g.drawString("GAME OVER",  370, 100);
	       // g2d.draw3DRect(400, 200, 250, 150,true);
	       // g.drawString("SCORE", 500, 26);
	        Font fnt1 = new Font("Comic Sans MS", Font.BOLD, 40);
	        g.setColor(Color.DARK_GRAY);
	        g2d.fill3DRect(370,  130, 300, 80,true);
	        g.setColor(Color.BLUE);
	        g.setFont(fnt1);
	        g.drawString("NEW GAME",370+4, 130+50);
	        g2d.draw3DRect(370, 130, 300, 80,true);
	        
	}
   @Override
	 public void mouseClicked(MouseEvent e) {
	        
	        int mx = e.getX();
	        int my = e.getY();
	        
	        if(mx>=370 && my<=670) {  
	            
	            if(my>=130 && mx<=210) {
	              
	                Board.State = Board.STATE.GAME;
	            }
	            
	           
	        }
	    }

	    public void mousePressed(MouseEvent e) {}

	    public void mouseReleased(MouseEvent e) {}

	    public void mouseEntered(MouseEvent e) {}

	    public void mouseExited(MouseEvent e) {}
	    
	    
	}


