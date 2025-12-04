package com.projetoPablo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // UPA CRIADA
        UPA upa1 = new UPA("Campo da Liga", "Rua do Prado");

        // ENFERMEIRO CRIADO
        Enfermeiro enfermeiro = new Enfermeiro("Pablo", "99999999999", "10/10/1980", "123", "12345", upa1);

        //  ATENDENTE CRIADO
        Atendente atendente = new Atendente("Chico Carlos", "44444444444", "04/04/2004", "1234", "12345", upa1);

        // MÉDICO CRIADO
        Medico medico = new Medico("Lucio", "555555555555", "05/05/2005", "54321", "54321", upa1, Prioridade.VERDE);

        // PACIENTE CRIADO
        Paciente p1 = new Paciente("Pedro SUPREMO", "11111111111", "01/01/2001", "saude1+@gmail.com", "saude+1", "20:34");
        Paciente p2 = new Paciente("Paulo", "12345678978", "01/02/2000","paulo@gmail.com", "saude1234","10:34");
        // AUTENTICANDO FUNCIONARIOS
        enfermeiro.autenticar("123", "12345");
        atendente.autenticar("1234", "12345");

        // LOGIN DE PACIENTES
        p1.login("saude1+@gmail.com",  "saude+1");
        p2.login("paulo@gmail.com","saude1234");

        // TRIAGEM DE PACIENTES PELO ENFERMEIRO
        enfermeiro.triarPaciente(p1, Prioridade.VERDE);


        // CADASTRO DE PACIENTES PELO ATENDENTE
        atendente.cadastrarPaciente(p1);

        // PACIENTES ADICIONADOS NA FILA PELO ATENDENTE
        //atendente.adicionarFila(null, upa1);


        // TESTE
        System.out.println(upa1.getFilaVerde());
        enfermeiro.encaminharParaMedico(p1);
        medico.atenderPaciente(p1);
        medico.encaminharParaEnfermaria(p1);
        enfermeiro.finalizarAtendimento(p1);

        //System.out.println(upa1.getFilaVerde());

        // TESTE try catch
        enfermeiro.triarPaciente(p2, Prioridade.VERMELHA);
        atendente.adicionarFila(p2, upa1);


        //TESTE PARA FINALIZAR ATENDIMENTO NA ENFERMARIA
        enfermeiro.finalizarAtendimento(p1);

        // 1) SALVA todos os pacientes das filas em um arquivo .txt
        upa1.salvarPacientesEmArquivo();

        // 2) LIMPA as filas só para testar o carregamento
        upa1.getFilaVerde().clear();
        upa1.getFilaAmarela().clear();
        upa1.getFilaVermelha().clear();

        // 3) CARREGA novamente os pacientes do arquivo
        upa1.carregarPacientesDoArquivo();

        System.out.println("Filas após carregar do arquivo:");
        System.out.println("VERDE   -> " + upa1.getFilaVerde());
        System.out.println("AMARELA -> " + upa1.getFilaAmarela());
        System.out.println("VERMELHA-> " + upa1.getFilaVermelha());
    }
}