import java.util.*;
public class Account{
    //Instance Vars
    private String firstName;
    private String lastName;
    private int ID;
    private double balance;
    private boolean paperless;

    //Constructors
    public Account(){
        this("John", "Doe", 0000, 12345.67, false);

    }

    public Account(String firstName, String lastName, int ID, double balance, boolean paperless){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.balance = balance;
        this.paperless = paperless;

    }
    //Getters
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public int getID(){return ID;}
    public double getBalance(){return balance;}
    public boolean getPaperless(){return paperless;}

    //Setters
    public void setFirstName(String firstName){this.firstName =firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setID(int ID){this.ID = ID;}
    public void setBalance(double balance){this.balance = balance;}
    public void setPaperless(boolean paperless){this.paperless = paperless;}

    //other necessary methods
    public String toString(){
        return "Account information:\nName: " + firstName +" "+lastName + "\nID:" + 
                ID + "\nBalance/Paperless Status:" + "$" + balance+"/"+paperless + "\n";
    }


    


}