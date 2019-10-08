package Login;

import android.app.DownloadManager;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Login {
    public  static  String SessionId;
    public static void login (String User_name, String Password, final TextView tv, RequestQueue queue){
    String url ="https://eniso.info/ws/core/login/"+User_name+"?password="+Password;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONObject res = response.getJSONObject("$1");
                    SessionId =res.getString("session");

                }catch (JSONException e){
                    try {
                        JSONObject res1 = response.getJSONObject("$error");
                        String m = res1.getString("message");
                        tv.setText(m);
                    }catch (JSONException e2){

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("no response !!");

            }
        });
        queue.add(request);
    }

}
