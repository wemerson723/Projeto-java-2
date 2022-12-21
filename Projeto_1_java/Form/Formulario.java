public class Formulario {

    Cabecario cabecario;
    Lista lista;
    
    public Cabecario getCabecario() {
        return cabecario;
    }
    public Lista getLista() {
        return lista;
    }
    public void setCabecario(Cabecario cabecario) {
        this.cabecario = cabecario;
    }
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public void printForm() {
        System.out.println(cabecario);
        lista.printlista();
    }
}