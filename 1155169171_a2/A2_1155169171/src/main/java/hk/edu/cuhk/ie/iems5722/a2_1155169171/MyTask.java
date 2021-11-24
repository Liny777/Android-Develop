//package hk.edu.cuhk.ie.iems5722.a2_1155169171;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import okhttp3.Call;
////import okhttp3.Callback;
//import okhttp3.Response;
//
//import retrofit2.Callback;
////第一个参数为doInBackground中传入的类型，第二个为doInBackground中更新的参数的类型，第三个为doInBackground完成后传出的参数。
//public class MyTask extends AsyncTask<String, Integer, String> {
//    private static final String TAG = "ASYNC_TASK";
//    List<ClassroomBean.ClassBean> rowsBeanList;
//    //onPreExecute方法用于在执行后台任务前做一些UI操作
//    @Override
//    protected void onPreExecute() {
//        Log.i(TAG, "onPreExecute() called");
//    }
//    //doInBackground方法内部执行后台任务,不可在此方法内修改UI
//    @Override
//    protected String doInBackground(String... params)
//    {
//        Log.i(TAG, "doInBackground(Params... params) called");
////        try {
////            //异步请求通讯录
////            WebClient.getInstance().getClassRoomList().enqueue(new Callback<ClassroomBean>() {
////                @Override
////                public void onResponse(retrofit2.Call<ClassroomBean> call, retrofit2.Response<ClassroomBean> response) {
//////                    response.body();
////                    Log.i("response",response.toString());
////                    ClassroomBean cb = response.body();
////                    rowsBeanList = cb.getClasses();
////                    return rowsBeanList;
////                    }
////
////                @Override
////                public void onFailure(retrofit2.Call<ClassroomBean> call, Throwable t) {
////
////                }
////            });
////        }
////         catch (Exception e) {
////            Log.e(TAG, e.getMessage());
////        }
//        return null;
//    }
//    //onProgressUpdate方法用于更新进度信息
//    @Override
//    protected void onProgressUpdate(Integer... progresses) {
//        Log.i(TAG, "onProgressUpdate(Progress... progresses) called");
//    }
//
//    //onPostExecute方法用于在执行完后台任务后更新UI,显示结果
//    @Override
//    protected void onPostExecute(String result) {
//        Log.i(TAG, "onPostExecute(Result result) called");
////        textView.setText(result);
////
////        execute.setEnabled(true);
////        cancel.setEnabled(false);
//    }
//
//    //onCancelled方法用于在取消执行中的任务时更改UI
//    @Override
//    protected void onCancelled() {
//        Log.i(TAG, "onCancelled() called");
////        textView.setText("cancelled");
////        progressBar.setProgress(0);
////
////        execute.setEnabled(true);
////        cancel.setEnabled(false);
//    }
//}
////}
//    private class MyTask extends AsyncTask<String, Integer, ArrayList<ClassroomBean.ClassBean> > {
//        //第一个String代表输入到任务的参数类型，也即是doInBackground()的参数类型
//        //第二个String代表处理过程中的参数类型，也就是doInBackground()执行过程中的产出参数类型，通过publishProgress()发消息
//        //传递给onProgressUpdate()一般用来更新界面
//        //第三个String代表任务结束的产出类型，也就是doInBackground()的返回值类型，和onPostExecute()的参数类型
//        private static final String TAG = "ASYNC_TASK";
//        //List<ClassroomBean.ClassBean> rowsBeanList;
//        //onPreExecute方法用于在执行后台任务前做一些UI操作
////        MyTask(){
////            classrooms = new ArrayList<ClassroomBean.ClassBean>();
////            System.out.println("jinge yyds22" +classrooms.hashCode());
////        }
//        @Override
//        protected void onPreExecute() {
//
//            Log.i(TAG, "onPreExecute() called");
//
//        }
//        //doInBackground方法内部执行后台任务,不可在此方法内修改UI
//        @Override
//        public ArrayList<ClassroomBean.ClassBean>  doInBackground(String... params)
//        {
//            System.out.println("jinge yyds1: " + classrooms.hashCode()+ " : "+classrooms.size());
//            Log.i(TAG, "doInBackground(Params... params) called");
//            try {
//                System.out.println("jinge yyds2: " +classrooms.hashCode());
//                WebClient.getInstance().getClassRoomList().enqueue(new Callback<ClassroomBean>() {
//                @Override
//                public void onResponse(Call<ClassroomBean> call, Response<ClassroomBean> response ) {
//                    Log.i("response",response.toString());
//                    ClassroomBean cb = response.body();
//                    rowsBeanList = cb.getData();
////                    ArrayList<ClassroomBean.ClassBean> classroom_temp = new ArrayList<ClassroomBean.ClassBean>();
//                    for(int i=0; i<rowsBeanList.size();i++){
//                        System.out.println(rowsBeanList.get(i).getName());
//                        classrooms.add(rowsBeanList.get(i));
//                    }
////                    Set_StringList(classroom_temp);
////                    classroomadapter = new ClassroomAdapter(MainActivity.this, classrooms);
////                    listView.setAdapter(classroomadapter);
////                    System.out.println("jinge yyds3: " +classrooms.hashCode() + " : "+classrooms.size());
////                    System.out.println("~~~~~~~~~~~~~1"+classrooms.size());
//                    }
//                @Override
//                public void onFailure(retrofit2.Call<ClassroomBean> call, Throwable t) {
////                    System.out.println("=======================");
//                }
//                public void Set_StringList(ArrayList<ClassroomBean.ClassBean> cl){
//                    for(int j=0;j<cl.size();j++){
////                        MyTask.classrooms.add(cl.get(j));
//                    }
//
//
//                }
//            });
////               return null;
//                System.out.println("jinge yyds4: " + classrooms.hashCode()+ " : "+classrooms.size());
//            return classrooms;
//        }
//         catch (Exception e) {
//            Log.e(TAG, e.getMessage());
//
//            return null;
//         }
////            return null;
//        }
//        //onProgressUpdate方法用于更新进度信息
//        @Override
//        protected void onProgressUpdate(Integer... progresses) {
//            Log.i(TAG, "onProgressUpdate(Progress... progresses) called");
//        }
//
//        //onPostExecute方法用于在执行完后台任务后更新UI,显示结果
//        @Override
//        protected void onPostExecute(ArrayList<ClassroomBean.ClassBean> cl) {
//            Log.i(TAG, "onPostExecute(Result result) called");
//            System.out.println("jinge yyds5: " + cl.hashCode()+ " : "+cl.size());
////            System.out.println("----------: "+cl.size());
////            System.out.println("+_+_+_+_+_111"+rowsBeanList.size());
//            classroomadapter = new ClassroomAdapter(MainActivity.this, classrooms);
//            listView.setAdapter(classroomadapter);
//        }
//
//        //onCancelled方法用于在取消执行中的任务时更改UI
//        @Override
//        protected void onCancelled() {
//            Log.i(TAG, "onCancelled() called");
//        }
//    }
//
//  android:layout_alignParentStart="true"
//          android:layout_alignParentTop="true"
//          android:layout_alignParentBottom="true"
//          android:layout_marginStart="150dp"
//          android:layout_marginTop="8dp"
//          android:layout_marginBottom="8dp"

