import java.util.*;
import java.io.*; //for file I/O

class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("== Classes & Objects ==");

        ArrayList<String> citiesAL = readDataFromFile("cities.txt");
        System.out.println("Cities Data\n" + citiesAL);
        /*
         * Read data from a file of students info into a list.
         * Take the contents of the list and create lists per
         * category: name, birth year, id, and science major
         */
        ArrayList<String> studsAL = readDataFromFile("students.txt");
        System.out.println("Students Data\n" + studsAL);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> bYr = new ArrayList<>();
        ArrayList<Integer> sId = new ArrayList<>();
        ArrayList<Boolean> sciMjr = new ArrayList<>();

        for (String s : studsAL) {
            String[] data = s.split(",");
            name.add(data[0]); // store a string
            bYr.add(Integer.parseInt(data[1])); // convert to int
            sId.add(Integer.parseInt(data[2])); // convert to int
            sciMjr.add(Boolean.parseBoolean(data[3]));// convert to bool
        }

        // Create a file 2735.txt to write to
        PrintStream outF = new PrintStream(new File("2735.txt"));
        for (Boolean b : sciMjr) { // write contents of an AL to file
            outF.println(b); // note the use of "println"
        }

        /*
         * TODO 1 - Create a student and display it
         * test out other class methods
         */
        Student s1 = new Student("Earl", 1,23,false);
        System.out.println("Student s1:\t" + s1 + s1.getName());
        s1.setName("Harley");
        System.out.println("Student s1:\t" + s1);

        //Student s2 = s1;
        Student s2 = new Student();
        System.out.println("Student s2:\t" + s2);
        // s2.setName("Festus");
        s2.setName("Earl");
        System.out.println("Student s2:\t" + s2);
        System.out.println("Student s1:\t" + s1);
        // if (s1 == s2){
        //   System.out.println("They are");
        // this does not work. you must use an equals method.



        /*
         * TODO 2 - Create Student objects from the data in the students.txt
         * file and display the objects to the screen and to an output file objects.txt
         */
        ArrayList<Student>sAL = new ArrayList<>();
        for (String s : studsAL){
            String [] data = s.split(",");
            // Student ss = new Student();
            // ss.setName(data[0]);
            // ss.setId(data[1]);
            // ss.setBirthYear(data[2]);
            // ss.setIsSciMaj(data[3]);
            Student sss = new Student(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Boolean.parseBoolean(data[3]));
            sAL.add(sss);
        }
        System.out.println("====Student objs====\n:" + sAL);
        PrintStream ttv = new PrintStream(new File("objects.txt"));// initilizing new printsream object
        for(Student s: sAL){
            ttv.println(s);
        }
        for (Student s:sAL){
            System.out.println(s.getName() + " is " + s.getAge());
        }
    }// main
    // function definitions

    public static ArrayList<String> readDataFromFile(String fName) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        // Attach Scanner to a file to be read from
        Scanner fileRdr = new Scanner(new File(fName));
        while (fileRdr.hasNextLine()) { // file has more data?
            // reads entire line from file
            result.add(fileRdr.nextLine());
            // read a string on line until whitespace encountered
            // result.add(fileRdr.next());
        }
        return result;
    }
}// end of class