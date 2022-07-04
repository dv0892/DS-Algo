package test.app.priortyqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] tasks = {'B','C','D','E','F','G','A','A','A','A','A','A'};
		
		System.out.println( new TaskScheduler().leastIntervalSimplified(tasks, 2));
	}
	
	public int leastInterval(char[] tasks, int n) {
        
		 if ( n == 0 )
	            return tasks.length;
		 
		 Comparator<Task> com = (Task task1, Task task2)->{ 
             if ( task1.cooldown == task2.cooldown ){
                 return task2.count - task1.count;
             } else {
                 return task1.cooldown - task2.cooldown;
             }
		 };
		 PriorityQueue<Task> pq = new PriorityQueue<>(com);
	        
	        short[] taskCount = new short[26];
	        for( char task : tasks ){
	            taskCount[task-'A']++;
	        }
	        
	        // Add the tasks to Priority Queue
	        for( int i=0;i<taskCount.length;i++) {
	    	   if( taskCount[i] > 0)
	    		   pq.add( new Task((char)('A'+i),taskCount[i],0) );
	       }
	       
	       int time = 0;
	       while( pq.size() > 0 ){
	    	   
	    	   Task highestPriorityTask = pq.remove();
	    	   
	    	   if( highestPriorityTask.cooldown == 0 )   {
	    		   highestPriorityTask.count--;
	    		   if( highestPriorityTask.count > 0 ){
	            	   highestPriorityTask.cooldown = n+1;
	                    pq.add(highestPriorityTask);
	               }
	    	   } else {
	    		   pq.add(highestPriorityTask);
	    	   }
	    	   
	    	   for( Task t : pq ) {
	    		   if( t.cooldown > 0 )
	    			   t.cooldown--;
	    	   }
	    	   
	    	   /*Task[] t = new Task[pq.size()];
	    	   int i=0;
	    	   while ( !pq.isEmpty() ) {
	    		   t[i++] = pq.remove();
	    	   }
	    	   
	    	   
	    	   for (Task t1 : t) {
	    		   pq.add(t1);
	    	   }*/
	    	   
	    	   int size = pq.size();
	    	   while ( size-- > 0) {
	    		   pq.add(pq.remove());
	    	   }
	    	   
	    	   time++;
		   }	
	        
	       return time;
        
    }

	
	
	public int leastIntervalSimplified(char[] tasks, int n) {
        
		 if ( n == 0 )
	            return tasks.length;
		 
		 Comparator<Task> com = (Task task1, Task task2)-> task2.count - task1.count ;	
		 
		 PriorityQueue<Task> pq = new PriorityQueue<>(com);
	        
	        short[] taskCount = new short[26];
	        for( char task : tasks ){
	            taskCount[task-'A']++;
	        }
	        
	        // Add the tasks to Priority Queue
	        for( int i=0;i<taskCount.length;i++) {
	    	   if( taskCount[i] > 0)
	    		   pq.add( new Task((char)('A'+i),taskCount[i],0) );
	       }
	       
	       int time = 0;
	       while( pq.size() > 0 ){
	    	   List<Task> temp = new ArrayList<>();
	    	   for( int i=1;i<=(n+1);i++) {
	    		   if(!pq.isEmpty())
	    			   temp.add(pq.remove());
	    	   }
	    	   
	    	   for ( Task task : temp ) {
	    		   if ( --task.count > 0 )
	    			   pq.add(task);
	    	   }
	    	   
	    	   time += pq.isEmpty() ? temp.size() : n+1;
		   }	
	        
	       return time;
       
   }

	
}

class Task {
    char taskName;
    short count;
    int cooldown ;
    
    public Task( char taskName, short count, int cooldown ){
        this.taskName = taskName;
        this.count = count;
        this.cooldown = cooldown;
    }
}
