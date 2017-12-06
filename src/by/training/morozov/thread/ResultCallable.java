package by.training.morozov.thread;

import java.util.concurrent.Callable;

public class ResultCallable implements Callable<String> {

	private Lot lot;
	
	@Override
	public String call() throws Exception {
		String result;
		Bid bid = lot.getBids().getLast();
		if (bid != null) {
			result = "The lot #" + lot.getLotId() + "was sold to the client #"
					+ bid.getClient().getClientId() + " for" + bid.getPrice();
		} else {
			result = "The lot #" + lot.getLotId() + "was not sold.";
		}
		System.out.println(result);
		return result;
	}
	
}
