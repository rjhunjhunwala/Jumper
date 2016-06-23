/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author rohan
 */
public class Controller implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
switch(e.getKeyChar()){
	case 'a':
		GamePanel.p.x-=6;
		break;
	case 'd':
		GamePanel.p.x+=6;
}
GamePanel.p.x+=700;
GamePanel.p.x%=700;
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
