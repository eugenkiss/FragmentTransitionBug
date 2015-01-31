package exterminator.fragmenttransitionbug;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new Fragment())
                .addToBackStack("dummy")
                .commit();
        PlaceholderFragment f;
        f = new PlaceholderFragment();
        f.setEnterTransition(new Slide(Gravity.RIGHT));
        f.setReturnTransition(new Slide(Gravity.RIGHT));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f)
                .addToBackStack(null)
                .commit();
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_main, container, false);
        }
    }
}
