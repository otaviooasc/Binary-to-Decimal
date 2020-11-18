package com.example.binarytodecimal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn_convert_decimal = findViewById(R.id.btn_result_decimal);
        final Button btn_convert_binary = findViewById(R.id.btn_result_binary);
        final EditText edit_txt_binary = findViewById(R.id.edit_txt_binary);
        final EditText edit_txt_decimal = findViewById(R.id.edit_txt_decimal);
        final Operations op = new Operations();

        edit_txt_binary.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus==false) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        edit_txt_decimal.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus==false){
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
            }
        });

        btn_convert_binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edit_txt_binary.getText().toString().isEmpty()){
                    op.setBinary(edit_txt_binary.getText().toString());
                    try{
                        op.setResult(Integer.parseInt(op.getBinary(),2));
                        edit_txt_decimal.setText(op.getResult() + "");
                    }catch (Exception e){
                        Snackbar.make(v, "Error. Enter the number in binary.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                }else {
                    Snackbar.make(v, "Enter some value.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
        btn_convert_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edit_txt_decimal.getText().toString().isEmpty()) {
                    op.setDecimal(edit_txt_decimal.getText().toString());
                    int i = Integer.parseInt(op.getDecimal());
                    try {
                        op.setBinary(Integer.toBinaryString(i));
                        edit_txt_binary.setText(op.getBinary());
                    }catch (Exception e) {
                        System.out.println("Error. Do not type letters.");
                    }
                }else {
                    Snackbar.make(v, "Enter some value.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
    }
}