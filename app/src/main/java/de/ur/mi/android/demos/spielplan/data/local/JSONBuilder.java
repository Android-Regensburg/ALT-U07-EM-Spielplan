package de.ur.mi.android.demos.spielplan.data.local;

import org.json.JSONException;
import org.json.JSONObject;

public interface JSONBuilder<T> {

    T fromJSONObject(JSONObject object) throws JSONException;

}
