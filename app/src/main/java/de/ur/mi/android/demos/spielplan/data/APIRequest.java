package de.ur.mi.android.demos.spielplan.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class APIRequest {

    private static final String API_URL_FOR_MATCH_DATA = "https://em.software-engineering.education/api/getmatchdata/em20/";
    private final Context context;

    public APIRequest(Context context) {
        this.context = context;
    }

    public void send(ResponseListener listener) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, API_URL_FOR_MATCH_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                listener.onError();
            }
        });
        queue.add(stringRequest);
    }

    public interface ResponseListener {
        void onResponse(String response);

        void onError();
    }
}
