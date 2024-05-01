package DFS.Q2023;

import java.util.Scanner;

public class Main {
	
	static int N, primeNum;
	
	static boolean isPrime(int num) {
		if(num<=1)
			return false;
		for(int i=2;i<num;i++) {
			if(num%i == 0)
				return false;
		}
		
		return true;
	}
	
	static void dfs(int num, int jarisu) {
		if(N < 1)
			return;
		
		if(jarisu==N)
			System.out.println(num);
		else {
			for(int i=0;i<10;i++) {
				int temp = 10*num + i;
				if(isPrime(temp))
				{
					dfs(temp,jarisu+1);
				}
					
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dfs(0,0);
	}

}
