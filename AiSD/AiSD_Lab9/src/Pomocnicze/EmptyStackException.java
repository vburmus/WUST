package Pomocnicze;

public class EmptyStackException extends Exception {

    @Override
    public void printStackTrace() {
        System.out.println("Nieprawidłowe wyrażenie!");
    }
}
