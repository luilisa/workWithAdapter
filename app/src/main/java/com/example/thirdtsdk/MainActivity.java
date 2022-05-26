package com.example.thirdtsdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        countriesList = findViewById(R.id.countriesList);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
        countriesList.setAdapter(stateAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

        states.add(new State ("United kingdom", "London", R.drawable.uk));
        states.add(new State ("Germany", "Berlin", R.drawable.german));
        states.add(new State ("Russian Federation", "Moscow", R.drawable.russia));
        states.add(new State ("Mexico", "Mexico", R.drawable.meksika));
        states.add(new State ("Kazakhstan", "Nur-Sultan", R.drawable.kz));
    }
}