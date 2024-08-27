import java.util.ArrayList;
import java.util.List;

// Class representing an auction
public class Auction implements AuctionSubject {
    private List<BidderObserver> bidders = new ArrayList<>(); // List of bidders
    private String itemName; // The item being auctioned

    // Constructor
    public Auction(String itemName) {
        this.itemName = itemName;
    }

    // Register a bidder to the auction
    @Override
    public void registerBidder(BidderObserver observer) {
        bidders.add(observer);
        System.out.println(observer.getName() + " has subscribed to auction notifications.");
    }
    

    // Unregister a bidder from the auction
    @Override
    public void unregisterBidder(BidderObserver observer) {
        bidders.remove(observer);
        System.out.println(observer.getName() + " has unsubscribed from auction notifications.");
    }

    // Notify all registered bidders
    @Override
    public void notifyBidders(String message) {
        for (BidderObserver bidder : bidders) {
            bidder.update(message);
        }
    }

    // Method to start the auction
    public void startAuction() {
        notifyBidders("Auction for " + itemName + " has started!");
    }

    // Method to end the auction
    public void endAuction() {
        notifyBidders("Auction for " + itemName + " has ended!");
    }

    // Method to announce item availability
    public void itemAvailable() {
        notifyBidders("Item available for bidding: " + itemName);
    }
}

