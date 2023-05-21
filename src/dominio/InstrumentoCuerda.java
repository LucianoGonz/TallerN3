package dominio;

public class InstrumentoCuerda extends Instrumentos {

    private String tipoCuerda;
    private String tipoSonido;
    private int numeroCuerdas;

    public InstrumentoCuerda(String codigo, int precio, int stock, String nombre, String material, String tipoCuerda, String tipoSonido, int numeroCuerdas) {
        super(codigo, precio, stock, nombre, material);
        this.tipoCuerda = tipoCuerda;
        this.tipoSonido = tipoSonido;
        this.numeroCuerdas = numeroCuerdas;
    }

    public String getTipoCuerda() {
        return tipoCuerda;
    }

    public String getTipoSonido() {
        return tipoSonido;
    }

    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }

}
