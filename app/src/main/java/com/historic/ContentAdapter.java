package com.historic;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nithin on 12/2/2016.
 */
public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentHolder>{
//    public static final String KEY_LINK ="desc";

    private List<Content> personalityList;
    private Context context;
    public class ContentHolder extends RecyclerView.ViewHolder {
        private TextView name, period, excerpt;
        private View contentView;
        private ImageView image;

        public ContentHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            excerpt = (TextView) itemView.findViewById(R.id.excerpt);
            period = (TextView) itemView.findViewById(R.id.period);
            image = (ImageView) itemView.findViewById(R.id.person_images);
            contentView = itemView;
        }
    }

    public ContentAdapter(List<Content> personalityList, Context context){
        this.personalityList = personalityList;
        this.context = context;
    }

    @Override
    public ContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.historic_row, parent,false);
        return new ContentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContentHolder holder, final int position){
        Content model = personalityList.get(position);
        holder.name.setText(model.getName());
        holder.excerpt.setText(model.getExcerpt());
        holder.period.setText(" " + model.getPeriod());
        holder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("country", personalityList.get(position).getCountry());
                intent.putExtra("description",personalityList.get(position).getDescription());
                intent.putExtra("references",personalityList.get(position).getReferences());
                intent.putExtra("full_name",personalityList.get(position).getFullName());
                intent.putExtra("keys",personalityList.get(position).getKeys());

                intent.putExtra("pass", (Serializable) personalityList.get(position));
                context.startActivity(intent);
            }
        });
        if (null != model.getImage() && null!=model.getCountry() && null!= model.getPeriod()) {
//            holder.country.setText(" "+model.getCountry());
            holder.image.setImageResource(Utils.getResId(model.getImage(),R.drawable.class));
        }
//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                Context context = view.getContext();
//                Intent intent = new Intent(context, DetailsActivity.class);
//                context.startActivity(intent);
////                Toast.makeText(context, "Recycle", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount(){
        return personalityList.size();
    }
}
