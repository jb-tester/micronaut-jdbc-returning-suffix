package com.mytests.spring;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.Transactional;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PersonRepository extends CrudRepository<Person,Integer> {

     // https://youtrack.jetbrains.com/issue/IDEA-342390
     // no parameters are suggested by IDEA, no errors are shown in case of some parameters missing
     // 1. require parameter matching 'update' properties
     // 2. require some @Id or @Version-annotated parameter
     @Transactional
     void updateRetired(@Id Integer id, boolean retired);

     // https://youtrack.jetbrains.com/issue/IDEA-342389 -
     // IDEA requires and suggests only parameters matching 'by' clause;
     // https://youtrack.jetbrains.com/issue/IDEA-342391 -
     // the Integer return type is falsely shown as invalid
     @Transactional
     Integer updateRetiredByAgeGreaterThan(int age, boolean retired);

     // https://youtrack.jetbrains.com/issue/IDEA-342393 -
     // returning suffix is not supported: error is reported for the return type
     // and for the suffix itself
     @Transactional
     List<Person> updateAgeBySurnameReturning(String lastName, int age);

     @Transactional
     @Query("insert into jbtests.person(first_name, last_name, age) values (:name, :surname, :age)")
     void customSave(String name, String surname, int age);

     // https://youtrack.jetbrains.com/issue/IDEA-342392
     // erase- and eliminate- prefixes are not suggested
     @Transactional void eraseByAgeGreaterThan(int age);
     @Transactional void eliminateByAgeGreaterThan(int age);

     // https://youtrack.jetbrains.com/issue/IDEA-342391 -
     // Number return type is error-highlighted
     @Transactional int deleteByAge(int age);

}
