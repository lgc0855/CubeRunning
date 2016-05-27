package Inter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.liguochao.cuberunning.MainActivity;
import com.example.liguochao.cuberunning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/17 0017.
 */
public class RankFragment extends Fragment {

    private View view;

    private List<StepListItem> stepListItems = new ArrayList<StepListItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment_rank,container,false);
        getFragmentManager().beginTransaction().add(R.id.frame_user_step,new UserStepFragment()).commit();

        updateStepList();
        StepAdapter stepAdapter = new StepAdapter(MainActivity.getContext(),R.layout.friends_step_item,stepListItems);
        ListView listView = (ListView) view.findViewById(R.id.listView_step);
        listView.setAdapter(stepAdapter);

        return view;
    }

    private void updateStepList() {
        if (stepListItems.size() != 0) {
            stepListItems.clear();
        }
        stepListItems.add(new StepListItem(1,R.drawable.head_icon,15321,"李国超"));
        stepListItems.add(new StepListItem(2,R.drawable.head_icon,25184,"肖强"));
        stepListItems.add(new StepListItem(3,R.drawable.head_icon,75412,"狄弘辉"));
        stepListItems.add(new StepListItem(4,R.drawable.head_icon,42316,"高盟"));
        stepListItems.add(new StepListItem(5,R.drawable.head_icon,12542,"王责羽"));
    }

}
