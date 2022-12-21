public class FormularioComposto extends FormularioFac {

    @Override
    public Cabecario montarCabecario() {
        return new CabecarioComposto();
    }

    @Override
    public Lista montarLista() {
        return new ListaComposta();
    }
}
