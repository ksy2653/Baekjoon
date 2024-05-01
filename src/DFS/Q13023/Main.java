package DFS.Q13023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static ArrayList<Integer>[] friends;
	static boolean[] visited;
	static int result=0;
	
	public static void dfs(int v, int depth) {
		if(depth == 5) {
			result=1;
			return;
		}
		
		visited[v] = true;
		
		for(int i:friends[v]) {
			if(visited[i] == false)
				dfs(i,depth+1);
		}
		
		visited[v] = false;
	}
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/DFS/Q13023/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friends = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			friends[s].add(e);
			friends[e].add(s);
		}
		
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if(result !=1) {
				dfs(i,1);
			}
		}
		System.out.println(result);
		
	}

}
