package com.example.jobSeeker.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
public class JobSeekers {
	
	public JobSeekers() {
		
	}
	
	public JobSeekers(int jobSeekerid, String jobSeekername, String jobSeekerresume, String jobSeekeremail,
			String jobSeekerphoneNumber, String jobSeekerCurrentJob, int jobSeekerExperienceInYears,
			int jobSeekerExperienceInMonths,String jobSeekerSkills, int jobSeekerPreferredRole,
			String jobSeekerPreferredPackageRange, String jobSeekerPreferredLocation,
			List<JobProviders> jobSeekerAppliedJobs, List<JobProviders> jobSeekerAvailableJobs) {
		super();
		this.jobSeekerid = jobSeekerid;
		this.jobSeekername = jobSeekername;
		this.jobSeekerresume = jobSeekerresume;
		this.jobSeekeremail = jobSeekeremail;
		this.jobSeekerphoneNumber = jobSeekerphoneNumber;
		this.jobSeekerCurrentJob = jobSeekerCurrentJob;
		this.jobSeekerExperienceInYears = jobSeekerExperienceInYears;
		this.jobSeekerExperienceInMonths = jobSeekerExperienceInMonths;
		this.jobSeekerSkills = jobSeekerSkills;
		this.jobSeekerPreferredRole = jobSeekerPreferredRole;
		this.jobSeekerPreferredPackageRange = jobSeekerPreferredPackageRange;
		this.jobSeekerPreferredLocation = jobSeekerPreferredLocation;
		this.jobSeekerAppliedJobs = jobSeekerAppliedJobs;
		this.jobSeekerAvailableJobs = jobSeekerAvailableJobs;
	}
	@Override
	public String toString() {
		return "JobSeekers [jobSeekerid=" + jobSeekerid + ", jobSeekername=" + jobSeekername + ", jobSeekerresume="
				+ jobSeekerresume + ", jobSeekeremail=" + jobSeekeremail + ", jobSeekerphoneNumber="
				+ jobSeekerphoneNumber + ", jobSeekerCurrentJob=" + jobSeekerCurrentJob
				+ ", jobSeekerExperienceInYears=" + jobSeekerExperienceInYears + ", jobSeekerExperienceInMonths="
				+ jobSeekerExperienceInMonths + ", jobSeekerSkills=" + jobSeekerSkills + ", jobSeekerPreferredRole="
				+ jobSeekerPreferredRole + ", jobSeekerPreferredPackageRange=" + jobSeekerPreferredPackageRange
				+ ", jobSeekerPreferredLocation=" + jobSeekerPreferredLocation + ", jobSeekerAppliedJobs="
				+ jobSeekerAppliedJobs + ", jobSeekerAvailableJobs=" + jobSeekerAvailableJobs + "]";
	}
	public int getJobSeekerid() {
		return jobSeekerid;
	}
	public void setJobSeekerid(int jobSeekerid) {
		this.jobSeekerid = jobSeekerid;
	}
	public String getJobSeekername() {
		return jobSeekername;
	}
	public void setJobSeekername(String jobSeekername) {
		this.jobSeekername = jobSeekername;
	}
	public String getJobSeekerresume() {
		return jobSeekerresume;
	}
	public void setJobSeekerresume(String jobSeekerresume) {
		this.jobSeekerresume = jobSeekerresume;
	}
	public String getJobSeekeremail() {
		return jobSeekeremail;
	}
	public void setJobSeekeremail(String jobSeekeremail) {
		this.jobSeekeremail = jobSeekeremail;
	}
	public String getJobSeekerphoneNumber() {
		return jobSeekerphoneNumber;
	}
	public void setJobSeekerphoneNumber(String jobSeekerphoneNumber) {
		this.jobSeekerphoneNumber = jobSeekerphoneNumber;
	}
	public String getJobSeekerCurrentJob() {
		return jobSeekerCurrentJob;
	}
	public void setJobSeekerCurrentJob(String jobSeekerCurrentJob) {
		this.jobSeekerCurrentJob = jobSeekerCurrentJob;
	}
	public int getJobSeekerExperienceInYears() {
		return jobSeekerExperienceInYears;
	}
	public void setJobSeekerExperienceInYears(int jobSeekerExperienceInYears) {
		this.jobSeekerExperienceInYears = jobSeekerExperienceInYears;
	}
	public int getJobSeekerExperienceInMonths() {
		return jobSeekerExperienceInMonths;
	}
	public void setJobSeekerExperienceInMonths(int jobSeekerExperienceInMonths) {
		this.jobSeekerExperienceInMonths = jobSeekerExperienceInMonths;
	}
	public String getJobSeekerSkills() {
		return jobSeekerSkills;
	}
	public void setJobSeekerSkills(String jobSeekerSkills) {
		this.jobSeekerSkills = jobSeekerSkills;
	}
	public int getJobSeekerPreferredRole() {
		return jobSeekerPreferredRole;
	}
	public void setJobSeekerPreferredRole(int jobSeekerPreferredRole) {
		this.jobSeekerPreferredRole = jobSeekerPreferredRole;
	}
	public String getJobSeekerPreferredPackageRange() {
		return jobSeekerPreferredPackageRange;
	}
	public void setJobSeekerPreferredPackageRange(String jobSeekerPreferredPackageRange) {
		this.jobSeekerPreferredPackageRange = jobSeekerPreferredPackageRange;
	}
	public String getJobSeekerPreferredLocation() {
		return jobSeekerPreferredLocation;
	}
	public void setJobSeekerPreferredLocation(String jobSeekerPreferredLocation) {
		this.jobSeekerPreferredLocation = jobSeekerPreferredLocation;
	}
	public List<JobProviders> getJobSeekerAppliedJobs() {
		return jobSeekerAppliedJobs;
	}
	public void setJobSeekerAppliedJobs(List<JobProviders> jobSeekerAppliedJobs) {
		this.jobSeekerAppliedJobs = jobSeekerAppliedJobs;
	}
	public List<JobProviders> getJobSeekerAvailableJobs() {
		return jobSeekerAvailableJobs;
	}
	public void setJobSeekerAvailableJobs(List<JobProviders> jobSeekerAvailableJobs) {
		this.jobSeekerAvailableJobs = jobSeekerAvailableJobs;
	}
	@Id
	@GeneratedValue
	private int jobSeekerid;
	private String jobSeekername;
	private String jobSeekerresume;
	private String jobSeekeremail;
	private String jobSeekerphoneNumber;
	private String jobSeekerCurrentJob;
	private int jobSeekerExperienceInYears;
	private int jobSeekerExperienceInMonths;
	
	@Column(columnDefinition = "TEXT")
	private String jobSeekerSkills;
	private int jobSeekerPreferredRole;
	@Column(columnDefinition = "TEXT")
	private String jobSeekerPreferredPackageRange;
	private String jobSeekerPreferredLocation;
	
	@ManyToMany
    @JoinTable(
        name = "job_applications",
        joinColumns = @JoinColumn(name = "job_seeker_id"),
        inverseJoinColumns = @JoinColumn(name = "job_provider_id")
    )
	@JsonIgnore
	private List<JobProviders> jobSeekerAppliedJobs;
	
	
	@ManyToMany
	@JsonIgnore
	private List<JobProviders> jobSeekerAvailableJobs;
	
//	private 
	
}
