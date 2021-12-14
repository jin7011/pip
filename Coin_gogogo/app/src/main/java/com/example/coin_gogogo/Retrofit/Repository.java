package com.example.coin_gogogo.Retrofit;

import com.example.coin_gogogo.data.Ticker_Response;
import com.example.coin_gogogo.data.Transaction_List_Response;

import io.reactivex.rxjava3.core.Single;

public class Repository {

    private static Repository instance;

    private Repository() {
    }

    // 싱클턴으로 사용
    public static Repository getInstance() {
        if (instance == null)
            instance = new Repository();
        return instance;
    }

    public io.reactivex.rxjava3.core.Single<Ticker_Response> get_Ticker_Single(){
        return RetrofitFactory
                .createRetrofit("https://api.bithumb.com/")
                .create(ExampleService.class)
                .TICKER_SINGLE();
    }

    public Single<Transaction_List_Response> get_Transaction_Single(String path, int count){
        return RetrofitFactory
                .createRetrofit("https://api.bithumb.com/")
                .create(ExampleService.class)
                .TRANSACTION_LIST_SINGLE(path,count);
    }

}
