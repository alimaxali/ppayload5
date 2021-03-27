package com.example.room_payload5;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {
    private AdView mAdView;
    private ProgressBar witt;
    private String url,namee,point,poooo,codd,testt,end;
    final ArrayList<NumbersView> arrayList = new ArrayList<NumbersView>();

    private JsonObjectRequest request = null;
    private int pointt;
    private LinearLayout lay1,lay2,lay3;

    private Button divv,reff,sing,backk;
    private JSONArray aary = new JSONArray();
    private RequestQueue requestQueuee = null;
    private Switch sw1;
    private InterstitialAd mInterstitialAd;
    private WebView weep;
    private EditText pass,namm;
    private BottomNavigationView vv;
    private BottomAppBar vvv;
    private FloatingActionButton btoonhome;
    private int num = 0;
     int seeadd = 0;

    private TextView pon ,sleepp;
    private RewardedVideoAd mRewardedVideoAd;

    private InterstitialAd yy;
    /////صفحه البدايه
    private TextView tt;
    private ImageView ico,icostar;
    private Animation aa;
    ////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        witt = (ProgressBar) findViewById(R.id.wit);
        divv = (Button) findViewById(R.id.addd);
        reff = (Button) findViewById(R.id.reff);
        sing = (Button) findViewById(R.id.sing);
        backk = (Button) findViewById(R.id.backk);
        lay1 = (LinearLayout) findViewById(R.id.lay1);
        lay2 = (LinearLayout) findViewById(R.id.lay2);
        lay3 = (LinearLayout) findViewById(R.id.lay3);

        icostar = (ImageView) findViewById(R.id.icostar);

        btoonhome = (FloatingActionButton) findViewById(R.id.bt);
        sw1 = (Switch)findViewById(R.id.pointtt);
        poooo ="0";
        end = "kkkkkkkkkkkk";
//////مدخلات الاسم والباسورد
        pass = (EditText) findViewById(R.id.pass);
        namm = (EditText) findViewById(R.id.namm);
///////
        pon = (TextView) findViewById(R.id.pon);
        sleepp = (TextView) findViewById(R.id.sleepp);

        ico = (ImageView) findViewById(R.id.icoroom);
        tt = (TextView) findViewById(R.id.troom);
        aa = AnimationUtils.loadAnimation(this,R.anim.ttt);
        //////المتصفح
        url = "https://roompayload5.blogspot.com/";
        weep = (WebView) findViewById(R.id.wwee);
        weep.getSettings().setLoadWithOverviewMode(true);
        weep.getSettings().setUseWideViewPort(true);
        weep.getSettings().setJavaScriptEnabled(true);
        weep.setWebViewClient(new WebViewClient());
        // weep.getSettings().setBuiltInZoomControls(true);
        weep.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity (intent);
            }
        });
        weep.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                witt.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                witt.setVisibility(View.GONE);
            }
        });
        weep.loadUrl(url);
//////////////////////////


//////اعلانات
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


//اعلان بيني////
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6645174391699661/3672824966");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        ////////
        ////////اعلان مكافئه
        yy = new InterstitialAd(this);
        yy.setAdUnitId("ca-app-pub-6645174391699661/9663673774");
        yy.loadAd(new AdRequest.Builder().build());

        yy.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                yy.loadAd(new AdRequest.Builder().build());
            }

        });
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();


