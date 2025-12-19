package encounter;

public class Encuentro {
	
	private String dateStart;
	private String dateEnd;
	private int id;
	
	
	
	// Constructores
    public Encuentro(int id, String dateStart, String dateEnd) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    
    public Encuentro () {}
    
    // Getters
    public int getId() {
    	return this.id;
    }
    
    public String getDateStart() {
    	return this.dateStart;
    }
    
    public String getDateEnd() {
    	return this.dateEnd;
    }
    
    // Setters
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setDateStart(String dateStart) {
    	this.dateStart = dateStart;
    }
    
    public void setDateEnd(String dateEnd) {
    	this.dateEnd = dateEnd;
    }
    
    // To String
    @Override
    public String toString() {
        return "Encuentro{" +
                "id=" + id +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                '}';
    }

}