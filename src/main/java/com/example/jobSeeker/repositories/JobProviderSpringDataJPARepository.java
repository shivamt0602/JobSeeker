package com.example.jobSeeker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobSeeker.Models.JobProviders;

@Repository
public interface JobProviderSpringDataJPARepository extends JpaRepository<JobProviders,Integer>{

}