////////////////////
        //شريط الخيارات
        vvv = (BottomAppBar) findViewById(R.id.bottomApp);

        vv = (BottomNavigationView) findViewById(R.id.bottomAppv);
        vv.setBackground(null);
        //booton شريط الخيارات
        vv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    //حول
                    case R.id.myhom1:
                        hid();
                        if (seeadd == 0 | seeadd >= 10 ){
                            seeadd=0;
                            Toast.makeText(MainActivity.this, "اعلان", Toast.LENGTH_SHORT).show();

                            seeadd++;
                            if (mInterstitialAd.isLoaded()) {


                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){

                                    public void onAdClosed() {
                                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                        // Code to be executed when the interstitial ad is closed.
                                        weep.loadUrl("https://rooompayload5.blogspot.com/");
                                    }


                                });

                            } else {
                                weep.loadUrl("https://rooompayload5.blogspot.com/");

                                Log.d("TAG", "The interstitial wasn't loaded yet.");
                            }

                        } else {
                            seeadd++;

                            weep.loadUrl("https://rooompayload5.blogspot.com/");

                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        return true;
                    //مسابقات
                    case R.id.myhom2:
                        hid();
                        if (seeadd == 0 | seeadd >= 10 ){
                            seeadd=0;
                            Toast.makeText(MainActivity.this, "اعلان", Toast.LENGTH_SHORT).show();

                            seeadd++;
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){

                                    public void onAdClosed() {
                                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                        weep.loadUrl("https://roompayload5.blogspot.com/search?q=مسابقه");
                                    }


                                });
                            } else {
                                weep.loadUrl("https://roompayload5.blogspot.com/search?q=مسابقه");
                                Log.d("TAG", "The interstitial wasn't loaded yet.");
                            }
                        }else {
                            seeadd++;

                            weep.loadUrl("https://roompayload5.blogspot.com/search?q=مسابقه");
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        return true;
                    //تطبيقات
                    case R.id.myhom3:
                        hid();
                        if (seeadd == 0 | seeadd >= 10 ){
                            seeadd=0;
                            Toast.makeText(MainActivity.this, "اعلان", Toast.LENGTH_SHORT).show();


                            seeadd++;
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){

                                    public void onAdClosed() {
                                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                        weep.loadUrl("https://roompayload5.blogspot.com/search?q=تطبيق");
                                    }


                                });
                            } else {
                                weep.loadUrl("https://roompayload5.blogspot.com/search?q=تطبيق");
                                Log.d("TAG", "The interstitial wasn't loaded yet.");
                            }

                        }else {
                            seeadd++;

                            weep.loadUrl("https://roompayload5.blogspot.com/search?q=تطبيق");
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        return true;

                    //متجر
                    case R.id.myhom4:

                        hid();
                        if (seeadd == 0 | seeadd >= 10 ) {
                            seeadd = 0;
                            Toast.makeText(MainActivity.this, "اعلان", Toast.LENGTH_SHORT).show();

                            seeadd++;
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener() {

                                    public void onAdClosed() {
                                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                        weep.loadUrl("https://roompayload5.blogspot.com/search?q=شراء");
                                    }


                                });
                            } else {
                                weep.loadUrl("https://roompayload5.blogspot.com/search?q=شراء");
                                Log.d("TAG", "The interstitial wasn't loaded yet.");
                            }
                        }else {
                            seeadd++;

                            weep.loadUrl("https://roompayload5.blogspot.com/search?q=شراء");
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }


                        return true;


                }
                return false;

            }
        });
        ////////////اخفاء
        weep.setVisibility(View.GONE);
        mAdView.setVisibility(View.GONE);
        vv.setVisibility(View.GONE);
        vvv.setVisibility(View.GONE);
        witt.setVisibility(View.GONE);
        divv.setVisibility(View.GONE);
        namm.setVisibility(View.GONE);
        pass.setVisibility(View.GONE);
        pon.setVisibility(View.GONE);
        sw1.setVisibility(View.GONE);
        reff.setVisibility(View.GONE);
        sing.setVisibility(View.GONE);
        icostar.setVisibility(View.GONE);
        backk.setVisibility(View.GONE);

        sleepp.setVisibility(View.GONE);

        lay1.setVisibility(View.GONE);
        lay2.setVisibility(View.GONE);
        lay3.setVisibility(View.GONE);

        btoonhome.setVisibility(View.GONE);
        tt.setText("Room_payload5 \n"+BuildConfig.VERSION_NAME.toString());
        tt.setAnimation(aa);

////////////////انتظار صفحه البدايه
        new CountDownTimer(7000,1000){


            @Override
            public void onTick(long l) {

                //  ico.setAnimation(aa);
                witt.setVisibility(View.GONE);
                tt.setAnimation(aa);

            }

            @Override
            public void onFinish() {
                backk.setVisibility(View.VISIBLE);

                weep.setVisibility(View.VISIBLE);
                mAdView.setVisibility(View.VISIBLE);
                vv.setVisibility(View.VISIBLE);
                vvv.setVisibility(View.VISIBLE);
                btoonhome.setVisibility(View.VISIBLE);
                sw1.setVisibility(View.VISIBLE);
                icostar.setVisibility(View.VISIBLE);
                pon.setVisibility(View.VISIBLE);
                lay1.setVisibility(View.VISIBLE);
                lay2.setVisibility(View.VISIBLE);
                lay3.setVisibility(View.VISIBLE);

                tt.setVisibility(View.GONE);
                ico.setVisibility(View.GONE);

            }
        }.start();



    }
    int timmm=00;
    int iii = 0;
    void seead(){

        iii = 15;
        new CountDownTimer(15000,1000){


            @Override
            public void onTick(long l) {
                iii--;
                sleepp.setVisibility(View.VISIBLE);

                sleepp.setText(Integer.toString(iii));
                //  ico.setAnimation(aa);
                divv.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                divv.setVisibility(View.VISIBLE);
                sleepp.setVisibility(View.GONE);

            }
        }.start();


    }
