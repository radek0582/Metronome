package com.doga.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DataHolderClass {
    private String value;
    private int found = 0;      // -1 unknown(searching), 0 false, 1 true
    private HashMap <String, String> changes;
    private int change = 0;
    private int settingValues = 0;
    private HashMap <String, String> founds;
    private HashMap <String, String> missedFounds;
    private HashMap <String, String> dataToRetrieve;
    private HashMap <String, String> toSearch;
    private Set <String> sets;
    private boolean refresh = false;
    private int SetOnChange = 0;
    private int foundData = 0;
    private int missedData = 0;
    private boolean foundEntry = false;
    private int verifiedAmount = 0;
    private boolean dataChanged = false;



    public DataHolderClass(){
        changes = new HashMap<>();
        founds = new HashMap<>();
        missedFounds = new HashMap<>();
        sets = new HashSet<>();
        dataToRetrieve = new HashMap<>();
        toSearch = new HashMap<>();
    }

    public boolean isDataChanged() {
        return dataChanged;
    }

    public void setDataChanged(boolean dataChanged) {
        this.dataChanged = dataChanged;
    }

    public HashMap<String, String> getToSearch() {
        return toSearch;
    }

    public void setToSearch(HashMap<String, String> toSearch) {
        this.toSearch = toSearch;
    }

    public HashMap<String, String> getMissedFounds() {
        return missedFounds;
    }

    public void setMissedFounds(HashMap<String, String> missedFounds) {
        this.missedFounds = missedFounds;
    }

    public HashMap<String, String> getDataToRetrieve() {
        return dataToRetrieve;
    }

    public void setDataToRetrieve(HashMap<String, String> dataToRetrieve) {
        this.dataToRetrieve = dataToRetrieve;
    }

    public boolean isFoundEntry() {
        return foundEntry;
    }

    public void setFoundEntry(boolean foundEntry) {
        this.foundEntry = foundEntry;
    }

    public int getVerifiedAmount() {
        return verifiedAmount;
    }

    public void setVerifiedAmount(int verifiedAmount) {
        this.verifiedAmount = verifiedAmount;
    }

    public int getMissedData() {
        return missedData;
    }

    public void setMissedData(int missedData) {
        this.missedData = missedData;
    }

    public int getFoundData() {
        return foundData;
    }

    public void setFoundData(int foundData) {
        this.foundData = foundData;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }

    public HashMap<String, String> getChanges() {
        return changes;
    }

    public void setChanges(HashMap<String, String> changes) {
        this.changes = changes;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        System.out.println("changed to " + change + " value: " + value);
        this.change = change;
    }

    public int getSettingValues() {
        return settingValues;
    }

    public void setSettingValues(int settingValues) {
        this.settingValues = settingValues;
    }

    public HashMap<String, String> getFounds() {
        return founds;
    }

    public void setFounds(HashMap<String, String> founds) {
        this.founds = founds;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public int getSetOnChange() {
        return SetOnChange;
    }

    public void setSetOnChange(int setOnChange) {
        SetOnChange = setOnChange;
    }

    public boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

//    public void restoreFoundsHolder(String id) {
//        if (id == null) {
//            this.getFounds().clear();
//            this.getMissedFounds().clear();
//            this.getDataToRetrieve().clear();
//        }
//        else {
//            this.getFounds().remove(id);
//            this.getDataToRetrieve().remove(id);
//            this.getMissedFounds().remove(id);
//        }
//
//        this.setFound(0);
//    }

    public void restoreFounds (String id){
        this.setFound(0);
        this.getFounds().remove(id);
    }
}
