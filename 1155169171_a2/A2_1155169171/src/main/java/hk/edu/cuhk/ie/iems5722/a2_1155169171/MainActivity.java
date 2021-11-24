package hk.edu.cuhk.ie.iems5722.a2_1155169171;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
{
    ArrayList<ClassroomBean.ClassBean> classrooms=new ArrayList<ClassroomBean.ClassBean>();
    ListView listView;
    ClassroomAdapter classroomadapter;
    List<ClassroomBean.ClassBean> rowsBeanList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.tb2);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_classroom);
        WebClient.getInstance().getClassRoomList().enqueue(new Callback<ClassroomBean>()
        {
            @Override
            public void onResponse(Call<ClassroomBean> call, Response<ClassroomBean> response )
            {
                    if(response.isSuccessful())
                    {
                        Log.i("response",response.toString());
                        ClassroomBean cb = response.body();
                        rowsBeanList = cb.getData();
                        for(int i=0; i<rowsBeanList.size();i++){
                            classrooms.add(rowsBeanList.get(i));
                        }
                        classroomadapter = new ClassroomAdapter(MainActivity.this, classrooms);
                        listView.setAdapter(classroomadapter);
                    }else{

                    }
            }
                @Override
                public void onFailure(Call<ClassroomBean> call, Throwable t) { }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                TextView textView= (TextView) view.findViewById(R.id.classroom_name);
                TextView textView1= (TextView) view.findViewById(R.id.classroom_id);
                intent.putExtra("room_title",textView.getText());
                intent.putExtra("room_id",textView1.getText());
                startActivity(intent);
            }
        });


    }

}