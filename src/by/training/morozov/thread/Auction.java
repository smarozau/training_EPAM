package by.training.morozov.thread;

import java.util.ArrayList;

public class Auction {

	private final static Auction INSTANCE = new Auction();
	
	
	public Bidding startBidding(Lot lot, ArrayList<Client> clients) {
		return new Bidding(lot, clients);
	};
	
	public static Auction getInstance() {
		return INSTANCE;
	}
		
}
