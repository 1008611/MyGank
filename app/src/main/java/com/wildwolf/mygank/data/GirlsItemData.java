package com.wildwolf.mygank.data;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlsItemData implements Parcelable {

    /**
     * title : 一时竟不知道该心疼谁
     * thumburl : http://ww3.sinaimg.cn/large/bd759d6djw1f4447o4di6j20ef0bh0tj.jpg
     * sourceurl : http://down.laifudao.com/images/tupian/201651117311.jpg
     * height : 413
     * width : 519
     * class : 1
     * url : http://www.laifudao.com/tupian/57519.htm
     */

    private String title;
    private String thumburl;
    private String sourceurl;
    private String height;
    private String width;
    private String classX;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.thumburl);
        dest.writeString(this.sourceurl);
        dest.writeString(this.height);
        dest.writeString(this.width);
        dest.writeString(this.classX);
        dest.writeString(this.url);
    }

    public GirlsItemData() {
    }

    protected GirlsItemData(Parcel in) {
        this.title = in.readString();
        this.thumburl = in.readString();
        this.sourceurl = in.readString();
        this.height = in.readString();
        this.width = in.readString();
        this.classX = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<GirlsItemData> CREATOR = new Parcelable.Creator<GirlsItemData>() {
        @Override
        public GirlsItemData createFromParcel(Parcel source) {
            return new GirlsItemData(source);
        }

        @Override
        public GirlsItemData[] newArray(int size) {
            return new GirlsItemData[size];
        }
    };

    @Override
    public String toString() {
        return "GirlsItemData{" +
                "title='" + title + '\'' +
                ", thumburl='" + thumburl + '\'' +
                ", sourceurl='" + sourceurl + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", classX='" + classX + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
