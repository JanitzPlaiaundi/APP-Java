//13/02/2026 10:32
package model;
import java.time.LocalDate;
import java.time.LocalTime;
public class PresentacionProyecto extends Evento {
   private String tipoProyecto;
   private String descripcionProyecto;
   private static int presentacionesCreadas;
   public PresentacionProyecto() {
       super();
       presentacionesCreadas++;
   }
   public PresentacionProyecto(String titulo, String ubicacion, String descripcion, LocalDate fIni, LocalDate fFin,
           LocalTime hIni, LocalTime hFin, String codigo, String tipoProyecto, String descripcionProyecto) {
       super(titulo, ubicacion, descripcion, fIni, fFin, hIni, hFin, codigo);
       this.tipoProyecto = tipoProyecto;
       this.descripcionProyecto = descripcionProyecto;
       presentacionesCreadas++;
   }
   public String getTipoProyecto() {
       return tipoProyecto;
   }
   public void setTipoProyecto(String tipoProyecto) {
       this.tipoProyecto = tipoProyecto;
   }
  
   public String getDescripcionProyecto() {
       return descripcionProyecto;
   }
   public void setDescripcionProyecto(String descripcionProyecto) {
       this.descripcionProyecto = descripcionProyecto;
   }
   public static int getPresentacionesCreadas() {
       return presentacionesCreadas;
   }
   @Override
   public String toString() {
       return super.toString() + "\n  Tipo proyecto: '" + this.getTipoProyecto() + '\'' + "\n  Descripcion proyecto: '" + this.getDescripcionProyecto() + '\'';
   };
}



