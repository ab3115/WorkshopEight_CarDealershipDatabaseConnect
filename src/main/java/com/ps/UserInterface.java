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
    }

    private static void processSearchVehicles(){

    }

    private static void processAddVehicles(){

    }

    private static void prccessManageSales(){

    }




}
