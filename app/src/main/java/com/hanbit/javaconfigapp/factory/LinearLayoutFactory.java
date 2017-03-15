package com.hanbit.javaconfigapp.factory;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Map;

/**
 * Created by hb2000 on 2017-03-15.
 */

public class LinearLayoutFactory {
    public static LinearLayout createLinearLayout(Context context, Map<String, String> map){
        LinearLayout linearLayout=null;
        switch (map.get("type")){
            case "vertical":
                linearLayout=new LinearLayout(context);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setLayoutParams(LayoutParamsFactory.createLayoutParams(map.get("layoutParams")));
                break;
        }
        return linearLayout;
    }
}
