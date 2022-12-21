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
    
        System.out.println("Digite a Opção:\n1: Consultar usuário.\n2: Consultar projeto.\n3: Consulta por atividade.\n0: Sair.");

        try {
            int n = ler.nextInt();
            switch (n) {
                case 0:{break;}
                case 1:{
                    System.out.println("Digite a Opção:\n1: Consultar um usuário.\n2: Consultar todos usuários.\n0: Sair.");

                    int n0 = ler.nextInt();
    
                    switch (n0) {
                        case 0:{
                            break;}
                        case 1:{
                            System.out.println("Digite o nome do usuário.");
                            int id_0 =  Check_Usuario();
                            if (id_0 != -1) { this.Usuarios.get(id_0).consulta(); }
                            else { System.out.println("ERRO: Usuário não encontrado."); }
                            break;}
                        case 2:{
                            System.out.println("Usuários:");
                            for (int i = 0; i < this.Usuarios.size(); i++) { this.Usuarios.get(i).consulta();  }
                            break;}
                        default:{
                            System.out.println("ERRO: Opção inválida.");
                        break;}
                    }
                break;}
                case 2:{
    
                    System.out.println("Digite a Opção:\n1: Consultar um projeto.\n2: Consultar todos projetos.\n0: Sair.");

                    int n0 = ler.nextInt();

                    switch (n0) {
                        case 0:{break;}
                        case 1:{
                            System.out.println("Digite a identificação do projeto.");
                            int id_1 =  Check_Projeto();
                            if (id_1 != -1) {
                                this.Projetos.get(id_1).consulta();
                            }
                            else { System.out.println("ERRO: Projeto não encontrado."); }
                            break;}
                        case 2:{
                            System.out.println("Projetos:");
                            for (int i = 0; i < this.Projetos.size(); i++) { this.Projetos.get(i).consulta();  }
                            break;}
                        default:{
                            System.out.println("ERRO: Opção inválida.");
                        break;}
                    }
                break;}
                case 3:{
                    System.out.println("Digite a Opção:\n1: Consultar uma atividade.\n2: Consultar todos atividades.\n0: Sair.");
                    
                    int n0 = ler.nextInt();

                    switch (n0) {
                        case 0:{break;}
                        case 1:{
                            System.out.println("Digite a identificação da atividade.");
                            int id_1 =  Check_atividade();
                            if (id_1 != -1) {
                                this.Atividades.get(id_1).consulta();
                            }
                            else { System.out.println("ERRO: Atividade não encontrado."); }
                            break;}
                        case 2:{
                            System.out.println("Atividades:");
                            for (int i = 0; i < this.Atividades.size(); i++) { this.Atividades.get(i).consulta();  }
                            break;}
                        default:{
                            System.out.println("ERRO: Opção inválida.");
                        break;}
                    }
                break;}
                default:
                    System.out.println("ERRO: Opção inválida.");
                break;
            }

        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante o menu de consulta.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void ADD_Usuario(){
        this.Usuarios.add(new Usuarios());
        this.menu();
    }
    public void ADD_projeto(){
            Scanner ler = new Scanner(System.in);
            System.out.println("Digite o nome do cordenador do projeto:");
            int id_0 = Check_Usuario();
            if (id_0 != -1){
                if((this.Usuarios.get(id_0).Get_cargo().equals("professor")) || this.Usuarios.get(id_0).Get_cargo().equals("pesquisador")){
                    this.Projetos.add(new Projeto(this.Usuarios.get(id_0)));
                }
                else {
                    System.out.println("ERRO: Esse usuário não tem poder para ser um cordenador.");
                }
            }
            else{
                System.out.println("ERRO: Usuário não encontrado.");
            }
        }
    public void Editar_projeto(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a Opção:\n1: Editar Projeto.\n2: Excluir projeto.\n3: Criar um novo projeto e adicionar.\n0: Sair.");

        try {
            int n = ler.nextInt();
            switch (n) {
                case 0:{
                    break;}
                case 1:{
                    System.out.println("Digite a identificação do projeto.");
                    int id_0 = Check_Projeto();
                    if (id_0 != -1) { this.Projetos.get(id_0).Editar_projeto(); }
                    else{ System.out.println("ERRO: Projeto não encontrado."); }
                    break;}
                case 2:{
                    System.out.println("Digite a identificação do projeto.");
                    int id_1 = Check_Projeto();
                    if (id_1 != -1) { this.Projetos.remove(id_1); }
                    else{ System.out.println("ERRO: Projeto não encontrado."); }
                    break;}
                case 3:{
                    System.out.println("Digite o nome do cordenador do novo projeto.");
                    int id_2 = Check_Usuario();
                    if (id_2 != -1) {
                        if (this.Usuarios.get(id_2).Get_cargo().equals("professor") || this.Usuarios.get(id_2).Get_cargo().equals("pesquisador")) {
                                this.Projetos.add(new Projeto(this.Usuarios.get(id_2)));
                            }
                            else { System.out.println("ERRO: Esse usuário não tem poder para ser um cordenador."); }
                    }
                    else{ System.out.println("ERRO: Usuário não encontrado."); }
                    break;}
                default:{
                break;}
           }
        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante o menu de edição do projeto.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void menu(){
        Scanner ler = new Scanner(System.in);
        int id = 1;
        while (id != 0){

            System.out.println("Digite a Opção:");
            System.out.println("1: Editar Projetos.");
            System.out.println("2: consultar informações.");
            System.out.println("3: Emitir relatório.");
            System.out.println("0: Sair.");

            id = ler.nextInt();
            switch (id) {
                case 0:{
                    break;}
                case 1:{
                   this.Editar_projeto();
                   break;}
                case 2:{
                    this.consulta();
                    break;}
                case 3:{
                    this.relario();
                    break;}
                default:{
                    System.out.println("ERRO: Opção inválida.");
                    break;}
            }
        };    
    }
    public void ADM(){
        Scanner ler = new Scanner(System.in);

        try {

            boolean lock = true;
            while (lock) {
                System.out.println("Digite a senha:");
                if (ler.nextInt() == 123456) {
                    this.menu();
                    lock = false;
                }
                else{
                    System.out.println("ERRO: Login errado.");  
                }
            }
            
        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante o login.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void login(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o usuário:");

        try {

            int id = this.Check_Usuario();
        
            if (id != -1) {
                System.out.println("Digite a senha:");
                if (this.Usuarios.get(id).login(ler.nextLine())) {
                    System.out.println("Login aceito.");
                    menu();
                }
                else{
                    System.out.println("ERRO: Login errado.");   
                }
            }
            else{
                System.out.println("ERRO: Usuário não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante o login.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void relario(){
        System.out.println("Relatório.");
        System.out.println("Projetos.");

        try {
            
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
        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante o relatório.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void inter() {
        System.out.println("Interface.");
    }
    public Gerencia(){
        try {
            this.Projetos = new ArrayList<Projeto>();
            this.Usuarios = new ArrayList<Usuarios>();
            this.Atividades = new ArrayList<Atividade>();
        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante a criação da gerencia.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
} 