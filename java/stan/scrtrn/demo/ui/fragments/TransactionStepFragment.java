package stan.scrtrn.demo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stan.scrtrn.demo.R;

public class TransactionStepFragment
    extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.transaction_step_fragment, container, false);
        initViews(v);
        init();
        return v;
    }
    private void initViews(View v)
    {

    }
    private void init()
    {
    }
}