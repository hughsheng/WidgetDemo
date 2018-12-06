package ${packageName};

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.api.bean.ErrorResultBean;
import com.example.sztangli.widgedemo.base.fragment.BaseFragment;

import ${mvpPackageName}.${pageName}Contract;

<#import "root://activities/MVP_Module/globals.xml.ftl" as gb>

<@gb.fileHeader />
public class ${pageName}Fragment extends BaseFragment implements ${pageName}Contract.IView{
  
  public static final String TAG = "${pageName}Fragment";
  private ${pageName}Contract.Presenter mPresenter;

    public static ${pageName}Fragment newInstance() {
      Bundle args = new Bundle();
     
      ${pageName}Fragment fragment = new ${pageName}Fragment();
      fragment.setArguments(args);
      return fragment;
    }

 @Override
  public int getLayoutResId() {
    return 0;
  }

 @Override
  public void initialization() {
    
  }


 @Override
  public void setPresenter(@NonNull ${pageName}Contract.Presenter presenter) {
    mPresenter = presenter;
  }

  @Override
  public void onLoadFail(ErrorResultBean.ErrorBean errorBean) {
    showToastTip(errorBean.getErrorResult());
  }

  @Override
  public void show() {
    showLoadingWithStatus(childManager, "获取数据中...");
  }

  @Override
  public void hide() {
    hideLoading();
  }

   @Override
  public void onUnBind() {
    mPresenter.unBindPresent();
  }
}
