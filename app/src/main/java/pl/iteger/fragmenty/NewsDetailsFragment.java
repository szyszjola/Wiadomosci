package pl.iteger.fragmenty;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.iteger.fragmenty.widgets.NewsDescriptionWidget;

/**
 * Created by jolanta.szyszkiewicz on 2017.12.11.
 */

public class NewsDetailsFragment extends Fragment{

//    private TextView tytul, tresc;
    private NewsDescriptionWidget newsDescriptionWidget;
    Wiadomosci wiadomosci;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_details, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        tytul = view.findViewById(R.id.detailsTytul);
//        tresc = view.findViewById(R.id.detailsTresc);
        newsDescriptionWidget =view.findViewById(R.id.news_widget);


        Bundle bundle = getArguments();

        if (bundle == null || !bundle.containsKey("DETAILS_NEWS")) {
            throw new RuntimeException("Nie przekazałeś obiektu news");
        }

        wiadomosci = bundle.getParcelable("DETAILS_NEWS");
        newsDescriptionWidget.setWiadomosci(wiadomosci);
//        tytul.setText(wiadomosci.getTytul());
//        tresc.setText(wiadomosci.getTresc());

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack(MainActivity.TRANSAKCJA_1, 0);
            }
        });

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsDetailsFragment newsDetailsFragment = new NewsDetailsFragment();
                Bundle arguments = new Bundle();
                wiadomosci.setTresc("To jest bardzo ważne");
                wiadomosci.setTytul("Kwik");
                arguments.putParcelable("DETAILS_NEWS",wiadomosci);
                newsDetailsFragment.setArguments(arguments);
                getFragmentManager().beginTransaction().replace(R.id.fragment_containerDetails, newsDetailsFragment).addToBackStack(null).commit();
            }
        });
    }
}
