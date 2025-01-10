import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int answer = 0;
    
    static class Visit{
        int x;
        int y;
        
        public Visit(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o){
            Visit visit = (Visit) o;
            if(visit.x == this.x && visit.y == this.y) return true;
            return false;
        }
        @Override
        public int hashCode(){
            return 100 * this.x + this.y;
        }
    }
    static class Robot{
        int x;
        int y;
        int routes;
        int idx;
        
        public Robot(int x, int y, int routes, int idx){
            this.x = x;
            this.y = y;
            this.routes = routes;
            this.idx = idx;
        }
    }
    static Set<Visit> set = new HashSet<>();
    static List<Robot> list = new ArrayList<>();
    
    public int solution(int[][] points, int[][] routes) {
        for(int i = 0; i < routes.length; i++){
            int point = routes[i][0] - 1;
            
            int x = points[point][0];
            int y = points[point][1];
            map[x][y] ++;
            set.add(new Visit(x, y));
            list.add(new Robot(x, y, 1, i));
        }
        cal();
        while(!list.isEmpty()){
            move(points, routes);
            cal();
            update(points, routes);
        }
        return answer;
    }
    
    private static void move(int[][] points, int[][] routes){
        //로봇 위치 옮기기
        for(int i = 0; i < list.size(); i++){
            Robot robot = list.get(i);
            map[robot.x][robot.y] --;
            
            if(robot.x != points[routes[robot.idx][robot.routes] - 1][0]){
                if(robot.x > points[routes[robot.idx][robot.routes] - 1][0]){
                    robot.x --;
                }
                else{
                    robot.x ++;
                }
            }
            else{
                if(robot.y != points[routes[robot.idx][robot.routes] - 1][1]){
                    if(robot.y > points[routes[robot.idx][robot.routes] - 1][1]){
                        robot.y --;
                    }
                    else{
                        robot.y ++;
                    }
                }
            }
            map[robot.x][robot.y] ++;
            set.add(new Visit(robot.x, robot.y));
        }
    }
    
    private static void cal(){
        
        for(Visit visit : set){
            if(map[visit.x][visit.y] > 1) answer++;
        }
        set.clear();
    }
    
    private static void update(int[][] points, int[][] routes){
        //목적지에 도착한 로봇 삭제
        int idx = 0;
        int n = list.size();
        for(int i = 0; i < n; i++){
            Robot cur = list.get(idx);
            if(cur.routes < routes[cur.idx].length - 1){
                if(cur.x == points[routes[cur.idx][cur.routes] - 1][0] &&
                    cur.y == points[routes[cur.idx][cur.routes] - 1][1]){
                    cur.routes++;
                }
                idx++;
            }
            else{
                if(cur.x == points[routes[cur.idx][cur.routes] - 1][0] &&
                    cur.y == points[routes[cur.idx][cur.routes] - 1][1]){
                    map[cur.x][cur.y] --;
                    list.remove(idx);
                }
                else{
                    idx++;
                }
            }
        }
    }
}