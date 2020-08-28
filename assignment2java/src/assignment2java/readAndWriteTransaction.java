package assignment2java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class readAndWriteTransaction {

	public static List<Transaction> fromCSV(String file) {
		String line = "";
		List<Transaction> lst = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				line = br.readLine();
				while ((line = br.readLine()) != null) {
					String[] trans = line.split(",");
					Transaction t = new Transaction();
					t.setId(trans[0]);
					t.setClient_id(trans[1]);
					t.setSecurity_id(trans[2]);
					try {
						t.setType(Type.valueOf(trans[3]));
					} catch (IllegalArgumentException e) {
						System.out.println(trans[3]);
					}
					
					try {
						t.setDate(new SimpleDateFormat("MM/dd/yyyy").parse(trans[4]));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						System.out.println(trans[4]);
						System.out.println("Date must be in MM/dd/yyyy format");
						e.printStackTrace();
					}
					t.setMarket_val(Double.parseDouble(trans[5]));
					t.setPriority((trans[6].equalsIgnoreCase("Y")) ? true : false);
					t.setProcessing_fee(0.0d);
					lst.add(t);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		return lst;
	}

	public static void writeToCSV(String file, List<Transaction> lst) {
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			StringBuilder sb = new StringBuilder("");
			sb.append(
					"External Transaction Id,Client Id,Security Id,Transaction Type,Transaction Date,Market Value,Priority Flag");
			sb.append("\n");
			for (Transaction t : lst) {
				sb.append(t.getId() + "," + t.getClient_id() + "," + t.getSecurity_id() + "," + t.getType().toString());
				sb.append("," + (new SimpleDateFormat("MM/dd/yyyy").format(t.getDate())) + ",");
				sb.append(Double.toString(t.getMarket_val()) + "," + Double.toString(t.getProcessing_fee()) + "\n");
			}
			writer.write(sb.toString());
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
