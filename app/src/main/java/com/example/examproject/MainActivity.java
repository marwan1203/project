package com.example.examproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private TextView siteName,enterView,siteType;
private Button submit,takePic;
private Spinner storeType;
private EditText review;
private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siteName = findViewById(R.id.siteName);
        enterView = findViewById(R.id.enterView);
        siteType = findViewById(R.id.siteType);
        submit = findViewById(R.id.submit);
        takePic = findViewById(R.id.takePic);
        storeType = findViewById(R.id.storeType);
        review = findViewById(R.id.review);
        img = findViewById(R.id.image);
        siteName.setText("site name");
        enterView.setText("enter view");
        siteType.setText("site type");
        review.setHint("review");
        String[] items = {
                "Clothing Store", "Food Court", "Cafe", "Supermarket", "Electronics Store",
                "Shoe Store", "Bookstore", "Pharmacy", "Accessories Store", "Sports Store"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        storeType.setAdapter(adapter);
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(!siteName.getText().toString().isEmpty()&&!enterView.getText().toString().isEmpty()&&!siteType.getText().toString().isEmpty()){
                sendData();
            }
            }

        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==RESULT_OK){
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            img.setImageBitmap(bitmap);
        }
}
    public void sendData(){
        Intent page2 = new Intent(this, page2.class);
        String view = enterView.getText().toString();
        String Type = storeType.getSelectedItem().toString();
        page2.putExtra("review",view);
        page2.putExtra("storetype",Type);
        startActivity(page2);
    }















}
