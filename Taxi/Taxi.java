import java.util.ArrayList;

public class Taxi {
    Motorista driver = new Motorista();
    Carro car = new Carro();
    ArrayList<Corrida> corridas = new ArrayList<>();

    String getCs(){
        int n = corridas.size();
        if(n == 0) return "Não há corridas registradas.";
        else{
            String res = "";
            for(int i = 0; i < n ; i++){
                res += "Corrida " + (i + 1) + "\n" + corridas.get(i).getC();
                
            }

            return res;
        }
    }
}
