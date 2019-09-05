package com.example.sztangli.widgedemo.base.fragment;

import androidx.annotation.NonNull;
import android.view.View;

import com.example.sztangli.widgedemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import tl.com.easy_recycleview_library.BaseRecyclerView;
import tl.com.easy_recycleview_library.BaseRecyclerViewAdapter;

public abstract class BaseListFragment<T> extends BaseFragment {

  @BindView(R.id.base_recycleView)
  protected BaseRecyclerView recycleView;
  @BindView(R.id.empty_view)
  protected View empty_view;

  protected List<T> listData = new ArrayList<T>();

  @Override
  public int getLayoutResId() {
    return R.layout.fragment_list;
  }

  @Override
  public void initialization() {
    recycleView.setEmptyView(empty_view);

    initView();
  }

  protected abstract void initView();

  /**
   * 是否开启下拉刷新 (默认开启)
   *
   * @param pull boolean
   */
  protected void canPull(boolean pull) {
    recycleView.setPullRefreshEnabled(pull);
  }

  /**
   * 是否开启上拉加载 (默认开启)
   *
   * @param load boolean
   */
  protected void canLoadMore(boolean load) {
    recycleView.setLoadMoreEnabled(load);
  }

  /**
   * 添加单个header
   *
   * @param baseRecyclerViewAdapter adapter
   * @param view                    header
   */
  protected void addHeader(BaseRecyclerViewAdapter baseRecyclerViewAdapter, View view) {
    baseRecyclerViewAdapter.addHeaderView(view);
  }

  /**
   * 添加多个header
   *
   * @param baseRecyclerViewAdapter adapter
   * @param views                   headers
   */
  protected void addHeaders(BaseRecyclerViewAdapter baseRecyclerViewAdapter, @NonNull List<View>
      views) {
    for (View view : views) {
      baseRecyclerViewAdapter.addHeaderView(view);
    }
  }

  /**
   * 添加单个footer
   *
   * @param baseRecyclerViewAdapter adapter
   * @param footer                  footer
   */
  protected void addFooter(BaseRecyclerViewAdapter baseRecyclerViewAdapter, View footer) {
    baseRecyclerViewAdapter.addFooterView(footer);
  }

  /**
   * 添加多个footer
   *
   * @param baseRecyclerViewAdapter adapter
   * @param footers                 footer
   */
  protected void addFooters(BaseRecyclerViewAdapter baseRecyclerViewAdapter, List<View> footers) {
    for (View view : footers) {
      baseRecyclerViewAdapter.addFooterView(view);
    }
  }


}
