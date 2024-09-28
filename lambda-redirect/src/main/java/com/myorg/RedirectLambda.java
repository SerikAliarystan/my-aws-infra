package com.myorg;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class RedirectLambda implements RequestHandler<Object, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(Object input, Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Location", "https://google.com/");

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 302);
        response.put("headers", headers);

        return response;
    }
}
