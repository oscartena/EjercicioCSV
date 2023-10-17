package org.ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class OperacionesCSV {

    public static List<Funko> listaFunkos(List<List<String>> csv){
        return csv.stream().map(parametros -> new Funko(parametros.get(0), parametros.get(1), parametros.get(2), Double.parseDouble(parametros.get(3)), parametros.get(4)))
                .collect(Collectors.toList());
    }

    public static Funko funkoMasCaro(List<Funko> lista){
        return lista.stream()
                .max(Comparator.comparingDouble(Funko::precio)).get();
    }

    public static double mediaPrecios(List<Funko> lista){
        return lista.stream().collect(averagingDouble(f -> f.precio()));
    }

    public static Map<String, List<Funko>> agruparFunkosModelo(List<Funko> lista){
        return lista.stream().collect(groupingBy(Funko::modelo));
    }

    public static Map<String, Long> contarPorModelo(List<Funko> lista){
        return lista.stream().collect(groupingBy(Funko::modelo, Collectors.counting()));
    }

    public static List<Funko> funkos2023(List<Funko> lista){
        return lista.stream().filter(f -> f.fecha().startsWith("2023")).toList();
    }
    public static void backup(List<Funko> lista){
        try {
            FileOutputStream archivoSalida = new FileOutputStream("funkos.dat");
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);

            objetoSalida.writeObject(lista);

            objetoSalida.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void restore(){
        try {
            FileInputStream archivoEntrada = new FileInputStream("funkos.dat");

            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);

            List<Funko> listaFunkos = (List<Funko>) objetoEntrada.readObject();

            listaFunkos.stream().forEach(System.out::println);

            objetoEntrada.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
