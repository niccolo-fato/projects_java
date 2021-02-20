package com.company;

public interface Shop {
    //Inserimento degli oggetti
    public void input();

    //Cerca e stampa un oggetto dato in input il codice
    public void search(String choice2);

    //Stampare l'oggetto piu' costoso di una categoria data in input oppure Cerca ed elimina un oggetto dato in input il codice
    public void expensive_delete(String choice2, int choice);

    //Stampa tutti gli oggetti
    public void print();
}
