package com.my.drum;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawPanel extends JPanel  {
	
	private boolean repaint = false;
	
	public void paintComponent(Graphics g) {
		if(repaint) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			Rect rect = randomRect();
			g.fillRect(rect.x, rect.y, rect.w, rect.h);
			repaint = false;
		}
	}
	
	private Rect randomRect() {
		int x = (int)(Math.random()*40)+10;
		int y = (int)(Math.random()*40)+10;
		int w = (int)(Math.random()*120)+10;
		int h = (int)(Math.random()*120)+10;
		return new Rect(x, y, w, h);
	}
	
	public void startRepaint() {
		repaint = true;
		repaint();
	}
	
	class Rect {
		int x, y, w, h;

		public Rect(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}
}
