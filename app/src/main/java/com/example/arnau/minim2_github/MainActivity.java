package com.example.arnau.minim2_github;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void getFollowers(View view){
        final EditText et = (EditText)findViewById(R.id.text1);
        API.getInstance().api.getUser(et.getText().toString()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Trobat", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Followers.class);
                    User u = (User) response.body();
                    i.putExtra("user", u.getLogin());
                    i.putExtra("avatarURL",u.getAvatar_url());
                    i.putExtra("followers",u.getFollowers());
                    i.putExtra("following",u.getFollowing());
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No trobat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Problema connectant",Toast.LENGTH_SHORT).show();
            }
        });
    }




}
