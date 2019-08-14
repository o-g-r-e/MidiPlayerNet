package com.my.drum;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements ControllerEventListener {
	
	private boolean msg = true;
	
	public void paintComponent(Graphics g) {
		if(msg) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			drawRandomRect(g2d);
		}
	}
	
	private void drawRandomRect(Graphics g) {
		int x = (int)(Math.random()*40)+10;
		int y = (int)(Math.random()*40)+10;
		int w = (int)(Math.random()*120)+10;
		int h = (int)(Math.random()*120)+10;
		g.fillRect(x, y, w, h);
	}

	@Override
	public void controlChange(ShortMessage event) {
		msg = true;
		repaint();
	}
}
