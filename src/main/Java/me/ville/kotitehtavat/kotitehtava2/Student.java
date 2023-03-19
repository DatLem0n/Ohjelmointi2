package main.Java.me.ville.kotitehtavat.kotitehtava2;

import java.time.Year;
import java.util.Objects;
import java.util.Random;

import static main.Java.me.ville.kotitehtavat.kotitehtava2.ConstantValues.*;

public class Student {

    private String firstName;
    private String lastName;
    private int id;
    private int startYear;
    private int graduationYear;
    private int degreeCount = 3;
    private Degree[] degrees;
    private String birthDate;
    private final int currentYear = Year.now().getValue();

    public Student() {
        firstName = NO_NAME;
        lastName = NO_NAME;
        id = getRandomId();
        startYear = currentYear;
        birthDate = NO_BIRTHDATE;
        degrees = new Degree[degreeCount];
        for (int i = 0; i < degreeCount; i++){
            degrees[i] = new Degree();
        }

    }

    public Student(String lname, String fname) {
        this();
        if (fname != null) firstName = fname;
        if (lname != null) lastName = lname;
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
        if ((id >= MIN_ID) && (id <= MAX_ID)) {
            this.id = id;
        }
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if ((startYear > 2000) && (startYear <= currentYear))  this.startYear = startYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {
        if (canGraduate()) {
            if ((graduationYear >= startYear) && (graduationYear <= currentYear)){
                this.graduationYear = graduationYear;
                return "Ok";
            }
            return "Check graduation year";
        }
        return "Check amount of required credits";

    }

    public void setDegreeTitle(final int i, String dName){
        if (i >= 0 && i < degreeCount && dName != null){
            degrees[i].setDegreeTitle(dName);
        }
    }

    public boolean addCourse(final int i, StudentCourse course){
        if (i >= 0 && i < degreeCount && course != null){
            return degrees[i].addStudentCourse(course);
        }
        else return false;
    }

    public int addCourses(final int i, StudentCourse[] courses){
        int addedCourses = 0;
        if (i >= 0 && i < degreeCount && courses != null){
            for (StudentCourse course : courses) {
                if (degrees[i].addStudentCourse(course)) addedCourses++;
            }
        }
        return addedCourses;
    }

    public void printCourses(){
        for (int degree = 0; degree < degreeCount; degree ++){
            if (degrees[degree] != null){
                degrees[degree].printCourses();
            }
        }
    }

    public void printDegrees(){
        for (int degree = 0; degree < degreeCount; degree ++){
            System.out.println(degrees[degree].toString());
        }
    }

    public void setTitleOfThesis(final int i, String title){
        if (i >= 0 && i < degreeCount && title != null){
            degrees[i].setTitleOfThesis(title);
        }
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

    public boolean hasGraduated(){
        return graduationYear != 0;
    }

    private boolean canGraduate(){
        if (degrees[BACHELOR_TYPE].getCredits() >= BACHELOR_CREDITS) if (degrees[MASTER_TYPE].getCredits() >= MASTER_CREDITS)
            if (!Objects.equals(degrees[BACHELOR_TYPE].getTitleOfThesis(), NO_TITLE))
                return !Objects.equals(degrees[MASTER_TYPE].getTitleOfThesis(), NO_TITLE);
        return false;
    }

    public int getStudyYears(){
        if (hasGraduated()){
            return graduationYear - startYear;
        }
        else return currentYear - startYear;
    }

    private int getRandomId(){
        Random i = new Random();
        return (i.nextInt(MAX_ID - MIN_ID + 1) + MIN_ID);
    }

    @Override
    public String toString(){
        String studentString = String.format("Student id: %d \n", id);
        studentString += String.format("\t First name: %s, Last name: %s \n", firstName, lastName);
        studentString += String.format("\t Date of Birth: %s \n", birthDate);

        // graduation check
        if (hasGraduated()){
            studentString += String.format("\t Status: The student has graduated in %d \n", graduationYear);
            studentString += String.format("\t StartYear: %d (studies lasted for %d years) \n",
                    startYear, graduationYear - startYear);
        }
        else {
            studentString += ("\t Status: The student has not graduated, yet \n");
            studentString += String.format("\t StartYear: %d (studies have lasted for %d years) \n",
                    startYear, currentYear - startYear);
        }

        studentString += String.format("\t Total credits: %.1f\n", degrees[BACHELOR_TYPE].getCredits() + degrees[MASTER_TYPE].getCredits());

        // bachelor credit check
        studentString += String.format("\t Bachelor credits: %.1f\n", degrees[BACHELOR_TYPE].getCredits());
        if (degrees[BACHELOR_TYPE].getCredits() >= BACHELOR_CREDITS){
            studentString += String.format("\t\t Total bachelor credits completed (%.1f/%.1f) \n",
                    degrees[BACHELOR_TYPE].getCredits(), BACHELOR_CREDITS);
        }
        else{
            studentString += String.format("\t\t Missing bachelor credits %.1f (%.1f/%.1f) \n",
                    BACHELOR_CREDITS - degrees[BACHELOR_TYPE].getCredits(),
                    degrees[BACHELOR_TYPE].getCredits(), BACHELOR_CREDITS);
        }
        studentString += String.format("\t\t Title of BSc Thesis: \"%s\" \n", degrees[BACHELOR_TYPE].getTitleOfThesis());

        // master credit check
        studentString += String.format("\t Master credits: %.1f\n", degrees[MASTER_TYPE].getCredits());
        if (degrees[MASTER_TYPE].getCredits() >= MASTER_CREDITS){
            studentString += String.format("\t\t Total master's credits completed (%.1f/%.1f) \n",
                    degrees[MASTER_TYPE].getCredits(), MASTER_CREDITS);
        }
        else{
            studentString += String.format("\t\t Missing master's credits %.1f (%.1f/%.1f) \n",
                    MASTER_CREDITS - degrees[MASTER_TYPE].getCredits(),
                    degrees[MASTER_TYPE].getCredits(), MASTER_CREDITS);
        }
        studentString += String.format("\t\t TitleOfMastersThesis: \"%s\" \n", degrees[MASTER_TYPE].getTitleOfThesis());
        return studentString;

    }
}
