package BuilderPattern;

public class TestProduct {

    public static void main(String[] args){

        // use case 1 - only mandatory fields
        Product product1 = new Product.ProductBuilder("Iphone 15",70000).build();
        System.out.println(product1.toString());

        // use case 2 - mandatory + optional fields
        Product product2 = new Product.ProductBuilder("T-Shirt",700)
                .setCategory("Fashion")
                .setDescription("Black Nike sports t-shirt")
                .setStock(500)
                .setFreeShipping(true)
                .build();
        System.out.println(product2.toString());
        product2.setDiscount(5);
        System.out.println(product2.toString());

    }
}
