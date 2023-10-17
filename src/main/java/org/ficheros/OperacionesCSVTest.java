package org.ficheros;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OperacionesCSVTest {
    private static List<Funko> lista;

    @BeforeAll
    public static void crearLista(){
        lista = new ArrayList<>();
        lista.add(new Funko("1", "a", "y", 5, "2020"));
        lista.add(new Funko("2", "b", "y", 15, "2019"));
        lista.add(new Funko("3", "c", "z", 10, "2023"));
    }


    @Test
    void funkoMasCaro() {
        Funko resultado = OperacionesCSV.funkoMasCaro(lista);
        assertEquals(lista.get(1),resultado);
    }

    @Test
    void mediaPrecios() {
        double resultado = OperacionesCSV.mediaPrecios(lista);
        assertEquals(10,resultado);
    }

    @Test
    void agruparFunkosModelo() {
        Map<String, List<Funko>> resultado = OperacionesCSV.agruparFunkosModelo(lista);
        assertEquals(2,resultado.get("y").size());
        assertEquals(1,resultado.get("z").size());
    }

    @Test
    void contarPorModelo() {
        Map<String, Long> resultado = OperacionesCSV.contarPorModelo(lista);
        assertEquals(2,resultado.get("y").longValue());
        assertEquals(1,resultado.get("z").longValue());
    }

    @Test
    void funkos2023() {
        List<Funko> resultado = OperacionesCSV.funkos2023(lista);
        assertEquals(1,resultado.size());
    }
}