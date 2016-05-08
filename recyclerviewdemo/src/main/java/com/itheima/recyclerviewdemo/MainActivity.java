package com.itheima.recyclerviewdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity
        extends ActionBarActivity
        implements SwipeRefreshLayout.OnRefreshListener
{
    private RecyclerView       mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;

    private List<DataBean> mListDatas     = new ArrayList<DataBean>();
    private List<DataBean> mStraggerDatas = new ArrayList<DataBean>();

    private int[] mListIcons = new int[]{R.mipmap.g1,
                                         R.mipmap.g2,
                                         R.mipmap.g3,
                                         R.mipmap.g4,
                                         R.mipmap.g5,
                                         R.mipmap.g6,
                                         R.mipmap.g7,
                                         R.mipmap.g8,
                                         R.mipmap.g9,
                                         R.mipmap.g10,
                                         R.mipmap.g11,
                                         R.mipmap.g12,
                                         R.mipmap.g13,
                                         R.mipmap.g14,
                                         R.mipmap.g15,
                                         R.mipmap.g16,
                                         R.mipmap.g17,
                                         R.mipmap.g18,
                                         R.mipmap.g19,
                                         R.mipmap.g20,
                                         R.mipmap.g21,
                                         R.mipmap.g22,
                                         R.mipmap.g23,
                                         R.mipmap.g24,
                                         R.mipmap.g25,
                                         R.mipmap.g26,
                                         R.mipmap.g27,
                                         R.mipmap.g28,
                                         R.mipmap.g29};

    private int[] mStraggeredIcons = new int[]{R.mipmap.p1,
                                               R.mipmap.p2,
                                               R.mipmap.p3,
                                               R.mipmap.p4,
                                               R.mipmap.p5,
                                               R.mipmap.p6,
                                               R.mipmap.p7,
                                               R.mipmap.p8,
                                               R.mipmap.p9,
                                               R.mipmap.p10,
                                               R.mipmap.p11,
                                               R.mipmap.p12,
                                               R.mipmap.p13,
                                               R.mipmap.p14,
                                               R.mipmap.p15,
                                               R.mipmap.p16,
                                               R.mipmap.p17,
                                               R.mipmap.p18,
                                               R.mipmap.p19,
                                               R.mipmap.p20,
                                               R.mipmap.p21,
                                               R.mipmap.p22,
                                               R.mipmap.p23,
                                               R.mipmap.p24,
                                               R.mipmap.p25,
                                               R.mipmap.p26,
                                               R.mipmap.p27,
                                               R.mipmap.p28,
                                               R.mipmap.p29,
                                               R.mipmap.p30,
                                               R.mipmap.p31,
                                               R.mipmap.p32,
                                               R.mipmap.p33,
                                               R.mipmap.p34,
                                               R.mipmap.p35,
                                               R.mipmap.p36,
                                               R.mipmap.p37,
                                               R.mipmap.p38,
                                               R.mipmap.p39,
                                               R.mipmap.p40,
                                               R.mipmap.p41,
                                               R.mipmap.p42,
                                               R.mipmap.p43,
                                               R.mipmap.p44};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        mRefreshLayout.setOnRefreshListener(this);

        //模拟加载数据
        for (int i = 0; i < mListIcons.length; i++)
        {
            DataBean bean = new DataBean();
            bean.icon = mListIcons[i];
            bean.content = "内容-" + i;

            mListDatas.add(bean);
        }

        for (int i = 0; i < mStraggeredIcons.length; i++)
        {
            DataBean bean = new DataBean();
            bean.icon = mStraggeredIcons[i];
            bean.content = "内容-" + i;

            mStraggerDatas.add(bean);
        }

        //list的效果
        initList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,
                                  menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_list)
        {
            initList();
            return true;
        } else if (id == R.id.action_grid)
        {
            initGrid();
            return true;
        } else if (id == R.id.action_stragger)
        {
            initStragger();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void initList()
    {
        //实现listView的效果
        // 可以垂直滑动，也可以水平滑动，数据反向加载

        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                                                                    LinearLayoutManager.VERTICAL,
                                                                    false);
        mRecyclerView.setLayoutManager(layoutManager);

        //设置adapter
        mRecyclerView.setAdapter(new ListAdapter(this,
                                                 mListDatas));//adapter ---> list数据
    }

    private void initGrid()
    {
        //实现listView的效果
        // 可以垂直滑动，也可以水平滑动，数据反向加载

        //设置布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this,
                                                                2,
                                                                GridLayoutManager.VERTICAL,
                                                                false);
        mRecyclerView.setLayoutManager(layoutManager);

        //设置adapter
        mRecyclerView.setAdapter(new ListAdapter(this,
                                                 mListDatas));//adapter ---> list数据
    }

    private void initStragger()
    {
        //实现listView的效果
        // 可以垂直滑动，也可以水平滑动，数据反向加载

        //设置布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                                                                                  StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);

        //设置adapter
        mRecyclerView.setAdapter(new StraggerdAdpater(this,
                                                      mStraggerDatas));//adapter ---> list数据
    }

    @Override
    public void onRefresh()
    {
        //下拉刷新时的回调
        new AsyncTask<Void, Void, Void>()
        {

            @Override
            protected Void doInBackground(Void... params)
            {
                try
                {
                    Thread.sleep(3000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                RecyclerView.Adapter adapter = mRecyclerView.getAdapter();

                if (adapter instanceof ListAdapter)
                {
                    //给list加载数据
                    for (int i = 0; i < mListIcons.length; i++)
                    {
                        DataBean bean = new DataBean();
                        bean.icon = mListIcons[i];
                        bean.content = "内容-" + i;

                        mListDatas.add(bean);
                    }
                } else if (adapter instanceof StraggerdAdpater)
                {
                    //给stragger加载数据
                    for (int i = 0; i < mStraggeredIcons.length; i++)
                    {
                        DataBean bean = new DataBean();
                        bean.icon = mStraggeredIcons[i];
                        bean.content = "内容-" + i;

                        mStraggerDatas.add(bean);
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid)
            {
                super.onPostExecute(aVoid);

                RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
                //adatper刷新
                adapter.notifyDataSetChanged();
                //通知刷新的view刷新完成
                mRefreshLayout.setRefreshing(false);

            }
        }.execute();

    }
}
