package Service;

import Cart.Cart;
import Customer.Customer;
import Product.Product;
import Product.ExpirableProduct;
import java.util.Map;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) throws Exception {

        //Raise an error if the cart is empty
        if(cart.getItems().isEmpty()){
            throw new Exception("Cart is Empty");
        }



        System.out.println("** Checkout receipt **");
        double totalPrice = 0;
        Map<Product, Integer> items = cart.getItems();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {

            //Raise and error if the product out of stock
            if(entry.getKey().getQuantity() < entry.getValue())
            {
                throw new Exception("Not enough quantity in the stock for the product: " + entry.getKey().getName());
            }

            //Raise an Error if the product expired
            if(entry.getKey() instanceof ExpirableProduct) {
                if(((ExpirableProduct)entry.getKey()).isExpired())
                {
                    throw new Exception("Product: "+ entry.getKey().getName() +" is Expired");
                }

            }

            System.out.printf("%dx %s \t %.2f%n", entry.getValue(), entry.getKey().getName(),
                    entry.getValue()*entry.getKey().getPrice());

            //change the original quantity in the stock
            entry.getKey().setQuantity(entry.getKey().getQuantity()-entry.getValue());

            totalPrice += entry.getKey().getPrice()*entry.getValue();

        }
        System.out.println("------------------------");
        System.out.println("Subtotal \t "+totalPrice);


        System.out.println("Shipping \t "+1*ShippingService.totalWeight); // Let's say it's 1 pound for every single one kg

        double amount = totalPrice+ShippingService.totalWeight;
        System.out.println("Amount \t "+amount);

        //Raise an error if the customer's balance is insufficient
        if(customer.getBalance() < amount) {
            throw new Exception("Insufficient Balance");
        }

            System.out.println("Your Current Balance \t "+
                    (customer.getBalance()-amount));
            customer.setBalance(customer.getBalance()-amount);
        System.out.println(); //make a new line because if another receipt comes out "formating"


    }

}

