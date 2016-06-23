package jumper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rohans
 */
public class TitleFrame extends JFrame {

	public static AtomicBoolean playing = new AtomicBoolean(false);
	private static final long serialVersionUID = 1L;
public static AtomicBoolean doBreak=new AtomicBoolean(false);
	public static TitleFrame t;

	public static void main(String[] args) throws Exception {

		t = new TitleFrame();
		while (true) {
			while (!playing.get()) {
				t.repaint();
			}
			t.setVisible(false);
			Jumper.playOneGame();

			while (playing.get()) {
				Thread.sleep(10);
				if(doBreak.get()){
					break;
				}
			}
			doBreak.set(false);
			t.setVisible(true);
		}
	}

	public TitleFrame() {
		super("Orbital");

		TitlePanel p = new TitlePanel();

		this.add(p);

		this.pack();

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addKeyListener(new TitleController());
		this.setLocationRelativeTo(null);
		this.repaint();
	}

	public static class TitlePanel extends JPanel {

		/**
		 * Shows what screen is currently showing
		 */
		public static AtomicReference<Screens> screen = new AtomicReference<>(Screens.title);


		/**
		 * These dots are to be used to separate the names from the scores in the high
		 * score table.
		 */
		private static final String dots = "....................................";

		public static final Font big = new Font("Monospaced", 24, 24);

		public static final Font huge = new Font("Monospaced", 72, 72);

		

		public TitlePanel() {
			TitlePanel.screen.set(Screens.title);
			this.setBackground(Color.red);
		}

		@Override

		public Dimension getPreferredSize() {
	
			return new Dimension(700, 700);
		}
		public static final Color green = new Color(0, 255, 0);

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
g.setFont(big);
			g.setColor(Color.blue);
			switch (screen.get()) {
				case title:
g.drawString("Jumper",325, 350);
g.setFont(new Font("Times New Roman",12,12));
g.drawString("A/D to move left/right", 0,475);
g.drawString("Press \"H\" for high score table",0,500);
g.drawString("Press \"P\" to play",0,525);
					break;
				case help:
					g.drawString("Arrow keys to move, press r to return", 0, 350);
					break;

				case highscore:

					g.setColor(Color.cyan);
					g.setFont(big);
					g.drawString("High Scores", 700 / 2 - 70, 50);
					int i = 60;
					for (HighScore s : HighScore.scores) {
						g.drawString(s.name + dots.substring(s.name.length()), 65, 100 + i);
						g.drawString(s.score + "", 565, 100 + i);
						i += 50;

					}
					g.drawString("Press \"R\" to return to the home screen", 0, 668 - 24);
			}
		}
	}

}
