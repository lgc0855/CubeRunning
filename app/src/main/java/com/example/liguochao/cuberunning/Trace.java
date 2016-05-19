package com.example.liguochao.cuberunning;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.OnStartTraceListener;
import com.baidu.trace.OnTrackListener;

/**
 * Created by liguochao on 2016/5/19.
 */
public class Trace {

    com.baidu.trace.Trace trace ;
    LBSTraceClient client;
    OnStartTraceListener startTraceListener ;
    String entityName ;
    protected static OnTrackListener trackListener = null;
    int gatherInterval = 2;
    //打包周期
    int packInterval=6;
    //设置位置采集和打包周期

    //鹰眼服务ID
    final long serviceId  =  115846  ;
    //轨迹服务类型（0 : 不上传位置数据，也不接收报警信息； 1 : 不上传位置数据，但接收报警信息；2 : 上传位置数据，且接收报警信息）
    int  traceType = 2;

    protected static BaiduMap mBaiduMap = null;
    protected static MapView bmapView = null;



}
