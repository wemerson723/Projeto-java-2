import java.util.Scanner;

class Data{

    private int segundos;
    private int minutos;
    private int horas;
    private int dia;
    private int mes;
    private int ano;

    public int Get_segundos (){ return segundos; }
    public int Get_minutos  (){ return minutos;  }
    public int Get_horas    (){ return horas;    }
    public int Get_dia      (){ return dia;      }
    public int Get_mes      (){ return mes;      }
    public int Get_ano      (){ return ano;      }

    public void consulta(){
        System.out.println(this.dia +"/"+ this.mes +"/"+ this.ano +". "+ this.horas +":"+ this.minutos +":"+ this.segundos + ".\n");
    }

    public boolean check(){ if ((segundos != -1) && (minutos != -1) && (horas != -1) && (dia != -1) && (mes != -1) && (ano != -1)){ return true; } else{ return false;}}
        
    public void Edit(){

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o Dia:");
        this.dia = ler.nextInt();

        System.out.println("Digite o Mês:");
        this.mes = ler.nextInt();

        System.out.println("Digite o Ano:");
        this.ano = ler.nextInt();

        System.out.println("Digite as Horas:");
        this.horas = ler.nextInt();

        System.out.println("Digite os Minutos:");
        this.minutos = ler.nextInt();

        System.out.println("Digite os Segundos:");
        this.segundos = ler.nextInt();
        
    }
    public void data(){
        this.segundos = -1;
        this.minutos = -1; 
        this.horas = -1;
        this.dia = -1;
        this.mes = -1;
        this.ano = -1;
    }
}