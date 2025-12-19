public class Evento {

    // =======================
    // ATRIBUTOS
    // =======================
    private int id;                // Identificador único del evento
    private String titulo;            // Título del evento
    private String ubicacion;         // Ubicación donde se realiza el evento
    private String descripcion;       // Descripción del evento
    private String fechaInicio;       // Fecha de inicio del evento
    private String fechaFin;          // Fecha de finalización del evento
    private String horarioInicio;     // Hora de inicio del evento
    private String horarioFin;        // Hora de finalización del evento
    private String codigoEncuentro;   // Código del encuentro al que pertenece el evento
    private String tipoEvento;        // Tipo de evento (ej. Presentación, Taller)

    // =======================
    // CONSTRUCTORES
    // =======================
    public Evento() {}  // Constructor vacío

    public Evento(String id, String titulo, String tipoEvento, String codigoEncuentro) 
    {
        // Constructor que inicializa algunos atributos y los convierte a mayúsculas
        setId(id);
        this.titulo = titulo.toUpperCase();
        this.tipoEvento = tipoEvento.toUpperCase();
        this.codigoEncuentro = codigoEncuentro.toUpperCase();
    }

    // =======================
    // SETTERS
    // =======================
    public void setId(String idStr) 
    {
        try {
            int idNum = Integer.parseInt(idStr);  // Convertir String a int
            this.id = idNum;  // Guardar el ID
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("ID solo puede contener números");
        }
    }
    
    public void setTitulo(String titulo) 
    {
        this.titulo = titulo.toUpperCase();  // Convierte el título a mayúsculas
    }
    
    public void setUbicacion(String ubicacion) 
    {
        this.ubicacion = ubicacion.toUpperCase();  // Convierte la ubicación a mayúsculas
    }
    
    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion.toUpperCase();  // Convierte la descripción a mayúsculas
    }
    
    public void setFechaInicio(String fechaInicio) 
    {
        this.fechaInicio = fechaInicio;  // Guarda la fecha de inicio
    }
    
    public void setFechaFin(String fechaFin) 
    {
        this.fechaFin = fechaFin;  // Guarda la fecha de fin
    }
    
    public void setHorarioInicio(String horarioInicio) 
    {
        this.horarioInicio = horarioInicio;  // Guarda el horario de inicio
    }
    
    public void setHorarioFin(String horarioFin) 
    {
        this.horarioFin = horarioFin;  // Guarda el horario de fin
    }
    
    public void setCodigoEncuentro(String codigoEncuentro) 
    {
        this.codigoEncuentro = codigoEncuentro.toUpperCase();  // Convierte a mayúsculas
    }
    
    public void setTipoEvento(String tipoEvento) 
    {
        this.tipoEvento = tipoEvento.toUpperCase();  // Convierte a mayúsculas
    }

    // =======================
    // GETTERS
    // =======================
    public int getId() 
    {
        return id;  // Devuelve el ID
    }
    
    public String getTitulo() 
    { 
        return titulo;  // Devuelve el título
    }
    
    public String getUbicacion() 
    {
        return ubicacion;  // Devuelve la ubicación
    }
    
    public String getDescripcion() 
    {
        return descripcion;  // Devuelve la descripción
    }
    
    public String getFechaInicio() 
    {
        return fechaInicio;  // Devuelve la fecha de inicio
    }
    
    public String getFechaFin() 
    {
        return fechaFin;  // Devuelve la fecha de fin
    }
    
    public String getHorarioInicio() 
    {
        return horarioInicio;  // Devuelve el horario de inicio
    }
    
    public String getHorarioFin() 
    {
        return horarioFin;  // Devuelve el horario de fin
    }
    
    public String getCodigoEncuentro() 
    {
        return codigoEncuentro;  // Devuelve el código del encuentro
    }
    
    public String getTipoEvento() 
    {
        return tipoEvento;  // Devuelve el tipo de evento
    }
    

    // =======================
    // TO STRING
    // =======================
    @Override
    public String toString() 
    {
        // Devuelve todos los datos del evento en formato legible
        return "EVENTO {" +
                "\n  ID = '" + this.id + '\'' +
                "\n  TÍTULO = '" + this.titulo + '\'' +
                "\n  TIPO = '" + this.tipoEvento + '\'' +
                "\n  UBICACIÓN = '" + this.ubicacion + '\'' +
                "\n  FECHA INICIO = '" + this.fechaInicio + '\'' +
                "\n  FECHA FIN = '" + this.fechaFin + '\'' +
                "\n  HORARIO = " + this.horarioInicio + " - " + horarioFin +
                "\n  ENCUENTRO = '" + this.codigoEncuentro + '\'' +
                "\n  DESCRIPCIÓN = '" + this.descripcion + '\'' +
                "\n}";
    }    
}