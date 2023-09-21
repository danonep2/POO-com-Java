class Animal {
    private int id;
    private double peso = 0;
    private double preco = 0;
    private String tipo;

    public String getAnimal(){
        if (peso != 0)return "\nID :" + this.id +  "\nO animal é um " + this.tipo+ "\nTem " + this.peso + "KG\n" + "E custa: R$" + this.preco;
        else return "\nID :" + this.id + "\nO animal é um " + this.tipo+  "\n Peso e preço não informados";
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int setID() {
        return this.id;
    }

    public double getpeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        
    }
    public void setPreco(){
        if (this.tipo == "bovino") this.preco = peso * 40;
        if (this.tipo == "ovino")  this.preco = peso * 25;
        if (this.tipo == "suino")  this.preco = peso * 30;
    }

    public double getPreco(){
        return this.preco;
    }

}