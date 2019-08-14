package com.my.drum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiSimple implements ActionListener {
	JFrame frame;
	JLabel label;
	DrawPanel drawPanel;
	JButton colorButton;
	JButton labelButton;
	
	class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("Ouch!");
		}
		
	}
	
	class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
		
	}
	
	public void display() {
		
		frame = new JFrame();
		
		colorButton = new JButton("color");
		labelButton = new JButton("label");
		drawPanel = new DrawPanel();
		label = new JLabel("I'm a label");
		
		colorButton.addActionListener(new ColorListener());
		labelButton.addActionListener(new LabelListener());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(100, 100);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.repaint();
	}
}
