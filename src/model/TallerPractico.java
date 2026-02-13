//13/02/2026 10:33
package model;

import java.time.LocalDate;
import java.time.LocalTime;


public class TallerPractico extends Evento {
    private int nTaller;
    private static int talleresPracticosCreados;

    public TallerPractico() {
        super();
        talleresPracticosCreados++;
    }

    public TallerPractico(String titulo, String ubicacion, String descripcion, LocalDate fIni, LocalDate fFin,
            LocalTime hIni, LocalTime hFin, String codigo, int nTaller) {
        super(titulo, ubicacion, descripcion, fIni, fFin, hIni, hFin, codigo);
        this.nTaller = nTaller;
        talleresPracticosCreados++;
    }

    public int getnTaller() {
        return nTaller;
    }

    public void setnTaller(int nTaller) {
        this.nTaller = nTaller;
    }

    public static int getTalleresPracticosCreados() {
        return talleresPracticosCreados;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n  Nº taller: '" + this.getnTaller() + '\'';
    };
}


