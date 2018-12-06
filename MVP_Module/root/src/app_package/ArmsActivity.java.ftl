package ${packageName};

import android.os.Bundle;

import com.example.sztangli.widgedemo.MainToolBarActivity;
import com.example.sztangli.widgedemo.R;
import com.example.sztangli.widgedemo.base.activity.BaseToolBarActivity;
import com.example.sztangli.widgedemo.utils.ActivityUtils;
import ${daggertPackageName}.${pageName}Module;
import ${mvpPackageName}.${pageName}Presenter;
import javax.inject.Inject;


<#import "root://activities/MVP_Module/globals.xml.ftl" as gb>

<@gb.fileHeader />
public class ${pageName}Activity extends BaseToolBarActivity {

  @Inject
  ${pageName}Presenter mPresenter;

  @Override
  public int getLayoutResId() {
    return R.layout.activity_base;
  } 

  @Override
  public void initalFragment(Bundle savedInstanceState) {
    String title = getIntent().getStringExtra(MainToolBarActivity.TITLE);
    setTitleCenter(title);
    ${pageName}Fragment mFragment = ${pageName}Fragment.newInstance();
    ActivityUtils.addFragmentToActivity(mFragmentManager, mFragment, R.id.container,
        ${pageName}Fragment.TAG);
    getApiServiceComponent().get${pageName}Component(new ${pageName}Module(mFragment))
        .inject(this);
  }
}
