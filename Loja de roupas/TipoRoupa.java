public enum TipoRoupa {
    smoking(Sexo.MASCULINO,"Smoking",false),
    terno(Sexo.MASCULINO,"Terno",true),
    vestidoLongo(Sexo.FEMININO,"Vestido longo",false),
    vestidoCurto(Sexo.FEMININO,"Vestido curto",true);

    Sexo sexo;
    String tipo;
    boolean podeVender;

    TipoRoupa(Sexo sexo,String tipo,Boolean podeVender){
        this.sexo = sexo;
        this.podeVender = podeVender;
        this.tipo = tipo;
    }
    
}
