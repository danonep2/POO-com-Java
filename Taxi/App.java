import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Taxi verif;


        Scanner inp = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de taxi!!!");
        int act;
        ArrayList<Taxi> cads = new ArrayList<>();

        Taxi taxiT = new Taxi();
        taxiT.driver.nome = "Julio";
        taxiT.driver.cpf = "123,123,123-21";
        taxiT.car.cor = "azul";
        taxiT.car.modelo = "Corola";
        cads.add(taxiT);


        Taxi taxiT2 = new Taxi();
        taxiT2.driver.nome = "Cesar";
        taxiT2.driver.cpf = "123,123,123-21";
        taxiT2.car.cor = "amarelo";
        taxiT2.car.modelo = "Celta";
        cads.add(taxiT2);



        while (true){
            System.out.println("O que deseja fazer?");
            System.out.println("1. Realizar um cadastro");
            System.out.println("2. Listar táxis cadastrados");
            System.out.println("3. Remover um táxi");
            System.out.println("4. Selecionar um taxi");
            System.out.println("0. Finalizar programa");

            act = inp.nextInt();

            if (act == 0) break;

            else if (act == 1){
                Taxi cadsNow = new Taxi();

                System.out.println("Digite nome do motorista:");
                cadsNow.driver.nome = inp.next();
                System.out.println("Digite o cpf do motorista:");
                cadsNow.driver.cpf = inp.next();

                System.out.println("Digite o modelo do carro");
                cadsNow.car.modelo = inp.next();
                System.out.println("Digite a cor do carro:");
                cadsNow.car.cor = inp.next();

                System.out.println("Cadastro realizado com sucesso :D\n\n");

                cads.add(cadsNow);

            }

            else if (act == 2){
                int n = cads.size();
                Taxi list;
                if(cads.size() == 0) System.out.println("Não existe taxis registrados :(");
                else{
                    for(int x = 0; x < n; x++){
                        list = cads.get(x);
                        System.out.println("Taxi " + (x + 1));
                        System.out.println("Motorista: " + list.driver.getNome());
                        System.out.println("CPF: " + list.driver.getCpf());
                        System.out.println("Modelo: " + list.car.getModelo());
                        System.out.println("Cor: " + list.car.getCor());
                        System.out.println("\n");                
                    }
}
            }
            else if (act == 3){
                System.out.println("Qual o numero do taxi q deseja remover?");
                int ind = inp.nextInt();
                if(cads.size() < ind){
                    System.out.println("Numero invalido");
                }
                else{
                    cads.remove(ind - 1);
                    System.out.println("Táxi removido.");
                }
            }
            else if (act == 4){
                System.out.println("Qual motorista deseja selecionar?");
                String driverNow = inp.next();
                int x, F = 0;
                int n = cads.size();

                for(x = 0;x < n;x ++){
                    verif = cads.get(x);
                    System.out.println();
                    if (verif.driver.getNome().equals(driverNow)){
                        F = x+1;
                        break;
                    }
                }

                if(F == 0) System.out.println("Motorista nao encontrado");
                else{
                    System.out.println("Motorista encontrado e selecionado.");
                    int acao;
                    Taxi select = cads.get(F -1);
                    while (true){
                        System.out.println("1.Listar corridas anteriores\n2.Inicar uma nova corrida\n0.Sair da seleção");
                        acao = inp.nextInt();
                        if(acao == 0) break;
                        else if(acao == 1){
                           System.out.println(select.getCs());
                        }
                        else if(acao == 2){
                            Corrida c = new Corrida();
                            System.out.println("Digite a data da corrida:");
                            c.data = inp.next();

                            System.out.println("Digite a origem da corrida:");
                            c.origem = inp.next();

                            System.out.println("Digite o destino da corrida:");
                            c.destino = inp.next();

                            System.out.println("Digite a hora da corrida:");
                            c.hora = inp.next();

                            System.out.println("Digite o valor da corrida:");
                            c.valor = inp.nextDouble();
                            
                            select.corridas.add(c);
                            System.out.println("Corrida registrada com sucesso!!");

                        }
                    }
                }

            }
            else System.out.println("Ação inválida");
    }
}
}