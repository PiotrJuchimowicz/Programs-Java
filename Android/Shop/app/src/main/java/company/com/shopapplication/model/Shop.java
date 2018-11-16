package company.com.shopapplication.model;

import android.os.Build;
import android.support.annotation.RequiresApi;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import company.com.shopapplication.R;
import company.com.shopapplication.exception.UnableToFindObjectException;


public class Shop {
    private static Shop shop = null;
    private  List<Product> products = new LinkedList<>();

    private Shop() {
        init();
    }

    public static synchronized Shop getShop() {
        if (shop == null) {
            shop = new Shop();
        }
        return shop;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Product findProductById(Long id) {
        Optional<Product> result = products.stream()
                .filter((p) -> p.getId().equals(id))
                .findFirst();
        if (result.isPresent())
            return result.get();
        else
            throw new UnableToFindObjectException("Unable to find object with id: " + id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateProduct(Product product) {
        Product result = findProductById(product.getId());
        result.setName(product.getName());
        result.setPrice(product.getPrice());
        result.setQuantity(product.getQuantity());
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }

    public Integer getNumberOfProducts(){
        return products.size();
    }

    public Product getProductByPositionOnList(Integer position){
        return products.get(position);
    }

    public  List<Product> getProducts() {
        return products;
    }

    private  void init() {
        Product p1 = new Product("Computer", 5000D, 2L,R.drawable.baseline_computer_24);
        products.add(p1);
        Product p2 = new Product("Head set", 300D, 10L,R.drawable.baseline_headset_24);
        products.add(p2);
        Product p3 = new Product("Monitor", 700D, 5L,R.drawable.baseline_desktop_windows_24);
        products.add(p3);
        Product p4 = new Product("Keyboard", 250D, 2L,R.drawable.baseline_keyboard_24);
        products.add(p4);
        Product p5 = new Product("Mouse", 140D, 20L,R.drawable.baseline_mouse_24);
        products.add(p5);
    }
}
