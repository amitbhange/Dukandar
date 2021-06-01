package com.example.dukandar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UserDetails extends AppCompatActivity {
    private Button button7;
    private EditText name, address, mobNo;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        name = findViewById(R.id.name);
        address =findViewById(R.id.address);
        mobNo =findViewById(R.id.mobNo);
        button7 =findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference= rootNode.getReference("orders");

                String name1=name.getText().toString();
                String MobNo1 = mobNo.getEditableText().toString();
                String address1=address.getEditableText().toString();

                UserHelperClass hp=new UserHelperClass(name1,MobNo1,address1);

                reference.push().setValue(hp);

            }
        });


    }
}
