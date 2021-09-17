package com.anatame.recylerview3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class AddEditOne extends AppCompatActivity {

    private Button btnOk, btnCancel;
    private EditText etPresName, etPresDate, etPresImageUrl;
    private TextView tvPresId;

    private List<President> presidentList;
    private MyApplication myApplication = (MyApplication) this.getApplication();
    private int id, nextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        presidentList = MyApplication.getPresidentList();

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);

        btnOk = findViewById(R.id.btn_ok);
        btnCancel = findViewById(R.id.btn_cancel);
        etPresName = findViewById(R.id.et_presidentName);
        etPresDate = findViewById(R.id.et_dateElection);
        etPresImageUrl = findViewById(R.id.et_pictureUrl);
        tvPresId = findViewById(R.id.tv_presidentIdNumber);

        President president = null  ;

        if(id >= 0) {
            for(President p: presidentList){
                if(p.getId() == id){
                    president = p;
                }
            }


            etPresName.setText(president.getName());
            etPresDate.setText(String.valueOf(president.getDateOfElection()));
            etPresImageUrl.setText(president.getImageUrl());
        }

        tvPresId.setText(String.valueOf(id));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(id >= 0){
                    //update
                    President updatedPresident = new President(nextId, etPresName.getText().toString(), Integer.parseInt(etPresDate.getText().toString()), etPresImageUrl.getText().toString());
                    presidentList.set(id, updatedPresident);

                } else{
                    //add new pres

                    //create President Object
                    nextId = MyApplication.getNextId();
                    President newPresident = new President(nextId, etPresName.getText().toString(), Integer.parseInt(etPresDate.getText().toString()), etPresImageUrl.getText().toString());

                    //add Object to the global list of presidents
                    presidentList.add(newPresident);
                    MyApplication.setNextId(nextId++);

                }

                //go back to main screen



                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}