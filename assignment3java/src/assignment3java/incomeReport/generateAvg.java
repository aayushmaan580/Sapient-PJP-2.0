package assignment3java.incomeReport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class generateAvg {
	
	private static HashMap<String, IncomeOutput> h = new HashMap<>();	
	
	private static List<IncomeOutput> markZone(List<IncomeInput> lst) {
		List<IncomeOutput> res = new ArrayList<>();
		for (IncomeInput i : lst) {
			String zone;
			if(!i.getCountry().equals(""))
				zone = i.getCountry();
			else
				zone = i.getCity();
			String str = zone + "|" + i.getGender();
			double income = convertToUSD(i.getIncome(), i.getCurrency());
			if(h.containsKey(str)) {
				IncomeOutput obj = h.get(str);
				obj.setPopulation(obj.getPopulation() + 1L);
				obj.setTotal_income(obj.getTotal_income() + income);
			}
			else {
				IncomeOutput obj = new IncomeOutput();
				obj.setGender(i.getGender());
				obj.setPopulation(1L);
				obj.setTotal_income(income);
				obj.setZone(zone);
				h.put(str, obj);
				res.add(obj);
			}
		}
		return res;
	}
	
	public static List<IncomeOutput> computeAverage(List<IncomeInput> lst) {
		List<IncomeOutput> res = markZone(lst);
		double avg;
		for (IncomeOutput i : res) {
			avg = i.getTotal_income()/i.getPopulation();
			i.setAvg_income(avg);
		}
		return res;
	}

	private static double convertToUSD(double income, String currency) {
		switch (currency) {
		case "INR": {
			income *= 66d;
			break;
		}
		case "GBP": {
			income *= 0.67d;
			break;
		}
		case "SGD": {
			income *= 1.5d;
			break;
		}
		case "HKD": {
			income *= 8d;
			break;
		}
		}
		return income;
	}
}
