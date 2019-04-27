package com.example.a4001_healthhappy;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayTodo extends AppCompatActivity {

    private static final String TAG = DisplayTodo.class.getSimpleName();
    RecyclerView rvTodo;
    DatabaseReference databaseTodo;
    List<Todo> todos;
    SwipeRefreshLayout swpRfrsh;
    CardView cvTodo;
    Button btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_todo);

        DisplayTodo.this.setTitle("Display Todo");

        swpRfrsh = (SwipeRefreshLayout) findViewById(R.id.rfrshLayout);
        rvTodo = (RecyclerView) findViewById(R.id.ivTodo);
        databaseTodo = FirebaseDatabase.getInstance().getReference("TODO");
        todos = new ArrayList<>();
        cvTodo = (CardView) findViewById(R.id.cardTodo);
        btnDel = (Button) findViewById(R.id.delTodo);

    }
}

