package mendez.pa1.org;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    ImageView ivLogo;
    TextView  txtLogo;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivLogo = findViewById(R.id.ivLogo);
        txtLogo = findViewById(R.id.txtLogo);

        animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        ivLogo.startAnimation(animation);
        txtLogo.startAnimation(animation);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i= new Intent(Splash.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        },3000);
    }
}