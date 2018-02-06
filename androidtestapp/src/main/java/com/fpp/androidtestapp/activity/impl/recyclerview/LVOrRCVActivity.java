package com.fpp.androidtestapp.activity.impl.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.adapter.order.AddGoodsCategoryAdapter;
import com.fpp.androidtestapp.entity.GoodsCategory;
import com.fpp.androidtestapp.entity.GoodsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fupengpeng
 * @description listview嵌套recycleview
 * @date 2018/2/5 0005 17:27
 */
public class LVOrRCVActivity extends AppCompatActivity {


    /**
     * 添加服务项和商品项数据----接收数据
     */
    List<GoodsItem> addGoodsItemListNum = new ArrayList<GoodsItem>();
    @BindView(R.id.lv_fragment_add_goods_item)
    ListView lvFragmentAddGoodsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvor_rcv);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        AddGoodsCategoryAdapter addGoodsCategoryAdapter = new AddGoodsCategoryAdapter(this,getData());
        lvFragmentAddGoodsItem.setAdapter(addGoodsCategoryAdapter);
        

    }
    
    
    /**
     * 设置数据
     *
     * @return
     */
    public List<GoodsCategory> getData() {
        List<GoodsCategory> goodsCategoryList = new ArrayList<GoodsCategory>();

        //护理类
        GoodsCategory GoodsCategoryOne = new GoodsCategory();
        GoodsCategoryOne.setGoodscategoryid("1");
        GoodsCategoryOne.setGoodscategoryname("护理类");
        List<GoodsItem> goodsItemsOne = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("倒膜" + j);
            goodsItem.setDiscount("0");
            goodsItemsOne.add(goodsItem);
        }
        GoodsCategoryOne.setGoodslist(goodsItemsOne);
        goodsCategoryList.add(GoodsCategoryOne);

        //美容类
        GoodsCategory GoodsCategoryTwo = new GoodsCategory();
        GoodsCategoryTwo.setGoodscategoryid("2");
        GoodsCategoryTwo.setGoodscategoryname("美容类");
        List<GoodsItem> goodsItemsTwo = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("修眉" + j);
            goodsItem.setDiscount("0");
            goodsItemsTwo.add(goodsItem);
        }
        GoodsCategoryTwo.setGoodslist(goodsItemsTwo);
        goodsCategoryList.add(GoodsCategoryTwo);

        //基础项目
        GoodsCategory GoodsCategoryThree = new GoodsCategory();
        GoodsCategoryThree.setGoodscategoryid("3");
        GoodsCategoryThree.setGoodscategoryname("基础项目");
        List<GoodsItem> goodsItemsThree = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("洗吹" + j);
            goodsItem.setDiscount("0");
            goodsItemsThree.add(goodsItem);
        }
        GoodsCategoryThree.setGoodslist(goodsItemsThree);
        goodsCategoryList.add(GoodsCategoryThree);

        //烫发类
        GoodsCategory GoodsCategoryFour = new GoodsCategory();
        GoodsCategoryFour.setGoodscategoryid("4");
        GoodsCategoryFour.setGoodscategoryname("烫发类");
        List<GoodsItem> goodsItemsFour = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("烫发" + j);
            goodsItem.setDiscount("0");
            goodsItemsFour.add(goodsItem);
        }
        GoodsCategoryFour.setGoodslist(goodsItemsFour);
        goodsCategoryList.add(GoodsCategoryFour);

        //染发类
        GoodsCategory GoodsCategoryFive = new GoodsCategory();
        GoodsCategoryFive.setGoodscategoryid("5");
        GoodsCategoryFive.setGoodscategoryname("染发类");
        List<GoodsItem> goodsItemsFive = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("染发" + j);
            goodsItem.setDiscount("0");
            goodsItemsFive.add(goodsItem);
        }
        GoodsCategoryFive.setGoodslist(goodsItemsFive);
        goodsCategoryList.add(GoodsCategoryFive);

        //染发类
        GoodsCategory GoodsCategoryF = new GoodsCategory();
        GoodsCategoryF.setGoodscategoryid("5");
        GoodsCategoryF.setGoodscategoryname("染发类f");
        List<GoodsItem> goodsItemsF = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("染发f" + j);
            goodsItem.setDiscount("0");
            goodsItemsF.add(goodsItem);
        }
        GoodsCategoryF.setGoodslist(goodsItemsF);
        goodsCategoryList.add(GoodsCategoryF);

        //染发类
        GoodsCategory GoodsCategorySix = new GoodsCategory();
        GoodsCategorySix.setGoodscategoryid("5");
        GoodsCategorySix.setGoodscategoryname("染发类6");
        List<GoodsItem> goodsItemsSix = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("染发6" + j);
            goodsItem.setDiscount("0");
            goodsItemsSix.add(goodsItem);
        }
        GoodsCategorySix.setGoodslist(goodsItemsSix);
        goodsCategoryList.add(GoodsCategorySix);

        //染发类
        GoodsCategory GoodsCategorySeven = new GoodsCategory();
        GoodsCategorySeven.setGoodscategoryid("5");
        GoodsCategorySeven.setGoodscategoryname("染发类7");
        List<GoodsItem> goodsItemsSeven = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("染发7" + j);
            goodsItem.setDiscount("0");
            goodsItemsSeven.add(goodsItem);
        }
        GoodsCategorySeven.setGoodslist(goodsItemsSeven);
        goodsCategoryList.add(GoodsCategorySeven);

        //染发类
        GoodsCategory GoodsCategoryEight = new GoodsCategory();
        GoodsCategoryEight.setGoodscategoryid("5");
        GoodsCategoryEight.setGoodscategoryname("染发类8");
        List<GoodsItem> goodsItemsEight = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("染发8" + j);
            goodsItem.setDiscount("0");
            goodsItemsEight.add(goodsItem);
        }
        GoodsCategoryEight.setGoodslist(goodsItemsEight);
        goodsCategoryList.add(GoodsCategoryEight);

        //染发类
        GoodsCategory GoodsCategoryNine = new GoodsCategory();
        GoodsCategoryNine.setGoodscategoryid("5");
        GoodsCategoryNine.setGoodscategoryname("染发类9");
        List<GoodsItem> goodsItemsNine = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("染发9" + j);
            goodsItem.setDiscount("0");
            goodsItemsNine.add(goodsItem);
        }
        GoodsCategoryNine.setGoodslist(goodsItemsNine);
        goodsCategoryList.add(GoodsCategoryNine);

        //染发类
        GoodsCategory GoodsCategoryEleven = new GoodsCategory();
        GoodsCategoryEleven.setGoodscategoryid("5");
        GoodsCategoryEleven.setGoodscategoryname("染发类11");
        List<GoodsItem> goodsItemsEleven = new ArrayList<GoodsItem>();
        for (int j = 0; j < 10; j++) {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setSaleprice("12.00");
            goodsItem.setGoodsname("染发11" + j);
            goodsItem.setDiscount("0");
            goodsItemsEleven.add(goodsItem);
        }
        GoodsCategoryEleven.setGoodslist(goodsItemsEleven);
        goodsCategoryList.add(GoodsCategoryEleven);


        return goodsCategoryList;
    }


    public List<GoodsItem> getAddGoodsItemListNum() {
        return addGoodsItemListNum;
    }

    public void setAddGoodsItemListNum(List<GoodsItem> addGoodsItemListNum) {
        this.addGoodsItemListNum = addGoodsItemListNum;
    }
}
