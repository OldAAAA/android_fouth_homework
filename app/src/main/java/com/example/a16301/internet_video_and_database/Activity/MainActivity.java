
package com.example.a16301.internet_video_and_database.Activity;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.a16301.internet_video_and_database.R;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements
        MediaController.MediaPlayerControl,
        MediaPlayer.OnBufferingUpdateListener,
        SurfaceHolder.Callback {

    //MediaPlayer用于播放视频
    private MediaPlayer mediaPlayer;
    //MediaController用于控制视频
    private MediaController controller;
    private int bufferPercentage = 0;
    private String TAG = "nihao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();

        //初始化设置MediaController的控制界面是此activity
        controller = new MediaController(this);
        controller.setAnchorView(findViewById(R.id.surfaceView));

//        VideoView videoView = findViewById(R.id.);
//        String uri = "http://192.168.0.106:8000/vedio/1.mp4";
//        videoView.setVideoURI(Uri.parse(uri));
//        videoView.start();

        initSurfaceView();
    }

    private void initSurfaceView(){
        SurfaceView videoSuf = (SurfaceView) findViewById(R.id.surfaceView);
        videoSuf.setZOrderOnTop(false);
        videoSuf.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        videoSuf.getHolder().addCallback(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        try {
            String uri = "http://192.168.0.106:8000/vedio/1.mp4";
            mediaPlayer.setDataSource(this,Uri.parse(uri));
            mediaPlayer.setOnBufferingUpdateListener(this);
            controller.setMediaPlayer(this);
            controller.setEnabled(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //当页面暂停的时候设置mediaplayer暂停
    @Override
    protected void onPause(){
        super.onPause();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    //当页面销毁的时候设置mediaplayer释放
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mediaPlayer){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    //当点击屏幕时,显示控制器
    @Override
    public boolean onTouchEvent(MotionEvent event){
        controller.show();
        return super.onTouchEvent(event);
    }

    //MediaController.MediaPlayerControl的重写方法
    @Override
    public void start() {
        if(null != mediaPlayer){
            mediaPlayer.start();
        }
    }

    @Override
    public void pause() {
        if(null != mediaPlayer){
            mediaPlayer.pause();
        }
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mediaPlayer.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        if (mediaPlayer.isPlaying()){
            return true;
        }
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return bufferPercentage;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    //MediaPlayer.OnBufferingUpdateListener的重写方法
    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        bufferPercentage = percent;
    }

    //SurfaceHolder的callback
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mediaPlayer.setDisplay(holder);
        mediaPlayer.prepareAsync();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

}
