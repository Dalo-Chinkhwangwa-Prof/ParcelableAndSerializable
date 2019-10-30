package com.example.myhomeworksolution;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_InJava extends AppCompatActivity {

    private Button startCameraButton;
    private EditText nameEdittext;
    private Button displayUser;
    private ImageView myCameraImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startCameraButton = findViewById(R.id.camera_button);
        myCameraImageView = findViewById(R.id.my_imageview);
        nameEdittext = findViewById(R.id.name_edittext);
        displayUser = findViewById(R.id.display_person_button);

        startCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 777);
            }
        });

        displayUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEdittext.getText().toString();
                HumanJava newHuman = new HumanJava(name, "Black/Brown");

                Intent humanIntent = new Intent(MainActivity_InJava.this, HumanActivity.class);
                humanIntent.putExtra("my_human_key", newHuman);
                startActivity(humanIntent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 777 && resultCode == RESULT_OK) {
            try {
                Bitmap fromCamera = (Bitmap) data.getExtras().get("data");
                myCameraImageView.setImageBitmap(fromCamera);

            } catch (Exception e) {
                //An error occurred..
            }
        }
    }
}
