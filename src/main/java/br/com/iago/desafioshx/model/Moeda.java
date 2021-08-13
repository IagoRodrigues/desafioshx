package br.com.iago.desafioshx.model;

import java.sql.Timestamp;

/**
 * This class represents a currency with
 * highest value and the timestamp of the requisition.
 * 
 * Labels:
 * high = maximum value
 * timestamp = timestamp
 */
public class Moeda {
	private double high;
	private Timestamp timestamp;
		
	public Moeda(double high, Timestamp timestamp) {
		super();
		this.high = high;
		this.timestamp = timestamp;
	}
	
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
}
