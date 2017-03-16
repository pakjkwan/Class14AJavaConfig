package com.hanbit.javaconfigapp.member;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbit.javaconfigapp.action.IDetail;
import com.hanbit.javaconfigapp.factory.Composite;
import com.hanbit.javaconfigapp.factory.DetailQuery;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**/
public class MemberDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=MemberDetail.this;
        Intent intent=this.getIntent();
        final String id=intent.getExtras().getString("id").toString();
        HashMap<String,Object>components=(HashMap<String,Object>)init(context);
        final DetailDAO dao=new DetailDAO(context);
        IDetail service=new IDetail() {
            @Override
            public Map<String,String> detail() {
                return dao.detail("select _id AS id,name,phone,age,address,salary from member where _id='"+id+"';");
            }
        };
        Map<String,String>rsMap= (Map<String,String>)service.detail();
        String temp="";
        Iterator<Map.Entry<String,String>>it=rsMap.entrySet().iterator();
        while (it.hasNext()){
           Map.Entry<String,String>entry=it.next();
           temp+=entry.getKey()+","+entry.getValue()+",";
        }
        final String spec=temp;
        TextView tvIdContent= (TextView) components.get("tvIdContent");
        tvIdContent.setText(rsMap.get("id"));
        TextView tvNameContent= (TextView) components.get("tvNameContent");
        tvNameContent.setText(rsMap.get("name"));
        TextView tvPhoneContent= (TextView) components.get("tvPhoneContent");
        tvPhoneContent.setText(rsMap.get("phone"));
        TextView tvAgeContent= (TextView) components.get("tvAgeContent");
        tvAgeContent.setText(rsMap.get("age"));
        TextView tvAddressContent= (TextView) components.get("tvAddressContent");
        tvAddressContent.setText(rsMap.get("address"));
        TextView tvSalaryContent= (TextView) components.get("tvSalaryContent");
        tvSalaryContent.setText(rsMap.get("salary"));
        setContentView((LinearLayout) components.get("frame"));
        Button btLocation= (Button) components.get("btLocation");
        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button btGoogleMap= (Button) components.get("btGoogleMap");
        btGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button btGallery= (Button) components.get("btGallery");
        btGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button btMusic= (Button) components.get("btMusic");
        btGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button btSMS= (Button) components.get("btSMS");
        btGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button btMail= (Button) components.get("btMail");
        btGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button btDial= (Button) components.get("btDial");
        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "));
                //intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + map.get("phoneNum")));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Button btCall= (Button) components.get("btCall");
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "));
                //intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + map.get("phoneNum")));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Button btList= (Button) components.get("btList");
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));

            }
        });
        Button btUpdate= (Button) components.get("btUpdate");
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MemberUpdate.class);
                intent.putExtra("spec",spec);
                startActivity(intent);
            }
        });
    }
    class DetailDAO extends DetailQuery {
        public DetailDAO(Context context) {
            super(context);
        }
        @Override
        public Map<String,String> detail(String sql) {
            Map<String,String> map=new HashMap<>();
            SQLiteDatabase db=super.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);
            if(cursor!=null) {
                if (cursor.moveToNext()){
                    map.put("id",cursor.getString(cursor.getColumnIndex("id")));
                    map.put("name",cursor.getString(cursor.getColumnIndex("name")));
                    map.put("age",cursor.getString(cursor.getColumnIndex("age")));
                    map.put("phone",cursor.getString(cursor.getColumnIndex("phone")));
                    map.put("address",cursor.getString(cursor.getColumnIndex("address")));
                    map.put("salary",cursor.getString(cursor.getColumnIndex("salary")));
                }
            }
            return map;
        }
    }
    public HashMap<?,?>init(Context context){
        Composite compo=new Composite(context,"MemberDetail");
        compo.execute();
        setContentView(compo.getFrame());
        return compo.getComponents();
    }
}
