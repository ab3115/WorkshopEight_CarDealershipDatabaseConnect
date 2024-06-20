package com.ps;

import com.ps.DAOs.LeaseDAO;
import com.ps.DAOs.SalesDAO;
import com.ps.DAOs.VehicleDAO;
import com.ps.models.LeaseContract;
import com.ps.models.SalesContract;
import com.ps.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static LeaseDAO leaseDAO;
    private static VehicleDAO vehicleDAO;
    private static SalesDAO salesDAO;
    private static Scanner scanner = new Scanner(System.in);

    public static void init(String[] args) {

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership_db");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);

        leaseDAO = new LeaseDAO(basicDataSource);
        salesDAO = new SalesDAO(basicDataSource);
        vehicleDAO = new VehicleDAO(basicDataSource);

    }

    public static void display(String[] args) {

        init(args);

        int input;

        do {

            System.out.println("Welcome! Please choose one of the following:");
            System.out.println("1) Search vehicle");
            System.out.println("2) Add vehicles");
            System.out.println("3) Remove vehicle");
            System.out.println("4) Manage Sales");
            System.out.println("5) Manage Leases");
            System.out.println("0) Exit");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    processSearchVehicles();
                    break;
                case 2:
                    processAddVehicles();
                    break;
                case 3:
                    processRemoveVehicle();
                    break;
                case 4:
                    processManageSales();
                    break;
                case 5:
                    processManageLeases();
                case 0:
                    System.out.println("Exit Dealership");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (input != 0);
    }


    private static void processSearchVehicles(){
        int input;

        do {

            System.out.println("Search Vehicles:");
            System.out.println("1) Show all Vehicles");
            System.out.println("2) Get vehicle by price range");
            System.out.println("3) Get vehicle by Make & Model");
            System.out.println("4) Get vehicle by year range");
            System.out.println("5) Get vehicle by color");
            System.out.println("6) Get vehicle by mileage");
            System.out.println("7) Get vehicle by type");
            System.out.println("0) Return");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {

                case 1:

                    List<Vehicle> vehicle_list = vehicleDAO.getAllVehicles();

                    for (Vehicle vehicle: vehicle_list) {
                        System.out.println(vehicle);
                    }

                    break;

                case 3:

                    System.out.println("Enter make:");
                    String make = scanner.nextLine();
                    System.out.println("Enter model:");
                    String model = scanner.nextLine();
                    List<Vehicle> vehiclesByMakeModel = vehicleDAO.getVehiclesByMakeModel(make, model);
                    vehiclesByMakeModel.forEach(System.out::println);
                    break;

                case 4:

                    System.out.println("Enter min year:");
                    int min = scanner.nextInt();
                    System.out.println("Enter max year:");
                    int max = scanner.nextInt();
                    List<Vehicle> vehiclesByYearRange = vehicleDAO.getVehiclesByYear(min, max);
                    vehiclesByYearRange.forEach(System.out::println);
                    break;

                case 5:

                    System.out.println("Enter color ");
                    String color = scanner.nextLine();
                    List<Vehicle> vehiclesByColor = vehicleDAO.getVehiclesByColor(color);
                    vehiclesByColor.forEach(System.out::println);
                    break;

                case 6:

                    System.out.println("Enter min mileage:");
                    int minimum = scanner.nextInt();
                    System.out.println("Enter max mileage:");
                    int maximum = scanner.nextInt();
                    List<Vehicle> vehiclesByMileageRange = vehicleDAO.getVehiclesByMileage(minimum, maximum);
                    vehiclesByMileageRange.forEach(System.out::println);
                    break;

                case 7:

                    System.out.println("Enter vehicle type:");
                    String type= scanner.nextLine();
                    List<Vehicle> vehiclesByType = vehicleDAO.getVehiclesByType(type);
                    vehiclesByType.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Going back to last screen");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (input != 0);
    }

    private static void processAddVehicles(){

        System.out.println("Enter vin:");
        int vin = scanner.nextInt();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter type:");
        String type = scanner.nextLine();
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter mileage:");
        int mileage = scanner.nextInt();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        Vehicle vehicle = new Vehicle(vin,year, make, model, type, color, mileage, price);
        vehicleDAO.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    private static void processRemoveVehicle(){
        System.out.print("Enter vehicle vin:");
        int vin = scanner.nextInt();
        vehicleDAO.removeVehicle(vin);
        System.out.println("Vehicle removed successfully!");
    }

    private static void processManageSales(){

    }

    private static void processManageLeases() {

    }

}
