package com.example.dm2.tabsyappbar;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lstLlamadas, lstChats, lstContactos;
    private TabHost tabs;
    private static int sw=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] llamadas = new String[]{"Llamada 1", "Llamada 2", "Llamada 3", "Llamada 4", "Llamada 5"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, llamadas);

        lstLlamadas = (ListView) findViewById(R.id.listaLlamadas);

        lstLlamadas.setAdapter(adaptador);

        final String[] chats = new String[]{"Chat 1", "Chat 2", "Chat 3", "Chat 4", "Chat 5"};
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chats);

        lstChats = (ListView) findViewById(R.id.listaChats);
        lstChats.setAdapter(adaptador2);

        final String[] contactos = new String[]{"Contacto 1", "Contacto 2", "Contacto 3", "Contacto 4", "Contacto 5"};
        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactos);

        lstContactos = (ListView) findViewById(R.id.listaContactos);
        lstContactos.setAdapter(adaptador3);

        Resources res = getResources();
        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("llamadas");
        spec.setContent(R.id.llamadas);
        spec.setIndicator("LLAMADAS");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("chats");
        spec.setContent(R.id.chat);
        spec.setIndicator("CHATS");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("CONTACTOS");
        spec.setContent(R.id.contactos);
        spec.setIndicator("CONTACTOS");
        tabs.addTab(spec);

        tabs.setCurrentTab(1);

        //poner color blanco
        for(int i=0;i<=2;i++)
        {
            final TextView tv = (TextView) tabs.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(this.getResources().getColorStateList(R.color.blanco));
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_otro)
        {
            switch (tabs.getCurrentTab())
            {
                case 0:
                    tabs.setCurrentTab(tabs.getCurrentTab()+1);
                    break;
                case 1:
                    if(sw==0)
                    {
                        tabs.setCurrentTab(tabs.getCurrentTab()-1);
                        sw =1;
                        break;
                    }
                    else
                    {
                        tabs.setCurrentTab(tabs.getCurrentTab()+1);
                        sw =0;
                        break;
                    }

                case 2:
                    tabs.setCurrentTab(tabs.getCurrentTab()-1);
                    break;
            }
        }

        return true;

    }

}
