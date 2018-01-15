package pl.iteger.fragmenty;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewDetailsActivity extends AppCompatActivity {  ///NIE UŻYWAMY JUŻ

    private TextView tytul, tresc;
    private Wiadomosci wiadomosci;
    public static final String EXTRA_NEWS = "extra_news";
    public static final String EXTRA_NEWS_ID = "extra_news_id";

    public static class Runner //ponieważ Runner już nie uzywa parametrów klasy details, możemy ją przenieś wyżej, tzn w oddzielny plik (ale pomijamy bo nie musimy)
    {
        public void startActivity(Context context, Wiadomosci wiadomosci)
        {
            Intent intent = new Intent(context, NewDetailsActivity.class); //podnieniamy NewsDetailsActivity.class na akcje którą napisaliśmy w manifeście
            intent.putExtra(EXTRA_NEWS_ID , wiadomosci.getId());
            intent.putExtra(EXTRA_NEWS, wiadomosci);

            context.startActivity(intent);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_new_details);
        Wiadomosci wiadomosci = getIntent().getParcelableExtra(EXTRA_NEWS);

        tytul = findViewById(R.id.tytul);
        tresc = findViewById(R.id.tresc);

        tytul.setText(wiadomosci.getTytul());
        tresc.setText(wiadomosci.getTresc());


    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
        super.onBackPressed();
    }
}
