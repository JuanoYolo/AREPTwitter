package co.edu.escuelaing.service;

import org.json.JSONObject;

public class Service {

    public Object addPost(String value) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("post:",value);
        return jsonObject;
    }

}
