package com.ps.DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ps.DAOs.interfaces.SalesInt;
import com.ps.DAOs.interfaces.VehicleInt;
import com.ps.models.SalesContract;
import com.ps.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;


public class SalesDAO implements SalesInt {
    private BasicDataSource dataSource;

    public SalesDAO(BasicDataSource basicDataSource) {
        this.dataSource = basicDataSource;
    }

    @Override
    public List<SalesContract> getAllSales() {
        return List.of();
    }

    @Override
    public int createSale(SalesContract sale) {
        return 0;
    }

    @Override
    public void deleteSale(int id) {

    }
}
