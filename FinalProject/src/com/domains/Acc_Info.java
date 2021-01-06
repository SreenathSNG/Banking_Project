package com.domains;

public class Acc_Info {

	private String username;
	private int acc_no, cc_no, cvv_no, balance;
	
	public Acc_Info() {
		super();
	}

	public Acc_Info(String username, int acc_no, int cc_no, int cvv_no, int balance) {
		super();
		this.username = username;
		this.acc_no = acc_no;
		this.cc_no = cc_no;
		this.cvv_no = cvv_no;
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public int getCc_no() {
		return cc_no;
	}

	public void setCc_no(int cc_no) {
		this.cc_no = cc_no;
	}

	public int getCvv_no() {
		return cvv_no;
	}

	public void setCvv_no(int cvv_no) {
		this.cvv_no = cvv_no;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Acc_Info [username=" + username + ", acc_no=" + acc_no + ", cc_no=" + cc_no + ", cvv_no=" + cvv_no
				+ ", balance=" + balance + "]";
	}
	
	
	
}
