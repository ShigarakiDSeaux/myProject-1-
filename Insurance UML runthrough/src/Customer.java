import java.util.*;
public class Customer {
    //Instance variables
    private int customerID;
    private String name;
    private String address;
    private String phone;


    //Constructor(s)
    public Customer(){
        this(Integer.MAX_VALUE,"Name:","Address:","Phone:");

    }

    public Customer(int customerID, String name, String address, String phone){
        if(customerID < 0){
            throw new IllegalArgumentException();
        }
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;


    }//Parameterized Constructor
    public String toString (){
        return "Customer ID:" + customerID + "\n" +"Name:"+name+"\n"+"Address:"+address+"\n"+"Phone:"+phone;
    }//toString Method


    //GETTERS
    public int getCustomerID(){
        return customerID;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    //SETTERS
    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }

    public void setName(String name){
        this.name = name;

    }

    public void setAddress(String address){
        this.address = address;

    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    @Override
    //Equals Method
    public boolean equals(Object o) {
        if (this == o) {
            return false;
        }
        ;
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        //Type casting to convert object to customer
        Customer c = (Customer) o;
        return customerID == c.customerID && name.equals(c.name) && address.equals(c.address) && phone.equals(c.phone);
    }
    @Override
    //HASHCODE FORMATTING
    public int hashCode(){
        return Objects.hash(customerID, name, address, phone);

    }



}//END OF OBJECT
