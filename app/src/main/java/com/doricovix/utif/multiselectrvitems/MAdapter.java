package com.doricovix.utif.multiselectrvitems;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by utif on 8/26/2017.
 */

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {
    private Context context;
    private List<Model> modelList;
    private ViewHolder holder;
    private View view;
    private ClickListener mClickListener;

    public MAdapter(Context context, List<Model> modelList, ClickListener listener) {
        this.context = context;
        this.modelList = modelList;
        this.mClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        holder = new ViewHolder(view);

        return holder;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        SparseBooleanArray selectedItems = new SparseBooleanArray();

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.song_title);
            desc = (TextView) itemView.findViewById(R.id.song_author);
        }

        public void bind(final Model model, final ClickListener mClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(model, getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mClickListener.onItemLongClick(v, model, getAdapterPosition(), selectedItems);

                    return true;
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(modelList.get(position).getTitle());
        holder.desc.setText(modelList.get(position).getDesc());

        holder.bind(modelList.get(position), mClickListener);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void doRemoveItem(int position){
        modelList.remove(position);
        notifyItemRangeRemoved(position, getItemCount());
        notifyDataSetChanged();
    }

    public interface ClickListener{
        void onItemClick(Model itemModel, int position);
        void onItemLongClick(View v, Model itemModel, int position, SparseBooleanArray selectedItems);
    }
}
