package jumper;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan
 */
public class GamePanel extends JPanel{
	public static final Player p=new Player();
	
	public GamePanel(){

	}
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(700,700);//hardcoded
	}
	@Override
	public void paintComponent(Graphics g){
	p.drawSelf(g);
	for(Platform p:Player.platforms){
		p.drawSelf(g);
	}
	}
}
