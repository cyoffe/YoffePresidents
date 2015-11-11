package yoffe.presidents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {

    private President[] presidents;
    private Integer[] pictures;

    public PresidentAdapter(President[] presidents, Integer[] pictures){
        this.presidents = presidents;
        this.pictures = pictures;
    }

    @Override
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.president_list_item, parent, false);

        return new PresidentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PresidentViewHolder holder, final int position) {
        holder.bind(presidents[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("PICTURES", pictures);
                intent.putExtra("PRESIDENTS", presidents);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presidents.length;
    }
}
