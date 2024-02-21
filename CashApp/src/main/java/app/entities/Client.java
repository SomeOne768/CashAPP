package app.entities;

import java.util.Date;

public class Client{
    private Long clientId;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private int postcode;

    
    public Client(String firstname, String lastname, Date birthdate, int postcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.postcode = postcode;
    }

    
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
