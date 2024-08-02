package homework4;


import java.util.*;

public class SocialNetwork {
    private  Map<String, List<Friendship>> adjacencyList = new HashMap<>();

    public void addUser(String user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addFriendship(Friendship f) {
        adjacencyList.get(f.friend_one()).add(f);
        adjacencyList.get(f.friend_two()).add(f);
    }

    public List<FriendshipRecommendation> recommendFriends(String user) {
        if (!adjacencyList.containsKey(user)) {
            return new ArrayList<>();
        }

        Map<String, Integer> recommendationStrengths = new HashMap<>();


        List<Friendship> directFriends = adjacencyList.get(user);

        for (Friendship directFriendship : directFriends) {
            String directFriend = directFriendship.friend_two().equals(user) ? directFriendship.friend_one() : directFriendship.friend_two();


            if (adjacencyList.containsKey(directFriend)) {
                for (Friendship friendOfFriendship : adjacencyList.get(directFriend)) {
                    String friendOfFriend = friendOfFriendship.friend_two().equals(directFriend) ? friendOfFriendship.friend_one() : friendOfFriendship.friend_two();


                    if (!friendOfFriend.equals(user) && !containsFriend(directFriends, friendOfFriend)) {
                        int currentStrength = Math.min(directFriendship.getFriendshipStrength(), friendOfFriendship.getFriendshipStrength());
                        recommendationStrengths.put(friendOfFriend, recommendationStrengths.getOrDefault(friendOfFriend, 0) + currentStrength);
                    }
                }
            }
        }


        List<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : recommendationStrengths.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }

        Collections.sort(recommendations);
        return recommendations;
    }


    private boolean containsFriend(List<Friendship> friends, String potentialFriend) {
        for (Friendship friendship : friends) {
            if (friendship.friend_one().equals(potentialFriend) || friendship.friend_two().equals(potentialFriend)) {
                return true;
            }
        }
        return false;
    }

}