//Inserimento valori in una matrice con i messaggi
package com.company;
import javax.swing.JOptionPane;

public class Main {
    public static int LeggiInteroPositivo(String messaggio) {
        int n;
        do {
            n = Integer.parseInt(JOptionPane.showInputDialog(messaggio));
        } while (n <= 0);
        return n;
    }

    public static int LeggiIntero(String messaggio) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(messaggio));
        return n;
    }

    public static int[][] LeggiMatrice() {
        int n = LeggiInteroPositivo("Dimensione dell'array(RIGA)");
        int m = LeggiInteroPositivo("Dimensione dell'array(COLONNA)");
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                a[i][j] = LeggiIntero("Inserisci il numero: ");
        }
        return a;
    }

    public static void StampaMatrici(int[][] x) {
        for (int[] ints : x) {
            for (int anInt : ints) {
                System.out.print("\t" + anInt);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] x;
        x = LeggiMatrice();
        StampaMatrici(x);
    }
}
