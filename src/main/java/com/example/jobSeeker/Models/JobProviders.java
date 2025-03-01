package com.example.jobSeeker.Models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class JobProviders {
	
	
	@Override
	public String toString() {
		return "JobProviders [JobProviderid=" + JobProviderid + ", JobProvidercompanyName=" + JobProvidercompanyName
				+ ", JobProvidercompanyIndustry=" + JobProvidercompanyIndustry + ", JobProviderJobtitle="
				+ JobProviderJobtitle + ", JobProviderDescription=" + JobProviderDescription
				+ ", JobProviderRequiredSkills=" + JobProviderRequiredSkills + ", JobProviderExperienceLevel="
				+ JobProviderExperienceLevel + ", JobProviderPackageRange=" + JobProviderPackageRange
				+ ", JobProviderEmail=" + JobProviderEmail + ", JobProviderJobPostedDate=" + JobProviderJobPostedDate
				+ ", JobProviderApplicationDeadline=" + JobProviderApplicationDeadline + ", JobProviderLocation="
				+ JobProviderLocation + "]";
	}

	public JobProviders() {
		
	}
	
	public JobProviders(int jobProviderid, String jobProvidercompanyName, String jobProvidercompanyIndustry,
			String jobProviderJobtitle, String jobProviderDescription, String jobProviderRequiredSkills,
			String jobProviderExperienceLevel, String jobProviderPackageRange, String jobProviderEmail,
			LocalDate jobProviderJobPostedDate, LocalDate jobProviderApplicationDeadline, String jobProviderLocation) {
		
		JobProviderid = jobProviderid;
		JobProvidercompanyName = jobProvidercompanyName;
		JobProvidercompanyIndustry = jobProvidercompanyIndustry;
		JobProviderJobtitle = jobProviderJobtitle;
		JobProviderDescription = jobProviderDescription;
		JobProviderRequiredSkills = jobProviderRequiredSkills;
		JobProviderExperienceLevel = jobProviderExperienceLevel;
		JobProviderPackageRange = jobProviderPackageRange;
		JobProviderEmail = jobProviderEmail;
		JobProviderJobPostedDate = jobProviderJobPostedDate;
		JobProviderApplicationDeadline = jobProviderApplicationDeadline;
		JobProviderLocation = jobProviderLocation;
	}
	public int getJobProviderid() {
		return JobProviderid;
	}
	public void setJobProviderid(int jobProviderid) {
		JobProviderid = jobProviderid;
	}
	public String getJobProvidercompanyName() {
		return JobProvidercompanyName;
	}
	public void setJobProvidercompanyName(String jobProvidercompanyName) {
		JobProvidercompanyName = jobProvidercompanyName;
	}
	public String getJobProvidercompanyIndustry() {
		return JobProvidercompanyIndustry;
	}
	public void setJobProvidercompanyIndustry(String jobProvidercompanyIndustry) {
		JobProvidercompanyIndustry = jobProvidercompanyIndustry;
	}
	public String getJobProviderJobtitle() {
		return JobProviderJobtitle;
	}
	public void setJobProviderJobtitle(String jobProviderJobtitle) {
		JobProviderJobtitle = jobProviderJobtitle;
	}
	public String getJobProviderDescription() {
		return JobProviderDescription;
	}
	public void setJobProviderDescription(String jobProviderDescription) {
		JobProviderDescription = jobProviderDescription;
	}
	public String getJobProviderRequiredSkills() {
		return JobProviderRequiredSkills;
	}
	public void setJobProviderRequiredSkills(String jobProviderRequiredSkills) {
		JobProviderRequiredSkills = jobProviderRequiredSkills;
	}
	public String getJobProviderExperienceLevel() {
		return JobProviderExperienceLevel;
	}
	public void setJobProviderExperienceLevel(String jobProviderExperienceLevel) {
		JobProviderExperienceLevel = jobProviderExperienceLevel;
	}
	public String getJobProviderPackageRange() {
		return JobProviderPackageRange;
	}
	public void setJobProviderPackageRange(String jobProviderPackageRange) {
		JobProviderPackageRange = jobProviderPackageRange;
	}
	public String getJobProviderEmail() {
		return JobProviderEmail;
	}
	public void setJobProviderEmail(String jobProviderEmail) {
		JobProviderEmail = jobProviderEmail;
	}
	public LocalDate getJobProviderJobPostedDate() {
		return JobProviderJobPostedDate;
	}
	public void setJobProviderJobPostedDate(LocalDate jobProviderJobPostedDate) {
		JobProviderJobPostedDate = jobProviderJobPostedDate;
	}
	public LocalDate getJobProviderApplicationDeadline() {
		return JobProviderApplicationDeadline;
	}
	public void setJobProviderApplicationDeadline(LocalDate jobProviderApplicationDeadline) {
		JobProviderApplicationDeadline = jobProviderApplicationDeadline;
	}
	public String getJobProviderLocation() {
		return JobProviderLocation;
	}
	public void setJobProviderLocation(String jobProviderLocation) {
		JobProviderLocation = jobProviderLocation;
	}
	
	@Id
	@GeneratedValue
	private int JobProviderid;
	private String JobProvidercompanyName;
	private String JobProvidercompanyIndustry;
	private String JobProviderJobtitle;
	private String JobProviderDescription;
	@Column(columnDefinition = "TEXT")
	private String JobProviderRequiredSkills;
	private String JobProviderExperienceLevel;
	@Column(columnDefinition = "TEXT")
	private String JobProviderPackageRange;
	private String JobProviderEmail;
	private LocalDate JobProviderJobPostedDate;
	private LocalDate JobProviderApplicationDeadline;
	private String JobProviderLocation;
	
	 @ManyToMany(mappedBy = "jobSeekerAppliedJobs") // This should match the field name in JobSeekers
	 @JsonIgnore
	 private List<JobSeekers> jobSeekersList;

	public List<JobSeekers> getJobSeekersList() {
		return jobSeekersList;
	}

	public void setJobSeekersList(List<JobSeekers> jobSeekersList) {
		this.jobSeekersList = jobSeekersList;
	}


	
	
}
