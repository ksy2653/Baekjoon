package DFS.Q1987;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static boolean[] visited;
	static char[][] alphabet;
	static int max=0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/DFS/Q1987/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[26];
		alphabet = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String alphabet_line = br.readLine();
			for(int j=0;j<C;j++) {
				alphabet[i][j] = alphabet_line.charAt(j);
			}
		}
		
		dfs(0,0,1);
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int count) {
		int index = alphabet[x][y] - 'A';
		if(visited[index])
			return;
		
		max = Math.max(count, max);
		visited[index] = true;
		for(int i=0;i<4;i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(0<=newX && newX<R && 0<=newY && newY<C ) {
				int newIndex = alphabet[newX][newY] - 'A';
				if(!visited[newIndex])
					dfs(newX,newY,count+1);
			}
		}
		
		visited[index] = false;
	}

}
