package singleton.design.pattern.example1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
	private static Cart cart = null;
	private List <Item> itemList;
	
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}



	public static Cart getInstance() {
		  if(cart == null) {
			  
			     synchronized(Cart.class) {
			       if(cart == null) {
			         cart = new Cart();
			       }
			    }
		  }
		  return cart;
	}
	
	
	
	public void addItem(Item item){
		if (itemList==null){
			itemList = new ArrayList<Item>();
		}
		itemList.add(item);
	}
	
	public void removeItem(Item item){
		if (itemList!=null && item != null){
			String itemId=item.getId();
			Iterator<Item> it = itemList.iterator();
			int index=0;
			while(it.hasNext()){
				
				Item tmpItem=it.next();
				String tmpId = tmpItem.getId();
				if(tmpId.equals(itemId))
					break;
				index++;
			}
			itemList.remove(index);
		}
	}
	
	public double totalPrice(){
		double sum=0;
		if (itemList!=null ){
			Iterator<Item> it = itemList.iterator();

			while(it.hasNext()){
				Item tmpItem=it.next();
				sum+=tmpItem.getPrice();
			}
		}
		return sum;
	}

}
