package solutions.vladik.topovayaprilaga.Story_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import solutions.vladik.topovayaprilaga.R;

public class Content_2 extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content2);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Расцвет Асов");
        setSupportActionBar(toolbar);
        navView();

        String[] section = new String[]{"Да!", "Это", "Жёстка"
        };

        ListView list_content = (ListView) findViewById(R.id.list_content_2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, section);
        list_content.setAdapter(adapter);

        list_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(view.getContext(), Story_2.class);
                switch (position){
                    case 0:
                        //Передача инфы о выбранном разделе
                        intent.putExtra("number", "0");
                        startActivity(intent);
                        break;
                    case 1:
                        //Передача инфы о выбранном разделе
                        intent.putExtra("number", "1");
                        startActivity(intent);
                        break;
                }

            }
        });
    }

    public void navView(){
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                //.withAccountHeader(headerResult)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withSliderBackgroundColor(Color.DKGRAY)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName("Раздел 1")
                                .withTextColor(Color.WHITE)
                                .withSelectedTextColor(Color.WHITE)
                                .withSelectedColor(getResources().getColor(R.color.selectedNaw))
                                .withIcon(getResources().getDrawable(R.drawable.library_music))
                                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                    @Override
                                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                                        return false;
                                    }
                                }),
                        new PrimaryDrawerItem()
                                .withName("Раздел 2")
                                .withTextColor(Color.WHITE)
                                .withSelectedTextColor(Color.WHITE)
                                .withSelectedColor(getResources().getColor(R.color.selectedNaw))
                                .withIcon(getResources().getDrawable(R.drawable.library_music)),
                        new PrimaryDrawerItem()
                                .withName("Раздел 3")
                                .withTextColor(Color.WHITE)
                                .withSelectedTextColor(Color.WHITE)
                                .withSelectedColor(getResources().getColor(R.color.selectedNaw))
                                .withIcon(getResources().getDrawable(R.drawable.library_music)),
                        new DividerDrawerItem(),

                        new PrimaryDrawerItem()
                                .withName("Google Drive")
                                .withTextColor(Color.WHITE)
                                .withSelectedTextColor(Color.WHITE)
                                .withSelectedColor(getResources().getColor(R.color.selectedNaw))
                                .withIcon(getResources().getDrawable(R.drawable.library_music)),
                        new DividerDrawerItem(),

                        new PrimaryDrawerItem()
                                .withName("Version")
                                .withTextColor(Color.WHITE)
                                .withSelectedTextColor(Color.WHITE)
                                .withSelectedColor(getResources().getColor(R.color.selectedNaw))
                                .withIcon(getResources().getDrawable(R.drawable.library_music)),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Раздел 10: ").withSelectable(false).withTextColor(Color.WHITE),
                        new PrimaryDrawerItem()
                                .withName("Подраздел 1.pdf")
                                .withTextColor(Color.WHITE)
                                .withSelectedTextColor(Color.WHITE)
                                .withSelectedColor(getResources().getColor(R.color.selectedNaw))
                                .withIcon(getResources().getDrawable(R.drawable.library_music)),
                        new PrimaryDrawerItem()
                                .withName("Подраздел 2.png")
                                .withTextColor(Color.WHITE)
                                .withSelectedTextColor(Color.WHITE)
                                .withSelectedColor(getResources().getColor(R.color.selectedNaw))
                                .withIcon(getResources().getDrawable(R.drawable.library_music))
                )
                .build();
    }
}
