import java.util.ArrayList;

public class Loja {
    private ArrayList<Cliente> clientes;
    private ArrayList<Roupa> roupas;
    private ArrayList<Atendente> atendentes;
    private int lastID;

    public Loja(){
        this.clientes = new ArrayList();
        this.roupas = new ArrayList();
        this.atendentes = new ArrayList();
        this.lastID = 0;

        addRoupa(TipoRoupa.smoking,"Preto",50,150);
        addRoupa(TipoRoupa.smoking,"Branco",50,150);
        addRoupa(TipoRoupa.terno,"Preto",50,150);
        addRoupa(TipoRoupa.terno,"Azul",50,150);
        addRoupa(TipoRoupa.vestidoCurto,"Amarelo",30,130);
        addRoupa(TipoRoupa.vestidoCurto,"Vermelho",30,130);
        addRoupa(TipoRoupa.vestidoLongo,"Roxo",40,140);
        addRoupa(TipoRoupa.vestidoLongo,"Violeta",40,140);
        addRoupa(TipoRoupa.terno,"Roxo",80,180);
        addRoupa(TipoRoupa.vestidoLongo,"Verde",35,135);
    }

    public void addPessoa(String nome, String telefone, String cpf, Sexo sexo,  String email){ //Add cliente
        Cliente novo = new Cliente(nome, telefone, cpf, sexo,  email);
        this.clientes.add(novo);
    }

    public void addPessoa(String nome, String telefone, Sexo sexo, String cpf, Loja loja, int acesso, String email){ //Add Atendente
        Atendente novo = new Atendente(nome, telefone, cpf, sexo, loja, acesso, email);
        this.atendentes.add(novo);
    }

    public void addRoupa(TipoRoupa tipo, String cor, double getPrecoAluguel, double precoVenda){
        Roupa nova = new Roupa(lastID, tipo, cor, getPrecoAluguel,precoVenda);
        lastID++;
        this.roupas.add(nova);
    }

    public boolean login(int acesso){ //Login atendente
        for(Atendente a: this.atendentes){
            if(a.getAcesso() == acesso) return true;
        }
        return false;
    }

    public boolean login(String nomeC){ //Login cliente
        for(Cliente c: this.clientes){
            if(c.getNome().equals(nomeC)){
                return true;
            }
        }
        return false;        
    }

    public Atendente getPessoa(int acesso){
        for(Atendente a: this.atendentes){
            if(a.getAcesso() == acesso) return a;
        }
        return null;
    }

    public Cliente getPessoa(String nome){
        for(Cliente c: this.clientes){
            if(c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }

    public String listarPessoas(){
        String res = "Clientes:\n";

        if(this.clientes.size() == 0) res = res + "Não existe clientes cadastrados.";
        
        for(Cliente c: clientes){
            res = res + c.getNome() + " " + c.getTelefone() + "\n";
        }

        res = res + "\nAtendentes\n";
        for(Atendente a: atendentes){
            res = res + a.getNome() + " " + a.getTelefone() + "\n";
        }

        return res;
    }

    public Roupa getRoupa(int id){
        for(Roupa r: this.roupas){
            if(r.getId() == id) return r;
        }
        return null;
    }

    public ArrayList<Roupa> getRoupas() {
        return roupas;
    }

}
