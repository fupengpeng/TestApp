package com.fpp.androidtestapp.activity.impl.adapterview;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableListViewActivity extends AppCompatActivity {

    @BindView(R.id.list)
    ExpandableListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ButterKnife.bind(this);

        initView();


    }

    private void initView() {
        ExpandableListAdapter adapter = new ExpandableListAdapter() {

            int[] logos = new int[]{
                    R.drawable.shilipic,
                    R.drawable.shilipic,
                    R.drawable.shilipic
            };
            private  String[] armTypes = new String[]{
                    "神族兵种",
                    "虫族兵种",
                    "人族兵种"
            };
            private String [][] arms = new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","点兵"},
                    {"小狗","小猫","小马","小龙"},
                    {"机枪手","护士MM","幽灵","吸血鬼"},
            };


            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            /**
             * 获取指定位置、指定列表项处的子列表数据
             * @param i
             * @param i1
             * @return
             */
            @Override
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView = getTextView();
                textView.setText(getChild(i,i1).toString());
                return textView;
            }


            /**
             * 获取指定组位置处的组数据
             * @param i
             * @return
             */
            @Override
            public Object getGroup(int i) {
                return armTypes[i];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            private TextView getTextView(){
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView = new TextView(ExpandableListViewActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);
                return textView;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout ll = new LinearLayout(ExpandableListViewActivity.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ImageView logo = new ImageView(ExpandableListViewActivity.this);
                logo.setImageResource(logos[i]);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(i).toString());
                ll.addView(textView);
                return null;
            }






            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int i) {

            }

            @Override
            public void onGroupCollapsed(int i) {

            }

            @Override
            public long getCombinedChildId(long l, long l1) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long l) {
                return 0;
            }


        };

        list.setAdapter(adapter);




    }
}
