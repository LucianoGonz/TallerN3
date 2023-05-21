package utils;


import dominio.InstrumentoCuerda;
import dominio.Instrumentos;
import edu.princeton.cs.stdlib.StdOut;

public class ListaInstrumentos {

    public Instrumentos[] listainstrumentos;
    private int cantMax;
    private int cantActual;


    public ListaInstrumentos(int cantMax) {
        this.cantMax = cantMax;
        this.cantActual = 0;
        this.listainstrumentos = new Instrumentos[cantMax];
    }

    public void agregar(Instrumentos instrumento) {

        if (this.cantActual < listainstrumentos.length) {
            this.listainstrumentos[this.cantActual]=instrumento;
            this.cantActual++;
        } else {
            StdOut.println("No se pueden agregar mas instrumentos al lista esta completa");
        }

    }
    public Instrumentos obtenerInstrumentoPorposicion(int posicion){
        if (posicion<0||posicion>=this.cantActual){
            return null;
        }
        return this.listainstrumentos[posicion];
    }

    public Instrumentos buscarInstrumentoporCodigo(String codigo) {

        for (int i = 0; i < this.cantActual; i++) {
            if (this.listainstrumentos[i].getCodigo().equalsIgnoreCase(codigo)) {
                return this.listainstrumentos[i];
            }

        }
        return null;
    }



    public int getCantActual() {
        return cantActual;
    }


}
