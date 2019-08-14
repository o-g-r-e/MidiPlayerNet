package com.my.drum;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;

public class MidiSimple {
	
	public static final int START_NOTE = 144;
	public static final int END_NOTE = 128;
	//public static final int CHANGE_INSTRUMENT = ;
	
	public void playTest() throws MidiUnavailableException, InvalidMidiDataException {
		
		Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		sequencer.addControllerEventListener(this, new int[]{127});
		Sequence sequence = new Sequence(Sequence.PPQ, 4);
		
		Track track = sequence.createTrack();
		
		for (int i = 5; i < 61; i+=4) {
			track.add(createEvent(MidiSimple.START_NOTE, 1, i, 100, i));
			track.add(createEvent(176, 1, 127, 0, i));
			track.add(createEvent(MidiSimple.END_NOTE, 1, i, 100, i+2));
		}
		
		sequencer.setSequence(sequence);
		sequencer.setTempoInBPM(220);
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
