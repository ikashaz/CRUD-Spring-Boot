package net.java.springboot_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //getter to get data of private datatype
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="user") //to add table details
public class User {
    @Id //as primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY) //auto generate
    private long id;
    @Column(name="First_Name")
    private String firstname;
    @Column(name="Last_Name")
    private String lastname;
    @Column(name="Email") //if not use this notation jpa will use as name below
    private String email;
}
