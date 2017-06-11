[main]# Notes
一.基本功能

==========================

### 以下功能为NotePad延伸

### 1 . 时间

### 2 . 搜索

### 3.  UI美化

### 4.  分享

### 5.  编写便签

### 6.  修改便签


二.功能介绍
==========================

### 添加便签功能
![main](https://github.com/475050342/Notes/blob/master/picture/Screenshot_2017-06-11-22-37-34_com.example.ibook.png)
![main](https://github.com/475050342/Notes/blob/master/picture/Screenshot_2017-06-11-22-49-41_com.example.ibook.png)

### 主页面：用户可以通过点击写便签或者右上角的新建来添加事务

![main](https://github.com/475050342/Notes/blob/master/picture/Screenshot_2017-06-11-22-49-46_com.example.ibook.png)

### 这是编写便签的界面

![mian](https://github.com/475050342/Notes/blob/master/picture/Screenshot_2017-06-11-22-49-43_com.example.ibook.png)

### 直接点击主页便签可以直接修改

### 显示时间戳的代码
### 
      public void onBackPressed() {
		     // TODO Auto-generated method stub		
		    //super.onBackPressed();
		    SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy.MM.dd  HH:mm:ss");     
	    	Date   curDate   =   new   Date(System.currentTimeMillis());//获取当前时间     
		    String times   =   formatter.format(curDate);      
		    String title=ed1.getText().toString();
	    	String content=ed2.getText().toString();
		//是要修改数据
		if(ids!=0){
			cun=new Cuns(title,ids, content, times);
			    myDatabase.toUpdate(cun);
			    Intent intent=new Intent(SecondAtivity.this,MainActivity.class);
			    startActivity(intent);
			    SecondAtivity.this.finish();
	    	}

### 分享界面

![mian](https://github.com/475050342/Notes/blob/master/picture/Screenshot_2017-06-11-22-50-32_com.example.ibook.png)
![mian](https://github.com/475050342/Notes/blob/master/picture/Screenshot_2017-06-11-22-50-34_android.png)
### 分享功能的代码
###   
     	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent intent=new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, "标题："+ed1.getText().toString()+"    内容："+ed2.getText().toString());
			startActivity(intent);
			break;

		default:
			break;
		}
		return false;
	}

### 搜素功能

![mian](https://github.com/475050342/Notes/blob/master/picture/Screenshot_2017-06-11-22-37-38_com.example.ibook.png)

### 搜索代码

### 
     <EditText
        android:drawableLeft="@drawable/search_icon"
        android:background="@drawable/search_edittext_shape"

        android:id="@+id/search"
        android:layout_width="match_parent"
        android:layout_height="50dp" />
	
	
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


