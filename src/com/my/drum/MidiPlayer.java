package com.my.drum;


import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class MidiPlayer {
	
	public static final int START_NOTE = 144;
	public static final int END_NOTE = 128;
	//public static final int CHANGE_INSTRUMENT = ;
	private Sequencer sequencer;
	
	public MidiPlayer() throws MidiUnavailableException, InvalidMidiDataException {
		sequencer = MidiSystem.getSequencer();
		sequencer.open();
		Sequence sequence = new Sequence(Sequence.PPQ, 4);
		
		initTrack(sequence.createTrack());
		
		sequencer.setSequence(sequence);
		sequencer.setTempoInBPM(220);
	}
	
	private void initTrack(Track track) {
		for (int i = 5; i < 61; i+=4) {
			track.add(createEvent(MidiPlayer.START_NOTE, 1, i, 100, i));
			track.add(createEvent(176, 1, 127, 0, i));
			track.add(createEvent(MidiPlayer.END_NOTE, 1, i, 100, i+2));
		}
	}
	
	public void setTickEventListener(ControllerEventListener c) {
		if(sequencer != null) {
			sequencer.addControllerEventListener(c, new int[]{127});
		}
	}
	
	public void play() {
		sequencer.start();
	}
	
	public static MidiEvent createEvent(int cmd, int chanel, int a, int b, int tick) {
		MidiEvent event = null;
		ShortMessage mes = new ShortMessage();
		try {
			mes.setMessage(cmd, chanel, a, b);
			event = new MidiEvent(mes, tick);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return event;
	}
}
