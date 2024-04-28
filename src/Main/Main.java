package Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N, danji_count;
	static int MAX = 50;
	static boolean[][] apart, visited;
	static ArrayList<Integer> danji;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0;i<4;i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			if(!visited[newY][newX] && apart[newY][newX]) {
				danji_count++;
				dfs(newY,newX);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/Main/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apart = new boolean[MAX][MAX];
		visited = new boolean[MAX][MAX];
		
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			for(int j=1;j<=N;j++) {
				apart[i][j] = str.charAt(j-1) == '1';
			}
		}
		
		danji = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				danji_count=0;
				if(!visited[i][j] && apart[i][j]) {
					danji_count++;
					dfs(i,j);
					danji.add(danji_count);
				}
				
			}
		}
		Collections.sort(danji);
		
		System.out.println(danji.size());
		for(int i=0;i<danji.size();i++) {
			System.out.println(danji.get(i));
		}
	}

}
