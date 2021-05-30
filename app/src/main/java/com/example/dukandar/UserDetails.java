package com.example.dukandar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UserDetails extends AppCompatActivity {
    private Button button7;
    EditText name,address,mobNo;
    FirebaseDatabase rootNode;
    DatabaseReference reference,dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

       name =(EditText) findViewById(R.id.name);
       address = (EditText) findViewById(R.id.address);
       mobNo = (EditText)findViewById(R.id.mobNo);
       button7=(Button) findViewById(R.id.button7);

      reference = FirebaseDatabase.getInstance().getReference().child("UserDetails");

       button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                 dbref=reference.child("UserDetails");
                final String uniqueKey=dbref.push().getKey();

                UserHelperClass helperClass=new UserHelperClass( name.getText().toString() , mobNo.getText().toString(),address.getText().toString(),uniqueKey);
                dbref.child(uniqueKey).setValue(helperClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(UserDetails.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UserDetails.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });


                Toast toast = Toast.makeText(getApplicationContext(), "Simple Toast In Android", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
              toast.show(); // display the Toast
            }

        });

    }
}