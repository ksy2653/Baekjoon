package DFS.Q4963;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int MAX = 60;
	static int w,h;
	static boolean[][] visited, island;
	static int[] dx = {0,0,-1,1,-1,-1,1,1};
	static int[] dy = {-1,1,0,0,-1,1,-1,1};
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0;i<8;i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			if(!visited[newY][newX] && island[newY][newX]) {
				dfs(newY,newX);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/DFS/Q4963/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0)
				return;
			
			visited = new boolean[MAX][MAX];
			island = new boolean[MAX][MAX];
			int island_count=0;
			
			for(int i=1;i<=h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=w;j++) {
					island[i][j] = st.nextToken().charAt(0) == '1';
				}
			}
			
			for(int i=1;i<=h;i++) {
				for(int j=1;j<=w;j++) {
					if(!visited[i][j] && island[i][j]) {
						island_count++;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(island_count);
		}

	}

}
