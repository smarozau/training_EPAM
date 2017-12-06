package by.training.morozov.thread;

import java.math.BigDecimal;

public class Bid {

	private Client client;
	private BigDecimal price;
	
	public Bid(Client client, BigDecimal price) {
		this.client = client;
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
