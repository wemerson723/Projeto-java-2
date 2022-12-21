import java.util.ArrayList;
import java.util.Scanner;

//import java.util.Data;
//import java.text.SimpleDateFormat;

class Gerencia implements Interface {  

    private ArrayList<Projeto> Projetos;
    private ArrayList<Usuarios> Usuarios;
    private ArrayList<Atividade> Atividades;
    
    public Projeto  Get_projeto(int index){ return Projetos.get(index);  }
    public Usuarios Get_Usuario(int index){ return Usuarios.get(index);  }

    public int Check_Usuario(){
        Scanner ler = new Scanner(System.in);
        String nome = ler.nextLine();
        for (int i = 0; i < this.Usuarios.size(); i++){
            if(this.Usuarios.get(i).Get_nome().intern().equals(nome.intern())){
                return i;
            }
        }
        return -1;
    
    }
    
    public int Check_Projeto(){
        Scanner ler = new Scanner(System.in);
        int id = ler.nextInt();
        for (int i = 0; i < this.Projetos.size(); i++){
            if(this.Projetos.get(i).Get_identificacao() == id){
                return i;
            }
        }
        return -1;
    }
    
    public int Check_atividade(){
        Scanner ler = new Scanner(System.in);
        int id = ler.nextInt();
        for (int i = 0; i < this.Atividades.size(); i++){
            if(this.Atividades.get(i).Get_identificacao() == id){
                return i;
            }
        }
        return -1;
    }

    public void consulta(){

        Scanner ler = new Scanner(System.in);
    
        System.out.println("Digite a Opção:\n1: Consultar usuário.\n2: Consultar projeto.\n3: Consulta por atividade.\n");

        switch (ler.nextInt()) {
            case 1:
                System.out.println("Digite a Opção:\n1: Consultar um usuário.\n2: Consultar todos usuários.\n");

                switch (ler.nextInt()) {
                    case 1:
                        System.out.println("Digite o nome do usuário.\n");
                        int id_0 =  Check_Usuario();
                        if (id_0 != -1) { this.Usuarios.get(id_0).consulta(); }
                        else { System.out.println("ERRO: Usuário não encontrado.\n"); }
                        break;
                    case 2:
                        System.out.println("Usuários:\n");
                        for (int i = 0; i < this.Usuarios.size(); i++) { this.Usuarios.get(i).consulta();  }
                        break;
                    default:
                        System.out.println("ERRO: Opção inválida.\n");
                    break;
                }
            break;
            case 2:

                System.out.println("Digite a Opção:\n1: Consultar um projeto.\n2: Consultar todos projetos.\n");
                switch (ler.nextInt()) {
                    case 1:
                        System.out.println("Digite a identificação do projeto.\n");
                        int id_1 =  Check_Projeto();
                        if (id_1 != -1) {
                            this.Projetos.get(id_1).consulta();
                        }
                        else { System.out.println("ERRO: Projeto não encontrado.\n"); }
                    case 2:
                        System.out.println("Projetos:\n");
                        for (int i = 0; i < this.Projetos.size(); i++) { this.Projetos.get(i).consulta();  }
                        break;
                    default:
                        System.out.println("ERRO: Opção inválida.\n");
                    break;
                }
            break;
            case 3:
                System.out.println("Digite a Opção:\n1: Consultar uma atividade.\n2: Consultar todos atividades.\n");
                switch (ler.nextInt()) {
                    case 1:
                        System.out.println("Digite a identificação da atividade.\n");
                        int id_1 =  Check_atividade();
                        if (id_1 != -1) {
                            this.Atividades.get(id_1).consulta();
                        }
                        else { System.out.println("ERRO: Atividade não encontrado.\n"); }
                    case 2:
                        System.out.println("Atividades:\n");
                        for (int i = 0; i < this.Atividades.size(); i++) { this.Atividades.get(i).consulta();  }
                        break;
                    default:
                        System.out.println("ERRO: Opção inválida.\n");
                    break;
                }
            break;
            default:
                System.out.println("ERRO: Opção inválida.\n");
            break;
        }
    }

    public void ADD_projeto(){
            Scanner ler = new Scanner(System.in);
            System.out.println("Digite o nome do cordenador do projeto:\n");
            int id_0 = Check_Usuario();
            if (id_0 != -1){
                if((this.Usuarios.get(id_0).Get_cargo().equals("professor")) || this.Usuarios.get(id_0).Get_cargo().equals("pesquisador")){
                    this.Projetos.add(new Projeto(this.Usuarios.get(id_0)));
                }
                else {
                    System.out.println("ERRO: Esse usuário não tem poder para ser um cordenador.\n");
                }
            }
            else{
                System.out.println("ERRO: Usuário não encontrado.\n");
            }
        }
    public void Editar_projeto(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a Opção:\n1: Editar Projeto.\n2: Excluir projeto.\n3: Criar um novo projeto e adicionar.\n");
        switch (ler.nextInt()) {
            case 1:
                System.out.println("Digite a identificação do projeto.\n");
                int id_0 = Check_Projeto();
                if (id_0 != -1) { this.Projetos.get(id_0).Editar_projeto(); }
                else{ System.out.println("ERRO: Projeto não encontrado.\n"); }
                break;
            case 2:
                System.out.println("Digite a identificação do projeto.\n");
                int id_1 = Check_Projeto();
                if (id_1 != -1) { this.Projetos.remove(id_1); }
                else{ System.out.println("ERRO: Projeto não encontrado.\n"); }
                break;
            case 3:
                System.out.println("Digite o nome do cordenador do novo projeto.\n");
                int id_2 = Check_Usuario();
                if (id_2 != -1) {
                if (this.Usuarios.get(id_2).Get_cargo().equals("professor") || this.Usuarios.get(id_2).Get_cargo().equals("pesquisador")) {
                        this.Projetos.add(new Projeto(this.Usuarios.get(id_2)));
                    }
                    else { System.out.println("ERRO: Esse usuário não tem poder para ser um cordenador.\n"); }
                }
                else{ System.out.println("ERRO: Usuário não encontrado.\n"); }
                break;
        default:
            break;
       }
    }
    public void menu(){
        boolean lock = true;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a Opção:\n1: Editar Projetos.\n2: consultar informações.\n3: Emitir relatório.\n7: Sair.\n");
        while (lock) {
            switch (ler.nextInt()) {
                case 1:
                   this.Editar_projeto();
                case 2:
                    this.consulta();
                    break;
                case 3:
                    this.relario();
                    break;
                case 7:
                    lock = false;
                    break;
            
                default:
                    System.out.println("ERRO: Opção inválida.");
                    break;
            }
        }
        
    }

