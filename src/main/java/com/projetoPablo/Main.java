package com.projetoPablo;

public class Main {
    public static void main(String[] args) {
        Paciente p1 = new Paciente("Xivu", "00000000000", "00/00/0000", "saude+@gmail.com", "saude+123", "verde", "20:34");

        System.out.println(p1.toString());
        p1.login("saude+@gmail.com", "saude+123");
    }
}