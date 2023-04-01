package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.util.Objects;
import java.util.Random;
import static main.Java.me.ville.kotitehtavat.kotitehtava3.ConstantValues.*;
abstract class Person {
    private String firstName = NO_NAME;
    private String lastName = NO_NAME;
    private String birthDate = NO_BIRTHDATE;

    Person(String lname, String fname){
        setFirstName(fname);
        setLastName(lname);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null)  this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null)   this.lastName = lastName;
    }

    public String getBirthDate(){
        return birthDate;
    }

    public String setBirthDate(String personID){
        if (personID != null){
            PersonID ID = new PersonID();
            String returnString = ID.setPersonID(personID);
            if (Objects.equals(returnString, "Ok")){
                birthDate = ID.getBirthDate();
                return birthDate;
            }
            else return "No change";

        }
        else return "No change";
    }
    protected int getRandomId(final int min, final int max){
        Random i = new Random();
        return (i.nextInt(max - min + 1) + min);
    }
    abstract String getIdString();
}
