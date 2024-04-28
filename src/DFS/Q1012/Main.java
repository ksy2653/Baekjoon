package DFS.Q1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T,M,N,K;
	static boolean[][] visited;
	static boolean[][] cabbage;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int count;
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0;i<4;i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			if(!visited[newY][newX] && cabbage[newY][newX])
				dfs(newY,newX);
		}
	}

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/DFS/Q1012/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			visited = new boolean[100][100];
			cabbage = new boolean[100][100];
			count=0;
			
			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cabbage[y+1][x+1] = true;
			}
			
			for(int row=1;row<=N;row++) {
				for(int col=1;col<=M;col++) {
					if(!visited[row][col] && cabbage[row][col]) {
						dfs(row,col);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}

}
