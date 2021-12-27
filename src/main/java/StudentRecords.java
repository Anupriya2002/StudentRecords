import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;

public class StudentRecords {
    public int capacity = 0;
    public List<Student> studentRecords = new ArrayList<Student>();

    public StudentRecords(int capacity){
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
            this.studentRecords.add(null);
        }
    }

    //hash function to get index
    public int hash(String key){
        //find hash
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }

        return sum % this.capacity;
    }

    //rehash if index is already taken
    public int rehash(int oldHash){
        int newHashVal = (oldHash + 1) % this.capacity;
        return newHashVal;
    }

    public void insert(Student s){
        int currentIndex = this.hash(s.firstName);

        //if the current index is not empty,  keep rehashing until a new index is found
        while (this.studentRecords.get(currentIndex) != null) {
            System.out.println("index is not free, looking for new index");
            currentIndex = this.rehash(currentIndex);
        }

        this.studentRecords.set(currentIndex, s);
    }
    
    public String toString(){
        String toReturn = "\n";
        for(Student s : studentRecords){
            toReturn += s.toString() + "\n";
        }
        return toReturn;

    }


    public static void main(String []args){

        System.out.println("********** STUDENT RECORD MANAGEMENT SYSTEM **********" + "\n");
        System.out.println("   MENU    ");
        System.out.println("1. Add Student to Record");
        System.out.println("2. Print Student Record");
        System.out.println("3. Exit Student Management System" + "\n");

        //new Student Record
        StudentRecords schoolRecords = new StudentRecords(26);

        Scanner input = new Scanner(System.in);
        int option = 0;

        while(option!= 3){
            try {
                System.out.println("Pick an option from the menu listed above: ");
                option = input.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Enter a number to select an action: ");
            }
            input.nextLine();

            while(option <= 0 || option > 3){
                System.out.println("Invalid Input. Try Again.");
                option = input.nextInt();
            }

            //add student
            if (option == 1){
                String fN, lN, prog;
                int year, sNum = 0;

                System.out.println("Enter First Name:");
                fN = input.nextLine();

                System.out.println("Enter Last Name:");
                lN = input.nextLine();

                System.out.println("Enter Year(as a number):");
                year = input.nextInt();

                System.out.println("Enter Student Number:");
                sNum = input.nextInt();
                input.nextLine();

                System.out.println("Enter Program:");
                prog = input.nextLine();

                Student newStudent = new Student(fN, lN, year, sNum, prog);
                schoolRecords.insert(newStudent);
            }
            else if (option == 2){
                //print all records
                System.out.println(schoolRecords.toString());
            }
        }
        System.out.println("System Exited.");


    }
}
