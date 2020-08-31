package assignment3java.incomeReport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteZonewiseIncome {

	public static List<IncomeInput> fromCSV(String file) {
		String line = "";
		List<IncomeInput> lst = new ArrayList<IncomeInput>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				line = br.readLine();
				while ((line = br.readLine()) != null) {
					String[] s = line.split(",");
					IncomeInput ip = new IncomeInput();
					ip.setCity(s[0]);
					ip.setCountry(s[1]);
					ip.setGender(Character.toUpperCase(s[2].charAt(0)));
					ip.setCurrency(s[3]);
					ip.setIncome(Double.parseDouble(s[4]));
					lst.add(ip);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		return lst;
	}

	public static void writeToCSV(String file, List<IncomeOutput> lst) {
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			StringBuilder sb = new StringBuilder("");
			sb.append("City/Country,Gender,Average Income(In USD)");
			sb.append("\n");
			for (IncomeOutput i : lst) {
				sb.append(i.getZone() + "," + i.getGender() + "," + String.format("%.2f", i.getAvg_income()) + "\n");
			}
			writer.write(sb.toString());
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
