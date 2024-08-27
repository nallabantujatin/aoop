
public class AuctionSystem {
    public static void main(String[] args) {
        
        Auction auction = new Auction("Antique Vase");

        
        BidderObserver bidder1 = new Bidder("Alice");
        BidderObserver bidder2 = new Bidder("Bob");

        
        auction.registerBidder(bidder1);
        auction.registerBidder(bidder2);

        
        auction.itemAvailable();

        
        auction.startAuction();

        
        auction.unregisterBidder(bidder1); 

    
        auction.endAuction();
    }
}
