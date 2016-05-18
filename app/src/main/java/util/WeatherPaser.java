package util;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.liguochao.cuberunning.R;

/**
 * Created by liguochao on 2016/5/14.
 */
public class WeatherPaser extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        String httpUrl = "https://api.heweather.com/x3/weather?cityid=CN101010700&key=62648c60f9c3485fbea2cb79f6641dcd";
        String weather = new JsonPaser().parserWeather(httpUrl) ;
     //   Log.d("Weather",weather) ;
        return null ;
    }
}
