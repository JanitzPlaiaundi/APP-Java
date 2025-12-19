package encounter;

public class Main {

    public static void main(String[] args) {

        // Crear un Encuentro
        Encuentro encuentro = new Encuentro(
                1,
                "2025-12-01 10:00",
                "2025-12-01 12:00"
        );

        // Crear un Invitado
        Invitado invitado = new Invitado(
                "jdoe",
                "Jordi",
                "Hurtado",
                "913464000",
                "Saber y ganar",
                "jurtado@gmail.com",
                "losMAGNIFICOS"
        );
        
        Encuentro encuentro2 = new Encuentro();
		encuentro2.setId(1);
        
        // Mostrar objetos
        System.out.println(encuentro);
        System.out.println(invitado);
    }
}
