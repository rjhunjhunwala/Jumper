/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author rohan
 */
public class GameFrame extends JFrame{
	public GameFrame(){
		super("Jumper");
		this.setVisible(true);
this.add(new GamePanel());
		this.pack();
		this.setBackground(Color.blue);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new Controller());
		new Thread((Runnable) new Game()).start();
	}
}
