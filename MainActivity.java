package ltc.lawncaretracker;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends ActionBarActivity 
{
	// List view
    private ListView listView;
     
    // Listview Adapter
    ArrayAdapter<String> adapter;
     
    // Search EditText
    EditText inputSearch;
    
    Context context;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        // Listview Data
        String names[] = {"John Smith", "Jane Doe", "Michael Adams", "Ryan Evans", "Trey Thibodeaux", "Tucker Roussel", "abc", "123"};
         
        listView = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
         
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, R.id.client_name, names);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener() 
        {

 
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent i = new Intent(getApplicationContext(), MainActivity2.class);
				startActivity(i);
				
			}
        });
         
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() 
        {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) 
            {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);   
            }
             
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) 
            {
                // TODO Auto-generated method stub
                 
            }
             
            @Override
            public void afterTextChanged(Editable arg0) 
            {
                // TODO Auto-generated method stub                          
            }
        });
    }    
   

}
