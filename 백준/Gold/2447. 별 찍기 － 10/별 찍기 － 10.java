import java.util.Scanner;

public class Main {
    static char[][] arr;

    static void printStar(int n, int x, int y) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                int nx = x + n / 3 * i;
                int ny = y + n / 3 * j;
                printStar(n / 3, nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }
        printStar(n, 0, 0);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
