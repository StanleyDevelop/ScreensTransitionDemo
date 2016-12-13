package stan.scrtrn.demo.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import stan.scrtrn.demo.R;

public class AddTransactionFragment
    extends MultiFragment
{
    private View subscreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.add_transaction_fragment, container, false);
        initViews(v);
        init();
        return v;
    }
    private void initViews(View v)
    {
        v.findViewById(R.id.add).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                add();
            }
        });
        subscreen = v.findViewById(R.id.subscreen);
    }
    private void init()
    {
        setEnterAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.btt));
        subscreen.post(new Runnable()
        {
            @Override
            public void run()
            {
                setSize(subscreen.getHeight(), subscreen.getWidth());
            }
        });
    }

    private void add()
    {
        String tag = "tsf" + System.currentTimeMillis();
        getChildFragmentManager().beginTransaction()
                .add(R.id.subscreen, new TransactionStepFragment(), tag)
                .addToBackStack(tag)
                .commit();
    }

}