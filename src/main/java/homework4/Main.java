package homework4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:/Users/pc/Desktop/social_network.csv");
        try {
            Scanner scanner = new Scanner(file).useDelimiter(";|\r?\n");

            SocialNetwork socialNetwork = new SocialNetwork();


            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }


            while (scanner.hasNext()) {
                String friend_one = scanner.next().trim();
                String friend_two = scanner.next().trim();
                int friendshipStrength = scanner.nextInt();
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
                socialNetwork.addUser(friend_one);
                socialNetwork.addUser(friend_two);
                socialNetwork.addFriendship(new Friendship(friend_one, friend_two, friendshipStrength));
            }
            scanner.close();


            Scanner inputScanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a name to recommend for, or -1 to exit:");
                String name = inputScanner.nextLine();
                if ("-1".equals(name)) {
                    break;
                }

                List<FriendshipRecommendation> recommendations = socialNetwork.recommendFriends(name);
                System.out.println("Total recommendations: " + recommendations.size());
                if (recommendations.isEmpty()) {
                    System.out.println("No recommendations found or user not found.");
                } else {
                    System.out.println("Top 10 recommendations based on friendship strength:");

                    Collections.sort(recommendations);
                    int count = Math.min(recommendations.size(), 10);
                    for (int i = 0; i < count; i++) {
                        FriendshipRecommendation recommendation = recommendations.get(i);
                        System.out.println(recommendation.getUser() + ": " + recommendation.getRecommendationStrength());
                    }
                }
            }
            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}