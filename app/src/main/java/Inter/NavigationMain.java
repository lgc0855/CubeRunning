package Inter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liguochao.cuberunning.R;

/**
 * Created by Administrator on 2016/5/17 0017.
 */
public class NavigationMain extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_navigation_main,container,false);
        return view;
    }
}
