package com.udea.TurnosVigilancia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vigilantes")
public class Vigilante {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private  Integer id;//Integer sirve para que envuelva muchas mas cosas aparte de los numeros Ej: los nulos
    @Column
    private  String name;

    @Column
    private int age;


    @Column
    private String  company;


    @Column
    private  boolean disponible;


    @Column
    private String puestoVigilancia;


    @Column
    int telefono;

    @Column
    String dia;

    @Column
    int horas;


    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPuestoVigilancia() {
        return puestoVigilancia;
    }

    public void setPuestoVigilancia(String puestoVigilancia) {
        this.puestoVigilancia = puestoVigilancia;
    }







    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }




    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
