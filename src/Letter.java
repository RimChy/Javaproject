
import javax.swing.*;
import java.awt.*;
import java.awt.*;
public class Letter {
	
	private Image img;               
	private int x, y;   

	//private String imgpos;
private boolean check = true;              
	
	
	public Letter(int x,int y, String loc) {
                
		this.x = x;
		this.y = y;
	        ImageIcon g = new ImageIcon(loc);
		img = g.getImage(); 
	}
	public void endLife()
	{
		check=false;
	}
	public int getX() {
                
		return x;
	}
	
	public int getY() {
                
		return y;
	}
	
	public boolean isAlive() {
                
		return check;
	}
	
	public Image getImage() {
                
		return img;
	}

	public void move(int dx) {
                
		x -= dx;
	}
	
	public Rectangle getBounds() {
                
		return new Rectangle(x,y,31 ,50);
	}
	
	

}
