package Auction2;

public class Auction {
 public static void main(String[] args) {
  Stock auction = new Stock();
  
  // create some Traders
  Trader amy = new Trader(auction);
  Trader julie = new Trader(auction);
  Trader pat = new Trader(auction);

  // submit some bids to the auction 
  auction.submitBid(new Bid("Amy",150));
  auction.submitBid(new Bid("Julie",160));
  auction.submitBid(new Bid("Amy",165));
  auction.submitBid(new Bid("Julie",170));
  auction.submitBid(new Bid("Pat", 175));

  // The bidding has gone too high for Amy.
  auction.removeObserver(amy);
  
  // few more bids
  auction.submitBid(new Bid("Julie",180));
  auction.submitBid(new Bid("Pat",185));
  
  // now too high for Julie
  auction.removeObserver(julie);

  // this doesn't make sense, but just to show that
  // there is now only one observer (Pat)
  auction.submitBid(new Bid("Pat",190));
 }
}
