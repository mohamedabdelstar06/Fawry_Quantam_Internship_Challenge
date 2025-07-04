package Service;


import Product.Product;
import Product.Shippable;
import java.util.Map;

public class ShippingService {

    static double totalWeight = 0;

    public static void ship(Map<Product,Integer> shippableItems) {
        System.out.println("** Shipment notice **");
        for (Map.Entry<Product,Integer> entry : shippableItems.entrySet()) {



            if(entry.getKey() instanceof Shippable)
            {

                System.out.printf("%dx %s \t %.2fg%n", entry.getValue(),
                        entry.getKey().getName(),
                        (((Shippable)entry
                                .getKey())
                                .getWeight()*entry.getValue())*1000 );

                totalWeight+= ((Shippable) entry.getKey()).getWeight()*entry.getValue();


            }

            else {

                System.out.printf("%dx %s \t %n", entry.getValue(),
                        entry.getKey().getName());
            }


        }
        System.out.printf("Total package weight %.2fkg%n%n", totalWeight);



    }


}
