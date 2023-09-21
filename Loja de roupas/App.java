import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Loja loja = new Loja();
        Scanner scan = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema da Casa da moda");

        loja.addPessoa("Iago", "1",  "1",Sexo.MASCULINO,"1@gmail.com");
        loja.addPessoa("Joana", "42140809", Sexo.FEMININO,  "1209380", loja, 1728, "@gmail.com");
        loja.addPessoa("Maria", "23495729", Sexo.FEMININO,  "2146821", loja, 1727, "@gmail.com");
        loja.addPessoa("Aline", "23686432", Sexo.FEMININO,  "6449842", loja, 1729, "@gmail.com");

        while (true) {
            System.out.println("Aguardando cliente...");
            System.out.println("Digite 'iniciar' para acessar o sistema");
            System.out.println("Digite 'parar' para encerrar o sistema");
            System.out.println("Digite 'listar' para listar as pessoas cadastradas");

            String wait = scan.next();

            if (wait.equals("parar"))
                break;
            if (wait.equals("listar")) System.out.println(loja.listarPessoas());

            if (wait.equals("iniciar")) {
                System.out.println("Digite o acesso do atendente:");
                System.out.print("Acesso:");
                int acesso = scan.nextInt();

                if(!loja.login(acesso)){
                    System.out.println("Acesso negado.");
                    continue;
                }

                Atendente atendenteAtual = loja.getPessoa(acesso);

                System.out.println("Atendente " + atendenteAtual.getNome() + " encontrada!");

                System.out.println("Acessando sistema...");
                System.out.println("Bem vindo ao sistema.");
                System.out.println("O cliente possue cadastro?");
                System.out.println("1.Sim\n2.Não");

                int login = scan.nextInt();

                Cliente clienteAtual;

                if (login == 1) {
                    System.out.println("Qual o nome do cliente?");
                    String nomeC = scan.next();

                    if (loja.login(nomeC)) {
                        System.out.println("Cliente encontrado!");
                        clienteAtual = loja.getPessoa(nomeC);
                    }
                    else {
                        System.out.println("Cliente não encontrado!");
                        continue;
                    }
                }

                else {
                    System.out.println("Cadastrando novo cliente...");

                    System.out.print("Nome: ");
                    String nNome = scan.next();

                    System.out.print("Telefone: ");
                    String nNumero = scan.next();

                    System.out.print("CPF:");
                    String cpf = scan.next();

                    System.out.println("O cliente usa roupas:");
                    System.out.println("1.Masculinas\n2.Femeninas");

                    Sexo s = Sexo.MASCULINO;
                    int nS = scan.nextInt();

                    if (nS == 2) s = Sexo.FEMININO;

                    System.out.println("Email:");
                    String email = scan.next();

                    loja.addPessoa(nNome, cpf, nNumero, s, email);
                    System.out.println("Cliente cadastrado!");
                    clienteAtual = loja.getPessoa(nNome);
                }

                while (true) {
                    System.out.println("O que deseja fazer, " + clienteAtual.getNome() + "?");
                    System.out.println("1.Ver o estoque");
                    System.out.println("2.Ver débito com a loja");
                    if (clienteAtual.getRoupas().size() != 0){
                        System.out.println("3.Ver roupas");
                        System.out.println("4.Entregar uma roupa alugada");
                    }
                    System.out.println("0.Sair do sistema");

                    int acao = scan.nextInt();

                    if (acao == 0) break;

                    if (acao == 1) {
                        while (true) {
                            System.out.println(atendenteAtual.mostrarCatalogo(clienteAtual.getSexo()));
                            System.out.println("Qual roupa deseja esperimentar?");
                            System.out.println("Digite 0 para sair");
                            System.out.print("ID: ");

                            acao = scan.nextInt();

                            if (acao == 0) break;

                            int id = acao -1;
                            Roupa roupaExperimentada = loja.getRoupa(id);

                            if (roupaExperimentada.getTipo().sexo != clienteAtual.getSexo()){
                                System.out.println("Você não pode comprar/alugar esta roupa!");
                                continue;
                            }
                            
                            if (!(roupaExperimentada.isDisponivel())) {
                                System.out.println("A roupa não está disponivel.");
                                continue;
                            }

                            System.out.println("O que deseja fazer agora?");
                            System.out.println("1.Experimentar outra roupa");
                            System.out.println("2.Alugar esta roupa");
                            if (roupaExperimentada.getTipo().podeVender) {
                                System.out.println("3.Comprar esta roupa");
                            }

                            acao = scan.nextInt();

                            if (acao == 1) continue;
                            if (acao == 2){
                                System.out.print("Informe a data quando alugou:");
                                String data = scan.next();
                                System.out.println("Alugando roupa...");
                                atendenteAtual.alugar(roupaExperimentada,clienteAtual,data);
                            }
                            if (acao == 3){
                                if (!roupaExperimentada.getTipo().podeVender){
                                    System.out.println("Você não pode comprar esta roupa!");
                                    continue;
                                }
                                atendenteAtual.vender(clienteAtual,roupaExperimentada);                            
                                System.out.println(String.format("Novo débito: %1.2f",clienteAtual.getDebito()));
                            } 
                        }
                    }
                    if (acao == 2) System.out.println(String.format("Débito: %1.2f",clienteAtual.getDebito()));
                    if (acao == 3) {
                        System.out.println("Débito atual:" + clienteAtual.getDebito());
                        System.out.println(clienteAtual.listRoupas(false));
                    }
                    if (acao == 4){
                        System.out.println(clienteAtual.listRoupas(true));
                        System.out.print("Qual roupa deseja entregar?\nID:");
                        int id = scan.nextInt();
                        id--;

                        if(!clienteAtual.temRoupa(id)){
                            System.out.println("Esta roupa não foi alugada!");
                            continue;
                        }

                        System.out.println("A roupa está danificada?");
                        System.out.println("1.Sim\n2.Não");

                        acao = scan.nextInt();
                        
                        if(acao == 1){
                            System.out.println("O cliente terá que comprar a roupa.");
                            atendenteAtual.vender(clienteAtual, loja.getRoupa(id));        
                            System.out.println(String.format("Novo débito: %1.2f",clienteAtual.getDebito()));
                        }
                        else{
                            System.out.println("Quantos dias o client ficou com a roupa?");
                            int dias = scan.nextInt();
                            System.out.println((dias < 3)? "Não precisa pagar multa" : "Precisa pargar multa");
                            atendenteAtual.receberRoupa(clienteAtual, loja.getRoupa(id), dias);
                        } 
                        System.out.println("Roupa entregue!");
                        System.out.println(String.format("Novo débito: %1.2f",clienteAtual.getDebito()));
                    }
                }
            }
        }
    }
}
