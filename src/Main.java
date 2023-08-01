import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner s = new Scanner(System.in);
        String input;
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

        try{// load previous file if available
            manager.loadFile();
        }catch (FileNotFoundException e){
            System.out.println("No file found");

        }

        do{
            System.out.println("---------------------------------------------");
            System.out.println("Welcome to Westminster Skin Consultation Manager");
            System.out.println("---------------------------------------------");
            System.out.println("Enter A to add doctor: ");
            System.out.println("Enter D to delete doctor: ");
            System.out.println("Enter P to print doctor list: ");
            System.out.println("Enter S to save the file:");
            System.out.println("Enter G to open GUI");
            System.out.println("Enter Q to quit program");
            System.out.println(" ");

            input = s.next().toUpperCase();
            switch (input) {
                case ("A"):
                    manager.addDoctor();
                    break;
                case ("D"):
                    manager.deleteDoctor();
                    break;
                case ("P"):
                    manager.printDoctor();
                    break;
                case ("S"):
                    manager.saveFile();
                    break;
                case ("G"):
                    manager.loadGUI();

                    break;
                case("Q"):
                    System.out.println("Program Ending.....:(((");
                    break;
            }
        }while(!input.equals("Q"));

    }
}






//