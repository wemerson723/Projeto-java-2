import java.util.ArrayList;

public class TesteFactory {

    private static Formulario montarFormulario(String tipo){
        FormularioFac formC = null;
        switch (tipo) {
            case "simples":
                formC = new FormularioSimples();
                break;
            case "composto":
                formC = new FormularioComposto();
            break;
            default:
                break;
        }
        Formulario form = new Formulario();
        form.setCabecario(formC.montarCabecario());
        form.setLista(formC.montarLista());

        return form;
    }
}
