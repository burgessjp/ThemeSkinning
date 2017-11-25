package solid.ren.themeskinning.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import solid.ren.skinlibrary.base.SkinBaseActivity;
import solid.ren.themeskinning.R;

public class SecondActivity extends SkinBaseActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
