package main.Java.me.ville.kotitehtavat.kotitehtava2;

import java.time.Year;
import java.util.Random;
import static main.Java.me.ville.kotitehtavat.kotitehtava2.ConstantValues.*;

public class Student {
    private String firstName = NO_NAME;
    private String lastName = NO_NAME;
    private int id;
    private int startYear;
    private int graduationYear;
    private int degreeCount;
    private Degree[] degrees;
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    private final int currentYear = Year.now().getValue();

    public Student() {
        firstName = NO_NAME;
        lastName = NO_NAME;
        id = getRandomId();
        startYear = currentYear;
        birthDate = NO_BIRTHDATE;
    }

    public Student(String lname, String fname) {
        if (fname != null) firstName = fname;
        else firstName = NO_NAME;
        if (lname != null) lastName = lname;
        else lastName = NO_NAME;
        id = getRandomId();
        startYear = currentYear;
        birthDate = NO_BIRTHDATE;
    }
    private int getRandomId(){
        Random i = new Random();
        return (i.nextInt(MAX_ID - MIN_ID + 1) + MIN_ID);
    }
}
