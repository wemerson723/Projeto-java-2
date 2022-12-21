import java.util.Scanner;

public class Cliente {
    private Usuarios cliente;

    public Cliente(Gerencia Univer){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a Opção:");
        System.out.println("1: Fazer login.");
        System.out.println("2: Cadastrar novo Usuário.");
        System.out.println("3: Entrar como ADM.");
        System.out.println("0: Sair.");
        
        int id = 1;
        while (id != 0){
            try {
                id = ler.nextInt();
                switch (id) {
                    case 0:{break;}
                    case 1:{
                        Univer.login();
                        break;}
                    case 2:{
                        Univer.ADD_Usuario();
                        break;}
                    case 3:{
                        Univer.ADM();
                        break;}
                    default:{
                        System.out.println("ERRO: Opção inválida.");
                    break;}
                }
            } catch (Exception e) {
                System.out.println("ERRO: Houve um erro durante a criação do Cliente.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        };
    }
}
