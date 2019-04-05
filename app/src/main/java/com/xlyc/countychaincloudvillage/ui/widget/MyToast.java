package com.xlyc.countychaincloudvillage.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xlyc.countychaincloudvillage.R;


public class MyToast {
    private static Toast toast = null;

    public static void showHMToast(Activity context, boolean success, String msg) {
        if (context == null) {
            return;
        }

        LayoutInflater inflater = context.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_my, null);
        ImageView image = (ImageView) layout.findViewById(R.id.icon);
        if (success) {
            image.setImageResource(R.drawable.tan_right);
        } else {
            image.setImageResource(R.drawable.tan_misk);
        }
        TextView msgTV = (TextView) layout.findViewById(R.id.msg);
        msgTV.setText(msg);
        if (toast == null) {
            toast = new Toast(context);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
        }

        toast.setView(layout);
        toast.show();
    }

    public static void showToast(Context context, String msg) {
        if (context == null) {
            return;
        }

        toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 200);
        toast.show();
    }

    public static void closeToast(Context context) {
        if (toast != null) {
            toast.cancel();
        }
    }
}
