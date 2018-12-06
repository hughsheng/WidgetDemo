package ${mvpPackageName};

import com.example.sztangli.widgedemo.base.mvp.BasePresenter;
import com.example.sztangli.widgedemo.base.mvp.BaseView;

<#import "root://activities/MVP_Module/globals.xml.ftl" as gb>

<@gb.fileHeader />
public interface ${pageName}Contract {
    interface IView extends BaseView<Presenter> {
    
  }

  interface Presenter extends BasePresenter {
    
  }
}
