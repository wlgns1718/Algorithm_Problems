import java.util.*;
import java.io.*;

/* Online Java Compiler and Editor */
public class Main {
    static int R, C, M, size[][];
    static int king = -1, answer = 0;

    static class Shark implements Comparable<Shark>{
        int velocity;
        int direct;
        int size;
        int x;
        int y;
        public Shark(int velocity, int direct, int size, int x, int y){
            this.velocity = velocity;
            this.direct = direct;
            this.size = size;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Shark o) {
            return this.size - o.size;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "velocity=" + velocity +
                    ", direct=" + direct +
                    ", size=" + size +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static List<Shark> ls = new ArrayList<>();

    public static void main(String []args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[2]);

        size = new int[R][C];
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]) - 1;
            int c = Integer.parseInt(input[1]) - 1;
            int s = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);
            int z = Integer.parseInt(input[4]);
            ls.add(new Shark(s, d, z, r, c));
            size[r][c] = z;
        }
        Collections.sort(ls);
//        System.out.println(ls.toString());

        while(king < C-1){
            move_catch();
            move_shark();
            del_shark();
        }
        System.out.println(answer);
    }

    private static void move_catch(){

        //낚시왕이 오른쪽으로 한칸 이동한다.
        king++;
        int temp = -1;
        //낚시왕이 상어를 잡는다.
        loop1 :
        for(int i = 0; i < R; i++){
            //해당칸에 상어가 없다면
            if(size[i][king] == 0) continue;
            answer += size[i][king];
            for(int j = 0; j < ls.size(); j++){
                Shark shark = ls.get(j);
                if(shark.x == i && shark.y == king){
                    temp = j;
                    size[i][king] = 0;
                    break loop1;
                }
            }

        }
        if(temp != -1){
            ls.remove(temp);
        }
//        System.out.println("상어 잡은 후========================");
//        for(int i = 0; i < R; i++){
//            System.out.println(Arrays.toString(size[i]));
//        }
    }
    private static void move_shark(){

        /*
        원래 칸으로 돌아올 수 있는 경우
        현재 방향의 길이가 X일 때 (X-1) * 2로 나누어 지는 경우
        1. (x-1) * 2로 속도를 나눈다.
        2. 현재방향으로 진행했을 때 방향이 바뀌지 않는 조건은
           현재 위치에서 남은 공간이 속도보다 크거나 같을 때

         */
        for (Shark shark : ls) {
            int d = shark.direct;
            int s = shark.velocity;

            if (d == 1) {
                //위쪽
                //제자리로 올 수 있을 때
                s %= ((R - 1) * 2);

                //현재 위치에서 남은 위쪽 공간은 shark.x
                if (s < shark.x) {
                    // 방향이 바뀌지 않을 때
                    shark.x -= s;
                }
                else if (s == shark.x) {
                    shark.x = 0;
                    shark.direct = 2;
                }
                else {
                    // s > shark.x
                    s -= shark.x;
                    if(s >= R){
                        s -= (R - 1);
                        shark.x = (R - 1) - s;
                        continue;
                    }
                    shark.x = s;
                    shark.direct = 2;
                }
            } else if (d == 2) {
                //아래쪽

                //제자리로 올 수 있을 때
                s %= ((R - 1) * 2);

                //현재 위치에서 남은 아래쪽 공간은 R - shark.x - 1;

                if (s < R - shark.x - 1) {
                    // 방향이 바뀌지 않을 때
                    shark.x += s;
                } else if (s == R - shark.x - 1) {
                    shark.x = R - 1;
                    shark.direct = 1;
                } else {
                    // s > shark.x

                    s -= (R - shark.x - 1);
                    if(s >= R){
                        s -= (R - 1);
                        shark.x = s;
                        continue;
                    }
                    shark.x = (R - 1 - s);
                    shark.direct = 1;
                }

            } else if (d == 3) {
                //오른쪽
                //제자리로 올 수 있을 때
                s %= ((C - 1) * 2);

                //현재 위치에서 남은 오른쪽 공간은 C - shark.y - 1

                if (s < C - shark.y - 1) {
                    // 방향이 바뀌지 않을 때
                    shark.y += s;
                }
                else if (s == C - shark.y - 1) {
                    shark.y = C - 1;
                    shark.direct = 4;
                } else {
                    // s > C - shark.y - 1
                    s -= (C - shark.y - 1);

                    if(s >= C){
                        s -= C - 1;
                        shark.y = s;
                        continue;
                    }
                    shark.y = (C - 1 - s);
                    shark.direct = 4;
                }
            } else {
                //왼쪽

                //제자리로 올 수 있을 때
                s %= ((C - 1) * 2);

                //현재 위치에서 남은 오른쪽 공간은 shark.y

                if (s < shark.y) {
                    // 방향이 바뀌지 않을 때
                    shark.y -= s;
                } else if (s == shark.y) {
                    shark.y = 0;
                    shark.direct = 3;
                }
                else {
                    // s > shark.y
                    s -= shark.y;

                    if(s >= C){
                        s -= C - 1;
                        shark.y = (C-1) - s;
                        continue;
                    }
                    shark.y = s;
                    shark.direct = 3;
                }
            }

        }

    }
    private static void del_shark(){

        //같은 공간에 있는 상어가 있다면 작은 상어 삭제하기
        //삭제할 상어 번호 담기
        List<Integer> del_list = new ArrayList<>();
        for(int i = 0; i < R; i++){
            Arrays.fill(size[i], 0);
        }

        for(int i = ls.size() - 1; i >= 0; i--){
            Shark shark = ls.get(i);
            if(size[shark.x][shark.y] == 0){
                size[shark.x][shark.y] = shark.size;
                continue;
            }
            if(size[shark.x][shark.y] != 0){
                del_list.add(i);
            }
        }
        for (Integer integer : del_list) {
            ls.remove((int) integer);
        }

//        System.out.println("상어 제거 후========================");
//        for(int i = 0; i < R; i++){
//            System.out.println(Arrays.toString(size[i]));
//        }
    }
}