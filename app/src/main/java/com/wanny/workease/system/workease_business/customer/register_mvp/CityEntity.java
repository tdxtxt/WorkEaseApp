package com.wanny.workease.system.workease_business.customer.register_mvp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * 文件名： CityEntity
 * 功能：
 * 作者： wanny
 * 时间： 14:58 2017/7/14
 */
public class CityEntity implements Parcelable {

     private String id;//": "500000",
    private String name;//": "重庆市",
    private String parentId;//": "0",
    private ArrayList<City> subCitys;//"

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

    public ArrayList<City> getSubCitys() {
        return subCitys;
    }

    public void setSubCitys(ArrayList<City> subCitys) {
        this.subCitys = subCitys;
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
        dest.writeList(this.subCitys);
    }

    public CityEntity() {
    }

    protected CityEntity(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.parentId = in.readString();
        this.subCitys = new ArrayList<City>();
        in.readList(this.subCitys, City.class.getClassLoader());
    }

    public static final Parcelable.Creator<CityEntity> CREATOR = new Parcelable.Creator<CityEntity>() {
        @Override
        public CityEntity createFromParcel(Parcel source) {
            return new CityEntity(source);
        }

        @Override
        public CityEntity[] newArray(int size) {
            return new CityEntity[size];
        }
    };
}
