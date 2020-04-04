package com.example.amazonapp.Controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<<<< Temporary merge branch 1
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

=========

import android.content.Context;
import android.content.SharedPreferences;
>>>>>>>>> Temporary merge branch 2
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.amazonapp.Adapters.CategoryAdapter;
import com.example.amazonapp.Adapters.PopularProductAdapter;
import com.example.amazonapp.AsyncTasks.AsyncResponse;
import com.example.amazonapp.AsyncTasks.WebServiceCallGet;
import com.example.amazonapp.AsyncTasks.WebserviceCall;

import com.example.amazonapp.Helper.Config;
import com.example.amazonapp.Helper.Utils;
import com.example.amazonapp.Models.CategoryModel;
import com.example.amazonapp.Models.PopularProductModel;
import com.example.amazonapp.Models.PopularProductResponseModel;
import com.example.amazonapp.Models.ResponseModel;
import com.example.amazonapp.R;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

<<<<<<<<< Temporary merge branch 1
=========
import com.google.android.material.navigation.NavigationView;
>>>>>>>>> Temporary merge branch 2
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener{
    private static final String TAG =MainActivity.class.getName() ;
    RecyclerView categoryList, productList;
   Toolbar toolbar_top;
    List<String> titles;
    CategoryAdapter adapter;
    PopularProductAdapter popularProductAdapter;
    BottomAppBar bottomAppBar;
    Spinner spinner_category;
    List<String> productName;
    List<String> imgUrl;
    TextView txtUserWlcm;
   //Hiding menu items on different items
    Toolbar toolbar;

<<<<<<<<< Temporary merge branch 1
    //final Fragment fragmenthome = new MainActivity();


    //Fragment active = fragment1;

    //Calling api using volley
=========
>>>>>>>>> Temporary merge branch 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar_top);
<<<<<<<<< Temporary merge branch 1

=========
        productName=new ArrayList<>();
        imgUrl=new ArrayList<>();
        txtUserWlcm=findViewById(R.id.txtWlcmUser);
        SharedPreferences myPrefs = getSharedPreferences("AmazonApp", Context.MODE_PRIVATE);


            txtUserWlcm.setText(myPrefs.getString("Fname","Welcome Guest"));


        String PRODUCTURL= Config.POPULAR_PRODUCT;
        new WebServiceCallGet(MainActivity.this, PRODUCTURL,null, "Getting Popular Product..", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("response", response);
                PopularProductResponseModel model = new Gson().fromJson(response, PopularProductResponseModel.class);
                ArrayList<PopularProductModel> popularProductModels=model.getData();


                if (model.getSuccess().equals("1") ) {
                    Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();




                    for(PopularProductModel pm:popularProductModels)
                    {
                        productName.add(pm.getProductname());
                        imgUrl.add(pm.getImage());


                    }
                    popularProductAdapter=new PopularProductAdapter(MainActivity.this,productName,imgUrl);

                    GridLayoutManager gridLayoutManagerProduct = new GridLayoutManager(MainActivity.this, 1, GridLayoutManager.HORIZONTAL, false);

                    productList.setLayoutManager(gridLayoutManagerProduct);
                    productList.setAdapter(popularProductAdapter);

                } else if (model.getSuccess().equals("0")) {
                    Toast.makeText(MainActivity.this, "" + model.getSuccess(), Toast.LENGTH_SHORT).show();

                }
            }
        }).execute();


        ///--------------------------------------------------------------------------------------

>>>>>>>>> Temporary merge branch 2
        spinner_category=(Spinner)findViewById(R.id.spinner_category);
        spinner_category.setOnItemSelectedListener(this);
        //CAtegory List...//

        String[] keys=new String[]{"CompanyId"};
        String[] values=new String[]{"1"};
        final String JSONREQUEST= Utils.createJsonRequest(keys,values);
        String URL= Config.GET_CATEGORIES;

        new WebserviceCall(MainActivity.this, URL, JSONREQUEST, "Getting catgeories..", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("response", response);
                ResponseModel model = new Gson().fromJson(response, ResponseModel.class);
                ArrayList<CategoryModel> categoryModel=model.getData();

                if (model.getSuccess().equals("1") ) {
                    Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();

                  /*  ArrayList<String> categoryName=new ArrayList<>();*/

                   ArrayList<String> categoryString=new ArrayList<>();


                    for(CategoryModel cm:categoryModel)
                    {
                        categoryString.add(cm.getCategoryname());
                        titles.add(cm.getCategoryname());
                    }

                    ArrayAdapter<String> bindCategory=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,categoryString);
                    bindCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner_category.setAdapter(bindCategory);
                    //binding cardview with api data
                    adapter = new CategoryAdapter(MainActivity.this, titles);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2, GridLayoutManager.VERTICAL, false);
                    categoryList.setLayoutManager(gridLayoutManager);
                    categoryList.setAdapter(adapter);

                    //will call api of popular product
<<<<<<<<< Temporary merge branch 1
                    popularProductAdapter=new PopularProductAdapter(MainActivity.this,titles);

                    GridLayoutManager gridLayoutManagerProduct = new GridLayoutManager(MainActivity.this, 1, GridLayoutManager.HORIZONTAL, false);

                    productList.setLayoutManager(gridLayoutManagerProduct);
                    productList.setAdapter(popularProductAdapter);

                    /*Intent intent = new Intent(Feedback.this, Home_Page_Navigation.class);
                    startActivity(intent);*/
=========






                } else if (model.getSuccess().equals("0")) {
                    Toast.makeText(MainActivity.this, "" + model.getSuccess(), Toast.LENGTH_SHORT).show();
>>>>>>>>> Temporary merge branch 2

               /*     // Creating adapter for spinner
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, userType);

                    // Drop down layout style - list view with radio button
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    // attaching data adapter to spinner
                    spinner.setAdapter(dataAdapter);*/



                } else if (model.getSuccess().equals("0")) {
                    Toast.makeText(MainActivity.this, "" + model.getSuccess(), Toast.LENGTH_SHORT).show();

                }
            }
        }).execute();
        categoryList = findViewById(R.id.categoryList);
        productList=findViewById(R.id.popularproduct);
        bottomAppBar=findViewById(R.id.bar);
        setSupportActionBar(bottomAppBar);
        titles = new ArrayList<>();
<<<<<<<<< Temporary merge branch 1
    }

    /*private void BindCategory() {


        StringRequest postRequest = new StringRequest(Request.Method.POST, getCategoryURL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("CompanyId", "1");
=========
        //Spinner put data using api




>>>>>>>>> Temporary merge branch 2

    }



    //Bottom Navigation menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu:
                BottomSheetDialogFragment bottomSheetDialogFragment = new BottomFragment();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getClass().getSimpleName());
                //Toast.makeText(this, "Menu ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart:
                Fragment selectedFragment = null;
                selectedFragment = new CartFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, selectedFragment).commit();
                //final Fragment fragmentcart = new CartFragment();
                //fragmentcart.show(getSupportFragmentManager(),fragmentcart.getClass().getSimpleName());
                //final FragmentManager fm = getSupportFragmentManager();
                //fm.beginTransaction().show(fragmentcart).commit();
                //active = fragment1;


                /*CartFragment cartFragment = new CartFragment();
                FragmentManager fragmentManagerCart = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManagerCart.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, cartFragment);
               // fragmentTransaction.commit();*/
                //Toast.makeText(this, "Order History ", Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

<<<<<<<<< Temporary merge branch 1
    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
=========
>>>>>>>>> Temporary merge branch 2
}
