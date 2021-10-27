package com.example.modul2_kel06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNama, tvEmail, tvTwitter, tvFacebook;
    private ImageView ivPhoto;
    private Button btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvTwitter = findViewById(R.id.tv_twitter);
        tvFacebook = findViewById(R.id.tv_facebook);
        btnAbout = findViewById(R.id.btn_about);
        ivPhoto = findViewById(R.id.iv_photo);

        if (getIntent().hasExtra("first_name")) {

            String first_name = getIntent().getStringExtra("first_name");
            String last_name = getIntent().getStringExtra("last_name");
            String name = first_name + " " + last_name;
            String twitter = "@" + first_name.toLowerCase() + last_name.toLowerCase();
            String facebook = "facebook.com/" + first_name.toLowerCase() + last_name.toLowerCase();
            String email = getIntent().getStringExtra("email");
            String photo = getIntent().getStringExtra("photo");
            tvNama.setText(name);
            tvTwitter.setText(twitter);
            tvFacebook.setText(facebook);
            tvEmail.setText(email);

            Glide.with(this)
                    .asBitmap()
                    .load(photo)
                    .into(ivPhoto);
        }
        credit();
    }

    private void credit() {
        btnAbout.setOnClickListener(V -> {
            Intent about = new Intent(this, AboutActivity.class);
            startActivity(about);
            finish();}
        );
    }
}