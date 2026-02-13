//13/02/2026 12:10
package model;
import java.time.LocalDate;
import java.time.LocalTime;
public class ConferenciaMagistral extends Evento {
	
   private String tipoConferencia;
   private static int conferenciasCreadas;
   public ConferenciaMagistral() {
       super();
       conferenciasCreadas++;
   }
   public ConferenciaMagistral(String titulo, String ubicacion, String descripcion, LocalDate fIni, LocalDate fFin,
           LocalTime hIni, LocalTime hFin, String codigo, String tipoConferencia) {
       super(titulo, ubicacion, descripcion, fIni, fFin, hIni, hFin, codigo);
       this.tipoConferencia = tipoConferencia;
       conferenciasCreadas++;
   }
   //GETTERS
   public String getTipoConferencia() {
       return tipoConferencia;
   }
   public static int getConferenciasCreadas() {
       return conferenciasCreadas;
   }
  
   //SETTERS
   public void setTipoConferencia(String tipoConferencia) {
       this.tipoConferencia = tipoConferencia;
   }
   //TOSTRING
   @Override
   public String toString() {
       return super.toString() + "\n Tipo conferencia: '" + this.getTipoConferencia() + '\'';
   };
}



