import java.util.*;
import java.io.*;
public class AccountDemo{
    public static ArrayList<Account> accountFromFile(String fileName){
        /*Create a list of type Account to store the file data,
        and create a new filepath.*/
        ArrayList<Account> accounts = new ArrayList<>();
        File file = new File(fileName);
        /*use try catch blocks to read,catch user input error.
        TRY reading the file and creating the object.....if unsuccessful*/
        
        try{

            //Create a scannner to read the file.
            Scanner input = new Scanner(file);
            /*Note. tthe file has multiple elements oon each line. 
            create a string array to split the data inn teach line and
            assign them accordingly*/
            while(input.hasNext()){
                String firstName = input.next();
                String lastName = input.next();
                int ID = input.nextInt();
                double balance = input.nextDouble();
                boolean paperless = input.nextBoolean();

                Account a = new Account(firstName, lastName,ID,balance,paperless);
                accounts.add(a);
            }
            input.close();
        }
        /*catch it and output this string and exit the program.*/
        catch(FileNotFoundException ex){
            System.out.println("ERROR: No file was found!");
            System.exit(2);
        }

        


        return accounts;
    }
     public static ArrayList<Account> gotIncentive (ArrayList<Account> accts){
        ArrayList<Account> result = new ArrayList<>();
        double newBalance = 0;
        for(int i = 0; i < accts.size(); i++){
            if (accts.get(i).getPaperless() == true){
                // get the balance first, add the 5, then update.
                newBalance = accts.get(i).getBalance() + 5.00;
                accts.get(i).setBalance(newBalance); 
                result.add(accts.get(i));
            }
            

        }

        return result;
    }

    public static Account mostBread(ArrayList<Account> accts){
        Account result = new Account();
        double max = 0;
        for(Account act: accts){
            if (act.getBalance() > max){
                max = act.getBalance();
                result = act;
            }
        }

        return result;
        
        
    }


    public static void main (String [] args){
        /*1) For each row in the file “accounts.txt”, create an Account object using the data from the
        file
        2) Store all Account objects into an ArrayList called “customers”
        3) As an incentive to be environmentally friendly, this bank will provide a $5.00 cash reward
        to all customers who are signed up for paperless statements.
        • Make your program add $5.00 to all customer accounts that are signed up for
        paperless statements. Afterwards, print all customers that are signed up for
        paperless statements.
        4) Print the customer with the largest account balance*/
        ArrayList<Account> customers = accountFromFile("account.txt");
        Account a1 = new Account(); // testing out my new object
        Account a2 = new Account("Samuel", "Maxey",1929,123456.78,true);
        System.out.printf("My default contructed object:>>>>\n%s\n",a1);
        System.out.printf("My parameterized contructed object:>>>>\n%s\n",a2);
        System.out.println("The customers from the data file:>>>>\n" + customers);
        System.out.println("\nCustomers who are paperless and received the Incentive:>>>>\n" + gotIncentive(customers));
        System.out.printf("The customer that has the highest balance is:>>>>\n%s\n", mostBread(customers));


        


        
        
    }
}