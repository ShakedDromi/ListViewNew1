package com.example.shakeddromi.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView LV;
    String[] str={"Africa","Europe","Asia","South America","North America"};
    int x=21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LV=(ListView) findViewById(R.id.LV);
        LV.setOnItemClickListener(this);
        LV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, str);
        LV.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, ""+str[position], Toast.LENGTH_SHORT).show();
        x=position;
    }

    public void btn(View view) {
        if (x!= 21) {
            Intent si = new Intent(this, Main2Activity.class);
            si.putExtra("position", x);
            startActivity(si);
        }
    }

}