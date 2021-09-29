import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Integer> numbers = new ArrayList<>();
    private static int x = -1 , y = -1;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int number = sc.nextInt();
        int[][] map = new int[number][number];
        numbers.add(-1);

        Random random = new Random();


        for(int i = 1; i < number * number; i++){
            numbers.add(i);
        }

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = numbers.remove(random.nextInt(numbers.size()));
                if(map[i][j] == -1){
                    x = i;
                    y = j;
                }
            }
        }

        while(true){
            System.out.println("Enter R L U D Move !");
            String input = sc.nextLine();
            int newX = x , newY = y;

            switch (input) {
                case "R" -> newY++;
                case "L" -> newY--;
                case "U" -> newX--;
                case "D" -> newX++;
            }

            if(newX >= 0 && newX < number && newY >= 0 && newY < number){
                int temp = map[x][y];
                map[x][y] = map[newX][newY];
                map[newX][newY] = temp;

                x = newX;
                y = newY;
            }else{
                System.out.println("Cannot Move");
            }

            printMap(map);

            if(checkWin(map)){
                System.out.println("You Win :D");
                break;
            }
        }

    }

    private static void printMap(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (ints[j] == -1) {
                    System.out.print("# ");
                } else {
                    System.out.print(ints[j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean checkWin(int[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == -1){
                    if(i == map.length - 1 && j == map.length - 1){
                        return true;
                    }
                }
                if(map[i][j] != map.length * i + j + 1){
                    return false;
                }
            }
        }
        return true;
    }


}
