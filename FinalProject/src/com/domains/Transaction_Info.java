package com.domains;
import java.util.Date;
public class Transaction_Info {
	
	private int sl, withdraw, deposit, balance;
	private String description, username;
	private Date date;
	public Transaction_Info() {
	}

	public Transaction_Info(Date date, String description, String username, int deposit, int balance) {
		super();
		this.date = date;
		this.description = description;
		this.deposit = deposit;
		this.username = username;
		this.balance = balance;
	}
	public Transaction_Info(Date date, String description, int withdraw, String username, int balance) {
		super();
		this.date = date;
		this.description = description;
		this.withdraw = withdraw;
		this.username = username;
		this.balance = balance;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction_Info [sl=" + sl + ", withdraw=" + withdraw + ", deposit=" + deposit + ", balance=" + balance
				+ ", description=" + description + ", username=" + username + ", date=" + date + "]";
	}

	
	
	
	

}
