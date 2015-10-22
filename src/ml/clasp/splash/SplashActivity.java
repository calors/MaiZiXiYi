package ml.clasp.splash;

import java.util.ArrayList;
import java.util.List;

import ml.clasp.mzxy.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Telephony.Sms;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashActivity extends Activity
{
	private ViewPager mPager;
	private List<View> mSplashViewList;
	private Context mContext;
	private static final String TAG = "SplashActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		mContext = this;
		initView();
		mPager.addOnPageChangeListener(new OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int pArg0)
			{
				Log.i(TAG, "page" + pArg0);
			}

			@Override
			public void onPageScrolled(int pArg0, float pArg1, int pArg2)
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageScrollStateChanged(int pArg0)
			{
				// TODO Auto-generated method stub
			}
		});
	}

	private void initView()
	{
		mPager = (ViewPager) findViewById(R.id.splashVP);
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
				pContainer.addView(mSplashViewList.get(pPosition));
				return mSplashViewList.get(pPosition);
			}

			@Override
			public boolean isViewFromObject(View pArg0, Object pArg1)
			{
				// TODO Auto-generated method stub
				return pArg0 == pArg1;
			}

			@Override
			public int getCount()
			{
				return mSplashViewList.size();
			}
		});
	}
}
