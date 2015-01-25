package singleton.design.pattern.example1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tester {
	

	@Test
	public void test1(){
		
		Item it1 = new Item();
		it1.setName("toycar");
		it1.setId("1");
		it1.setPrice(20);
		
		
		Item it2 = new Item();
		it2.setName("milk");
		it2.setId("2");
		it2.setPrice(3.45);
		
		Item it3 = new Item();
		it3.setName("bread");
		it3.setId("3");
		it3.setPrice(4.00);
		
		Cart cart1 = Cart.getInstance();
		
		cart1.addItem(it1);
		cart1.addItem(it2);
		cart1.addItem(it3);
		
		double total = cart1.totalPrice();
		assertEquals(27.45,total,0.001);
		
		cart1.removeItem(it1);
		
		total = cart1.totalPrice();
		assertEquals(7.45,total,0.001);
		
		Cart cart2 = Cart.getInstance(); //Since cart2 is same cart as cart1
		double total2 = cart2.totalPrice();//Therefore the total price didn't change
		assertEquals(7.45,total2,0.001);
	}

}
