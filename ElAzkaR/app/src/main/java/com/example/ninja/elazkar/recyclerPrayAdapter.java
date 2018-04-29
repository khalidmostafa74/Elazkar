package com.example.ninja.elazkar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ninja on 19/02/2018.
 */

public class recyclerPrayAdapter extends RecyclerView.Adapter<recyclerPrayAdapter.recyclerViewHolder> {
   ArrayList<Pray> arrayList = new ArrayList<>();
   Context ctx;
   public recyclerPrayAdapter(Context ctx,ArrayList<Pray>arrayList){
       this.arrayList=arrayList;
       this.ctx = ctx;
   }
    @Override
    public recyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_lay, parent, false);
        recyclerViewHolder viewHolder = new recyclerViewHolder(view,ctx,arrayList);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(recyclerViewHolder holder, int position) {
       Pray pray = arrayList.get(position);
       holder.btn.setText(pray.getPrayName());
       holder.tv1.setText(pray.getPrayHead());

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class recyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       Context ctx ;
       ArrayList<Pray> arrayList = new ArrayList<>();
        Button btn;
        TextView tv1;
        public recyclerViewHolder(final View itemView, Context ctx, ArrayList<Pray>arrayList) {
            super(itemView);
            this.ctx=ctx;
            this.arrayList=arrayList;
            itemView.setOnClickListener(this);
            btn = itemView.findViewById(R.id.but2);
            btn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_right, 0);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LinearLayout findMagicLl = (LinearLayout)itemView.findViewById(R.id.lin);
                    if (findMagicLl.getVisibility() == View.VISIBLE) {
                        ScaleAnimation animation = new ScaleAnimation(1f, 1f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
                        animation.setDuration(180);
                        animation.setFillAfter(true);
                        findMagicLl.startAnimation(animation);
                        findMagicLl.setVisibility(View.GONE);
                        btn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_right, 0);
                    } else {
                        ScaleAnimation animation = new ScaleAnimation(1f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
                        animation.setDuration(180);
                        animation.setFillAfter(true);
                        findMagicLl.startAnimation(animation);
                        findMagicLl.setVisibility(View.VISIBLE);
                        btn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_chevron_down, 0);
                    }
                }
            });
            tv1 = itemView.findViewById(R.id.tv);
        }

        @Override
        public void onClick(View view) {
        }
    }
}
