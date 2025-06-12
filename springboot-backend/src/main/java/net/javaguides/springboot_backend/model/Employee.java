package net.javaguides.springboot_backend.model;

import jakarta.persistence.*;

@Entity //Maps the Java class to a database table.
@Table(name="employees")
public class Employee {
    @Id //marks id as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailID;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String emailID){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
    }

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
