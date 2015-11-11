package yoffe.presidents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public President[] presidents;
    public Integer[] pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create(); //uses builder pattern

        InputStream in = getResources().openRawResource(R.raw.presidents);

        presidents = gson.fromJson(new InputStreamReader(in), President[].class);
        pictures = new  Integer[] {R.drawable.george_washington, R.drawable.john_adams, R.drawable.thomas_jefferson,
                    R.drawable.james_madison, R.drawable.james_monroe, R.drawable.john_q_adams, R.drawable.andrew_jackson,
                    R.drawable.martin_van_buren, R.drawable.william_henry_harrison, R.drawable.john_tyler,
                    R.drawable.james_k_polk, R.drawable.zachary_taylor, R.drawable.millard_fillmore, R.drawable.franklin_pierce,
                    R.drawable.james_buchanan, R.drawable.abraham_lincoln, R.drawable.andrew_johnson, R.drawable.ullysses_s_grant,
                    R.drawable.rutherford_b_hayes, R.drawable.james_a_garfield, R.drawable.chester_a_arthur,
                    R.drawable.grover_clevland, R.drawable.benjamin_harrison, R.drawable.grover_clevland, R.drawable.william_mckinley,
                    R.drawable.theodore_roosevelt, R.drawable.william_howard_taft, R.drawable.woodrow_wilson,
                    R.drawable.warren_g_harding, R.drawable.calvin_coolidge, R.drawable.herbert_hoover,
                    R.drawable.franklin_roosevelt, R.drawable.harry_truman, R.drawable.dwight_eisenhower,
                    R.drawable.john_f_kennedy, R.drawable.lyndon_johnson, R.drawable.richard_nixon,
                    R.drawable.gerald_ford, R.drawable.jimmy_carter, R.drawable.ronald_reagan, R.drawable.george_bush,
                    R.drawable.bill_clinton, R.drawable.george_w_bush, R.drawable.barack_obama};

        PresidentAdapter adapter = new PresidentAdapter(presidents, pictures);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
