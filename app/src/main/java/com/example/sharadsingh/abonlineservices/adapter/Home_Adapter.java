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
import com.example.sharadsingh.abonlineservices.activity.SlidingMenuActvity;
import com.example.sharadsingh.abonlineservices.fragments.BillPayments_fragmets;
import com.example.sharadsingh.abonlineservices.fragments.Home_fragmets;
import com.example.sharadsingh.abonlineservices.fragments.MoneyTransfer_fragmets;
import com.example.sharadsingh.abonlineservices.fragments.Recharge_fragmets;
import com.example.sharadsingh.abonlineservices.fragments.SettingFragments;

/**
 * Created by sharadsingh on 18/09/17.
 */

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.SettingViewHolder> {
private Activity mContext;
private final String[] string;
private final int[] Imageid;
        int width;

public Home_Adapter(Activity c, String[] string, int[] Imageid) {
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
            ((SlidingMenuActvity)mContext).transactionFragments(Recharge_fragmets.newInstance(), true, R.id.container, false, "Recharge");
        }
        if ((Integer) v.getTag() == 1) {
            ((SlidingMenuActvity)mContext).transactionFragments(BillPayments_fragmets.newInstance(), true, R.id.container, false, "BillPayments");
        }
        if ((Integer) v.getTag() == 2) {
            ((SlidingMenuActvity)mContext).transactionFragments(MoneyTransfer_fragmets.newInstance(), true, R.id.container, false, "MoneyTransfer");
        }
        if ((Integer) v.getTag() == 3) {
       // ((MainActivity) mContext).addFragment(new NotificationSetting(), mContext.getString(R.string.notification_setting_forDash));
        }
        if ((Integer) v.getTag() == 4) {
       // ((MainActivity) mContext).addFragment(new AccountDetailFragment(), mContext.getString(R.string.account_datail));
        }
        if ((Integer) v.getTag() == 5) {
            ((SlidingMenuActvity)mContext).transactionFragments(SettingFragments.newInstance(), true, R.id.container, false, "Setting");
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
