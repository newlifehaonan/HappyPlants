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

public class PlantLaterRecyclerViewAdapter extends RecyclerView.Adapter<PlantLaterRecyclerViewAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private ArrayList<PlantProfile> plantLaterProfiles;
    private Context context;
    private RecyclerViewListener recyclerViewListener;

    public PlantLaterRecyclerViewAdapter(Context context, ArrayList<PlantProfile> plantProfiles)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.plantLaterProfiles = plantProfiles;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = layoutInflater.inflate(R.layout.later_card, parent, false);
        PlantLaterRecyclerViewAdapter.ViewHolder viewHolder = new PlantLaterRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.specie.setText(plantLaterProfiles.get(position).getSpecies().toString());
        holder.specie_des.setText(plantLaterProfiles.get(position).getDescription());
        // something went wrong here.
        holder.later_avatar.setImageDrawable(context.getDrawable(plantLaterProfiles.get(position).getAvatar()));
    }

    @Override
    public int getItemCount() {
        return plantLaterProfiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView specie;
        private TextView specie_des;
        private ImageView later_avatar;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.specie = itemView.findViewById(R.id.later_specie);
            this.specie_des = itemView.findViewById(R.id.later_species_description);
            this.later_avatar = itemView.findViewById(R.id.later_avatar);
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
        return plantLaterProfiles.get(id);
    }

    public void setClickListener(RecyclerViewListener orecyclerViewListener)
    {
        this.recyclerViewListener = orecyclerViewListener;
    }
}
