package practice;

import java.util.Scanner;

public class merge_sort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x[]=new int [n];
		for (int i = 0; i < n; i++) {
			x[i]=sc.nextInt();
		}
		System.out.println(maxProfit(x));

		
		
	}
	public static int [] sortmerge(int x []) {
		if (x.length==1) {
			return x;
		}
		int temp1[]=new int [x.length/2];
		int temp2[]=new int [x.length-x.length/2];
		for (int i = 0; i < x.length; i++) {
			if (i<x.length/2) {
				temp1[i]=x[i];
			}else {
				temp2[i-x.length/2]=x[i];
			}
		}
		 temp1=sortmerge(temp1);
		 temp2=sortmerge(temp2);
		 int sol[]=new int[x.length];
		 int j=0;
		 int k=0;
		for (int i = 0; i < sol.length; i++) {
			if (j==temp1.length) {
				sol[i]=temp2[k++];
				continue;
			}
			if (k==temp2.length) {
				sol[i]=temp1[j++];
				continue;
			}
			if (temp1[j]<temp2[k]) {
				sol[i]=temp1[j++];
			}else {
				sol[i]=temp2[k++];
			}
		}
		return sol;
	}
	 public static int maxProfit(int[] prices) {
	        int sol=0;
	        int count[]=new int [prices.length];
	        for(int i=prices.length-1;i>=0;i--){
	            for(int j=i;j<prices.length;j++){
	                count[i]=Math.max(sol,(count[j]+(prices[j]-prices[i])));
	                sol=Math.max(count[i],sol);
	            }
	        }
	        return sol;
	    }


}
