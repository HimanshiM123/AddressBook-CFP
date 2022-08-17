package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAddressRepository extends JpaRepository<AddressModel, Long> {
    Optional<AddressModel> findByEmailId(String emailId);
}
