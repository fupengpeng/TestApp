package com.fpp.androidtestapp.model.impl;

import android.graphics.Bitmap;

import com.alibaba.fastjson.JSON;
import com.fpp.androidtestapp.application.MyApplication;
import com.fpp.androidtestapp.common.Consts;
import com.fpp.androidtestapp.common.ListCallBack;
import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.GoodsCategory;
import com.fpp.androidtestapp.entity.LoadOrderListResponseData;
import com.fpp.androidtestapp.entity.Member;
import com.fpp.androidtestapp.entity.OrderItem;
import com.fpp.androidtestapp.entity.SelectOrderItem;
import com.fpp.androidtestapp.entity.ServiceCategory;
import com.fpp.androidtestapp.entity.response.AddOrderServiceAndGoodsItemResponse;
import com.fpp.androidtestapp.entity.response.CreateMemberResponse;
import com.fpp.androidtestapp.entity.response.CreateOrderResponse;
import com.fpp.androidtestapp.entity.response.DeleteOrderServiceAndGoodsItemResponse;
import com.fpp.androidtestapp.entity.response.GetMemberSearchListResponse;
import com.fpp.androidtestapp.entity.response.LoadGoodsItemListResponse;
import com.fpp.androidtestapp.entity.response.LoadOrderDetailResponse;
import com.fpp.androidtestapp.entity.response.LoadOrderListResponse;
import com.fpp.androidtestapp.entity.response.LoadServiceItemListResponse;
import com.fpp.androidtestapp.entity.response.SendSMSResponse;
import com.fpp.androidtestapp.entity.response.UploadImageResponse;
import com.fpp.androidtestapp.model.interf.IOrderModel;
import com.fpp.androidtestapp.util.BitmapUtils;
import com.fpp.androidtestapp.util.DateUtils;
import com.fpp.androidtestapp.util.MD5Util;
import com.fpp.androidtestapp.util.SPUtils;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

import java.util.List;

/**
 * 服务单业务
 */
public class OrderModel implements IOrderModel {
    /**
     * 请求队列
     */
    private static RequestQueue requestQueue = NoHttp.newRequestQueue(3);

