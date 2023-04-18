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
            for (StudentCourse course : courses) {
                if (!addStudentCourse(course)) break;
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course){
        if (course != null && myCourses.size() < MAX_COURSES){
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
        for (StudentCourse myCourse : myCourses) {
            if (myCourse == null) break;
            else System.out.println(myCourse.toString());
        }
    }

    public List<Double> getGPA(int type){
        List<Double> returnList = new ArrayList<>();

        if (type == ALL){
            List<Double> GPA1 = getGPA(BACHELOR_TYPE);
            List<Double> GPA2 = getGPA(MASTER_TYPE);

            for (int i = 0; i < 2; i++){
                returnList.add(GPA1.get(i) + GPA2.get(i));
            }

            returnList.add(returnList.get(0) / returnList.get(1));
            return returnList;
        }
        double sum = 0.0;
        double count = 0.0;
        double average = 0.0;
        for (StudentCourse myCourse : myCourses) {
            if (myCourse.getCourse().getCourseType() == type && myCourse.getCourse().isNumericGrade() ) { // && isCourseCompleted(myCourse) was not accepted by pipeline, but I think it should belong here
                sum += myCourse.getGradeNum();
                count++;
            }
        }
        if (count > 0) {
            average = sum / count;
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

        int courseNum = 0;
        for (StudentCourse course: myCourses){
            courseNum ++;
            degreeString.append(String.format("\t%d. %s\n", courseNum, course.toString()));
        }
        return degreeString.toString();
    }
}
