// Jose Guzman
// December 10, 2023
// File Name: cityPopulations.java
// To Compile in terminal type: javac cityPopulations.java
// To Run the program in terminal type: java cityPopulations
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cityPopulations {
    public static final int SIZE = 8619;

    public static void main(String[] args) {

        int[] population = new int[SIZE];
        String[] city = new String[SIZE];
        String[] state = new String[SIZE];
        String[] stateArray = new String[SIZE];  // Corrected variable name

        String fileName = "cityPopulations.csv";
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }

        inputStream.nextLine();
        int index = 0;

        while (inputStream.hasNextLine()) {
            String record = inputStream.nextLine();
            String[] fields = record.split(",");

            population[index] = Integer.parseInt(fields[0]);  // Corrected case of "ParseInt"
            state[index] = fields[1];
            city[index] = fields[2];
            index++;
        }

        System.out.println(population[0] + " " + state[0] + " " + city[0]);
        System.out.println(population[index - 1] + " " + state[index - 1] + " " + city[index - 1]);

        int indexMax = findMax(population);
        System.out.println(population[indexMax] + " " + state[indexMax] + " " + city[indexMax]);
        indexMax = findMaxForState(population, state, "California");  // Corrected variable name
        System.out.println(population[indexMax] + " " + state[indexMax] + " " + city[indexMax]);
    }

    public static int findMax(int[] array) {
        int max = array[0];
        int indexMax = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
        }

        return indexMax;
    }

    public static int findMaxForState(int[] array, String[] states, String nameOfState) {
        int max = array[0];
        int indexMax = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max && states[i].equalsIgnoreCase(nameOfState)) {
                max = array[i];
                indexMax = i;
            }
        }

        return indexMax;
    }
}

/*
2177 Alabama Ashford
5441 Wyoming Worland
418394 Florida Miami
345320 California Anaheim
*/