package Inter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.liguochao.cuberunning.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
public class InfoAdapter extends ArrayAdapter<PersonInfo> {
    private int resourceID;

    public InfoAdapter(Context context, int resource, List<PersonInfo> objects) {
        super(context, resource, objects);
        resourceID = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonInfo personInfo = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
            viewHolder = new ViewHolder();
            viewHolder.attribute = (TextView) view.findViewById(R.id.info_item_attribute);
            viewHolder.value = (TextView) view.findViewById(R.id.info_item_value);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.attribute.setText(personInfo.getAttribute());
        viewHolder.value.setText(personInfo.getValue());
        return view;
    }

    public class ViewHolder {
        TextView attribute,value;
    }
}
