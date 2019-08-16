package com.my.drum;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BeatBoxGui {
	
	JPanel mainPanel;
	List<JCheckBox> checkBoxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Share", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", 
											"Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"	};
	
	
	
	public BeatBoxGui() {
		theFrame = new JFrame("Beat Box");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout borderLayout = new BorderLayout();
		JPanel background = new JPanel(borderLayout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkBoxList = new ArrayList<JCheckBox>();
		
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		JButton upTempo = new JButton("Up Tempo");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		
		JButton downTempo = new JButton("Down Tempo");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		
		for (int i = 0; i < instrumentNames.length; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
		
		theFrame.getContentPane().add(background);
		
		GridLayout gridLayout = new GridLayout(16, 16);
		gridLayout.setVgap(1);
		gridLayout.setHgap(2);
		mainPanel = new JPanel(gridLayout);
		background.add(BorderLayout.CENTER, mainPanel);
		
		for (int i = 0; i < 256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkBoxList.add(c);
			mainPanel.add(c);
		}
		
		
		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();
		theFrame.setVisible(true);
	}
}
