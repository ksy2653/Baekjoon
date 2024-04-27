package DFS.Q2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	static int count=0;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/Baekjoon2606/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		DFS(1);
		System.out.println(count);
	}
	
	public static void DFS(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false) {
				count++;
				DFS(i);
			}
		}
	}

}
