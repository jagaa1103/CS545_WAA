package edu.mum.service;

import org.springframework.stereotype.Service;

import edu.mum.domain.Login;

@Service
public interface LoginService
{
	public String verify(Login login);
}
