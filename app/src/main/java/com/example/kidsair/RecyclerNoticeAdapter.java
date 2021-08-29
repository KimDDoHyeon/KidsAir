package com.example.kidsair;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerNoticeAdapter extends RecyclerView.Adapter<RecyclerNoticeAdapter.ItemViewHolder> {

    private ArrayList<NoticeData> listData = new ArrayList<>();
    private Context context;
    private SparseBooleanArray selectedItems =  new SparseBooleanArray();
    private int prePosition = -1;


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticeitem_recyclerview, parent, false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position),position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(NoticeData data) {
        listData.add(data);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView1;
        private TextView textView2;
        private ImageView imageView1;
        private int position;
        private NoticeData data;

        ItemViewHolder(View itemView){
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView4);
            textView2 = itemView.findViewById(R.id.textView12);
            imageView1 = itemView.findViewById(R.id.imageView2);

        }

        void onBind(NoticeData data, int position){
            this.data=data;
            this.position=position;

            textView1.setText(data.getTitle());
            textView2.setText(data.getContent());
            imageView1.setImageResource(data.getResId());

            changeVisibility(selectedItems.get(position));
            textView1.setOnClickListener(this);
            /*textView2.setOnClickListener(this);*/
            imageView1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (selectedItems.get(position)){
                selectedItems.delete(position);
            }else {
                selectedItems.delete(prePosition);
                selectedItems.put(position,true);
            }
            if (prePosition != -1) notifyItemChanged(prePosition);
            notifyItemChanged(position);
            prePosition = position;
        }

        private void changeVisibility(final boolean isExpanded) {

            int dpValue = 150;
            float d = context.getResources().getDisplayMetrics().density;
            int height = (int) (dpValue * d);

            ValueAnimator va = isExpanded ? ValueAnimator.ofInt(0, height) : ValueAnimator.ofInt(height, 0);
            va.setDuration(600);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int value = (int) animation.getAnimatedValue();
                    textView2.getLayoutParams().height = value;
                    textView2.requestLayout();
                    textView2.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                }
            });
            va.start();
            }
        }
    }

