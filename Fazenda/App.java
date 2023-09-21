public class App {
    public static void main(String[] args) throws Exception {
        Fazenda fazendinha = new Fazenda();
        fazendinha.AddAnimalPeso("ovino",100);
        fazendinha.AddAnimalPeso("bovino",400);
        fazendinha.AddAnimalPeso("suino",150);
        fazendinha.AddAnimalPeso("ovino",100);
        fazendinha.AddAnimalPeso("bovino",450);
        fazendinha.AddAnimalPeso("bovino",500);
        fazendinha.AddAnimal("ovino");
        fazendinha.AddAnimal("ovino");
        fazendinha.AddAnimal("bonino");
        fazendinha.AddAnimal("bovino");
        fazendinha.AddAnimal("bovino");
        fazendinha.AddAnimal("ovino");
        fazendinha.AddAnimal("ovino");
        System.out.println(fazendinha.GetAnimais());
        System.out.println(fazendinha.listAnimals());
    }
}
