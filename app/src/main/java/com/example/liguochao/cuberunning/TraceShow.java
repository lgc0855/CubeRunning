package com.example.liguochao.cuberunning;

import android.graphics.Color;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

import java.util.ArrayList;
import java.util.List;

import util.GsonService;

import static android.app.PendingIntent.getActivity;

/**
 * Created by liguochao on 2016/5/9.
 */
public class TraceShow {

    private Button btnDate = null;

    private Button btnProcessed = null;

    private int startTime = 0;
    private int endTime = 0;

    private int year = 0;
    private int month = 0;
    private int day = 0;

    // 起点图标
    private static BitmapDescriptor bmStart;
    // 终点图标
    private static BitmapDescriptor bmEnd;

    // 起点图标覆盖物
    private static MarkerOptions startMarker = null;
    // 终点图标覆盖物
    private static MarkerOptions endMarker = null;
    // 路线覆盖物
    private static PolylineOptions polyline = null;

    private MapStatusUpdate msUpdate = null;

    private TextView tvDatetime = null;

    private static int isProcessed = 0;

    protected void showHistoryTrack(String historyTrack) {
        Log.d("TraceShow","this is in showHistoryTrack") ;

        HistoryTrackData historyTrackData = GsonService.parseJson(historyTrack,
                HistoryTrackData.class);

        List<LatLng> latLngList = new ArrayList<LatLng>();
        if (historyTrackData != null && historyTrackData.getStatus() == 0) {
            if (historyTrackData.getListPoints() != null) {
                latLngList.addAll(historyTrackData.getListPoints());
            }

            // 绘制历史轨迹
            drawHistoryTrack(latLngList, historyTrackData.distance);

        }

    }

    /**
     * 绘制历史轨迹
     *
     * @param points
     */
    private void drawHistoryTrack(final List<LatLng> points, final double distance) {
        // 绘制新覆盖物前，清空之前的覆盖物
        MainActivity.mBaiduMap.clear();
        Log.d("TraceShow","this is in drawTrace") ;

        if (points == null || points.size() == 0) {
            Looper.prepare();
            //Toast.makeText(MainActivity, "当前查询无轨迹点", Toast.LENGTH_SHORT).show();
            Looper.loop();
            resetMarker();
        } else if (points.size() > 1) {

            LatLng llC = points.get(0);
            LatLng llD = points.get(points.size() - 1);
            LatLngBounds bounds = new LatLngBounds.Builder()
                    .include(llC).include(llD).build();

            msUpdate = MapStatusUpdateFactory.newLatLngBounds(bounds);

            bmStart = BitmapDescriptorFactory.fromResource(R.drawable.icon_start);
            bmEnd = BitmapDescriptorFactory.fromResource(R.drawable.icon_end);

            // 添加起点图标
            startMarker = new MarkerOptions()
                    .position(points.get(points.size() - 1)).icon(bmStart)
                    .zIndex(9).draggable(true);

            // 添加终点图标
            endMarker = new MarkerOptions().position(points.get(0))
                    .icon(bmEnd).zIndex(9).draggable(true);

            // 添加路线（轨迹）
            polyline = new PolylineOptions().width(10)
                    .color(Color.RED).points(points);

            addMarker();

            Looper.prepare();
        //    Toast.makeText(getActivity(), "当前轨迹里程为 : " + (int) distance + "米", Toast.LENGTH_SHORT).show();
            Looper.loop();

        }

    }

    /**
     * 添加覆盖物
     */
    protected void addMarker() {

        if (null != msUpdate) {
            MainActivity.mBaiduMap.setMapStatus(msUpdate);
        }

        if (null != startMarker) {
            MainActivity.mBaiduMap.addOverlay(startMarker);
        }

        if (null != endMarker) {
            MainActivity.mBaiduMap.addOverlay(endMarker);
        }

        if (null != polyline) {
            MainActivity.mBaiduMap.addOverlay(polyline);
        }

    }


    /**
     * 重置覆盖物
     */
    private void resetMarker() {
        startMarker = null;
        endMarker = null;
        polyline = null;
    }

}
