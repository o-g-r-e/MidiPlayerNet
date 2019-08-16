package com.my.drum;


import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.JCheckBox;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class MidiPlayer {
	private Sequencer sequencer;
	private Sequence sequence;
	private Track track;
	public static final int TICKS_NUM = 16;
	
	private int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
	
	public MidiPlayer() throws MidiUnavailableException, InvalidMidiDataException {
		sequencer = MidiSystem.getSequencer();
		sequencer.open();
		sequence = new Sequence(Sequence.PPQ, 4);
		
		track = sequence.createTrack();
		initSimpleTrack(track);
		
		sequencer.setSequence(sequence);
		sequencer.setTempoInBPM(220);
	}
	
	private void initSimpleTrack(Track track) {
		for (int i = 5; i < 61; i+=4) {
			track.add(createEvent(ShortMessage.NOTE_ON, 1, i, 100, i));
			track.add(createEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, i)); //пустое событие, которое тригерит ControllerEventListener, благодар€ чему получаем вызов коллбека после каждой ноты
			track.add(createEvent(ShortMessage.NOTE_OFF, 1, i, 100, i+2));
		}
	}
	
	private void buildTrack() {
		int[] trackList = new int[16];
		
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for (int i = 0; i < 16; i++) {
			int key = instruments[i];
			
			for (int j = 0; j < MidiPlayer.TICKS_NUM; j++) {
				JCheckBox jc = 
			}
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
	
	// Examples :
	// createEvent(start_note, channel_number, note_number, note_sound_volume, tick_play_number)
	public static MidiEvent createEvent(int command, int channel, int data1, int data2, int tick) {
		MidiEvent event = null;
		ShortMessage mes = new ShortMessage();
		try {
			mes.setMessage(command, channel, data1, data2);
			event = new MidiEvent(mes, tick);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return event;
	}
}
