import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{
    public static void main(String [] args){
        // Queue<Integer> testq = new Queue<>();
        // testq.enqueue(1);
        // System.out.println(testq);
        // testq.enqueue(3);
        // System.out.println(testq);
        // testq.enqueue(5);
        // System.out.println(testq);
        // testq.priorityEnqueue(19);
        // System.out.println(testq);

        // Queue <Document> printerQ = getDoxFromFile("documents.txt",10);
        

        int choice;
        Scanner in = new Scanner (System.in);
        // System.out.println(printerQ);
        do{
            Queue <Document> printerQ = getDoxFromFile("documents.txt",10);
            Queue<Document> nextQ = remainingDox("documents.txt",10);
            System.out.println("Make a printer selection:");
            System.out.println("1.)View the printer's current Queue.");
            System.out.println("2.)Check if the queue is full");
            System.out.println("3.)Check for file called priority_topSecret.txt and make it the first document printed");
            System.out.println("4.)Print your documents");
            System.out.println("5.) View the next queue.");
            System.out.println("6.)Clear Screen");
            System.out.println("7.) Quit..");
            choice = in.nextInt();
            System.out.println("\003[H\033[2J");
            System.out.flush();

            switch(choice){
                case 1:
                    System.out.println("All documentts from the file:\n" + printerQ );
                    break;
                case 2:
                    printerQ.isFull();
                    break;
                case 3:
                    if(printerQ.hasPriority(0) == false){
                        System.out.println("The priorrity file is absent. Queue remains unchanged");
                    } 
                    if(printerQ.hasPriority(0) == true){
                        printerQ.swapPriority();
                        System.out.println("We found the document. Here is your new queue:\n" + printerQ);
                

                    }
                    break;
                case 4:
                    printerQ.swapPriority();
                    nextQ.swapPriority();
                    printDocuments(printerQ);
                    printDocuments(nextQ);

                    break;
                case 5:  
                    System.out.println("\003[H\033[2J");
                    System.out.flush();
                    System.out.println("The next documents next in queue:\n" + nextQ);
                    break;
                case 6: 
                    System.out.println("\003[H\033[2J");
                    System.out.flush();
                    break;
                case 7:
                    System.out.println("Printing has stopped. GoodBye!!");
                    break;
                default:
                System.out.println("Invalid entry. Try again.");
            }

        }   while(choice != 7);


       
       





        
    }

    public static void printDocuments(Queue<Document> someQ){
        for(Document element: someQ.queAsArray()){
            System.out.println("Now Printing........" + element);
        }
            
        

    }

    public static Queue<Document> getDoxFromFile(String filename, int limit){
        Queue <Document> result = new Queue<>(limit);
        Document d;
        int countLine = 0;
        try{
            Scanner fileRdr = new Scanner (new File(filename));
            while(fileRdr.hasNextLine() && countLine < 10){
                String line = fileRdr.nextLine();
                result.enqueue(new Document(line));
                countLine++;
            }
        
        }
        catch(FileNotFoundException e){
            e.printStackTrace();


        }

        return result;

    }

    public static Queue<Document> remainingDox (String filename, int limit){
        Document d;
        int currentLine = 0;
        Queue<Document> result = new Queue<>(limit);
        Queue<Document> leftOvers = new Queue<>();
        try{
            Scanner fileRdr2 = new Scanner(new File(filename));
            while(fileRdr2.hasNextLine()){
                currentLine++;
                String line = fileRdr2.nextLine();
                if (currentLine >= limit + 1){
                    result.enqueue(new Document(line));
                

                }
                


        
            }
    
        }

        catch(FileNotFoundException e){
            e.printStackTrace();


        }

        return result;
        
        

    }

}