package com.deathalurer.codmobileguide;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class WeaponStats {
    private String name;
    private int damage;
    private int firRate;
    private int accuracy;
    private int mobility;
    private int range;
    private String tier;

    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getFirRate() {
        return firRate;
    }

    public void setFirRate(int firRate) {
        this.firRate = firRate;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getMobility() {
        return mobility;
    }

    public void setMobility(int mobility) {
        this.mobility = mobility;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String  getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public WeaponStats(int imageId,String name, int damage, int firRate, int accuracy, int mobility, int range, String tier) {
        this.name = name;
        this.damage = damage;
        this.imageId = imageId;
        this.firRate = firRate;
        this.accuracy = accuracy;
        this.mobility = mobility;
        this.range = range;
        this.tier = tier;
    }
}
