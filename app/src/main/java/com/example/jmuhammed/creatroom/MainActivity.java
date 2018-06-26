package com.example.jmuhammed.creatroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText nameroom,passroom,idroom;
    private TextView DatabaseRoomIdTextView;
    private Button add ;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameroom = (EditText) findViewById(R.id.roomName);
        passroom = (EditText) findViewById(R.id.passroom);
        idroom = (EditText) findViewById(R.id.idroom);
        DatabaseRoomIdTextView = (TextView) findViewById(R.id.textDatabaseRoomId);
        add = (Button) findViewById(R.id.add);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mReference = firebaseDatabase.getReference();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRoom();
            }
        });


        idroom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lineIdDataRoom);
                linearLayout.setVisibility(View.VISIBLE);
                DatabaseRoomIdTextView.setText(idroom.getText());
                if (TextUtils.isEmpty(idroom.getText())){
                    linearLayout.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void addRoom(){
        String name , pass , id;
        name = nameroom.getText().toString();
        pass = passroom.getText().toString();
        id = idroom.getText().toString();

        ModuleCreatRoom moduleCreatRoom = new ModuleCreatRoom(id ,name , pass);

        mReference.child("rooms").child(id).setValue(moduleCreatRoom);
        mReference.child(id).child("members").child("Master").setValue(pass);
        mReference.child(id).child("mssg").setValue(" ");
    }
}
