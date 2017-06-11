package com.example.acerpc.myapplication;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private FactBook f = new FactBook();
    //Declare our View variables
    private TextView factView;
    private Button show;
    private ConstraintLayout background;
    private int randomGenerated;
    String[] background_color={"#DC143C","#BA55D3","#00CD66","#51b46d","#8E8E38","#8E388E","#FFD700","#9ACD32","#4F94CD","#FF3E96"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Views from the layout to the corresponding variables
        factView=(TextView) findViewById(R.id.textView2);
        show=(Button) findViewById(R.id.button);
        background = (ConstraintLayout) findViewById(R.id.background_layout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                factView.setText(f.getFact());
                randomGenerated=f.getRandomNumber();
                background.setBackgroundColor(Color.parseColor(background_color[randomGenerated]));
                show.setTextColor(Color.parseColor(background_color[randomGenerated]));
            }
        };
        show.setOnClickListener(listener);
        //Toast.makeText(this, "Yay !", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"We are logging from the onCreate() method");
    }
}
