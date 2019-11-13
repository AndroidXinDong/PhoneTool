package com.example.phonetool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void grow(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_tree:
                intent.setClass(this,TreeActivity.class);
                break;
            case R.id.btn_ls:
                intent.setClass(this,FlowActivity.class);
                break;
        }
        startActivity(intent);

    }
}
