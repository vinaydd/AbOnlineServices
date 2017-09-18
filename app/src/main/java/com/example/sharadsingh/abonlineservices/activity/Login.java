package com.example.sharadsingh.abonlineservices.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.sharadsingh.abonlineservices.R;
import com.example.sharadsingh.abonlineservices.response.BaseResponse;
import com.example.sharadsingh.abonlineservices.response.LoginResponse;
import com.example.sharadsingh.abonlineservices.utils.Constants;
import com.example.sharadsingh.abonlineservices.web.WebcallMaegerClass;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 7/11/16.
 */
public class Login extends CommonBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginnew);
        Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SlidingMenuActvity.class);
                startActivity(intent);
            }
        });

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("vehicleNumber", "UP200002");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        WebcallMaegerClass.getInstance().getLogin(this, Constants.JSON_OBJECTS, Constants.GET_REQUEST, null, true);
    }

    @Override
    public <T> void processResponse(T result) {
        super.processResponse(result);
        BaseResponse baseResponse = (BaseResponse) result;
        if (result instanceof LoginResponse) {
            LoginResponse resp = (LoginResponse) result;
        }
    }
}
