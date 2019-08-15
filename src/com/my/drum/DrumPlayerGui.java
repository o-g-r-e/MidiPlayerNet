package com.my.drum;

import java.awt.BorderLayout;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JFrame;

public class DrumPlayerGui extends JFrame implements ControllerEventListener {
	
	DrawPanel drawPanel;
	
	public DrumPlayerGui() {
		
		drawPanel = new DrawPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(BorderLayout.CENTER, drawPanel);
		setSize(400, 400);
		setVisible(true);
	}

	@Override
	public void controlChange(ShortMessage event) {
		drawPanel.startRepaint();
	}
}
