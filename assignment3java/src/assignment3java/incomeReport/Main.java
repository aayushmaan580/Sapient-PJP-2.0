package assignment3java.incomeReport;

import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String inputFile = "C:\\Users\\Aayushmaan Thakur\\eclipse-workspace\\assignment3java\\resources\\input.csv";
		String outputFile = "C:\\Users\\Aayushmaan Thakur\\eclipse-workspace\\assignment3java\\resources\\output.csv";
		printReport(inputFile, outputFile);
	}

	private static void printReport(String inputFile, String outputFile) {
		List<IncomeOutput> lst = generateAvg.computeAverage(ReadAndWriteZonewiseIncome.fromCSV(inputFile));
		Collections.sort(lst, new CustomComparator());
		ReadAndWriteZonewiseIncome.writeToCSV(outputFile, lst);
	}

}

