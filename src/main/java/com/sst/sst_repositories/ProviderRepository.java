package com.sst.sst_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sst.sst_models.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
