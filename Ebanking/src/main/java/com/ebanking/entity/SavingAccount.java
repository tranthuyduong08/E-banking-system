package com.ebanking.entity;

import java.util.Date;

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
@Table(name = "saving_account")
public class SavingAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "initialAmount")
	private Integer initialAmount;
	
	@Column(name = "tenor")
	private String tenor;
	
	@Column(name = "openDate")
	private Date openDate;
	
	@Column(name = "closeDate")
	private Date closeDate;
	
	@Column(name = "description")
	private String description;

	//FK
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="saving_user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="saving_interest_id")
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
	
	public Integer getInitialAmount() {
		return initialAmount;
	}

	public void setInitialAmount(Integer initialAmount) {
		this.initialAmount = initialAmount;
	}

	public String getTenor() {
		return tenor;
	}

	public void setTenor(String tenor) {
		this.tenor = tenor;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
