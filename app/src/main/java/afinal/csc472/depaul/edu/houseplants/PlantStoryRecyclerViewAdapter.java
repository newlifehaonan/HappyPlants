package afinal.csc472.depaul.edu.houseplants;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlantStoryRecyclerViewAdapter extends RecyclerView.Adapter<PlantStoryRecyclerViewAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private RecyclerViewListener recyclerViewListener;
    private ArrayList<PlantProfile> plantStory;
    private Context context;

    public PlantStoryRecyclerViewAdapter(Context context, ArrayList<PlantProfile> plantStory)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.plantStory = plantStory;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = layoutInflater.inflate(R.layout.story_card, parent, false);
        PlantStoryRecyclerViewAdapter.ViewHolder viewHolder = new PlantStoryRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.plant_index.setText(String.format("Plant %s", plantStory.get(i).getNickname()));
        holder.plant_des_name.setText(String.format("I added a plant %s named %s!", plantStory.get(i).getSpecies().toString(), plantStory.get(i).getNickname()));
        holder.plant_story_pic.setImageDrawable(context.getDrawable(plantStory.get(i).getAvatar()));
    }

    @Override
    public int getItemCount() {
        return plantStory.size();
    }

    public PlantProfile getItem(int id)
    {
        return plantStory.get(id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView plant_index;
        private TextView plant_des_name;
        private ImageView plant_story_pic;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.plant_index = itemView.findViewById(R.id.plant_index);
            this.plant_des_name = itemView.findViewById(R.id.plant_des_name);
            this.plant_story_pic = itemView.findViewById(R.id.plant_story_pic);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(recyclerViewListener!=null){
                recyclerViewListener.Click(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(RecyclerViewListener recyclerViewListener)
    {
        this.recyclerViewListener = recyclerViewListener;
    }
}
