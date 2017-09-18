package com.example.sharadsingh.abonlineservices.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sharadsingh.abonlineservices.R;

/**
 * Created by sharadsingh on 18/09/17.
 */

public class BillPayments_Adapter extends RecyclerView.Adapter<BillPayments_Adapter.SettingViewHolder> {
private Activity mContext;
private final String[] string;
private final int[] Imageid;
        int width;

public BillPayments_Adapter(Activity c, String[] string, int[] Imageid) {
        mContext = c;
        this.Imageid = Imageid;
        this.string = string;
        }

@Override
public int getItemCount() {
        return string.length;
        }

@Override
public void onBindViewHolder(final SettingViewHolder contactViewHolder, int position) {
        contactViewHolder.textSetting.setText(string[position]);
        contactViewHolder.settingImage.setImageResource(Imageid[position]);
        contactViewHolder.card_view.setLayoutParams(new CardView.LayoutParams((width / 2) - (width / 16), (width / 2) - (width / 16)));
        contactViewHolder.card_view.setTag(position);
        contactViewHolder.card_view.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
        if ((Integer) v.getTag() == 0) {
       // ((MainActivity) mContext).addFragment(new Profile(), mContext.getString(R.string.profile));
        }
        if ((Integer) v.getTag() == 1) {
      //  ((MainActivity) mContext).addFragment(new ChangeLanguageNew(), mContext.getString(R.string.change_language_forDash));
        }
        if ((Integer) v.getTag() == 2) {
       // ((MainActivity) mContext).addFragment(new MyWallet(), mContext.getString(R.string.my_wallet));
        }
        if ((Integer) v.getTag() == 3) {
       // ((MainActivity) mContext).addFragment(new NotificationSetting(), mContext.getString(R.string.notification_setting_forDash));
        }


        }
        });
        }

@Override
public SettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.
        from(viewGroup.getContext()).
        inflate(R.layout.home_fragments_list_item, viewGroup, false);
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        width = windowManager.getDefaultDisplay().getWidth();
        return new SettingViewHolder(itemView);
        }

public static class SettingViewHolder extends RecyclerView.ViewHolder {
    protected TextView textSetting;
    protected ImageView settingImage;
    protected CardView card_view;

    public SettingViewHolder(View v) {
        super(v);
        textSetting = (TextView) v.findViewById(R.id.textSetting);
        settingImage = (ImageView) v.findViewById(R.id.settingImage);
        card_view = (CardView) v.findViewById(R.id.card_view);
    }
}
}
