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

/**
 * @author Shaked Dromi
 * @version beta
 * @since 18/10/19
 * This activity is the main activity. Here you can choose one continent out of 5 options. Then you click on the "next" button.
 * The last continent you press on, will be showed as a toast.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView LV;
    String[] str={"Africa","Europe","Asia","South America","North America"};
    int x=21;

    /**
     * LV is the Java List View widget.
     * The array str contains the 5 continents' names.
     * x is an index of the chosen continent.
     */

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

    /**
     * When a continent is chosen, this function will start.
     * @param position - the index of the chosen continent from the List View.
     * @return the function shows (prints) the last continent's name that was chosen as a toast.
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, ""+str[position], Toast.LENGTH_SHORT).show();
        x=position;
    }

    /**
     * when the "next" button is clicked, this function will start.
     * if a continent is chosen, we move to the second activity. The continent's index is in str.
     * else- we stay on this activity. a toast that says "choose a continent please" comes.
     * blah blah blah
     */

    public void btn(View view) {
        if (x!= 21) {
            Intent si = new Intent(this, Main2Activity.class);
            si.putExtra("position", x);
            startActivity(si);
        }
        else{
            Toast.makeText(this, "choose a continent please", Toast.LENGTH_SHORT).show();
        }
    }

}