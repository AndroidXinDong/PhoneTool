package com.example.phonetool;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class FlowActivity extends AppCompatActivity {
    FlowLayout mFlowLayout;
    private String mNames[] = {
            "welcome","Android","TextView",
            "appleJamy","Kobe bryant",
            "jordan"," Bundle ","savedInstanceState"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        initView();
        initChildViews();
    }
    private void initView() {
        mFlowLayout = findViewById(R.id.flowLayout);
    }
    private void initChildViews() {
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 1;
        lp.rightMargin = 1;
        lp.topMargin = 1;
        lp.bottomMargin = 1;
        for(int i = 0; i < mNames.length; i ++){
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundResource(R.drawable.textview_bg);
            mFlowLayout.addView(view,lp);
        }
    }

}
