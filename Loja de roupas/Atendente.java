public class Atendente extends Pesssoa implements InterAtendente{
    private Loja loja;
    private int acesso;
    private Remove remove;

    public Atendente(String nome, String telefone, String cpf, Sexo sexo, Loja loja, int acesso, String email) {
        super(nome, telefone, cpf, sexo, email);
        this.loja = loja;
        this.acesso = acesso;
        this.remove = new Remove();
    }
    
    @Override
    public String mostrarCatalogo(Sexo sexo){
        String res = "ID|      Tipo     |     Cor    |Aluguel | Venda  | Disponibilidade\n";
        for(Roupa r: loja.getRoupas()){
            if (r.getTipo().sexo == sexo){
                res = res + r.getRoupa(false);
            }
        }
        return res;
    }

    @Override
    public void vender(Cliente c,Roupa r){
        c.addRoupa(r);
        c.addDebito(r.getPrecoVenda());
        r.setDisponivel(true);
        loja.addRoupa(r.getTipo(), r.getCor(), r.getPrecoAluguel(), r.getPrecoVenda());
        remove.remove(loja.getRoupas(),r.getId());     
    }

    @Override
    public void receberRoupa(Cliente c, Roupa r, int dias){
        if (dias < 3){
            c.entregarRoupa(r, r.getPrecoAluguel());
            return;
        }
        c.entregarRoupa(r, r.getPrecoAluguel() * (1 + 0.1 * (dias -2)));     
    }

    @Override
    public void alugar(Roupa roupaExperimentada, Cliente clienteAtual, String data){      
        roupaExperimentada.setDisponivel(false);
        roupaExperimentada.setData(data);
        clienteAtual.addRoupa(roupaExperimentada);
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
}
