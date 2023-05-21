package services;

import java.io.IOException;

public interface Sistema {
    /*Method agregarInstrumento
    *@param El Instrumento a agregar
    *
     */
    public void agregarInstrumento();
    /*Method menuPrincipal
    *@param el Sistema a desplegar
    *
     */
    public void menuPrincipal() throws IOException;
    public void iniciar();
    public void venderInstrumento();
    public void consultarInventario();
    public void terminarPrograma();

}
