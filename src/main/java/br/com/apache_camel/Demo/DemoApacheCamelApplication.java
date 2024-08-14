package br.com.apache_camel.Demo;

import org.apache.camel.spring.boot.security.CamelSSLAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;

@SpringBootApplication
public class DemoApacheCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApacheCamelApplication.class, args);
	}

}
