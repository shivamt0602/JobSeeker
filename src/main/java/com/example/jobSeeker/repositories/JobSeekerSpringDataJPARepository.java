package com.example.jobSeeker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobSeeker.Models.JobSeekers;

@Repository
public interface JobSeekerSpringDataJPARepository extends JpaRepository<JobSeekers,Integer>{

}