/////لاظهار بينات المشاركين
    void reed() {
        testt="0";

      //  data();

        if (false){

        }else {

            String URLL =("https://alimax99xx.000webhostapp.com/payload5/see.php");

          //  divv.setVisibility(View.VISIBLE);

            requestQueuee = null;
            requestQueuee =  Volley.newRequestQueue(MainActivity.this);
            JSONObject jsonObject = null;
            aary = null;

            request = new JsonObjectRequest(
                    Request.Method.GET, URLL, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            arrayList.clear();
                            try {
                                divv.setVisibility(View.GONE);
                                aary = response.getJSONArray("alldata");
                                for (int i =0 ;i<aary.length();i++) {
                                    JSONObject jsonObject = aary.getJSONObject(i);
                                    namee = jsonObject.getString("name");
                                    point = jsonObject.getString("point");
                                    codd = jsonObject.getString("cod");
                                    int icoo = R.drawable.ic_baseline_person_24;

                                    if (codd.equals(pass.getText().toString().trim())){
                                        /////الملف الشخصي
                                        testt="1";
                                        divv.setVisibility(View.VISIBLE);

                                        poooo = point;
                                     //   icostar.setVisibility(View.VISIBLE);

                                        pon.setText(poooo);
                                        if (end.equals(poooo)){
                                            icoo = R.drawable.fass;
                                          //  arrayList.add(new NumbersView(R.drawable.fass,point, namee));

////////عند الفوز
                                            Toast.makeText(MainActivity.this, "انت الفائز", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                    if (codd.equals("alimax123456789@")){
                                        icoo = R.drawable.userr;
                                        //arrayList.add(new NumbersView(R.drawable.userr,point, namee));

                                        end = point;

                                    }


                                        pon.setText(poooo);

                                        //////////اضافه محتاويات ليست فيو
                                    arrayList.add(new NumbersView(icoo,point, namee));
///////////////////////////////////////////////////

                                }
                                tete();
                            } catch (JSONException e) {

                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, "تاكد من الانترنت", Toast.LENGTH_SHORT).show();

                        }
                    });
            ///////مسح الذاكره الموقته
            requestQueuee.add(request);
            requestQueuee.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
                @Override
                public void onRequestFinished(Request<Object> request) {
                    requestQueuee.getCache().clear();
                }
            });
////////////////////
        }

    }


/////////فتح ليست فيو////
    public void tete() {
        weep.setVisibility(View.GONE);
        ListView listVieww = (ListView) findViewById(R.id.listvv);

     //   arrayList.add(new NumbersView( "1", "One"));
        NumbersViewAdapter numbersArrayAdapter = new NumbersViewAdapter(MainActivity.this, arrayList);
        listVieww.setAdapter(numbersArrayAdapter);




    }
////////////////

///////////////////////////////صلحيه تخزين
    public void permission_Check(){
        //////////////////
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                return;
            }

        }
        SaveFile();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            SaveFile();
        }else{
            ///////////اخذ الصلحيه
            permission_Check();

        }
    }
    public void SaveFile(){
        ///هنا كود حفظ الملفات



    }
