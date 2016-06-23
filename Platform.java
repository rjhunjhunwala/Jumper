/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author rohan
 */
public class Platform {

	public int x;
	public int y;
	public static final int width = 50;
	public static final int depth = 10;
	public AtomicBoolean isAlive = new AtomicBoolean(true);
	public static int topOfScreen=0;
	public static int bottomOfScreen=700;

	public Platform(int inX, int inY) {
				x = inX;
		y = inY;
		for(Platform p:Player.platforms){
			if(p!=null&&(this.isFarEnough(p.x, p.y)||p.isFarEnough(inX, inY))){
				this.x=-1;
				this.y=710;
				this.isAlive.set(false);

			}
		}

	}
public void drawSelf(Graphics g){
	g.setColor(Color.red);
	g.fillRect(x, y-topOfScreen, width, depth);
}
	public boolean isFarEnough(int inX, int inY) {
		return (inX - x < width+10 && inX - x > -10 && inY - y < depth+10 && inY - y > -10);
	}
		public boolean isInMesh(int inX, int inY) {
		return (inX - x < width && inX - x > 0 && inY - y < depth && inY - y > 0);
	}
}
