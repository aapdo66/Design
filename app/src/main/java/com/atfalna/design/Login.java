package com.atfalna.design;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.atfalna.design.Adapter.SimpleRecyclesAdapter;


public class Login extends AppCompatActivity {

    Button btnFallDown,btnSlideFromBottom;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnFallDown = (Button) findViewById(R.id.btnFallDown);
        btnSlideFromBottom = (Button) findViewById(R.id.btnBottom);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnFallDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAnimation(recyclerView,0);
            }
        });
        btnSlideFromBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAnimation(recyclerView,1);
            }
        });

    }

    private void runAnimation(RecyclerView recyclerView, int type)
    {
        Context context = recyclerView.getContext();
        LayoutAnimationController controller=null;

        if (type == 0) // Fall Down animation
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_fall_down);
        else if (type == 1) // Slide from bottom
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_bottom);

        SimpleRecyclesAdapter adater = new SimpleRecyclesAdapter();
        recyclerView.setAdapter(adater);

        // set animation
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