//////////////////////////////////////////////


    //booton home
    public void bt_Home(View view) {


        hid();
        if (seeadd == 0 | seeadd >= 10 ) {
            seeadd = 0;
            Toast.makeText(MainActivity.this, "اعلان", Toast.LENGTH_SHORT).show();

            seeadd++;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener(){

                public void onAdClosed() {
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    // Code to be executed when the interstitial ad is closed.
                    weep.loadUrl("https://roompayload5.blogspot.com");
                }


            });
        } else {
            weep.loadUrl("https://roompayload5.blogspot.com");
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        } else {
            seeadd++;

            weep.loadUrl("https://roompayload5.blogspot.com");
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

    }
    ///////////////////////////////////////////////////



    ///////////////////////////////////////////////////////

    void sing() {
      //  reed();
        String cccc = namm.getText().toString().trim();

        String ccc = pass.getText().toString().trim();
        if (ccc.equals("")|testt.equals("1")|cccc.equals("")){
            Toast.makeText(getBaseContext(), "موجود مسبقا", Toast.LENGTH_LONG).show();

        }else {
            pointt = Integer.parseInt(poooo)+15;
            String URLL =("https://alimax99xx.000webhostapp.com/payload5/ad.php?cod="+pass.getText()+"&name="+namm.getText()+"&point="+pointt).toString();


            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, URLL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //JSONObject obj = null;
                    try {
                        JSONObject obj = new JSONObject(response);
                        String ggg = obj.getString("success");
                        if (ggg == "true") {
                            Toast.makeText(getBaseContext(),"+15", Toast.LENGTH_LONG).show();
                            pon.setText(poooo);
                            reed();

                        }else if (ggg == "false"){

                            Toast.makeText(getBaseContext(),"+15", Toast.LENGTH_LONG).show();
                            pon.setText(poooo);
                            reed();

                        }else {

                            Toast.makeText(getBaseContext(),"تاكد من الانترنت", Toast.LENGTH_LONG).show();

                        }
                    } catch (JSONException e) {
                        Toast.makeText(getBaseContext(),"تاكد من الانترنت", Toast.LENGTH_LONG).show();

                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getBaseContext(),"تاكد من الانترنت", Toast.LENGTH_LONG).show();

                }
            });

            requestQueue.add(stringRequest);

        }

    }
    void send() {

        String ccc = pass.getText().toString().trim();
        if (ccc.equals("")|testt.equals("0")){
            Toast.makeText(getBaseContext(), "يجب ملي جميع الحقول", Toast.LENGTH_LONG).show();

        }else {
            pointt = Integer.parseInt(poooo)+15;

            String URLL =("https://alimax99xx.000webhostapp.com/payload5/ad.php?cod="+pass.getText()+"&name="+namm.getText()+"&point="+pointt).toString();


            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, URLL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //JSONObject obj = null;
                    try {
                        JSONObject obj = new JSONObject(response);
                        String ggg = obj.getString("success");
                        if (ggg == "true") {
                            Toast.makeText(getBaseContext(),"+15", Toast.LENGTH_LONG).show();
                            pon.setText(poooo);
                            reed();

                        }else if (ggg == "false"){

                            Toast.makeText(getBaseContext(),"+15", Toast.LENGTH_LONG).show();
                            pon.setText(poooo);
                            reed();

                        }else {

                            Toast.makeText(getBaseContext(),"تاكد من الانترنت", Toast.LENGTH_LONG).show();

                        }
                    } catch (JSONException e) {
                        Toast.makeText(getBaseContext(),"تاكد من الانترنت", Toast.LENGTH_LONG).show();

                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getBaseContext(),"تاكد من الانترنت", Toast.LENGTH_LONG).show();

                }
            });

            requestQueue.add(stringRequest);

        }

    }
    public void div(View view) {



        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();

        }else {
            Toast.makeText(getBaseContext(),"يتم تحميل الفيديو \n حاول مرة أخرى ",Toast.LENGTH_LONG).show();
            loadRewardedVideoAd();

        }

    }



    public void sww(View view) {
        String str1, str2;
        if (sw1.isChecked()) {
            str1 = sw1.getTextOn().toString();
            weep.setVisibility(View.GONE);
            divv.setVisibility(View.GONE);
            namm.setVisibility(View.VISIBLE);
            pass.setVisibility(View.VISIBLE);
            pon.setVisibility(View.VISIBLE);
            reff.setVisibility(View.VISIBLE);
            sing.setVisibility(View.VISIBLE);
           // icostar.setVisibility(View.GONE);

            reed();

        }
        else {
            str1 = sw1.getTextOff().toString();
            weep.setVisibility(View.VISIBLE);
            divv.setVisibility(View.GONE);
            reff.setVisibility(View.GONE);
            sing.setVisibility(View.GONE);
           // icostar.setVisibility(View.GONE);

        }

    }
    
    void hid(){

        weep.setVisibility(View.VISIBLE);
        divv.setVisibility(View.GONE);
        reff.setVisibility(View.GONE);
        sing.setVisibility(View.GONE);


    }


    public void refrsh(View view) {
        reed();
    }
    private void loadRewardedVideoAd() {
        if(!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd("ca-app-pub-6645174391699661/9663673774",
                    new AdRequest.Builder().build());
        }
    }
    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
       // Toast.makeText(this, "هنيئاً لك\n لقد أصبحت هذه الميزة متاحة الآن", Toast.LENGTH_SHORT).show();
        seead();

        send();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    public void sing(View view) {
        sing();
    }


    public void backkk(View view) {
        weep.goBack();
    }
}