package net.buttology.avt.main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.buttology.avt.gui.Window;

public class Main {

	public static final String APP_NAME = "Amnesia Video Tool";
	public static final String APP_VERSION = "2.0.0";
	
	public static void main(String[] args) {
		System.out.printf("Starting %s version %s%n", APP_NAME, APP_VERSION);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				try {
					Window window = new Window();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
