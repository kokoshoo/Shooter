package Main;

import java.applet.Applet;
import java.util.*;
import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShooterMain extends Applet implements Runnable{

	int appletW = 400;
	int appletH = 400;
	int x = 10;
	int y = 10;
	Thread runner = null;
	Player p1;
	Player p2;
	Bullet b1;
	Bullet b2;
	int bulw= 6;
	int bulh= 2;
	int p1hp = 100;
	int p2hp = 100;
	Button retryb;
	Button startb;
	int random;
	Random ran;
	int count = 0;
	
	public ShooterMain(){
		retryb = new Button("Retry?");
		retryb.setSize(70,50);
		retryb.setLocation(165,175);
		retryb.setBackground(Color.CYAN);
		retryb.addActionListener(new Retry());
		startb = new Button("Retry?");
		startb.setSize(70,50);
		startb.setLocation(165,175);
		startb.setBackground(Color.CYAN);
		startb.addActionListener(new Start());
		
	}
	
	public void damage(){
		if(p2.getBounds().intersects(b1.getBounds())){
			b1.reset(p1.getX()+10,p1.getY()+18,bulw,bulh);
			p2hp-=10;
			
		}
		if(p1.getBounds().intersects(b2.getBounds())){
			b2.reset(p2.getX()-10, p2.getY()+18,bulw,bulh);
			p1hp-=10;
		}
	}
	
	public int makeRandom(){
		Random ran = new Random();
		random = ran.nextInt(10);
		System.out.println(random);
		return random;
	}
	
	public void checkbul(){
		if(b1.x>appletW){
			b1.reset(p1.getX()+10,p1.getY()+18,bulw,bulh);
		}
		if(b2.x<0){
			b2.reset(p2.getX()-10, p2.getY()+18,bulw,bulh);
		}
	}
	
	public void playerMove(){
		if(p1.up){
			p1.moveUp();
		}
		if(p1.down){
			p1.moveDown();
		}
		if(p2.up){
			p2.moveUp();
		}
		if(p2.down){
			p2.moveDown();
		}
	}
	
	public void checkgame(){
		if(p2hp<= 0 || p1hp<=0){
			count = 0;
			stop();
		}
	}
	/*public void update(Graphics g){
		Graphics gc;
		Image offscreen = null;
		Dimension d = size();
		
		offscreen = createImage(d.width,d.height);
		gc = offscreen.getGraphics();
		gc.setColor(getBackground());
		gc.fillRect(0, 0, d.width, d.height);
		gc.setColor(getForeground());
		paint(gc);
		g.drawImage(offscreen,0,0,this);
		
		
	}*/
	
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, appletW, appletH);
		g.setColor(Color.RED);
		g.fillRect(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
		g.setColor(Color.GREEN);
		g.fillRect(p2.getX(),p2.getY(),p2.getWidth(),p2.getHeight());
		g.setColor(Color.WHITE);
		g.fillRect(b1.getX(), b1.getY(), b1.getWidth(), b1.getHeight());
		g.fillRect(b2.getX(), b2.getY(), b2.getWidth(), b2.getHeight());
		g.setColor(Color.red);
		g.fillRect(15, 15, p1hp, 15);
		g.setColor(Color.GREEN);
		g.fillRect(285, 15, p2hp, 15);
		g.setColor(Color.WHITE);
		g.drawString("Player  1", 45, 25);
		g.drawString("Player  2", 305, 25);
	}
	
	
	public void start(){
		if(runner == null){
			this.remove(retryb);
			runner = new Thread(this);
			runner.start();
		}
	}
	
	public void stop(){
		if(runner != null){
			runner = null;
			this.add(retryb);
			retryb.setVisible(true);
		}	
	}
	
	public void init(){
		runner = null;
		this.setSize(appletW, appletH);
		p1 = new Player(0,160,10,40);
		p2 = new Player(390,160,10,40);
		b1 = new Bullet(p1.getX()+10,p1.getY()+18,bulw,bulh);
		b2 = new Bullet(p2.getX()+10, p2.getY()+18,bulw,bulh);
		this.setFocusable(isEnabled());
		this.addKeyListener(new PlayerListener(p1,p2,b1,b2));
	}
	
	public void update(){
		repaint();
		playerMove();
		damage();
		checkbul();
		checkgame();
		p2.ai(p1.y, makeRandom());
		p2.newAI(makeRandom());
		if(count > 50){
		//Keep shooting
		b2.shot = true;
		}
		b1.bulletShotp1(p1.getX()+10,p1.getY()+18);
		b2.bulletShotp2(p2.getX()+10, p2.getY()+18);
	}
	
	@Override
	public void run() {
		while(runner!=null){
			update();
			try {
				Thread.sleep(15);
				count++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private class Retry implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			p1hp = 100;
			p2hp = 100;
			init();
			start();
			retryb.setVisible(false);
		}
	}
	
	private class Start implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			start();
			startb.setVisible(false);
		}
		
	}
}
