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
 *  @文件名:   StraggerdAdpater
 *  @创建者:   肖琦
 *  @创建时间:  2015/5/21 17:02
 *  @描述：    TODO
 */
public class StraggerdAdpater
        extends RecyclerView.Adapter<StraggerdAdpater.StraggerdHolder>
{

    private List<DataBean> mDatas;
    private Context        mContext;

    public StraggerdAdpater(Context context,
                            List<DataBean> datas)
    {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public StraggerdAdpater.StraggerdHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType)
    {
        View view = View.inflate(mContext,
                                 R.layout.item_straggered,
                                 null);

        return new StraggerdHolder(view);
    }

    @Override
    public void onBindViewHolder(StraggerdAdpater.StraggerdHolder holder,
                                 int position)
    {
        holder.setData(mDatas.get(position));
    }

    @Override
    public int getItemCount()
    {
        if (mDatas != null) { return mDatas.size(); }
        return 0;
    }

    public class StraggerdHolder
            extends RecyclerView.ViewHolder
    {
        ImageView iv;
        TextView  tv;

        public StraggerdHolder(View itemView)
        {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.item_straggered_iv);
            tv = (TextView) itemView.findViewById(R.id.item_straggered_tv);
        }

        public void setData(DataBean dataBean)
        {
            iv.setImageResource(dataBean.icon);
            tv.setText(dataBean.content);
        }
    }
}
