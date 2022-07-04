package test.app.stack;

import test.app.utils.Utils;

public class NoOfStudentsUnableToEatLunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new NoOfStudentsUnableToEatLunch().countStudents( new int[] {1,1,1,0}, new int[] { 0,1,0,1} ) );
	}
	
	 public int countStudents(int[] students, int[] sandwiches) {
		 
		 	/*
		 	 *  Since sandwiches are stacked, so only the top one can be picked.
		 	 *  Now the students are queued so if the  student at front of queue
		 	 *  can't pick a sandwich we will try with next one( by dequeuing it and enqueue it.)
		 	 *  and keep on doing it until we have got back to first student again.
		 	 *  If we have got back to first student again this means :
		 	 *  1. No one got their preferred choice of sandwich.
		 	 *  Simply return the no of students lying in the queue.
		 	 *  
		 	 *  If some one got their favorite sandwich in between : 
		 	 *  1. Then we will pick student choice and place it at end of queue.
		 	 *  And decrease the size of queue.
		 	 *  
		 	 *  We will keep on repeating this until no of students are zero.
		 	 *  
		 	 *  
		 	 */
		 
	        
	        int s = 0;
	        int studentsCt = students.length;
	        
	        while(studentsCt > 0){
	            
	            int i=0;
	            for( ;i<studentsCt; i++){
	                if( students[i] == sandwiches[s] )
	                    break;
	            }
	            
	            if(i == studentsCt){
	                return studentsCt;
	            }
	            
	            Utils.swap(students,i,studentsCt-1);
	            
	            studentsCt--;
	            s++;
	        }
	        
	        return 0;
	    }

}
