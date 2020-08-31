package assignment3java.incomeReport;

import java.util.Comparator;

public class CustomComparator implements Comparator<IncomeOutput>{

	@Override
	public int compare(IncomeOutput o1, IncomeOutput o2) {
		if(!o1.getZone().equalsIgnoreCase(o2.getZone()))
			return o1.getZone().compareToIgnoreCase(o2.getZone());
		else 
			return Character.valueOf(o1.getGender()).compareTo(o2.getGender());
	}
	
}
