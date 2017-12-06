package by.training.morozov.thread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AuctionRunner {

	public static void main(String[] args) {

		ArrayList<Lot> lots = new ArrayList<Lot>();
		for (int i = 0; i < new Random().nextInt(5); i++) {
			lots.add(new Lot(i, new BigDecimal(new Random().nextInt(100)), new LinkedList<Bid>()));
			System.out.println("Lot #" + i + " is ready for sale!");
		}

		ArrayList<Client> clients = new ArrayList<Client>();
		for (int i = 0; i < new Random().nextInt(5); i++) {
			clients.add(new Client(i));
			System.out.println("Client #" + i + " is ready!");
		}
		
		ArrayList <Callable<String>> tasks = new ArrayList<Callable<String>>(); 

		Auction auction = Auction.getInstance();
		ExecutorService es = Executors.newFixedThreadPool(lots.size());
		for (int i = 0; i < lots.size(); i++) {
			Lot lot = lots.get(i);
			es.execute(auction.startBidding(lot, clients));
			ResultCallable result = new ResultCallable();
			es.submit(result);
			tasks.add(result);
		}
		es.shutdown();
		try {
			es.invokeAll(tasks, 1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
