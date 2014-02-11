package Main;

import java.awt.Rectangle;
import java.util.Random;

public class Player {
	int x = 0;
	int y = 0;
	int w = 0;
	int h = 0;
	boolean up = false;
	boolean down = false;
	boolean aiup = true;
	boolean aidown = false;
	int upcount = 0;
	int downcount = 0;
	int random = 0;
	int random2 = 0;
	
	public Player(int X, int Y, int W, int H){
		x = X;
		y = Y;
		w = W;
		h = H;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return w;
	}
	
	public int getHeight(){
		return h;
	}
	
	public void moveUp(){
		if(y>40){
		y-=6;
		}
	}
	
	public void moveDown(){
		if(y<360)
		y+=6;
	}
	
	public int makeRandom(int r){
		Random ran = new Random();
		random = ran.nextInt(10);
		return r;
	}
	
	public void ai(int d, int r){
			if(d - 50 < this.y){
				y-=r;
			}
			if(d + 50 > this.y){
				y+=r;
	
			}
	}
	
	public void newAI(int r){
		if(y < 360){
			if(r < 4){
				y+= 20;
			}
		}
		if(y > 40){
			if(r > 5){
				y-= 20;
			}
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
	}
	
}
