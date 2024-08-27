// Class representing a bidder
public class bidders implements BidderObserver {
    private String name; // Bidder's name

    // Constructor
    




    // Method called when the bidder receives a notification
    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    // Method to get the name of the bidder
    @Override
    public String getName() {
        return name;
    }
}

