/*The daily maximum temperatures recorded for 5 cities during the first 6 days 
of January month have to be tabulated. Develop an application to read the 
data and find the city and day corresponding to highest temperature and 
lowest temperature */

import java.util.Scanner;

public class TemperatureEvaluater {
    public static void main(String args[]) {
        // create a scanner object to read data.
        Scanner s = new Scanner(System.in);

        // have variable to store the no of days and cities so as to manipulate with
        // array to be created.
        int numCities = 5;
        int numDays = 6;

        // create two strings to store the city name and the day's no.
        String[] cities = new String[numCities];
        String[] days = { "Day1", "Day2", "Day3", "Day4", "Day5", "Day6" };

        // create a double 2d array to store the temperatures of a city for 6 days.
        double[][] temperature = new double[numCities][numDays];

        // input the data, i.e city name, temp of the corresponding day using two nested
        // loops.
        for (int cityNo = 0; cityNo < numCities; cityNo++) {
            System.out.print("Enter the name of the city " + (cityNo + 1) + ": ");
            cities[cityNo] = s.nextLine();
            System.out.println();
            // similarly to the temperatures.

            for (int dayNo = 0; dayNo < numDays; dayNo++) {
                System.out.print(days[dayNo] + ": ");
                temperature[cityNo][dayNo] = s.nextDouble();
            }
            System.out.println();

            // consume next line
            s.nextLine();
        }

        // create variables to store the highest & lowest temperature recording day,
        // temp, and city .
        double highestTemperature = temperature[0][0];
        String highestTempCity = cities[0];
        String highestTempDay = days[0];
        double lowestTemperature = temperature[0][0];
        String lowestTempCity = cities[0];
        String lowestTempDay = days[0];

        // find the maximum temp recording city by traversing every cities every days
        // temperature using two nested loops(i.e traverse 2d array completely)
        for (int cityNo = 0; cityNo < numCities; cityNo++) {
            // traverse each and every city,
            for (int dayNo = 0; dayNo < numDays; dayNo++) {
                // traverse each and every day find the highest and lowest of all.
                if (temperature[cityNo][dayNo] > highestTemperature) {
                    highestTemperature = temperature[cityNo][dayNo];
                    highestTempCity = cities[cityNo];
                    highestTempDay = days[dayNo];
                } else if (temperature[cityNo][dayNo] < lowestTemperature) {
                    lowestTemperature = temperature[cityNo][dayNo];
                    lowestTempCity = cities[cityNo];
                    lowestTempDay = days[dayNo];
                }
            }
        }

        // display the evaulated result.
        System.out.println("Evaulated result of 6 days of temperature in 5 cities,");
        System.out.println("Highest Temperature : " + highestTemperature);
        System.out.println("Highest Temperature holding city : " + highestTempCity);
        System.out.println("Highest Temperature on : " + highestTempDay);
        System.out.println();
        System.out.println("Lowest Temperature : " + lowestTemperature);
        System.out.println("Lowest Temperature holding city : " + lowestTempCity);
        System.out.println("Lowest Temperature on : " + lowestTempDay);

        // close the used scanner upon completion.
        s.close();
    }
}
