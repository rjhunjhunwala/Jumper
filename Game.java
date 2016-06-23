/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rohan
 */
public class Game implements Runnable {
	public static AtomicBoolean playing=new AtomicBoolean(true);
	public Game(){
		playing.set(true);
	}
	@Override
	public void run(){
		while(playing.get()){
			try {
				Thread.sleep(7);
			} catch (InterruptedException ex) {
				Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
			}
GamePanel.p.step();
		}
	TitleFrame.playing.set(false);	
	TitleFrame.doBreak.set(true);
	Jumper.g.setVisible(false);
	}
}
