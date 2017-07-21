package com.wanny.workease.system.workease_business.customer.register_mvp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 文件名： City
 * 功能：
 * 作者： wanny
 * 时间： 15:12 2017/7/21
 */
public class City implements Parcelable {


    private String id;//": "500000",
    private String name;//": "重庆市",
    private String parentId;//": "0",
    private String subCitys;//":null

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSubCitys() {
        return subCitys;
    }

    public void setSubCitys(String subCitys) {
        this.subCitys = subCitys;
    }

    public City() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.parentId);
        dest.writeString(this.subCitys);
    }

    protected City(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.parentId = in.readString();
        this.subCitys = in.readString();
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
