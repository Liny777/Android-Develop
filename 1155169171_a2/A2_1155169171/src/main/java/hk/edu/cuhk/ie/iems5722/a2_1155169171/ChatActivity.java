package hk.edu.cuhk.ie.iems5722.a2_1155169171;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import com.alibaba.fastjson.JSON;

public class ChatActivity extends AppCompatActivity {
    private ArrayList<hk.edu.cuhk.ie.iems5722.a2_1155169171.Msg> msgs;
    private EditText editText;
    private hk.edu.cuhk.ie.iems5722.a2_1155169171.MessageAdapter myadapter;
    private ListView listView;
    private ImageButton btnSpeak;
    private int totalPage;
    private int currentPage;
    private int oldVisibleItem;
    private int Flag_stop=0;
    private Integer firstItem;
    private Integer statusCode = 0;
    MessageBean.DataBean rowsBeanList;
    List<Msg> historymessage;
    ArrayList<Msg> historymessage_temp = new ArrayList<Msg>();
    MessageAdapter messageadapter;
    String roomId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String roomTitle = intent.getStringExtra("room_title");
        roomId = intent.getStringExtra("room_id");
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = findViewById(R.id.tb);
        toolbar.setTitle(roomTitle);
        setSupportActionBar(toolbar);
        // toolbar
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                callHRefreshMessageHttp();
//                callHistoryMessageHttp(1);
//                callHistoryMessageHttp(2);
                return true;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // http request
        callHistoryMessageHttp(1);
        // Dialogue
        editText = (EditText) findViewById(R.id.MessageText);
        msgs = new ArrayList<hk.edu.cuhk.ie.iems5722.a2_1155169171.Msg>();
        myadapter = new hk.edu.cuhk.ie.iems5722.a2_1155169171.MessageAdapter(this, msgs);
        listView = (ListView) findViewById(R.id.lv_main);
        btnSpeak = (ImageButton) findViewById(R.id.button_main);
        btnSpeak.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String msg=editText.getText().toString();
                if(!msg.trim().isEmpty())
                {
                    editText.getText().clear();
                    FormBody formBody = new FormBody.Builder()
                            .add("chatroom_id", roomId)
                            .add("user_id", "1155169171")
                            .add("name", "Liny")
                            .add("message", msg)
                            .build();
                    Request postMessages = new Request.Builder()
                            .url("http://18.217.125.61/api/a3/send_message")
                            .post(formBody)
                            .build();
                    OkHttpClient client = new OkHttpClient();
                    client.newCall(postMessages).enqueue(new okhttp3.Callback() {
                        @Override
                        public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                            e.printStackTrace();
                        }
                        @Override
                        public void onResponse(@NonNull okhttp3.Call call, @NonNull okhttp3.Response response) throws IOException {
                            Log.d("Call request", call.request().toString());
                            Log.d("Call request header", call.request().headers().toString());
                            Log.d("Response raw header", response.headers().toString());
                            Log.d("Response raw", String.valueOf(response.body()));
                            Log.d("Response code", String.valueOf(response.code()));
//                            JSONObject responseobj=new JSONObject(response.body().toString());
                            String s = response.body().string();
//                            String s = JSON.toJSONString(response.body());
//                            ResponseBody rb = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(s);
                                String status = jsonObject.getString("status");
                                System.out.println("=======: "+status);
                                if (status.equals("ERROR")){
                                    Log.d("postMessageStatus",status);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener(){
//            boolean is_top=false;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                /**
                 *scrollState有三种状态，分别是SCROLL_STATE_IDLE、SCROLL_STATE_TOUCH_SCROLL、SCROLL_STATE_FLING
                 *SCROLL_STATE_IDLE是当屏幕停止滚动时
                 *SCROLL_STATE_TOUCH_SCROLL是当用户在以触屏方式滚动屏幕并且手指仍然还在屏幕上时（The user is scrolling using touch, and their finger is still on the screen）
                 *SCROLL_STATE_FLING是当用户由于之前划动屏幕并抬起手指，屏幕产生惯性滑动时（The user had previously been scrolling using touch and had performed a fling）
                 */
//                if (scrollState==SCROLL_STATE_IDLE){
////                    Flag_stop = 0;
//                    if (is_top==true){
//                        if (currentPage < totalPage){
//                            callHistoryMessageOfMore();
//                        }
//                        is_top=false;
//                    }
//                }
//                if (scrollState==SCROLL_STATE_TOUCH_SCROLL){
////                    Flag_stop = 0;
//                }
//                if (scrollState==SCROLL_STATE_FLING){
////                    Flag_stop = 0;
//                }
                statusCode = scrollState;
                if (statusCode != 0 && firstItem == 0) {
                    if (currentPage < totalPage) {
                        callHistoryMessageOfMore();
                    }
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                /**
                 * firstVisibleItem 表示在当前屏幕显示的第一个listItem在整个listView里面的位置（下标从0开始）
                 * visibleItemCount表示在现时屏幕可以见到的ListItem(部分显示的ListItem也算)总数
                 * totalItemCount表示ListView的ListItem总数
                 * listView.getLastVisiblePosition()表示在现时屏幕最后一个ListItem
                 * (最后ListItem要完全显示出来才算)在整个ListView的位置（下标从0开始）
                 */
                firstItem = firstVisibleItem;
//                if ((visibleItemCount>0)&&(firstVisibleItem==0)){
//                    // scrolled to the top of listview
//                    Log.d("messagesView","scrolled to the top");
//                    is_top=true;
//                }
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount > 0) {
                    // 滚动到最后一行了
//                    if(Flag_stop==1){
//                        callHistoryMessageOfMore();
//                    }
                }
                if (firstVisibleItem > oldVisibleItem) {
//                    if(Flag_stop==1){
//                        callHistoryMessageOfMore();
//                    }
//                    if ((visibleItemCount>0)&&(firstVisibleItem==0)){
//                        // scrolled to the top of listview
//                        Log.d("messagesView","scrolled to the top");
//                        is_top=true;
//                    }
                    // 向上滑动
                }
                if ((visibleItemCount>0)&&(firstVisibleItem==0)){
                    // scrolled to the top of listview
//                    Log.d("messagesView","scrolled to the top");
//                    is_top=true;
                }
                if (firstVisibleItem < oldVisibleItem) {
                    // 向下滑动
//                    is_top=false;

                }
                oldVisibleItem = firstVisibleItem;
            }
        });
    }
//    // 获取当前可见区域内第一个item的id
//        mListView.getFirstVisiblePosition();
//
//    // 获取当前可见区域内最后一个item的id
//        mListView.getLastVisiblePosition();

    public void postMessagetoServer(){


    }
    public void callHistoryMessageOfMore(){
        WebClient.getInstance().getHistoryMessage(roomId,currentPage+1).enqueue(new Callback<MessageBean>()
        {
            @Override
            public void onResponse(Call<MessageBean> call, Response<MessageBean> response )
            {
                if(response.isSuccessful())
                {
                    Log.i("response",response.toString());
                    MessageBean cb = response.body();
                    rowsBeanList = cb.getData();
                    totalPage =  Integer.valueOf(rowsBeanList.getTotal_page());
                    currentPage = Integer.valueOf(rowsBeanList.getCurrent_page());
                    System.out.println("cb.getStatus() "+cb.getStatus());
                    System.out.println("rowsBeanList.getCurrent_page() "+rowsBeanList.getCurrent_page());
                    List<Msg> historymessage_temp_1;
                    historymessage_temp_1 = rowsBeanList.getMessages();
                    for(int i=0; i<historymessage_temp_1.size();i++){
//                    for(int i=historymessage_temp_1.size()-1; i>=0;i--){
                        if (historymessage_temp_1.get(i).getUser_id().equals("1155169171")){
                            historymessage_temp_1.get(i).setType(0);
                        }else {
                            historymessage_temp_1.get(i).setType(1);
                        }
                        historymessage_temp.add(0,historymessage_temp_1.get(i));
                    }
                    messageadapter = new MessageAdapter(ChatActivity.this, historymessage_temp);
                    listView.setAdapter(messageadapter);
                    int fv = listView.getFirstVisiblePosition();
//                    System.out.println("---------------------------fy: "+fv);
                    listView.setSelection(fv);
                }else{

                }
            }
            @Override
            public void onFailure(Call<MessageBean> call, Throwable t) { }
        });
    }
    public void callHRefreshMessageHttp(){
        WebClient.getInstance().getHistoryMessage(roomId,1).enqueue(new Callback<MessageBean>()
        {
            @Override
            public void onResponse(Call<MessageBean> call, Response<MessageBean> response )
            {
                if(response.isSuccessful())
                {
                    Log.i("response",response.toString());
                    MessageBean cb = response.body();
                    rowsBeanList = cb.getData();
                    System.out.println("cb.getStatus() "+cb.getStatus());
                    System.out.println("rowsBeanList.getCurrent_page() "+rowsBeanList.getCurrent_page());
                    currentPage = Integer.valueOf(rowsBeanList.getCurrent_page());
                    totalPage =  Integer.valueOf(rowsBeanList.getTotal_page());
                    historymessage = rowsBeanList.getMessages();
                    historymessage_temp.clear();
                    for(int i=0; i<historymessage.size();i++){
//                    for(int i=historymessage.size()-1; i>=0;i--){
                        if (historymessage.get(i).getUser_id().equals("1155169171")){
                            historymessage.get(i).setType(0);
                        }else {
                            historymessage.get(i).setType(1);
                        }
                        historymessage_temp.add(0,historymessage.get(i));
                    }
                    messageadapter = new MessageAdapter(ChatActivity.this, historymessage_temp);
                    listView.setAdapter(messageadapter);
//                    int fv = listView.getFirstVisiblePosition();
//                    listView.setSelection(fv);
                }else{

                }
            }
            @Override
            public void onFailure(Call<MessageBean> call, Throwable t) { }
        });
        WebClient.getInstance().getHistoryMessage(roomId,2).enqueue(new Callback<MessageBean>()
        {
            @Override
            public void onResponse(Call<MessageBean> call, Response<MessageBean> response )
            {
                if(response.isSuccessful())
                {
                    Log.i("response",response.toString());
                    MessageBean cb = response.body();
                    rowsBeanList = cb.getData();
                    System.out.println("cb.getStatus() "+cb.getStatus());
                    System.out.println("rowsBeanList.getCurrent_page() "+rowsBeanList.getCurrent_page());
                    currentPage = Integer.valueOf(rowsBeanList.getCurrent_page());
                    totalPage =  Integer.valueOf(rowsBeanList.getTotal_page());
                    historymessage = rowsBeanList.getMessages();
//                    historymessage_temp.clear();
                    for(int i=0; i<historymessage.size();i++){
//                    for(int i=historymessage.size()-1; i>=0;i--){
                        if (historymessage.get(i).getUser_id().equals("1155169171")){
                            historymessage.get(i).setType(0);
                        }else {
                            historymessage.get(i).setType(1);
                        }
                        historymessage_temp.add(0,historymessage.get(i));
                    }
                    messageadapter = new MessageAdapter(ChatActivity.this, historymessage_temp);
                    listView.setAdapter(messageadapter);
//                    int fv = listView.getFirstVisiblePosition();
//                    listView.setSelection(fv);
                }else{

                }
            }
            @Override
            public void onFailure(Call<MessageBean> call, Throwable t) { }
        });
    }
    public void callHistoryMessageHttp(int num){
        WebClient.getInstance().getHistoryMessage(roomId,num).enqueue(new Callback<MessageBean>()
        {
            @Override
            public void onResponse(Call<MessageBean> call, Response<MessageBean> response )
            {
                if(response.isSuccessful())
                {
                    Log.i("response",response.toString());
                    MessageBean cb = response.body();
                    rowsBeanList = cb.getData();
                    System.out.println("cb.getStatus() "+cb.getStatus());
                    System.out.println("rowsBeanList.getCurrent_page() "+rowsBeanList.getCurrent_page());
                    currentPage = Integer.valueOf(rowsBeanList.getCurrent_page());
                    totalPage =  Integer.valueOf(rowsBeanList.getTotal_page());
                    historymessage = rowsBeanList.getMessages();
                    historymessage_temp.clear();
                    for(int i=0; i<historymessage.size();i++){
//                    for(int i=historymessage.size()-1; i>=0;i--){
                        if (historymessage.get(i).getUser_id().equals("1155169171")){
                            historymessage.get(i).setType(0);
                            }else {
                            historymessage.get(i).setType(1);
                            }
                        historymessage_temp.add(0,historymessage.get(i));
                    }
                    messageadapter = new MessageAdapter(ChatActivity.this, historymessage_temp);
                    listView.setAdapter(messageadapter);
//                    int fv = listView.getFirstVisiblePosition();
//                    listView.setSelection(fv);
                }else{

                }
            }
            @Override
            public void onFailure(Call<MessageBean> call, Throwable t) { }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_chat,menu);
        setIconsVisible(menu,true);
        return true;
    }
    /**
     * 解决不显示menu icon的问题
     * @param menu
     * @param flag
     */
    private void setIconsVisible(Menu menu, boolean flag) {
        //判断menu是否为空
        if(menu != null) {
            try {
                //如果不为空,就反射拿到menu的setOptionalIconsVisible方法
                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                //暴力访问该方法
                method.setAccessible(true);
                //调用该方法显示icon
                method.invoke(menu, flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(this);
//        normalDialog.setIcon(R.drawable.icon_dialog);
        normalDialog.setTitle("Tips");
        normalDialog.setMessage("Input is empty!");
        normalDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }



}
