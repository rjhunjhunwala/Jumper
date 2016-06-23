/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper;

import javax.swing.JOptionPane;

/**
 *
 * @author rohan
 */
public class Jumper {
public static GameFrame g=new GameFrame();
	/**
	 * @param args the command line arguments
	 */
	public static void playOneGame(String... args) {

while(Game.playing.get()){
	g.repaint();
}
	}
	
	public static void popUp(String prompt) {
		JOptionPane.showMessageDialog(null, prompt);
	}
}
