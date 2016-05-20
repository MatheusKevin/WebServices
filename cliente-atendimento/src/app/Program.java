package app;

import java.util.Scanner;
import services.FilaAtendimento;
import services.FilaAtendimentoService;

public class Program {

    public static void main(String[] args) {
        FilaAtendimentoService fs = new FilaAtendimentoService();
        FilaAtendimento fila = fs.getFilaAtendimentoPort();
        Scanner sc = new Scanner(System.in);
        int menu;
        do{
            System.out.println("Digite:\n1-Senha de atendimento");
            menu = sc.nextInt();
            switch(menu){
                case 1:
                    System.out.println("Senha: "+fila.gerarSenha());
                    break;
                default:
                    System.out.println("Digite um número válido");
            }
        }while(true);
    }
    
}
