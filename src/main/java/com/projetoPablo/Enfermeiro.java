package com.projetoPablo;

public class Enfermeiro extends Funcionario{
    // TALVEZ ACRESCENTAR UMA AREA DE TRABALHO PARA O ENFERMEIRO... SENDO: TRIAGEM OU ENFERMARIA (PARECIDO COM A DO MEDICO)

    // CONSTRUTOR
    public Enfermeiro(String nome, String cpf, String dataNascimento, String matricula, String senha, UPA upaAlocado) {
        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
    }

    // MÉTODOS
    public void triarPaciente(Paciente paciente, Prioridade prioridade){
        paciente.setPrioridade(prioridade);

        // Adiciona o paciente na fila da UPA conforme a prioridade
        getUpaAlocado().adicionarPacienteFila(paciente);

        System.out.println("======================================================================");
        System.out.println("✅ TRIAGEM REALIZADA COM SUCESSO");
        System.out.println("👤 Paciente: " + paciente.getNome());
        System.out.println("📌 Prioridade definida: " + prioridade);

        switch (prioridade) {
            case VERDE -> System.out.println("🟢 Caso leve. Atendimento por ordem de chegada.");
            case AMARELA -> System.out.println("🟡 Caso moderado. Atendimento prioritário.");
            case VERMELHA -> System.out.println("🔴 Caso grave! Atendimento imediato.");
        }

        System.out.println("🏥 Encaminhado para a fila " + prioridade +
                " da UPA " + getUpaAlocado().getNome());
        System.out.println("======================================================================");
    }

    public void finalizarAtendimento(Paciente paciente){
        // SEM LOGICA
    }

    public void encaminharParaMedico(Paciente paciente){
        // SEM LOGICA
    }
}
