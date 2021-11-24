package hk.edu.cuhk.ie.iems5722.a2_1155169171;


import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

import org.json.JSONObject;

import java.util.HashMap;
//import java.util.Observable;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    /*无参GET请求 */
    //没有数据就填 '.' 或者 '/'
    //获取通讯录接口
    @GET("get_chatrooms")
    Call<ClassroomBean> getClassRoomList();

    @GET("get_messages")
    Call<MessageBean> getHistoryMessage(@Query("chatroom_id")String chatroom_id, @Query("page") int page);

//    @Headers("Content-Type:application/json")
//    @POST("user/login")
//    Observable<ResponseBody> login(@Body RequestBody requestBody);

    @POST("/send_message")
    @Multipart
//    fun getProcess(@Part("action") requestBody: RequestBody):Call<Any>
    Call<receiveBean> postSendMessage(@Part("chatroom_id")RequestBody chatroom_id,@Part("user_id") RequestBody user_id,@Part("name") RequestBody name,@Part("message") RequestBody message);
//    Call<receiveBean> postSendMessage(@JsonAdapter() sendMessageBean);
//    Call<JsonObject> postSendMessage(@Field("chatroom_id")String chatroom_id, @Field("user_id") String user_id, @Field("name") String name, @Field("message") String message);
//    Call<receiveBean> postSendMessage(@Query("chatroom_id")String chatroom_id, @Query("user_id") String user_id, @Query("name") String name, @Query("message") String message);
//    Call<receiveBean> postSendMessage(@Body RequestBody sendMessageBean);
//    @GET("api/teacher")/*api/teacher?type=4&num=10*/
//    Call<Teacher> getCall(@Query("type") String type, @Query("num")String num);
//    //文件上传接口
//    @Multipart
//    @POST("/common/upload")
//    Call<UploadBean> upload(@Part MultipartBody.Part file);

}
