package com.example.sztangli.widgedemo.coordinatorsample;

import android.os.Bundle;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.databinding.ActivityCoordinatorBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sztangli.widgedemo.home.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.coordinatorsample.adapter.TypeAdapter;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import com.guyuan.handlein.base.databinding.ActivityWithToolbarBinding;
import com.guyuan.handlein.base.databinding.ActivityWithoutToolbarBinding;
import com.guyuan.handlein.base.ui.activity.BaseNoToolbarActivity;
import com.guyuan.handlein.base.ui.activity.BaseToolbarActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class CoordinatorToolBarActivity extends BaseToolbarActivity<ActivityCoordinatorBinding, BaseViewModel> {

    private AppBarLayout.LayoutParams params;

    private void setSpinner() {
        binding.collapsingtoolbar.titleSpinner.setVisibility(View.VISIBLE);
        params = (AppBarLayout.LayoutParams) binding.collapsingtoolbar.toolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
        final String[] arr = {"scroll", "scroll|enterAlways", "scroll|enterAlways|enterAlwaysCollapsed",
                "scroll|exitUntilCollapsed", "scroll|snap"};
        List<String> dataList = Arrays.asList(arr);
        TypeAdapter adapter = new TypeAdapter(this, dataList);
        binding.collapsingtoolbar.titleSpinner.setAdapter(adapter);

        binding.collapsingtoolbar.titleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (arr[position]) {
//          Child View 伴随着滚动事件而滚出或滚进屏幕。
//          注意两点：第一点，如果使用了其他值，必定要使用这个值才能起作用；
//          第二点：如果在这个child View前面的任何其他Child View没有设置这个值，
//          那么这个Child View的设置将失去作用。
                    case "scroll":
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                        break;
//          快速返回模式。其实就是向下滚动时Scrolling View和Child View之间的滚动优先级问题。
//          对比scroll和scroll | enterAlways设置，发生向下滚动事件时，
//          前者优先滚动Scrolling View，后者优先滚动Child View，当优先滚动的一方已经全部滚进屏幕之后，
//          另一方才开始滚动。
                    case "scroll|enterAlways":
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout
                                .LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
                        break;
//          enterAlways的附加值。这里涉及到Child View的高度和最小高度，向下滚动时，
//          Child View先向下滚动最小高度值，然后Scrolling View开始滚动，到达边界时，
//          Child View再向下滚动，直至显示完全。
                    case "scroll|enterAlways|enterAlwaysCollapsed":

                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout
                                .LayoutParams.SCROLL_FLAG_ENTER_ALWAYS | AppBarLayout.LayoutParams
                                .SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);

                        break;
//          这里也涉及到最小高度。发生向上滚动事件时，Child View向上滚动退出直至最小高度，
//          然后Scrolling View开始滚动。也就是，Child View不会完全退出屏幕。
                    case "scroll|exitUntilCollapsed":
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout
                                .LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
                        break;

                    case "scroll|snap":
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout
                                .LayoutParams.SCROLL_FLAG_SNAP);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        CoordinatorFragment fragment = CoordinatorFragment.newInstance();
        ActivityUtils.addFragmentToActivity(fragmentManager, fragment, R.id.fragment_container,
                CoordinatorFragment.TAG);
        setTitleCenter(getIntent().getStringExtra(MainToolBarActivity.TITLE));
        setSpinner();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_coordinator;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }
}
