public class FormularioSimples extends FormularioFac {

    @Override
    public Cabecario montarCabecario() {
        return new CabecarioSimples();
    }

    @Override
    public Lista montarLista() {
        return new ListaSimples();
    }
}
