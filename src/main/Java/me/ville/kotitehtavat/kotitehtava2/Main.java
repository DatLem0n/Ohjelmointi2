package main.Java.me.ville.kotitehtavat.kotitehtava2;


import static main.Java.me.ville.kotitehtavat.kotitehtava2.ConstantValues.*;
public class Main {
    public static void main(String[] args) {

        Student a = new Student();
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies ", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        StudentCourse SC1 = new StudentCourse(course1, 1, 2013);
        StudentCourse SC2 = new StudentCourse(course2, 1, 2014);
        StudentCourse SC3 = new StudentCourse(course3, 1, 2015);
        StudentCourse SC4 = new StudentCourse(course4, 4, 2016);
        StudentCourse SC5 = new StudentCourse(course5, 5, 2017);
        StudentCourse SC6 = new StudentCourse(course6, 1, 2018);
        StudentCourse SC7 = new StudentCourse(course7, 1, 2019);
        StudentCourse SC8 = new StudentCourse(course8, 2, 2020);
        StudentCourse SC9 = new StudentCourse(course9, 0, 2021);
        StudentCourse SC10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse SC11 = new StudentCourse(course11, 'f', 2022);

        StudentCourse[] bachelor = {SC1, SC2, SC3, SC4, SC5};
        StudentCourse[] master = {SC6, SC7, SC8, SC9, SC10, SC11};
        a.setDegreeTitle(BACHELOR_TYPE,"Bachelor of Science");
        a.setDegreeTitle(MASTER_TYPE,"Master of Science");
        a.setTitleOfThesis(BACHELOR_TYPE,"Bachelor thesis title");
        a.setTitleOfThesis(MASTER_TYPE,"Masters thesis title");
        a.addCourses(BACHELOR_TYPE,bachelor);
        a.addCourses(MASTER_TYPE,master);
        a.setStartYear(2001);
        a.setGraduationYear(2020);
        a.setFirstName("Donald");
        a.setLastName("Duck");
        System.out.println(a);
        a.setBirthDate("230498-045T");
        a.setTitleOfThesis(BACHELOR_TYPE,"Christmas - The most wonderful time of the year");
        a.setTitleOfThesis(MASTER_TYPE,"Dreaming of a white Christmas");
        a.printDegrees();
        SC9.setGrade(3);
        System.out.println(a);
        a.printDegrees();
        a.printCourses();
        SC11.setGrade('X');
        System.out.println(SC11.toString());
        SC11.setGrade('a');
        System.out.println(SC11.toString());
        SC1.setGrade(6);
        System.out.println(SC1.toString());
        SC1.setGrade(5);
        System.out.println(SC1.toString());


    }
}
