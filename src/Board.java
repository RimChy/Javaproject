import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
 
public class Board extends JPanel implements ActionListener, Runnable {
    
    JFrame f;
  
private static final long serialVersionUID = 1L;
    Dude p;
    public Image backimg,menuBg,img;
    Timer time;
    static int v = 260;
    private Menu Menu;
   private Over over;
    Thread animator;
   int totalScore=0;
   public static int life=1;
   public static int lifeval=0,val=0;
    public static final int N = 64000;
   
    public static int SCORE=0;
    public static double HIGHSCORE;
    Enemy obs;
    Letter cn;

    ArrayList < Enemy > arr = new ArrayList < Enemy >();
    ArrayList < Letter > brr = new ArrayList <Letter> ();
    
    boolean lost = false, a = false, done2 = false;
    public static enum STATE {MENU,GAME,HELP,OVER}; 
    public static STATE State = STATE.MENU;
   
    static Font font = new Font("Comic Sans MS", Font.BOLD, 30);
    
    static Font font1 = new Font("Comic Sans MS", Font.BOLD, 40);
    
    public Board() {
    	
    	this.addMouseListener(new Menu()); 
             
          
        	p = new Dude();  
            Menu = new Menu();
           
            addKeyListener(new actionListener());
            setFocusable(true); 
            
           ImageIcon i1 = new ImageIcon("D:\\Downloads\\Jgame\\menu7.png");             
            menuBg = i1.getImage();
            
            ImageIcon i2 = new ImageIcon("D:\\Downloads\\Jgame\\background.png");
            backimg = i2.getImage();
            ImageIcon i3=new ImageIcon("D:\\Downloads\\Jgame\\background.png");
            img=i3.getImage();
            
          
            
            time = new Timer(10, this); 
            time.start();
            
           int counter = 0;
            
        
          for(int k = 1200 ; k <= N ; k += 500, counter++) {
            	 counter %= 4;
            	 if(counter == 3) {
            		 continue;
            	 }
            	 if(counter == 0) {
            		 	arr.add(new Enemy(k,340,"D:\\Downloads\\Jgame\\ob2.png"));
            		 	arr.add(new Enemy(k+600,340,"D:\\Downloads\\Jgame\\ob5.png"));
            		 	continue;
            	 }
            	// obs = new Enemy(k + 900, 340, "C:\\gamephoto\\ob3.png");
            	// arr.add(obs);
  
            }
            
                       
            for(int k = 1000 ; k <= 1800 ; k += 200) {
            		if(k%900 == 0) {
            			cn = new Letter(k,320,"D:\\Downloads\\Jgame\\s1.png");
            		}
            		else cn = new Letter(k,320,"D:\\Downloads\\Jgame\\d2.png");
            		brr.add(cn);
            }
            
            for(int k = 2000 ; k <= N ; k += 500) {
            		Random rand = new Random();
            		int tot = rand.nextInt(100);
         		tot %= 2;
           		tot ^= 1;
            		if(tot == 1) {
            			cn = new Letter(k+200, 320, "C:\\gamephoto\\p.png");
            			brr.add(cn);
            			cn = new Letter(k+300,320,"C:\\gamephoto\\f1.png");
            		}
            		else {
            			cn = new Letter(k+300,320, "C:\\gamephoto\\h.png");
            			brr.add(cn);
            			cn = new Letter(k+200,320,"D:\\Downloads\\Jgame\\d2.png");
            		}
            		brr.add(cn);	
            }
            
  }

    
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        
          
            p.move();
            
            
          for(int k = 0 ;k < arr.size() ; k++) {
                
            		if(p.getShift() >= 1000) {
                                
            			arr.get(k).move(p.dx); 
            		}
            		if(arr.get(k).getX() <= -40) {
                                
            			arr.remove(k);
            		} 
            } 
            
            for(int k = 0 ; k < brr.size(); k++) {
                
            		if(p.getShift() >= 500) {
                                
            			brr.get(k).move(p.dx);
            		}
            }
            
