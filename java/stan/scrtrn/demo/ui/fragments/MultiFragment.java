package stan.scrtrn.demo.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

public abstract class MultiFragment
    extends Fragment
{
    private Animation enterAnimation;
    private int height = 0;
    private int width = 0;
    private final FragmentManager.OnBackStackChangedListener onBackStackChangedListener = new FragmentManager.OnBackStackChangedListener()
    {
        @Override
        public void onBackStackChanged()
        {
            Log.e(getClass().getName(), getChildFragmentManager().getFragments().toString());
            for(int i=0; i<getChildFragmentManager().getBackStackEntryCount(); i++)
            {
                FragmentManager.BackStackEntry backStackEntry = getChildFragmentManager().getBackStackEntryAt(i);
//                Log.e(getClass().getName(), "backStackEntry " + backStackEntry + " name " + backStackEntry.getName());
                Fragment fragment = getChildFragmentManager().findFragmentByTag(backStackEntry.getName());
//                Log.e(getClass().getName(), "fragment " + fragment);
                if(fragment != null && fragment.getView() != null)
                {
                    final View view = fragment.getView();
                    final int offset = i*100;
                    ViewGroup.LayoutParams params = view.getLayoutParams();
                    params.height = height - offset;
                    params.width = width - (getChildFragmentManager().getBackStackEntryCount()-1)*10 + i*10;
                    view.setLayoutParams(params);
                    Log.e(getClass().getName(), "params.height " + params.height);
                    if(i == getChildFragmentManager().getBackStackEntryCount() -1)
                    {
                        animate(view);
                    }
                }
            }
        }
    };

    private void animate(final View view)
    {
        view.setVisibility(View.GONE);
        runAfterResume(new Runnable()
        {
            @Override
            public void run()
            {
                view.setVisibility(View.VISIBLE);
                view.startAnimation(enterAnimation);
            }
        });
    }

    protected void setEnterAnimation(Animation ea)
    {
        enterAnimation = ea;
    }
    protected void setSize(int h, int w)
    {
        height = h;
        width = w;
        Log.e(getClass().getName(), "height " + height + " width " + width);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        getChildFragmentManager().addOnBackStackChangedListener(onBackStackChangedListener);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        getChildFragmentManager().removeOnBackStackChangedListener(onBackStackChangedListener);
    }

    protected void runAfterResume(final Runnable r)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(!isResumed())
                {

                }
                getView().post(r);
            }
        }).start();
    }
}