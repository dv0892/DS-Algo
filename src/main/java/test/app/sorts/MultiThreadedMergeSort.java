package test.app.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import test.app.linkedlist.MergeNodesInBetweenZeroes;

public class MultiThreadedMergeSort {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Integer> list = Arrays.asList(10,9,8,7,6,5,4,3,2,1);
		ExecutorService service = Executors.newCachedThreadPool();
		
		ParallelMergeSort mergeSort = new ParallelMergeSort(list, service);
		Future<List<Integer>> res = service.submit(mergeSort);
		
		
		System.out.println( res.get());

	}

}

class ParallelMergeSort implements Callable< List<Integer> > {

	List<Integer> vals ;
	ExecutorService service;
	
	public ParallelMergeSort(List<Integer> vals , ExecutorService service ) {
		this.vals = vals;
		this.service = service;
	} 
	
	
	@Override
	public List<Integer> call( ) throws Exception {
		if( vals.size() <= 1 )
			return vals;
		
		int mid = vals.size()/2;
		List<Integer> left = vals.subList(0, mid);
		List<Integer> right = vals.subList(mid, vals.size());
		
		ParallelMergeSort leftSort = new ParallelMergeSort(left, service);
		ParallelMergeSort rightSort = new ParallelMergeSort(right, service);
		
		Future < List<Integer> > futureLeft = service.submit(leftSort);
		Future < List<Integer> > futureRight = service.submit(rightSort);
		
		return MergeNodesInBetweenZeroes( futureLeft, futureRight );
		
	}


	private List<Integer> MergeNodesInBetweenZeroes(Future<List<Integer>> futureLeft,
			Future<List<Integer>> futureRight) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		List<Integer> sortedLeft = futureLeft.get();
		List<Integer> sortedRight = futureRight.get();
		
		List<Integer> sortedList = new ArrayList<>();
        int first = 0;
        int second = 0;
        
     // Compare values from both the arrays
        while (first < sortedLeft.size() && second < sortedRight.size()) {
            // If left is smaller, add to sorted array
            // increment first
            if (sortedLeft.get(first) < sortedRight.get(second)) {
            	sortedList.add(sortedLeft.get(first));
                ++first;
            } else {
                // Add the right one to the sorted array
                // increment second
            	sortedList.add(sortedRight.get(second));
                ++second;
            }
        }

        while (first < sortedLeft.size()) {
        	sortedList.add(sortedLeft.get(first));
            ++first;
        }

        while (second < sortedRight.size()) {
        	sortedList.add(sortedRight.get(second));
            ++second;
        }

        
        return sortedList;
	}
	
}
