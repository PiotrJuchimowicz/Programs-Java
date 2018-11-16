package company.com.shopapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import company.com.shopapplication.R;
import company.com.shopapplication.adapter.MyAdapter;
import company.com.shopapplication.model.Product;
import company.com.shopapplication.model.Shop;

public class ProductsListActivity extends AppCompatActivity {
    private ListView listView;
    private MyAdapter myAdapter;
    private Shop shop = Shop.getShop();
    private int checkedProducts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_list);
        listView = findViewById(R.id.productsList);
        myAdapter = new MyAdapter(ProductsListActivity.this, R.layout.products_list, shop.getProducts());
        listView.setAdapter(myAdapter);
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Product product = (Product) listView.getItemAtPosition(position);
            Toast.makeText(ProductsListActivity.this.getApplicationContext(), product.toString(), Toast.LENGTH_LONG).show();
            return true;
        });
        handleSubmitButton();
    }

    private void handleSubmitButton(){
        Button button = findViewById(R.id.submitButton);
        button.setOnClickListener(v -> {
            int checkedProducts = MyAdapter.getCheckedProducts();
            String checkedOneInfo = getString(R.string.selected_one_product);
            String checkedMultipleInfo = getString(R.string.selected_multiple_products) + " :" + checkedProducts;
            if(checkedProducts==1)
                Toast.makeText(ProductsListActivity.this.getApplicationContext(), checkedOneInfo, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ProductsListActivity.this.getApplicationContext(), checkedMultipleInfo, Toast.LENGTH_LONG).show();
        });
    }
}
