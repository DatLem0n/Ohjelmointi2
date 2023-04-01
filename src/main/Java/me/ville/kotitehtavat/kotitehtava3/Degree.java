package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.util.ArrayList;
import java.util.List;

import static main.Java.me.ville.kotitehtavat.kotitehtava3.ConstantValues.*;
public class Degree {
    private static final int MAX_COURSES = 50;
    private String degreeTitle = NO_TITLE;
    private String titleOfThesis = NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>();

    public List<StudentCourse> getCourses() {
        return myCourses;
    }

    public void addStudentCourses(List<StudentCourse> courses){
        if (courses != null) {
            for (int i = 0; i < courses.size(); i++) {
                if (!addStudentCourse(courses.get(i))) break;
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course){
        if (course != null && myCourses.size() <= MAX_COURSES){
            myCourses.add(course);
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
        for (int i = 0; i < myCourses.size(); i++){
            if (isCourseCompleted(myCourses.get(i)) && myCourses.get(i).getCourse().getCourseBase() == base){
                creditSum += myCourses.get(i).getCourse().getCredits();
            }
        }
        return creditSum;
    }

    public double getCreditsByType(final int courseType){
        double creditSum = 0;
        for (int i = 0; i < myCourses.size(); i++){
            if (isCourseCompleted(myCourses.get(i)) && myCourses.get(i).getCourse().getCourseType() == courseType){
                creditSum += myCourses.get(i).getCourse().getCredits();
            }
        }
        return creditSum;
    }

    public double getCredits(){
        double creditSum = 0;
        for (int i = 0; i < myCourses.size(); i++){
            if (isCourseCompleted(myCourses.get(i))) creditSum += myCourses.get(i).getCourse().getCredits();
        }
        return creditSum;
    }

    private boolean isCourseCompleted(StudentCourse c){
        if (c != null) return c.isPassed();
        else return false;
    }

    public void printCourses(){
        for (int i = 0; i <= myCourses.size(); i++){
            if (myCourses.get(i) == null) break;
            else System.out.println(myCourses.get(i).toString());
        }
    }

    public List<Double> getGPA(int type){
        List<Double> returnList = new ArrayList<>();
        double sum = 0.0;
        double count = 0.0;
        double average = 0.0;
        for (int i = 0; i < myCourses.size(); i++){
            if (isCourseCompleted(myCourses.get(i)) && myCourses.get(i).getCourse().getCourseType() == type &&
                                                                myCourses.get(i).getCourse().isNumericGrade()){
                sum += myCourses.get(i).getGradeNum();
                count ++;
                average = sum / count;
            }
        }
        returnList.add(sum);
        returnList.add(count);
        returnList.add(average);
        return returnList;

    }

    @Override
    public String toString(){
        StringBuilder degreeString = new StringBuilder(String.format("Degree [Title: \"%s\" (courses: %d)\n", degreeTitle, myCourses.size()));
        degreeString.append(String.format("\tThesis title: \"%s\"\n", titleOfThesis));

        for (int i = 0; i < myCourses.size(); i++){
            degreeString.append(String.format("\t%d. %s\n", i + 1, myCourses.get(i).toString()));
        }
        return degreeString.toString();
    }
}
