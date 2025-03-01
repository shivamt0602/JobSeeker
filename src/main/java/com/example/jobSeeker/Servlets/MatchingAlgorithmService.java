package com.example.jobSeeker.Servlets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobSeeker.Models.JobProviders;
import com.example.jobSeeker.Models.JobSeekers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MatchingAlgorithmService {
	
	
	
	public List<JobProviders> returnAllAvailableJobs(JobSeekers jobseeker, List<JobProviders> allJobsinDB){
		
		List<JobProviders> allAvailableJobs = new ArrayList<>();
		String skillSet = jobseeker.getJobSeekerSkills();
		System.out.println("skillset of the job seekere is here"+skillSet);
		ObjectMapper objectMapper = new ObjectMapper();
		List<String> skillsList = null;
		HashSet<String> skillsetOfJobSeeker = new HashSet<>();
		try {
			skillsList = objectMapper.readValue(skillSet, new TypeReference<List<String>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(String skill : skillsList) {
			skillsetOfJobSeeker.add(skill);
		}
		System.out.println("skillset as in list"+skillsList);
		
		for(int i=0;i<allJobsinDB.size();i++) {
			
			JobProviders job_provider = allJobsinDB.get(i);
			List<String> job_providers_skills = null;
			String job_providers_skills_inString = job_provider.getJobProviderRequiredSkills();
			
			try {
				job_providers_skills = objectMapper.readValue(job_providers_skills_inString, new TypeReference<List<String>>() {});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("job provider skill number"+i);
			System.out.println("job provider skill here"+job_providers_skills);
			
			for(String skill : job_providers_skills) {
				if(skillsetOfJobSeeker.contains(skill)) {
					allAvailableJobs.add(job_provider);
					break;
				}
			}
			
		}
		
		
		
		return allAvailableJobs;
	}
	
}
