package rts.lab04;

import java.util.Random;

public class Reader implements Runnable {

	private Access access;
	private String name;
	private Random random = new Random();

	public Reader(Access access, String name) {
		super();
		this.access = access;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			access.startReading(this);
			try {
				Thread.sleep(random.nextInt(10)*500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
