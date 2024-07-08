package Main;

import java.io.BufferedReader;		
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	// boolean으로 apart[][], danji[][] 선언
	// house_count로 선언 -> danji_count list에 저장 후 오름차순 배열
	// dfs는 파라미터로 x,y를 받아서 방문 여부 체크 -> dx, dy for문 돌려서 체크
	static int N;
	static boolean apart[][], visited[][];
	static int house;
	static ArrayList<Integer> danji_count;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/Main/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		apart = new boolean[N+1][N+1];
		visited = new boolean[N+1][N+1];
		danji_count = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			String danji_line = br.readLine();
			for(int j=1;j<=N;j++) {
				apart[i][j] =  danji_line.charAt(j-1) == '1';
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!visited[i][j] && apart[i][j]) {
					house=0;
					dfs(i,j);
					danji_count.add(house);
				}
			}
		}
		
		Collections.sort(danji_count);
		System.out.println(danji_count.size());
		for(int i=0;i<danji_count.size();i++) {
			System.out.println(danji_count.get(i));
		}
	}
	
	public static void dfs(int y,int x) {
		if(visited[y][x] || apart[y][x] == false)
			return;
		visited[y][x] = true;
		house++;
		for(int i=0;i<4;i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			if(0<newY && newY<=N && 0<newX && newX <=N &&!visited[newY][newX] && apart[newY][newX]) {
				dfs(newY,newX);
			}
		}
	}

}
