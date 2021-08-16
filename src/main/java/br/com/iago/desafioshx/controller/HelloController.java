package br.com.iago.desafioshx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <h1>This class represents a test Controller</h1>
 * 
 * It just came to say hello :)
 */
@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return("Hello!");
	}

}