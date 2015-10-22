package ml.clasp.fragment;

import ml.clasp.mzxy.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jroz on 2015/10/20.
 */
public class myfragment3 extends Fragment
{
	public myfragment3()
	{
		super();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_layout, null);
	}
}
