package com.hzyc.zxl.demo_012;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/3/8 0008.
 */
public class MyContentProvider extends ContentProvider{

    //URI解析器
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    //最先执行
    static {
        //1.地址  2.访问路径，数据库表  3.响应码
        //#匹配所有数字  *匹配所有字符串  后面的1，2，3是区分不同URI的解析码
        URI_MATCHER.addURI("com.hzyc.zxl.demo_012.MyContentProvider","person",1);
        URI_MATCHER.addURI("com.hzyc.zxl.demo_012.MyContentProvider","person/#",2);
        URI_MATCHER.addURI("com.hzyc.zxl.demo_012.MyContentProvider","person/#/*",3);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
