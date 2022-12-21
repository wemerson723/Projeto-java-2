import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {
        Gerencia Univer = new Gerencia();
        Cliente cliente = new Cliente(Univer);
    }
}
