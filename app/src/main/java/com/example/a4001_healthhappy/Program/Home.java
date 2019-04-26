package com.example.a4001_healthhappy.Program;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.a4001_healthhappy.Login;
import com.example.a4001_healthhappy.R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Home extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    FirebaseUser user;
    GoogleSignInClient mGoogleSignInClient;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInAccount gAccount;
    private static final String TAG = "";
    FloatingActionButton fabCall;


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Button btn_logout = (Button) findViewById(R.id.signout);
        mAuth = FirebaseAuth.getInstance();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(Home.this, Login.class));
                }
            }
        };
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mAuth.getCurrentUser().equals(mGoogleApiClient)){
//                    // Google sign out
////                    Auth.GoogleSignInApi.signOut(mGoogleApiClient);
//                    mGoogleSignInClient.signOut()
//                            .addOnCompleteListener(Home.this, new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//
//                                }
//                            });
//                }else{
//                    // Firebase sign out
//                    mAuth.getInstance().signOut();
//            }
//            }
//        });
        fabCall = (FloatingActionButton) findViewById(R.id.btnCall);
        fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeACall("08111198525");
            }
        });
    }

    public void listenerMenu(View view) {
        switch (view.getId()){
            case R.id.imgWorkout:
                Intent intent1 = new Intent(Home.this,HalamanWorkout.class);
                startActivity(intent1);
                break;
            case R.id.imgDiet:
                Intent intent2 = new Intent(Home.this,Home.class);
                startActivity(intent2);
                break;
            case R.id.imgTodo:
                Intent intent3 = new Intent(Home.this,Home.class);
                startActivity(intent3);
                break;
            case R.id.imgMaps:
                Intent intent4 = new Intent(Home.this,Home.class);
                startActivity(intent4);
                break;
        }
    }
    //method untuk implement menu pada activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu); // inflate atau memasukkan menu
        return super.onCreateOptionsMenu(menu);
    }

    //method untuk handling menu yang di klik dari daftar di menu yang di implement
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnLogout:
                mAuth.getInstance().signOut();
                startActivity(new Intent(Home.this, Login.class)); //panggil login activity
                finish();
                break;
//            case a:
//                startActivity(new Intent(Home.this, Home.class)); //panggil login activity
//                finish();
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void makeACall(final String phoneNumber){
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}


