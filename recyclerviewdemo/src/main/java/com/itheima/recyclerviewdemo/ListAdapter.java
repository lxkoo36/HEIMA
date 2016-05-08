package com.itheima.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*
 *  @项目名：  Heima5.0 
 *  @包名：    com.itheima.recyclerviewdemo
 *  @文件名:   ListAdapter
 *  @创建者:   肖琦
 *  @创建时间:  2015/5/21 16:39
 *  @描述：    TODO
 */
public class ListAdapter
        extends RecyclerView.Adapter<ListAdapter.ListHolder>
{
    private Context        mContext;
    private List<DataBean> mDatas;

    public ListAdapter(Context context,
                       List<DataBean> datas)
    {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup viewGroup,
                                         int i)
    {
        //当itemview创建时的回调
        View view = View.inflate(mContext,
                                 R.layout.item_list,
                                 null);

        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder listHolder,
                                 int i)
    {
        //正在加载某个view的时候的回调
        listHolder.setData(mDatas.get(i));
    }

    @Override
    public int getItemCount()
    {
        //返回list有多少数据
        if (mDatas != null) { return mDatas.size(); }
        return 0;
    }

    public class ListHolder
            extends RecyclerView.ViewHolder
    {
        ImageView iv;
        TextView tv;
        public ListHolder(View itemView)
        {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.item_list_iv);
            tv = (TextView) itemView.findViewById(R.id.item_list_tv);
        }

        public void setData(DataBean bean)
        {
            iv.setImageResource(bean.icon);
            tv.setText(bean.content);
        }
    }
}
