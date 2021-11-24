package hk.edu.cuhk.ie.iems5722.a2_1155169171;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ClassroomAdapter extends ArrayAdapter<ClassroomBean.ClassBean> {
    public ClassroomAdapter(Context context, ArrayList<ClassroomBean.ClassBean> Classrooms) {
        super(context, 0, Classrooms);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ClassroomBean.ClassBean cl= getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_main, parent, false);
        }
        TextView clId = (TextView) convertView.findViewById(R.id.classroom_id);
        TextView clName = (TextView) convertView.findViewById(R.id.classroom_name);
        clId.setText(cl.getId());
        clName.setText(cl.getName());
        return convertView;
    }
}
