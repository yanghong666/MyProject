package com.example.yanghong.myqx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = ScreenShotUtils.shotBitmap(MainActivity.this);
                if (flag) {
                    Toast.makeText(MainActivity.this, "截图成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "截图失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
