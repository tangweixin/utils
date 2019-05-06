/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tangweixin.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Web相关工具类
 *
 * @author thomas
 * @date 2019-04-30
 */
public final class WebUtils {

    /**
     * 获得请求的基础路径.
     *
     * @param request
     * @return
     */
    public static String getBaseURI(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        sb.append(request.getScheme());
        sb.append("://");
        sb.append(request.getServerName());
        int port = request.getServerPort();
        if (port != 80 && port != 443) {
            sb.append(":");
            sb.append(port);
        }
        sb.append(request.getContextPath());
        return sb.toString();
    }

    /**
     * 获取客户端真实IP.
     *
     * @param request
     * @param headers
     * @return
     */
    public static String getIp(HttpServletRequest request, String... headers) {
        String ip = getIpByHeaders(request, headers);
        if (isBlank(ip)) {
            ip = request.getRemoteAddr();
        }
        // 对于多级代理，只取第一个
        ip = ip.split(",")[0];

        // 多级代理，取最后一个
        // String[] ips = ip.split(",");
        // ip = ips[ips.length - 1].trim();

        // 重要：线上环境，去掉该段代码！
        // if ("0:0:0:0:0:0:0:1".equals(ip)) {
        // ip = "127.0.0.1";
        // // 本地开发环境，获取ip地址.
        // ip = NetUtils.getLocalHost();
        // }
        return ip;
    }

    /**
     * 获取客户端真实IP.
     *
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        return getIp(request, "remoteip", "x-real-ip", "x-forwarded-for");
    }

    /**
     * 获取IP，循环调用.
     *
     * @param request
     * @param headers
     * @return
     */
    private static String getIpByHeaders(HttpServletRequest request, String... headers) {
        String ip = null;
        for (String h : headers) {
            ip = request.getHeader(h);
            if (!isBlank(ip)) {
                return ip;
            }
        }
        return ip;
    }

    /**
     * 获得请求的基础路径.
     *
     * @param request
     * @return
     */
    public static String getURI(HttpServletRequest request) {
        String uri = request.getRequestURI();
        uri = uri.replace(request.getContextPath(), "");
        return uri;
    }

    /**
     * 获取请求头的Map数据
     *
     * @return
     */
    public static Map<String, String> getHeadersMap(HttpServletRequest req) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            String k = e.nextElement();
            String v = req.getHeader(k);
            map.put(k, v);
        }
        return map;
    }

    /**
     * 获取请求头的Json格式数据.
     *
     * @param req
     * @return
     */
    public static String getHeadersJson(HttpServletRequest req) {
        return JsonUtils.toJson(getHeadersMap(req));
    }

    /**
     * 获取当前请求的完整URL地址
     *
     * @param request
     * @return
     */
    public static String getRequestURL(HttpServletRequest request) {
        String link = request.getRequestURL().toString();
        String q = request.getQueryString();
        if (!isBlank(q)) {
            link += "?" + q;
        }
        return link;
    }

    /**
     * 显示请求详情.
     *
     * @param req
     */
    public static void show(HttpServletRequest req) {
        String method = req.getMethod();
        System.out.println("method-->" + method);
        String uri = req.getRequestURL() + "";
        String query = req.getQueryString();
        if (query != null && !"".equals(query.trim())) {
            uri = uri + "?" + query;
        }
        System.out.println("url=" + uri);
        showRequest(req);
        System.out.println();
    }

    /**
     * 显示请求信息.
     *
     * @param req
     */
    public static void showRequest(HttpServletRequest req) {
        showParams(req);
        showHeaders(req);
    }

    /**
     * 显示请求头信息.
     *
     * @param req
     */
    public static void showHeaders(HttpServletRequest req) {
        System.out.println("=============show Headers==============");
        Enumeration<String> e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            String s = e.nextElement();
            String v = req.getHeader(s);
            System.out.println(s + "=" + v);
        }
    }

    /**
     * 显示请求参数.
     *
     * @param req
     */
    public static void showParams(HttpServletRequest req) {
        System.out.println("=============show showParams==============");
        Map<String, String[]> map = req.getParameterMap();
        for (Map.Entry<String, String[]> e : map.entrySet()) {
            String key = e.getKey();
            String v = Arrays.toString(e.getValue());
            System.out.println(key + "=" + v);
        }
    }

    /**
     * 获取Cookies
     *
     * @param req
     * @return
     */
    public static Map<String, Cookie> getCookieMaps(HttpServletRequest req) {
        Map<String, Cookie> map = new HashMap<>();
        Cookie[] cs = req.getCookies();
        if (cs == null || cs.length == 0) {
            return map;
        }
        for (Cookie c : cs) {
            map.put(c.getName().toUpperCase(), c);
        }
        return map;
    }

    /**
     * 是否为空白字符
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}