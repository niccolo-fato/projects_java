package com.company;
import java.util.Scanner;
class conto {

    String[] cliente;
    String[][] data;
    float[] saldo;
    float[] ti;
    float[][] importo;


    public conto() {

        cliente = new String[100];
        data = new String[100][100];
        saldo = new float[100];
        ti = new float[100];
        importo = new float[100][100];
    }

    Scanner scan = new Scanner(System.in);

    public void tasso_interesse(String c, int cont) {

        for (int i = 0; i < cont; i++) {
            if (c.equals(cliente[i])) {
                System.out.print("Inserire il tasso di interesse:");
                ti[i] = scan.nextFloat();
                saldo[i] += (ti[i] / 100) * saldo[i];
                System.out.println("Il saldo e' stato incrementato con sucesso! ");
            }
        }

    }

    public void prelievo(float a, String c, int cont,boolean bool) {

        for (int i = 0; i < cont; i++) {
            if (c.equals(cliente[i])) {
                if (saldo[i] >= a) {
                    saldo[i] -= a;
                    for (int y = i; y < 100; y++) {
                        for (int j = 0; j < 100; j++) {
                                if (importo[y][j] == 0) {
                                    System.out.println("Il saldo attuale è di " + saldo[i] + "€");
                                    importo[y][j] = -a;
                                    System.out.println("Inserire data del prelievo:");
                                    data[y][j] = scan.next();
                                    bool = true;

                                }
                            if(bool)
                                break;
                        }
                        if(bool)
                            break;
                        bool = false;
                    }
                } else {
                    System.out.println("Non è possibile effettuare il prelievo perchè la cifra da lei inserita è superiore al saldo attuale che  ammonta a " + saldo[i] + "€");
                }
            }
        }
    }

    public void crea(int cont) {

        for (int i = 0; i < cont; i++) {
            System.out.println("\t\t Inserimento dati del cliente numero " + (i + 1));
            System.out.print("Inserire saldo:");
            saldo[i] = scan.nextFloat();
            System.out.print("Inserire il cognome del cliente:");
            cliente[i] = scan.next();
        }

    }

    public void versamento(float a, String c, int cont,boolean bool) {

        for (int i = 0; i < cont; i++) {
            if (c.equals(cliente[i])) {
                saldo[i] += a;
                for (int y = i; y < 100; y++) {
                    for (int j = 0; j < 100; j++) {
                            if (importo[y][j] == 0) {
                                System.out.println("Il saldo attuale è di " + saldo[i] + "€");
                                importo[y][j] = +a;
                                System.out.println("Inserire data del versamento:");
                                data[y][j] = scan.next();
                                bool = true;
                            }
                        if(bool)
                            break;
                    }
                    if(bool)
                        break;
                    bool = false;
                }
            }
        }

    }

    public void stampa(int cont, boolean bool) {

        for (int i = 0; i < cont; i++) {
            System.out.println("\t\t Dati del cliente numero " + (i + 1) + ":");
            System.out.println("Cliente: " + cliente[i] + "\n Saldo: " + saldo[i] + "\n Tasso di interesse: " + ti[i] + "%");
            System.out.println("Importi fatti da " + cliente[i] + ":");
            for (int y = i; y < 100; y++) {
                for (int j = 0; j < 100; j++) {
                    if (importo[y][j] != 0) {
                        System.out.println("Data " + data[y][j] + ": " + importo[y][j]);
                        bool = true;
                    }
                }
                if(bool)
                    break;
            }
            if(!bool){
                System.out.println(cliente[i]+" non ha effettuato ancora nessun importo!!!");
            }
            bool = false;
        }

    }
}
public class Main {

    public static void  main(String[] args) {

        Scanner scan2 = new Scanner(System.in);
        int scelta;
        float a;
        int cont;
        boolean bool = false;
        String c;
        System.out.print("Inserire quanti cliente si desidera registrare:");
        cont = scan2.nextInt();
        conto conto = new conto();
        conto.crea(cont);
            do {

                System.out.println("\t\t----MENU' SCELTA----");
                System.out.print("""
                        1-Per fare un prelievo,
                        2-Per fare un versamento,
                        3-Per fare una stampa dei dati del conto,
                        4-Per incrementare il saldo,
                        0-Per uscire.
                        Scelta:""");
                scelta = scan2.nextInt();
                switch (scelta)
                {
                    case 0 -> System.out.println("Hai deciso di uscire dal programma!");
                    case 1 ->{
                        System.out.print("Inserire cognome cliente:");
                        c = scan2.next();
                        System.out.print("Inserire la cifra da prelevare:");
                        a = scan2.nextFloat();
                        conto.prelievo(a,c,cont, false);
                    }
                    case 2 ->{
                        System.out.print("Inserire cognome cliente:");
                        c = scan2.next();
                        System.out.println("Inserire la cifra da versare:");
                        a = scan2.nextFloat();
                        conto.versamento(a,c,cont, false);
                    }
                    case 3 ->conto.stampa(cont, false);
                    case 4 ->{
                        System.out.print("Inserire cognome cliente al quale vuole inserire il tasso di interesse:");
                        c = scan2.next();
                        conto.tasso_interesse(c,cont);
                    }
                    default -> System.out.println("!Scelta sbagliata riprova!");
                }

            } while (scelta != 0);
    }
}