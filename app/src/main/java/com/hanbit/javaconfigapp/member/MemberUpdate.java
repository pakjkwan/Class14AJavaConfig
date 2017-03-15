package com.hanbit.javaconfigapp.member;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbit.javaconfigapp.action.IUpdate;
import com.hanbit.javaconfigapp.factory.LayoutParamsFactory;
import com.hanbit.javaconfigapp.factory.WriteQuery;

import java.util.HashMap;
import java.util.Map;

public class MemberUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context= MemberUpdate.this;
        Intent intent=this.getIntent();
        String spec=intent.getExtras().getString("spec").toString();
        Log.d("넘어온 스펙",spec);
        String[] specs=spec.split(",");
        final Map<String,String> map=new HashMap<>();
        String[]keys=new String[specs.length/2];
        String[]vals=new String[specs.length/2];
        int k=0,v=0;
        for(int i=0;i<specs.length;i++){
            String key="",val="";
            if((i%2)==0){
                Log.d("keys["+k+"] = specs["+i+"] :"+k,specs[i]);
                keys[k]=specs[i];
                k++;
            }else{
                Log.d("vals["+k+"] = specs["+i+"] :"+k,specs[i]);
                vals[v]=specs[i];
                v++;
            }
        }
        v=0;
        for(String key:keys){
            map.put(key,vals[v++]);
        }
        LinearLayout ui=new LinearLayout(context);
        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));

        LinearLayout uiId=new LinearLayout(context);
        uiId.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        final TextView tvId=new TextView(context);
        tvId.setText("ID: ");
        tvId.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvId.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvIdContent=new TextView(context);
        tvIdContent.setText("ID content");
        tvIdContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvIdContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiId.addView(tvId);
        uiId.addView(tvIdContent);
        ui.addView(uiId);

        LinearLayout uiName=new LinearLayout(context);
        uiName.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvName=new TextView(context);
        tvName.setText("NAME: ");
        tvName.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvNameContent=new TextView(context);
        tvNameContent.setText("NAME content");
        tvNameContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvNameContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiName.addView(tvName);
        uiName.addView(tvNameContent);
        ui.addView(uiName);

        LinearLayout uiPhone=new LinearLayout(context);
        uiPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvPhone=new TextView(context);
        tvPhone.setText("PHONE: ");
        tvPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        final EditText etPhoneContent=new EditText(context);
        etPhoneContent.setHint("PHONE content");
        etPhoneContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etPhoneContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiPhone.addView(tvPhone);
        uiPhone.addView(etPhoneContent);
        ui.addView(uiPhone);

        LinearLayout uiAge=new LinearLayout(context);
        uiAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvAge=new TextView(context);
        tvAge.setText("AGE: ");
        tvAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvAgeContent=new TextView(context);
        tvAgeContent.setText("AGE content");
        tvAgeContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAgeContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAge.addView(tvAge);
        uiAge.addView(tvAgeContent);
        ui.addView(uiAge);

        LinearLayout uiAddress=new LinearLayout(context);
        uiAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvAddress=new TextView(context);
        tvAddress.setText("ADDRESS: ");
        tvAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        final EditText etAddressContent=new EditText(context);
        etAddressContent.setHint("ADDRESS content");
        etAddressContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etAddressContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAddress.addView(tvAddress);
        uiAddress.addView(etAddressContent);
        ui.addView(uiAddress);

        LinearLayout uiSalary=new LinearLayout(context);
        uiSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvSalary=new TextView(context);
        tvSalary.setText("SALARY: ");
        tvSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvSalary.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        final EditText etSalaryContent=new EditText(context);
        etSalaryContent.setHint("SALARY content");
        etSalaryContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etSalaryContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiSalary.addView(tvSalary);
        uiSalary.addView(etSalaryContent);
        ui.addView(uiSalary);

        LinearLayout uiButton=new LinearLayout(context);
        uiButton.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        Button btCancel=new Button(context);
        btCancel.setLayoutParams(weight);
        btCancel.setText("CANCEL");
        btCancel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btConfirm=new Button(context);
        btConfirm.setLayoutParams(weight);
        btConfirm.setText("CONFIRM");
        btConfirm.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton.addView(btCancel);
        uiButton.addView(btConfirm);
        ui.addView(uiButton);
        tvIdContent.setText(map.get("id"));
        tvNameContent.setText(map.get("name"));
        etPhoneContent.setHint(map.get("phone"));
        tvAgeContent.setText(map.get("age"));
        etAddressContent.setHint(map.get("address"));
        etSalaryContent.setHint(map.get("salary"));
        setContentView(ui);

        final UpdateDAO dao=new UpdateDAO(context);
        final IUpdate updateService=new IUpdate() {
            @Override
            public void update() {
                String sql=String.format("update member set phone='%s',address='%s',salary='%s' where _id='%s'",
                        map.get("phone"),map.get("address"),map.get("salary"),map.get("id"));
                dao.update(sql);
            }
        };

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etPhoneContent.getText().toString().equals("")){
                    map.put("phone",etPhoneContent.getText().toString());
                }
                if(!etAddressContent.getText().toString().equals("")){
                    map.put("address",etAddressContent.getText().toString());
                }
                if(!etSalaryContent.getText().toString().equals("")){
                    map.put("salary",etSalaryContent.getText().toString());
                }
                updateService.update();
                Intent intent=new Intent(context,MemberDetail.class);
                intent.putExtra("id",map.get("id"));
                startActivity(intent);
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,MemberList.class));
            }
        });
    }
    class UpdateDAO extends WriteQuery {
        public UpdateDAO(Context context) {
            super(context);
        }
        @Override
        public void update(String sql) {
            super.getDatabase().execSQL(sql);
        }
    }
}
