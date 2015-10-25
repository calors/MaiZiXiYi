package ml.clasp.splash;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.Duration;

import ml.clasp.mzxy.MainActivity;
import ml.clasp.mzxy.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

public class SplashActivity extends Activity
{
	private ViewPager mPager;
	private List<View> mSplashViewList;
	private static final String TAG = "genolog";
	private int mCurrentPage;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initView();
		mPager.addOnPageChangeListener(new OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int pArg0)
			{
				Log.i(TAG, "selected=" + pArg0);
				mCurrentPage = pArg0;
			}

			@Override
			public void onPageScrolled(int pArg0, float pArg1, int pArg2)
			{
			}

			@Override
			public void onPageScrollStateChanged(int pArg0)
			{
				Log.i(TAG, "Scrollstatechange=" + pArg0);
				if (mCurrentPage==2&&pArg0==0)
				{
					Intent _intent=new Intent(SplashActivity.this,MainActivity.class);
					startActivity(_intent);
				}
			}
		});
	}

	private void initView()
	{
		mPager = (ViewPager) findViewById(R.id.splashVP);
		Animation _animation = new AlphaAnimation(0.0f, 1.0f);
		_animation.setDuration(3000);
		mPager.setAnimation(_animation);
		LayoutInflater _inflater = getLayoutInflater();
		mSplashViewList = new ArrayList<View>();
		// 加载每一个Splash的view
		View _splashView1 = _inflater.inflate(R.layout.splash1, null);
		View _splashView2 = _inflater.inflate(R.layout.splash2, null);
		View _splashView3 = _inflater.inflate(R.layout.splash3, null);
		mSplashViewList.add(_splashView1);
		mSplashViewList.add(_splashView2);
		mSplashViewList.add(_splashView3);
		// Viewpager添加适配器
		mPager.setAdapter(new PagerAdapter()
		{
			@Override
			public Object instantiateItem(ViewGroup pContainer, int pPosition)
			{
				Log.i(TAG, "instant=" + pPosition);
				pContainer.addView(mSplashViewList.get(pPosition));
				return mSplashViewList.get(pPosition);
			}

			@Override
			public boolean isViewFromObject(View pArg0, Object pArg1)
			{
				return pArg0 == pArg1;
			}

			@Override
			public int getCount()
			{
				return mSplashViewList.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object)
			{
				container.removeView(mSplashViewList.get(position));
			}
		});
	}
}
