package by.training.morozov.thread;

import java.math.BigDecimal;

public class Client {

	private int clientId;
	
	public Client(int clientId) {
		this.clientId = clientId;
		}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public void makeBid(Lot lot) {
		
			BigDecimal bid = lot.getPrice().multiply(new BigDecimal(1.05)).setScale(2, BigDecimal.ROUND_CEILING);
			lot.setPrice(bid);
		    lot.getBids().add(new Bid(this, bid));
	}
	}

