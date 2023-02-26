package main.Java.me.ville.kotitehtavat.kotitehtava1;

import java.util.Random ;
import java.time.Year;

public class Student {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        ownTest1();

    }
    private static void test1(){
        Student a = new Student();
        Student b = new Student("Mouse", "Mickey");
        a.setFirstName("Donald");
        a.setLastName("Duck");
        a.setId(330);
        a.setBachelorCredits(55);
        a.setMasterCredits(14);
        a.setTitleOfBachelorThesis("Bachelor thesis title");
        a.setStartYear(2020);
        a.setGraduationYear(2021);
        b.setBachelorCredits(5);
        b.setId(4);
        b.setTitleOfBachelorThesis(null);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
    private static void test2(){
        Student a = new Student();
        Student b = new Student("Mouse", "Mickey");
        a.setFirstName("Donald");
        a.setLastName("Duck");
        a.setId(0);
        a.setBachelorCredits(180);
        a.setMasterCredits(180);
        a.setTitleOfMastersThesis("Masters thesis title");
        a.setTitleOfBachelorThesis("Bachelor thesis title");
        a.setStartYear(2001);
        a.setGraduationYear(2020);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
    private static void test3(){
        Student a = new Student();
        Student b = new Student("Mouse", "Mickey");
        a.setFirstName("Donald");
        a.setLastName("Duck");
        a.setId(0);
        a.setBachelorCredits(180);
        a.setMasterCredits(120);
        a.setTitleOfBachelorThesis("Bachelor thesis title");
        a.setStartYear(2021);
        a.setGraduationYear(2021);
        b.setFirstName(null);
        b.setLastName(null);
        b.setBachelorCredits(180);
        b.setMasterCredits(120);
        b.setTitleOfBachelorThesis("How to survive a bachelors thesis");
        b.setTitleOfMastersThesis("Happy ending");
        b.setId(101);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(a.setGraduationYear(2023));
        System.out.println(b.setGraduationYear(2019));
    }
    private static void ownTest1(){
        Student a = new Student();
        a.setBachelorCredits(180);
        a.setMasterCredits(120);
        a.setTitleOfMastersThesis("Masters thesis title");
        a.setTitleOfBachelorThesis("Bachelor thesis title");
        System.out.println(a.setGraduationYear(2023));
        System.out.println(a.toString());

    }
    private String firstName;
    private String lastName;
    private int id;
    private double bachelorCredits;
    private double masterCredits;
    private String titleOfMastersThesis;
    private String titleOfBachelorThesis;
    private int startYear;
    private int graduationYear;
    private String birthDate;
    private int currentYear = Year.now().getValue();

    public Student(){
        firstName = ConstantValues.NO_NAME;
        lastName = ConstantValues.NO_NAME;
        id = getRandomId();
        bachelorCredits = ConstantValues.MIN_CREDIT;
        masterCredits = ConstantValues.MIN_CREDIT;
        titleOfMastersThesis = ConstantValues.NO_TITLE;
        titleOfBachelorThesis = ConstantValues.NO_TITLE;
        startYear = currentYear;
        birthDate = ConstantValues.NO_BIRTHDATE;

    }

    public Student(String lname, String fname){
        firstName = fname;
        lastName = lname;
        id = getRandomId();
        bachelorCredits = ConstantValues.MIN_CREDIT;
        masterCredits = ConstantValues.MIN_CREDIT;
        titleOfMastersThesis = ConstantValues.NO_TITLE;
        titleOfBachelorThesis = ConstantValues.NO_TITLE;
        startYear = Year.now().getValue();
        birthDate = ConstantValues.NO_BIRTHDATE;

    }
    public boolean hasGraduated(){
            if (graduationYear == 0) return false;
            else return true;
    }
    private boolean canGraduate(){
        if (((bachelorCredits >= 180) && (masterCredits >= 120)) && (titleOfBachelorThesis != ConstantValues.NO_TITLE && titleOfMastersThesis != ConstantValues.NO_TITLE)) return true;
        else return false;
    }

    private int getRandomId(){
        Random i = new Random();
        return (i.nextInt(ConstantValues.MAX_ID) + 1);
    }
    public int getStudyYears(){
        if (hasGraduated()){
            return startYear - graduationYear;
        }
        else return startYear - currentYear;
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

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        if ((id >= 1) && (id <= 100)) {
            this.id = id;
        }
    }

    public double getBachelorCredits() {
        return bachelorCredits;
    }

    public void setBachelorCredits(final double bachelorCredits) {
        if ((bachelorCredits >= 0) && (bachelorCredits <= 300)) {
            this.bachelorCredits = bachelorCredits;
        }
    }

    public double getMasterCredits() {
        return masterCredits;
    }

    public void setMasterCredits(final double masterCredits) {
        if ((masterCredits >= 0) && (masterCredits <= 300)) {
            this.masterCredits = masterCredits;
        }
    }

    public String getTitleOfMastersThesis() {
        return titleOfMastersThesis;
    }

    public void setTitleOfMastersThesis(String title) {
        if (title != null)   this.titleOfMastersThesis = title;
    }

    public String getTitleOfBachelorThesis() {
        return titleOfBachelorThesis;
    }

    public void setTitleOfBachelorThesis(String title) {
        if (title != null)  this.titleOfBachelorThesis = title;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if ((startYear >= 2000) && !(startYear > currentYear))  this.startYear = startYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {
        if (canGraduate()){
            if ((graduationYear >= startYear) && (graduationYear <= currentYear)){
                this.graduationYear = graduationYear;
                return "Ok";
            }
            return "Check graduation year";

        }
        return "Check the required studies";
    }
    @Override
    public String toString(){
        String studentString = String.format("Student id: %d \n", id); // student ID
        studentString += String.format("\t FirstName: %s, LastName: %s \n", firstName, lastName); // student name
        if (hasGraduated()){
            studentString += String.format("\t Status: The student has graduated in %d \n", graduationYear); // graduation year status (graduated)
            studentString += String.format("\t StartYear: %d (studies have lasted for %d years \n",startYear, graduationYear - startYear); // start year
        }
        else {
            studentString += ("\t Status: The student has not graduated, yet \n"); // graduation status (not graduated)
            studentString += String.format("\t StartYear: %d (studies have lasted for %d years \n",startYear, currentYear - startYear); //start year
        }
        studentString += String.format("\t BachelorCredits: %.1f \n", bachelorCredits); // bachelor credits
        studentString += String.format("\t MasterCredits: %.1f \n", masterCredits); // master credits
        studentString += String.format("\t TitleOfMastersThesis: %s \n", titleOfMastersThesis); // title of masters
        studentString += String.format("\t TitleOfBachelorThesis: %s \n", titleOfBachelorThesis); // title of bachelor

        return studentString;

    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
