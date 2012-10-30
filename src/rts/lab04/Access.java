package rts.lab04;

import javax.swing.JTextArea;

public class Access {

	private Mode mode = Mode.WRITE;

	private Lock readerLock = new Lock();
	private Lock writerLock = new Lock();
	private JTextArea textArea;

	private InformationFund fund = new InformationFund();

	public Access(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void init() {
		synchronized (writerLock) {
			writerLock.notify();
		}
	}

	public void startReading(Reader reader) {
		try {
			if (Mode.WRITE == mode) {
				synchronized (readerLock) {
					readerLock.wait();
				}
			}
			textArea.append(reader.getName() + " start read \n");
			synchronized (mode) {
				mode = Mode.READ;
			}
			textArea.append(reader.getName() + " has read string: "
					+ fund.read()+"\n");
			textArea.append(reader.getName() + " stop read \n");
			synchronized (writerLock) {
				writerLock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void startWriting(Writer writer) {
		try {
			if (Mode.FREE != mode) {
				synchronized (writerLock) {
					writerLock.wait();
				}
			}
			textArea.append(writer.getName() + " start write \n");
			synchronized (mode) {
				mode = Mode.WRITE;
			}
			String s = fund.write();
			textArea.append(writer.getName() + " has write string: " + s +"\n");

			textArea.append(writer.getName() + " stop write \n");
			synchronized (mode) {
				mode = Mode.FREE;
			}
			synchronized (readerLock) {
				readerLock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Lock getReaderLock() {
		return readerLock;
	}

	public void setReaderLock(Lock readerLock) {
		this.readerLock = readerLock;
	}

	public Lock getWriterLock() {
		return writerLock;
	}

	public void setWriterLock(Lock writerLock) {
		this.writerLock = writerLock;
	}

	public InformationFund getFund() {
		return fund;
	}

	public void setFund(InformationFund fund) {
		this.fund = fund;
	}

}
