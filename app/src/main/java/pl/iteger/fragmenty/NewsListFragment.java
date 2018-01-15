package pl.iteger.fragmenty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by jolanta.szyszkiewicz on 2017.12.06.
 */

public class NewsListFragment extends ListFragment {

    private String conferenceName;
    public static final String CONFERENCE_NAME = "conference_name";
    private AdapterWiadomosci adapter;
    //    private NewDetailsActivity.Runner detailsActivityRunner = new NewDetailsActivity.Runner();
    private OnNewsItemClickListener onNewsItemClickListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey(CONFERENCE_NAME)) {
            Toast.makeText(getActivity().getApplicationContext(), savedInstanceState.getString(CONFERENCE_NAME), Toast.LENGTH_LONG).show();
        }
        conferenceName = "Kwik kwik kwik 2018";
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CONFERENCE_NAME, conferenceName);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new AdapterWiadomosci(getActivity(), R.layout.widget_news_description);
        setListAdapter(adapter);
        inicjalizujListe();
    }

    private void inicjalizujListe() {
        Wiadomosci wiadomosci;

        for (int i = 0; i < 100; i++) {
            wiadomosci = new Wiadomosci();
            wiadomosci.setTytul("Tytul: " + i);
            wiadomosci.setTresc("To jest treść wiadomości o tytule nr " + i);
            wiadomosci.setId(i);
            adapter.add(wiadomosci);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (onNewsItemClickListener != null) {
            onNewsItemClickListener.OnNewsItemClick(adapter.getItem(position));
        }
//detailsActivityRunner.startActivity(getActivity(), adapter.getItem(position)); //zastępujemy interfejsem, bo lepiej takie cuda robić z activity nie z fragmentu
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!(getActivity() instanceof OnNewsItemClickListener)) {
            throw new RuntimeException("Twoja activity nie implementuje OnNewsItemClickListenera");
        }
        onNewsItemClickListener = (OnNewsItemClickListener) getActivity();

    }
}
