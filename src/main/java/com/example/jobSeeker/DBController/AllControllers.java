package com.example.jobSeeker.DBController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.jobSeeker.Models.JobProviders;
import com.example.jobSeeker.Models.JobSeekers;
import com.example.jobSeeker.Servlets.AIServicetoSendEmail;
import com.example.jobSeeker.Servlets.EmailService;
import com.example.jobSeeker.Servlets.MatchingAlgorithmService;
import com.example.jobSeeker.repositories.JobProviderSpringDataJPARepository;
import com.example.jobSeeker.repositories.JobSeekerSpringDataJPARepository;

@RestController
public class AllControllers {

	@Autowired
	AIServicetoSendEmail AiChatService;

	@Autowired
	EmailService emailService;

	@Autowired
	MatchingAlgorithmService matchingAlgoService;

	@Autowired
	private JobSeekerSpringDataJPARepository jobseekerRepo;

	@Autowired
	private JobProviderSpringDataJPARepository jobproviderRepo;

	@PostMapping("/AddJobSeeker")
	public void AddjobSeeker(@RequestBody JobSeekers jobseekerDetails) {
		jobseekerRepo.save(jobseekerDetails);
	}

	@PostMapping("/AddJobProvider")
	public void AddjobProvider(@RequestBody JobProviders jobproviderDetails) {
		jobproviderRepo.save(jobproviderDetails);
	}

	@GetMapping("/GetAvailableJobs/{job_seeker_id}")
	public List<JobProviders> ReturnAvailableJobs(@PathVariable int job_seeker_id) {
		// make a seApplyforJobrvice which matches the available jobs with skill set
		Optional<JobSeekers> current_jobSeekerOptional = jobseekerRepo.findById(job_seeker_id);
		JobSeekers jobSeeker = current_jobSeekerOptional.get();
		List<JobProviders> AllJobsinDB = jobproviderRepo.findAll();
		return matchingAlgoService.returnAllAvailableJobs(jobSeeker, AllJobsinDB);
	}

	@PostMapping("/ApplyforJob/{job_seeker_id}")
	public void ApplyForJob(@PathVariable int job_seeker_id, @RequestBody JobProviders jobDetails) {
		Optional<JobSeekers> current_jobSeekerOptional = jobseekerRepo.findById(job_seeker_id);
		JobSeekers jobSeeker = current_jobSeekerOptional.get();
		// adding the job seekers here 
		if(jobDetails.getJobSeekersList() == null) {//there are no job seekers for that particular job providers
			jobDetails.setJobSeekersList(new ArrayList<>());
		}
		
		// add a check here to check if the list already contains the jobs
		 boolean alreadyApplied = jobDetails.getJobSeekersList().stream()
		            .anyMatch(seeker -> seeker.getJobSeekerid() == jobSeeker.getJobSeekerid());
		 
		 
		jobSeeker.getJobSeekerAppliedJobs().add(jobDetails);
		jobDetails.getJobSeekersList().add(jobSeeker);
		
		
		System.out.println("job seekers for the particular job provider"+jobDetails.getJobSeekersList().toString());
		//
		jobproviderRepo.save(jobDetails);
		jobseekerRepo.save(jobSeeker);
		// trigger an email to the HR, here the subject and description would change and
		// it will be taken from open-ai API
		String subject = String.format("Aspiring %s Eager to Contribute to %s", jobDetails.getJobProviderJobtitle(),
				jobDetails.getJobProvidercompanyName());
		String EmailRequestPrompt = String.format("""
				I want you to write an email to the recruiter which is basically a cold email
				asking to seek a job that is being posted on my behalf.

				My name is %s, and my skills are %s.
				This is my current job: %s.
				I have %s years of experience.

				Here is my resume link: %s.
				Also the recruiter's company name is %S
				the company preferred role is %s
				, the disclaimer is that only construct the email based on all
				the things which are being provided to you and nothing more, because based on your
				response, it will go to the recruiter, also do not send any subject just send the content
				of what I will write and also maybe format it just like how to write in any email conversation
				""", jobSeeker.getJobSeekername(), jobSeeker.getJobSeekerSkills(), jobSeeker.getJobSeekerCurrentJob(),
				jobSeeker.getJobSeekerExperienceInYears(), jobSeeker.getJobSeekerresume(),
				jobDetails.getJobProvidercompanyName(), jobDetails.getJobProviderJobtitle());

		String Email_Description = AiChatService.getChatReplies(EmailRequestPrompt);
		System.out.println("the email description is here" + Email_Description);

		// here the to paramater will be jobDetails.getJobProviderEmail()
		emailService.sendEmail("shivamtirmare@gmail.com", subject, Email_Description);
	}

	@GetMapping("/GetJobSeekers/{jobProviderId}")
	public List<JobSeekers> returnJobSeekers(@PathVariable int jobProviderId) {
	    Optional<JobProviders> jobProviderOptional = jobproviderRepo.findById(jobProviderId);
	    if (jobProviderOptional.isPresent()) {
	        JobProviders jobProvider = jobProviderOptional.get();
	        return jobProvider.getJobSeekersList();
	    }
	    return new ArrayList<>();  // Return empty list if job provider not found
	}
}
