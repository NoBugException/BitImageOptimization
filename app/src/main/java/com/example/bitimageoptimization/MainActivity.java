package com.example.bitimageoptimization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private BitImageView bigImageView;

    private Button load_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load_image = findViewById(R.id.load_image);
        bigImageView = findViewById(R.id.bigImageView);

        load_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = null;
                try{
                     inputStream = getAssets().open("big_image1.jpg");
                    bigImageView.loadImage(inputStream);
                }catch(Exception e) {
                    e.printStackTrace();
                } finally {
                    if(inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}