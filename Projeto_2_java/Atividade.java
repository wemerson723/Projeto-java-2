import java.util.ArrayList;
import java.util.Scanner;

class Atividade extends SC implements Interface{

    private Usuarios responsavel;
    private ArrayList<Usuarios> usuarios_ativos;
    private ArrayList<String> tarefas;

    public Usuarios Get_responsavel()                { return responsavel;      }
    public ArrayList<Usuarios> Get_usuarios_ativos() { return usuarios_ativos;  }
    public ArrayList<String> Get_tarefas()           { return tarefas;          }


    public void Edit_responsavel    (Usuarios responsavel)               { this.responsavel = responsavel;        }
    public void Edit_usuarios_ativos(ArrayList<Usuarios> usuarios_ativos){ this.usuarios_ativos = usuarios_ativos;}
    public void Edit_tarefas        (ArrayList<String> tarefas)          { this.tarefas = tarefas;                }

    public void Delete_responsavel      (){ responsavel = null;     }
    public void Delete_usuarios_ativos  (){ usuarios_ativos = null; }
    public void Delete_tarefas          (){ tarefas = null;         }

     public void get_MM(){
        System.out.println("resp =" + responsavel.Get_nome() + " desc ="+ Get_descricao());
    }

    public void consulta(){
        consulta_SC();
        System.out.println("Responsável: \nNome:"+ this.responsavel.Get_nome()+" Cargo: "+this.responsavel.Get_cargo()+".\n");
        System.out.println("Usuários Ativos:\n");
        for (int i = 0; i < this.usuarios_ativos.size(); i++) {
            System.out.println("Nome: "+this.Get_usuarios_ativos().get(i).Get_nome()+"Cargo: "+this.Get_usuarios_ativos().get(i).Get_cargo()+".\n");
            
        }
        System.out.println("Tarefas:\n");
        for (int i = 0; i < this.usuarios_ativos.size(); i++) { System.out.println(this.Get_tarefas().get(i)+".\n"); }
    }

    public void ADD_Usuario(Usuarios usuario){ this.usuarios_ativos.add(usuario); }
    public void Rem_Usuario(int index)      { this.usuarios_ativos.remove(index);}

    public int Check_Usuario(String nome){
        for (int i = 0; i < usuarios_ativos.size(); i++){
            if(usuarios_ativos.get(i).Get_nome().intern().equals(nome.intern())){
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
        System.out.println("Digite a Opção:\n 1: Editar identificação\n 2: Editar descrição\n 3: Editar data início\n 4: Editar data termino\n 5: Editar responsável\n 6: Editar profissionais envolvidos na atividade;\n 7: Editar tarefas\n");
        switch (ler.nextInt()) {
            case 1:
                System.out.println("Digite a nova identificação da atividade:\n");
                Edit_identificacao(ler.nextInt());
            break;
            case 2: 
                System.out.println("Digite a nova descrição do Projeto:\n");
                Edit_descricao(ler.nextLine()); 
            break;
            case 3:
                System.out.println("Digite os novos dados da data:\n");
                Edit_data_inicio();
            break;
            case 4:
                System.out.println("Digite os novos dados da data:\n");
                Edit_data_termino();
            break;
            case 5:
                System.out.println("Digite nome do novo responsavel\n");
                int id_1 = Check_Usuario(ler.nextLine());
                if (id_1 != -1){ this.responsavel = this.usuarios_ativos.get(id_1); }
                else{ System.out.println("ERRO: Usuário não está alocado para essa Atividade.\n"); }
            break;
            case 6:
                System.out.println("Digite a Opção:\n 1: Adicionar usuários.\n2: Remover usuários.\n");
                switch (ler.nextInt()) {
                    case 1:
                        System.out.println("Digite quantos usuários quer adicionar\n");
                        int J = ler.nextInt();
                        for(int h = 0; h < J; h++){
                            System.out.println("Digite o nome usuário\n");
                            int id_2 = Check_Usuario(Todos_usuarios, ler.nextLine());
                            if (id_2 != -1){ this.usuarios_ativos.add(Todos_usuarios.get(id_2)); }
                            else{ System.out.println("ERRO: Usuário não encontrado.\n"); }
                        }
                    break;
                    case 2:
                        System.out.println("Digite quantos usuários quer remover\n");
                        int T = ler.nextInt();
                        for(int h = 0; h < T; h++){
                            System.out.println("Digite o nome usuário\n");
                            int id_2 = Check_Usuario(ler.nextLine());
                            if (id_2 != -1){ this.usuarios_ativos.remove(id_2); }
                            else{ System.out.println("ERRO: Usuário não encontrado.\n"); }
                        }
                    break;
                    default:
                    break;
                }
            break;
            case 7:         
                System.out.println("Digite a opção: \n 1: Adicionar tarefa.\n 2: Remover tarefa.\n"); 
                switch (ler.nextInt()) {
                    case 1:
                        System.out.println("Digite a nova tarefa.\n");
                        this.tarefas.add(ler.nextLine());
                    break;
                    case 2:
                        System.out.println("Digite a tarefa.\n");
                        int id_3 = Check_tarefa(ler.nextLine());
                        if (id_3 != -1) { this.tarefas.remove(id_3); }
                        else{ System.out.println("ERRO: Tarefa não encontrada.\n"); }
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

    public int Check_tarefa(String tarefa){
        for (int i = 0; i < this.tarefas.size(); i++){
            if(this.tarefas.get(i).intern().equals(tarefa.intern())){
                return i;
            }
        }
        return -1;
    }
    public Atividade(){
        Edit_identificacao(-1);
        Edit_descricao("null"); 
        responsavel = new Usuarios();
        tarefas = new ArrayList<String>();
    }
    @Override
    public void inter() {
        System.out.println("Interface.\n");
    }
}