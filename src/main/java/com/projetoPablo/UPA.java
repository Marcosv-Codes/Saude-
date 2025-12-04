package com.projetoPablo;

import java.util.ArrayList;
import java.io.*;

public class UPA {
    // ATRIBUTOS
    private String nome;
    private String endereco;
    private ArrayList<Paciente> filaVerde;
    private ArrayList<Paciente> filaAmarela;
    private ArrayList<Paciente> filaVermelha;

    // ARQUIVO DE PACIENTES (SUA PARTE)
    private static final String ARQUIVO_PACIENTES = "pacientes.txt";

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Paciente> getFilaVerde() {
        return filaVerde;
    }

    public void setFilaVerde(ArrayList<Paciente> filaVerde) {
        this.filaVerde = filaVerde;
    }

    public ArrayList<Paciente> getFilaAmarela() {
        return filaAmarela;
    }

    public void setFilaAmarela(ArrayList<Paciente> filaAmarela) {
        this.filaAmarela = filaAmarela;
    }

    public ArrayList<Paciente> getFilaVermelha() {
        return filaVermelha;
    }

    public void setFilaVermelha(ArrayList<Paciente> filaVermelha) {
        this.filaVermelha = filaVermelha;
    }

    // CONSTRUTOR
    public UPA(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.filaVerde = new ArrayList<>();
        this.filaAmarela = new ArrayList<>();
        this.filaVermelha = new ArrayList<>();
    }

    // TO-STRING
    @Override
    public String toString() {
        return "UPA{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", filaVerde=" + filaVerde +
                ", filaAmarela=" + filaAmarela +
                ", filaVermelha=" + filaVermelha +
                '}';
    }

    // MÉTODOS DO GRUPO (NÃO MEXI)
    public void adicionarPacienteFila(Paciente paciente) throws PacienteInvalidoException {
        if (paciente == null) {
            throw new PacienteInvalidoException("Usuário Inválido");
        }

        if (paciente.getPrioridade() == null) {
            throw new PacienteInvalidoException("⚠️ O paciente " + paciente.getNome() + " ainda não passou pela triagem!");
        }

        switch (paciente.getPrioridade()) {
            case VERDE:
                filaVerde.add(paciente);
                break;
            case AMARELA:
                filaAmarela.add(paciente);
                break;
            case VERMELHA:
                filaVermelha.add(paciente);
                break;
        }
    }

    public Paciente chamarProximo(Prioridade prioridade) {
        return null; // SEM LOGICA
    }

    public double getTempoMedioEspera() {
        return 0.0; // SEM LOGICA
    }

    public boolean removerPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }

        boolean removido = false;

        if (filaVerde != null) {
            for (int i = 0; i < filaVerde.size(); i++) {
                if (filaVerde.get(i).getCpf().equals(paciente.getCpf())) {
                    filaVerde.remove(i);
                    removido = true;

                    System.out.println("======================================================================");
                    System.out.println("🎉 O paciente " + paciente.getNome() + " teve alta! 🏥");
                    System.out.println("📃 Status: Recebeu alta médica e foi removido da fila VERDE.");
                    System.out.println("======================================================================");

                    break;
                }
            }
        }

        if (!removido && filaAmarela != null) {
            for (int i = 0; i < filaAmarela.size(); i++) {
                if (filaAmarela.get(i).getCpf().equals(paciente.getCpf())) {
                    filaAmarela.remove(i);
                    removido = true;

                    System.out.println("======================================================================");
                    System.out.println("🎉 O paciente " + paciente.getNome() + " teve alta! 🏥");
                    System.out.println("📃 Status: Recebeu alta médica e foi removido da fila AMARELA.");
                    System.out.println("======================================================================");

                    break;
                }
            }
        }

        if (!removido && filaVermelha != null) {
            for (int i = 0; i < filaVermelha.size(); i++) {
                if (filaVermelha.get(i).getCpf().equals(paciente.getCpf())) {
                    filaVermelha.remove(i);
                    removido = true;

                    System.out.println("======================================================================");
                    System.out.println("🎉 O paciente " + paciente.getNome() + " teve alta! 🚑");
                    System.out.println("📃 Status: Recebeu alta médica e foi removido da fila VERMELHA.");
                    System.out.println("======================================================================");

                    break;
                }
            }
        }

        return removido;
    }

    public int posicaoNaFila(Paciente paciente) {
        return 0; // SEM LOGICA
    }

    // SALVA todos os pacientes das filas em um arquivo .txt
    public void salvarPacientesEmArquivo() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ARQUIVO_PACIENTES)))) {

            for (Paciente p : filaVerde) {
                pw.println(p.toCSV());
            }
            for (Paciente p : filaAmarela) {
                pw.println(p.toCSV());
            }
            for (Paciente p : filaVermelha) {
                pw.println(p.toCSV());
            }

            System.out.println("💾 Pacientes salvos em " + ARQUIVO_PACIENTES);
        } catch (IOException e) {
            System.out.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    // CARREGA pacientes do arquivo e recoloca nas filas
    public void carregarPacientesDoArquivo() {
        filaVerde.clear();
        filaAmarela.clear();
        filaVermelha.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_PACIENTES))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                try {
                    Paciente p = Paciente.fromCSV(linha);
                    adicionarPacienteFila(p);
                } catch (PacienteInvalidoException e) {
                    System.out.println("⚠️ Erro ao ler paciente do arquivo: " + e.getMessage());
                }
            }

            System.out.println("📂 Pacientes carregados de " + ARQUIVO_PACIENTES);

        } catch (FileNotFoundException e) {
            System.out.println("Nenhum arquivo de pacientes encontrado (primeira execução).");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de pacientes: " + e.getMessage());
        }
    }
}
