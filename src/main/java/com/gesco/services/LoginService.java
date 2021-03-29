package com.gesco.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gesco.config.JWTConstants;
import com.gesco.domain.Funcionario;
import com.gesco.domain.Hospital;
import com.gesco.dto.LoginDTO;
import com.gesco.dto.SessaoDTO;
import com.gesco.repositories.FuncionarioRepository;
import com.gesco.services.exceptions.ObjectNotFoundException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class LoginService {
	
	@Autowired
	private FuncionarioRepository repoFunc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public SessaoDTO validarLogin(LoginDTO loginDto){
		
		try {
			
			Optional<Funcionario> login = repoFunc.findByLogin(loginDto.getLogin());
			
			if (login.isPresent()) {
				
				Funcionario funcionario = login.get();
				
				
				boolean validPassword = passwordEncoder.matches(loginDto.getSenha(), funcionario.getSenha());
				
				if (!validPassword) {
					throw new ObjectNotFoundException("Senha incorreta: " + loginDto.getSenha());
				}
				
				long tempoToken = 1 * 60 * 60 * 1000;
				SessaoDTO sessao = new SessaoDTO();
				
				sessao.setDataInicio(new Date(System.currentTimeMillis()));
				sessao.setDataFim(new Date(System.currentTimeMillis() + tempoToken));
				sessao.setLogin(funcionario.getLogin());
				sessao.setToken(JWTConstants.PREFIX + getJWTToken(sessao));
				funcionario.setSenha(null);
				sessao.setFuncionario(funcionario);	
				
				return sessao;
			}	
			
		}catch (IllegalArgumentException e) {
			
			throw new IllegalArgumentException("Usuário não encontrado");
		}
		
		throw new ObjectNotFoundException("Usuário não encontrado");
		
	}
	
		
	private String getJWTToken(SessaoDTO sessao) {
		String role = "ROLE_USER";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);

		String token = Jwts.builder().setSubject(sessao.getLogin())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(sessao.getDataInicio()).setExpiration(sessao.getDataFim())
				.signWith(SignatureAlgorithm.HS512, JWTConstants.KEY.getBytes()).compact();

		return token;
	}

}
