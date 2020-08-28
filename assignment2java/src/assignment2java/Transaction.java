package assignment2java;

import java.util.Date;

enum Type {
	BUY, SELL, DEPOSIT, WITHDRAW
}

public class Transaction implements Comparable<Transaction> {
	private String id;
	private String client_id;
	private String security_id;
	private Type type;
	private Date date;
	private double market_val;
	private boolean priority;
	private double processing_fee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getSecurity_id() {
		return security_id;
	}

	public void setSecurity_id(String security_id) {
		this.security_id = security_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMarket_val() {
		return market_val;
	}

	public void setMarket_val(double market_val) {
		this.market_val = market_val;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getProcessing_fee() {
		return processing_fee;
	}

	public void setProcessing_fee(double processing_fee) {
		this.processing_fee = processing_fee;
	}

	public int compareTo(Transaction t1) {
		if (this.getClient_id().compareTo(t1.getClient_id()) == 0) {
			if (this.getType().compareTo(t1.getType()) == 0) {
				if (this.getDate().compareTo(t1.getDate()) == 0) {
					if (this.isPriority()) {
						if (t1.isPriority())
							return 0;
						else
							return 1;
					} else if (t1.isPriority())
						return -1;
					else
						return 0;
				} else
					return this.getDate().compareTo(t1.getDate());
			}

			else
				return this.getType().compareTo(t1.getType());
		} else
			return this.getClient_id().compareTo(t1.getClient_id());
	}
}
