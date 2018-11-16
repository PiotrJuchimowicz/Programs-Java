package company.com.shopapplication.model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Long quantity;
    private Integer imageId;

    public Product(String name, Double price, Long quantity, Integer imageId) {
        this.id = IdGenerator.generate();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return name + " price: "+ price + " available items : " + quantity;
    }
}
