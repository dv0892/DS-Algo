package test.app.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import test.app.utils.Job;

public class ActivitySelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Job> jobs =  Arrays.asList( 
				Job.of(1, 4),  Job.of(3, 5),  Job.of(0, 6),
                Job.of(5, 7),  Job.of(3, 8),  Job.of(5, 9),
                Job.of(6, 10), Job.of(8, 11), Job.of(8, 12),
                Job.of(2, 13), Job.of(12, 14) );
		
		Collections.sort(jobs, Comparator.comparingInt( job -> job.finishTime ));
		
		System.out.println( new ActivitySelection().findNonConflictingJobsLengthUsingDP(jobs));
	
		System.out.println( new ActivitySelection().findNonConflictingJobsLengthUsingGreedy(jobs));
	}
	
	
	public  int findNonConflictingJobsLengthUsingDP(List<Job> jobs) {
    
		
		int[] ans = new int[jobs.size()];
		
		for( int i=jobs.size()-1;i>=0;i--) {
			for( int j = i+1; j < jobs.size() ;j++ ) {
				if( jobs.get(j).startTime > jobs.get(i).finishTime && ans[i] < ans[j] )
					ans[i] = ans[j];
			}
			
			ans[i]++;
		}
		
		return Arrays.stream(ans).max().getAsInt();
    }
	
	
	public  int findNonConflictingJobsLengthUsingGreedy(List<Job> jobs) {
		

		int ans = 1;
 		int prev = 0;
		/*
		for( int i=1;i<jobs.size();i++) {
			if( jobs.get(i).startTime > jobs.get(prev).finishTime ) {
				ans++;
				prev= i;
				
			}
		}*/
		
		
		
		// Considering the latest start time
		
		Collections.sort(jobs, Comparator.comparingInt( job -> job.startTime ));
		ans = 1;
		prev = jobs.size()-1;
		for( int i=jobs.size()-2; i>=0; i--) {
			if( jobs.get(i).finishTime < jobs.get(prev).startTime ) {
				ans++;
				prev= i;
				
			}
		}
		
		return ans;
    }

}
