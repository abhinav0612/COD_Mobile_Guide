package com.deathalurer.codmobileguide;

import androidx.recyclerview.widget.LinearSmoothScroller;

import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class Recycler_Item {
    private String name;
    private int imageResId;
    private String desc;
    private String accu;
    private String range;
    private List<String> weaponList;

    public List<String> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<String> weaponList) {
        this.weaponList = weaponList;
    }

    public Recycler_Item(String name, int imageResId, List<String> weaponList) {
        this.name = name;
        this.imageResId = imageResId;
        this.weaponList = weaponList;
    }

    public String getAccu() {
        return accu;
    }

    public void setAccu(String accu) {
        this.accu = accu;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Recycler_Item(String name, int imageResId, String desc, String accu, String range) {
        this.name = name;
        this.imageResId = imageResId;
        this.desc = desc;
        this.accu = accu;
        this.range = range;
    }

    public Recycler_Item(String name, int imageResId, String desc) {
        this.name = name;
        this.imageResId = imageResId;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Recycler_Item(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }
}
