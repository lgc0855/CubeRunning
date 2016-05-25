package util;

import android.renderscript.ScriptGroup;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;


/**
 * Created by liguochao on 2016/5/9.
 */
public class JsonPaser {
    InputStream in = null ;
    JsonReader reader = null ;
    final String TAG = "JsonPaser"  ;
    WeatherMessage weatherMessage = new WeatherMessage() ;

    // 可调用此函数获取天气信息
    public WeatherMessage getWeatherMessage() {
        return weatherMessage;
    }

    public String parser(String s) throws JSONException {
        JSONObject obj = new JSONObject(s) ;
        String sl = obj.getString("distance") ;
        Log.d("Json",sl) ;
        return sl ;
    }

    public String parserWeather(String httpUrl ){
        BufferedReader breader = null ;
        String result = null ;
        StringBuffer sbf = new StringBuffer() ;
        try{
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            Log.d("JsonPaser", "Network is connected!") ;
            InputStream is = connection.getInputStream() ;
            startPaser(is);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result ;
    }

    private void startPaser(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        String name = null ;
        JsonReader reader = new JsonReader(isr) ;
        reader.beginObject();
        name = reader.nextName() ;
        Log.d(TAG, "excepted HeWeather data service 3.0 ,   the true is " + name) ;
        reader.beginArray();
        while(reader.hasNext()){
            reader.beginObject();
            while(reader.hasNext()){
                name= reader.nextName() ;
                if(name.equals("aqi")){
                    Log.d(TAG,"progress is in " +name) ;
                    readAqi(reader) ;
                }else if(name.equals("daily_forecast")){
                    Log.d(TAG,"progress is in daily_forecast") ;
                    readdaily_forecast(reader) ;
                }else if(name.equals("suggestion")){
                    Log.d(TAG,"progress is in suggestion") ;
                    readSuggestion(reader);
                } else{
                    Log.d(TAG,"progress is in "+name) ;
                    reader.skipValue();
                }
            }
            reader.endObject();
        }
        reader.endArray();
        reader.endObject();
    }

    private void readAqi(JsonReader reader) {
        String weather = null ;
        try {
            reader.beginObject();
            while(reader.hasNext()){
                weather = reader.nextName() ;
                if(weather.equals("city")){
                    readCity(reader) ;
                }else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCity(JsonReader reader) {
        String weather = null ;
        try {
            reader.beginObject();
            while(reader.hasNext()){
                weather = reader.nextName() ;
                if(weather.equals("pm25")){
                    weather = reader.nextString() ;
                    weatherMessage.setPm25(weather);
                    Log.d(TAG , "weatherMessage.Pm25 is " + weatherMessage.getPm25()) ;
                }else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readSuggestion(JsonReader reader){
        String weather = null ;
        try {
            reader.beginObject();
            while(reader.hasNext()){
                weather = reader.nextName() ;
                Log.d("readSuggestion",weather) ;
                if(weather.equals("sport")){
                    Log.d(TAG, " progress is in" + weather) ;
                    readSport(reader);
                }else {
                    reader.skipValue();
                }
            }
           reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readSport(JsonReader reader){
        try {
            reader.beginObject();
            String weather = null ;
            while(reader.hasNext()){
                weather = reader.nextName() ;
                if(weather.equals("brf")){
                    weather = reader.nextString() ;
                    weatherMessage.setSuggestionbrf(weather);
                    Log.d(TAG, "WeatherMessage .suggestionbrf  " + weatherMessage.getSuggestionbrf()) ;
                }else if(weather.equals("txt")){
                    weather = reader.nextString() ;
                    weatherMessage.setSuggestiontext(weather);
                    Log.d(TAG, "WeatherMessage .suggestiontext  " + weatherMessage.getSuggestiontext()) ;
                }else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readdaily_forecast(JsonReader reader) {
        String weather  = null ;
        try {
            reader.beginArray();
            reader.beginObject();
            while(reader.hasNext()){
                weather = reader.nextName() ;
                if(weather.equals("cond")){
                    Log.d(TAG,"progress is in " + weather) ;
                    readCond(reader);
                }else{
                    reader.skipValue();
                }
            }
            reader.endObject();
            while(reader.hasNext()){
                reader.skipValue();
            }
            reader.endArray();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readCond(JsonReader reader){
        String weather = null ;
        try {
            reader.beginObject();
            while(reader.hasNext()){
                weather = reader.nextName() ;
                if(weather.equals("txt_d")){
                    Log.d(TAG,"progress is in" + weather) ;
                    weatherMessage.setText_day(reader.nextString());
                    Log.d(TAG, "WeatherMessage .txt_day is  " + weatherMessage.getText_day()) ;
                }else if (weather.equals("txt_n")){
                    Log.d(TAG,"progress is in" + weather) ;
                    weatherMessage.setText_night(reader.nextString());
                    Log.d(TAG, "WeatherMessage .txt_n is  " + weatherMessage.getText_night()) ;
                }else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
