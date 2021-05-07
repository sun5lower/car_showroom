import cars.Car;
import cars.ShowRoom;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    ShowRoom showRoom = new ShowRoom();
Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
    void showMenu() {

        String userInput = "";
        do {
            System.out.println("Welcome to showroom, please choose activity:");
            System.out.println("1. Add Car");
            System.out.println("2. View all cars");
            System.out.println("3. View Single car");
            System.out.println("4. Remove Car");
            System.out.println("5. Update Car");
            System.out.println("\nEnter Quit to end the program");
            System.out.print("What would you like to do?");
            userInput = scanner.nextLine();

            switch (userInput){
                case "quit":
                    System.out.println("Exiting application...");
                    break;
                case "1":
                    addCar();
                    break;
                case "2":
                    viewAllCars();
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    deleteCar();
                    break;
                case "5":
                    updateCar();
                    break;
                default:
                    break;
            }
            System.out.println("\n Enter C to continue\n");
            scanner.nextLine();
        } while (!userInput.equalsIgnoreCase("quit"));
        return;
    }

    void addCar(){
        System.out.println("\nAdd car");

         Car car = new Car();
        System.out.println("Enter name");
        car.name = scanner.nextLine();

        System.out.println("Enter Manufacturer");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter Type");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String message = showRoom.addCar(car);


        System.out.println(message);

    }

    void viewAllCars(){
        ArrayList<Car> allCars = showRoom.getAllCars();
        System.out.println("\nAll available cars\n");
        System.out.println("Car Name\t Manufacturer\t Car Type");
     int counter = 0;
        for (Car car: allCars){
            System.out.println(counter + ". \t" + car.name + " \t" + car.manufacturer +   " " + car.type);
counter ++;
        }
    }
    void viewSingleCar(){
        System.out.println("View Car\n");
        System.out.println("Enter car ID:");

        int carID = scanner.nextInt();
       Car car = showRoom.getSingleCar(carID);

        System.out.println("Car Name:" + car.name);
        System.out.println("Car Manufacturer:" + car.manufacturer);
        System.out.println("Car Number:" + car.id);
        System.out.println("Car Type:" + car.type);
   }

   void deleteCar(){
       System.out.println("Delete car\n");
       System.out.println("Enter Car Id");

       int carId = scanner.nextInt();
       String message = showRoom.removeCar(carId);
       System.out.println(message);

   }

   void updateCar(){
       Car car = new Car();
       this.viewAllCars();

       System.out.println("Update car");

       System.out.println("Enter car Id");
       int carId = Integer.parseInt(scanner.nextLine());
        scanner.nextInt();
       System.out.println("Enter new name for a car");
       car.name = scanner.nextLine();

       System.out.println("Enter the type for a car");
       car.type = scanner.nextLine();

       System.out.println("Enter the manufacturer for a car");
       car.manufacturer = scanner.nextLine();

       String response = showRoom.updateCar(carId, car);
       System.out.println(response);

   }
}
