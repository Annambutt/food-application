package com.MealMagic.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.Menu;
import android.view.MenuItem;

import com.MealMagic.foodorderapp.Adapters.MainAdapter;
import com.MealMagic.foodorderapp.Models.MainModel;
import com.MealMagic.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger, "Beef Burger" , "300" , "Toasted Buns, Crispy-edged Burger, and Tangy Sauce"));
        list.add(new MainModel(R.drawable.zingerburger, "Zinger Burger" , "250" , "Boneless chicken enriched with cheese and red sauce packed in soft buns topped with Seeds"));
        list.add(new MainModel(R.drawable.vegburger, "Vegetable Burger" , "200" , "Jamaican Style Vegetable Burger are Vegetable turnovers made with a whole wheat crust and filled with a blend of seasoned hearty vegetables"));
        list.add(new MainModel(R.drawable.fishburger, "Fish Burger" , "400" , "British Style Fish Burger are fresh Fish turnovers made with a whole wheat crust and filled with a blend of seasoned Fresh Fish"));
        list.add(new MainModel(R.drawable.cheesepizza, "Cheese Pizza" , "900" , "Crispy thin Crust topped with double cheese"));
        list.add(new MainModel(R.drawable.pizza, "Chicken Pizza" , "700" , "Crispy Crust with Mint and Tomato Sauce topped with Olives"));
        list.add(new MainModel(R.drawable.vegetablepizza, "Vegetable Pizza" , "600" , "Veg pizza is made with the Combination of Delicious Vegetables like broccoli, onion, capsicum, carrot, mushroom and cauliflower"));
        list.add(new MainModel(R.drawable.plainfries, "Plain Fries" , "250" , "Crispy Potato Sticks Cooked gently merinated with tomato sauce"));
        list.add(new MainModel(R.drawable.pizzacheesefries, "Pizza Fries" , "500" , "Combo of pizza with fries enriched with Mozzarella Cheese"));



        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
            startActivity(new Intent(MainActivity.this,OrdersActivity.class));
            break;
    }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("EXIT")
                .setIcon(R.drawable.warning)
                .setMessage("Are you sure you want to Exit")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.cancel();
            }
        }).show();

    }
}