package util;

public class Validador {

    public static boolean correoValido(String correo) {
        return correo.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
