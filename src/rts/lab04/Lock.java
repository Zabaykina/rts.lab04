package rts.lab04;

import java.util.ArrayList;
import java.util.List;

public class Lock {

	private List<Runnable> accessList = new ArrayList<Runnable>();

	public Lock() {
		super();
	}

	/**
	 * @return the accessList
	 */
	public List<Runnable> getAccessList() {
		return accessList;
	}

	/**
	 * @param accessList the accessList to set
	 */
	public void setAccessList(List<Runnable> accessList) {
		this.accessList = accessList;
	}


	
}
