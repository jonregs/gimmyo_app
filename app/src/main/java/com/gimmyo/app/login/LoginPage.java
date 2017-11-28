package com.gimmyo.app.login;

import com.gimmyo.app.R;
import com.gimmyo.app.bidboard.BidBoardHome;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jonregalado on 10/28/17.
 */

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
	
	private String TAG = "LoginGimmyo";
	private String userAccount;
	private String passwordAccount;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page_layout);
		
		Button signinButton = (Button) findViewById(R.id.login_to_gimmyo);
		signinButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
			case R.id.login_to_gimmyo:
				signIn();
		}
	}
	
	private void signIn() {
		
		if(!validate()){
			onSignInFailed();
			return;
		} else {
			
			final ProgressDialog progressDialog = new ProgressDialog(LoginPage.this, R.style.AppTheme_Dark_Dialog);
			progressDialog.setIndeterminate(true);
			progressDialog.setMessage("Authenticating your account...");
			progressDialog.show();
			
			EditText userName = (EditText) findViewById(R.id.input_email);
			final String _userName = userName.getText().toString();
			
			EditText password = (EditText) findViewById(R.id.input_password);
			final String _password = password.getText().toString();
			
			setUserAccount(_userName, _password);
			
			new android.os.Handler().postDelayed(
					new Runnable() {
						@Override
						public void run() {
							ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
							
							query.getInBackground("lhPdEne3nI", new GetCallback<ParseObject>() {
								@Override
								public void done(ParseObject object, ParseException e) {
									if (e == null && object != null) {
										Log.d(TAG, "inside parse query");
										boolean loggedIn = confirmLoginAccount(object.getString("username"), Integer.toString(object.getInt("score")));
										if(!loggedIn) {
											onSignInFailed();
										}
									}
								}
							});
							progressDialog.dismiss();
						}
					}, 1000);
		}
	}
	
	public void setUserAccount(String userAccount, String passwordAccount){
		this.userAccount = userAccount;
		this.passwordAccount = passwordAccount;
	}
	
	private boolean confirmLoginAccount(String username, String password) {
		Log.d(TAG, "inside confirm login account");
		if (username.equals(userAccount) && password.equals(passwordAccount)) {
			Log.d(TAG, "success logging in");
			Intent successLogin = new Intent(LoginPage.this, BidBoardHome.class);
			startActivity(successLogin);
			finish();
			return true;
		}
		else {
			return false;
		}
	}
	
	private void onSignInFailed() {
		Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
	}
	
	private boolean validate() {
		boolean valid = true;
		
		EditText userName = (EditText) findViewById(R.id.input_email);
		String _userName = userName.getText().toString();
		
		EditText password = (EditText) findViewById(R.id.input_password);
		String _password = password.getText().toString();
		
		if (_userName.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(_userName).matches()){
			userName.setError("enter a valid email address");
			valid = false;
		} else {
			userName.setError(null);
		}
		
		if (_password.isEmpty() || _password.length() < 4 || password.length() > 15) {
			password.setError("between 4 and 15 alphanumeric characters required");
			valid = false;
		} else {
			password.setError(null);
		}
		return valid;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
	}
}