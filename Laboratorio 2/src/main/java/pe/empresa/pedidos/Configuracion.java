package pe.empresa.pedidos;

import java.io.InputStream;
import java.util.Properties;

// Lee los valores que cambian por entorno desde application.properties (sin recompilar).
public class Configuracion {
    private final Properties props = new Properties();

    public Configuracion() throws Exception {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            props.load(in);
        }
    }

    public String getString(String clave) {
        return props.getProperty(clave);
    }

    public double getDouble(String clave) {
        return Double.parseDouble(props.getProperty(clave));
    }
}
