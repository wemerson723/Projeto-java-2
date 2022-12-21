import java.util.Scanner;

class Data{

    public int segundos;
    public int minutos;
    public int horas;
    public int dia;
    public int mes;
    public int ano;

    public int Get_segundos (){ return segundos; }
    public int Get_minutos  (){ return minutos;  }
    public int Get_horas    (){ return horas;    }
    public int Get_dia      (){ return dia;      }
    public int Get_mes      (){ return mes;      }
    public int Get_ano      (){ return ano;      }

    public void consulta(){

        try {

            System.out.println(this.dia +"/"+ this.mes +"/"+ this.ano +". "+ this.horas +":"+ this.minutos +":"+ this.segundos + ".\n");
            
        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante a consulta de data.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean check(){ if ((segundos != -1) && (minutos != -1) && (horas != -1) && (dia != -1) && (mes != -1) && (ano != -1)){ return true; } else{ return false;}}
        
    public void Edit(){

        Scanner ler = new Scanner(System.in);

        try {

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

        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante a edição da data.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    public static class DataBuilder{
        public int segundos;
        public int minutos;
        public int horas;
        public int dia;
        public int mes;
        public int ano;

        DataBuilder(){
        }
        public DataBuilder segundos(int segundos){
            this.segundos = segundos;
            return this;
        }
        public DataBuilder minutos(int minutos){
            this.minutos = minutos;
            return this;
        }
        public DataBuilder horas(int horas){
            this.horas = horas;
            return this;
        }
        public DataBuilder dia(int dia){
            this.dia = dia;
            return this;
        }
        public DataBuilder mes(int mes){
            this.mes = mes;
            return this;
        }
        public DataBuilder ano(int ano){
            this.ano = ano;
            return this;
        }
        public Data CriarData(){
            return new Data();
        }
    }
    private void Data(){
        try {
            this.segundos = -1;
            this.minutos = -1; 
            this.horas = -1;
            this.dia = -1;
            this.mes = -1;
            this.ano = -1;
        } catch (Exception e) {
            System.out.println("ERRO: Houve um erro durante a criação da data.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}