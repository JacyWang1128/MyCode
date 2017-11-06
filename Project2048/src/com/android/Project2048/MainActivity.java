package com.android.Project2048;

import com.android.dao.UserDao;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btLogin,btRegister;
	private EditText username,password;
	private UserDao cUserDao;
	private long lDbState;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btLogin = (Button) findViewById(R.id.btLogin);
		btRegister = (Button) findViewById(R.id.btRegister);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		cUserDao = new UserDao(this);
		btLogin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				boolean b = cUserDao.check(username.getText().toString(), password.getText().toString());
				if (b==true) {
					Intent intent = new Intent(MainActivity.this,GameRoot.class);
					startActivity(intent);
					Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
					finish();
				}else {
					Toast.makeText(MainActivity.this, "登录失败！，用户名或密码错误", Toast.LENGTH_LONG).show();
				}
			}});
		btRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lDbState = cUserDao.add(username.getText().toString(),
		                password.getText().toString());
Toast.makeText(MainActivity.this, "注册成功！", Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
