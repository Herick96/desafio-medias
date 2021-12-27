package com.herick;

import java.util.Locale;
import java.util.Scanner;

public class Medias {

    private Integer mediaExercicios = null;
    private notasAlunos notas = new notasAlunos();


    public static void main(String[] args) {
        Medias medias = new Medias();
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        System.out.println("Informe suas notas:");

        while (medias.mediaExercicios == null) {

            medias.inputMediaExercicios(input);

            if (medias.mediaExercicios >= 0 && medias.mediaExercicios <= 10) {
                medias.inputNota1(input);
                medias.inputNota2(input);
                medias.inputNota3(input);


                System.out.println("A sua media de aproveitamento é " + medias.calculaAproveitamento());

            } else {
                System.out.println("A sua Nota tem que ser entre 0 e 10");
            }
        }
    }

    public void inputMediaExercicios(Scanner input) {
        do {
            try {
                System.out.print("Informe a sua media dos exercicios: ");
                mediaExercicios = input.nextInt();
                notas.setMediaExercicios(mediaExercicios);

            } catch (Exception ex) {
                System.out.println("Você digitou uma media de exercicio incorreta, digite novamente.");
                mediaExercicios = null ;
                input.next();
            }
        } while (mediaExercicios == null || mediaExercicios < 0 || mediaExercicios > 10);
    }

    public void inputNota1(Scanner input) {
        do {
            try {
                System.out.print("Informe a sua Nota 1: ");
                notas.setNota1(input.nextFloat());

                if (notas.getNota1() < 0 || notas.getNota2() > 10) {
                    System.out.println("A sua nota não pode ser negativa, digite novamente.");
                }

            } catch (Exception ex) {
                System.out.println("Você digitou uma nota errada, digite novamente.");
                input.next();
            }
        } while (notas.getNota1() < 0 || notas.getNota1() > 10);
    }


    public void inputNota2(Scanner input) {
        do {
            try {
                System.out.print("Informe a sua Nota 2: ");
                notas.setNota2(input.nextFloat());

                if (notas.getNota2() < 0 || notas.getNota2() > 10) {
                    System.out.println("A sua nota não pode ser maior que 10 ou negativa, digite novamente.");
                }

            } catch (Exception ex) {
                System.out.println("Você digitou uma nota errada, digite novamente.");
                input.next();
            }
        } while (notas.getNota2() < 0 || notas.getNota2() > 10);
    }

    public void inputNota3(Scanner input) {
        do {
            try {
                System.out.print("Informe sua nota 3: ");
                notas.setNota3(input.nextFloat());

                if (notas.getNota3() < 0 || notas.getNota3() > 10) {
                    System.out.println("A sua nota não pode ser maior que 10 ou negativa, digite novamente.");
                }

            } catch (Exception ex) {
                System.out.println("Você digitou uma nota errada, digite novamente.");
                input.next();
            }
        } while (notas.getNota3() < 0 || notas.getNota3() > 10);
    }


    public float calculaAproveitamento() {
        return (notas.getNota1() + (notas.getNota2() * 2) +
                (notas.getNota3() * 3) + notas.getMediaExercicios()) / 7;
    }



}


