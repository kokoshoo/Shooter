package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {
	
	Player p;
	Player p2;
	Bullet b1;
	Bullet b2;
	
	public PlayerListener(Player pl,Player pl2,Bullet bul1, Bullet bul2){
	
	p = pl;
	p2 = pl2;
	b1 = bul1;
	b2 = bul2;
	
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_W){
			p.up = true;	
		}
		if(key == KeyEvent.VK_S){
			p.down = true;
		}
		if(key == KeyEvent.VK_UP){
			p2.up = true;
		}
		if(key == KeyEvent.VK_DOWN){
			p2.down = true;
		}
		if(key == KeyEvent.VK_SPACE){
			b1.shot = true;
		}
		if(key == KeyEvent.VK_L){
			b2.shot = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_W){
			p.up = false;	}
		if(key == KeyEvent.VK_S){
			p.down = false;
		}
		if(key == KeyEvent.VK_UP){
			p2.up = false;
		}
		if(key == KeyEvent.VK_DOWN){
			p2.down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
