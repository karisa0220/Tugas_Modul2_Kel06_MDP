package com.example.modul2_kel06;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AboutActivity extends AppCompatActivity {

    ListView listView;
    String[] mNama = {"Karisa Zihni Lutfiana", "Samuel Imanta Ginting", "Ghaly Wisnu Aryawira", "Muhamad Ikhsan Arya Wibowo"};
    String[] mNIM = {"21120119130077", "21120119120010", "21120119140139", "21120119140129"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mNama, mNIM);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(AboutActivity.this, "Anggota 1 Kelompok 06", Toast.LENGTH_SHORT).show();
                }
                if (position ==  1) {
                    Toast.makeText(AboutActivity.this, "Anggota 2 Kelompok 06", Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(AboutActivity.this, "Anggota 3 Kelompok 06", Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(AboutActivity.this, "Anggota 4 Kelompok 06", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rNama;
        String[] rNIM;

        MyAdapter (Context c, String nama[], String nim[]) {
            super(c, R.layout.row, R.id.textView1, nama);
            this.context = c;
            this.rNama = nama;
            this.rNIM = nim;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            myTitle.setText(rNama[position]);
            myDescription.setText(rNIM[position]);

            return row;
        }
    }
}