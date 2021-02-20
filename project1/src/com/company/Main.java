package com.company;
import java.util.*;

class student implements single_student {
    String surname, name, address, class_student;
    int count;
    float vote_sum;
    ArrayList<Global> g = new ArrayList<>();
    public student(String new_surname, String new_name, String new_address, String new_class){
        surname = new_surname;
        name = new_name;
        address = new_address;
        class_student = new_class;
        count = 0;
        vote_sum = 0;
    }
    public int print_student(){
        System.out.println("Nome: "+name);
        System.out.println("Cognome: "+surname);
        System.out.println("Indirizzo: "+address);
        System.out.println("Classe: "+class_student);
        return 0;
    }
}
class students implements school{
    Scanner scan2 = new Scanner(System.in);
    ArrayList<student> s = new ArrayList<>();
    Global v;
    student c;
    public void add_student(){
        String new_surname, new_name, new_address, new_class;
        System.out.println("Inserisci cognome:");
        new_surname = scan2.next();
        System.out.println("Inserisci nome:");
        new_name = scan2.next();
        System.out.println("Inserisci indirizzo:");
        new_address = scan2.next();
        System.out.println("Inserisci classe:");
        new_class = scan2.next();;
        student student = new student(new_surname, new_name, new_address, new_class);
        s.add(student);
        System.out.println("-------------------------------------------");
    }
    public void print()
    {
        System.out.println("\t\tLista studenti:\n");
        for (int i = 0; i < s.size(); i++) {
            System.out.println("Studente numero " + (i + 1) + ":");
            System.out.println(s.get(c.print_student()));
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scan2 = new Scanner(System.in);
        students st = new students();
        String search_surname, change_address, vote_subject;
        float new_vote;
        int choice = 0;
        do {

            System.out.println("\t\t----MENU' SCELTA----");
            System.out.print("""
                    1-Per registrare uno studente,
                    2-Per aggiungere un voto e aggiornare la media voti,
                    3-Per cambiare il proprio indirizzo,
                    4-Per stampare,
                    0-Per uscire.
                    Scelta:""");
            choice = scan2.nextInt();
            switch (choice) {
                case 0 -> System.out.println("!Hai deciso di uscire dal programma!");
                case 1 -> st.add_student();
                case 4 -> st.print();
            }
        }while(choice != 0);
        }
    }
