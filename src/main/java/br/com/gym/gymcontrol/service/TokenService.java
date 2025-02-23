package br.com.gym.gymcontrol.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${origens.jwt.expiration}")
    private String tempoExpiracao;

    @Value("${origens.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authenticate) {
	Usuario usuario = (Usuario) authenticate.getPrincipal();

	Date dataCriacaoToken = new Date();
	Date dataExpiracaoToken = new Date(dataCriacaoToken.getTime() + Long.parseLong(tempoExpiracao));

	return Jwts.builder().setIssuer("API Origens BJJ") // Noem da app quando o cliente for gerar token
		.setSubject(usuario.getId().toString()) // passando identificador unico de usuario do token gerado
		.setIssuedAt(dataCriacaoToken) // data de criacao do token
		.setExpiration(dataExpiracaoToken) // data de expiracao do token
		.signWith(SignatureAlgorithm.HS256, secret) // forma de encriptacao e codigo de encriptacao
		.compact();
    }

}
