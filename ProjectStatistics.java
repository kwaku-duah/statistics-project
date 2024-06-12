import java.util.Arrays;
import java.util.Scanner;

public class ProjectStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grades with spaces");

        String[] input = scanner.nextLine().split(" ");
        int N = input.length;
        int[] scores = new int[N];

        for (int i = 0; i < N; i++){
            scores[i] = Integer.parseInt(input[i]);
        }
        
        // Calculate min, average, max
        int minScore = Arrays.stream(scores).min().getAsInt();
        int maxScore = Arrays.stream(scores).max().getAsInt();
        double averageScore = Arrays.stream(scores).average().getAsDouble();

        int[] stats = new int[5];
        for ( int score : scores){
            if (score > 80) stats[4]++;
            else if (score > 60) stats[3]++;
            else if (score > 40) stats[2]++;
            else if (score > 20) stats[1]++;
            else stats[0]++;

        }
        // Display results for min, max and average grades
        System.out.printf("The minimum grade is %d\n", minScore);
        System.out.printf("The maximum grade is %d\n",maxScore);
        System.out.printf("The average grade is %.6f\n",averageScore);

        System.out.println("\nGraph:\n");
        int maxHeight = Arrays.stream(stats).max().getAsInt();

        for (int i = maxHeight; i > 0; i--){
            System.out.printf("%3d > ",i);
            for (int j = 0; j < stats.length; j++){
                if (stats[j] >= i){
                    System.out.print("   #######   ");
                } else {
                    System.out.print("             ");
                }
            }
            System.out.println();
        }
        // Bottom axis of the graph with labelling
        System.out.println("    +-------------+-------------+-------------+-------------+-------------+");
        System.out.println("    I     0-20    I    21-40     I    41-60   I    61-80    I     81-100  I");
        }
    }
