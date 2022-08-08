package com.spring.student.repository;

import com.spring.student.model.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<students,String> {
    List<students> findByNameLike(String name);
    Optional<students> findByIdStudent(long idStudent);
    void deleteByIdStudent(long idStudent);


    @Query(value = "select * from students",nativeQuery = true)
    List<students> findAllstudents();

    @Query(value="select * from students where name = ?1",nativeQuery = true)
    List<students> findstudentsByName(String name);

    @Query(value="select * from students where id_student = ?1",nativeQuery = true)
    Optional<students> findStudentsById(long idStudent);

    @Query(value="delete * from students where id_student = ?1",nativeQuery = true)
    void deleteStudentById(long idStudent);

}
