package yoffe.presidents;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class President implements Serializable{
    private int number;
    private String president;
    private int birthYear;
    private Integer deathYear;
    private String tookOffice;
    private String leftOffice;
    private String party;

    public Integer getDeathYear() {
        return deathYear;
    }

    public int getNumber() {
        return number;
    }

    public String getLeftOffice() {
        return leftOffice;
    }

    public String getParty() {
        return party;
    }

    public String getTookOffice() {
        return tookOffice;
    }

    public String getPresident() {
        return president;
    }

    public int getBirthYear() {
        return birthYear;
    }


}
