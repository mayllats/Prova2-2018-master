package professorangoti.com.interaocomousuario.activities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    /* -- Passo 1 : Esta é a classe de instância do retrofit, onde é passado o URL e é construído
    de fato o objeto retrofit que será utilizado para as funções de post e get
    as bibliotecas retrofit e gson devem estar presents no build.gradle
     */

    public static final String BASE_URL = "http://provaddm2018.atwebpages.com/precos";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