//android:layout_alignParentTop="true"
//        android:layout_alignParentEnd="true"
//        android:layout_alignParentBottom="true"
//        android:layout_marginStart="5dp"
//        android:layout_marginTop="8dp"
//        android:layout_marginEnd="150dp"
//        android:layout_marginBottom="8dp"
//
//<TextView
//            android:id="@+id/classroom_name"
//                    android:layout_width="wrap_content"
//                    android:layout_height="20dp"
//                    android:layout_centerVertical="true"
//                    android:layout_centerHorizontal="true"
//                    android:layout_centerInParent="true"
//                    android:text="Message"
//                    android:textColor="@color/black" />
//
//<TextView
//            android:id="@+id/classroom_id"
//                    app:layout_constraintBaseline_toBaselineOf="@id/classroom_name"
//                    app:layout_constraintLeft_toRightOf="@+id/classroom_name"
//                    android:layout_width="wrap_content"
//                    android:layout_height="20dp"
//                    android:layout_centerVertical="true"
//                    android:layout_centerHorizontal="true"
//                    android:layout_centerInParent="true"
//                    android:layout_toEndOf="@+id/classroom_name"
//                    android:text="Time"
//                    android:textColor="@color/black" />
//<!--    </RelativeLayout>-->
//    android:background="#437EAE"
//package hk.edu.cuhk.ie.iems5722.a2_1155169171;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.ListView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//import okhttp3.MediaType;
//import okhttp3.RequestBody;
//import okio.BufferedSink;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class ChatActivity extends AppCompatActivity {
//    private ArrayList<hk.edu.cuhk.ie.iems5722.a2_1155169171.Msg> msgs;
//    private EditText editText;
//    private hk.edu.cuhk.ie.iems5722.a2_1155169171.MessageAdapter myadapter;
//    private ListView listView;
//    private ImageButton btnSpeak;
//    MessageBean.DataBean rowsBeanList;
//    List<Msg> historymessage;
//    ArrayList<Msg> historymessage_temp = new ArrayList<Msg>();
//    MessageAdapter messageadapter;
//    String roomId;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
//        String roomTitle = intent.getStringExtra("room_title");
//        roomId = intent.getStringExtra("room_id");
//        setContentView(R.layout.activity_chat);
//        Toolbar toolbar = findViewById(R.id.tb);
//        toolbar.setTitle(roomTitle);
//        setSupportActionBar(toolbar);
//        // toolbar
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                callHistoryMessageHttp();
//                return true;
//            }
//        });
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        // http request
//        callHistoryMessageHttp();
//        // Dialogue
//        editText = (EditText) findViewById(R.id.MessageText);
//        msgs = new ArrayList<hk.edu.cuhk.ie.iems5722.a2_1155169171.Msg>();
//        myadapter = new hk.edu.cuhk.ie.iems5722.a2_1155169171.MessageAdapter(this, msgs);
//        listView = (ListView) findViewById(R.id.lv_main);
//        btnSpeak = (ImageButton) findViewById(R.id.button_main);
//        btnSpeak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                SendMessageBean sb = new SendMessageBean();
//                sb.setMessage("hello");
//                sb.setChatroom_id(roomId);
//                sb.setName("Liny");
//                sb.setUser_id("1155169171");
//                postMessagetoServer(sb);
//                System.out.println("----------------11-----------------");
////                String str= editText.getText().toString();
////                if(str.length()==0){
////                    showNormalDialog();
////                }else{
////                    Calendar c   =   Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));//可以用set()对每个时间域单独修改
////                    int   hour   =   c.get(Calendar.HOUR_OF_DAY);
////                    int   minute   =   c.get(Calendar.MINUTE);
////                    String nowTime = hour + ":" + minute;
////                    hk.edu.cuhk.ie.iems5722.a2_1155169171.Msg newMsg = new hk.edu.cuhk.ie.iems5722.a2_1155169171.Msg(str,nowTime);
////                    myadapter.add(newMsg);
////                    editText.setText("");
////                    listView.setAdapter(myadapter);
////                }
//
//            }
//        });
//    }
//    public void postMessagetoServer(SendMessageBean sb){
//        System.out.println("------------33--------------");
//        RequestBody requestBody1 = RequestBody.create(MediaType.parse("chatroom_id"),"1");
//        RequestBody requestBody2 = RequestBody.create(MediaType.parse("user_id"),"1155169171");
//        RequestBody requestBody3 = RequestBody.create(MediaType.parse("name"),"this_is_username");
//        RequestBody requestBody4 = RequestBody.create(MediaType.parse("message"),"this_is_username");
//        WebClient.getInstance().postSendMessage(requestBody1,requestBody2,requestBody3,requestBody4).enqueue(new Callback<receiveBean>()
////        WebClient.getInstance().postSendMessage(roomId,"1155169171","William","haha!").enqueue(new Callback<receiveBean>()
////                WebClient.getInstance().postSendMessage(sb).enqueue(new Callback<receiveBean>()
//        {
//            @Override
//            public void onResponse(Call<receiveBean> call, Response<receiveBean> response )
//            {Log.d("Call request", call.request().toString());
//                Log.d("Call request header", call.request().headers().toString());
//                Log.d("Response raw header", response.headers().toString());
//                Log.d("Response raw", String.valueOf(response.raw().body()));
//                Log.d("Response code", String.valueOf(response.code()));
//                if(response.isSuccessful())
//                {
//                    Log.i("response",response.toString());
//                    receiveBean rb = response.body();
//                    System.out.println("--------: "+rb.getStatus());
//                    System.out.println("---------------------------------");
//                }else{
//                    System.out.println("---------------4441-----------------"+ String.valueOf(response.errorBody()));
//                    System.out.println("---------------4442-----------------"+response.body());
//                    System.out.println("---------------4443-----------------"+response.getClass());
//                }
//            }
//            @Override
//            public void onFailure(Call<receiveBean> call, Throwable t) {
//                System.out.println("----------------22-----------------");
//            }
//        });
//    }
//    public void callHistoryMessageHttp(){
//        WebClient.getInstance().getHistoryMessage(roomId,1).enqueue(new Callback<MessageBean>()
//        {
//            @Override
//            public void onResponse(Call<MessageBean> call, Response<MessageBean> response )
//            {
//                if(response.isSuccessful())
//                {
//                    Log.i("response",response.toString());
//                    MessageBean cb = response.body();
//                    rowsBeanList = cb.getData();
//                    System.out.println("11111111111112: "+cb.getStatus());
//                    System.out.println("11111111111113: "+rowsBeanList.getCurrent_page());
//                    historymessage = rowsBeanList.getMessages();
//                    for(int i=0; i<historymessage.size();i++){
//                        historymessage_temp.add(historymessage.get(i));
//                    }
//                    messageadapter = new MessageAdapter(ChatActivity.this, historymessage_temp);
//                    listView.setAdapter(messageadapter);
//                }else{
//
//                }
//            }
//            @Override
//            public void onFailure(Call<MessageBean> call, Throwable t) { }
//        });
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.menu_chat,menu);
//        setIconsVisible(menu,true);
//        return true;
//    }
//    /**
//     * 解决不显示menu icon的问题
//     * @param menu
//     * @param flag
//     */
//    private void setIconsVisible(Menu menu, boolean flag) {
//        //判断menu是否为空
//        if(menu != null) {
//            try {
//                //如果不为空,就反射拿到menu的setOptionalIconsVisible方法
//                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
//                //暴力访问该方法
//                method.setAccessible(true);
//                //调用该方法显示icon
//                method.invoke(menu, flag);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    private void showNormalDialog(){
//        /* @setIcon 设置对话框图标
//         * @setTitle 设置对话框标题
//         * @setMessage 设置对话框消息提示
//         * setXXX方法返回Dialog对象，因此可以链式设置属性
//         */
//        final AlertDialog.Builder normalDialog =
//                new AlertDialog.Builder(this);
////        normalDialog.setIcon(R.drawable.icon_dialog);
//        normalDialog.setTitle("Tips");
//        normalDialog.setMessage("Input is empty!");
//        normalDialog.setPositiveButton("OK",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //...To-do
//                    }
//                });
//        // 显示
//        normalDialog.show();
//    }
//
//
//
//}
