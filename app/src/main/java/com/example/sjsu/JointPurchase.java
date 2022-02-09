package com.example.sjsu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

public class JointPurchase extends AppCompatActivity {
    private SearchView purchaseSearch;
    articleAdapter articleAdapter;
    ImageButton backButton;



    Dialog dialog1;
    GridView gridView1;
    View dialogView;

    String[] items={"1", "2", "3"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joint_purchase);



        // 그리드 뷰
        gridView1 = (GridView) findViewById(R.id.articleGrid1);

        articleAdapter = new articleAdapter();
        articleAdapter.addItem(new articleItem("Tissue", "4/5", "$5", R.drawable.image1));
        articleAdapter.addItem(new articleItem("Laundry detergent", "3/10","$10", R.drawable.image2));
        articleAdapter.addItem(new articleItem("Fabric softener", "1/5","$7.3", R.drawable.image3));
        articleAdapter.addItem(new articleItem("Snack set", "1/10", "$5.1",R.drawable.image4));


        gridView1.setAdapter(articleAdapter);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(
                        getApplicationContext(), // 현재화면의 제어권자
                        purchase_detail.class); // 다음넘어갈 화면


                startActivity(intent);
                Handler timeHandler = new Handler();
                timeHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        articleAdapter = new articleAdapter();
                        articleAdapter.addItem(new articleItem("Tissue", "5/5", "$5", R.drawable.image1));
                        articleAdapter.addItem(new articleItem("Laundry detergent", "3/10","$10", R.drawable.image2));
                        articleAdapter.addItem(new articleItem("Fabric softener", "1/5","$7.3", R.drawable.image3));
                        articleAdapter.addItem(new articleItem("Snack set", "1/10", "$5.1",R.drawable.image4));
                        articleAdapter.addItem(new articleItem("Mask", "1/10", "$2",R.drawable.image5));


                        gridView1.setAdapter(articleAdapter);
                    }
                }, 500);


            }
        });


        //다이얼 로그
        dialog1 = new Dialog(JointPurchase.this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.dialog);

        findViewById(R.id.suggestButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1();
            }
        });

        //뒤로가기 버튼
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }



    // 그리드 어댑터
    class articleAdapter extends BaseAdapter{
        ArrayList<articleItem> items = new ArrayList<articleItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(articleItem articleItem){
            items.add(articleItem);
        }

        @Override
        public articleItem getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            articleViewer articleViewer = new articleViewer(getApplicationContext());
            articleViewer.setItem(items.get(i));
            return articleViewer;
        }
    }




    // 다이얼로그 기능
    public void dialog1(){
        dialog1.show();


        Button noBtn = dialog1.findViewById(R.id.cancel);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });
        // 네 버튼
        Button yesBtn = dialog1.findViewById(R.id.suggest);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articleAdapter = new articleAdapter();
                articleAdapter.addItem(new articleItem("Tissue", "4/5", "$5", R.drawable.image1));
                articleAdapter.addItem(new articleItem("Laundry detergent", "3/10","$10", R.drawable.image2));
                articleAdapter.addItem(new articleItem("Fabric softener", "1/5","$7.3", R.drawable.image3));
                articleAdapter.addItem(new articleItem("Snack set", "1/10", "$5.1",R.drawable.image4));
                articleAdapter.addItem(new articleItem("Mask", "1/10", "$2",R.drawable.image5));
                gridView1.setAdapter(articleAdapter);
                dialog1.dismiss();
            }
        });
    }


}