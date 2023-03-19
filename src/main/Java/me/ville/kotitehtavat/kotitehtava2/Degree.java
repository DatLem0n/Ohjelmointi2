package main.Java.me.ville.kotitehtavat.kotitehtava2;

import static main.Java.me.ville.kotitehtavat.kotitehtava2.ConstantValues.*;
public class Degree {
    private static final int MAX_COURSES = 50;
    private int count;
    private String degreeTitle = NO_TITLE;
    private String titleOfThesis = NO_TITLE;
    private StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];

    public StudentCourse[] getCourses() {
        return myCourses;
    }

    public void addStudentCourses(StudentCourse[] courses){
        if (courses != null) {
            for (int i = 0; i < courses.length; i++) {
                if (!addStudentCourse(courses[i])) break;
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course){
        if (course != null && count < MAX_COURSES){
            myCourses[count] = course;
            count ++;
            return true;
        }
        else return false;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) this.degreeTitle = degreeTitle;
    }

    public String getTitleOfThesis() {
        return titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) this.titleOfThesis = titleOfThesis;
    }

    public double getCreditsByBase(Character base){
        double creditSum = 0;
        for (int i = 0; i < count; i++){
            if (isCourseCompleted(myCourses[i]) && myCourses[i].getCourse().getCourseBase() == base){
                creditSum += myCourses[i].getCourse().getCredits();
            }
        }
        return creditSum;
    }

    public double getCreditsByType(final int courseType){
        double creditSum = 0;
        for (int i = 0; i < count; i++){
            if (isCourseCompleted(myCourses[i]) && myCourses[i].getCourse().getCourseType() == courseType){
                creditSum += myCourses[i].getCourse().getCredits();
            }
        }
        return creditSum;
    }

    public double getCredits(){
        double creditSum = 0;
        for (int i = 0; i < count; i++){
            if (isCourseCompleted(myCourses[i])) creditSum += myCourses[i].getCourse().getCredits();
        }
        return creditSum;
    }

    private boolean isCourseCompleted(StudentCourse c){
        if (c != null) return c.isPassed();
        else return false;
    }

    public void printCourses(){
        for (int i = 0; i <= myCourses.length; i++){
            if (myCourses[i] == null) break;
            else System.out.println(myCourses[i].toString());
        }
    }

    @Override
    public String toString(){
        StringBuilder degreeString = new StringBuilder(String.format("Degree [Title: \"%s\" (courses: %d)\n", degreeTitle, count));
        degreeString.append(String.format("\tThesis title: \"%s\"\n", titleOfThesis));

        for (int i = 0; i < count; i++){
            degreeString.append(String.format("\t%d. %s\n", i + 1, myCourses[i].toString()));
        }
        return degreeString.toString();
    }
}
