package com.mytests.spring;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.Transactional;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PersonRepository extends CrudRepository<Person,Integer> {

     // no parameters are suggested by IDEA, no errors are shown in case of some parameters missing
     // 1. require parameter matching 'update' properties
     // 2. require some @Id or @Version-annotated parameter
     @Transactional
     void updateRetired(@Id Integer id, boolean retired);

     // IDEA requires and suggests only parameters matching 'by' clause
     @Transactional
     void updateRetiredByAgeGreaterThan(int age, boolean retired);

     // returning suffix is not supported
     @Transactional
     List<Person> updateAgeBySurnameReturning(String lastName, int age);

     @Transactional
     @Query("insert into jbtests.person(first_name, last_name, age) values (:name, :surname, :age)")
     Person customSave(String name, String surname, int age);
}
