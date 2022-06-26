package com.testspring.springtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "users", schema = "public")
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Users {
    public Users(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="user_id")
    private int userId;

    @Column(name ="user_name")
    private String userName;

    @Column(name ="user_surname")
    private String userSurname;
    
}

