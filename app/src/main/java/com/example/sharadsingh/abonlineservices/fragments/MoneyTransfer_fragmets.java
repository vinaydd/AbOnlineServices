package com.example.sharadsingh.abonlineservices.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sharadsingh.abonlineservices.R;
import com.example.sharadsingh.abonlineservices.activity.SlidingMenuActvity;
import com.example.sharadsingh.abonlineservices.adapter.Home_Adapter;
import com.example.sharadsingh.abonlineservices.adapter.MoneyTrasnfer_Adapter;
import com.example.sharadsingh.abonlineservices.response.BaseResponse;
import com.example.sharadsingh.abonlineservices.response.LoginResponse;


/**
 * Created by root on 7/11/16.
 */
public class MoneyTransfer_fragmets extends CommonBaseFragment {
    public static MoneyTransfer_fragmets newInstance() {
        MoneyTransfer_fragmets fragment = new MoneyTransfer_fragmets();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragments, container, false);
        ((SlidingMenuActvity)getActivity()).setActionBarTitle("MoneyTransfer");
        RecyclerView recList = (RecyclerView) view.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        GridLayoutManager Glm = new GridLayoutManager(getActivity(), 2);
        recList.setLayoutManager(Glm);
       // WebcallMaegerClass.getInstance().getLogin(getActivity(), Constants.JSON_OBJECTS, Constants.POST_REQUEST, jsonObject, true);


        String [] gridViewStrings = {"Prepaid", "postpaid", "DTH","DataCard"};
        int[] gridViewImages = {R.mipmap.ic_launcher,  R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        MoneyTrasnfer_Adapter mSettingAdapter = new MoneyTrasnfer_Adapter(getActivity(), gridViewStrings, gridViewImages);
        recList.setAdapter(mSettingAdapter);


        return view;
    }

    @Override
    public <T> void processFragmentResponse(T result) {
        super.processFragmentResponse(result);
        BaseResponse baseResponse = (BaseResponse) result;
        if (result instanceof LoginResponse) {

        }
    }
}
