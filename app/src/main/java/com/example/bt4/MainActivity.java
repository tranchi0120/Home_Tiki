package com.example.bt4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;
import shop.Shop;

public class MainActivity extends AppCompatActivity {
    private CategoryAdapter categoryAdapter;
    ViewFlipper v_flipper1;
    int [] arrayHinh = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8};
    RecyclerView rcvCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        v_flipper1 = (ViewFlipper) findViewById(R.id.v_flipper1);
        for (int i=0;i<arrayHinh.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP)
            ;
            imageView.setImageResource(arrayHinh[i]);
            v_flipper1.addView(imageView);
        }
        v_flipper1.setFlipInterval(3000);
        v_flipper1.setAutoStart(true);



        rcvCategory= findViewById(R.id.rcv_category);
        categoryAdapter= new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

    }

    //Recycalview row
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Shop>  listShop = new ArrayList<>();
        List<Shop>  listShop1 = new ArrayList<>();
        listShop.add(new Shop(R.drawable.c1,"Mã giảm giá"));
        listShop.add(new Shop(R.drawable.c2,"Đánh giá sản phẩm"));
        listShop.add(new Shop(R.drawable.c3,"Free ship"));
        listShop.add(new Shop(R.drawable.c4,"Hoàn tiền 15%"));
        listShop.add(new Shop(R.drawable.c5,"Coupon 50%"));
        listShop.add(new Shop(R.drawable.c6,"TikeLive"));
        listShop.add(new Shop(R.drawable.c9,"Giảm giá sốc"));
        listShop.add(new Shop(R.drawable.c8,"Săn sale mỗi ngày"));

        listShop1.add(new Shop(R.drawable.c7,"Đánh giá "));
        listShop1.add(new Shop(R.drawable.c8,"Quà mỗi ngày"));
        listShop1.add(new Shop(R.drawable.c9,"Free ship"));
        listShop1.add(new Shop(R.drawable.c10,"Tiki Card"));
        listShop1.add(new Shop(R.drawable.c11,"Nạp thẻ tiện ích"));
        listShop1.add(new Shop(R.drawable.c12,"Dành cho hội viên"));
        listShop1.add(new Shop(R.drawable.c13,"Hẹn giao và lắp đặt"));
        listShop1.add(new Shop(R.drawable.c14,"Tươi sống"));


        listCategory.add(new Category("", listShop));
        listCategory.add(new Category("", listShop1));

        return listCategory;
    }
}