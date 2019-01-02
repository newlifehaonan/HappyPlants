package afinal.csc472.depaul.edu.houseplants;

public class Selection {
    private Light light;
    private Difficulty difficulty;
    private Interest interest;
    private Environment environment;

    public Selection() {
    }

    public Light getLight() {
        return light;
    }

    public Difficulty getDifficulty() {return difficulty;
    }

    public Interest getInterest() {
        return interest;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
