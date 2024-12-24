package com.sst.sst_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sst.sst_models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
