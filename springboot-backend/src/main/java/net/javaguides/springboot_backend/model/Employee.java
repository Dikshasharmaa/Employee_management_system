package net.javaguides.springboot_backend.model;

public class Employee {
    private long Id;
    private String firstName;
    private String lastName;
    private String emailID;

    public long getId(){
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}
