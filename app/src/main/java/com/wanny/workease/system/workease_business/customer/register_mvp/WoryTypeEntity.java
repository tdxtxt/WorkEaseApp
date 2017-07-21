package com.wanny.workease.system.workease_business.customer.register_mvp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 文件名： WoryTypeEntity
 * 功能：
 * 作者： wanny
 * 时间： 14:39 2017/7/14
 */
public class WoryTypeEntity implements Parcelable {


    private String id;//": "2123",
    private String name;//": "抹灰工",

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    public WoryTypeEntity() {
    }

    protected WoryTypeEntity(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<WoryTypeEntity> CREATOR = new Parcelable.Creator<WoryTypeEntity>() {
        @Override
        public WoryTypeEntity createFromParcel(Parcel source) {
            return new WoryTypeEntity(source);
        }

        @Override
        public WoryTypeEntity[] newArray(int size) {
            return new WoryTypeEntity[size];
        }
    };
}
