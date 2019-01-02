package afinal.csc472.depaul.edu.houseplants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.Random;

public class SharedData {
    private Selection selection;
    private ArrayList<PlantProfile> plant;
    private db db;
    private PlantProfile plantProfile;
    private static SharedData sharedData = null;
    static
    {
        sharedData = new SharedData();
    }

    private SharedData()
    {
        this.db = null;
        this.selection = new Selection();
        this.plant = new ArrayList<PlantProfile>();
        for(Plant spices : Plant.values()){
            PlantProfile item = new PlantProfile(spices);
            this.plant.add(item);
        }
    }

    public void setDb(afinal.csc472.depaul.edu.houseplants.db db) {
        this.db = db;
    }

    public db getDb(){
        return this.db;
    }

    public static SharedData getSharedData()
    {
        return sharedData;
    }

    public Selection getSelection() {
        return selection;
    }

    public void setNickname(String nickname){
        this.plantProfile.setNickname(nickname);
    }

    public PlantProfile finalresult() {
//        lightfilter(selection);
//        difficultyfilter(selection);
//        environmentfilter(selection);
//        spicesfilter(selection);
//        return this.plant;
//        This is the fake data we need for database testing;
//        rendomly select one from your list of Plant
        Random randomizer = new Random();
        PlantProfile yourplant = plant.get(randomizer.nextInt(plant.size()));
        this.plantProfile = yourplant;
        return this.plantProfile;
    }

    private void lightfilter(Selection selection){
        Light selected = selection.getLight();
        if(selected.equals(Light.LOW)){
            ArrayList<Plant> lowlight_species =
                    new ArrayList<Plant>(Arrays.asList(
                            Plant.FicusRetusa
                    ));
            this.plant.removeAll(lowlight_species);
        }
        else if (selected.equals(Light.MEDIUM)){
            ArrayList<Plant> medium_light_species =
                    new ArrayList<Plant>(Arrays.asList(Plant.Bamboo, Plant.ChineseElm, Plant.ChristmasFern,Plant.Cactus,Plant.DehliaTubers,Plant.FicusRetusa));
            this.plant.removeAll(medium_light_species);
        }
        else if (selected.equals(Light.HIGH)){
            ArrayList<Plant> highlight_species =
                    new ArrayList<Plant>(Arrays.asList(Plant.Bamboo, Plant.ChineseElm, Plant.ChristmasFern));
            this.plant.removeAll(highlight_species);
        }
        else {
            return;
        }
    }

    private void difficultyfilter(Selection selection){
        Difficulty selected = selection.getDifficulty();
        if(selected.equals(Difficulty.EASY)){

        }
        else if (selected.equals(Difficulty.AVERAGE)) {

        }
        else if (selected.equals(Difficulty.DIFFICULT)) {

        } else {
            return;
        }
    }

    private void environmentfilter(Selection selection) {
        Environment selected = selection.getEnvironment();
        if(selected.equals(Environment.yes)) {

        }
        else if (selected.equals(Environment.no)){

        }
        else {

        }
    }

    private void spicesfilter(Selection selection){
        Interest selected = selection.getInterest();
        if(selected.equals(Interest.bonsai)){
            ArrayList<Plant> bonsai_species =
                    new ArrayList<Plant>(Arrays.asList(
                            Plant.FicusRetusa
                    ));
            this.plant.removeAll(bonsai_species);
        }
        else if (selected.equals(Interest.cleanairplant)){

        }
        else if (selected.equals(Interest.ground)){

        }
        else if (selected.equals(Interest.flowering)){

        }
        else if (selected.equals(Interest.hanging)) {

        }
        else if (selected.equals(Interest.officeplants)){

        }
        else {

        }
    }

    public PlantProfile getPlantProfile() {
        return this.plantProfile;
    }
}
