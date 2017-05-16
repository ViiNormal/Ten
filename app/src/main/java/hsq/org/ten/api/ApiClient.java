package hsq.org.ten.api;

/**
 * Created by 黄上清 on 2017/5/16.
 */

public class ApiClient {
    public static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpParams.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
