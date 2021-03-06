package IceCreamShopV1;

/**
 * Demonstration of the Factory pattern
 */

public class IceCreamShopV1 {

 private IceCreamFactory factory;
 
 public IceCreamShopV1(IceCreamFactory factory) {
  this.factory = factory;
 }
 
 public IceCream orderCone(String type) {
  IceCream cone;
  
  cone = factory.getIceCream(type);
  
  cone.scoop();
  
  return cone;
 }

 public static void main(String[] args) {

/*	String type="Chocolate";
  IceCream cone = null;
  
  if (type.equals("Chocolate"))
   cone = new Chocolate();
  else if (type.equals("Strawberry"))
   cone = new Strawberry();
  else if (type.equals("Vanilla"))
   cone = new Vanilla();

	cone.scoop();
*/

/*
  IceCreamFactory factory = new IceCreamFactory();
	IceCream cone = factory.getIceCream("Chocolate");
  cone.scoop();*/



  IceCreamFactory factory = new IceCreamFactory();
  IceCreamShopV1 shop = new IceCreamShopV1(factory);
  
 	shop.orderCone("Chocolate");
 }
}
