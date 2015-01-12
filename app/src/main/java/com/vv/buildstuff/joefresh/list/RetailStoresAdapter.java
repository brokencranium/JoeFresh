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

    public ArrayList<Model> getDataSet() {
        return mDataset;
    }

    public void setDataSet(ArrayList<Model> dataSet) {
        this.mDataset = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater vi = LayoutInflater.from(parent.getContext());
        View v = vi.inflate(R.layout.list_row, null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
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

        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(view, position);
                (mDataset.get(position)).setToggle();

            }
        });

    }

    @Override
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
    }



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


}
