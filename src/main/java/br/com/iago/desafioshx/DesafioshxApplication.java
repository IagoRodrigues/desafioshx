package br.com.iago.desafioshx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * <h1>Main Application</h1>
 * 
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class DesafioshxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioshxApplication.class, args);
	}

}
