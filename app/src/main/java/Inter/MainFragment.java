package Inter;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.liguochao.cuberunning.MainActivity;
import com.example.liguochao.cuberunning.R;

/**
 * Created by Administrator on 2016/5/17 0017.
 */
public class MainFragment extends Fragment {

    private static NavigationRide navigationRide;
    private static NavigationRun navigationRun;
    private static NavigationWalk navigationWalk;

    private Button btn_walk ;
    private Button btn_ride ;
    private Button btn_run;
    private Button btn_go;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_main,container,false);
        init();
        btn_run = (Button) view.findViewById(R.id.btn_Frame_run);
        btn_walk = (Button) view.findViewById(R.id.btn_Frame_walk);
        btn_ride = (Button) view.findViewById(R.id.btn_Frame_ride);
        btn_go = (Button) view.findViewById(R.id.btn_go);
        showWalkButton();
        showRideButton();
        showRunButton();
        showGoButton();
        return view;
    }

    private void showGoButton() {
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.getContext(),RunningActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showRunButton() {
        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frame_navigation, navigationRun).commit();
            }
        });

    }

    private void showWalkButton() {

        btn_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frame_navigation, navigationWalk).commit();
            }
        });

    }

    private void showRideButton() {

        btn_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frame_navigation, navigationRide).commit();
            }
        });
    }

    private void init() {
        navigationRide = new NavigationRide();
        navigationRun = new NavigationRun();
        navigationWalk = new NavigationWalk();


        getFragmentManager().beginTransaction().add(R.id.frame_navigation, navigationRun).commit();
    }
}
