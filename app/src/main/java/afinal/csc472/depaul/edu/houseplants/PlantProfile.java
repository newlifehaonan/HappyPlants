package afinal.csc472.depaul.edu.houseplants;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class PlantProfile implements Parcelable{
    private String nickname;
    private Plant species;
    private int time;
    private String description;
    private int avatar;
    public PlantProfile(Plant species) {
        this.species = species;
        setupDescription();
        setupWaterTime();
        setupAvatar();
    }

    public PlantProfile(String nickname, String description,Plant species, int time, int avatar) {
        this.nickname = nickname;
        this.species = species;
        this.description = description;
        this.time = time;
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public Plant getSpecies() {
        return species;
    }

    public int getTime() {
        return time;
    }

    public String getDescription(){ return description;}

    public int getAvatar() {return avatar;}

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSpecies(Plant species) {
        this.species = species;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private void setupDescription(){
        switch (this.species) {
            case Jade:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case Bamboo:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case Cactus:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case Spider:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case DevilIvy:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case Satsuki:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case MassCane:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case ceropegia:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case Evergreen:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case GroundIvy:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case WizardMix:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case ChineseElm:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case FicusRetusa:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case DehliaTubers:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case ChristmasFern:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case JapaneseMaple:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
            case CreepingDogwood:
                this.description
                        = String.format("The rules for the %s includes All require lots of sun to look their best. " +
                        "They require gritty porous soil with excellent drainage. " +
                        "Water regularly over the summer months letting the soil dry out between waterings", this.species.toString());
                return;
        }
    }

    private void setupWaterTime() {
        switch (this.species) {
            case Jade:
                this.time = 10000;
                return;
            case Bamboo:
                this.time = 20000;
                return;
            case Cactus:
                this.time = 30000;
                return;
            case Spider:
                this.time = 40000;
                return;
            case DevilIvy:
                this.time = 50000;
                return;
            case Satsuki:
                this.time = 60000;
                return;
            case MassCane:
                this.time = 50000;
                return;
            case ceropegia:
                this.time = 40000;
                return;
            case Evergreen:
                this.time = 30000;
                return;
            case GroundIvy:
                this.time = 20000;
                return;
            case WizardMix:
                this.time = 10000;
                return;
            case ChineseElm:
                this.time = 20000;
                return;
            case FicusRetusa:
                this.time = 30000;
                return;
            case DehliaTubers:
                this.time = 40000;
                return;
            case ChristmasFern:
                this.time = 50000;
                return;
            case JapaneseMaple:
                this.time = 60000;
                return;
            case CreepingDogwood:
                this.time = 50000;
                return;
        }
    }

    private void setupAvatar() {
        switch (this.species) {
            case Jade:
                this.avatar = R.drawable.bonsaiimg;
                return;
            case Bamboo:
                this.avatar = R.drawable.cleanairplant;
                return;
            case Cactus:
                this.avatar = R.drawable.floweringimg;
                return;
            case Spider:
                this.avatar = R.drawable.hangingimg;
                return;
            case DevilIvy:
                this.avatar = R.drawable.hangingimg;
                return;
            case Satsuki:
                this.avatar = R.drawable.floweringimg;
                return;
            case MassCane:
                this.avatar = R.drawable.cleanairplant;
                return;
            case ceropegia:
                this.avatar = R.drawable.hangingimg;
                return;
            case Evergreen:
                this.avatar = R.drawable.officeplant;
                return;
            case GroundIvy:
                this.avatar = R.drawable.groundimg;
                return;
            case WizardMix:
                this.avatar = R.drawable.bonsaiimg;
                return;
            case ChineseElm:
                this.avatar = R.drawable.bonsaiimg;
                return;
            case FicusRetusa:
                this.avatar = R.drawable.floweringimg;
                return;
            case DehliaTubers:
                this.avatar = R.drawable.officeplant;
                return;
            case ChristmasFern:
                this.avatar = R.drawable.hangingimg;
                return;
            case JapaneseMaple:
                this.avatar = R.drawable.floweringimg;
                return;
            case CreepingDogwood:
                this.avatar = R.drawable.groundimg;
                return;
        }
    }

    public int getClipAvatar() {
        switch (this.avatar) {
            case R.drawable.bonsaiimg:
                return R.drawable.bonsai_clip;
            case R.drawable.cleanairplant:
                return R.drawable.cleanair_clip;
            case R.drawable.floweringimg:
                return R.drawable.flowering_clip;
            case R.drawable.groundimg:
                return R.drawable.ground_clip;
            case R.drawable.officeplant:
                return R.drawable.plant_with_oval_clip;
            case R.drawable.hangingimg:
                return R.drawable.hanging_clip;
        }
        return 0;
    }

    protected PlantProfile(Parcel in) {
        this.nickname = in.readString();
        this.species = (Plant)in.readSerializable();
        this.description = in.readString();
        this.time = in.readInt();
        this.avatar = in.readInt();
    }

    public static final Parcelable.Creator<PlantProfile> CREATOR = new Parcelable.Creator<PlantProfile>() {
        @Override
        public PlantProfile createFromParcel(Parcel source) {
            return new PlantProfile(source);
        }

        @Override
        public PlantProfile[] newArray(int size) {
            return new PlantProfile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nickname);
        dest.writeSerializable(this.species);
        dest.writeString(this.description);
        dest.writeInt(this.time);
        dest.writeInt(this.avatar);
    }
}
