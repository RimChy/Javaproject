
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Menu implements MouseListener{
  
    public static void render(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        Font fnt = new Font("Comic Sans MS", Font.BOLD, 40);//font of the options
        
        g.setColor(Color.DARK_GRAY);// background color of the buttons
        
        g.fill3DRect(100, 297, 150, 100, true);//fills color in 3d rectangles
        g.fill3DRect(400, 297, 150, 100, true);
        g.fill3DRect(700, 297, 150, 100, true);
        
        g.setColor(Color.GREEN);//font color
        g.setFont(fnt);
        
        //draws buttons
        
        g.drawString("Play",  100+28, 297 + 55);
        g2d.draw3DRect(100, 297, 150, 100,true);
        
        g.drawString("Help", 400 + 28, 297+ 55);
        g2d.draw3DRect(400, 297, 150, 100, true);
        
        g.drawString("Quit", 700 + 28, 297 + 55);
        g2d.draw3DRect(700, 297, 150, 100, true);
            

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        int mx = e.getX();
        int my = e.getY();
        
        if(my>=297 && my<=397) {  
            
            if(mx>=100 && mx<=250) {
              
                Board.State = Board.STATE.GAME;///goes to game window
            }
            
//            if(my>=297 && my<=367) {
//                
//                //HelpWindow ob2=new HelpWindow(); ///goes to help window
//                GameWindow.State = GameWindow.STATE.HELP;
//            }
            
            if(mx>=700 && mx<=850) {
                
                System.exit(1);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    
}