package ml.clasp.mzxy;

import java.util.ArrayList;
import java.util.List;

import ml.clasp.fragment.myfragment1;
import ml.clasp.fragment.myfragment2;
import ml.clasp.fragment.myfragment3;
import ml.clasp.fragment.myfragment4;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;

public class MainActivity extends FragmentActivity
{
	private Context mContext;
	private List<Fragment> mFragmentList;
	private ViewPager mViewPager;
	private List<RadioButton> mRadioButtons;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.mContext = this;
		initView();
	}

	private void initView()
	{
		RadioButton mRBtn1 = (RadioButton) findViewById(R.id.rb1);
		RadioButton mRBtn2 = (RadioButton) findViewById(R.id.rb2);
		RadioButton mRBtn3 = (RadioButton) findViewById(R.id.rb3);
		RadioButton mRBtn4 = (RadioButton) findViewById(R.id.rb4);
		mRadioButtons = new ArrayList<RadioButton>();
		mRadioButtons.add(mRBtn1);
		mRadioButtons.add(mRBtn2);
		mRadioButtons.add(mRBtn3);
		mRadioButtons.add(mRBtn4);
		Fragment _fragment1 = new myfragment1();
		Fragment _fragment2 = new myfragment2();
		Fragment _fragment3 = new myfragment3();
		Fragment _fragment4 = new myfragment4();
		mFragmentList = new ArrayList<Fragment>();
		mFragmentList.add(_fragment1);
		mFragmentList.add(_fragment2);
		mFragmentList.add(_fragment3);
		mFragmentList.add(_fragment4);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(new FragmentPagerAdapter(
				getSupportFragmentManager())
		{
			@Override
			public Fragment getItem(int position)
			{
				return mFragmentList.get(position);
			}

			@Override
			public int getCount()
			{
				return mFragmentList.size();
			}
		});
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
		{
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels)
			{
			}

			@Override
			public void onPageSelected(int position)
			{
				mRadioButtons.get(position).setChecked(true);
			}

			@Override
			public void onPageScrollStateChanged(int state)
			{
			}
		});
	}
}
