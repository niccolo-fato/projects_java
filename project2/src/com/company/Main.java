//Programma con il random
package com.company;
import java.util.Random;//Per poter utilizzare il random nel programma
public class Main {

    public static void main(String[] args) {
        Random dice = new Random();
        int num;
        for(int i = 0; i < 10 ; i++){
            num = dice.nextInt(100);
            System.out.println("Numero " + i + ':' + num);
        }
    }
}
