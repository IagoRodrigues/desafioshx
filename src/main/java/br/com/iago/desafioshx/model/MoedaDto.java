package br.com.iago.desafioshx.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>This class is a DTO = Data Transfer Object</h1>
 * 
 *Just to send the right attributes to the database.</br>
 *high = highest value</br>
 *timestamp = timestamp from data creation</br>
 *
 */
public class MoedaDto {
	
	private double high;
	private Timestamp timeStamp;
	
	public MoedaDto(Moeda moeda) {
		super();
		this.high = moeda.getHigh();
		this.timeStamp = moeda.getTimestamp();
	}
		
	public double getHigh() {
		return high;
	}

	public Timestamp getTimestamp() {
		return timeStamp;
	}

	public static List<MoedaDto> converter(List<Moeda> moedas) {
		return moedas.stream().map(MoedaDto::new).collect(Collectors.toList());
	}

}
