/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbw.ch.schulweg;

import java.util.ArrayList;

/**
 *
 * @author Jassimran
 */
public class Person {

    private String name;
    private String surname;
    private String departureLocation;
    private String arrivalLocation;
    private ArrayList<Person> personList;

    public Person() {
        this.personList = new ArrayList<>();
    }

    public Person(String name, String surname, String departureLocation, String arrivalLocation) {
        this.name = name;
        this.surname = surname;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
}
