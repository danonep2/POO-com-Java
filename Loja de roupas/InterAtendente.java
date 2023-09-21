public interface InterAtendente {
    public String mostrarCatalogo(Sexo sexo);
    public void vender(Cliente c,Roupa r);
    public void receberRoupa(Cliente c, Roupa r, int dias);
    public void alugar(Roupa roupaExperimentada, Cliente clienteAtual, String data);

}
