package afinal.csc472.depaul.edu.houseplants;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SearchAllRecyclerViewAdapter extends RecyclerView.Adapter<SearchAllRecyclerViewAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private ArrayList<PlantProfile> plantProfiles;
    private RecyclerViewListener recyclerViewListener;
    private Context context;

    public SearchAllRecyclerViewAdapter(Context context, ArrayList<PlantProfile> plantProfiles) {
        this.layoutInflater = LayoutInflater.from(context);
        this.plantProfiles = plantProfiles;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = layoutInflater.inflate(R.layout.later_card, parent, false);
        SearchAllRecyclerViewAdapter.ViewHolder viewHolder = new SearchAllRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.specie.setText(plantProfiles.get(position).getSpecies().toString());
        holder.specie_des.setText(plantProfiles.get(position).getDescription());
        // something went wrong here.
        holder.later_avatar.setImageDrawable(context.getDrawable(plantProfiles.get(position).getAvatar()));
    }

    @Override
    public int getItemCount() {
        return plantProfiles.size();
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

    public void setClickListener(RecyclerViewListener orecyclerViewListener)
    {
        this.recyclerViewListener = orecyclerViewListener;
    }
}
