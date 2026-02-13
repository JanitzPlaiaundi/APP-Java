//11/02/2026 14:02
package model;
import java.time.LocalDate;
import java.time.LocalTime;
public class MesaRedonda extends Evento {
   private int nConferencia;
   private static int conferenciasCreadas;
   //CONSTRUCTORES
   public MesaRedonda() {
       super();
       conferenciasCreadas++;
   }
   public MesaRedonda(String titulo, String ubicacion, String descripcion, LocalDate fIni, LocalDate fFin,
           LocalTime hIni, LocalTime hFin, String codigo, int nConferencia) {
       super(titulo, ubicacion, descripcion, fIni, fFin, hIni, hFin, codigo);
       this.nConferencia = nConferencia;
       conferenciasCreadas++;
   }
   //GETTERS
   public int getnConferencia() {
       return nConferencia;
   }
   public void setnConferencia(int nConferencia) {
       this.nConferencia = nConferencia;
   }
   public static int getConferenciasCreadas() {
       return conferenciasCreadas;
   }
  
   //TOSTRING
   @Override
   public String toString() {
       return super.toString() + "\n Nº Conferencia: '" + this.getnConferencia() + '\'';
   };
}



