package Drzewo;

import Pomocnicze.ArrayQueue;
import Pomocnicze.EmptyQueueException;

public class BST {


    Node root;


    public BST (Node root) {
        this.root = root;
    }



    private boolean czyOperator(String e) {
        return e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/") || e.equals("%");
    }

    private double operacjaNadLiczbami(double a, double b, String s) {
        if (s.equals("+"))
            return a + b;
        if (s.equals("-"))
            return a - b;
        if (s.equals("*"))
            return a * b;
        if (s.equals("/")) {
            if (b == 0) {
                throw new IllegalArgumentException();
            }
            else
                return a/b;
        }
        if (s.equals("%"))
            if (b == 0)
                throw new IllegalArgumentException();
            else
                return a%b;

        return 0;
    }

    private void postorder(Node elem) {
        if (elem.getLeft() != null) {
            postorder(elem.getLeft());
        }
        if (elem.getRight() != null) {
            postorder(elem.getRight());
        }
        System.out.print(" " + elem.getValue());
    }

    private void inorder(Node elem) {
        if (elem.getLeft() != null) {
            System.out.print("(");
            inorder(elem.getLeft());
        }

        if (!czyOperator(elem.getValue()))
            System.out.print("(" + elem.getValue() + ")");
        else
            System.out.print(elem.getValue());

        if (elem.getRight() != null) {
            inorder(elem.getRight());
            System.out.print(")");
        }
    }

    private double obliczenie(Node elem){
        if (elem==null)
            return 0;
        if (elem.getLeft()==null && elem.getRight()==null)
            return Integer.parseInt(elem.getValue());

        double a = obliczenie(elem.getLeft());
        double b = obliczenie(elem.getRight());

        return operacjaNadLiczbami(a, b, elem.getValue());
    }

    public void wartoscWyrazenia() {
        System.out.println("Warto???? wyra??enia zapisanego w drzewie wynosi: " + obliczenie(root));
    }

    public void wyswietlInfiks() {
        System.out.print("Wyra??enie w postaci infiksowej : ");
        inorder(root);
        System.out.print(" = " +  obliczenie(root) + "\n");
    }

    public void wyswietlPostfiks() {
        System.out.print("Wyra??enie w postaci postfiksowej (ONP): ");
        postorder(root);
        System.out.print(" = "+  obliczenie(root) + "\n");
    }

    private int liscie(Node elem) {
        int count = 0;
        if (elem!=null)
        {
            if (elem.getLeft() == null && elem.getRight() == null)
                count++;
            if (elem.getLeft() != null)
                count += liscie(elem.getLeft());
            if (elem.getRight() != null)
                count += liscie(elem.getRight());
        }
        return count;
    }

    public void liczbaLisci() {
        System.out.println("Liczba li??ci: " + liscie(root));
    }

    private int wezly(Node elem){
        int count = 0;
        if (elem == null)
            return 0;

        count++;

        if (elem.getLeft() != null)
            count+= wezly(elem.getLeft());
        if (elem.getRight() != null)
            count+= wezly(elem.getRight());

        return count;
    }

    public void liczbaWezlow()
    {
        System.out.println("Liczba w??z????w: " + wezly(root));
    }

    private int wysokosc(Node elem) {
        int count =- 1;
        if (elem != null) {
            count = Math.max(wysokosc(elem.getLeft()), wysokosc(elem.getRight()));
            count++;
        }
        return count;
    }

    public void wysokoscDrzewa(){
        System.out.println("Wysoko????: " + wysokosc(root));
    }

    private void levelorder(Node elem) throws EmptyQueueException{
        if (elem != null) {
            ArrayQueue<Node> kolejka = new ArrayQueue<>();
            kolejka.enqueue(elem);
            while (!kolejka.isEmpty()) {
                Node n = kolejka.dequeue();
                System.out.print(n.getValue() + " ");

                if (n.getLeft() != null)
                    kolejka.enqueue(n.getLeft());
                if (n.getRight() != null)
                    kolejka.enqueue(n.getRight());
            }
        }
    }

    public void przechodzenieWszerz() throws EmptyQueueException {
        System.out.print("Notacja polska: ");
        levelorder(root);
    }
}
