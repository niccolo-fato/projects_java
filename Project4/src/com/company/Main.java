package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        final int MAX_NUM = 4;
        int cont = 0;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("\t\t MENU' SCELTA:");
            System.out.println("-Inserisci 1 per fare la media,\n" +
                               "-Inserisci 2 per trovare il max e min,\n" +
                               "-Inserisci 3 per generare numeri casuali, inserirli dentro " +
                               "una matrice e fare la media di ogni riga,\n" +
                               "-Inserisci 0 se vuoi uscire dal programma,\n" +
                               "Scelta:");
            cont = scan.nextInt();
            switch (cont) {
                case 0 -> System.out.println("Hai deciso di uscire dal programma");
                case 1 -> {
                    System.out.println("\t\t Scelta 1:MEDIA");
                    float x = 0f;
                    x = media(MAX_NUM);
                    System.out.println("La media equivale a:" + x);
                    System.out.println("------------------------------------");
                }
                case 2 -> {
                    System.out.println("\t\t Scelta 2:MAX E MIN");
                    MaxMin();
                    System.out.println("------------------------------------");
                }
                case 3 -> {
                    double x = 0;
                    int MAX_ROWS = 0, MAX_COLS = 0;
                    System.out.println("Inserisci il numero di righe:");
                    MAX_ROWS = scan.nextInt();
                    System.out.println("Inserisci il numero di colonne:");
                    MAX_COLS = scan.nextInt();
                    x = Matrice(MAX_ROWS, MAX_COLS);
                    System.out.println("La media equivale a:" + x);
                    System.out.println("------------------------------------");
                }
            }
        }   while(cont != 0);
    }
     static float media(int MAX_NUM){
        int[] num;
        num = new int[MAX_NUM];
        float media = 0f;
         for(int i = 0; i < MAX_NUM; i++){
             Scanner scan = new Scanner(System.in); //Mettere sempre prima del system.out e serve per inserire un valore
             System.out.println("Inserire il numero: ");//Serve per visualizzare un messaggio
             num[i] = scan.nextInt();
             media += num[i];
         }
         media /= MAX_NUM;
        return media;
    }
    static void MaxMin(){
        int max = 0, min = 0, num = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Quanti numeri vuoi inserire?");
        num = scan.nextInt();
        int[] N;
        N = new int[num];
        for (int i = 0; i < num; i++){
             System.out.println("Inserisci il numero in posizione " + (i+1));
             N[i] = scan.nextInt();
             if (N[i] > max){
                 max = N[i];
             }
             else{
                 min = N[i];
             }
        }
    }
    static double Matrice(int MAX_ROWS, int MAX_COLS){
        double[][] M;
        M = new double[MAX_ROWS][MAX_COLS];
        double media = 0;
        Random rnd = new Random();
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M.length; j++){
                M[i][j] = rnd.nextInt(49)+1;
            }
        }
        for (double[] doubles : M) {
            for (int j = 0; j < M.length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
        for (double[] doubles : M) {
            for (int j = 0; j < M.length; j++) {
                media += doubles[j];
            }
        }
        media /= MAX_ROWS + MAX_COLS;
        return media;
    }
}
