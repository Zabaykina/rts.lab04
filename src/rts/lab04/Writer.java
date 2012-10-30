package rts.lab04;

import java.util.Random;

public class Writer implements Runnable {

	private Access access;
	private String name;
	private Random random = new Random();

	public Writer(Access access, String name) {
		super();
		this.access = access;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			access.startWriting(this);
			try {
				Thread.sleep(random.nextInt(10) * 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Access getLock() {
		return access;
	}

	public void setLock(Access access) {
		this.access = access;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
