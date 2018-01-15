package pl.iteger.fragmenty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by jolanta.szyszkiewicz on 2017.11.24.
 */

public class ResultProviderActivity extends Activity implements View.OnClickListener {  //nie używany!!!!

    private Button btn_tak, btn_nie;
    public static int RESULT_TAK = 0;
    public static int RESULT_NIE = 1;
    public static String EXTRA_WIADOMOSCI = "extra_wiadomosci";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_result);
        btn_tak = findViewById(R.id.tak);
        btn_nie = findViewById(R.id.nie);

        btn_tak.setOnClickListener(this);
        btn_nie.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int resultCode = 0; //teraz próbujemy przesłać więcej rzeczów
        String tytul;
        String tresc;

        if(view == btn_tak)
        {
           // setResult(RESULT_TAK);
            tytul = "TAK!";
            tresc = "Klikłeś tak!";
        }
        else
        {
            //setResult(RESULT_NIE);
            tytul = "NIE!";
            tresc = "Klikłeś nie!";
        }
        Wiadomosci wiadomosci = new Wiadomosci();
        wiadomosci.setId(0);
        wiadomosci.setTytul(tytul);
        wiadomosci.setTresc(tresc);

        Intent intent = new Intent();
        intent.putExtra(EXTRA_WIADOMOSCI, wiadomosci);
        setResult(resultCode , intent);
        finish();
    }
}
