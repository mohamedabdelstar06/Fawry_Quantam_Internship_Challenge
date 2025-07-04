import Cart.Cart;
import Customer.Customer;
import Product.Cheese;
import Product.MobileScratchCard;
import Product.TV;


import java.time.LocalDate;

import static Service.CheckoutService.checkout;
import static Service.ShippingService.ship;

public class Main {
    public static void main(String[] args) throws Exception {

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Customer customer1 = new Customer("Mohamed", 5000);
        Customer customer2 = new Customer("Abdelstar", 1000);

        Cheese cheese = new Cheese("Cheese", 50, 5, LocalDate.of(2025, 12, 30), 1);
        Cheese oldCheese = new Cheese("Old Cheese", 30, 4, LocalDate.of(2025, 10, 1), .5);

        TV tv = new TV("TV", 1000, 100, 20);
        MobileScratchCard scratchCard = new MobileScratchCard("Scratch Card", 200, 20);


        //Tests to prove my code is working

        //normal case
        cart1.add(cheese, 2);
        cart1.add(tv, 3);
        cart1.add(scratchCard, 4);
        cart1.remove(scratchCard, 2);
        ship(cart1.getItems());
        checkout(customer1, cart1);


        //send empty cart
//        try{
//            checkout(customer2,cart2);
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }


        //Customer's Balance is Insufficient
//        try{
//            cart2.add(tv,10);
//            ship(cart2.getItems());
//            checkout(customer2,cart2);
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }


        //product is out of stock
//        try{
//        cart2.add(cheese,10);
//        ship(cart2.getItems());
//        checkout(customer2,cart2);
//        }catch(Exception e){
//            System.out.println(e);
//        }


        //product is Expired
//        try{
//            cart2.add(oldCheese,2);
//            ship(cart2.getItems());
//            checkout(customer2,cart2);
//        }catch (Exception e){
//            System.out.println(e);
//        }


        //trying to remove a product not exist in the cart
//        cart2.add(cheese,2);
//        cart2.remove(tv,1);
//        ship(cart2.getItems());
//        checkout(customer2,cart2);

    }
}
