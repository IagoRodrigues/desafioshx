package br.com.iago.desafioshx.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iago.desafioshx.model.Moeda;

@FeignClient(name = "moeda", url = "https://economia.awesomeapi.com.br/json")
public interface ClientFeign {
	
	@RequestMapping(method = RequestMethod.GET, value = "/USD-BRL")
	List<Moeda> getMoeda();
}
