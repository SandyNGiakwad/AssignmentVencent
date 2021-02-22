package com.sng.assignmentvencent.viewModel;

import com.sng.assignmentvencent.model.Users;
import com.sng.assignmentvencent.network.ApiInterface;
import com.sng.assignmentvencent.network.NetworkInstance;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel
{
    MutableLiveData<ArrayList<Users>> usersMutableLiveData;
    MutableLiveData<Boolean> isloading;

    public UserViewModel()
    {
        usersMutableLiveData=new MutableLiveData<>();
        isloading=new MutableLiveData<>();
        getUsersMutableLiveData();
    }
    public void getUsersMutableLiveData() {
        isloading.setValue(true);
        ApiInterface apiInterface= NetworkInstance.getInstance().create(ApiInterface.class);
        Call<ArrayList<Users>> call=apiInterface.getUsers();
        call.enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(Call<ArrayList<Users>> call, Response<ArrayList<Users>> response) {
                usersMutableLiveData.setValue(response.body());
                isloading.setValue(false);
            }

            @Override
            public void onFailure(Call<ArrayList<Users>> call, Throwable throwable) {
                isloading.setValue(false);
            }
        });
       /* ArrayList<Users> usersList=new ArrayList<>();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    try {
                        JSONArray jsonArray = new JSONArray(response.body().toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Users users = new Users();
                            users.setId(jsonObject.getString("id"));
                            users.setAvatar(jsonObject.getString("avatar"));
                            users.setEmail(jsonObject.getString("email"));
                            users.setName(jsonObject.getString("name"));
                            usersList.add(users);
                        }
                        usersMutableLiveData.setValue(usersList);
                        isloading.setValue(false);
                    } catch (JSONException e) {
                        isloading.setValue(false);
                        usersMutableLiveData.setValue(null);
                        e.printStackTrace();
                    }
                }
                }

                @Override
                public void onFailure (Call call, Throwable throwable){
                    isloading.setValue(false);
                    usersMutableLiveData.setValue(null);
                }

        });*/

    }

    public LiveData<ArrayList<Users>> getUsers()
    {
        return usersMutableLiveData;
    }
    public LiveData<Boolean> getLoading()
    {
        return isloading;
    }
}
