package encounter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        //listas de objetos
        ArrayList<Invitado> guestList = new ArrayList<>();
        ArrayList<Encuentro> encuentrosList = new ArrayList<>();
        ArrayList<Atendiente> atendientesList = new ArrayList<>();
        ArrayList<Evento> eventosList = new ArrayList<>();

        //bucle general
        while (choice != 0) {
        	
            System.out.println("\n///// MENU ADMINISTRADOR GLOBAL /////");
            System.out.println("(1) Invitados");
            System.out.println("(2) Encuentros");
            System.out.println("(3) Atendientes");
            System.out.println("(4) Eventos");
            System.out.println("(0) Salir");
            System.out.print("Seleccione una opción: ");

            //comprobacion de la seleccion correcta de la opcion
            try {
            	
                choice = sc.nextInt();
                sc.nextLine();
                
            } catch (InputMismatchException e) {
            	
                System.err.println("Debe ingresar un número válido");
                sc.nextLine();
                choice = -1;
                
            }

            //ejecutacion de los metodos deseados segun la opcion elegida
            switch (choice) {
                case 1:
                	
                    crudInvitados(sc, guestList);
                    break;
                    
                case 2:
                	
                    crudEncuentros(sc, encuentrosList);
                    break;
                    
                case 3:
                	
                    crudAtendientes(sc, atendientesList);
                    break;
                    
                case 4:
                	
                    crudEventos(sc, eventosList);
                    break;
                    
                case 0:
                	
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                	
                    System.out.println("Opción no válida");
            }
        }

        sc.close();
    }

    //METODOS GENERALES
    
    //PEDIR ENTRADA AL INICIO (VACIA)
    static String pedirEntrada(Scanner sc, String campo) {
    	
        String input = "";
        
        while (input.isEmpty()) {
        	
            System.out.print(campo + ": ");
            
            input = sc.nextLine();
            
            if (input.isEmpty()) {
                System.err.println("El campo '" + campo + "' no puede estar vacío");
            }
        }
        return input;
    }

    //PEDIR ENTRADA EXISTENTE A ACTUALIZAR
    static String pedirEntradaActualizar(Scanner sc, String campo, String valorActual) {
    	
        System.out.print(campo + " (" + valorActual + "): ");
        return sc.nextLine();
    }

    
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    //CRUD INVITADOS
    static void crudInvitados(Scanner sc, ArrayList<Invitado> guestList) {
    	
        int option = -1;
        
        while (option != 0) {
            System.out.println("\n///// MENU ADMIN INVITADOS /////");
            System.out.println("(1) Crear nuevo INVITADO");
            System.out.println("(2) Ver INVITADOS");
            System.out.println("(3) Actualizar INVITADO");
            System.out.println("(4) Eliminar INVITADO");
            System.out.println("(0) Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            //comprobacion de la correcta seleccion del menu
            try {
            	
                option = sc.nextInt();
                sc.nextLine();
                
            } catch (InputMismatchException e) {
            	
                System.err.println("Debe ingresar un número válido");
                
                sc.nextLine();
                option = -1;
            }

            //opciones CRUD
            switch (option) {
                case 1 -> crearInvitado(sc, guestList);
                
                case 2 -> listarInvitados(guestList);
                
                case 3 -> actualizarInvitado(sc, guestList);
                
                case 4 -> eliminarInvitado(sc, guestList);
                
                case 0 -> System.out.println("Volviendo al menú principal...");
                
                default -> System.out.println("Opción no válida");
            }
        }
    }

    //METODOS CRUD INVITADO
    
    //creacion invitado
    static void crearInvitado(Scanner sc, ArrayList<Invitado> guestList) {
    	
        System.out.println("\n--- CREAR INVITADO ---");
        Invitado i = new Invitado(
                pedirEntrada(sc, "Username"),
                pedirEntrada(sc, "Primer apellido"),
                pedirEntrada(sc, "Segundo apellido"),
                pedirEntrada(sc, "Teléfono"),
                pedirEntrada(sc, "Carrera"),
                pedirEntrada(sc, "Email"),
                pedirEntrada(sc, "Password")
        );
        guestList.add(i);
        System.out.println("+ Invitado creado correctamente");
    }
    
    //listado invitados
    static void listarInvitados(ArrayList<Invitado> guestList) {
    	
        if (guestList.isEmpty()) {
        	
            System.out.println("No hay nada que mostrar");
            return;
        } else {
        
        //muestre de todos los invitados
        for (int i = 0; i < guestList.size(); i++) {
        	
            System.out.println((i + 1) + ". " + guestList.get(i));
        }
        
        }
    }

    //actualizacion de invitado
    static void actualizarInvitado(Scanner sc, ArrayList<Invitado> guestList) {
    	
        listarInvitados(guestList);
        
        if (guestList.isEmpty()) return;

        
        System.out.print("Número del invitado a actualizar: ");
        
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        //indice dentro de los elementos existentes
        if (index < 0 || index >= guestList.size()) return;

        
        Invitado i = guestList.get(index);
        String input;
        
        input = pedirEntradaActualizar(sc, "Username", i.getUsername());
        if (!input.isEmpty()) i.setUsername(input);

        input = pedirEntradaActualizar(sc, "Primer apellido", i.getFirstSurname());
        if (!input.isEmpty()) i.setFirstSurname(input);

        input = pedirEntradaActualizar(sc, "Segundo apellido", i.getSecondSurname());
        if (!input.isEmpty()) i.setSecondSurname(input);

        input = pedirEntradaActualizar(sc, "Teléfono", i.getPhoneNumber());
        if (!input.isEmpty()) i.setPhoneNumber(input);

        input = pedirEntradaActualizar(sc, "Carrera", i.getCareer());
        if (!input.isEmpty()) i.setCareer(input);

        input = pedirEntradaActualizar(sc, "Email", i.getMail());
        if (!input.isEmpty()) i.setMail(input);

        input = pedirEntradaActualizar(sc, "Password", i.getPassword());
        if (!input.isEmpty()) i.setPassword(input);

        System.out.println("+ Invitado actualizado correctamente");
    }

    //eliminacion de invitado
    static void eliminarInvitado(Scanner sc, ArrayList<Invitado> guestList) {
    	
        listarInvitados(guestList);
        if (guestList.isEmpty()) return;

        System.out.print("Número del invitado a eliminar: ");
        int index = sc.nextInt() - 1;
        
        sc.nextLine();
        
        //index dentro de los elementos existentes
        if (index < 0 || index >= guestList.size()) return;

        Invitado removed = guestList.remove(index);
        System.out.println(" - Invitado '" + removed.getUsername() + "' eliminado correctamente");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //CRUD ENCUENTROS
    static void crudEncuentros(Scanner sc, ArrayList<Encuentro> list) {
    	
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n///// MENU ADMIN ENCUENTROS /////");
            System.out.println("(1) Crear ENCUENTRO");
            System.out.println("(2) Ver ENCUENTROS");
            System.out.println("(3) Actualizar ENCUENTRO");
            System.out.println("(4) Eliminar ENCUENTRO");
            System.out.println("(0) Volver");
            System.out.print("Seleccione una opción: ");

            //comprobacion de una opcion valida seleccionada
            try {
            	
                choice = sc.nextInt();
                sc.nextLine();
                
            } catch (InputMismatchException e) {
            	
                System.err.println("Debe ingresar un número válido");
                sc.nextLine();
                choice = -1;
            }

            switch (choice) {
            
                case 1 -> crearEncuentro(sc, list);
                case 2 -> listarEncuentros(list);
                case 3 -> actualizarEncuentro(sc, list);
                case 4 -> eliminarEncuentro(sc, list);
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida");
            }
        }
    }

    //creacion encuentro
    static void crearEncuentro(Scanner sc, ArrayList<Encuentro> list) {
    	
        System.out.println("\n--- CREAR ENCUENTRO ---");
        int id = 0;
        
        while (true) {
        	
        	//comprobacion de un ID valido
            try {
                System.out.print("ID: ");
                id = sc.nextInt();
                sc.nextLine();
                break;
                
            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar un número válido para ID");
                sc.nextLine();
            }
        }
        
        Encuentro e = new Encuentro(id, pedirEntrada(sc, "Fecha inicio"), pedirEntrada(sc, "Fecha fin"));
        list.add(e);
        System.out.println("+ Encuentro creado correctamente");
    }

    //ver encuentros
    static void listarEncuentros(ArrayList<Encuentro> list) {
    	
        if (list.isEmpty()) {
            System.out.println("No hay encuentros registrados");
            return;
            
        }
        
        //muestre de todos los eventos
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    //actualizacion de encuentri
    static void actualizarEncuentro(Scanner sc, ArrayList<Encuentro> list) {
    	
        listarEncuentros(list);
        if (list.isEmpty()) return;

        System.out.print("Número del encuentro: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        //comprobacion de que el index exista
        if (index < 0 || index >= list.size()) return;

        Encuentro e = list.get(index);
        String input;
        
        //peticion de datos a rellenar
        input = pedirEntradaActualizar(sc, "ID", String.valueOf(e.getId()));
        if (!input.isEmpty()) e.setId(Integer.parseInt(input));

        input = pedirEntradaActualizar(sc, "Fecha inicio", e.getDateStart());
        if (!input.isEmpty()) e.setDateStart(input);

        input = pedirEntradaActualizar(sc, "Fecha fin", e.getDateEnd());
        if (!input.isEmpty()) e.setDateEnd(input);

        System.out.println("+ Encuentro actualizado correctamente");
    }

    //eliminacion encuentro
    static void eliminarEncuentro(Scanner sc, ArrayList<Encuentro> list) {
    	
        listarEncuentros(list);
        if (list.isEmpty()) return;

        System.out.print("Número del encuentro: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        //comprobacion de index existente
        if (index < 0 || index >= list.size()) return;

        Encuentro removed = list.remove(index);
        System.out.println(" - Encuentro con ID '" + removed.getId() + "' eliminado correctamente");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //CRUD ATENDIENTES
    static void crudAtendientes(Scanner sc, ArrayList<Atendiente> list) {
    	
        int option = -1;
        while (option != 0) {
        	
            System.out.println("\n///// MENU ADMIN ATENDIENTES /////");
            System.out.println("(1) Crear ATENDIENTE");
            System.out.println("(2) Ver ATENDIENTES");
            System.out.println("(3) Actualizar ATENDIENTE");
            System.out.println("(4) Eliminar ATENDIENTE");
            System.out.println("(0) Volver");
            System.out.print("Seleccione una opción: ");

            //comprobacion de la correcta seleccion de la opcion
            try {
            	
                option = sc.nextInt();
                sc.nextLine();
                
            } catch (InputMismatchException e) {
            	
                System.err.println("Debe ingresar un número válido");
                sc.nextLine();
                option = -1;
            }

            //ejecutacion de metodos segun accion deseada
            switch (option) {
            
                case 1 -> crearAtendiente(sc, list);
                case 2 -> listarAtendientes(list);
                case 3 -> actualizarAtendiente(sc, list);
                case 4 -> eliminarAtendiente(sc, list);
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida");
            }
        }
    }

    //creacion de atendiente
    static void crearAtendiente(Scanner sc, ArrayList<Atendiente> list) {
    	
        System.out.println("\n--- CREAR ATENDIENTE ---");
        Atendiente a = new Atendiente(
                pedirEntrada(sc, "DNI"),
                pedirEntrada(sc, "Contraseña"),
                pedirEntrada(sc, "Nombre"),
                pedirEntrada(sc, "Apellidos"),
                pedirEntrada(sc, "Email")
        );
        list.add(a);
        System.out.println("+ Atendiente creado correctamente");
    }

    //visor de atendientes
    static void listarAtendientes(ArrayList<Atendiente> list) {
    	
        if (list.isEmpty()) {
        	
            System.out.println("No hay atendientes registrados");
            return;
        } else {
        
        //lisdtado de todos los atendientes
        for (int i = 0; i < list.size(); i++) {
        	
            System.out.println((i + 1) + ". " + list.get(i));
        }
        }
    }

    //actualizacion atendiente
    static void actualizarAtendiente(Scanner sc, ArrayList<Atendiente> list) {
    	
        listarAtendientes(list);
        
        //imposibilidad de actualizar nada si no existe nada
        if (list.isEmpty()) return;

        System.out.print("Número del atendiente: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        //comprobacion de index existente
        if (index < 0 || index >= list.size()) return;

        Atendiente a = list.get(index);
        String input;

        input = pedirEntradaActualizar(sc, "DNI", a.getDni());
        if (!input.isEmpty()) a.setDni(input);

        input = pedirEntradaActualizar(sc, "Contraseña", a.getContraseña());
        if (!input.isEmpty()) a.setContraseña(input);

        input = pedirEntradaActualizar(sc, "Nombre", a.getNombre());
        if (!input.isEmpty()) a.setNombre(input);

        input = pedirEntradaActualizar(sc, "Apellidos", a.getApellidos());
        if (!input.isEmpty()) a.setApellidos(input);

        input = pedirEntradaActualizar(sc, "Email", a.getEmail());
        if (!input.isEmpty()) a.setEmail(input);

        System.out.println("+ Atendiente actualizado correctamente");
    }

    //eliminacion de antendiente
    static void eliminarAtendiente(Scanner sc, ArrayList<Atendiente> list) {
    	
        listarAtendientes(list);
        
        //imposibilidad de borrar nada si no hay nada
        if (list.isEmpty()) return;

        System.out.print("Número del atendiente: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        //comprobacion de index existente
        if (index < 0 || index >= list.size()) return;

        list.remove(index);
        System.out.println("- Atendiente eliminado correctamente");
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    
    
    //CRUD EVENTOS
    static void crudEventos(Scanner sc, ArrayList<Evento> list) {
    	
        int option = -1;
        while (option != 0) {
        	
            System.out.println("\n///// MENU ADMIN EVENTOS /////");
            System.out.println("(1) Crear EVENTO");
            System.out.println("(2) Ver EVENTOS");
            System.out.println("(3) Actualizar EVENTO");
            System.out.println("(4) Eliminar EVENTO");
            System.out.println("(0) Volver");
            System.out.print("Seleccione una opción: ");

            //comprobacion de que la opcion elegida existe y es valida
            try {
            	
                option = sc.nextInt();
                sc.nextLine();
                
            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar un número válido");
                sc.nextLine();
                option = -1;
            }

            //ejecutacion de metodos segun accion deseada
            switch (option) {
            
                case 1 -> crearEvento(sc, list);
                case 2 -> listarEventos(list);
                case 3 -> actualizarEvento(sc, list);
                case 4 -> eliminarEvento(sc, list);
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida");
            }
        }
    }

    //creaccion evento
    static void crearEvento(Scanner sc, ArrayList<Evento> list) {
    	
        System.out.println("\n--- CREAR EVENTO ---");
        Evento e = new Evento(
                pedirEntrada(sc, "ID"),
                pedirEntrada(sc, "Título"),
                pedirEntrada(sc, "Tipo de evento"),
                pedirEntrada(sc, "Código Encuentro")
        );
        
        e.setUbicacion(pedirEntrada(sc, "Ubicación"));
        e.setFechaInicio(pedirEntrada(sc, "Fecha inicio"));
        e.setFechaFin(pedirEntrada(sc, "Fecha fin"));
        e.setHorarioInicio(pedirEntrada(sc, "Hora inicio"));
        e.setHorarioFin(pedirEntrada(sc, "Hora fin"));
        e.setDescripcion(pedirEntrada(sc, "Descripción"));
        
        list.add(e);
        System.out.println("+ Evento creado correctamente");
    }

    //vision de todos los eventos
    static void listarEventos(ArrayList<Evento> list) {
    	
        if (list.isEmpty()) {
        	
            System.out.println("No hay eventos registrados");
            return;
            
        } else {
        
        //vision de todos los eventos
        for (int i = 0; i < list.size(); i++) {
        	
            System.out.println((i + 1) + ".\n" + list.get(i));
            
        }
        }
    }

    //actualizacion de eventos
    static void actualizarEvento(Scanner sc, ArrayList<Evento> list) {
    	
        listarEventos(list);
        
        //imposibilidad de actualizar nada si no exiete nada
        if (list.isEmpty()) return;

        System.out.print("Número del evento: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        //comprobacion de index existente
        if (index < 0 || index >= list.size()) return;

        Evento e = list.get(index);
        String input;

        input = pedirEntradaActualizar(sc, "ID", String.valueOf(e.getId()));
        if (!input.isEmpty()) e.setId(input);

        input = pedirEntradaActualizar(sc, "Título", e.getTitulo());
        if (!input.isEmpty()) e.setTitulo(input);

        input = pedirEntradaActualizar(sc, "Tipo evento", e.getTipoEvento());
        if (!input.isEmpty()) e.setTipoEvento(input);

        input = pedirEntradaActualizar(sc, "Código Encuentro", e.getCodigoEncuentro());
        if (!input.isEmpty()) e.setCodigoEncuentro(input);

        input = pedirEntradaActualizar(sc, "Ubicación", e.getUbicacion());
        if (!input.isEmpty()) e.setUbicacion(input);

        input = pedirEntradaActualizar(sc, "Fecha inicio", e.getFechaInicio());
        if (!input.isEmpty()) e.setFechaInicio(input);

        input = pedirEntradaActualizar(sc, "Fecha fin", e.getFechaFin());
        if (!input.isEmpty()) e.setFechaFin(input);

        input = pedirEntradaActualizar(sc, "Horario inicio", e.getHorarioInicio());
        if (!input.isEmpty()) e.setHorarioInicio(input);

        input = pedirEntradaActualizar(sc, "Horario fin", e.getHorarioFin());
        if (!input.isEmpty()) e.setHorarioFin(input);

        input = pedirEntradaActualizar(sc, "Descripción", e.getDescripcion());
        if (!input.isEmpty()) e.setDescripcion(input);

        System.out.println("+ Evento actualizado correctamente");
    }

    //eliminacion de evento
    static void eliminarEvento(Scanner sc, ArrayList<Evento> list) {
    	
        listarEventos(list);
        
        //imposibilidad de borra nada si no existe nada
        if (list.isEmpty()) return;

        System.out.print("Número del evento: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        //comprobacion index existente
        if (index < 0 || index >= list.size()) return;

        list.remove(index);
        System.out.println("- Evento eliminado correctamente");
    }
}
