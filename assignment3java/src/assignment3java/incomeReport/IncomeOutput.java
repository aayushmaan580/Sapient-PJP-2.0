package assignment3java.incomeReport;

public class IncomeOutput {
	private String zone;
	private char gender;
	private double total_income;
	private long population;
	private double avg_income;

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getAvg_income() {
		return avg_income;
	}

	public void setAvg_income(double avg_income) {
		this.avg_income = avg_income;
	}

	public double getTotal_income() {
		return total_income;
	}

	public void setTotal_income(double total_income) {
		this.total_income = total_income;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}
}
