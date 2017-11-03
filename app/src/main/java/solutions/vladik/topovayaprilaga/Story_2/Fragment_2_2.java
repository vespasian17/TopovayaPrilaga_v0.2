package solutions.vladik.topovayaprilaga.Story_2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solutions.vladik.topovayaprilaga.R;

/**
 * Created by tim on 3.11.17.
 */

public class Fragment_2_2 extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.level_2_page_01, container, false);
    }
}
