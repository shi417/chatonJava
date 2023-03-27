package com.gpt.holder;

import jakarta.servlet.http.HttpServletRequest;

public class RequestHolder {

    private static final ThreadLocal<HttpServletRequest> REQUEST_HOLDER = new ThreadLocal<>();

    public static void set(HttpServletRequest request) {
        REQUEST_HOLDER.set(request);
    }

    public static HttpServletRequest get() {
        return REQUEST_HOLDER.get();
    }

    public static void remove() {
        REQUEST_HOLDER.remove();
    }
}
