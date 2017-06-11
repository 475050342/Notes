# Notes
一.基本功能

==========================

### 以下功能为NotePad延伸

### 1 . 时间

### 2 . 搜索

### 3.  UI美化

### 4.  分享

### 5.  编写便签

二.功能介绍
==========================

### 添加便签功能



### 主页面：用户可以通过点击写便签或者右上角的新建来添加事务



### 这是编写便签的界面



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


### 分享功能的代码
###   
     	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent intent=new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, "标题："+ed1.getText().toString()+"    内容："+ed2.getText().toString());
			startActivity(intent);
			break;

		default:
			break;
		}
		return false;
	}

### 搜素功能



### 我的记事本在美化ui上花了比较多时间，但基础的功能时间戳和搜索有实现，还加入了分享功能以下是代码的布局

代码已在github中
