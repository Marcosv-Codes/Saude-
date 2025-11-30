package com.projetoPablo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // UPA CRIADA
        UPA upa1 = new UPA("Campo da Liga", "Rua do Prado");

        // CARREGAR PACIENTES DO ARQUIVO (se existir)
        upa1.carregarPacientesDoArquivo();

        // ENFERMEIRO CRIADO
        Enfermeiro enfermeiro = new Enfermeiro("Pablo", "99999999999",
                "10/10/1980", "123", "12345", upa1);

        // ATENDENTE CRIADO
        Atendente atendente = new Atendente("Chico Carlos", "44444444444",
                "04/04/2004", "1234", "12345", upa1);

        // MÉDICO CRIADO
        Medico medico = new Medico("Lucio", "555555555555",
                "05/05/2005", "54321", "54321", upa1, Prioridade.VERDE);

        // pacienre 1 pedro
        Paciente p1 = new Paciente("Pedro SUPREMO", "11111111111",
                "01/01/2001", "saude1+@gmail.com", "saude+1", "20:34");

        enfermeiro.autenticar("123", "12345");
        atendente.autenticar("1234", "12345");

        p1.login("saude1+@gmail.com",  "saude+1");
        enfermeiro.triarPaciente(p1, Prioridade.VERDE);
        atendente.cadastrarPaciente(p1);
        atendente.adicionarFila(p1, upa1);

        // ALDO novo paciente
        Paciente aldo = new Paciente("Aldo", "22222222222",
                "02/02/2002", "aldo@gmail.com", "aldo123", "20:35");

        aldo.login("aldo@gmail.com", "aldo123");
        enfermeiro.triarPaciente(aldo, Prioridade.AMARELA);
        atendente.cadastrarPaciente(aldo);
        atendente.adicionarFila(aldo, upa1);

        // MOSTRAR FILAS
        System.out.println("\n--- FILAS ATUAIS ---");
        System.out.println("Fila Verde: " + upa1.getFilaVerde());
        System.out.println("Fila Amarela: " + upa1.getFilaAmarela());
        System.out.println("Fila Vermelha: " + upa1.getFilaVermelha());

        // FLUXO DO PRIMEIRO PACIENTE
        enfermeiro.encaminharParaMedico(p1);
        medico.atenderPaciente(p1);
        enfermeiro.finalizarAtendimento(p1);

        System.out.println("\n--- FILAS APÓS ATENDIMENTO DO PEDRO ---");
        System.out.println("Fila Verde: " + upa1.getFilaVerde());
        System.out.println("Fila Amarela: " + upa1.getFilaAmarela());
        System.out.println("Fila Vermelha: " + upa1.getFilaVermelha());

        // salva o paciente no arquivo
        upa1.salvarPacientesEmArquivo();

        // mostra o conteudo do arquivo
        mostrarPacientesSalvos();
    }

    // MÉTODO pra ler o arquivo de pacientes
    public static void mostrarPacientesSalvos() {
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {

            System.out.println("\n--- PACIENTES SALVOS NO ARQUIVO ---");

            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}
