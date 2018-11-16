package company.com.shopapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import company.com.shopapplication.R;
import company.com.shopapplication.activity.ProductsListActivity;
import company.com.shopapplication.model.Product;
import company.com.shopapplication.model.Shop;

public class MyAdapter extends ArrayAdapter<Product> {
    private int resource;
    private Context context;
    private List<Product> products;
    private static  int checkedProducts=0;

    public MyAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        this.resource = resource;
        this.context=context;
        this.products=products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_product_layout, parent, false);
        TextView nameText = rowView.findViewById(R.id.productName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.productImage);
        nameText.setText(products.get(position).getName());
        imageView.setImageResource(products.get(position).getImageId());
        CheckBox checkBox = rowView.findViewById(R.id.checkbox);
        checkBox.setOnClickListener(v -> {
            if(checkBox.isChecked())
                checkedProducts++;
            else
                checkedProducts--;
        });
        return rowView;
    }

    public static int getCheckedProducts() {
        return checkedProducts;
    }

    public static void setCheckedProducts(int checkedProducts) {
        MyAdapter.checkedProducts = checkedProducts;
    }
}
