package com.xlyc.countychaincloudvillage.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.xlyc.countychaincloudvillage.R;

public class DialogUtil {


    //选择朋友圈发布类型
    public static void showReleaseSelectBtmDialog(Context context, OnTypeSelectListener selectListener) {
        Dialog dialog = new Dialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_btm_release_select_type_layout, null);
        view.findViewById(R.id.dPhotograph).setOnClickListener(v -> {
            dialog.dismiss();
            selectListener.onPhotograph();
        });
        view.findViewById(R.id.dPhotoAlbum).setOnClickListener(v -> {
            dialog.dismiss();
            selectListener.onPhotoAlbum();
        });
        view.findViewById(R.id.dShootVideo).setOnClickListener(v -> {
            dialog.dismiss();
            selectListener.onShootVideo();
        });
        view.findViewById(R.id.dCancel).setOnClickListener(v -> dialog.dismiss());

        dialog.setContentView(view);
        dialog.show();
    }


    public interface OnTypeSelectListener {
        void onPhotograph();

        void onShootVideo();

        void onPhotoAlbum();
    }


}
