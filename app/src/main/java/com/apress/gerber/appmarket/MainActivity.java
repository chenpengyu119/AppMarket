package com.apress.gerber.appmarket;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private  ListView  mListView;
    //需要适配的数据
    private String[] names = {"京东商城", "QQ", "QQ斗地主", "新浪微博", "天猫",
            "UC浏览器", "微信"};
    //图片id数组
    private int[] icons = {R.drawable.jd, R.drawable.qq, R.drawable.dz,
            R.drawable.xl, R.drawable.tm, R.drawable.uc, R.drawable.wx};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加代码
        mListView = (ListView) findViewById(R.id.lv); //获取Listview
        //创建一个List集合
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        //通过for循环将图片id和列表项文字放到Map中，并添加到List集合中
        for (int i = 0; i < icons.length; i++) {
            //实例化Map对象
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("icon", icons[i]);
            map.put("name", names[i]);
            listItems.add(map);  //将map对象添加到List集合中
        }
        //创建SimpleAdapter（简单适配器）
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item, new String[]{"name", "icon"}, new int[]{R.id.item_tv, R.id.item_image});
        mListView.setAdapter(adapter);  //将适配器与Listview关联
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选择项的值
                //String result=parent.getItemAtPosition(position).toString();
                //用Toast显示所选项信息（包括name和icon的id）
                Context context;
                context=getApplicationContext();


                Intent intent = new Intent();
                PackageManager packageManager = context.getPackageManager();
                switch (position) {
                    case 0:
                       // Toast.makeText(MainActivity.this, "您选择的是：京东商城", Toast.LENGTH_SHORT).show();
                        try {
                            PackageManager pm = getPackageManager();
                            pm.getPackageInfo("com.jingdong.app.mall", PackageManager.GET_ACTIVITIES);
                            //打开应用
                            intent = packageManager.getLaunchIntentForPackage("com.jingdong.app.mall");
                            intent.setAction("android.intent.action.VIEW");
                            context.startActivity(intent);
                        } catch (PackageManager.NameNotFoundException e) {

                            // e.printStackTrace();
                            intent = new Intent();
                            //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            intent.setAction("android.intent.action.VIEW");
                            Uri content_url = Uri.parse("http://www.jd.com/");
                            intent.setData(content_url);
                            startActivity(intent);
                        }

                        break;
                    case 1:
                        //Toast.makeText(MainActivity.this, "您选择的是：QQ", Toast.LENGTH_SHORT).show();
                        try {
                            PackageManager pm = getPackageManager();
                            pm.getPackageInfo("com.tencent.mobileqq", PackageManager.GET_ACTIVITIES);
                            //打开应用
                            intent = packageManager.getLaunchIntentForPackage("com.tencent.mobileqq");
                            intent.setAction("android.intent.action.VIEW");
                            context.startActivity(intent);
                        } catch (PackageManager.NameNotFoundException e) {

                            // e.printStackTrace();
                            intent = new Intent();
                            //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            intent.setAction("android.intent.action.VIEW");
                            Uri content_url = Uri.parse("http://im.qq.com/");
                            intent.setData(content_url);
                            startActivity(intent);
                        }
                        break;
                    case 2:
                      //  Toast.makeText(MainActivity.this, "您选择的是：QQ斗地主", Toast.LENGTH_SHORT).show();
                        try {
                            PackageManager pm = getPackageManager();
                            pm.getPackageInfo("com.ucmobile.lite", PackageManager.GET_ACTIVITIES);
                            //打开应用
                            intent = packageManager.getLaunchIntentForPackage("com.ucmobile.lite");
                            intent.setAction("android.intent.action.VIEW");
                            context.startActivity(intent);
                        } catch (PackageManager.NameNotFoundException e) {

                            // e.printStackTrace();
                            intent = new Intent();
                            //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            intent.setAction("android.intent.action.VIEW");
                            Uri content_url = Uri.parse("http://hlddz.qq.com/");
                            intent.setData(content_url);
                            startActivity(intent);
                        }
                        break;
                    case 3:
                       // Toast.makeText(MainActivity.this, "您选择的是：微博", Toast.LENGTH_SHORT).show();
                        try {
                            PackageManager pm = getPackageManager();
                            pm.getPackageInfo("com.sina.weibo", PackageManager.GET_ACTIVITIES);
                            //打开应用
                            intent = packageManager.getLaunchIntentForPackage("com.sina.weibo");
                            intent.setAction("android.intent.action.VIEW");
                            context.startActivity(intent);
                        } catch (PackageManager.NameNotFoundException e) {

                            // e.printStackTrace();
                            intent = new Intent();
                            //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            intent.setAction("android.intent.action.VIEW");
                            Uri content_url = Uri.parse("http://weibo.com");
                            intent.setData(content_url);
                            startActivity(intent);
                        }
                        break;
                    case 4:
                        //Toast.makeText(MainActivity.this, "您选择的是：天猫", Toast.LENGTH_SHORT).show();
                        try {
                            PackageManager pm = getPackageManager();
                            pm.getPackageInfo("com.taobao.taobao", PackageManager.GET_ACTIVITIES);
                            //打开应用
                            intent = packageManager.getLaunchIntentForPackage("com.taobao.taobao");
                            intent.setAction("android.intent.action.VIEW");
                            context.startActivity(intent);
                        } catch (PackageManager.NameNotFoundException e) {

                            // e.printStackTrace();
                            intent = new Intent();
                            //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            intent.setAction("android.intent.action.VIEW");
                            Uri content_url = Uri.parse("http://www.tmall.com/");
                            intent.setData(content_url);
                            startActivity(intent);
                        }
                        break;
                    case 5:
                        //Toast.makeText(MainActivity.this, "您选择的是：UC", Toast.LENGTH_SHORT).show();
                        // openCLD("com.ucmobile.lite",context);
                          try {
                               PackageManager pm = getPackageManager();
                               pm.getPackageInfo("com.ucmobile.lite", PackageManager.GET_ACTIVITIES);
                              //打开应用
                              intent = packageManager.getLaunchIntentForPackage("com.ucmobile.lite");
                              intent.setAction("android.intent.action.VIEW");
                              context.startActivity(intent);
                          } catch (PackageManager.NameNotFoundException e) {

                            // e.printStackTrace();
                              intent = new Intent();
                              //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                              intent.setAction("android.intent.action.VIEW");
                              Uri content_url = Uri.parse("http://www.uc.cn/");
                              intent.setData(content_url);
                              startActivity(intent);
                            }
                        break;
                    case 6:
                       // Toast.makeText(MainActivity.this, "您选择的是：微信", Toast.LENGTH_SHORT).show();
                        try {
                            PackageManager pm = getPackageManager();
                            pm.getPackageInfo("com.tencent.mm", PackageManager.GET_ACTIVITIES);
                            //打开应用
                            intent = packageManager.getLaunchIntentForPackage("com.tencent.mm");
                            intent.setAction("android.intent.action.VIEW");
                            context.startActivity(intent);
                        } catch (PackageManager.NameNotFoundException e) {

                            // e.printStackTrace();
                            intent = new Intent();
                            //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            intent.setAction("android.intent.action.VIEW");
                            Uri content_url = Uri.parse("http://weixin.qq.com/");
                            intent.setData(content_url);
                            startActivity(intent);
                        }
                        break;

                }
            }
        });
    }


    //跳转应用
   /* public static void openCLD(String packageName,Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo pi = null;

        try {

            pi = packageManager.getPackageInfo("cld.navi.mainframe", 0);
        } catch (PackageManager.NameNotFoundException e) {

        }
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pi.packageName);

        List<ResolveInfo> apps = packageManager.queryIntentActivities(resolveIntent, 0);

        ResolveInfo ri = apps.iterator().next();
        if (ri != null ) {
            String className = ri.activityInfo.name;

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);

            ComponentName cn = new ComponentName(packageName, className);

            intent.setComponent(cn);
            context.startActivity(intent);
        }
    }
*/


}
