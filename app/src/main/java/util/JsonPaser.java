package util;

import android.util.JsonReader;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import com.google.gson.Gson;


/**
 * Created by liguochao on 2016/5/9.
 */
public class JsonPaser {
    InputStream in = null ;
    JsonReader reader = null ;


    public String parser(String s) throws JSONException {
        JSONObject obj = new JSONObject(s) ;
        String sl = obj.getString("distance") ;
        Log.d("Json",sl) ;
        return sl ;
    }
}
