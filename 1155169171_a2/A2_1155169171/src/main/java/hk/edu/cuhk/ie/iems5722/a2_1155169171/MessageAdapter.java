package hk.edu.cuhk.ie.iems5722.a2_1155169171;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class MessageAdapter extends ArrayAdapter<Msg> {
    public MessageAdapter(Context context, ArrayList<Msg> msgs) {
        super(context, 0, msgs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Msg msg = getItem(position);
        if(msg.getType()==0){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_historymsgofme, parent, false);
        }else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_historymessage, parent, false);
        }
        // Check if an existing view is being reused, otherwise inflate the view
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_historymessage, parent, false);
//        }
        // Lookup view for data population
        TextView tvMessage = (TextView) convertView.findViewById(R.id.tvMessage);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tvMessage_time);
        tvMessage.setText(msg.getMessage());
        tvName.setText(msg.getName());
        tvTime.setText(msg.getMessage_time());
        return convertView;
    }

}

