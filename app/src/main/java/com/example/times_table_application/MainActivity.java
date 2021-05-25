package com.example.times_table_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ListView listView;

    public void generatetimestable(int timestable){

        ArrayList<String>myList=new ArrayList<String>();

        for(int i =1; i<= 10; i++){
            myList.add(Integer.toString(i* timestable));

        }
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myList);

        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=(SeekBar)findViewById(R.id.seekb);
        listView= (ListView)findViewById(R.id.myl);
        seekBar.setMax(100);
        seekBar.setProgress(50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timestable;

                if(progress<min){
                    timestable = min;
                    seekBar.setProgress(min);
                }
                else{
                    timestable=progress;
                }

                generatetimestable(timestable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generatetimestable(50);


    }
}