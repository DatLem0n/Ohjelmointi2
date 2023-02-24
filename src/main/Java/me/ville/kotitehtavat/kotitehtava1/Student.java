package main.Java.me.ville.kotitehtavat.kotitehtava1;

import java.util.Random;
import java.time.Year;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private Random i = new Random();
    private double bachelorCredits;
    private double masterCredits;
    private String titleOfMastersThesis;
    private String titleOfBachelorThesis;
    private int startYear;
    private int graduationYear;
    private String birthDate;

    public Student(){
        firstName = ConstantValues.NO_NAME;
        lastName = ConstantValues.NO_NAME;
        id = i.nextInt(ConstantValues.MAX_ID + 1);
        bachelorCredits = ConstantValues.MIN_CREDIT;
        masterCredits = ConstantValues.MIN_CREDIT;
        titleOfMastersThesis = ConstantValues.NO_TITLE;
        titleOfBachelorThesis = ConstantValues.NO_TITLE;
        startYear = Year.now().getValue();
        birthDate = ConstantValues.NO_BIRTHDATE;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Random getI() {
        return i;
    }

    public void setI(Random i) {
        this.i = i;
    }

    public double getBachelorCredits() {
        return bachelorCredits;
    }

    public void setBachelorCredits(double bachelorCredits) {
        this.bachelorCredits = bachelorCredits;
    }

    public double getMasterCredits() {
        return masterCredits;
    }

    public void setMasterCredits(double masterCredits) {
        this.masterCredits = masterCredits;
    }

    public String getTitleOfMastersThesis() {
        return titleOfMastersThesis;
    }

    public void setTitleOfMastersThesis(String titleOfMastersThesis) {
        this.titleOfMastersThesis = titleOfMastersThesis;
    }

    public String getTitleOfBachelorThesis() {
        return titleOfBachelorThesis;
    }

    public void setTitleOfBachelorThesis(String titleOfBachelorThesis) {
        this.titleOfBachelorThesis = titleOfBachelorThesis;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
