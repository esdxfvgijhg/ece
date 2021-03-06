package Test1;

import java.util.ArrayList;
import java.util.List;

public class Farm {
	private Integer nTrees=0;
	private Integer price=0;
	private List<Market> destinations = new ArrayList<>();

	public Farm(Integer nTrees, Integer price, List<Market> destinations) {
		this.nTrees=nTrees;
		this.price=price;
		this.destinations=destinations;
	} 

	public Integer getnTrees() {
		return nTrees;
	}
	public void setnTrees(Integer nTrees) {
		this.nTrees = nTrees;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public List<Market> getDestinations() {
		return destinations;
	}
	public void setDestination(List<Market> destinations) {
		this.destinations = destinations;
	}
}
