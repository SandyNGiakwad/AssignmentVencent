package com.sng.assignmentvencent;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.sng.assignmentvencent.adapter.AdapterUsres;
import com.sng.assignmentvencent.model.Users;
import com.sng.assignmentvencent.viewModel.UserViewModel;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_users;
    ProgressDialog progressDialog;
    AdapterUsres adapterUsres;
    ArrayList<Users> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users=new ArrayList<>();
        adapterUsres = new AdapterUsres(this, users);
        rv_users=findViewById(R.id.rv_users);
        rv_users.setLayoutManager(new LinearLayoutManager(this));
        rv_users.setAdapter(adapterUsres);
        rv_users.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Wait");
        progressDialog.setMessage("Loading users data");
        rv_users = (RecyclerView) findViewById(R.id.rv_users);
        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUsers().observe(this, new Observer<ArrayList<Users>>() {
            @Override
            public void onChanged(ArrayList<Users> users) {
                adapterUsres.updateUsers(users);
            }
        });
        userViewModel.getLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean==true)
                    progressDialog.show();
                else
                    progressDialog.dismiss();
            }
        });
    }
}