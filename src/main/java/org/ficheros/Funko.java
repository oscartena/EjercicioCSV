package org.ficheros;

import java.io.Serializable;

public record Funko (String cod, String nombre, String modelo, double precio, String fecha) implements Serializable {

    @Override
    public String toString(){
        return "Funko{codigo:"+cod+"}{nombre:"+nombre+"}{modelo:"+modelo+"}{precio:"+precio+"€}{fecha:"+fecha+"}";
    }

}
