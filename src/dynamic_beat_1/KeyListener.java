package dynamic_beat_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
 
	//�������̵� --> Ű �ν��ϴ� �� 
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game ==  null) { //Ű�� ������ ���� ��� ���� ���� 
			return; 
		}
		if(e.getKeyCode()==KeyEvent.VK_S) { // SŰ�� ������ ��� 
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D) { // DŰ�� ������ ��� 
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode()==KeyEvent.VK_F) { // FŰ�� ������ ��� 
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) { // SpaceŰ�� ������ ��� 
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode()==KeyEvent.VK_J) { // JŰ�� ������ ��� 
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode()==KeyEvent.VK_K) { // KŰ�� ������ ��� 
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode()==KeyEvent.VK_L) { // LŰ�� ������ ��� 
			DynamicBeat.game.pressL();
		}
	}
	
	//�������̵� --> Ű ������ ��� 
		public void keyReleased(KeyEvent e) {
			if(DynamicBeat.game ==  null) { //Ű�� ������ ���� ��� ���� ����
				return; 
			}
			if(e.getKeyCode()==KeyEvent.VK_S) { // SŰ�� ������ ��� 
				DynamicBeat.game.releaseS();
			}
			else if(e.getKeyCode()==KeyEvent.VK_D) { // DŰ�� ������ ��� 
				DynamicBeat.game.releaseD();
			}
			else if(e.getKeyCode()==KeyEvent.VK_F) { // FŰ�� ������ ��� 
				DynamicBeat.game.releaseF();
			}
			else if(e.getKeyCode()==KeyEvent.VK_SPACE) { // SpaceŰ�� ������ ��� 
				DynamicBeat.game.releaseSpace();
			}
			else if(e.getKeyCode()==KeyEvent.VK_J) { // JŰ�� ������ ��� 
				DynamicBeat.game.releaseJ();
			}
			else if(e.getKeyCode()==KeyEvent.VK_K) { // KŰ�� ������ ��� 
				DynamicBeat.game.releaseK();
			}
			else if(e.getKeyCode()==KeyEvent.VK_L) { // LŰ�� ������ ��� 
				DynamicBeat.game.releaseL();
			}
		}
}
