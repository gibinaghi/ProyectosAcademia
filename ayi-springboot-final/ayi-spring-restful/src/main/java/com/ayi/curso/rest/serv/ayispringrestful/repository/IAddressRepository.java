package com.ayi.curso.rest.serv.ayispringrestful.repository;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
