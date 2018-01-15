package pl.iteger.fragmenty.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pl.iteger.fragmenty.R;
import pl.iteger.fragmenty.Wiadomosci;

/**
 * Created by jolanta.szyszkiewicz on 2017.12.12.
 */

public class NewsDescriptionWidget extends RelativeLayout {

    private TextView tresc;
    private TextView tytul;

    public NewsDescriptionWidget(Context context) {
        super(context);
        initWidget();
    }

    public NewsDescriptionWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidget();
    }

    public NewsDescriptionWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWidget();
    }

    private void initWidget()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_news_description, this);

        tresc = findViewById(R.id.tresc);
        tytul = findViewById(R.id.tytul);
    }

    public void setWiadomosci(Wiadomosci wiadomosci)
    {
        tresc.setText(wiadomosci.getTresc());
        tytul.setText(wiadomosci.getTytul());
    }
}
