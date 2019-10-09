package test.vardaan.camera2api;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button openCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openCameraButton = findViewById(R.id.openCameraButton);

        openCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String docID = "Aadhar_Front";

                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                intent.putExtra("docID", docID);
                startActivityForResult(intent, 12);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12 && resultCode == 2) {

            String path = data.getStringExtra("Path");
            Log.e("Path in main", path);

            Toast.makeText(this, "Saved image to " + path, Toast.LENGTH_SHORT).show();

            // ToDo: Save image to firebase storage here
        }
    }
}
