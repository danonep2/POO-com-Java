import java.util.ArrayList;

public class Cliente extends Pesssoa implements InterCliente{
    private ArrayList<Roupa> roupas;
    private double debito;
    private Remove remove;

    public Cliente(String nome, String telefone, String cpf,  Sexo sexo, String email) {
        super(nome, telefone, cpf, sexo, email);
        this.roupas = new ArrayList<>();
        this.remove = new Remove();
        this.debito = 0;
    }
    
    public double getDebito() {
        return debito;
    }
    
    public void setDebito(double debito) {
        this.debito = debito;
    }

    public void addDebito(double d){
        this.debito += d;
    }
    
    @Override
    public String listRoupas(Boolean entregar) {
        String res = "";
        for (Roupa r : this.roupas) {
            if (r.isDisponivel() && entregar) continue;            
            res = res + r.getRoupa(entregar);                
            }

        return res;
    }
    
    @Override
    public boolean temRoupa(int id) {
        for (Roupa r : roupas) {
            if (r.getId() == id)
            return true;
        }
        return false;
    }

    @Override
    public void addRoupa(Roupa roupa) {
        this.roupas.add(roupa);
    }
    
    @Override
    public void entregarRoupa(Roupa r, double preco) {
        r.setData("");
        r.setDisponivel(true);
        addDebito(preco);
        remove.remove(this.roupas, r.getId());        
    }

    public void setRoupas(ArrayList<Roupa> roupas) {
        this.roupas = roupas;
    }
    
    public ArrayList<Roupa> getRoupas() {
        return roupas;
    }
}
