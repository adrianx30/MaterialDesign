package co.edu.udea.cmovil.gr04.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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

    public void ocultarPantalla(View v) {

        final View miCard = findViewById(R.id.view);
        if (miCard.getVisibility() == View.VISIBLE) {
            int cx = (miCard.getLeft() + miCard.getRight()) / 2;
            int cy = (miCard.getTop() + miCard.getBottom()) / 2;

            int radioInicial = miCard.getWidth();

            Animator anim = ViewAnimationUtils.createCircularReveal(miCard, cx, cy, radioInicial, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    miCard.setVisibility(View.INVISIBLE);
                }
            });

            anim.start();

        }else {
            Toast mensaje = Toast.makeText( getApplicationContext(), "Si ya no hay nada, ¿qué querés ocultar?"	, Toast.LENGTH_SHORT);
            mensaje.show();
        }

    }

    public void mostrarPantalla(View v) {

        final View miCard = findViewById(R.id.view);

        if (miCard.getVisibility() != View.VISIBLE) {
            int cx = (miCard.getLeft() + miCard.getRight()) / 2;
            int cy = (miCard.getTop() + miCard.getBottom()) / 2;

            int radioFinal = Math.max(miCard.getWidth(), miCard.getHeight());

            Animator anim = ViewAnimationUtils.createCircularReveal(miCard, cx, cy, 0, radioFinal);

            miCard.setVisibility(View.VISIBLE);
            anim.start();


        }else {
            Toast mensaje = Toast.makeText(getApplicationContext(), "Ya lo estás viendo ole, relajate!", Toast.LENGTH_SHORT);
            mensaje.show();
        }
    }

}
