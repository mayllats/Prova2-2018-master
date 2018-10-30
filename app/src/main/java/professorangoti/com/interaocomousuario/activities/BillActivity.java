package professorangoti.com.interaocomousuario.activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import professorangoti.com.interaocomousuario.R;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillActivity extends AppCompatActivity {

    private String pedido;
    private List<Bill> bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        pedido = intent.getStringExtra("@id/total");
        Log.i("pedido", "Pedido: " + pedido);

        retrofit2.Call<List<Bill>> call = ApiInterface.getValor();

        call.enqueue(new Callback<List<Bill>>() {

            @Override
            public void onResponse(retrofit2.Call<List<Bill>> call, Response<List<Bill>> response) {
                bill = response.body();
                Log.i("Valor:", bill.toString());

                TextView total = findViewById(R.id.total);
                total.setText(bill.getValor());

            }

            @Override
            public void onFailure(Call<List<Bill>> call, Throwable t) {
                Log.e("Erro", "Erro ao recuperar preços", t);
            }
        });

    }
}
