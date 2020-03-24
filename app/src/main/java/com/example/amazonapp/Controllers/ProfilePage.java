package com.example.amazonapp.Controllers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.amazonapp.R;


public class ProfilePage extends Fragment implements View.OnClickListener {


    Button btn_edit, btn_save;
    EditText edit_fname, edit_lname, edit_email, edit_cnumber, edit_pcode, edit_address;
    Spinner sp_ctry, sp_city, sp_province;


    //private AwesomeValidation awesomeValidation;


    public ProfilePage() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);



    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        btn_edit = view.findViewById(R.id.btn_update);
        btn_save = view.findViewById(R.id.btn_savechanges);
        edit_fname = view.findViewById(R.id.firstName_pr);

        edit_lname = view.findViewById(R.id.lastName_pr);
        edit_email = view.findViewById(R.id.emailaddress_pr);
        edit_cnumber = view.findViewById(R.id.contactnumber_pr);
        edit_pcode = view.findViewById(R.id.postalcode_pr);
        edit_address = view.findViewById(R.id.address_pr);

        sp_ctry = view.findViewById(R.id.country_pr);
        sp_city = view.findViewById(R.id.city_pr);
        sp_province = view.findViewById(R.id.province_pr);

        edit_fname.setEnabled(false);
        btn_edit.setText("Edit");

        btn_edit.setOnClickListener(this);

        //adding validation to edittexts
       /* awesomeValidation.addValidation(this, R.id.firstName_pr, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.lastName_pr, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.emailaddress_pr, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.contactnumber_pr, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);*/


        btn_save.setOnClickListener(this);

    }

  /*  private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(getActivity(), "Validate Successfully", Toast.LENGTH_SHORT).show();

            //process the data further
        }
    }*/


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_update:  //Your edit button
                enableDisableEditText();

                break;

            default:
                break;
        }

        /*if (view == btn_save) {
            submitForm();
        }*/
    }

    //method for enable or disable edittext
    private void enableDisableEditText() {
        edit_fname.setFocusableInTouchMode(true);
        edit_lname.setFocusableInTouchMode(true);
        edit_email.setFocusableInTouchMode(true);
        edit_cnumber.setFocusableInTouchMode(true);
        sp_ctry.setFocusableInTouchMode(true);
        sp_city.setFocusableInTouchMode(true);
        sp_province.setFocusableInTouchMode(true);
        edit_pcode.setFocusableInTouchMode(true);
        edit_address.setFocusableInTouchMode(true);
        if (edit_fname.isEnabled()) {
            edit_fname.setEnabled(false);;
            // btn_edit.setText("Edit");
        }
        else{
            edit_fname.setEnabled(true);

            // btn_edit.setText("Done");
        }
    }


}