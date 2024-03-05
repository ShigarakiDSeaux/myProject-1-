import java.util.*;
import java.time.*;
public class Student{
    //in order for my object to have state(data), you must have instance vairables
    private String name;
    private int birthYear;
    private int id;
    private boolean isSciMaj;

    //Constructor(s) will bbe the same name as your class.
    public Student(){
        // name = "Samuel";
        // birthYear = -1;
        // id = -1;
        // isSciMaj = false;
        this("Julian",Integer.MAX_VALUE,Integer.MAX_VALUE, false);

    } //constructor 1

    //Parameterized constructor
    public Student( String name, int bYr, int id, boolean ism){
        if (bYr < 0 || id < 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        birthYear = bYr;
        this.id = id;
        isSciMaj = ism;

    } // end of constructors


    public String toString(){
        return name + " " + birthYear + " " + id + " " + isSciMaj;
    }// must have this tostrig method

    //Method(s) - a function tht belongs to an object. Not used in main like a regualr function.
    public String getName(){
        return name;
    }//Name Accessor/getter

    public void setName(String Iname){
        name = Iname;
    }//Name setter

    public int getYear(){
        return birthYear;
    }//birth year Accessor/getter

    public void setYear(int bYear){
        birthYear = bYear;
    }//birthyear setter

    public int getId(){
        return id;

    }//id accessor/getter

    public void setId(int someId){
        id = someId;


    }//id setter

    public boolean getIsSciMajor(){
        return isSciMaj;

    }//major accessor/getter

    public void setIsSciMajor(boolean yesNo){
        isSciMaj = yesNo;
    }

    //sss.getAge()
    public int getAge(){
        int currY = 2023;
        LocalDate tdyDate = LocalDate.now();
        currY = tdyDate.getYear();
        return currY - birthYear;
    }// age getter

    @Override
    //s1.equals(s2) <--- a call will look like this
    public boolean equals (Object o){
        if (this == o){return true;}
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        //equals

        Student s = (Student) o ; //Type casting o converting to student
        return id == s.id && birthYear == s.birthYear && name.equals(s.name) && isSciMaj == s.isSciMaj;
    }
    @Override
    public int hashCode(){
        return Objects.hash("Name:" + name + "\n", "Customer Id:" + id + "\n","BirthYear:" + birthYear + "\n", "Science Major:" + isSciMaj);

    }//function call
}//end of obj
