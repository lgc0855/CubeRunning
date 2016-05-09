package com.example.liguochao.cuberunning;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.OnStartTraceListener;
import com.baidu.trace.OnStopTraceListener;
import com.baidu.trace.OnTrackListener;
import com.baidu.trace.Trace;

public class MainActivity extends AppCompatActivity {
    Trace trace ;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button)findViewById(R.id.start) ;
        Button stop = (Button)findViewById(R.id.stop) ;
        Button qurey = (Button)findViewById(R.id.qurey) ;
        final TextView message_callback = (TextView)findViewById(R.id.message_callback) ;
        initTrace();


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.startTrace(trace, startTraceListener);
            }
        });

        qurey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int simpleReturn = 0 ;
                int startTime = (int) (System.currentTimeMillis() / 1000 - 12 * 60 * 60);
                int endTime = (int) (System.currentTimeMillis() / 1000);
                // 分页大小
                int pageSize = 1000;
                // 分页索引
                int pageIndex = 1;
                client.queryHistoryTrack(serviceId, entityName, simpleReturn, startTime
                        , endTime, pageSize, pageIndex, trackListener);
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化停止轨迹服务回调接口
                OnStopTraceListener stopTraceListener = new OnStopTraceListener(){
                    // 轨迹服务停止成功
                    @Override
                    public void onStopTraceSuccess() {
                    }
                    // 轨迹服务停止失败（arg0 : 错误编码，arg1 : 消息内容，详情查看类参考）
                    @Override
                    public void onStopTraceFailed(int arg0, String arg1) {
                    }
                };

//停止轨迹服务
                client.stopTrace(trace, stopTraceListener);
            }
        });

        trackListener = new OnTrackListener() {

            // 请求失败回调接口
            @Override
            public void onRequestFailedCallback(String arg0) {
                // TODO Auto-generated method stub
                Looper.prepare();
                Toast.makeText(MainActivity.this, "track请求失败回调接口消息 : " + arg0, Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            // 查询历史轨迹回调接口
            @Override
            public void onQueryHistoryTrackCallback(String arg0) {
                // TODO Auto-generated method stub
                super.onQueryHistoryTrackCallback(arg0);
                message_callback.setText(arg0);
                Log.d("Main", arg0) ;
            }

        };



    }


    void initTrace(){
        //实例化轨迹服务客户端
        client = new LBSTraceClient(getApplicationContext());
        //entity标识
        entityName = "mycar";
        //实例化轨迹服务
        trace = new Trace(getApplicationContext(), serviceId, entityName, traceType);
        //实例化开启轨迹服务回调接口
        startTraceListener = new OnStartTraceListener() {
            //开启轨迹服务回调接口（arg0 : 消息编码，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onTraceCallback(int arg0, String arg1) {
            }
            //轨迹服务推送接口（用于接收服务端推送消息，arg0 : 消息类型，arg1 : 消息内容，详情查看类参考）


            //位置采集周期            @Override
            public void onTracePushCallback(byte arg0, String arg1) {
            }
        };
        client.setInterval(gatherInterval, packInterval);
        client.startTrace(trace, startTraceListener);

        client.startTrace(trace, startTraceListener);


    }
}
