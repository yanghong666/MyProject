package com.example.yanghong.myqx;


import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
public class ShotScreenActivity extends Activity {
    private Button button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shot_screen);

        initView();

        button01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                button01.setVisibility(Button.GONE);//截图开始时隐藏按钮
                getAndSaveCurrentImage();
                button01.setVisibility(Button.VISIBLE);//截图结束时显示按钮
            }
        });
    }

    //初始化组件
    public void initView(){
        button01 = (Button)this.findViewById(R.id.button01);
    }

    //截取当前屏幕的图像并保存至SDCard特定目录下
    public void getAndSaveCurrentImage(){
        WindowManager windowManager = this.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int w = display.getWidth();
        int h = display.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        View decorView = this.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        bitmap = decorView.getDrawingCache();
        String savePath = getSDCardPath() + "/mcc/currentImage/";

        try{
            File path = new File(savePath);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss", Locale.US);
            String imagePath = savePath + sdf.format(new Date()) + ".png";
            File file = new File(imagePath);
            if(!path.exists()){
                path.mkdirs();
            }
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = null;
            fos = new FileOutputStream(file);
            if(null != fos){
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
                Toast.makeText(this, "截屏文件已保存至SDCard/mcc/currentImage/下",
                        Toast.LENGTH_LONG).show();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //得到SDCard根目录
    public String getSDCardPath(){
        File sdCardDir = null;
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            sdCardDir = Environment.getExternalStorageDirectory();
        }

        return sdCardDir.toString();

    }
}