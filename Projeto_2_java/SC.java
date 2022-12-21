
public abstract class SC<T>{
    
    private int identificacao;
    private String descricao;
    private Data data_inicio;
    private Data data_termino;
    private T generic;

    public int                  Get_identificacao(){        return identificacao;          }
    public String               Get_descricao(){            return descricao;              }
    public Data                 Get_data_inicio(){          return data_inicio;            }
    public Data                 Get_data_termino(){         return data_termino;           }
    
    public void  Edit_identificacao(int identificacao){  this.identificacao = identificacao; }
    public void  Edit_descricao(String descricao){       this.descricao = descricao;         }
    public void  Edit_data_inicio(){                     this.data_inicio.Edit();            }
    public void  Edit_data_termino(){                    this.data_termino.Edit();           }

    public void Delete_identificacao    (){ identificacao = 0;      }
    public void Delete_descricao        (){ descricao = null;       }
    public void Delete_data_inicio      (){ data_inicio = null;     } 
    public void Delete_data_termino     (){ data_termino = null;    }

    public void get_MM(){
        System.out.println("id =" + identificacao + " desc ="+ descricao);
    }

    public void consulta_SC(){
        System.out.println("Identificação: "+this.identificacao+".\n");
        System.out.println("Descrição: "+this.descricao+".\n");
        System.out.println("Data de início: ");
        this.data_inicio.consulta();
        System.out.println("Data de termino: ");
        this.data_termino.consulta();
    }
}