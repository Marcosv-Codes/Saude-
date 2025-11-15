package com.projetoPablo;

public class Enfermeiro extends Funcionario{
    // TALVEZ ACRESCENTAR UMA AREA DE TRABALHO PARA O ENFERMEIRO... SENDO: TRIAGEM OU ENFERMARIA (PARECIDO COM A DO MEDICO)

    // CONSTRUTOR
    public Enfermeiro(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado) {
        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
    }

    // MÉTODOS
    public void triarPaciente(Paciente paciente, String prioridade){ // VERDE, AMARELA, VERMELHA
        // SEM LOGICA
    }

    public void finalizarAtendimento(Paciente paciente){
        // SEM LOGICA
    }

    public void encaminharParaMedico(Paciente paciente){
        // SEM LOGICA
    }
}
