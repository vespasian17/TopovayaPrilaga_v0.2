package solutions.vladik.topovayaprilaga;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import solutions.vladik.topovayaprilaga.Story_1.Content;
import solutions.vladik.topovayaprilaga.Story_2.Content_2;

public class MainActivity extends AppCompatActivity {
    String ATTRIBUTE_NAME_TEXT = "text";
    String ATTRIBUTE_NAME_TEXT2 = "texts";
    String TAG_IMAGE = "image";

    Toolbar toolbar;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    ArrayList<String> img_id = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Скандинавские Боги");
        setSupportActionBar(toolbar);
        navView();
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        names.add("Часть 1"); names.add("Часть 2"); names.add("Часть 3"); names.add("Часть 4");
        description.add("Зарождение жизни");
        description.add("Расцвет асов");
        description.add("В разработке");
        description.add("В разработке");
        img_id.add("drawable/f.jpg");
        img_id.add("drawable/u.jpg");
        img_id.add("drawable/t.jpg");
        img_id.add("drawable/a.jpg");


        ListView lv = (ListView) findViewById(R.id.lv);

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(names.size());
        Map<String, Object> model;
        for (int i = 0; i < names.size(); i++) {
            model = new HashMap<String, Object>();
            model.put(ATTRIBUTE_NAME_TEXT, names.get(i));
            model.put(ATTRIBUTE_NAME_TEXT2, " " + description.get(i));
            //model.put(TAG_IMAGE, img_id.get(i));

            data.add(model);
        }

        MyListAdapter adapter =
                new MyListAdapter(
                        this,
                        data,
                        R.layout.item,
                        new String[]{ATTRIBUTE_NAME_TEXT,ATTRIBUTE_NAME_TEXT2},
                        new int[]{R.id.tv1,R.id.tv2});
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, Content.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, Content_2.class);
                        startActivity(intent2);
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
