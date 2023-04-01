package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static main.Java.me.ville.kotitehtavat.kotitehtava3.ConstantValues.*;
public class Student extends Person{
    private int id;
    private int startYear;
    private int graduationYear;
    private int degreeCount = 3;
    private List<Degree> degrees = new ArrayList<Degree>();
    private int currentYear = Year.now().getValue();

    Student(String lname, String fname) {
        super(lname, fname);
        id = super.getRandomId(MIN_STUDENT_ID, MAX_STUDENT_ID);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        if ((id >= MIN_STUDENT_ID) && (id <= MAX_STUDENT_ID)) {
            this.id = id;
        }
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
            degrees.get(i).setDegreeTitle(dName);
        }
    }

    public boolean addCourse(final int i, StudentCourse course){
        if (i >= 0 && i < degreeCount && course != null){
            return degrees.get(i).addStudentCourse(course);
        }
        else return false;
    }

    public int addCourses(final int i, StudentCourse[] courses){
        int addedCourses = 0;
        if (i >= 0 && i < degreeCount && courses != null){
            for (StudentCourse course : courses) {
                if (degrees.get(i).addStudentCourse(course)) addedCourses++;
            }
        }
        return addedCourses;
    }

    public void printCourses(){
        for (int degree = 0; degree < degreeCount; degree ++){
            if (degrees.get(degree) != null){
                degrees.get(degree).printCourses();
            }
        }
    }

    public void printDegrees(){
        for (int degree = 0; degree < degreeCount; degree ++){
            System.out.println(degrees.get(degree).toString());
        }
    }

    public void setTitleOfThesis(final int i, String title){
        if (i >= 0 && i < degreeCount && title != null){
            degrees.get(i).setTitleOfThesis(title);
        }
    }
    public boolean hasGraduated(){
        return graduationYear != 0;
    }

    private boolean canGraduate(){
        if (degrees.get(BACHELOR_TYPE).getCredits() >= BACHELOR_CREDITS) if (degrees.get(MASTER_TYPE).getCredits() >= MASTER_CREDITS)
            if (!Objects.equals(degrees.get(BACHELOR_TYPE).getTitleOfThesis(), NO_TITLE))
                return !Objects.equals(degrees.get(MASTER_TYPE).getTitleOfThesis(), NO_TITLE);
        return false;

    }
    public int getStudyYears(){
        if (hasGraduated()){
            return graduationYear - startYear;
        }
        else return currentYear - startYear;
    }
    @Override
    public String toString(){
        String studentString = String.format("Student id: %d \n", id);
        studentString += String.format("\t First name: %s, Last name: %s \n", super.getFirstName(), super.getLastName());
        studentString += String.format("\t Date of Birth: %s \n", super.getBirthDate());

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

        studentString += String.format("\t Total credits: %.1f\n", degrees.get(BACHELOR_TYPE).getCredits() + degrees.get(MASTER_TYPE).getCredits());

        // bachelor credit check
        studentString += String.format("\t Bachelor credits: %.1f\n", degrees.get(BACHELOR_TYPE).getCredits());
        if (degrees.get(BACHELOR_TYPE).getCredits() >= BACHELOR_CREDITS){
            studentString += String.format("\t\t Total bachelor credits completed (%.1f/%.1f) \n",
                    degrees.get(MASTER_TYPE).getCredits(), BACHELOR_CREDITS);
        }
        else{
            studentString += String.format("\t\t Missing bachelor credits %.1f (%.1f/%.1f) \n",
                    BACHELOR_CREDITS - degrees.get(BACHELOR_TYPE).getCredits(),
                    degrees.get(BACHELOR_TYPE).getCredits(), BACHELOR_CREDITS);
        }
        studentString += String.format("\t\t Title of BSc Thesis: \"%s\" \n", degrees.get(BACHELOR_TYPE).getTitleOfThesis());

        // master credit check
        studentString += String.format("\t Master credits: %.1f\n", degrees.get(MASTER_TYPE).getCredits());
        if (degrees.get(MASTER_TYPE).getCredits() >= MASTER_CREDITS){
            studentString += String.format("\t\t Total master's credits completed (%.1f/%.1f) \n",
                    degrees.get(MASTER_TYPE).getCredits(), MASTER_CREDITS);
        }
        else{
            studentString += String.format("\t\t Missing master's credits %.1f (%.1f/%.1f) \n",
                    MASTER_CREDITS - degrees.get(MASTER_TYPE).getCredits(),
                    degrees.get(MASTER_TYPE).getCredits(), MASTER_CREDITS);
        }
        studentString += String.format("\t\t TitleOfMastersThesis: \"%s\" \n", degrees.get(MASTER_TYPE).getTitleOfThesis());
        return studentString;

    }
    public String getIdString(){
        return String.format("Student id: %d",getId());
    }


}
