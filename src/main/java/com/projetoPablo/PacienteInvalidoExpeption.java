package com.projetoPablo;

public class PacienteInvalidoExpeption extends RuntimeException {
    public PacienteInvalidoExpeption(String message) {
        super(message);
    }

}