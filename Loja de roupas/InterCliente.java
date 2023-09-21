import java.util.ArrayList;

public interface InterCliente {
    public String listRoupas(Boolean entregar);
    public boolean temRoupa(int id);
    public void addRoupa(Roupa roupa);
    public void entregarRoupa(Roupa r, double preco);
}
