package com.homework1_3.androiddeynenko221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputNote;
    private Button btnSaveNote;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {
        inputNote = findViewById(R.id.inputNote);
        btnSaveNote = findViewById(R.id.btnSaveNote);
        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                String noteTxt = inputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                Toast.makeText(MainActivity.this, getString(R.string.toast_save),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getDateFromSharedPref(){
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        inputNote.setText(noteTxt);
    }
}