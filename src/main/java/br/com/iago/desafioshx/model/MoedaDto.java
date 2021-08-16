package br.com.iago.desafioshx.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>This class is a DTO = Data Transfer Object</h1>
 * 
 * Just to send the right attributes from the database to front.</br>
 * high = highest value</br>
 * timestamp = timestamp from data creation</br>
 *
 */
public class MoedaDTO {
	
	private double high;
	private Timestamp time_stamp;
	
	public MoedaDTO(Moeda moeda) {
		super();
		this.high = moeda.getHigh();
		this.time_stamp = moeda.getTimestamp();
	}
		
	public double getHigh() {
		return high;
	}

	public Timestamp getTimestamp() {
		return time_stamp;
	}
	
	/**
	 * This method convert a Moeda to MoedaDTO and returns a list
	 * of this type.</br>
	 * 
	 * @param moedas
	 * @return list of MoedaDTO with value and timeStamp
	 */
	public static List<MoedaDTO> converter(List<Moeda> moedas) {
		return moedas.stream().map(MoedaDTO::new).collect(Collectors.toList());
	}
}
