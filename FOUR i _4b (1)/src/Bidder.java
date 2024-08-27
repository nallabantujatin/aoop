public class Bidder implements BidderObserver {
    private String name;

    public Bidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    @Override
    
    public String getName() {
        return name;
    }
}
