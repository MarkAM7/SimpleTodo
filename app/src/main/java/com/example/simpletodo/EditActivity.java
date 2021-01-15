package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editTextItem;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTextItem = findViewById(R.id.editTextItem);
        buttonSave = findViewById(R.id.buttonSave);

        // Setting the title to this EditActivity
        getSupportActionBar().setTitle("Edit Item");

        editTextItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent which will contain the data
                Intent intent = new Intent();

                // Pass the data
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, editTextItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // Set the data of the intent
                setResult(RESULT_OK, intent);

                // Finish activity, close the screen and go back
                finish();
            }
        });
    }
}