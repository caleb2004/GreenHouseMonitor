package com.example.greenglobal.greenhousemonitor.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.greenglobal.greenhousemonitor.R;
//import com.example.greenglobal.greenhousemonitor.view.Input;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;


@EBean
public class Dialog {

    @RootContext
    Activity activity;

    @UiThread
    public void showWarning(final int stringResource){
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        /*builder.setPositiveButton(activity.getString(R.string.dismiss), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });*/
        builder.setMessage(activity.getString(stringResource));
        builder.show();
    }

    @UiThread
    public void showInfo(final int stringResource, final boolean finishActivity){
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        /*builder.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                if (finishActivity) {
                    activity.finish();
                }
            }
        });*/
        builder.setMessage(activity.getString(stringResource));
        builder.show();
    }

}
