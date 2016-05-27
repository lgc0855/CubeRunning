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
 * Created by Administrator on 2016/5/22 0022.
 */
public class InfoFragment extends Fragment {

    private List<PersonInfo> personInfoList = new ArrayList<PersonInfo>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_info,container,false);

        updateInfo();
        InfoAdapter infoAdapter = new InfoAdapter(MainActivity.getContext(),R.layout.person_info_item,personInfoList);
        ListView listView = (ListView) view.findViewById(R.id.ListView_info);
        listView.setAdapter(infoAdapter);

        return view;
    }

    private void updateInfo() {
        if (personInfoList.size() != 0) {
            personInfoList.clear();
        }
        personInfoList.add(new PersonInfo("昵称","balalaika"));
        personInfoList.add(new PersonInfo("性别","男"));
        personInfoList.add(new PersonInfo("年龄","46"));
        personInfoList.add(new PersonInfo("身高(cm)","170"));
        personInfoList.add(new PersonInfo("体重(kg)","60.0"));
    }
}
