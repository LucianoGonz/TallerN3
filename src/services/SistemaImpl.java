package services;

import dominio.InstrumentoCuerda;
import dominio.InstrumentoPercusión;
import dominio.InstrumentoViento;
import dominio.Instrumentos;
import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;
import utils.ListaInstrumentos;

import java.io.*;
import java.util.Arrays;

/*The SistemaImpl
*
*
* @author Programación Avanzada
 */
public class SistemaImpl implements Sistema {

    private ListaInstrumentos listaInstrumentos;


    @Override
    public void menuPrincipal() throws IOException {

        StdOut.println("#####BeatTheRhythm####");
        StdOut.println("Bienvenido al control maestro de inventario");
        StdOut.println("[1] - Agregar un instrumento");
        StdOut.println("[2] - Realizar una venta");
        StdOut.println("[3] - Consultar el stock");
        StdOut.println("[4] - Salir");

        String opcion = StdIn.readString();

        while(!opcion.equalsIgnoreCase("4")) {

            switch (opcion) {

                case "1":
                    agregarInstrumento();
                    break;
                case "2":
                    venderInstrumento();
                    break;
                case "3":
                    consultarInventario();
                    break;
                case "4":
                    terminarPrograma();
                    break;
                default:
                    StdOut.println("La opción que usted ha ingresado no es válida");
                    break;
            }

            StdOut.println("[1] - Agregar un instrumento");
            StdOut.println("[2] - Realizar una venta");
            StdOut.println("[3] - Consultar el stock");
            StdOut.println("[4] - Salir");

             opcion = StdIn.readString();


        }
    }
    public void LeerArchivo(){


        String SEPARADOR=",";
        BufferedReader bufferedLectura=null;

        try{
            Instrumentos instrumentos;

            bufferedLectura= new BufferedReader(new FileReader("csv_prueba.csv"));

            String linea= bufferedLectura.readLine();

            while (linea != null){

                String[] campos=linea.split(SEPARADOR);
                String codigo=campos[0];
                String preci0=campos[1];
                int precio=Integer.parseInt(preci0);
                String st0ck=campos[2];
                int stock=Integer.parseInt(st0ck);
                String instrumento=campos[3];
                if (instrumento.equalsIgnoreCase("guitarra")||instrumento.equalsIgnoreCase("violin")||instrumento.equalsIgnoreCase("Bajo")||instrumento.equalsIgnoreCase("Arpa")){
                    String tipoCuerda=campos[4];
                    String cuerdAs=campos[5];
                    int cuerdas=Integer.parseInt(cuerdAs);
                    String material=campos[6];
                    String tipo=campos[7];
                    instrumentos=new InstrumentoCuerda(codigo,precio,stock,instrumento,material,tipoCuerda,tipo,cuerdas);
                    listaInstrumentos.agregar(instrumentos);
                }
                if (instrumento.equalsIgnoreCase("Bongo")||instrumento.equalsIgnoreCase("Cajon")||instrumento.equalsIgnoreCase("Campanas Tubulares")||instrumento.equalsIgnoreCase("Bombo")){
                    String tipoPercusion=campos[4];
                    String Material=campos[5];
                    String Altura=campos[6];
                    instrumentos=new InstrumentoPercusión(codigo,precio,stock,instrumento,Material,tipoPercusion,Altura);
                    listaInstrumentos.agregar(instrumentos);
                }
                if (instrumento.equalsIgnoreCase("Trompeta")||instrumento.equalsIgnoreCase("Saxofon")||instrumento.equalsIgnoreCase("Clarinete")||instrumento.equalsIgnoreCase("Flauta traversa")){
                    String material=campos[4];

                    instrumentos=new InstrumentoViento(codigo,precio,stock,instrumento,material);
                    listaInstrumentos.agregar(instrumentos);
                }

                StdOut.println(Arrays.toString(campos));
                linea= bufferedLectura.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (bufferedLectura!=null){
                try{
                    bufferedLectura.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public SistemaImpl(){
        this.iniciar();
        this.listaInstrumentos=new ListaInstrumentos(250);
    }


    public void iniciar(){}


    @Override
    public void agregarInstrumento() {


        StdOut.println("Que tipo instrumento desea ingresar al sistema?");
        StdOut.println("Opciones Disponibles: ");
        StdOut.println("-Cuerda");
        StdOut.println("-Percusion");
        StdOut.println("-Viento");

        String instrumentoElegido = StdIn.readString();

        //Auxiliares para validación

        int precioInstrumento;
        int stockInstrumento;
        int alturaInstrumento;


        /*if (!instrumentoElegido.equalsIgnoreCase("Cuerda")||!instrumentoElegido.equalsIgnoreCase("Percusion") ||!instrumentoElegido.equalsIgnoreCase("Viento")){

            while (true) {

                StdOut.println("Está intentando ingresar un tipo de Instrumento no registrado en el sistema. Por favor, intentelo de nuevo con las siguientes opciones: ");
                StdOut.println("Cuerda,Percusion,Viento");
                instrumentoElegido = StdIn.readString();

                if (instrumentoElegido.equalsIgnoreCase("Cuerda") || instrumentoElegido.equalsIgnoreCase("Percusion") || instrumentoElegido.equalsIgnoreCase("Viento")) {
                    break;
                }
            }

                if (!instrumentoElegido.equalsIgnoreCase("Cuerda")||instrumentoElegido.equalsIgnoreCase("Percusion") ||instrumentoElegido.equalsIgnoreCase("Viento")) {

                    StdOut.println("Está intentando ingresar un tipo de Instrumento no registrado en el sistema. Por favor, intentelo de nuevo con las siguientes opciones: ");
                    StdOut.println("Cuerda,Percusion,Viento");
                    instrumentoElegido = StdIn.readString();
                    if(instrumentoElegido.equalsIgnoreCase("Cuerda")||instrumentoElegido.equalsIgnoreCase("Percusion")||instrumentoElegido.equalsIgnoreCase("Viento")) {*/

                        //Agregar instrumentos de Cuerda

                        if (instrumentoElegido.equalsIgnoreCase("Cuerda")) {

                            String nuevoInstrumento[] = new String[8];

                            StdOut.println("Ingrese el codigo del instrumento:");
                            nuevoInstrumento[0] = StdIn.readString();

                            StdOut.println("Ingrese el precio del instrumento:");
                            nuevoInstrumento[1] = StdIn.readString();

                            //Verifica que no se pueda ingresar un precio negativo
/*
                            precioInstrumento = Integer.parseInt(nuevoInstrumento[1]);
                            if (precioInstrumento < 0) {
                                while (true) {
                                    StdOut.print("Ingresó un precio inválido, por favor intentelo de nuevo: ");
                                    StdOut.println("");
                                    precioInstrumento = StdIn.readInt();
                                    if (precioInstrumento > 0) {
                                        nuevoInstrumento[1] = Integer.toString(precioInstrumento);
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el stock del instrumento:");
                            nuevoInstrumento[2] = StdIn.readString();

                            //Verifica que no se pueda ingresar un stock negativo al programa

                            /*stockInstrumento = Integer.parseInt(nuevoInstrumento[2]);
                            if (stockInstrumento < 0) {
                                while (true) {
                                    StdOut.println("Ha ingresado una cantidad de cuerdas no válida, por favor, intente de nuevo.");
                                    stockInstrumento = StdIn.readInt();
                                    if (stockInstrumento > 0) {
                                        nuevoInstrumento[2] = Integer.toString(stockInstrumento);
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el nombre del instrumento:");
                            nuevoInstrumento[3] = StdIn.readString();

                            //El bloque de código de abajo básicamente se asegura de que el usuario ingrese un Instrumento que exista
                            /*if (!nuevoInstrumento[3].equalsIgnoreCase("Guitarra") || !nuevoInstrumento[3].equalsIgnoreCase("Bajo") || !nuevoInstrumento[3].equalsIgnoreCase("Violin") || !nuevoInstrumento[3].equalsIgnoreCase("Arpa")) {
                                while (true) {
                                    StdOut.println("El instrumento que usted intenta ingresar no esta registrado en la tienda, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Guitarra,Arpa,Bajo,Violin");
                                    nuevoInstrumento[3] = StdIn.readString();
                                    if (nuevoInstrumento[3].equalsIgnoreCase("Guitarra") || nuevoInstrumento[3].equalsIgnoreCase("Bajo") || nuevoInstrumento[3].equalsIgnoreCase("Violin") || nuevoInstrumento[3].equalsIgnoreCase("Arpa")) {
                                        break;
                                    }
                                }
                            }*/


                            StdOut.println("Ingrese el tipo de cuerda del instrumento:");
                            nuevoInstrumento[4] = StdIn.readString();

                            /*if (!nuevoInstrumento[4].equalsIgnoreCase("nylon") || !nuevoInstrumento[4].equalsIgnoreCase("acero") || !nuevoInstrumento[4].equalsIgnoreCase("tripa")) {
                                while (true){
                                    StdOut.println("Ingresó un tipo de cuerda que no existe, por favor, invente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Nylon,Acero,Tripa");
                                    nuevoInstrumento[4] = StdIn.readString();
                                    if (nuevoInstrumento[4].equalsIgnoreCase("nylon") || nuevoInstrumento[4].equalsIgnoreCase("acero") || nuevoInstrumento[4].equalsIgnoreCase("tripa")) {
                                        break;
                                    }
                                }
                            }*/


                            StdOut.println("Ingrese la cantidad de cuerdas del instrumento:");
                            nuevoInstrumento[5] = StdIn.readString();

                            //Verifica que se ingrese una cantidad de cuerdas positiva

                            /*int cantidadDeCuerdas = Integer.parseInt(nuevoInstrumento[5]);
                            if (cantidadDeCuerdas < 0) {
                                while (true) {
                                    StdOut.println("Ha ingresado una cantidad de cuerdas no válida, por favor, intente de nuevo.");
                                    cantidadDeCuerdas = StdIn.readInt();
                                    if (cantidadDeCuerdas > 0) {
                                        nuevoInstrumento[5] = Integer.toString(cantidadDeCuerdas);
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el material del instrumento:");
                            nuevoInstrumento[6] = StdIn.readString();

                            /*Verifica que el material ingresado sea uno correspondiente al instrumento

                            if (!nuevoInstrumento[6].equalsIgnoreCase("metal") || !nuevoInstrumento[6].equalsIgnoreCase("madera")) {
                                while (true) {
                                    StdOut.println("Ingresó un tipo de material que no existe, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Madera,Metal");
                                    nuevoInstrumento[6] = StdIn.readString();
                                    if (nuevoInstrumento[6].equalsIgnoreCase("Madera") || nuevoInstrumento[6].equalsIgnoreCase("Metal")) {
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el tipo de instrumento ya sea [Acustica] o [electrico]:");
                            nuevoInstrumento[7] = StdIn.readString();

                            /*
                            if (!nuevoInstrumento[7].equalsIgnoreCase("Acustico") || !nuevoInstrumento[7].equalsIgnoreCase("Electrico")) {
                                while (true) {
                                    StdOut.println("Ingresó un tipo de instrumento que no existe, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Acustico, Electrico");
                                    nuevoInstrumento[7] = StdIn.readString();
                                    if (nuevoInstrumento[7].equalsIgnoreCase("Acustico") || nuevoInstrumento[7].equalsIgnoreCase("Electrico")) {
                                        break;
                                    }
                                }
                            }*/


                            //Escribe el archivo, usamos el contador para saber cuantos campos tenemos que escribir en el archivo

                            String archivo = "csv_prueba.csv";
                            int contador = 0;
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {

                                writer.newLine();
                                for (String dato : nuevoInstrumento) {
                                    if (contador == 7) {
                                        writer.write(dato);
                                        Instrumentos instrumentos = new InstrumentoCuerda(nuevoInstrumento[0], Integer.parseInt(nuevoInstrumento[1]), Integer.parseInt(nuevoInstrumento[2]), nuevoInstrumento[3], nuevoInstrumento[6], nuevoInstrumento[4], nuevoInstrumento[7], Integer.parseInt(nuevoInstrumento[5]));
                                        listaInstrumentos.agregar(instrumentos);
                                        writer.newLine();
                                        return;
                                    }
                                    writer.write(dato + ",");
                                    contador++;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                        //Agregar instrumentos de Percusion

                        if (instrumentoElegido.equalsIgnoreCase("Percusion")) {

                            String nuevoInstrumento[] = new String[7];
                            StdOut.println("Ingrese el codigo del instrumento:");
                            nuevoInstrumento[0] = StdIn.readString();

                            StdOut.println("Ingrese el precio del instrumento:");
                            nuevoInstrumento[1] = StdIn.readString();

                            /*Verifica que no se pueda ingresar un precio negativo al programa

                            precioInstrumento = Integer.parseInt(nuevoInstrumento[1]);
                            if (precioInstrumento < 0) {
                                while (true) {
                                    StdOut.print("Ingresó un precio inválido, por favor intentelo de nuevo: ");
                                    StdOut.println("");
                                    precioInstrumento = StdIn.readInt();
                                    if (precioInstrumento > 0) {
                                        nuevoInstrumento[1] = Integer.toString(precioInstrumento);
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el stock del instrumento:");
                            nuevoInstrumento[2] = StdIn.readString();

                            /*Verifica que no se pueda ingresar un stock negativo al programa

                            stockInstrumento = Integer.parseInt(nuevoInstrumento[2]);
                            if (stockInstrumento < 0) {
                                while (true) {
                                    StdOut.println("Ha ingresado una cantidad de cuerdas no válida, por favor, intente de nuevo.");
                                    stockInstrumento = StdIn.readInt();
                                    if (stockInstrumento > 0) {
                                        nuevoInstrumento[2] = Integer.toString(stockInstrumento);
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el nombre del instrumento:");
                            nuevoInstrumento[3] = StdIn.readString();

                            /*El bloque de código de abajo básicamente se asegura de que el usuario ingrese un Instrumento que exista acorde a su clase
                            if (!nuevoInstrumento[3].equalsIgnoreCase("Bongo") || !nuevoInstrumento[3].equalsIgnoreCase("Cajon") || !nuevoInstrumento[3].equalsIgnoreCase("Campanas") || !nuevoInstrumento[3].equalsIgnoreCase("Tubulares") || !nuevoInstrumento[3].equalsIgnoreCase("Bombo")) {
                                while (true) {
                                    StdOut.println("El instrumento que usted intenta ingresar no esta registrado en la tienda, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Bongo,Cajon,Campanas,Tubulares,Bombo");
                                    nuevoInstrumento[3] = StdIn.readString();
                                    if (nuevoInstrumento[3].equalsIgnoreCase("Bombo") || nuevoInstrumento[3].equalsIgnoreCase("Cajon") || nuevoInstrumento[3].equalsIgnoreCase("Campanas") || nuevoInstrumento[3].equalsIgnoreCase("Tubulares") || nuevoInstrumento[3].equalsIgnoreCase("Bombo")) {
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el tipo de percusion del instrumento:");
                            nuevoInstrumento[4] = StdIn.readString();

                            /*if (!nuevoInstrumento[4].equalsIgnoreCase("Membrafono") || !nuevoInstrumento[4].equalsIgnoreCase("Idiofono")) {
                                while (true) {
                                    StdOut.println("Ingresó un tipo de percusion que no existe, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Membrafono, Idiofono");
                                    nuevoInstrumento[4] = StdIn.readString();
                                    if (nuevoInstrumento[4].equalsIgnoreCase("Membrafono") || nuevoInstrumento[7].equalsIgnoreCase("Idiofono")) {
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el material del instrumento:");
                            nuevoInstrumento[5] = StdIn.readString();

                            /*if (!nuevoInstrumento[5].equalsIgnoreCase("metal") || !nuevoInstrumento[5].equalsIgnoreCase("madera") || !nuevoInstrumento[5].equalsIgnoreCase("piel")) {
                                while (true) {
                                    StdOut.println("Ingresó un tipo de material que no existe, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Madera,Metal,Piel");
                                    nuevoInstrumento[5] = StdIn.readString();
                                    if (nuevoInstrumento[5].equalsIgnoreCase("Madera") || nuevoInstrumento[5].equalsIgnoreCase("Metal") || nuevoInstrumento[5].equalsIgnoreCase("piel")) {
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese la altura del instrumento:");
                            nuevoInstrumento[6] = StdIn.readString();

                            //Verifica que no se pueda ingresar una altura negativa

                            /*alturaInstrumento = Integer.parseInt(nuevoInstrumento[6]);
                            if (alturaInstrumento < 0) {
                                while (true) {
                                    StdOut.println("Ha ingresado una cantidad de cuerdas no válida, por favor, intente de nuevo.");
                                    alturaInstrumento = StdIn.readInt();
                                    if (alturaInstrumento > 0) {
                                        nuevoInstrumento[6] = Integer.toString(alturaInstrumento);
                                        break;
                                    }
                                }
                            }*/


                            String archivo = "csv_prueba.csv";
                            int contador = 0;
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {

                                writer.newLine();
                                for (String dato : nuevoInstrumento) {
                                    if (contador == 6) {
                                        writer.write(dato);
                                        Instrumentos instrumentos = new InstrumentoPercusión(nuevoInstrumento[0], Integer.parseInt(nuevoInstrumento[1]), Integer.parseInt(nuevoInstrumento[2]), nuevoInstrumento[3], nuevoInstrumento[5], nuevoInstrumento[4], nuevoInstrumento[6]);
                                        listaInstrumentos.agregar(instrumentos);
                                        writer.newLine();
                                        return;
                                    }
                                    writer.write(dato + ",");
                                    contador++;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }

                        //Agregar instrumentos de Viento

                        if (instrumentoElegido.equalsIgnoreCase("Viento")) {

                            String nuevoInstrumento[] = new String[5];
                            StdOut.println("Ingrese el codigo del instrumento:");
                            nuevoInstrumento[0] = StdIn.readString();


                            StdOut.println("Ingrese el precio del instrumento:");
                            nuevoInstrumento[1] = StdIn.readString();

                            //Verifica que no se pueda ingresar un precio negativo al programa

                            /*precioInstrumento = Integer.parseInt(nuevoInstrumento[1]);
                            if (precioInstrumento < 0) {
                                while (true) {
                                    StdOut.print("Ingresó un precio inválido, por favor intentelo de nuevo: ");
                                    StdOut.println("");
                                    precioInstrumento = StdIn.readInt();
                                    if (precioInstrumento > 0) {
                                        nuevoInstrumento[1] = Integer.toString(precioInstrumento);
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el stock del instrumento:");
                            nuevoInstrumento[2] = StdIn.readString();

                            //Verifica que no se pueda ingresar un stock negativo al programa

                            /*stockInstrumento = Integer.parseInt(nuevoInstrumento[2]);
                            if (stockInstrumento < 0) {
                                while (true) {
                                    StdOut.println("Ha ingresado una cantidad de cuerdas no válida, por favor, intente de nuevo.");
                                    stockInstrumento = StdIn.readInt();
                                    if (stockInstrumento > 0) {
                                        nuevoInstrumento[2] = Integer.toString(stockInstrumento);
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el nombre del instrumento:");
                            nuevoInstrumento[3] = StdIn.readString();

                            //El bloque de código de abajo básicamente se asegura de que el usuario ingrese un Instrumento que exista acorde a su clase
                            /*if (!nuevoInstrumento[3].equalsIgnoreCase("Trompeta") || !nuevoInstrumento[3].equalsIgnoreCase("Clarinete") || !nuevoInstrumento[3].equalsIgnoreCase("Saxofon") || !nuevoInstrumento[3].equalsIgnoreCase("Flauta traversa")) {
                                while (true) {
                                    StdOut.println("El instrumento que usted intenta ingresar no esta registrado en la tienda, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Bongo,Cajon,Campanas,Tubulares,Bombo");
                                    nuevoInstrumento[3] = StdIn.readString();
                                    if (nuevoInstrumento[3].equalsIgnoreCase("Trompeta") || nuevoInstrumento[3].equalsIgnoreCase("Clarinete") || nuevoInstrumento[3].equalsIgnoreCase("Saxofon") || nuevoInstrumento[3].equalsIgnoreCase("Flauta traversa")) {
                                        break;
                                    }
                                }
                            }*/

                            StdOut.println("Ingrese el material del instrumento:");
                            nuevoInstrumento[4] = StdIn.readString();

                            /*if (!nuevoInstrumento[4].equalsIgnoreCase("metal") || !nuevoInstrumento[4].equalsIgnoreCase("madera")) {
                                while (true) {
                                    StdOut.println("Ingresó un tipo de material que no existe, por favor, intente de nuevo con las siguientes opciones: ");
                                    StdOut.println("Madera,Metal");
                                    nuevoInstrumento[4] = StdIn.readString();
                                    if (nuevoInstrumento[4].equalsIgnoreCase("Madera") || nuevoInstrumento[4].equalsIgnoreCase("Metal")) {
                                        break;
                                    }
                                }
                            }*/
//Escribir archivo
                            //Nuevamente, usamos un contador para saber cuantos campos tenemos que escribir en el archivo.
                            String archivo = "csv_prueba.csv";
                            int contador = 0;
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {

                                writer.newLine();
                                for (String dato : nuevoInstrumento) {
                                    if (contador == 4) {
                                        writer.write(dato);
                                        Instrumentos instrumentos = new InstrumentoViento(nuevoInstrumento[0], Integer.parseInt(nuevoInstrumento[1]), Integer.parseInt(nuevoInstrumento[2]), nuevoInstrumento[3], nuevoInstrumento[4]);
                                        listaInstrumentos.agregar(instrumentos);
                                        writer.newLine();
                                        return;
                                    }
                                    writer.write(dato + ",");
                                    contador++;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                }//IF gigante todos los instrumentos


    @Override
    public void venderInstrumento(){
        Instrumentos instrumentos;
        StdOut.println("");
        StdOut.println("Ingrese el codigo del instrumento que desea vender:");
        StdOut.println("");
        String codigo=StdIn.readString();
        Instrumentos aux=this.listaInstrumentos.buscarInstrumentoporCodigo(codigo);
        aux.setStock(aux.getStock()-1);
        if (aux==null){
            StdOut.println("El inhstrumento del codigo ingresado no se encuentra disponible o no existe");
            return;
        }

        StdOut.println("///////////////////////////////////////////////////////////////");
        StdOut.println("                    Instrumento vendido                        ");
        StdOut.println("                    "+aux.getNombre()+"                        ");
        StdOut.println("                    $"+aux.getPrecio()+"                        ");
        StdOut.println("///////////////////////////////////////////////////////////////");



    }

    @Override
    public void terminarPrograma(){};

    @Override
    public void consultarInventario() {

        StdOut.println("");
        StdOut.println("////Stock/////");

    }



}//class Impl
