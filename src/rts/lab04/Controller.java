package rts.lab04;

import javax.swing.JTextArea;

public class Controller {
	Access access;

	public Controller(JTextArea textArea) {
		this.access = new Access(textArea);
	}

	public void start(int readerCount, int writerCount) {
		for (int i = 1; i <= writerCount; i++) {
			new Thread(new Writer(access, "writer-" + i)).start();
		}
		access.init();
		for (int i = 1; i <= readerCount; i++) {
			new Thread(new Reader(access, "reader-" + i)).start();
		}
		
	}

	public void stop() {

	}

}
