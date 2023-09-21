public class Roupa {
    private int id;
    private TipoRoupa tipo;
    private String cor;
    private boolean disponivel;
    private double precoAluguel;
    private double precoVenda;
    private String data;

    public Roupa(int id,TipoRoupa tipo, String cor, double precoAluguel, double precoVenda) {
        this.id = id;
        this.tipo = tipo;
        this.cor = cor;
        this.disponivel = true;
        this.precoAluguel = precoAluguel;
        this.precoVenda = precoVenda;
        this.data = "";
    }

    public String getRoupa(boolean entrega){
        String res = "";
        if (this.id < 9) 
            res = res + 0;
        
        res = res + (this.id + 1) + "|";
        res = res + String.format("%14s",this.tipo.tipo) + " | ";
        res = res + String.format("%-10s",this.cor ) + " | ";
        res = res + String.format("%-6.2f",this.precoAluguel) + " | ";
        
        if(entrega) return res + "\n";

        if (this.tipo.podeVender){
            res = res + String.format("%-6.2f",this.precoVenda) + " | ";
        }

        else res = res + "       | ";

        res = res + ((this.disponivel)? "Disponivel\n" : "Indisponivel" + " alugada em: " + this.data + "\n");
        return res;
    }

    public TipoRoupa getTipo() {
        return tipo;
    }

    public void setTipo(TipoRoupa tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
