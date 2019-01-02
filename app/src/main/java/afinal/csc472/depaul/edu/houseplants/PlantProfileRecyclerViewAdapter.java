package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlantProfileRecyclerViewAdapter extends RecyclerView.Adapter<PlantProfileRecyclerViewAdapter.ViewHolder>
{
    private LayoutInflater layoutInflater;
    private ArrayList<PlantProfile> plantProfiles;
    private RecyclerViewListener recyclerViewListener;
    private Context activity;

    public PlantProfileRecyclerViewAdapter(Context context, ArrayList<PlantProfile> plantProfiles)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.plantProfiles = plantProfiles;
        this.activity = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = layoutInflater.inflate(R.layout.plant_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.nickname.setText(plantProfiles.get(position).getNickname());
        holder.specie.setText(plantProfiles.get(position).getSpecies().toString());
        holder.wateringtime.setText(Integer.toString(plantProfiles.get(position).getTime()));
        holder.plant_pic.setImageDrawable(activity.getResources().getDrawable(plantProfiles.get(position).getAvatar()));
    }

    @Override
    public int getItemCount()
    {
        return plantProfiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView nickname;
        private TextView specie;
        private TextView wateringtime;
        private ImageView plant_pic;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.nickname = itemView.findViewById(R.id.nickname);
            this.specie = itemView.findViewById(R.id.planttype);
            this.wateringtime = itemView.findViewById(R.id.wateringtime);
            this.plant_pic = itemView.findViewById(R.id.plant_card_pic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(recyclerViewListener!=null){
                recyclerViewListener.Click(v, getAdapterPosition());
            }
        }
    }

    // getting value at click position
    public PlantProfile getItem(int id)
    {
        return plantProfiles.get(id);
    }

    public void setClickListener(RecyclerViewListener orecyclerViewListener)
    {
        this.recyclerViewListener = orecyclerViewListener;
    }
}
