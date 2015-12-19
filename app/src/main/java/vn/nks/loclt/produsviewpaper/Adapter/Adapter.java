package vn.nks.loclt.produsviewpaper.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.nks.loclt.mylibrary.RecyclerViewPager;
import vn.nks.loclt.produsviewpaper.R;

/**
 * Created by loc on 19/12/2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.Viewhole> {

    //?
    private static final int DEFAULT_ITEM_COUNT = 100;
    Context context;
    RecyclerView mreRecyclerView;
    List<Integer> list;


    @Override
    public Viewhole onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        Viewhole vh = new Viewhole(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Viewhole holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class Viewhole extends RecyclerView.ViewHolder {
        TextView txttitle;

        public Viewhole(View itemView) {
            super(itemView);

        }
    }


}
