import java.util.ArrayList;
import java.util.Scanner;

class Atividade implements Interface{

    private Usuarios responsavel;
    private ArrayList<Usuarios> usuarios_ativos;
    private ArrayList<String> tarefas;
    private int identificacao;
    private String descricao;
    private Data data_inicio;
    private Data data_termino;

    public int                  Get_identificacao(){        return identificacao;          }
    public String               Get_descricao(){            return descricao;              }
    public Data                 Get_data_inicio(){          return data_inicio;            }
    public Data                 Get_data_termino(){         return data_termino;           }
    public Usuarios Get_responsavel()                { return responsavel;      }
    public ArrayList<Usuarios> Get_usuarios_ativos() { return usuarios_ativos;  }
    public ArrayList<String> Get_tarefas()           { return tarefas;          }

    public void Edit_identificacao(int identificacao){  this.identificacao = identificacao; }
    public void Edit_descricao(String descricao){       this.descricao = descricao;         }
    public void Edit_data_inicio(){                     this.data_inicio.Edit();            }
    public void Edit_data_termino(){                    this.data_termino.Edit();           }
    public void Edit_responsavel    (Usuarios responsavel)               { this.responsavel = responsavel;        }
    public void Edit_usuarios_ativos(ArrayList<Usuarios> usuarios_ativos){ this.usuarios_ativos = usuarios_ativos;}
    public void Edit_tarefas        (ArrayList<String> tarefas)          { this.tarefas = tarefas;                }

    public void Delete_responsavel      (){ responsavel = null;     }
    public void Delete_usuarios_ativos  (){ usuarios_ativos = null; }
    public void Delete_tarefas          (){ tarefas = null;         }
    public void Delete_identificacao    (){ identificacao = 0;      }
    public void Delete_descricao        (){ descricao = null;       }
    public void Delete_data_inicio      (){ data_inicio = null;     } 
    public void Delete_data_termino     (){ data_termino = null;    }
    
     public void get_MM(){
        System.out.println("resp =" + responsavel.Get_nome() + " desc ="+ Get_descricao());
    }

    public void consulta(){

        try {

            System.out.println("Identificação: "+this.identificacao+".");
            System.out.println("Descrição: "+this.descricao+".");
            System.out.println("Data de início: ");
            this.data_inicio.consulta();
            System.out.println("Data de termino: ");
            this.data_termino.consulta();

            System.out.println("Responsável: \nNome:"+ this.responsavel.Get_nome()+" Cargo: "+this.responsavel.Get_cargo()+".");
            System.out.println("Usuários Ativos:");
            for (int i = 0; i < this.usuarios_ativos.size(); i++) {
                System.out.println("Nome: "+this.Get_usuarios_ativos().get(i).Get_nome()+"Cargo: "+this.Get_usuarios_ativos().get(i).Get_cargo()+".");
                
            }
            System.out.println("Tarefas:");
            for (int i = 0; i < this.usuarios_ativos.size(); i++) { System.out.println(this.Get_tarefas().get(i)+"."); }

        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante a consulta de atividade.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void ADD_Usuario(Usuarios usuario){ this.usuarios_ativos.add(usuario); }
    public void Rem_Usuario(int index)      { this.usuarios_ativos.remove(index);}

    public int Check_Usuario(String nome){
        for (int i = 0; i < usuarios_ativos.size(); i++){
            if(usuarios_ativos.get(i).Get_nome().equalsIgnoreCase(nome)){
                return i;
            }
        }
        return -1;
    }

    public int Check_Usuario(ArrayList<Usuarios> usuarios, String nome){
        for (int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).Get_nome().equals(nome)){
                return i;
            }
        }
        return -1;
    }

    public void editar_atividade(ArrayList<Usuarios> Todos_usuarios){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a Opção:\n 1: Editar identificação\n 2: Editar descrição\n 3: Editar data início\n 4: Editar data termino\n 5: Editar responsável\n 6: Editar profissionais envolvidos na atividade;\n 7: Editar tarefas\n0: Sair.");
       
        try {
            int n = ler.nextInt();
            switch (n) {
                case 0:{break;}
                case 1:{
                    System.out.println("Digite a nova identificação da atividade:");
                    Edit_identificacao(ler.nextInt());
                break;}
                case 2:{ 
                    System.out.println("Digite a nova descrição do Projeto:");
                    Edit_descricao(ler.nextLine()); 
                break;}
                case 3:{
                    System.out.println("Digite os novos dados da data:");
                    Edit_data_inicio();
                break;}
                case 4:{
                    System.out.println("Digite os novos dados da data:");
                    Edit_data_termino();
                break;}
                case 5:{
                    System.out.println("Digite nome do novo responsavel");
                    int id_1 = Check_Usuario(ler.nextLine());
                    if (id_1 != -1){ this.responsavel = this.usuarios_ativos.get(id_1); }
                    else{ System.out.println("ERRO: Usuário não está alocado para essa Atividade."); }
                break;}
                case 6:{
                    System.out.println("Digite a Opção:\n 1: Adicionar usuários.\n2: Remover usuários.\n0: Sair.");
                    int n0 = ler.nextInt();
                    switch (n0) {
                        case 0:{break;}
                        case 1:{
                            System.out.println("Digite quantos usuários quer adicionar");
                            int J = ler.nextInt();
                            for(int h = 0; h < J; h++){
                                System.out.println("Digite o nome usuário");
                                int id_2 = Check_Usuario(Todos_usuarios, ler.nextLine());
                                if (id_2 != -1){ this.usuarios_ativos.add(Todos_usuarios.get(id_2)); }
                                else{ System.out.println("ERRO: Usuário não encontrado."); }
                            }
                        break;}
                        case 2:{
                            System.out.println("Digite quantos usuários quer remover");
                            int T = ler.nextInt();
                            for(int h = 0; h < T; h++){
                                System.out.println("Digite o nome usuário");
                                int id_2 = Check_Usuario(ler.nextLine());
                                if (id_2 != -1){ this.usuarios_ativos.remove(id_2); }
                                else{ System.out.println("ERRO: Usuário não encontrado."); }
                            }
                        break;}
                        default:{
                        break;}
                    }
                break;}
                case 7:{         
                    System.out.println("Digite a opção: \n 1: Adicionar tarefa.\n 2: Remover tarefa.\n0: Sair."); 
                    int n1 = ler.nextInt();
                    switch (n1) {
                        case 0:{break;}
                        case 1:{
                            System.out.println("Digite a nova tarefa.");
                            this.tarefas.add(ler.nextLine());
                        break;}
                        case 2:{
                            System.out.println("Digite a tarefa.");
                            int id_3 = Check_tarefa(ler.nextLine());
                            if (id_3 != -1) { this.tarefas.remove(id_3); }
                            else{ System.out.println("ERRO: Tarefa não encontrada."); }
                        break;}
                        default:{
                            System.out.println("ERRO: Opção inválida.");
                        break;}
                    }
                break;}
                default:{
                    System.out.println("ERRO: Opção inválida.");
                break;}
                                                
            }

        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante a edição do atividade.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }            
    }

    public int Check_tarefa(String tarefa){
        for (int i = 0; i < this.tarefas.size(); i++){
            if(this.tarefas.get(i).equalsIgnoreCase(tarefa)){
                return i;
            }
        }
        return -1;
    }
    public Atividade(){

        try {
            Edit_identificacao(-1);
            Edit_descricao("null"); 
            responsavel = new Usuarios();
            tarefas = new ArrayList<String>();
        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante a criação do atividade.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void inter() {
        System.out.println("Interface.");
    }
}