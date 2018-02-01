package com.fpp.androidtestapp.activity.impl.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fpp.androidtestapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.Holder> {
    private ArrayList<Message> list = new ArrayList<>();
    private Context context;
    private boolean show;


    public RVAdapter(Context context, List<Message> list, Boolean show) {
        this.list = (ArrayList<Message>) list;
        this.context = context;
        this.show = show;
        Log.e("-ss----", String.valueOf(list));
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (show) {
            Log.e("----sssssss---show----------", "" + show);
            View view = LayoutInflater.from(context).inflate(R.layout.all_products_one_lines, parent, false);
            Holder holder = new Holder(view);
            return holder;
        } else {
            Log.e("-------show----------", "" + show);
            View view = LayoutInflater.from(context).inflate(R.layout.all_products_two_lines, parent, false);
            Holder holder = new Holder(view);
            Log.e("-------------------------------------", "++++++++++++++++++++++++++++++++++++");
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tvContent.setText(list.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tvContent;
        public TextView txt_addCart;
        public TextView txt_collect;
        public LinearLayout llLayout;
        public TextView tvSalesVolume;

        public Holder(View itemView) {
            super(itemView);

            tvContent = (TextView) itemView.findViewById(R.id.all_products_sales_price);
            txt_addCart = (TextView) itemView.findViewById(R.id.tvDelete);
            txt_collect = (TextView) itemView.findViewById(R.id.tvTop);
            llLayout = (LinearLayout) itemView.findViewById(R.id.llLayout);
            tvSalesVolume = (TextView) itemView.findViewById(R.id.all_products_sales_volume);

        }
    }
}
