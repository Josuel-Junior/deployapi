package com.eletronicos.jfctecnologia.eletronico.infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.eletronicos.jfctecnologia.usuarios.Usuario;

@Service
public class TokenService {

	public String gerarToken(Usuario usuario) {
		try {
			var algorithm = Algorithm.HMAC256("1234");
			return JWT.create().withIssuer("Eletronico_api")
					.withSubject(usuario.getLogin())
					.withExpiresAt(dataExperiração())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token");
		}
	}

	private Instant dataExperiração() {
		
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
