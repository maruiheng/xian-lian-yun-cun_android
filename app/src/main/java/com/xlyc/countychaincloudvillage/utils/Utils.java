package com.xlyc.countychaincloudvillage.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;


import com.xlyc.countychaincloudvillage.ui.widget.MyToast;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 */
public class Utils {
	// 手机分辨率宽高
	public static int screenHeight_;
	public static int screenWidth_;
	static final String LOG_TAG = "PullToRefresh";
	
	/**
	 * 验证手机号码格式表达式
	 */
	public static Pattern MobilePattern = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[0678]|18[0-9]|14[57])[0-9]{8}$");

	/**
	 * 获取屏幕分辨率
	 * 
	 * @param context
	 */
	public static void windowScreenSize(Context context) {
		DisplayMetrics outMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		screenHeight_ = outMetrics.heightPixels;
		screenWidth_ = outMetrics.widthPixels;
	}

	public static float convertDpToPixel(float dp, Context context){
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float px = dp * (metrics.densityDpi / 160f);
		return px;
	}

	public static float convertPixelsToDp(float px, Context context){
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float dp = px / (metrics.densityDpi / 160f);
		return dp;
	}

	/**
	 * 获取版本名称
	 * 
	 * @param context
	 * @return
	 */
	public static String getVersionName(Context context) {
		try {
			String pkName = context.getPackageName();
			String versionName = context.getPackageManager().getPackageInfo(pkName, 0).versionName;

			return versionName;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 获取友盟渠道号
	 * 
	 * @param context
	 * @return
	 */
	public static String getUmengChannel(Activity context) {/*
		Object value = null;

		PackageManager packageManager = context.getPackageManager();
		ApplicationInfo applicationInfo;

		try {
			applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);

			if (applicationInfo != null && applicationInfo.metaData != null) {
				value = applicationInfo.metaData.get("UMENG_CHANNEL");
				if (value != null) {
					return value.toString();
				}
			}
		} catch (NameNotFoundException e) {

		}

	*/
		return null;
	}

	/**
	 * 1 Year 1年 1 Month 1个月 1 Day 1天
	 * 
	 * @param period
	 * @param periodUnit
	 * @return
	 */
	public static String periodConversion(int period, String periodUnit) {
		if ("Year".equals(periodUnit)) {
			return period + "年";
		}

		if ("Month".equals(periodUnit)) {
			return period + "个月";
		}

		if ("Day".equals(periodUnit)) {
			return period + "天";
		}

		return period + "";
	}

	/**
	 * 1 Year 1年 1 Month 1个月 1 Day 1天
	 * 
	 * @param periodUnit
	 * @return null
	 */
	public static String periodConversion(String periodUnit) {
		if ("Year".equals(periodUnit)) {
			return "年";
		}

		if ("Month".equals(periodUnit)) {
			return "个月";
		}

		if ("Day".equals(periodUnit)) {
			return "天";
		}

		return "";
	}

	/**
	 * 123123123 2015-05-18 10:54:27
	 * 
	 * @param time
	 * @return
	 */
	public static String getDateString(long time) {
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return myFmt.format(new Date(time));
	}

	public static String getDateStringMinute(long time) {
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		return myFmt.format(new Date(time));
	}

	/**
	 * 123123123 2015-05-18
	 * 
	 * @param time
	 * @return
	 */
	public static String getDateStringDay(long time) {
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");

		return myFmt.format(new Date(time));
	}

	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 跳转到内部WebView
	 * 
	 * @param context
	 * @param url
	 * @param title
	 */
	/*
	 * public static void jumpURL(Context context, String url, String title) {
	 * if (TextUtils.isEmpty(url) || "#".equals(url)) { return; }
	 * 
	 * Intent intent = new Intent(context, WebActivity.class);
	 * intent.putExtra("url", url); intent.putExtra("name", title);
	 * context.startActivity(intent); }
	 */
	
	
	public static void jumpURL(Context context, String url, String title, String iconUrl, boolean isRightShow) {
		if (TextUtils.isEmpty(url) || "#".equals(url)) {
			return;
		}

		/*Intent intent = new Intent(context, WebActivity.class);
		intent.putExtra("url", url);
		intent.putExtra("name", title);
		intent.putExtra("iconUrl", iconUrl);
		intent.putExtra("isRightShow", isRightShow);
		context.startActivity(intent);*/
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 13817124233 138****4233
	 * 
	 * @param phone
	 * @return
	 */
	public static String hidePhone(String phone) {
		return phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
	}

	public static String replace(String phone){
		return phone.replace(" ", "");
	}

	public static boolean regPatternsPassword(Context context, String password) {
		if (password.length() < 6 || password.length() > 20) {
			MyToast.showToast(context, "密码长度只能在6-20位字符之间");
			return true;
		}

		Pattern sameCharsPattern = Pattern.compile("(\\w)(\\1)+");
		if (sameCharsPattern.matcher(password).matches()) {
			MyToast.showToast(context, "密码不能为同一个字符");
			return true;
		}

		Pattern containsCharsPattern = Pattern.compile("^[0-9]*$");
		Pattern containsNumberPattern = Pattern.compile("^[a-zA-Z]+$");
		if (containsCharsPattern.matcher(password).matches()
				|| containsNumberPattern.matcher(password).matches()) {
			MyToast.showToast(context, "密码需要包含字母和数字");
			return true;
		}

		return false;
	}

	/**
	 * 跳转到webview
	 * 
	 * @param url
	 */
	public static void jumpExplorer(Context context, String url) {
		if (TextUtils.isEmpty(url) || "#".equals(url)) {
			return;
		}

		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		Uri content_url = Uri.parse(url);
		intent.setData(content_url);
		context.startActivity(intent);
	}

	public static String getTime() {

		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String date = simpleFormat.format(System.currentTimeMillis());
		return date;

	}

	public static void closeBoard(Activity mActivity) {
		((InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE))
				.hideSoftInputFromWindow(mActivity.getCurrentFocus().getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
	}

	/**
	 * 判断应用程序是否安装
	 * 
	 * @param context
	 * @param packageName
	 *            应用程序安装包名
	 * @return
	 */
	public static boolean isAppInstalled(Context context, String packageName) {
		PackageInfo packageInfo = null;
		try {
			// 获取安装包信息
			packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
		} catch (NameNotFoundException e) {
			packageInfo = null;
			e.printStackTrace();
		}

		if (null == packageInfo) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 从 Assets 文件夹中获取图片
	 * 
	 * @param activity
	 * @param assetName
	 *            文件名称
	 * @return null 文件不存在
	 */
	public static Bitmap getBitmapFromAssets(Activity activity, String assetName) {
		InputStream input = null;
		Bitmap bmp = null;
		try {
			input = activity.getAssets().open(assetName);
			bmp = BitmapFactory.decodeStream(input);
		} catch (IOException e) {
			bmp = null;
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bmp;
	}
	
	/**
	 * 获取SDK版本
	 * @return
	 */
	public static int getSDKVersion(){
		return Build.VERSION.SDK_INT;
	}

	/* 控制台统一输出信息 start */

	// 是否打印标志
	private static boolean isPrintMessage_;

	public static void isPrintMessage(boolean isprint) {
		isPrintMessage_ = isprint;
	}

	/**
	 * 控制台统一打印
	 *
	 * @param obj
	 */
	public final static void printOutToConsole(Object obj) {
		if (isPrintMessage_) {
			if (obj instanceof String) {
				printOutToConsole((String) obj);
			} else if (obj instanceof byte[]) {
				printOutToConsole((byte[]) obj);
			} else {
				System.out.println(obj);
			}
		}
	}

	/**
	 * @param s
	 */
	public final static void printOutToConsole(String s) {
		if (isPrintMessage_) {
			int length = s.length();
			int offset = 3000;
			if (length > offset) {// 解决报文过长，打印不全的问题
				int n = 0;
				for (int i = 0; i < length; i += offset) {
					n += offset;
					if (n > length)
						n = length;
					System.out.println(s.substring(i, n));
				}
			} else {
				System.out.println(s);
			}
		}
	}

	/**
	 * @param byts
	 */
	public final static void printOutToConsole(byte[] byts) {
		if (isPrintMessage_) {
			if (byts == null) {
				return;
			}
			for (int i = 0; i < byts.length; i++) {
				System.out.print("[" + i + "]" + " : \t");
				System.out.println(byts[i]);
			}
		}
	}

	/**
	 * 异常统一打印
	 * 
	 * @param e
	 */
	public final static void printException(Exception e) {
		if (isPrintMessage_) {
			e.printStackTrace();
		}
	}

	/* 信息输出 end */

	/* 网络判断 start */
	/**
	 * 判断网络是否可用
	 * 
	 * @return boolean
	 */
	public static boolean isConnectByNet() {
		/*ConnectivityManager conn = (ConnectivityManager) AppBasic.getInstance().currentActivity()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = conn.getActiveNetworkInfo();
		if (null == netInfo || !netInfo.isAvailable()) {
			return false;
		}*/
		return true;
	}

	/* 网络判断 end */

	/**
	 * 获取String资源
	 * @return
	 */
	public static String getString(Context context, @NonNull int resId){
		return context.getString(resId);
	}

	/**
	 * 获取屏幕宽度
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenWith(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getApplicationContext().getResources().getDisplayMetrics();
		return dm.widthPixels;
	}

	/**
	 * 获取屏幕高度
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getApplicationContext().getResources().getDisplayMetrics();
		return dm.heightPixels;
	}
	

	/**
	 * 判断当前字符是否是表情字符
	 * @param codePoint
	 * @return
	 */
	public static boolean isEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}
	
	/**
	 * 判断当前字符
	 * @param str
	 * @return
	 */
	public static boolean isEmojiCharacter(String str) {
		if(TextUtils.isEmpty(str)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if(!isEmojiCharacter(str.charAt(i))){
				return true;
			}
		}
		return false;
	}

	/**
	 * 去掉手机号内除数字外的所有字符
	 *
	 * @param phoneNum 手机号
	 * @return
	 */
	public static String formatPhoneNum(String phoneNum) {
		String regex = "(\\+86)|[^0-9]";
		Pattern pattern = Pattern.compile(regex );
		Matcher matcher = pattern.matcher(phoneNum);
		return matcher.replaceAll("");
	}

	/**
	 * 分割 imgs
	 * @param imgs
	 * @return
	 */
	public static String[] formString(@NonNull String imgs){
		if (imgs.contains(",")) {
			// 清空空格
			imgs = imgs.replace(" ", "");

			String[] img = imgs.split(",");
			return img;
		}

		return null;
	}

}
