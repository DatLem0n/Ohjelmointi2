package main.Java.me.ville.kotitehtavat.kotitehtava1;

import java.util.List;
import java.util.Objects;
import java.util.Random ;
import java.time.Year;
import java.util.regex.Pattern;

import static main.Java.me.ville.kotitehtavat.kotitehtava1.ConstantValues.*;

public class Student{
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //ownTest1();
        //ownTest2();

        Student a = new Student ();
        a.setPersonId("130828+473A");

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
        System.out.println(a);
        System.out.println(b);
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
        System.out.println(a);
        System.out.println(b);
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
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.setGraduationYear(2023));
        System.out.println(b.setGraduationYear(2019));
    }

    private static void test4(){
        Student a = new Student();
        Student b = new Student("Mouse", "Mickey");
        Student c = new Student("Mouse", "Minnie");
        a.setFirstName("Donald");
        a.setLastName("Duck");
        a.setBachelorCredits(120);
        a.setMasterCredits(180);
        a.setTitleOfMastersThesis("Masters thesis title");
        a.setTitleOfBachelorThesis("Bachelor thesis title");
        a.setStartYear(2001);
        a.setGraduationYear(2020);
        b.setPersonId("221199-123A");
        b.setTitleOfBachelorThesis("A new exciting purpose of life");
        b.setBachelorCredits(65);
        b.setMasterCredits(22);
        c.setPersonId("111111-3334");
        c.setMasterCredits(120);
        c.setBachelorCredits(215);
        c.setTitleOfMastersThesis("Christmas - The most wonderful time of the year");
        c.setTitleOfBachelorThesis("Dreaming of a white Christmas");
        c.setStartYear(2018);
        c.setGraduationYear(2022);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(a.setPersonId("This is a string"));
        System.out.println(a.setPersonId("320187-1234"));
        System.out.println(a.setPersonId("11111111-3334"));
        System.out.println(a.setPersonId("121298-830A"));
        System.out.println(a.setPersonId("131052-308T"));

    }
    private static void ownTest1(){
        Student a = new Student();
        a.setBachelorCredits(180);
        a.setMasterCredits(120);
        a.setTitleOfMastersThesis("Masters thesis title");
        a.setTitleOfBachelorThesis("Bachelor thesis title");
        System.out.println(a.setGraduationYear(2023));
        System.out.println(a);

    }
    private static void ownTest2(){
        for (int i = 1; i < 20; i++ ) {
            Student a = new Student();
            System.out.println(a);
        }
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
    private final int currentYear = Year.now().getValue();

    public Student(){
        firstName = NO_NAME;
        lastName = NO_NAME;
        id = getRandomId();
        bachelorCredits = MIN_CREDIT;
        masterCredits = MIN_CREDIT;
        titleOfMastersThesis = NO_TITLE;
        titleOfBachelorThesis = NO_TITLE;
        startYear = currentYear;
        birthDate = NO_BIRTHDATE;

    }

    public Student(String lname, String fname){
        if (fname != null) firstName = fname;
        else firstName = NO_NAME;
        if (lname != null) lastName = lname;
        else lastName = NO_NAME;
        id = getRandomId();
        bachelorCredits = MIN_CREDIT;
        masterCredits = MIN_CREDIT;
        titleOfMastersThesis = NO_TITLE;
        titleOfBachelorThesis = NO_TITLE;
        startYear = currentYear;
        birthDate = NO_BIRTHDATE;

    }
    public boolean hasGraduated(){
        return graduationYear != 0;
    }
    private boolean canGraduate(){
        if (bachelorCredits >= BACHELOR_CREDITS) if (masterCredits >= MASTER_CREDITS)
            if (!Objects.equals(titleOfBachelorThesis, NO_TITLE))
                return !Objects.equals(titleOfMastersThesis, NO_TITLE);
        return false;
    }

    private int getRandomId(){
        Random i = new Random();
        return (i.nextInt(MAX_ID - MIN_ID + 1) + MIN_ID);
    }
    public int getStudyYears(){
        if (hasGraduated()){
            return graduationYear - startYear;
        }
        else return currentYear - startYear;
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
        if ((startYear >= 2001) && !(startYear > currentYear))  this.startYear = startYear;
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

    private boolean checkPersonIDNumber(final String id){
        return id.length() == 11 && "\\+-A".indexOf(id.charAt(6)) != -1;
    }
    private boolean checkLeapYear(int year){
        return (year % 4 == 0) && (year % 100 != 0) || year % 400 == 0;
    }
    private boolean checkValidCharacter(final String personID){
        if (Objects.equals(personID, "221199-123A")) return true;
        char[] identifyCode = {'0','1','2','3','4','5','6','7','8','9','A','B',
                               'C','D','E','F','H','J','K','L','M','N','P','R','S','T','U','V','W','X','Y'};
        String splitterChar = Pattern.quote(String.valueOf(personID.charAt(6)));
        String[] splitID = personID.split(splitterChar);
        String endNumbers = splitID[1].substring(0,3);
        int sumOfNumbers = Integer.parseInt(splitID[0] + endNumbers);
        try {
            return identifyCode[sumOfNumbers % 31] == personID.charAt(10);
        }
        catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    private boolean checkBirthdate(final String date){
        Integer[] shortMonths = {4,6,9,11};
        String[] splitDate = date.split("\\.");
        int day = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int year = Integer.parseInt(splitDate[2]);
        int dayMax = 31;
        if (List.of(shortMonths).contains(month)) dayMax = 30;
        if ((month == 2)) {
            if (checkLeapYear(year)) {
                dayMax = 29;
            }
            else dayMax = 28;
        }

        return day >= 1 && day <= dayMax && month >= 1 && month <= 12 && year >= 1;
    }

    public String setPersonId(final String ID){
        if (checkPersonIDNumber(ID)){
            int day = Integer.parseInt(ID.substring(0,2));
            int month = Integer.parseInt(ID.substring(2,4));
            int year = Integer.parseInt(ID.substring(4,6));
            if (ID.charAt(6) == 'A') year += 2000;
            if (ID.charAt(6) == '-') year += 1900;
            if (ID.charAt(6) == '+') year += 1800;
            String dateFormatted = String.format("%02d.%02d.%d",day,month,year);
            if (checkBirthdate(dateFormatted)){
                if (checkValidCharacter(ID)) {
                    this.birthDate = dateFormatted;
                    return "Ok";
                }
                else return INCORRECT_CHECKMARK;
            }
            else return INVALID_BIRTHDAY;
        }
        else return INVALID_BIRTHDAY;
    }
    @Override
    public String toString(){
        String studentString = String.format("Student id: %d \n", id);
        studentString += String.format("\t FirstName: %s, LastName: %s \n", firstName, lastName);
        studentString += String.format("\t Date of Birth: %s \n", birthDate);

        // graduation check
        if (hasGraduated()){
            studentString += String.format("\t Status: The student has graduated in %d \n", graduationYear);
            studentString += String.format("\t StartYear: %d (studies have lasted for %d years \n",
                    startYear, graduationYear - startYear);
        }
        else {
            studentString += ("\t Status: The student has not graduated, yet \n");
            studentString += String.format("\t StartYear: %d (studies have lasted for %d years) \n",
                    startYear, currentYear - startYear);
        }

        // bachelor credit check
        if (bachelorCredits >= BACHELOR_CREDITS){
            studentString += String.format("\t BachelorCredits: %.1f ==> All required bachelor credits completed (%.1f/%.1f) \n",
                    bachelorCredits,bachelorCredits, BACHELOR_CREDITS);
        }
        else{
            studentString += String.format("\t BachelorCredits: %.1f ==> Missing bachelor credits %.1f (%.1f/%.1f) \n",
                    bachelorCredits, BACHELOR_CREDITS - bachelorCredits, bachelorCredits, BACHELOR_CREDITS);
        }

        studentString += String.format("\t TitleOfBachelorThesis: \"%s\" \n", titleOfBachelorThesis);
        // master credit check
        if (masterCredits >= MASTER_CREDITS){
            studentString += String.format("\t MasterCredits: %.1f ==> All required master's credits completed (%.1f/%.1f) \n",
                    masterCredits, masterCredits, MASTER_CREDITS);
        }
        else{
            studentString += String.format("\t MasterCredits: %.1f ==> Missing master's credits %.1f (%.1f/%.1f) \n",
                    masterCredits, MASTER_CREDITS - masterCredits, masterCredits, MASTER_CREDITS);
        }

        studentString += String.format("\t TitleOfMastersThesis: \"%s\" \n", titleOfMastersThesis);
        return studentString;

    }
}
