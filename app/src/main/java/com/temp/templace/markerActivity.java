package com.temp.templace;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class markerActivity extends Activity {
    static  final  String FIREBASE_URL ="https://torrid-fire-287.firebaseio.com/";
    Firebase Firebaseref;
    EditText address;
    EditText days;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_marker);
      Firebase.setAndroidContext(this);
        Firebaseref= new Firebase(FIREBASE_URL);
      address= (EditText) findViewById(R.id.et_address);
      days= (EditText) findViewById(R.id.et_days);
      add= (Button) findViewById(R.id.add);

      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String v_address= address.getText().toString();
              String v_days= days.getText().toString();

              if(v_address.equals("")|| v_days.equals("")){
                  Toast.makeText(markerActivity.this, "please fill all the required fields" , Toast.LENGTH_SHORT).show();

              }else
              {
                String pass= "true";
                  AddMarker add= new AddMarker(v_address , v_days );
                  Firebaseref.push().setValue(add);
                  Toast.makeText(markerActivity.this, "done", Toast.LENGTH_SHORT).show();
                  address.setText("");
                  days.setText("");
//
//                  Bundle bundle = new Bundle();
//                  bundle.putString("KEY", pass.toString());
//
//                  mMapFragment fragobj = new mMapFragment();
//                  fragobj.setArguments(bundle);



                  finish();
        //<activity android:name=".markerActivity" android:noHistory="true" ... />  to not keep it in activity stack

              }

          }
      });


    }
}
