import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class StartingPoint extends Applet implements Runnable {
	
int x= 0 ;
int dx= 2 ;
int y= 0 ;
 int dy = 2 ;
 int radius =20 ;
 private Image i ;
 private Graphics doubleg ;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setSize(500,500);

	}
//hello
	@Override
	public void start() {
		// TODO Auto-generated method stub
		Thread thread = new Thread(this); //this refers to whatever is implementing 
		//here it is runnable , and runnable adds run method so it'll refers to run method 
		thread.start() ;

	}
	public void run() {
		while(true){
			//add detecting wall collisons
			if(x+dx > this.getWidth()-radius-1){
				x = this.getWidth()-radius-1 ;
				dx = -dx ;
			}else if(x + dx <0 +radius){
				x = 0 + radius ;
				dx = -dx ;
			}else{
				x += dx ;
			}
			if(y + dy > this.getHeight()-radius-1 ){
				y = this.getHeight()-radius-1 ;
				dy = -dy ;
			}else if(y+dy <0+radius){
				y = 0 + radius ;
				dy = - dy ;
			}else{
				y+=dy ;
			}
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	//runs frame faster
	//double buffering
	//avoider flicker of animation
	@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			if(i==null){
				i =createImage(this.getSize().width, this.getSize().height);
				doubleg= i.getGraphics();
			}
			doubleg.setColor(getBackground()); //background of the applet
			doubleg.fillRect(0, 0, this.getSize().width, this.getSize().height);
			doubleg.setColor(getForeground());
			paint(doubleg);
			g.drawImage(i,0,0,this);
			
		}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.cyan); //Color is the color class which provides color
		g.fillOval(x, y, radius, radius);
		
	}
	

}
