package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dayouzc.e2e.core.E2EAppClientContext;
import com.dayouzc.e2e.core.config.E2ESvrConfig;
import com.dayouzc.e2e.core.constant.common.BaseConstant;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.Api;
import com.dayouzc.e2eapp.mcard.dto.McardTypeDTO;

import java.util.List;
/**
 * ================================================
 *
 * @Description: 卡适配
 * @Author qc
 * ================================================
 */
public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<McardTypeDTO> data;
    private OnItemClickListener onItemClickListener;

    public CardRecyclerAdapter(Context context, List<McardTypeDTO> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_recycler_card, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int newPos = position % data.size();
        String imageUrl = Api.BaseUrl + ":" + E2ESvrConfig.connectPort + "/" + BaseConstant.ContextPath.RBWEB_PATH + "/files/owner/" + data.get(newPos) + "/MAINIMG?token=" + E2EAppClientContext.getToken();
        Glide.with(context).load(imageUrl).into(holder.img);
        holder.tv.setText(data.get(newPos).getTypeName());
        holder.itemView.setTag(position);


    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, (Integer) view.getTag());
        }
    }

    //Holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_home_card_pic);
            tv = itemView.findViewById(R.id.tv_home_card_name);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;

    }

    interface OnItemClickListener {
        void onItemClick(View view, int tag);
    }
}
