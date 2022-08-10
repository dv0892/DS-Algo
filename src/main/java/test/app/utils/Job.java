package test.app.utils;

public class Job {

	public int startTime;
	public int finishTime;
	
	private Job( int startTime , int finishTime) {
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	public static Job of(int a, int b)
    {
        // calls private constructor
        return new Job(a, b);
    }
}
