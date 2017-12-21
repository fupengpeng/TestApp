package com.fpp.androidtestapp.model.interf;

import android.graphics.Bitmap;

import com.fpp.androidtestapp.common.ListCallBack;
import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.GoodsCategory;
import com.fpp.androidtestapp.entity.LoadOrderListResponseData;
import com.fpp.androidtestapp.entity.Member;
import com.fpp.androidtestapp.entity.OrderItem;
import com.fpp.androidtestapp.entity.SelectOrderItem;
import com.fpp.androidtestapp.entity.ServiceCategory;

import java.util.List;

/**
 * 服务单业务接口
 */
public interface IOrderModel {

    /**
     * 上传图片
     *
     * @param bitmap   图片
     * @param callBack 上传后的url
     */
    void uploadImage(Bitmap bitmap, final ObjectCallBack<String> callBack);

    /**
     * 发送验证码
     *
     * @param mobile   手机号
     * @param callBack 成功信息
     */
    void sendSMS(String mobile, final ObjectCallBack<String> callBack);

    /**
     * 创建会员
     *
     * @param member   会员信息
     * @param callBack 生成的会员ID
     */
    void createMember(Member member, final ObjectCallBack<String> callBack);

    /**
     * 检索会员信息【列表】
     *
     * @param mid      会员平台ID,可扫码获得,注意去除“”mid:
     * @param key      会员信息关键字，手机号、姓名及拼音等均可
     * @param callBack 成功提示
     */
    void getMemberSearchList(String mid, String key, final ListCallBack<Member> callBack);

    /**
     * 删除订单服务项目及商品
     *
     * @param opid     要删除的项目ID
     * @param callBack 成功提示
     */
    void deleteOrderServiceAndGoodsItem(String opid, final ObjectCallBack<String> callBack);

    /**
     * 添加订单服务项目及商品
     *
     * @param orderId  订单ID
     * @param items    选定的项目及商品集合
     * @param callBack 成功提示
     */
    void addOrderServiceAndGoodsItem(String orderId, List<SelectOrderItem> items, final ObjectCallBack<String> callBack);

    /**
     * 加载服务项目列表
     *
     * @param mid      会员ID,用于获取优惠额度；为0则为散客
     * @param callBack 服务分类列表（分类中包含服务项目列表）
     */
    void loadServiceItemList(String mid, final ListCallBack<ServiceCategory> callBack);

    /**
     * 加载商品项目列表
     *
     * @param mid      会员ID,用于获取优惠额度；为0则为散客
     * @param callBack 商品分类列表（分类中包含商品项目列表）
     */
    void loadGoodsItemList(String mid, final ListCallBack<GoodsCategory> callBack);

    /**
     * 创建订单
     *
     * @param mid      会员ID；为0则为散客
     * @param taking   "0":开单但没有接单人；"1":开单并自动接单
     * @param callBack 订单ID
     */
    void createOrder(String mid, String taking, final ObjectCallBack<String> callBack);

    /**
     * 加载订单详情
     *
     * @param orderId  订单ID
     * @param callBack 订单详情
     */
    void loadOrderDetail(String orderId, final ObjectCallBack<OrderItem> callBack);

    /**
     * 加载订单列表
     *
     * @param state    状态：0.全部，1.待接单，2.服务中，8.已完成,9.已取消
     * @param page     页码
     * @param count    每页返回结果数量
     * @param callBack 订单列表
     */
    void loadOrderList(int state, int page, int count,
                       final ObjectCallBack<LoadOrderListResponseData> callBack);
}
