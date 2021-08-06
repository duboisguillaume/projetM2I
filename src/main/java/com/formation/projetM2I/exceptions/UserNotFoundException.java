package com.formation.projetM2I.exceptions;

public class UserNotFoundException  extends RuntimeException {


	public UserNotFoundException(Integer id) {
		super("Could not find employee " + id);
	}
}