            repaint();
    }
    

	public void checkCollisions()
	{
		 
			Rectangle player = new Rectangle(150 ,(260 + (260- v)) , 90,90);
			
			for(int k = 0 ; k < arr.size() ; k++) {
                                
					Rectangle obst = arr.get(k).getBounds();
					
					if(player.intersects(obst)) {
						//System.out.println(lifeval);
							//System.out.println("Collision occured!");
							lost = true;
                                                            
                                                            lifeval--;
                                                            val++;
                                                            
                                                            
                                                           
				}
                                          
                                         
			}
			
			for(int k = 0 ; k < brr.size(); k++) {
					Rectangle coin = brr.get(k).getBounds();
					if(player.intersects(coin)) {
						brr.get(k).endLife();
						///totalScore = 0;
//                                                    //lost = true;
//                                                    //lifeval--;
					}
			}
	}

         
    public void paint(Graphics g) {
        
        	super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                    
    		if (lost) { /// After collision!
              
if(life==0){
          
          p.dx=0;
       
         
         Board.State = Board.STATE.OVER;
          
      }
lost = false;

}
	        
		if (p.dy == 1 && done2 == false) { 
                       
                         
		        done2 = true;
		        animator = new Thread(this);
		        animator.start();
		}

               
               
               if(State == STATE.GAME) {
               	if((p.getShift()-10)%2000==0) p.nx=0;
               	if((p.getShift()-1010)%2000==0) p.nx2=0;
                       
               	    g2d.drawImage(backimg,990-p.nx2,0,null);
                               //System.out.println(p.getX());
               	    if(p.getShift()>=10)
               	    	 g2d.drawImage(backimg,990-p.nx,0,null);
               	    g2d.drawImage(p.getImage(), 150, v, null);           
              
               }
               else if(State==STATE.MENU){
                           
                       g.drawImage(menuBg, 0, 0, null);
                           
                       Menu.render(g);
               }

                                    
               
               else if(State==STATE.OVER){
                       
                   g2d.drawImage(img,0,0,null);
                   p.firstpress=true;
                       
                   Over.render(g);
           }
       
               g2d.setFont(font);
                   
               g2d.setColor(Color.RED);
               System.out.println(lifeval);
               System.out.println(val);
                   
               int score = 0;
                   
                   boolean q=false;
                   for(int k = 0 ; k < brr.size(); k++) {
              		if(!brr.get(k).isAlive()) {
               			score++;
               		}
               }
                   
                  SCORE=score;
                  
                //  if(score>highscore) highscore=score;
                 // HIGHSCORE=highscore;
                  
                  
                  
                   
               g.drawString("SCORE: " + score , 0, 26);/// Show tot as 0!
              // g2d.drawString("HIGHSCORE: " + highscore , 0, 28);
                   
                   
                   
                 
                   
                   
                 
                   if(lifeval==2){
                       
                     //  life--;
                       
                       //q=true;
                       
                       lifeval=0;
                   }
                    if(lifeval==-64) {
                	   life--;
                	   q=true;
                       
                       if(life<=0)
                           life=0;  
                   }
         
               for(int k = 0 ; k < arr.size() ; k++) {
               	if(p.getShift() >= 700) {
               		g2d.drawImage(arr.get(k).getImage(), arr.get(k).getX(), arr.get(k).getY(), null);
               	}
               }
               
               for(int k = 0 ; k < brr.size(); k++) {
               	if(brr.get(k).isAlive() && p.getShift() >= 700) {
               		g2d.drawImage(brr.get(k).getImage(), brr.get(k).getX(), brr.get(k).getY(), null);
               	}
               }
   }

   private class actionListener extends KeyAdapter {
       
           public void keyReleased(KeyEvent e) {
                   p.keyReleased(e);
           }

           public void keyPressed(KeyEvent e) {
                   p.keyPressed(e);
           }
   }

   boolean h = false;
   boolean done = false;

  

   
   public void run() {

           long beforeTime, timeDiff, sleep;

           beforeTime = System.currentTimeMillis();

           while (done == false) {

                   Cycle();

                   timeDiff = System.currentTimeMillis() - beforeTime;
                   sleep = 10 - timeDiff;

                   if (sleep < 0)  sleep = 2;
                   
                   try {
                           Thread.sleep(sleep);
                           
                   } catch (InterruptedException e) {
                   	
                   }

                   beforeTime = System.currentTimeMillis();
           }
           
           done = false;
           h = false;
           done2 = false;
           
   }
   public void Cycle() {

       if (h == false)
               v -= 1;
       if (v == 140)
               h = true;
       if (h == true && v <= 260) {
               v += 1;
               if (v == 260) {
                       done = true;
               }
       }
}
}
   


