package Cart;

import Product.Product;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product,Integer> items= new HashMap<Product,Integer>();


    public void add(Product item, int quantity) {
        if(quantity>0) {
            items.put(item,quantity);
        }
    }

    public void remove(Product item, int quantity) {
        if (items.containsKey(item)) {
            int oldQuantity = items.get(item);
            if(oldQuantity <= quantity)
                items.remove(item);
            else {
                items.put(item, oldQuantity - quantity);
            }
        }
        else {
            System.out.println("The product does not exist in the cart " + item.getName());
        }
    }


    public Map<Product,Integer> getItems() {
        return items;
    }



}


