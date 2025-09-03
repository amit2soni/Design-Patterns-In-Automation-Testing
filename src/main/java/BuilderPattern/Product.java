package BuilderPattern;

public class Product {
    // required fields
    private String name;
    private double price;

    // optional fields
    private String description;
    private String category;
    private int stock;
    private boolean freeShipping;
    private double discount;

    private Product(ProductBuilder builder){
          this.name = builder.name;
          this.price = builder.price;
          this.description = builder.description;
          this.category = builder.category;
          this.stock = builder.stock;
          this.freeShipping = builder.freeShipping;
          this.discount = builder.discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", freeShipping=" + freeShipping +
                ", discount=" + discount +
                '}';
    }

    // ProductBuilder class will be used to create object of Product class
    public static class ProductBuilder{
        private String name;
        private double price;

        // constructor for required fields
        // if we want more required fields just add fields in this constructor
        public ProductBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        private String description;
        private String category;
        private int stock;
        private boolean freeShipping;
        private double discount;

        // setters for optional fields will return "this" to achieve method chaining
        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public ProductBuilder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public ProductBuilder setFreeShipping(boolean freeShipping) {
            this.freeShipping = freeShipping;
            return this;
        }

        public ProductBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        // build method to get the object of product class
        public Product build(){
            return new Product(this);
        }
    }
}
