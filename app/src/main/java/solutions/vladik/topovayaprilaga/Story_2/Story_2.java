package solutions.vladik.topovayaprilaga.Story_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import solutions.vladik.topovayaprilaga.R;
import solutions.vladik.topovayaprilaga.ViewPagerAdapter;

public class Story_2 extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("KACHESTVO");
        setSupportActionBar(toolbar);
        setupNavView();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Получение выбранного раздела из содержания
        Intent intent = getIntent();
        String et = intent.getStringExtra("number");
        int i = Integer.parseInt(et.toString());
        Log.d("qweqwe", intent.getStringExtra("number"));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_2);
        setupViewPager(viewPager);
        //Выставление раздела в соответствии с выбранным в содержании
        viewPager.setCurrentItem(i);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void setupNavView(){
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
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_2_2(), "Качество");
        /*adapter.addFragment(new SecondFragment(), "Страница");
        adapter.addFragment(new Fragment_3(), "Уверенность");
        adapter.addFragment(new Fragment_4(), null);
        adapter.addFragment(new Fragment_5(), null);
        adapter.addFragment(new Fragment_6(), null);
        adapter.addFragment(new Fragment_7(), null);
        adapter.addFragment(new Fragment_8(), null);
        adapter.addFragment(new Fragment_9(), null);
        adapter.addFragment(new Fragment_10(), null);
        adapter.addFragment(new Fragment_11(), null);
        adapter.addFragment(new Fragment_12(), null);*/
        viewPager.setAdapter(adapter);
    }
}
