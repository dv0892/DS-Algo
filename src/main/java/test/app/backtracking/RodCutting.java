package test.app.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.app.dp.RodCuttingDP;

public class RodCutting {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rodLen = 7;
		
		System.out.println( new RodCutting().findMaxRevenue(0,0,rodLen));
		System.out.println( new RodCuttingDP(rodLen).findMaxRevenueImprovedByDP(rodLen));
		System.out.println( new RodCuttingDP(rodLen).findMaxRevenueImprovedByDPUsingBottomUp(rodLen));
		System.out.println( new RodCuttingDP(rodLen).findMaxRevenueImprovedByDPUsingBottomUpWithCuts(rodLen));
	}
	
	int[] pricetable = { 0,1,5,8,9,10,17,17,20,24,30 };
	
	public int findMaxRevenue( int price , int lastChoice , int rodLength ) {
		/*
		 * Here we are moving towards each possible solution in DFS manner 
		 * As we are doing DFS, we are solving a lot of Sub-problems again and again.
		 * This can be improved by using DP ( saving the result of Sub-problem once it is solved).
		 * We are exploring all the solutions using backtracking.
		 * 
		 */
		
		if( rodLength == 0 )
			return price;
		
		int max=Integer.MIN_VALUE;
		if( rodLength >= lastChoice ) {
			int choice = Math.max(1, lastChoice);
			
			while( choice <= rodLength ) {
				
				price += pricetable[choice];
				
				max = Math.max(max, findMaxRevenue(price, choice, rodLength - choice));
				
				price -= pricetable[choice++];
			}
		}
		
		return max;
	}
	
	
}
