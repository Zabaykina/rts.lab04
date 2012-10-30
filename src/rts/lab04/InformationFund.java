package rts.lab04;

import java.util.ArrayList;
import java.util.List;

public class InformationFund {
	private List<String> resource = new ArrayList<String>();
	private Long count = 0L;

	public synchronized String read() {
		String result = "";
		for (String s : resource) {
			result += s + " ";
		}
		return result;
	}

	public synchronized String write() {
		count += 1;
		resource.add(count.toString());
		return count.toString();
	}

	public List<String> getResource() {
		return resource;
	}

	public void setResource(List<String> resource) {
		this.resource = resource;
	}

}
