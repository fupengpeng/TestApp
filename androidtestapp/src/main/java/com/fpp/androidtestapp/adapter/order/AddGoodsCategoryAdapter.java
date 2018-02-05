package com.fpp.androidtestapp.adapter.order;

/**
 * @author fupengpeng
 * @description 添加商品条目分类列表
 * @date 2017/12/20 0020 19:58
 */

public class AddGoodsCategoryAdapter
//        extends BaseAdapter
{
//    // context（依附的Activity）
//    private LVOrRCVActivity mAddServiceOrCommodityActivity;
//    // 数据列表
//    List<GoodsCategory> serviceCategoryList;
//
//    private LayoutInflater mInflater = null;
//
//    public AddGoodsCategoryAdapter(LVOrRCVActivity mAddServiceOrCommodityActivity, List<GoodsCategory> serviceCategoryList) {
//        //根据context上下文加载布局，这里的是Demo17Activity本身，即this
//        this.mInflater = LayoutInflater.from(mAddServiceOrCommodityActivity);
//        this.mAddServiceOrCommodityActivity = mAddServiceOrCommodityActivity;
//        this.serviceCategoryList = serviceCategoryList;
//    }
//
//    @Override
//    public int getCount() {
//        //How many items are in the data set represented by this Adapter.
//        //在此适配器中所代表的数据集中的条目数
//        return serviceCategoryList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        // Get the data item associated with the specified position in the data set.
//        //获取数据集中与指定索引对应的数据项
//        return serviceCategoryList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        //Get the row id associated with the specified position in the list.
//        //获取在列表中与指定索引对应的行id
//        return position;
//    }
//
//    //Get a View that displays the data at the specified position in the data set.
//    //获取一个在数据集中指定索引的视图来显示数据
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder = null;
//        //如果缓存convertView为空，则需要创建View
//        if (convertView == null) {
//            holder = new ViewHolder();
//            //根据自定义的Item布局加载布局
//            convertView = mInflater.inflate(R.layout.list_view_item_select_soc_content, null);
//            holder.tvLvItemSelectSocContentId = (TextView) convertView.findViewById(R.id.tv_lv_item_select_soc_content_id);
//            holder.tvLvItemSelectSocContentName = (TextView) convertView.findViewById(R.id.tv_lv_item_select_soc_content_name);
//
//            holder.hlvFragmentAddService = convertView.findViewById(R.id.hlv_fragment_add_service);
//            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        // 品项分类设置
//        holder.tvLvItemSelectSocContentId.setText(serviceCategoryList.get(position).getGoodscategoryid() + ".");
//        holder.tvLvItemSelectSocContentName.setText(serviceCategoryList.get(position).getGoodscategoryname());
//        // 获取品项分类数据
//        final List<GoodsItem> goodsItemList = serviceCategoryList.get(position).getGoodslist();
//        // 设置从订单详情跳转过来时，已有的品项数量
//        if (goodsItemList != null) {
//            for (GoodsItem goodsItem : goodsItemList) {
//                if (mAddServiceOrCommodityActivity.getAddGoodsItemListNum() != null) {
//                    for (GoodsItem goodsitem : mAddServiceOrCommodityActivity.getAddGoodsItemListNum()) {
//                        if (goodsItem.getGoodsid().equals(goodsitem.getGoodsid())) {
//                            goodsItem.setAcuid(goodsitem.getAcuid());
//                            goodsItem.setAcstate(goodsitem.getAcstate());
//                            goodsItem.setNum(goodsitem.getNum());
//                        }
//                    }
//                }
//            }
//        }
//        final AddGoodsItemAdapter addGoodsItemAdapter = new AddGoodsItemAdapter(mAddServiceOrCommodityActivity, goodsItemList);
//        holder.hlvFragmentAddService.setAdapter(addGoodsItemAdapter);
//        //添加服务按钮点击事件
//        addGoodsItemAdapter.setOnItemDeleteClickListener(new AddGoodsItemAdapter.OnItemDeleteListener() {
//            @Override
//            public void onDeleteClick(int position, AddGoodsItemAdapter.ViewHolder holder) {
//                GoodsItem item = addGoodsItemAdapter.getItem(position);
//                LogUtils.e("acuid = " + item.getAcuid());
//                if (MyApplication.getInstance().getUser().getId().equals(item.getAcuid()) | item.getAcuid() == null) {
//                    deleteServiceItem(position, holder, addGoodsItemAdapter, goodsItemList);
//                    getServiceItemNumList();
//                    transferData();
//                } else {
//                    ToastUtils.showLong(mAddServiceOrCommodityActivity, "你无权操作该项目！");
//                }
//            }
//        });
//        //减少服务按钮点击事件
//        addGoodsItemAdapter.setOnItemAddClickListener(new AddGoodsItemAdapter.OnItemAddListener() {
//            @Override
//            public void onAddClick(int position, AddGoodsItemAdapter.ViewHolder holder) {
//                GoodsItem item = addGoodsItemAdapter.getItem(position);
//                LogUtils.e("acuid = " + item.getAcuid());
//                if (MyApplication.getInstance().getUser().getId().equals(item.getAcuid()) | item.getAcuid() == null) {
//                    addServiceItem(position, holder, addGoodsItemAdapter, goodsItemList);
//                    getServiceItemNumList();
//                    transferData();
//                } else {
//                    ToastUtils.showLong(mAddServiceOrCommodityActivity, "你无权操作该项目！");
//                }
//            }
//        });
//        return convertView;
//    }
//
//    static class ViewHolder {
//        TextView tvLvItemSelectSocContentId;
//        TextView tvLvItemSelectSocContentName;
//        RecyclerView hlvFragmentAddService;
//
//    }
//
//    /**
//     * 统计此分类的选定的数据--筛选选定的项目，统计出来
//     */
//    private void getServiceItemNumList() {
//
//        if (mAddServiceOrCommodityActivity.getAddGoodsItemListNum() != null) {
//            mAddServiceOrCommodityActivity.getAddGoodsItemListNum().clear();
//        }
//        for (GoodsCategory goodsCategory : serviceCategoryList) {
//            List<GoodsItem> goodsItems = goodsCategory.getGoodslist();
//            for (GoodsItem goodsItem : goodsItems) {
//                if (goodsItem.getNum() > 0) {
//                    LogUtils.e("goodsItem.getNum(); = " + goodsItem.getNum() + " -- acuid -- " + goodsItem.getAcuid());
//                    mAddServiceOrCommodityActivity.getAddGoodsItemListNum().add(goodsItem);
//                }
//
//            }
//        }
//
//    }
//
//    /**
//     * 给依附的activity传递服务数据
//     */
//    private void transferData() {
//        mAddServiceOrCommodityActivity.receiveDataCommodity();
//    }
//
//    /**
//     * 添加
//     *
//     * @param position            第position个子条目
//     * @param holder              子条目的布局
//     * @param addGoodsItemAdapter 使用到的数据适配器
//     * @param goodsItems          布局所要添加的数据
//     */
//    private void addServiceItem(int position, AddGoodsItemAdapter.ViewHolder holder, AddGoodsItemAdapter addGoodsItemAdapter, List<GoodsItem> goodsItems) {
//        GoodsItem item = addGoodsItemAdapter.getItem(position);
//        int number;
//        if (item.getNum() <= 0) {
//            number = 0;
//            number++;
//            holder.ivLvItemSelectServiceRemove.setVisibility(View.VISIBLE);
//            holder.tvLvItemSelectServiceAdd.setText(number + "");
//        } else {
//            number = item.getNum();
//            number++;
//
//        }
//        holder.tvLvItemSelectServiceAdd.setText(number + "");
//        holder.ivLvItemSelectServiceRemove.setVisibility(View.VISIBLE);
//        goodsItems.get(position).setNum(number);
//        goodsItems.get(position).setAcuid(addGoodsItemAdapter.getItem(position).getAcuid());
//        goodsItems.get(position).setAcstate(addGoodsItemAdapter.getItem(position).getAcstate());
//        addGoodsItemAdapter.notifyDataSetChanged();
//    }
//
//    /**
//     * 减少
//     *
//     * @param position            第position个子条目
//     * @param holder              子条目的布局
//     * @param addGoodsItemAdapter 使用到的数据适配器
//     * @param goodsItems          布局所要添加的数据
//     */
//    private void deleteServiceItem(int position, AddGoodsItemAdapter.ViewHolder holder, AddGoodsItemAdapter addGoodsItemAdapter, List<GoodsItem> goodsItems) {
//        GoodsItem item = addGoodsItemAdapter.getItem(position);
//        int number = item.getNum();
//        if (number <= 1) {
//            holder.ivLvItemSelectServiceRemove.setVisibility(View.VISIBLE);
//            holder.ivLvItemSelectServiceAdd.setImageResource(R.drawable.order_add_item);
//        }
//        number--;
//        holder.tvLvItemSelectServiceAdd.setText(number + "");
//        goodsItems.get(position).setNum(number);
//        goodsItems.get(position).setAcuid(addGoodsItemAdapter.getItem(position).getAcuid());
//        goodsItems.get(position).setAcstate(addGoodsItemAdapter.getItem(position).getAcstate());
//        addGoodsItemAdapter.notifyDataSetChanged();
//    }

}
