package com.ps.DAOs.interfaces;

import com.ps.models.LeaseContract;

import java.util.List;


public interface LeaseInt {

    List<LeaseContract> getAllLeaseContracts();

    int createLease(LeaseContract lease);

    void deleteLease(int id);

}