    public void login(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o usuário:\n");
        int id = this.Check_Usuario();
        
        if (id != -1) {
            System.out.println("Digite a senha:\n");
            if (this.Usuarios.get(id).login(ler.nextLine())) {
                System.out.println("Login aceito.\n");   
            }
            else{
                System.out.println("ERRO: Login errado.\n");   
            }
        }
        else{
            System.out.println("ERRO: Usuário não encontrado.\n");
        }
    }

    public void relario(){
        System.out.println("Relatório.\n");
        System.out.println("Projetos.\n");

        for (int i = 0; i < this.Projetos.size(); i++){
            System.out.println("Cordenador: " + this.Projetos.get(i).Get_cordenador().Get_nome() + " Cargo do Cordenador: " + this.Projetos.get(i).Get_cordenador().Get_cargo()+ ".");
            System.out.println("Status do projeto:" + this.Projetos.get(i).Get_status() + ".");
            System.out.println("Identificação do projeto:" + this.Projetos.get(i).Get_identificacao()+".");
            System.out.println("Usuários ativos no projeto:");
            for (int j = 0; j < this.Projetos.get(i).Get_usuarios_ativos().size(); j++){
                System.out.println("Usuário:" + this.Projetos.get(i).Get_usuarios_ativos().get(j).Get_nome()+" Cargo do usuário:" + this.Projetos.get(i).Get_usuarios_ativos().get(j).Get_cargo()+".");
            }
            System.out.println("Atividades do projeto:");
            for (int j = 0; j < this.Projetos.get(i).Get_atividades().size(); j++){
                System.out.println("Identificação da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_identificacao()+".");
                System.out.println("descrição da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_descricao()+".");
                System.out.println("Data de início da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_dia() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_mes() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_ano() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_horas() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_minutos() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_segundos() + ".");
                System.out.println("Data de termino da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_dia() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_mes() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_ano() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_horas() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_minutos() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_segundos() + ".");
                System.out.println("Responsável pela atividade: " + this.Projetos.get(i).Get_atividades().get(j).Get_responsavel()+ ".");
                System.out.println("Responsável da atividade: " + this.Projetos.get(i).Get_atividades().get(j).Get_responsavel().Get_nome()+ " Cargo: " + this.Projetos.get(i).Get_atividades().get(j).Get_responsavel().Get_cargo()+ ".");
                System.out.println("Usuários ativos da atividade:");
                for (int k = 0; k < this.Projetos.get(i).Get_atividades().get(j).Get_usuarios_ativos().size() ; k++){
                    System.out.println("usuário : " + this.Projetos.get(i).Get_atividades().get(j).Get_usuarios_ativos().get(k).Get_nome()+" Cargo: " +this.Projetos.get(i).Get_atividades().get(j).Get_usuarios_ativos().get(k).Get_cargo()+".");
                }
                System.out.println("Tarefas da atividade:");
                for (int k = 0; k < this.Projetos.get(i).Get_atividades().get(j).Get_tarefas().size(); k++){
                    System.out.println(this.Projetos.get(i).Get_atividades().get(j).Get_tarefas().get(k)+".");
                }
            }
            System.out.println("Valor da bolsa do projeto: "+ this.Projetos.get(i).Get_valor_bolsa()+".");
            System.out.println("Período de vigência do projeto: "+ this.Projetos.get(i).Get_periodo_vigencia() + " dias.");
            System.out.println("Data de início do projeto:" + this.Projetos.get(i).Get_data_inicio() + this.Projetos.get(i).Get_data_inicio().Get_mes() + this.Projetos.get(i).Get_data_inicio().Get_ano() + this.Projetos.get(i).Get_data_inicio().Get_horas() + this.Projetos.get(i).Get_data_inicio().Get_minutos() + this.Projetos.get(i).Get_data_inicio().Get_segundos() + ".");
            System.out.println("Data de termino do projeto:" + this.Projetos.get(i).Get_data_termino().Get_dia() + this.Projetos.get(i).Get_data_termino().Get_mes() + this.Projetos.get(i).Get_data_termino().Get_ano() + this.Projetos.get(i).Get_data_termino().Get_horas() + this.Projetos.get(i).Get_data_termino().Get_minutos() + this.Projetos.get(i).Get_data_termino().Get_segundos() + ".");
        }
    }

    @Override
    public void inter() {
        System.out.println("Interface.\n");
    }
    public Gerencia(){
        this.Projetos = new ArrayList<Projeto>();
        this.Usuarios = new ArrayList<Usuarios>();
        this.Atividades = new ArrayList<Atividade>();

        System.out.println("Crie o primeiro usuário para o Projeto inicial.\n");
        this.Usuarios.add(new Usuarios());
        menu();
    }
} 