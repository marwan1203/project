package com.example.examproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class page2 extends AppCompatActivity {
private TextView title,reviewText,review,typeText,type;
private ImageView img;
private Button back;
private String reviewString,typeExtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        title=findViewById(R.id.title);
        reviewText=findViewById(R.id.reviewtext);
        review=findViewById(R.id.review);
        typeText=findViewById(R.id.storeType);
        type=findViewById(R.id.type);
        img=findViewById(R.id.img);
        back=findViewById(R.id.back);
        reviewString=getIntent().getStringExtra("REVIEW");
        typeExtra=getIntent().getStringExtra("STORETYPE");
        review.setText(reviewString);
        type.setText(typeExtra);
        Bitmap bitmap = getIntent().getParcelableExtra("img");
        img.setImageBitmap(bitmap);
        title.setText("Visit details");
        reviewText.setText("Review");
        typeText.setText("Store Type");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(page2.this,MainActivity.class);
                startActivity(intent);

            }
            });
        }
}

