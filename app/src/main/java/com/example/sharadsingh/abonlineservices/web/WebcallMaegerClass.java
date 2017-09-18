package com.example.sharadsingh.abonlineservices.web;

import android.content.Context;


import com.example.sharadsingh.abonlineservices.model.SatateModel;
import com.example.sharadsingh.abonlineservices.utils.Constants;

import org.json.JSONObject;

/**
 * Created by root on 10/11/16.
 */
public class WebcallMaegerClass {
    private static WebcallMaegerClass singleInstance;

    protected WebcallMaegerClass() {
    }

    public static WebcallMaegerClass getInstance() {
        if (singleInstance == null) {
            singleInstance = new WebcallMaegerClass();
        }
        return singleInstance;
    }

    public void getLogin(Context context, String requstType, String Mode, JSONObject obj, boolean isProgress) {
        CommonVollyClass<SatateModel> httptask = new CommonVollyClass<>(context, Constants.NEW_HOST_URL, SatateModel.class, Constants.STATE_KEY, requstType, Mode, obj);
        httptask.setIsApiKeyRequired(true);
        httptask.setForFragment(false);
        httptask.setShowProgress(isProgress);
    }

}
