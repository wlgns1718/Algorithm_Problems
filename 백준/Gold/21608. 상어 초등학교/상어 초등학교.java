import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int N, dx[] = {1,-1,0,0}, dy[] = {0,0,1,-1};
    static List<List<Integer>> ls = new ArrayList<>();
    static class Info{
        int empty;
        int like;
        int x;
        int y;
        public Info(int x, int y, int like, int empty){
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N * N; i++){
            ls.add(new ArrayList<>());
        }

        String[] input;
        for(int i = 0; i < N * N; i++){
            input = br.readLine().split(" ");
            int student = Integer.parseInt(input[0]);
            for(int idx = 1; idx <= 4; idx++){
                ls.get(student - 1).add(Integer.parseInt(input[idx]));
            }
            sol(student);
        }
        System.out.println(cal());

    }

    private static void sol(int num) {
        PriorityQueue<Info> queue = new PriorityQueue<>((o1,o2)->{
            if(o1.like != o2.like) return o2.like - o1.like;
            if(o1.empty != o2.empty) return o2.empty - o1.empty;
            if(o1.x != o2.x) return o1.x - o2.x;
            return o1.y - o2.y;
        });

        //좋아하는 친구 목록

        HashSet<Integer> set = new HashSet<>(ls.get(num - 1));

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] != 0) continue;
                int like = 0;
                int empty = 0;
                for(int idx = 0; idx  < 4; idx++){
                    int nx = i + dx[idx];
                    int ny = j + dy[idx];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(arr[nx][ny] == 0) empty++;
                    else if(set.contains(arr[nx][ny])) like++;
                }
                queue.offer(new Info(i, j, like, empty));
            }
        }
        Info info = queue.poll();
        arr[info.x][info.y] = num;
    }
    private static int cal(){
        int res = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int num = arr[i][j];
                HashSet<Integer> set = new HashSet<>(ls.get(num-1));
                int temp = 0;
                for(int idx = 0; idx < 4; idx ++){
                    int nx = i + dx[idx];
                    int ny = j + dy[idx];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(set.contains(arr[nx][ny])) temp++;
                }
                if(temp == 0) res += 0;
                else if(temp == 1) res += 1;
                else if(temp == 2) res += 10;
                else if(temp == 3) res += 100;
                else res += 1000;
            }
        }
        return res;
    }

}