package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<AddressModel, Long> {
}
