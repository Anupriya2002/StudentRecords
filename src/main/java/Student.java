import java.lang.*;

public class Student {
    public String firstName;
    public String lastName;
    public int year;
    public int studentNumber;
    public String programName;

    public Student(String firstName, String lastName, int year, int studentNumber, String programName){
        this.firstName= firstName;
        this.lastName = lastName;
        this.year = year;
        this.studentNumber = studentNumber;
        this.programName = programName;
    }

    public String toString(){
        String result = "";
        result += "Name: " +  this.firstName + " "  + this.lastName + "\n";
        result += "Student Number: " + this.studentNumber + "\n";
        result += "Year: " + this.year + "\n";
        result += "Program: " + this.programName + "\n";
        return result;
    }


}
