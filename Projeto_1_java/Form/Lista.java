import java.util.ArrayList;
import java.util.Iterator;

public class Lista {

    private ArrayList<String> lista;

    public ArrayList<String> getLista() {
        return lista;
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    public void printlista() {
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
