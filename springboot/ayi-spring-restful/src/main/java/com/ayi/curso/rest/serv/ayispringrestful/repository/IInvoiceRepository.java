package com.ayi.curso.rest.serv.ayispringrestful.repository;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
}
