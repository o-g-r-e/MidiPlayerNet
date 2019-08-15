package com.my.drum;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class Main {
	public static void main(String[] args) {
		try {
			MidiPlayer midiPlayer = new MidiPlayer();
			DrumPlayerGui gui = new DrumPlayerGui();
			midiPlayer.setTickEventListener(gui);
			midiPlayer.play();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}
