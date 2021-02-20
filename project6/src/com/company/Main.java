package com.company;
import java.util.Scanner;

class Global{
    //dichiarazione variabili globali
     public static boolean bool = false;
     public static final int NUM_OBJ = 100;
     public static int counter = 0;
}
class objects implements Shop{
    String[] category = {"cucina","scolastico","bagno","arredo","elettronica","elettrodomestici"};
    int[] count ;
    float[][] cost;
    String[][] code;
    String[][] object;

    Scanner scan = new Scanner(System.in);

    public objects() {

        cost = new float[Global.NUM_OBJ][Global.NUM_OBJ];
        code = new String[Global.NUM_OBJ][Global.NUM_OBJ];
        object = new String[Global.NUM_OBJ][Global.NUM_OBJ];
        count = new int[Global.NUM_OBJ];

    }
    public void input(){
        int choice_category = 0;
            System.out.println("\t\t Oggetto numero " + (count[Global.counter] + 1) + ":");
            System.out.println("Inserisci categoria dell'oggetto:");
            System.out.print("""
                        1-Se il tuo oggetto serve per la cucina,
                        2-Se il tuo oggetto e' di tipo  scolastico ,
                        3-Se il tuo oggetto serve per il bagno,
                        4-Se il tuo oggetto e' un arredo,
                        5-Se il tuo oggetto e' un oggetto elettronico,
                        6-Se il tuo oggetto e' un elettrodomestico,
                        Scelta:""");
            choice_category = scan.nextInt();
            switch(choice_category){
                case 1, 2, 3, 4, 5, 6 ->{
                    --choice_category;
                         for(int j = 0; j< Global.NUM_OBJ; j++){
                             if(object[choice_category][j] != " " &&  cost[choice_category][j] == 0 && code[choice_category][j] != " "){
                                 System.out.print("Inserisci il nome dell'oggetto:");
                                 object[choice_category][j] = scan.next();
                                 System.out.print("Inserisci il prezzo dell'oggetto:");
                                 cost[choice_category][j] = scan.nextFloat();
                                 do {
                                     System.out.print("Inserisci codice dell'oggetto(!Il codice dev'essere di 6 caratteri!): ");
                                     code[choice_category][j] = scan.next();
                                     if(code[choice_category][j].length() == 6)
                                         Global.bool = true;
                                 }while(!Global.bool);
                                 Global.bool = false;
                                 ++count[choice_category];
                                 ++Global.counter;
                                 break;
                             }
                         }
                }
            }
    }
    public void search(String choice2){
        for(int j = 0; j< 6; j++){
            for(int i = 0; i< count[j]; i++){
                if(choice2.equals(code[(j)][i])){
                    System.out.println("\t\t Dettagli oggetto cercato:");
                    System.out.println(" Categoria: " + category[j] + "\n Nome oggetto: " + object[j][i] + "\n Prezzo oggetto: " + cost[j][i]+"€" + "\n Codice oggetto: " + code[(j)][i]);
                    Global.bool = true;
                    break;
                }
            }
            if(Global.bool)
                break;
        }
        if(!Global.bool)
            System.out.println("!Non è stato trovato nessun oggetto con il codice " + choice2 + "!");
        Global.bool = false;
    }
    public void expensive_delete(String choice2, int choice){
        float max = 0f;
        String max_object = " ", delete_code;
        if(choice == 3){
            for (int j = 0; j< 6; j++){
            if(choice2.equals(category[j])){
                for (int i = 0; i< Global.NUM_OBJ; i++){
                    if ( cost[j][i] > max){
                        max = cost[j][i];
                        max_object = object[j][i];
                    }
                }
                System.out.println("L'oggetto con il costo piu' alto della categoria " + choice2 + " e' " + max_object + " con un prezzo di " + max);
                break;
            }
        }
        }
        if (choice == 4){

                    for (int i = 0; i< 6; i++) {
                         if(choice2.equals(category[i])){
                        System.out.print("Inserisci il codice dell'oggetto che si desidera eliminare:");
                        delete_code = scan.next();
                            for (int y = i; y <= count[i]; y++) {
                                 if (delete_code.equals(code[i][y])) {
                                code[i][y] = code[i + 1][y + 1];
                                object[i][y] = object[i + 1][y + 1];
                                cost[i][y] = cost[i + 1][y + 1];
                                Global.bool = true;
                                if(y == count[i]){
                                    code[i][y] = " ";
                                    object[i][y] = " ";
                                    cost[i][y] = 0;
                                    --count[i];
                                    --Global.counter;
                                }
                            }
                        if (Global.bool)
                            break;
                    }
                    }
                    if (Global.bool)
                            break;
                }

            if(!Global.bool)
                System.out.println("!Non è stato trovato nessun oggetto con il codice " + choice2 + "!");
        }
    }

   public void print(){
        for(int i = 0; i < 6; i++ ){
            System.out.println("\t\t Categoria " + category[i] + ":");
            System.out.println("Lista oggetti:");
            for(int j = 0; j < count[i]; j++ ){
                if(cost[i][j] != 0){
                    System.out.println(" Nome: "+ object[i][j]+"\n Prezzo: "+ cost[i][j]+ "\n Codice: "+ code[i][j]);
                    Global.bool = true;
                }
            }
            if(!Global.bool)
                System.out.println("!In questa categoria non e' stato registrato ancora nessun oggetto!");
            Global.bool = false;
        }
   }
}
public class Main {

    public static void main(String[] args) {
        Scanner scan2 = new Scanner(System.in);
        int  choice = 0,choice3 = 0;
        String choice2;
        objects obj = new objects();
        do {

            System.out.println("\t\t----MENU' SCELTA----");
            System.out.print("""
                        1-Per registrare un oggetto,
                        2-Per cercare un oggetto e stamparlo,
                        3-Per stampare l'oggetto piu' costoso di una categoria data in input,
                        4-Per eliminare un oggetto,
                        5-Per stampare
                        0-Per uscire.
                        Scelta:""");
            choice = scan2.nextInt();
            switch (choice)
            {
                case 0 -> System.out.println("!Hai deciso di uscire dal programma!");
                case 1 ->{
                    obj.input();
                    System.out.println("------------------------------------------------------------------------");
                }
                case 2->{
                    System.out.print("Inserisci il codice dell'oggetto che stai cercando:");
                    choice2 = scan2.next();
                    obj.search(choice2);
                    System.out.println("------------------------------------------------------------------------");
                }
                case 3 , 4->{
                    System.out.println("Scegli la categoria:");
                    System.out.print("""
                        1-Cucina,
                        2-Scolastico,
                        3-Bagno,
                        4-Arredo,
                        5-Elettronico,
                        6-Elettrodomestico,
                        Scelta:""");
                    choice3 = scan2.nextInt();
                    switch (choice3){
                        case 1 -> obj.expensive_delete("cucina",choice);
                        case 2 -> obj.expensive_delete("scolastico",choice);
                        case 3 -> obj.expensive_delete("bagno",choice);
                        case 4 -> obj.expensive_delete("arredo",choice);
                        case 5 -> obj.expensive_delete("elettronica",choice);
                        case 6 -> obj.expensive_delete("elettrodomestici",choice);
                    }
                    System.out.println("------------------------------------------------------------------------");
                }
                case 5 ->{
                    obj.print();
                    System.out.println("------------------------------------------------------------------------");
                }
                default -> System.out.println("!Scelta sbagliata riprova!");
            }
        } while (choice != 0);
    }
}