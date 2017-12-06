package by.training.morozov.thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bidding extends Thread {

	private Lot lot;
	private ArrayList<Client> clients;

	Lock locking = new ReentrantLock();

	public Bidding(Lot lot, ArrayList<Client> clients) {
		this.lot = lot;
		this.clients = clients;
	}

	public Lot getLot() {
		return lot;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void run() {
		locking.lock();
		try {
			for (int i = 0; i < 10; i++) {
				Client client = clients.get(new Random().nextInt(clients.size()));
				client.makeBid(lot);
				System.out.println("Client #" + client.getClientId() + " make bid: " + lot.getPrice() + " for lot #"
						+ lot.getLotId());
			}
		} finally {
			locking.unlock();
		}
	}

}
