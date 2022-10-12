package com.ayi.curso.rest.serv.ayispringrestful.repository;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    //List user like title
    @Query(value = "select u from  Users u where u.name like  %?1% ")
    List<Users> findByName(String name);

}
