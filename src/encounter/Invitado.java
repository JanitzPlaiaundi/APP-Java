package encounter;

public class Invitado {
	
	private String username, firstSurname, secondSurname;
	private String phoneNumber;
	private String career;
	private String mail, password;
	
	
	// Constructor
    public Invitado(String username, String firstSurname, String secondSurname, String phoneNumber, String career, String mail, String password) {
        this.username = username;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.phoneNumber = phoneNumber;
        this.career = career;
        this.mail = mail;
        this.password = password;
    }
    
    public Invitado () {}
    
    // Getters
    public String getUsername() {
    	return this.username;
    }
    
    public String getFirstSurname() {
    	return this.firstSurname;
    }
    
    public String getSecondSurname() {
    	return this.secondSurname;
    }
    
    public String getPhoneNumber() {
    	return this.phoneNumber;
    }
    
    public String getCareer() {
    	return this.career;
    }
    
    public String getMail() {
    	return this.mail;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    // Setters
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public void setFirstSurname(String firstSurname) {
    	this.firstSurname = firstSurname;
    }
    
    public void setSecondSurname(String secondSurname) {
    	this.secondSurname = secondSurname;
    }
    
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }
    
    public void setCareer(String career) {
    	this.career = career;
    }
    
    public void setMail(String mail) {
    	this.mail = mail;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    // To String
    @Override
    public String toString() {
        return "Invitado{" +
                "username='" + username + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", career='" + career + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }


}