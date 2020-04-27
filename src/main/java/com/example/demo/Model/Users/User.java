package com.example.demo.Model.Users;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="USERS")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(name="first_name", nullable = false, length=30)
    private String firstName;
    @Column(name="last_name", nullable = false, length=40)
    private String lastName;
    @Column(name="email", nullable = false, length=50)
    private String email;
    @Column(name="role", nullable = false )
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.getClass().getName();
    }

}

