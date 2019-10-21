package br.com.bandtec.agendadeobjetivos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.bandtec.agendadeobjetivos.domain.Token;

import java.util.ArrayList;

@SpringBootApplication
public class RememberApplication {
	public static void main(String[] args) {
		try {
			Token.lerArquivo("historico", true);
		} catch (Exception e) {
			Token.gravaArquivo(new ArrayList<>(), "historico", true);
		}

		SpringApplication.run(RememberApplication.class, args);
	}
}
