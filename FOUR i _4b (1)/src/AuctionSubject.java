
public interface AuctionSubject {
    void registerBidder(BidderObserver observer);
    void unregisterBidder(BidderObserver observer);
    void notifyBidders(String message);
}

