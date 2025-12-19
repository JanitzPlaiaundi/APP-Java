package encounter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = -1;

        ArrayList<Invitado> guestList = new ArrayList<>();
        ArrayList<Encuentro> encuentrosList = new ArrayList<>();

        while (choice != 0) {

            System.out.println("///// MENU ADMINISTRADOR GLOBAL /////");
            System.out.println("(1) Invitados");
            System.out.println("(2) Encuentros");
            System.out.println("(0) Salir");
            System.out.print("Seleccione una opción: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // limpiar buffer
            } catch (InputMismatchException e) {
                // Si el usuario ingresa un valor que no es número, mostramos error y reiniciamos la opción
                System.err.println("Debe ingresar un número válido");
                sc.nextLine(); // limpiar buffer
                choice = -1;
            }

            // ELECCIÓN DEL MENÚ PRINCIPAL
            switch (choice) {
                case 1:
                    crudInvitados(sc, guestList);
                    break;
                case 2:
                    crudEncuentros(sc, encuentrosList);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    // Si la opción ingresada no corresponde a ningún caso
                    System.out.println("Opción no válida");
            }
        }

        sc.close();
    }

    //CRUD INVITADOS
    static void crudInvitados(Scanner sc, ArrayList<Invitado> guestList) {

        int crudChoice = -1;

        while (crudChoice != 0) {

            System.out.println("\n///// MENU ADMIN INVITADOS /////");

            System.out.println("(1) Crear nuevo INVITADO");
            System.out.println("(2) Ver INVITADOS");
            System.out.println("(3) Actualizar INVITADO");
            System.out.println("(4) Eliminar INVITADO");

            System.out.println("(0) Volver al menú principal");

            System.out.print("Seleccione una opción: ");

            try {
                crudChoice = sc.nextInt();
                sc.nextLine(); // limpiar buffer

            } catch (InputMismatchException e) {
                // Captura si el usuario no ingresa un número
                System.err.println("Debe ingresar un número válido");
                sc.nextLine(); // limpiar buffer
                crudChoice = -1;
            }

            //seleccion de accion

            switch (crudChoice) {
                case 1:
                    crearInvitado(sc, guestList);
                    break;

                case 2:
                    listarInvitados(guestList);
                    break;

                case 3:
                    actualizarInvitado(sc, guestList);
                    break;

                case 4:
                    eliminarInvitado(sc, guestList);
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    // Si la opción ingresada no corresponde a ningún caso
                    System.out.println("Opción no válida");
            }
        }
    }

    //CREAR INVITADO CON VALIDACIÓN
    static void crearInvitado(Scanner sc, ArrayList<Invitado> guestList) {

        System.out.println("\n--- CREAR INVITADO ---");

        String username = pedirEntrada(sc, "Username");
        String firstSurname = pedirEntrada(sc, "Primer apellido");
        String secondSurname = pedirEntrada(sc, "Segundo apellido");
        String phoneNumber = pedirEntrada(sc, "Teléfono");
        String career = pedirEntrada(sc, "Carrera");
        String mail = pedirEntrada(sc, "Email");
        String password = pedirEntrada(sc, "Password");

        Invitado invitado = new Invitado(
                username,
                firstSurname,
                secondSurname,
                phoneNumber,
                career,
                mail,
                password
        );

        guestList.add(invitado);

        System.out.println("✅ Invitado creado correctamente");
    }

    //MÉTODO GENERAL PARA PEDIR ENTRADA CON VALIDACIÓN
    static String pedirEntrada(Scanner sc, String campo) {

        String input = "";

        while (input.isEmpty()) {

            try {
                System.out.print(campo + ": ");
                input = sc.nextLine();

                // VERIFICAMOS SI EL CAMPO ESTÁ VACÍO
                if (input.isEmpty()) {
                    System.err.println("El campo '" + campo + "' no puede estar vacío");
                }

            } catch (Exception e) {
                // Captura cualquier error de entrada de datos
                System.err.println("Error al ingresar " + campo + ", intente nuevamente");
                sc.nextLine(); // limpiar buffer
            }

        }
        return input;
    }

    //LISTAR INVITADOS
    static void listarInvitados(ArrayList<Invitado> guestList) {

        System.out.println("\n--- LISTA DE INVITADOS ---");

        // SI NO HAY INVITADOS, MOSTRAMOS MENSAJE
        if (guestList.isEmpty()) {
            System.out.println("No hay invitados registrados");
            return;
        }

        for (int i = 0; i < guestList.size(); i++) {
            System.out.println((i + 1) + ". " + guestList.get(i));
        }
    }

    //ACTUALIZAR INVITADO CON VALIDACIÓN
    static void actualizarInvitado(Scanner sc, ArrayList<Invitado> guestList) {

        listarInvitados(guestList);

        // SI LA LISTA ESTÁ VACÍA, RETORNAMOS
        if (guestList.isEmpty()) {
            return;
        }

        System.out.print("\nIngrese el número del invitado a actualizar: ");

        int index;

        try {
            index = sc.nextInt() - 1;
            sc.nextLine();

        } catch (InputMismatchException e) {
            // Captura si el input no es un número
            System.err.println("Debe ingresar un número válido");
            sc.nextLine();
            return;
        }

        // COMPROBACIÓN DE INDICE EXISTENTE
        if (index < 0 || index >= guestList.size()) {
            System.out.println("Número de invitado inválido");
            return;
        }

        // OBTENER OBJETO
        Invitado invitado = guestList.get(index);

        System.out.println("Dejar vacío para mantener el valor actual");

        //ACTUALIZACION DE VALORES
        
        //SI NO ESTÁ VACÍO, ACTUALIZAMOS
        String input = pedirEntradaActualizar(sc, "Username", invitado.getUsername());
        if (!input.isEmpty()) invitado.setUsername(input);

        input = pedirEntradaActualizar(sc, "Primer apellido", invitado.getFirstSurname());
        if (!input.isEmpty()) invitado.setFirstSurname(input);

        input = pedirEntradaActualizar(sc, "Segundo apellido", invitado.getSecondSurname());
        if (!input.isEmpty()) invitado.setSecondSurname(input);

        input = pedirEntradaActualizar(sc, "Teléfono", invitado.getPhoneNumber());
        if (!input.isEmpty()) invitado.setPhoneNumber(input);

        input = pedirEntradaActualizar(sc, "Carrera", invitado.getCareer());
        if (!input.isEmpty()) invitado.setCareer(input);

        input = pedirEntradaActualizar(sc, "Email", invitado.getMail());
        if (!input.isEmpty()) invitado.setMail(input);

        input = pedirEntradaActualizar(sc, "Password", invitado.getPassword());
        if (!input.isEmpty()) invitado.setPassword(input);

        System.out.println("✅ Invitado actualizado correctamente");
    }

    //MÉTODO PARA ACTUALIZAR CAMPOS
    static String pedirEntradaActualizar(Scanner sc, String campo, String valorActual) {

        String input = "";

        while (true) {

            try {
                System.out.print(campo + " (" + valorActual + "): ");
                input = sc.nextLine();
                break; // SE ROMPE EL BUCLE AUNQUE ESTÉ VACÍO

            } catch (Exception e) {
                // Captura cualquier error de entrada
                System.err.println("Error al ingresar " + campo + ", intente nuevamente");
                sc.nextLine();
            }
        }
        return input;
    }

    //ELIMINAR INVITADO
    static void eliminarInvitado(Scanner sc, ArrayList<Invitado> guestList) {

        listarInvitados(guestList);

        // SI LA LISTA ESTÁ VACÍA, RETORNAMOS
        if (guestList.isEmpty()) return;

        System.out.print("\nIngrese el número del invitado a eliminar: ");
        int index;

        try {
            index = sc.nextInt() - 1;
            sc.nextLine();

        } catch (InputMismatchException e) {
            // Captura si el input no es número
            System.err.println("Debe ingresar un número válido");
            sc.nextLine();
            return;
        }

        // INDICE FUERA DE LONGITUD DE LISTA
        if (index < 0 || index >= guestList.size()) {
            System.out.println("Número de invitado inválido");
            return;
        }

        Invitado removed = guestList.remove(index);
        System.out.println("❌ Invitado '" + removed.getUsername() + "' eliminado correctamente");
    }

    //=================== CRUD ENCUENTROS ===================
    static void crudEncuentros(Scanner sc, ArrayList<Encuentro> encuentrosList) {

        int crudChoice = -1;

        while (crudChoice != 0) {

            System.out.println("\n///// MENU ADMIN ENCUENTROS /////");
            System.out.println("(1) Crear nuevo ENCUENTRO");
            System.out.println("(2) Ver ENCUENTROS");
            System.out.println("(3) Actualizar ENCUENTRO");
            System.out.println("(4) Eliminar ENCUENTRO");
            System.out.println("(0) Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                crudChoice = sc.nextInt();
                sc.nextLine(); // limpiar buffer
            } catch (InputMismatchException e) {
                // Captura si el input no es número
                System.err.println("Debe ingresar un número válido");
                sc.nextLine();
                crudChoice = -1;
            }

            switch (crudChoice) {
                case 1:
                    crearEncuentro(sc, encuentrosList);
                    break;
                case 2:
                    listarEncuentros(encuentrosList);
                    break;
                case 3:
                    actualizarEncuentro(sc, encuentrosList);
                    break;
                case 4:
                    eliminarEncuentro(sc, encuentrosList);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida");
            }
        }
    }

    //CREAR ENCUENTRO CON VALIDACIÓN
    static void crearEncuentro(Scanner sc, ArrayList<Encuentro> encuentrosList) {

        System.out.println("\n--- CREAR ENCUENTRO ---");

        int id = 0;
        while (true) {
            try {
                System.out.print("ID: ");
                id = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                // Captura si ID no es número
                System.err.println("Debe ingresar un número válido para ID");
                sc.nextLine();
            }
        }

        String dateStart = pedirEntrada(sc, "Fecha de inicio");
        String dateEnd = pedirEntrada(sc, "Fecha de fin");

        Encuentro e = new Encuentro(id, dateStart, dateEnd);
        encuentrosList.add(e);

        System.out.println("✅ Encuentro creado correctamente");
    }

    //LISTAR ENCUENTROS
    static void listarEncuentros(ArrayList<Encuentro> encuentrosList) {

        System.out.println("\n--- LISTA DE ENCUENTROS ---");

        // SI LA LISTA ESTÁ VACÍA, MOSTRAMOS MENSAJE
        if (encuentrosList.isEmpty()) {
            System.out.println("No hay encuentros registrados");
            return;
        }

        for (int i = 0; i < encuentrosList.size(); i++) {
            System.out.println((i + 1) + ". " + encuentrosList.get(i));
        }
    }

    //ACTUALIZAR ENCUENTRO CON VALIDACIÓN
    static void actualizarEncuentro(Scanner sc, ArrayList<Encuentro> encuentrosList) {

        listarEncuentros(encuentrosList);

        // SI LA LISTA ESTÁ VACÍA, RETORNAMOS
        if (encuentrosList.isEmpty()) return;

        System.out.print("\nIngrese el número del encuentro a actualizar: ");
        int index;
        try {
            index = sc.nextInt() - 1;
            sc.nextLine();
        } catch (InputMismatchException e) {
            // Captura si input no es número
            System.err.println("Debe ingresar un número válido");
            sc.nextLine();
            return;
        }

        // COMPROBACIÓN DE INDICE EXISTENTE
        if (index < 0 || index >= encuentrosList.size()) {
            System.out.println("Número de encuentro inválido");
            return;
        }

        Encuentro e = encuentrosList.get(index);

        System.out.println("Dejar vacío para mantener el valor actual");

        String input;
        input = pedirEntradaActualizar(sc, "ID", String.valueOf(e.getId()));
        if (!input.isEmpty()) e.setId(Integer.parseInt(input)); // ACTUALIZAMOS SI NO ESTÁ VACÍO

        input = pedirEntradaActualizar(sc, "Fecha de inicio", e.getDateStart());
        if (!input.isEmpty()) e.setDateStart(input);

        input = pedirEntradaActualizar(sc, "Fecha de fin", e.getDateEnd());
        if (!input.isEmpty()) e.setDateEnd(input);

        System.out.println("✅ Encuentro actualizado correctamente");
    }

    //ELIMINAR ENCUENTRO
    static void eliminarEncuentro(Scanner sc, ArrayList<Encuentro> encuentrosList) {

        listarEncuentros(encuentrosList);

        // SI LA LISTA ESTÁ VACÍA, RETORNAMOS
        if (encuentrosList.isEmpty()) return;

        System.out.print("\nIngrese el número del encuentro a eliminar: ");
        int index;
        try {
            index = sc.nextInt() - 1;
            sc.nextLine();
        } catch (InputMismatchException e) {
            // Captura si input no es número
            System.err.println("Debe ingresar un número válido");
            sc.nextLine();
            return;
        }

        // INDICE FUERA DE LONGITUD DE LISTA
        if (index < 0 || index >= encuentrosList.size()) {
            System.out.println("Número de encuentro inválido");
            return;
        }

        Encuentro removed = encuentrosList.remove(index);
        System.out.println("❌ Encuentro con ID '" + removed.getId() + "' eliminado correctamente");
    }
}