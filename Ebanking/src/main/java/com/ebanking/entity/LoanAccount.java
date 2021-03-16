package com.ebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_account")
public class LoanAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tenor")
	private String tenor;
	
	@Column(name = "total_amount")
	private String totalAmount;
	
	@Column(name = "remain_amount")
	private String remainAmount;
	
	@Column(name = "open_date")
	private Integer openDate;
	
	@Column(name = "close_date")
	private Integer closeDate;
	
	@Column(name = "description")
	private String description;

	//FK
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="loan_user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="loan_interest_id")
	private InterestRate interestRate;

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public InterestRate getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(InterestRate interestRate) {
		this.interestRate = interestRate;
	}
	
	public String getTenor() {
		return tenor;
	}

	public void setTenor(String tenor) {
		this.tenor = tenor;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRemainAmount() {
		return remainAmount;
	}

	public void setRemainAmount(String remainAmount) {
		this.remainAmount = remainAmount;
	}

	public Integer getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Integer openDate) {
		this.openDate = openDate;
	}

	public Integer getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Integer closeDate) {
		this.closeDate = closeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
