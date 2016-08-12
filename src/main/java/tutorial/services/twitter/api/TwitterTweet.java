package tutorial.services.twitter.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TwitterTweet {

    String id_str;
    String text;
    String created_at;
    Date createdAt;

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
        convertDate(created_at);
    }

    public Date getCreatedAt() {
        if(this.createdAt == null) convertDate(this.created_at);

        return createdAt;
    }

    private void convertDate(String created_at) {
        DateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss Z", Locale.ENGLISH);
        try {
            this.createdAt = format.parse(created_at);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}