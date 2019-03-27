package cn.tiptopgame.tcall.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import java.util.ArrayList;

import cn.tiptopgame.tcall.app.Adapter.FragmentAdapter;
import cn.tiptopgame.tcall.app.Fragment.FriendlyFragment;
import cn.tiptopgame.tcall.app.Fragment.UniteFragment;

public class MainActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private ViewPager vp;
    private RadioGroup rg;
    private ArrayList<Fragment> fragmentlist;
    private FriendlyFragment friendlyFragment;
    private UniteFragment uniteFragment;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        fragmentlist=new ArrayList<>();
        friendlyFragment = new FriendlyFragment();
        uniteFragment = new UniteFragment();
        fragmentlist.add(friendlyFragment);
        fragmentlist.add(uniteFragment);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentlist);
        vp.setAdapter(fragmentAdapter);
        vp.addOnPageChangeListener(this);
        rg.setOnCheckedChangeListener(this);
        vp.setCurrentItem(0);
        rg.check(R.id.button01);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i){
            case 0:
                rg.check(R.id.button01);
                break;
            case 1:
                rg.check(R.id.button02);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.button01:
                vp.setCurrentItem(0);
                break;
            case R.id.button02:
                vp.setCurrentItem(1);
                break;
        }
    }
}
