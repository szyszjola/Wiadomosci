package pl.iteger.fragmenty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;


public class MainActivity extends FragmentActivity implements OnNewsItemClickListener{

    private NewDetailsActivity.Runner detailsActivityRunner = new NewDetailsActivity.Runner();
    private NewsListFragment newsListFragment;
    private View frameLayoutWithDetails;
    public final static String TRANSAKCJA_1 = "transakcja_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayoutWithDetails = findViewById(R.id.fragment_containerDetails);
            newsListFragment = new NewsListFragment();
            switchMainFragment(newsListFragment,R.id.fragment_container ,TRANSAKCJA_1);
        //tranzakcja na fragmentach
      //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, newsListFragment).commit();


    }

    @Override
    public void OnNewsItemClick(Wiadomosci wiadomosci) {
 //   detailsActivityRunner.startActivity(this, wiadomosci);
        NewsDetailsFragment detailsFragment = new NewsDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DETAILS_NEWS", wiadomosci);
        detailsFragment.setArguments(bundle);
        switchMainFragment(detailsFragment, R.id.fragment_containerDetails);

    }

    private  void switchMainFragment(Fragment fragment, int ResId )
    {
        switchMainFragment(fragment, ResId ,null);
    }

    private void switchMainFragment(Fragment fragment, int ResId,String transactionName )
    {
        if(ResId == R.id.fragment_containerDetails)
            frameLayoutWithDetails.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().replace(ResId, fragment).addToBackStack(transactionName).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        frameLayoutWithDetails.setVisibility(View.GONE);
    }
}



