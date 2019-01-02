package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class LocalStorage {
    private static LocalStorage localStorage = null;
    static
    {
        localStorage = new LocalStorage();
    }
    private LocalStorage() {

    }

    public static LocalStorage getLocalStorage() {
        return localStorage;
    }

    public void writeToG(Activity activity, PlantProfile plantProfile) {
        File dbFile= activity.getDatabasePath("plant.db");
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS GPlants(NickName VARCHAR, Discription VARCHAR, Specie VARCHAR, Time INTEGER, Avatar INTEGER);");
        sqLiteDatabase.execSQL(
                String.format(
                        "INSERT INTO GPlants VALUES('%s', '%s', '%s', %d, %d);",
                        plantProfile.getNickname(),
                        plantProfile.getDescription(),
                        plantProfile.getSpecies().toString(),
                        plantProfile.getTime(),
                        plantProfile.getAvatar())
        );
    }

    public ArrayList<PlantProfile> readFromG(Activity activity) {
        ArrayList<PlantProfile> localprofiles = new ArrayList<PlantProfile>();
        File dbFile= activity.getDatabasePath("plant.db");
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        Cursor resultSet = sqLiteDatabase.rawQuery("Select * from GPlants", null);
        resultSet.moveToFirst();
        while (resultSet.isAfterLast() == false)
        {
            String nick_name = resultSet.getString(0);
            String description = resultSet.getString(1);
            String specie = resultSet.getString(2);
            int time = resultSet.getInt(3);
            int avatar = resultSet.getInt(4);
            localprofiles.add(new PlantProfile(nick_name, description,Plant.valueOf(specie), time, avatar));
            resultSet.moveToNext();
        }
        return localprofiles;
    }

    public void writeToX(Activity activity, PlantProfile plantProfile) {
        File dbFile= activity.getDatabasePath("plant.db");
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS XPlants(NickName VARCHAR, Discription VARCHAR, Specie VARCHAR, Time INTEGER,Avatar INTEGER);");
        sqLiteDatabase.execSQL(
                String.format(
                        "INSERT INTO XPlants VALUES('%s','%s','%s', %d, %d);",
                        plantProfile.getNickname(),
                        plantProfile.getDescription(),
                        plantProfile.getSpecies().toString(),
                        plantProfile.getTime(),
                        plantProfile.getAvatar())
        );
    }

    public ArrayList<PlantProfile> readFromX(Activity activity) {
        ArrayList<PlantProfile> localprofiles = new ArrayList<PlantProfile>();
        File dbFile= activity.getDatabasePath("plant.db");
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        Cursor resultSet = sqLiteDatabase.rawQuery("Select * from XPlants", null);
        resultSet.moveToFirst();
        while (resultSet.isAfterLast() == false)
        {
            String nick_name = resultSet.getString(0);
            String description = resultSet.getString(1);
            String specie = resultSet.getString(2);
            int time = resultSet.getInt(3);
            int avatar = resultSet.getInt(4);
            localprofiles.add(new PlantProfile(nick_name, description, Plant.valueOf(specie), time, avatar));
            resultSet.moveToNext();
        }
        return localprofiles;
    }

    public void createTwoTables(Activity activity){
        File dbFile= activity.getDatabasePath("plant.db");
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS GPlants(NickName VARCHAR, Discription VARCHAR, Specie VARCHAR, Time INTEGER, Avatar INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS XPlants(NickName VARCHAR, Discription VARCHAR, Specie VARCHAR, Time INTEGER, Avatar INTEGER);");
    }

    public boolean isDbexist(Activity activity){
        File dbFile= activity.getDatabasePath("plant.db");
        return dbFile.exists();
    }

    public void removeFromX(Activity activity, PlantProfile plantProfile) {
        File dbFile= activity.getDatabasePath("plant.db");
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        sqLiteDatabase.execSQL(String.format("DELETE FROM XPlants WHERE NickName = '%s'", plantProfile.getNickname()));
    }

    public void addToG(Activity activity, PlantProfile plantProfile) {
        File dbFile= activity.getDatabasePath("plant.db");
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
        sqLiteDatabase.execSQL(
                String.format(
                "INSERT INTO GPlants VALUES('%s','%s','%s', %d, %d);",
                plantProfile.getNickname(),
                plantProfile.getDescription(),
                plantProfile.getSpecies().toString(),
                plantProfile.getTime(),
                plantProfile.getAvatar()));
    }

    // for plant search use

//    public void createAllTable(Activity activity) {
//        File dbFile= activity.getDatabasePath("plant.db");
//        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
//        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ALLPlants(NickName VARCHAR, Discription VARCHAR, Specie VARCHAR, Time INTEGER, Avatar INTEGER);");
//    }
//
//    public void writeToAll(Activity activity, ArrayList<PlantProfile> plantProfile) {
//        File dbFile= activity.getDatabasePath("plant.db");
//        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
//        for(PlantProfile profile : plantProfile) {
//            sqLiteDatabase.execSQL(
//                    String.format(
//                            "INSERT INTO AllPlants VALUES('%s','%s','%s', %d, %d);",
//                            profile.getNickname(),
//                            profile.getDescription(),
//                            profile.getSpecies().toString(),
//                            profile.getTime(),
//                            profile.getAvatar())
//            );
//        }
//    }
//
//
//    public ArrayList<PlantProfile> readFromAll(Activity activity) {
//        ArrayList<PlantProfile> localprofiles = new ArrayList<PlantProfile>();
//        File dbFile= activity.getDatabasePath("plant.db");
//        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
//        Cursor resultSet = sqLiteDatabase.rawQuery("Select * from AllPlants", null);
//        resultSet.moveToFirst();
//        while (resultSet.isAfterLast() == false)
//        {
//            String nick_name = resultSet.getString(0);
//            String description = resultSet.getString(1);
//            String specie = resultSet.getString(2);
//            int time = resultSet.getInt(3);
//            int avatar = resultSet.getInt(4);
//            localprofiles.add(new PlantProfile(nick_name, description,Plant.valueOf(specie), time, avatar));
//            resultSet.moveToNext();
//        }
//        return localprofiles;
//    }
}
