package com.finzly.csvapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finzly.csvapplication.model.MarginedRates;

@Repository
public interface MarginedRatesRepository extends JpaRepository<MarginedRates,Integer> {

}
