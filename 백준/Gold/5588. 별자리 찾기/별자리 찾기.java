import java.util.*;
import java.io.*;


public class Main {
    static int m,n;
    static HashSet<Data> stars = new HashSet<>();
    static List<Data> list = new ArrayList<>();
    static boolean tri = false;

    static public class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return (1000000+1) * y + x;
        }

        @Override
        public boolean equals(Object obj){
            Data data = (Data) obj;
            return x == data.x && y == data.y;
        }
    }

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        m = Integer.parseInt(br.readLine());
        int x,y;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list.add(new Data(x,y));
        }
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            stars.add(new Data(x,y));
        }
        Data start = list.get(0);
        int lineX = 0, lineY = 0;
        for(Data data : stars){
            if(tri)break;

            lineX = data.x - start.x;
            lineY = data.y - start.y;
            sol(lineX, lineY);

        }
        System.out.println(lineX + " " + lineY);

    }
    private static void sol(int line1, int line2){
        for(int i = 1; i < m; i++){
            Data data = list.get(i);
            if(!stars.contains(new Data(data.x+line1, data.y+line2))) return;
        }
        tri = true;

    }
}