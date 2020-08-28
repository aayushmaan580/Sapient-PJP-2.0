package assignment2java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class generateFee {

	static List<Map<String, Transaction>> arr = new ArrayList<>(4);

	public static void processFee(List<Transaction> lst) {
		for (int i = 0; i < 4; i++)
			arr.add(new HashMap<String, Transaction>());
		String key;
		for (Transaction t : lst) {
			key = t.getClient_id() + "|" + t.getSecurity_id() + "|" + t.getDate().toString();
			arr.get(t.getType().ordinal()).put(key, t);
		}
		processIntraDayFee();
		processNormalFee(lst);
		Collections.sort(lst);
	}

	private static void processIntraDayFee() {
		String key;
		for (Map.Entry<String, Transaction> e : arr.get(0).entrySet()) {
			key = e.getKey();
			if (arr.get(1).containsKey(key)) {
				arr.get(0).get(key).setProcessing_fee(10.0d);
				arr.get(1).get(key).setProcessing_fee(10.0d);
			}
		}
		for (Map.Entry<String, Transaction> e : arr.get(2).entrySet()) {
			key = e.getKey();
			;
			if (arr.get(3).containsKey(key)) {
				arr.get(2).get(key).setProcessing_fee(10.0d);
				arr.get(3).get(key).setProcessing_fee(10.0d);
			}
		}
	}

	private static void processNormalFee(List<Transaction> lst) {
		for (Transaction txn : lst) {
			if(txn.getProcessing_fee()==0.0d) {
				if(txn.isPriority())
					txn.setProcessing_fee(500.0d);
				else if(txn.getType().equals(Type.SELL)||txn.getType().equals(Type.WITHDRAW))
					txn.setProcessing_fee(100.0d);
				else
					txn.setProcessing_fee(50.0d);
			}
		}
	}
}
