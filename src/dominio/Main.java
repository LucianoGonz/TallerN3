package dominio;

import services.SistemaImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        SistemaImpl sistema = new SistemaImpl();
        sistema.LeerArchivo();
        sistema.menuPrincipal();



    }
}