package adi.flickhubbyadi.flickhub.Splash_Intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import adi.flickhubbyadi.flickhub.R;

public class SplashScreen extends AppCompatActivity {
    int k=1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

        setContentView(R.layout.splashscreen);

        new CountDownTimer(2000,400){
         ImageView logo = findViewById(R.id.logo);
            @Override
            public void onTick(long millisUntilFinished) {
                if(k%2==0){
               logo.animate().alpha(0.4f).setDuration(500);
                k++;
            }
                else{
                  logo.animate().alpha(1f).setDuration(500);
                  k++;
                }
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashScreen.this, IntroActivity.class));
            }
        }.start();

    }
}
