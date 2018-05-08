package com.androidtutz.anushka.memberapp.ui.main_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidtutz.anushka.memberapp.MemberApplication;
import com.androidtutz.anushka.memberapp.model.member_model.MemberDataManager;
import com.androidtutz.anushka.memberapp.R;
import com.androidtutz.anushka.memberapp.ui.json_api_activity.JsonApiActivity;

import javax.inject.Inject;

//For dagger focus on type of dependency
public class MainActivity extends AppCompatActivity {
    //inject the type
    @Inject
    MemberDataManager memberDataManager;

    private EditText memberId;
    private Button submitButton, mButtonRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dagger set up here
        /*
        static call to application
        Application.getApplication().getComponent().inject(this)
        this is the method call from the component class and this is for the mainactivity
        which we are currently on
         */
        MemberApplication.getMemberApplication().getMainActivityComponent().inject(this);

        memberId = findViewById(R.id.etMemberId);
        submitButton = findViewById(R.id.btnSubmit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((memberId.getText().toString().equals("")))
                {
                    Toast.makeText(getApplicationContext(), "Member ID is empty", Toast.LENGTH_SHORT).show();
                }else{

                    String input=memberId.getText().toString();
                    //String result=new MemberDataManager().checkMemberStatus(input);
                    //Dagger injection used to reference method
                    String result=memberDataManager.checkMemberStatus(input);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonRepos = findViewById(R.id.btnJsonActivity);
        mButtonRepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, JsonApiActivity.class);
                startActivity(i);
            }
        });
    }
}
