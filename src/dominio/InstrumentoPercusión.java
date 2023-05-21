package dominio;

public class InstrumentoPercusión extends Instrumentos {

    private String tipoPercusion;
    private String altura;

    public InstrumentoPercusión(String codigo, int precio, int stock, String nombre, String material, String tipoPercusion, String altura) {
        super(codigo, precio, stock,nombre, material);
        this.tipoPercusion = tipoPercusion;
        this.altura = altura;
    }

    public String getTipoPercusion() {
        return tipoPercusion;
    }

    public String getAltura() {
        return altura;
    }
}
