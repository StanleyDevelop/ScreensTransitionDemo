package stan.scrtrn.demo.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import stan.scrtrn.demo.R;
import stan.scrtrn.demo.ui.fragments.AddTransactionFragment;

public class MainActivity
        extends FragmentActivity
{
    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.main_activity);
        initViews();
        init();
    }

    private void initViews()
    {
        findViewById(R.id.open).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                open();
            }
        });
    }

    private void init()
    {

    }

    private void open()
    {
        getSupportFragmentManager().beginTransaction()
                                   .add(R.id.subscreen, new AddTransactionFragment())
                                   .addToBackStack("atf")
                                   .commit();
    }
}