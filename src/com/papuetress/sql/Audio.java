package com.papuetress.sql;

import java.io.*;
import javax.sound.sampled.*;

public class Audio {
	 void audioCheck(int i) {
		if (i == 0) {
			try {
				File yourFile = new File(
						"res/insert.wav");
				AudioInputStream stream = AudioSystem
						.getAudioInputStream(yourFile);
				AudioFormat format = stream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			} catch (Exception e) {
				System.out.println("Error sa moara masa");
			}		
		}
		if (i == 1) {
			try {
				File yourFile = new File(
						"res/allreadyThere.wav");
				AudioInputStream stream = AudioSystem
						.getAudioInputStream(yourFile);
				AudioFormat format = stream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			} catch (Exception e) {
				System.out.println("Error sa moara masa");
			}
		}
		if (i == 2) {
			try {
				File yourFile = new File(
						"res/emailFound.wav");
				AudioInputStream stream = AudioSystem
						.getAudioInputStream(yourFile);
				AudioFormat format = stream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			} catch (Exception e) {
				System.out.println("Error sa moara masa");
			}
		}
		if (i == 3) {
			try {
				File yourFile = new File(
						"res/save.wav");
				AudioInputStream stream = AudioSystem
						.getAudioInputStream(yourFile);
				AudioFormat format = stream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			} catch (Exception e) {
				System.out.println("Error sa moara masa");
			}
		}
		if (i == 4) {
			try {
				File yourFile = new File(
						"res/empty.wav");
				AudioInputStream stream = AudioSystem
						.getAudioInputStream(yourFile);
				AudioFormat format = stream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				Clip clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			} catch (Exception e) {
				System.out.println("Error sa moara masa");
			}
		}
	}
}
