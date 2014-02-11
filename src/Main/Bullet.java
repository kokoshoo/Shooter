package Main;

import java.awt.Rectangle;

public class Bullet {
	
	int x = 0;
	int y = 0;
	int w = 0;
	int h = 0;
	boolean up = false;
	boolean down = false;
	boolean shot = false;
	
	public Bullet(int X, int Y, int W, int H){
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
	
	public void reset(int q,int w,int e,int r){
		this.x = q;
		this.y = w;
		this.w = e;
		this.h = r;
		shot = false;
	}
	
	public void bulletShotp1(int q,int w){
		if(!shot){
		x = q;
		y = w;
		}
		if(shot)
			x+=15;
	}
	
	public void bulletShotp2(int q,int w){
		if(!shot){
		x = q;
		y = w;
		}
		if(shot)
			x-=15;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
	}

}
