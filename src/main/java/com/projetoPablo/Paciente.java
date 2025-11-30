package com.projetoPablo;

public class Paciente extends Pessoa{
    // ATRIBUTOS
    private String email;
    private String senha;
    private Prioridade prioridade; // VERDE, AMARELA, VERMELHA
    private String chegadaFilaTimestamp;

    // GETTERS E SETTERS
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public String getChegadaFilaTimestamp() {
        return chegadaFilaTimestamp;
    }
    public void setChegadaFilaTimestamp(String chegadaFilaTimestamp) {
        this.chegadaFilaTimestamp = chegadaFilaTimestamp;
    }

    // CONSTRUTOR
    public Paciente(String nome, String cpf, String dataNascimento, String email, String senha, String chegadaFilaTimestamp) {
        super(nome, cpf, dataNascimento);
        this.email = email;
        this.senha = senha;
        this.chegadaFilaTimestamp = chegadaFilaTimestamp;
        this.prioridade = null; // inicia sem prioridade, definida na triagem
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Paciente{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", chegadaFilaTimestamp='" + chegadaFilaTimestamp + '\'' +
                "} " + super.toString();
    }

    // MÉTODOS
    public boolean login(String email, String senha){
        // VERIFICA VALORES NULOS
        if(email == null || this.email == null || senha == null || this.senha == null){
            return false;
        }

        // COMPARA O E-MAIL E SENHA INSERIDOS:
        boolean emailCorreto = this.email.equals(email);
        boolean senhaCorreta = this.senha.equals(senha);
        boolean logouComSucesso = emailCorreto && senhaCorreta;

        if(logouComSucesso) {
            System.out.println("Verificando email e senha...");
            System.out.println(getNome() + " Logado com sucesso!");
        } else {
            System.out.println("Login falhou! E-mail ou senha incorretos!");
        }

        return logouComSucesso;
    }


    // transforma o paciente em uma linha de texto para salvar no arquivo
    public String toCSV() {
        String prioridadeStr = (prioridade != null) ? prioridade.name() : "";
        String chegadaStr = (chegadaFilaTimestamp != null) ? chegadaFilaTimestamp : "";

        return String.join(",",
                getNome(),              // vem de Pessoa
                getCpf(),               // vem de Pessoa
                getDataNascimento(),    // vem de Pessoa
                email,
                senha,
                prioridadeStr,
                chegadaStr
        );
    }

    // recria um paciente
    public static Paciente fromCSV(String linha) {
        if (linha == null || linha.isEmpty()) {
            return null;
        }

        String[] partes = linha.split(",");

        // nome, cpf, dataNascimento, email, senha, prioridade, chegada
        if (partes.length < 7) {
            return null;
        }

        String nome = partes[0];
        String cpf = partes[1];
        String dataNascimento = partes[2];
        String email = partes[3];
        String senha = partes[4];
        String prioridadeStr = partes[5];
        String chegada = partes[6];

        Prioridade prioridade = null;
        if (!prioridadeStr.isEmpty()) {
            try {
                prioridade = Prioridade.valueOf(prioridadeStr);
            } catch (IllegalArgumentException e) {
                prioridade = null; // se vier prioridade inválida, deixa null
            }
        }

        // usa o MESMO construtor que já existe hoje:
        Paciente p = new Paciente(nome, cpf, dataNascimento, email, senha, chegada);
        p.setPrioridade(prioridade);

        return p;
    }


    public double verTempoEspera(){
        double tempoEspera = 0.0;
        return tempoEspera; // FALTA A LOGICA
    }
}
