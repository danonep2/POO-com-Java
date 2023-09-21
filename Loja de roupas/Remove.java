import java.util.ArrayList;

class Remove {
    public void remove(ArrayList<Roupa> roupas, int id){
        int count = 0;
        for(Roupa r: roupas){
            if (r.getId() == id){
                roupas.remove(count);
                break;
            }
            count++;
        }
    }    
}
