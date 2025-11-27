package com.projetoPablo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Paciente p1 = new Paciente("Xivu", "00000000000", "00/00/0000", "saude+@gmail.com", "saude+123", Prioridade.VERDE, "20:34");

        p1.login("saude+@gmail.com", "saude+123");

        UPA upa1 = new UPA("Campo da Liga", "Rua do Prado");
        Medico medico = new Medico("Tereza", "00000000000", "00/00/0000", "12345", "12345", upa1, Prioridade.VERDE);
        medico.autenticar("12345", "12345");

        Enfermeiro enfermeiro = new Enfermeiro("Pablo", "00000000000", "00/00/0000", "123", "123", upa1);
        enfermeiro.autenticar("123", "123");
        enfermeiro.triarPaciente(p1, Prioridade.VERMELHA);

        upa1.adicionarPacienteFila(p1);

    }
}