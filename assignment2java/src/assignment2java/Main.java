package assignment2java;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		String inputFile = "C:\\Users\\Aayushmaan Thakur\\eclipse-workspace\\assignment2java\\src\\assignment2java\\input.csv";
		String outputFile = "C:\\Users\\Aayushmaan Thakur\\eclipse-workspace\\assignment2java\\src\\assignment2java\\output.csv";
		List<Transaction> lst = readAndWriteTransaction.fromCSV(inputFile);
		generateFee.processFee(lst);
		readAndWriteTransaction.writeToCSV(outputFile, lst);
	}
}
