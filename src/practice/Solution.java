package practice;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    public static void main(String[] args) throws IOException {
     Scanner sc= new Scanner(System.in);
     int n=sc.nextInt();
     BigInteger sol=new BigInteger(1+"");
     for(int i=n;i>0;i--){
         BigInteger temp=new BigInteger(i+"");
         sol=sol.multiply(temp);
     }
     
     System.out.println(sol);
     
	
    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        TreeMap<Integer,Integer> rank_map=new TreeMap();
        int j=1;
        List<Integer> sol=new LinkedList<>();
        int min=(int) 1e9;
        int max=0;
        for(int i=0;i<ranked.size();i++){
            if(!rank_map.containsKey(ranked.get(i))){
                rank_map.put(ranked.get(i), j++);
            }
            min=Math.min(min, ranked.get(i));
            max=Math.max(max, ranked.get(i));
        }
        for(int i=0;i<player.size();i++){
        	int temp =player.get(i);
        	if (temp<min) {
        		sol.add(j);
        	}
        	else {
        		if(temp>max) {
        			sol.add(1);
        		}
        		else {
                    sol.add(rank_map.get(rank_map.floorKey(player.get(i))));
        		}
        	}
        }
        return sol;

        }
}
