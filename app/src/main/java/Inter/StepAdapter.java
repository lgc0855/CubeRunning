package Inter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liguochao.cuberunning.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class StepAdapter extends ArrayAdapter<StepListItem> {
    private int resourceID;

    public StepAdapter(Context context, int resource, List<StepListItem> objects) {
        super(context, resource, objects);
        resourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StepListItem stepListItem = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
            viewHolder = new ViewHolder();
            viewHolder.headIcon = (ImageView) view.findViewById(R.id.step_item_imageView_headIcon);
            viewHolder.rank = (TextView) view.findViewById(R.id.step_item_textView_rank);
            viewHolder.name = (TextView) view.findViewById(R.id.step_item_textView_name);
            viewHolder.step = (TextView) view.findViewById(R.id.step_item_textView_step);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.headIcon.setImageResource(stepListItem.getHeadImageId());
        viewHolder.rank.setText(stepListItem.getRank());
        viewHolder.name.setText(stepListItem.getName());
        viewHolder.step.setText(stepListItem.getStep());
        return view;
    }

    public class ViewHolder {
        ImageView headIcon;
        TextView rank,name,step;
    }

}
