package dynamic_beat_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
 
	//오버라이딩 --> 키 인식하는 것 
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game ==  null) { //키를 누르지 않을 경우 강제 종료 
			return; 
		}
		if(e.getKeyCode()==KeyEvent.VK_S) { // S키를 눌렀을 경우 
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D) { // D키를 눌렀을 경우 
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode()==KeyEvent.VK_F) { // F키를 눌렀을 경우 
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) { // Space키를 눌렀을 경우 
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode()==KeyEvent.VK_J) { // J키를 눌렀을 경우 
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode()==KeyEvent.VK_K) { // K키를 눌렀을 경우 
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode()==KeyEvent.VK_L) { // L키를 눌렀을 경우 
			DynamicBeat.game.pressL();
		}
	}
	
	//오버라이딩 --> 키 눌렀을 경우 
		public void keyReleased(KeyEvent e) {
			if(DynamicBeat.game ==  null) { //키를 누르지 않을 경우 강제 종료
				return; 
			}
			if(e.getKeyCode()==KeyEvent.VK_S) { // S키를 눌렀을 경우 
				DynamicBeat.game.releaseS();
			}
			else if(e.getKeyCode()==KeyEvent.VK_D) { // D키를 눌렀을 경우 
				DynamicBeat.game.releaseD();
			}
			else if(e.getKeyCode()==KeyEvent.VK_F) { // F키를 눌렀을 경우 
				DynamicBeat.game.releaseF();
			}
			else if(e.getKeyCode()==KeyEvent.VK_SPACE) { // Space키를 눌렀을 경우 
				DynamicBeat.game.releaseSpace();
			}
			else if(e.getKeyCode()==KeyEvent.VK_J) { // J키를 눌렀을 경우 
				DynamicBeat.game.releaseJ();
			}
			else if(e.getKeyCode()==KeyEvent.VK_K) { // K키를 눌렀을 경우 
				DynamicBeat.game.releaseK();
			}
			else if(e.getKeyCode()==KeyEvent.VK_L) { // L키를 눌렀을 경우 
				DynamicBeat.game.releaseL();
			}
		}
}
