package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.time.Year;
import static main.Java.me.ville.kotitehtavat.kotitehtava3.ConstantValues.*;
public class StudentCourse {


    private Course course;
    private int gradeNum;
    private int yearCompleted;
    private int currentYear = Year.now().getValue();

    StudentCourse(){}
    StudentCourse(Course course, final int gradeNum, final int yearCompleted){
        setCourse(course);
        setYear(yearCompleted);
        setGrade(gradeNum);
    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    protected void setGrade(int gradeNum) {
        if (!course.isNumericGrade()){
            gradeNum = Character.toUpperCase(gradeNum);
        }
        if (checkGradeValidity(gradeNum)){
            this.gradeNum = gradeNum;
            if (yearCompleted == 0) yearCompleted = currentYear;
        }
    }
    private boolean checkGradeValidity(final int gradeNum){
        if(course.isNumericGrade() && (gradeNum >= MIN_GRADE && gradeNum <= MAX_GRADE)){
            return true;
        }
        else return !course.isNumericGrade() && (gradeNum == GRADE_FAILED || gradeNum == GRADE_ACCEPTED);
    }
    public boolean isPassed(){
        if (course.isNumericGrade()) return gradeNum != MIN_GRADE;
        else return gradeNum == GRADE_ACCEPTED;
    }

    public int getYear() {
        return yearCompleted;

    }

    public void setYear(final int year) {
        if (year > 2000 && year <= currentYear) yearCompleted = year;
    }

    @Override
    public String toString(){
        String courseString = course.toString();
        courseString += String.format(" Year: %d, ", yearCompleted);
        if (gradeNum == 0){
            courseString += "Grade: \"Not graded\".]";
        }
        else if (!course.isNumericGrade()){
            char gradeChar = (char)gradeNum;
            courseString += String.format("Grade: %c.]", gradeChar);
        }
        else {
            courseString += String.format("Grade: %d.]", gradeNum);
        }
        return courseString;
    }
}
