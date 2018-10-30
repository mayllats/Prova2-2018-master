package professorangoti.com.interaocomousuario.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import professorangoti.com.interaocomousuario.R;
import retrofit2.Callback;
import retrofit2.Response;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private String mensagem;
    private BillActivity valor;
    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    String TAG = "este";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerView = findViewById(R.id.recyclerView);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        retrofit2.Call<BillActivity> call = apiInterface.getValor();

        call.enqueue(new Callback<BillActivity>() {
            @Override
            public void onResponse(retrofit2.Call<BillActivity> call, Response<BillActivity> response) {

                if(!response.isSuccessful()) {
                    Log.i(TAG, "Entrou aqui! - resposta não foi bem sucedida");
                }

                valor = response.body();

            }

            @Override
            public void onFailure(retrofit2.Call<BillActivity> call, Throwable t) {
                Log.i(TAG, t.getMessage() + t.getLocalizedMessage() + t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        mensagem = getString(R.string.donut_order_message);
        displayToast(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        mensagem = getString(R.string.ice_cream_order_message);
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        mensagem = getString(R.string.froyo_order_message);
        displayToast(getString(R.string.froyo_order_message));
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("mensagem", mensagem);
        startActivity(intent);
    }

}
