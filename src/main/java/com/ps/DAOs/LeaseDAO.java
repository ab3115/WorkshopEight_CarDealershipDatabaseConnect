package com.ps.DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.ps.DAOs.interfaces.LeaseInt;
import com.ps.models.LeaseContract;
import org.apache.commons.dbcp2.BasicDataSource;


public class LeaseDAO implements LeaseInt {

    private BasicDataSource dataSource;

    public LeaseDAO(BasicDataSource basicDataSource) {
        this.dataSource = basicDataSource;
    }

    @Override
    public List<LeaseContract> getAllLeaseContracts() {
        return List.of();
    }

    @Override
    public int createLease(LeaseContract lease) {
        return 0;
    }

    @Override
    public void deleteLease(int id) {

    }
}
