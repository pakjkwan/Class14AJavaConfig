package com.hanbit.javaconfigapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbit.javaconfigapp.factory.ButtonFactory;
import com.hanbit.javaconfigapp.factory.LinearLayoutFactory;
import com.hanbit.javaconfigapp.factory.TextViewFactory;
import com.hanbit.javaconfigapp.member.MemberList;

import java.util.HashMap;
import java.util.Map;

public class Index extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=Index.this;
        init(context);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));
            }
        });
    }
    public void init(Context context){
        Map<String,String>map=new HashMap<>();
        map.put("type","vertical");
        map.put("layoutParams","mm");
        LinearLayout frame= LinearLayoutFactory.createLinearLayout(context,map);
        map.clear();
        map.put("type","basic");
        map.put("text","HELLO");
        map.put("layoutParams","mw");
        map.put("color","white");
        TextView textView = TextViewFactory.createTextView(context,map);
        map.clear();
        map.put("type","basic");
        map.put("text","ENTER");
        map.put("layoutParams","mw");
        map.put("color","#00FF00");
        button=ButtonFactory.createButton(context,map);
        frame.addView(textView);
        frame.addView(button);
        setContentView(frame);
        ViewGroup.MarginLayoutParams textViewMargin=new ViewGroup.MarginLayoutParams(textView.getLayoutParams());
        textViewMargin.setMargins(0, 200, 0, 0);
        textView.setLayoutParams(new LinearLayout.LayoutParams(textViewMargin));
        ViewGroup.MarginLayoutParams buttonMargin=new ViewGroup.MarginLayoutParams(button.getLayoutParams());
        buttonMargin.setMargins(0, 300, 0, 0);
        button.setLayoutParams(new LinearLayout.LayoutParams(buttonMargin));
    }
}
// message: title, content, writedate, sender, receiver
