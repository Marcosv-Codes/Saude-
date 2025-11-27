package com.projetoPablo;

import java.util.ArrayList;
import java.util.List;

public class UPA {
    // ATRIBUTOS
    private String nome;
    private String endereco;
    private ArrayList<Paciente> filaVerde;
    private ArrayList<Paciente> filaAmarela;
    private ArrayList<Paciente> filaVermelha;

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

    // MÉTODOS
    public void adicionarPacienteFila(Paciente paciente) {
        // SEM LOGICA
    }


    public Paciente chamarProximo(Prioridade prioridade) {
        return null; // SEM LOGICA
    }

    public double getTempoMedioEspera() {
        return 0.0; // SEM LOGICA
    }

    public boolean removerPaciente(Paciente paciente) {
        return false; // SEM LOGICA
    }

    public int posicaoNaFila(Paciente paciente) {
        return 0; // SEM LOGICA
    }

}
