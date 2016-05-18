package util;

/**
 * Created by liguochao on 2016/5/18.
 */
public class WeatherMessage {
    String text_day =  null ;
    String text_night = null ;
    String suggestionbrf = null ;
    String suggestiontext = null ;
    String pm25 = null ;

    public String getSuggestionbrf() {
        return suggestionbrf;
    }

    public void setSuggestionbrf(String suggestionbrf) {
        this.suggestionbrf = suggestionbrf;
    }

    public String getSuggestiontext() {
        return suggestiontext;
    }

    public void setSuggestiontext(String suggestiontext) {
        this.suggestiontext = suggestiontext;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }


    public String getText_day() {
        return text_day;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public String getText_night() {
        return text_night;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }
}
