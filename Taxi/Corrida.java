public class Corrida {
    String origem;
    String destino;
    String data;
    String hora;
    double valor;

    String getC(){
        return "Origem: " + origem + "\nDestino: " + destino + "\nData e hora:" + data + " " + hora + "\nValor: R$" + valor + "\n\n";
    }    
}
