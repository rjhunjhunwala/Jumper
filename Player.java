package jumper;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan
 */
public class Player {
	public static double x=350;
	public static double dY=2;
	public static double y=350;
	public static final double g=.01;
	public double pastYJump=-1;
	public static final ArrayList<Platform> platforms=new ArrayList<>(30);
	static{
		for(int i=0;i<30;i++){
			platforms.add(new Platform((int)(Math.random()*650),(int) (Math.random()*650)));
		}
	}
	public boolean isInMesh(int x, int y){
		int xDist=(int) (x-this.x);
		int yDist=(int) (y-this.y);
	return false;
	}
	public void drawSelf(Graphics g){
		g.setColor(Color.green);
		g.fillOval((int) x-10,(int) y-10-Platform.topOfScreen, 10, 10);
	}
	public synchronized void step(){
		if(dY<0){
		for(Platform p: platforms){
			if(p.isInMesh((int)x ,(int) y)){
dY=2;
				break;
			}
		}
		}
		y-=dY;
		dY-=g;
		if(y>Platform.bottomOfScreen){
			HighScore.manageScore((int) (-1*y+1400));
	Jumper.popUp("You lose");
			Game.playing.set(false);
return;
	}else if(y<Platform.topOfScreen+200){
		Platform.topOfScreen=(int) (y-200);
Platform.bottomOfScreen=Platform.topOfScreen+700;
for(int i=0;i<30;i++){
	if(true){
		if(platforms.get(i).y>Platform.bottomOfScreen) {
			platforms.set(i, new Platform((int) (Math.random()*650),Platform.topOfScreen-Platform.depth-1));
		}
	}
}
	}
	}
	
}
