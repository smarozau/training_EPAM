package by.training.morozov.thread;

import java.math.BigDecimal;
import java.util.LinkedList;


public class Lot extends Thread {

	private int lotId;
	private BigDecimal price;
	private LinkedList<Bid> bids;
			
	public Lot(int lotId, BigDecimal price, LinkedList<Bid> bids) {
		this.lotId = lotId;
		this.price = price;
		this.bids = bids;
	}

	public int getLotId() {
		return lotId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LinkedList<Bid> getBids() {
		return bids;
	}
	
	
	}

