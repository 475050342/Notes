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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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

/*
 * 这个类主要包括五个点击事件，分别为
 * 1，ListView的长按点击事件，用来AlertDialog来判断是否删除数据。
 * 2，ListView的点击事件，跳转到第二个界面，用来修改数据
 * 3，新建便签按钮的点击事件，跳转到第二界面，用来新建便签
 * 4，menu里的退出事件，用来退出程序
 * 5，menu里的新建事件，用来新建便签
 */
public class MainActivity extends Activity {
	Uri mUri;


	Button bt;
	ListView lv;
	EditText search;
	LayoutInflater inflater;
	ArrayList<Cuns> array,array2;
	MyDataBase mdb;
	int ids;
	Cuns cun;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);;
		setContentView(R.layout.activity_main);
		// Gets the View ID for the EditText box

		lv=(ListView) findViewById(R.id.listView1);
		bt=(Button) findViewById(R.id.button1);
		search = (EditText)findViewById(R.id.search);
		inflater=getLayoutInflater();
		
		mdb=new MyDataBase(this);
		array=mdb.getArray();
		MyAdapter adapter=new MyAdapter(inflater,array);
		lv.setAdapter(adapter);


		search.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				String value = search.getText().toString();
				array2=mdb.getArrayByValue(value);
				MyAdapter adapter=new MyAdapter(inflater,array2);
				lv.setAdapter(adapter);

			}
		});

		/*
		 * 点击listView里面的item,进入到第二个页面，用来修改日记
		 */
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub				
				Intent intent=new Intent(getApplicationContext(),SecondAtivity.class);
				intent.putExtra("ids",array.get(position).getIds() );
				startActivity(intent);
				MainActivity.this.finish();
			}
		});

		/*
		 * 长点后来判断是否删除数据
		 */
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {
				// TODO Auto-generated method stub
				//AlertDialog,来判断是否删除日记。
				new AlertDialog.Builder(MainActivity.this)
				.setTitle("删除")
				.setMessage("是否删除笔记")
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						mdb.toDelete(array.get(position).getIds());
						array=mdb.getArray();
						MyAdapter adapter=new MyAdapter(inflater,array);
						lv.setAdapter(adapter);
					}
				})
				.create().show();
				return true;
			}
		});
		/*
		 * 按钮点击事件，用来新建日记
		 */
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(),SecondAtivity.class);
				startActivity(intent);
				MainActivity.this.finish();
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			Intent intent=new Intent(getApplicationContext(),SecondAtivity.class);
			startActivity(intent);
			this.finish();
			break;
		case R.id.item2:
			this.finish();
			break;
			case R.id.item3:
				Intent intent1=new Intent(getApplicationContext(),ThirdActivity.class);
				startActivity(intent1);
				this.finish();
				break;
		default:
			break;
		}
		return true;
		
	}
	
	
}
