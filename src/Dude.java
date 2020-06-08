import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
 
public class Dude{
    
        int nx,nx2, dy, pause = 0;
        static int dx = 0;
        
        
        int x, y, shift; 
        Image still;
        
        boolean firstpress;
        
        ImageIcon i = new ImageIcon("D:\\Downloads\\Jgame\\player.gif");
      // ImageIcon j= new ImageIcon("C:\\gamephoto\\player.gif");
      

        
        public Dude() {
        	 still=i.getImage();
        	nx2=990;
        	shift = 0;
        	x = 0;
        	y = 260;
               
       
        }
        
        public int getX() {
            
        	return x;
        }
        
        public int getY() {
            
        	return y;
        }
       
        public void move() {
            
        	x -= dx;
        	shift += dx; 
        	nx2+=dx;
        	nx+=dx;
        	
        }
 
 
        public Image getImage() {
            
                return still;
        }
        
        public int getShift() {
        	return shift;
        }
     
//        public int getPauseValue() {
//        	return pause;
//        }
//        
        public void keyPressed(KeyEvent e) {
        	
                int key = e.getKeyCode();
                
               if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){ 
                    
                	if(firstpress == false) {
                            
                		dx = 2;
                		//firstpress = true;
                	}
                	still = i.getImage();          
               }
               
               /* if (key == KeyEvent.VK_B){
                   
                        dy = 1;    
                        still = i.getImage();
                }    
                
              /*  if(key == KeyEvent.VK_SPACE) {
                    
                	
                	dx=0;
                	moving=j.getImage();
                }
                
                if(key == KeyEvent.VK_ENTER) {
                    
                	
                	dx=1; 
                }
           }*/
             /*  if (key == KeyEvent.VK_LEFT) {
                    dx = -1;
                   still= i.getImage();
            }

            if (key == KeyEvent.VK_RIGHT) {
                    dx = 2;
                    still=i.getImage();
            }*/
            
            if (key == KeyEvent.VK_B) {
            	dy = 1;
            	still=i.getImage();
            }
    }
 
         public void keyReleased(KeyEvent e) {
        			
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT)
                    dx = 0;

            if (key == KeyEvent.VK_RIGHT)
                    dx = 0;
 
                if (key == KeyEvent.VK_UP){
                    
                	dy = 0;
                        
                        still=i.getImage();
                }
         }
 }
