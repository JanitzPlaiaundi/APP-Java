//13/02/2026 12:10
package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ChecksEntradaSalida {

    static Scanner sc = new Scanner(System.in);

    public int leerEntero(int minimo, int maximo) {
        int numero;
        while (true) {
            try {
                numero = sc.nextInt();
                if (numero < minimo || numero > maximo) {
                    throw new IllegalArgumentException(
                            "El numero no es valido, recuerda que debe de ser entre " + minimo + " y " + maximo);
                }
                sc.nextLine(); // Limpiar buffer
                return numero;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Por favor inserte un numero");
                sc.nextLine(); // Limpiar buffer en caso de error de tipo
            }
        }
    }


    public String leerString(String mensaje, int longitudMax) {
        String texto = "";
        while (true) {
            try {
                System.out.print(mensaje);
                texto = sc.nextLine();

                if (!texto.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ 0-9]+")) {
                    throw new Exception("No puede estar vacío o llevar caracteres especiales");
                }

                if (texto.length() > longitudMax) {
                    throw new Exception("Se ha excedido la longitud máxima de: " + longitudMax);
                }

                return texto;
            } catch (Exception e) {
                System.out.println("Entrada no válida: " + e.getMessage());
            }
        }
    }

    public LocalDate leerFecha(String mensaje, String formatoPatron) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoPatron);
        LocalDate fecha = null;
        boolean valida = false;

        do {
            try {
                String fechaTexto = leerString(mensaje + " (" + formatoPatron + "): ", 10);
                fecha = LocalDate.parse(fechaTexto, formatter);
                valida = true;
            } catch (DateTimeParseException e) {
                System.out.println("La fecha no es válida o no respeta el formato " + formatoPatron);
            }
        } while (!valida);
        return fecha;
    }

    public LocalTime leerHora(String mensaje, String formatoPatron) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoPatron);
        LocalTime hora = null;
        boolean valida = false;

        do {
            try {

                String horaTexto = leerString(mensaje + " (" + formatoPatron + "): ", 8);
                hora = LocalTime.parse(horaTexto, formatter);
                valida = true;
            } catch (DateTimeParseException e) {
                System.out.println("La hora no es válida o no respeta el formato " + formatoPatron);
            }
        } while (!valida);
        return hora;
    }
    
    public String leerEmail(String mensaje, int longitudMax) {
        String texto = "";
        while (true) {
            try {
                System.out.print(mensaje);
                texto = sc.nextLine();

                if (!texto.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    throw new Exception("No puede estar vacío o llevar caracteres especiales");
                }

                if (texto.length() > longitudMax) {
                    throw new Exception("Se ha excedido la longitud máxima de: " + longitudMax);
                }

                return texto;
            } catch (Exception e) {
                System.out.println("Entrada no válida: " + e.getMessage());
            }
        }
    }
}