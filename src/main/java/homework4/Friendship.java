package homework4;

public class Friendship {
    private String friend_one;
    private String friend_two;
    private int friendshipStrength;

    public Friendship(String friend_one, String friend_two, int friendshipStrength) {
        this.friend_one = friend_one;
        this.friend_two = friend_two;
        this.friendshipStrength = friendshipStrength;
    }


    public String friend_one() {
        return friend_one;
    }

    public String friend_two() {
        return friend_two;
    }

    public int getFriendshipStrength() {
        return friendshipStrength;
    }
}