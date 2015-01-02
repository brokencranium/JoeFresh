package com.vv.buildstuff.joefresh.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vv.buildstuff.joefresh.R;

import java.util.ArrayList;

/**
 * Created by vvennava on 12/27/14.
 */
public class RetailStoresAdapter extends RecyclerView.Adapter<RetailStoresAdapter.ViewHolder> {
    private ArrayList<Model> mDataset;
    private OnItemClickListener mListener;

    public RetailStoresAdapter(ArrayList<Model> mDataset) {
        this.mDataset = mDataset;
    }

    public RetailStoresAdapter(ArrayList<Model> myDataset, OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater vi = LayoutInflater.from(parent.getContext());
        View v = vi.inflate(R.layout.list_row, null);
//        View v = vi.inflate(R.layout.list_row, parent, false);
//        TextView tv = (TextView) v.findViewById(R.id.storeName);
//        CheckBox cb = (CheckBox) v.findViewById(R.id.check);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    /**
     * Interface for receiving click events from cells.
     */
    /**
     * Custom viewholder for the retail stores view.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView mTextView;
        public  CheckBox mCheckBox;


        public ViewHolder(View listRowView) {
            super(listRowView);
            mTextView = (TextView) listRowView.findViewById(R.id.storeName);
            mCheckBox = (CheckBox) listRowView.findViewById(R.id.check);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnItemClickListener {
        public void onClick(View view, int position);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText((mDataset.get(position)).getName());
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(view, position);

            }
        });
    }


}
