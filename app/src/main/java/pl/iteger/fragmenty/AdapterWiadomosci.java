package pl.iteger.fragmenty;
//1:11
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import pl.iteger.fragmenty.widgets.NewsDescriptionWidget;

/**
 * Created by jolanta.szyszkiewicz on 2017.11.23.
 */

public class AdapterWiadomosci extends ArrayAdapter<Wiadomosci> {

    private final LayoutInflater mInflater;

    public AdapterWiadomosci(@NonNull Context context, int resource) {
        super(context, resource);
        mInflater = LayoutInflater.from(getContext());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder vHolder;
        //jak tworzymy nowe obiekty nasz convert view jest nullem, więc musimy sprawdzić czy aby na pewno nim jest
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_news, null); //root - parent, tu, nie ma;

            //wyszukiwanie elementow po id jest dosyć kosztowne (findViewbyid)
            //więc należy zastosowac tak zwanego View Holder
            vHolder = new ViewHolder();
           vHolder.newsDescriptionWidget = (NewsDescriptionWidget)convertView;

            convertView.setTag(vHolder); //możemy przez setTag wrzucić wsio
        } else {
            vHolder = (ViewHolder) convertView.getTag(); //jeśli już convertView istniał, to znaczy że wcześniej zostal utworzony Holder, więc go pobieramy
        }
        Wiadomosci wiadomosci = getItem(position);
        vHolder.newsDescriptionWidget.setWiadomosci(wiadomosci);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
       return getItem(position).getId();
    }

    private static class ViewHolder { // ta klasa będzie trzymała referencje do naszych widoków
        public NewsDescriptionWidget newsDescriptionWidget;

    }
}
