package main.Java.me.ville.kotitehtavat.kotitehtava2;

import static main.Java.me.ville.kotitehtavat.kotitehtava2.ConstantValues.*;
public class Course {

    private String name;
    private String courseCode;
    private Character courseBase;
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;

    Course(){}
    Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade){
        setName(name);
        setCourseCode(code,courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }
    Course(Course course){
        this.name = course.getName();
        this.courseCode = course.getCourseCode();
        this.courseBase = course.getCourseBase();
        this.courseType = course.getCourseType();
        this.period = course.getPeriod();
        this.credits = course.getCredits();
        this.numericGrade = course.isNumericGrade();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) this.name = name;
    }
    public String getCourseTypeString() {
        if (courseType == 0) return "Optional";
        else return "Mandatory";
    }
    public int getCourseType(){
        return courseType;
    }
    public void setCourseType(final int type) {
        if (type == OPTIONAL || type == MANDATORY) courseType = type;
    }
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        if ((courseCode > 0 && courseCode < 1000000) && ("APS".indexOf(courseBase) != -1)) {
            this.courseCode = String.valueOf(courseCode);
            this.courseBase = courseBase;
        }
    }
    public Character getCourseBase() {
        return courseBase;
    }
    public int getPeriod() {
        return period;

    }
    public void setPeriod(final int period) {
        if (period >= MIN_PERIOD && period <= MAX_PERIOD) this.period = period;
    }

    public double getCredits() {
        return credits;
    }

    private void setCredits(final double credits) {
        if (credits >= MIN_CREDITS && credits <= MAX_COURSE_CREDITS) this.credits = credits;
    }
    public boolean isNumericGrade(){
        return numericGrade;
    }
    public void setNumericGrade(boolean numericGrade){
        this.numericGrade = numericGrade;
    }
    @Override
    public String toString(){
        String courseString = String.format("[%s%s \t(%4f cr), \"%s\"",courseCode,courseBase,credits,name);
        courseString += String.format("%s, period: %d.]",getCourseTypeString(),period);

        return courseString;
    }
}
