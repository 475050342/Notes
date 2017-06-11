package com.example.ibook;

import java.util.ArrayList;

import com.example.beans.Cuns;
import com.example.luoji.MyAdapter;
import com.example.luoji.MyDataBase;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/6/11.
 */

public class ThirdActivity extends Activity {
    SearchView mysearch;
    ListView mylist;
    String[] mStr = {"aaaaa","bbbbb","ccccc"};
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mylist=(ListView) findViewById(R.id.listView);
        mylist.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1));
        mylist.setTextFilterEnabled(true);
        mysearch=(SearchView) findViewById(R.id.searchView);

			mysearch.setIconifiedByDefault(false);
			mysearch.setSubmitButtonEnabled(true);
			mysearch.setQueryHint("查找");

        mysearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            Toast.makeText(ThirdActivity.this, "", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if(TextUtils.isEmpty(newText)){
                mylist.clearTextFilter();
            }
            else{
                mylist.setFilterText(newText);
            }
            return true;

        }
    });

}
}
