package bank.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public Customer() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
