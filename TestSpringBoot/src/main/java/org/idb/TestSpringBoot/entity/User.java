package org.idb.TestSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(length = 45, nullable = false, unique = true)
    private  String email;

    @Column(length = 64, nullable = false)
    private  String password;

    @Column(length = 30, nullable = false)
    private  String firstName;

    @Column(length = 30, nullable = false)
    private  String lastName;

}