    /**
     * 上传图片
     *
     * @param bitmap   图片
     * @param callBack 上传后的url
     */
    @Override
    public void uploadImage(Bitmap bitmap, final ObjectCallBack<String> callBack){
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "upfile";
        request.add("a", a);
        request.add("imagecontent", BitmapUtils.bitmap2StrByBase64(bitmap));
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                UploadImageResponse uploadImageResponse
                        = JSON.parseObject(result, UploadImageResponse.class);
                // 判断是否成功
                if (uploadImageResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(uploadImageResponse.getData());
                } else { // 失败
                    Exception e = new Exception(uploadImageResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 发送验证码
     *
     * @param mobile   手机号
     * @param callBack 成功信息
     */
    @Override
    public void sendSMS(String mobile, final ObjectCallBack<String> callBack){
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "smssend";
        request.add("a", a);
        request.add("mobile", mobile);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                SendSMSResponse uploadImageResponse
                        = JSON.parseObject(result, SendSMSResponse.class);
                // 判断是否成功
                if (uploadImageResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(uploadImageResponse.getData());
                } else { // 失败
                    Exception e = new Exception(uploadImageResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 创建会员
     *
     * @param member   会员信息
     * @param callBack 生成的会员ID
     */
    @Override
    public void createMember(Member member, final ObjectCallBack<String> callBack){
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "addmember";
        request.add("a", a);

        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                CreateMemberResponse createMemberResponse
                        = JSON.parseObject(result, CreateMemberResponse.class);
                // 判断是否成功
                if (createMemberResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(createMemberResponse.getData());
                } else { // 失败
                    Exception e = new Exception(createMemberResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 检索会员信息【列表】
     *
     * @param mid  会员平台ID,可扫码获得,注意去除“”mid:
     * @param key  会员信息关键字，手机号、姓名及拼音等均可
     * @param callBack 成功提示
     */
    @Override
    public void getMemberSearchList(String mid, String key,final ListCallBack<Member> callBack){
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "GetMemberSearchList";
        request.add("a", a);
        request.add("mid", mid);
        request.add("key", key);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                GetMemberSearchListResponse getMemberSearchListResponse
                        = JSON.parseObject(result, GetMemberSearchListResponse.class);
                // 判断是否成功
                if (getMemberSearchListResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(getMemberSearchListResponse.getData());
                } else { // 失败
                    Exception e = new Exception(getMemberSearchListResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 删除订单服务项目及商品
     *
     * @param opid     要删除的项目ID
     * @param callBack 成功提示
     */
    @Override
    public void deleteOrderServiceAndGoodsItem(String opid, final ObjectCallBack<String> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "delorderproject";
        request.add("a", a);
        request.add("opid", opid);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                DeleteOrderServiceAndGoodsItemResponse deleteOrderServiceAndGoodsItemResponse
                        = JSON.parseObject(result, DeleteOrderServiceAndGoodsItemResponse.class);
                // 判断是否成功
                if (deleteOrderServiceAndGoodsItemResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(deleteOrderServiceAndGoodsItemResponse.getData());
                } else { // 失败
                    Exception e = new Exception(deleteOrderServiceAndGoodsItemResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 添加订单服务项目及商品
     *
     * @param orderId  订单ID
     * @param items    选定的项目及商品集合
     * @param callBack 成功提示
     */
    @Override
    public void addOrderServiceAndGoodsItem(String orderId, List<SelectOrderItem> items,
                                            final ObjectCallBack<String> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "addorderproject";
        request.add("a", a);
        request.add("orderid", orderId);
        request.add("project", JSON.toJSONString(items));
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                AddOrderServiceAndGoodsItemResponse addOrderServiceAndGoodsItemResponse
                        = JSON.parseObject(result, AddOrderServiceAndGoodsItemResponse.class);
                // 判断是否成功
                if (addOrderServiceAndGoodsItemResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(addOrderServiceAndGoodsItemResponse.getData());
                } else { // 失败
                    Exception e = new Exception(addOrderServiceAndGoodsItemResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 加载服务项目列表
     *
     * @param mid      会员ID,用于获取优惠额度；为0则为散客
     * @param callBack 服务分类列表（分类中包含服务项目列表）
     */
    @Override
    public void loadServiceItemList(String mid, final ListCallBack<ServiceCategory> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "ServiceItemList";
        request.add("a", a);
        request.add("mid", mid);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoadServiceItemListResponse loadServiceItemListResponse = JSON.parseObject(result, LoadServiceItemListResponse.class);
                // 判断是否成功
                if (loadServiceItemListResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadServiceItemListResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadServiceItemListResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 加载商品项目列表
     *
     * @param mid      会员ID,用于获取优惠额度；为0则为散客
     * @param callBack 商品分类列表（分类中包含商品项目列表）
     */
    @Override
    public void loadGoodsItemList(String mid, final ListCallBack<GoodsCategory> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "GoodsItemList";
        request.add("a", a);
        request.add("mid", mid);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoadGoodsItemListResponse loadGoodsItemListResponse = JSON.parseObject(result, LoadGoodsItemListResponse.class);
                // 判断是否成功
                if (loadGoodsItemListResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadGoodsItemListResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadGoodsItemListResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 创建订单
     *
     * @param mid      会员ID；为0则为散客
     * @param taking   "0":开单但没有接单人；"1":开单并自动接单
     * @param callBack 订单ID
     */
    @Override
    public void createOrder(String mid, String taking, final ObjectCallBack<String> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "addorder";
        request.add("a", a);
        request.add("msid", mid);
        request.add("taking", taking);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                CreateOrderResponse createOrderResponse = JSON.parseObject(result, CreateOrderResponse.class);
                // 判断是否成功
                if (createOrderResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(createOrderResponse.getData());
                } else { // 失败
                    Exception e = new Exception(createOrderResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 加载订单详情
     *
     * @param orderId  订单ID
     * @param callBack 订单详情
     */
    @Override
    public void loadOrderDetail(String orderId, final ObjectCallBack<OrderItem> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "orderinfo";
        request.add("a", a);
        request.add("orderid", orderId);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoadOrderDetailResponse loadOrderDetailResponse = JSON.parseObject(result, LoadOrderDetailResponse.class);
                // 判断是否成功
                if (loadOrderDetailResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadOrderDetailResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadOrderDetailResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 加载订单列表
     *
     * @param state    状态：0.全部，1.待接单，2.服务中，8.已完成,9.已取消
     * @param page     页码
     * @param count    每页返回结果数量
     * @param callBack 订单列表
     */
    @Override
    public void loadOrderList(int state, int page, int count,
                              final ObjectCallBack<LoadOrderListResponseData> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        String a = "order";
        request.add("a", a);
        request.add("state", state);
        request.add("page", page);
        request.add("count", count);
        // 请求的公共参数
        requestCommonPerm(a, request);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoadOrderListResponse loadOrderListResponse = JSON.parseObject(result, LoadOrderListResponse.class);
                // 判断是否成功
                if (loadOrderListResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loadOrderListResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loadOrderListResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

    /**
     * 请求的公共参数
     *
     * @param a       操作
     * @param request 请求
     */
    private void requestCommonPerm(String a, Request<String> request) {
        // 获取公共数据
        String userId = MyApplication.getInstance().getUser().getId();
        String sessionId = (String) SPUtils.get(MyApplication.getInstance(), Consts.SESSION, "x");
        String shopId = MyApplication.getInstance().getCurrShop().getId();

        request.add("shopId", shopId);
        request.add("userId", userId);
        request.add("sessionId", sessionId);
        request.add("token", MD5Util.getMD5(sessionId + shopId + userId + a
                + "<*?hello.Kaiyuan.com//" + DateUtils.getCurrDate()));
    }
}
