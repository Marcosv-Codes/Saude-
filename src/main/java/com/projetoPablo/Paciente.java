package com.projetoPablo;

public class Paciente extends Pessoa {

    private String email;
    private String senha;
    private Prioridade prioridade;
    private String horarioChegada;

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

    // Login simples, só pra testar
    public boolean login(String email, String senha) {
        boolean ok = this.email.equals(email) && this.senha.equals(senha);
        System.out.println(ok ? "Login de paciente OK" : "Login de paciente FALHOU");
        return ok;
    }

    // =============== ARQUIVOS ===============

    public String toCSV() {
        // nome,cpf,dataNasc,email,senha,prioridade,horario
        return String.join(";",
                nome,
                cpf,
                dataNascimento,
                email,
                senha,
                prioridade != null ? prioridade.name() : "",
                horarioChegada != null ? horarioChegada : ""
        );
    }

    public static Paciente fromCSV(String linha) throws PacienteInvalidoExpeption {
        if (linha == null || linha.isEmpty()) {
            throw new PacienteInvalidoExpeption("Linha vazia ao ler paciente.");
        }

        String[] partes = linha.split(";");
        if (partes.length < 7) {
            throw new PacienteInvalidoExpeption("Dados incompletos de paciente: " + linha);
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
                throw new PacienteInvalidoExpeption("Prioridade inválida ao ler paciente: " + prioridadeStr);
            }
        }

        return new Paciente(nome, cpf, dataNasc, email, senha, prioridade, horario);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }

    // Para funcionar corretamente com List.remove(paciente)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente p = (Paciente) o;
        return this.cpf != null && this.cpf.equals(p.cpf);
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }
}
