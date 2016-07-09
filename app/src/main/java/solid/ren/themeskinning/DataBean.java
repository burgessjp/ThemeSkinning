package solid.ren.themeskinning;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by _SOLID
 * Date:2016/7/5
 * Time:9:49
 */
public class DataBean implements Parcelable {

    private String title;
    private String content;
    private String date;
    private String img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.date);
        dest.writeString(this.img);
    }

    public DataBean() {
    }

    protected DataBean(Parcel in) {
        this.title = in.readString();
        this.content = in.readString();
        this.date = in.readString();
        this.img = in.readString();
    }

    public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
        @Override
        public DataBean createFromParcel(Parcel source) {
            return new DataBean(source);
        }

        @Override
        public DataBean[] newArray(int size) {
            return new DataBean[size];
        }
    };
}
