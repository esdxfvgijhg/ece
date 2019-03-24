public class Market {
	private final String city ;
	private Integer nStalls ;
	
	public Market(String city, Integer nStalls) {
		super();
		this.city = city;
		this.nStalls = nStalls;
	}
	public Integer getnStalls() {
		return nStalls;
	}
	public void setnStalls(Integer nStalls) {
		this.nStalls = nStalls;
	}
	public String getCity() {
		return city;
	}
	
}
