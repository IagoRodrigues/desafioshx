package br.com.iago.desafioshx.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <h1>This class represents a currency</h1>
 * 
 * Labels:</br>
 * Code: currency from</br>
 * Codein: currency to</br>
 * Example:</br>
 * Code: USD, Codein: BRL = USD to BRL</br>
 * 
 * Name: Name of currency in PT-BR</br>
 * high: maximum value</br>
 * low: lowest value</br>
 * varBid: variation</br>
 * pctChange: percent variation</br>
 * bid: buy value</br>
 * ask: sell value</br>
 * timestamp: timestamp from data creation</br>
 * create_date: date of data creation</br>
 */
@Entity
public class Moeda {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String codein;
	private String name;
	private double high;
	private double low;
	private double varBid;
	private double pctChange;
	private double bid;
	private double ask;
	private Timestamp timeStamp;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodein() {
		return codein;
	}

	public void setCodein(String codein) {
		this.codein = codein;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getVarBid() {
		return varBid;
	}

	public void setVarBid(double varBid) {
		this.varBid = varBid;
	}

	public double getPctChange() {
		return pctChange;
	}

	public void setPctChange(double pctChange) {
		this.pctChange = pctChange;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public Timestamp getTimestamp() {
		return timeStamp;
	}
	public void setTimestamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moeda other = (Moeda) obj;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}
}
