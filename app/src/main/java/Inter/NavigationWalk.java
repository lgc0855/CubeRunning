package Inter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liguochao.cuberunning.R;

/**
 * Created by Administrator on 2016/5/11 0011.
 */
public class NavigationWalk extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_navigation_walk,container,false);
        return view;
    }
}
