package com.projetoPablo;

public class Paciente extends Pessoa {

    private String email;
    private String senha;
    private Prioridade prioridade;
    private String horarioChegada;

    // CONSTRUTOR USADO PELO SEU GRUPO (SEM PRIORIDADE)
    public Paciente(String nome, String cpf, String dataNascimento,
                    String email, String senha, String horarioChegada) {
        this(nome, cpf, dataNascimento, email, senha, null, horarioChegada);
    }

    // CONSTRUTOR COMPLETO (COM PRIORIDADE) - pode ser usado no futuro
    public Paciente(String nome, String cpf, String dataNascimento,
                    String email, String senha, Prioridade prioridade,
                    String horarioChegada) {
        super(nome, cpf, dataNascimento);
        this.email = email;
        this.senha = senha;
        this.prioridade = prioridade;
        this.horarioChegada = horarioChegada;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getEmail() {
        return email;
    }

    public String getHorarioChegada() {
        return horarioChegada;
    }

    // >>> ESTE MÉTODO É SÓ PRA NÃO DAR ERRO NO ATENDENTE <<<
    // (ele chama getChegadaFilaTimestamp, então a gente fornece)
    public String getChegadaFilaTimestamp() {
        return horarioChegada;
    }

    // Login simples, só pra testar
    public boolean login(String email, String senha) {
        boolean ok = this.email.equals(email) && this.senha.equals(senha);
        System.out.println(ok ? "Login de paciente OK" : "Login de paciente FALHOU");
        return ok;
    }

    // =============== ARQUIVOS ===============

    // Transforma o paciente em uma linha de texto (CSV)
    public String toCSV() {
        // nome;cpf;dataNasc;email;senha;prioridade;horario
        return String.join(";",
                getNome(),
                getCpf(),
                getDataNascimento(),
                email,
                senha,
                prioridade != null ? prioridade.name() : "",
                horarioChegada != null ? horarioChegada : ""
        );
    }

    // Reconstrói o paciente a partir de uma linha de texto
    public static Paciente fromCSV(String linha) throws PacienteInvalidoException {
        if (linha == null || linha.isEmpty()) {
            throw new PacienteInvalidoException("Linha vazia ao ler paciente.");
        }

        String[] partes = linha.split(";");
        if (partes.length < 7) {
            throw new PacienteInvalidoException("Dados incompletos de paciente: " + linha);
        }

        String nome = partes[0];
        String cpf = partes[1];
        String dataNasc = partes[2];
        String email = partes[3];
        String senha = partes[4];
        String prioridadeStr = partes[5];
        String horario = partes[6];

        Prioridade prioridade = null;
        if (!prioridadeStr.isEmpty()) {
            try {
                prioridade = Prioridade.valueOf(prioridadeStr);
            } catch (IllegalArgumentException e) {
                throw new PacienteInvalidoException("Prioridade inválida ao ler paciente: " + prioridadeStr);
            }
        }

        return new Paciente(nome, cpf, dataNasc, email, senha, prioridade, horario);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }

    // Para funcionar corretamente com List.remove(paciente)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente p = (Paciente) o;
        return this.getCpf() != null && this.getCpf().equals(p.getCpf());
    }

    @Override
    public int hashCode() {
        return getCpf() != null ? getCpf().hashCode() : 0;
    }
}
