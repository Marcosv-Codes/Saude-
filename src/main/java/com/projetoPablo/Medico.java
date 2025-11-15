package com.projetoPablo;

public class Medico extends Funcionario{
    // ATRIBUTOS
    private String areaTrabalho; // VERDE, AMARELO, VERMELHO

    // CONSTRUTOR
    public Medico(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado, String areaTrabalho) {
        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
        this.areaTrabalho = areaTrabalho;
    }

    // GETTERS E SETTERS
    public String getAreaTrabalho() {
        return areaTrabalho;
    }

    public void setAreaTrabalho(String areaTrabalho) {
        this.areaTrabalho = areaTrabalho;
    }

    // MÉTODOS
    public void atenderPaciente(Paciente paciente) {
        // SEM LOGICA
    }

    public void encaminharParaEnfermaria(Paciente paciente) {
        // SEM LOGICA
    }

    public void finalizarAtendimento(Paciente paciente) {
        // SEM LOGICA
    }
}