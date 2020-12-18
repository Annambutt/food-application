package com.MealMagic.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.MealMagic.foodorderapp.Adapters.OrdersAdapter;
import com.MealMagic.foodorderapp.Models.OrdersModel;
import com.MealMagic.foodorderapp.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list , this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

    }
}