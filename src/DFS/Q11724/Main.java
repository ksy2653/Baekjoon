package DFS.Q11724;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static boolean visited[];
	static int M,N;
	static int count=0;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/DFS/Q11724/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);		
		}
		
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.println(count);
	}

	private static void DFS(int v) {
		if(visited[v])
			return;
		
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false)
				DFS(i);
		}
		
	}
	
	

}