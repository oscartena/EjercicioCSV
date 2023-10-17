package org.ficheros;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Ejercicio2 {


    public static void main(String[] args) throws IOException {
        List<List<String>> csv = Files.lines(Paths.get("/home/oscmar/Escritorio/AccesoDatos-2023-2024-main/UD02-Ficheros/01-ManejoFicheros/src/main/resources/funkos.csv")).skip(1)
                .map(linea -> Arrays.asList(linea.split(",")))
                .toList();

        List<Funko> funkos = OperacionesCSV.listaFunkos(csv);

        Funko funkoCaro = OperacionesCSV.funkoMasCaro(funkos);

        double precio = OperacionesCSV.mediaPrecios(funkos);
        System.out.println("La media de precios de los funkos es "+String.format("%.2f",precio));

        Map<String, List<Funko>> funkosModelo = OperacionesCSV.agruparFunkosModelo(funkos);

        /*funkosModelo.forEach((modelo, funks) -> {
            System.out.println("MODELO: " + modelo);
            funks.forEach(f -> {
                System.out.println(f.nombre());
            });
            System.out.println();
        });*/


        //List<Funko> funkos2023 = OperacionesCSV.funkos2023(funkos);
        //funkos2023.forEach(funko -> System.out.println(funko.nombre()));

        OperacionesCSV.backup(funkos);

        OperacionesCSV.restore();

    }



}

