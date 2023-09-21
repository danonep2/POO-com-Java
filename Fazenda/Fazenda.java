import java.util.ArrayList;

class Fazenda {
    private int quantidade_total = 0;
    private int qtd_suino = 0;
    private int qtd_ovino = 0;
    private int qtd_bovino = 0;
    ArrayList<Animal> animais = new ArrayList<Animal>();
    private int lastID = 1;

    public String GetAnimais() {
        return "A fazenda possue " + quantidade_total + " animais\n"
        + qtd_bovino + " bovinos.\n" + qtd_ovino
        + " ovinos.\n" + qtd_suino + " sunios.\n";
    }
    public String listAnimals(){
        String res = "";
        for(int i = 0; i < animais.size();i++){
            res = res + "\n" + animais.get(i).getAnimal();            
        }
        return res;
    }
    
    public void AddAnimal(String tipo){
        Animal newAnimal = new Animal();

        newAnimal.setID(this.lastID);
        this.lastID++;

        newAnimal.setTipo(tipo);
        
        this.quantidade_total++;
        
        if (tipo == "bovino") {
            this.qtd_bovino++;
        }
        if (tipo == "ovino") {
            this.qtd_ovino++;
        }
        if (tipo == "suino") {
            this.qtd_suino++;
        }
        this.quantidade_total++;

        animais.add(newAnimal);

    }

    public void AddAnimalPeso(String tipo, double peso) {
        Animal newAnimal = new Animal();

        newAnimal.setID(this.lastID);
        this.lastID++;

        newAnimal.setTipo(tipo);
        
        this.quantidade_total++;
        if (tipo == "bovino") {
            this.qtd_bovino++;
        }
        if (tipo == "ovino") {
            this.qtd_ovino++;
        }
        if (tipo == "suino") {
            this.qtd_suino++;
        }
        this.quantidade_total++;

        newAnimal.setPeso(peso);
        newAnimal.setPreco();

        animais.add(newAnimal);
        
    }
}
