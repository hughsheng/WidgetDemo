package ${mvpPackageName};

import com.example.sztangli.widgedemo.base.api.bean.ErrorResultBean;
import com.example.sztangli.widgedemo.base.api.rx.SchedulersCompat;
import com.example.sztangli.widgedemo.base.mvp.HttpDelegate;
import ${ApiPackageName}.${pageName}ApiService;
import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class ${pageName}Presenter extends HttpDelegate implements ${pageName}Contract.Presenter {

  private ${pageName}Contract.IView iView;
  private ${pageName}ApiService apiService;

  @Inject
  public ${pageName}Presenter(${pageName}Contract.IView iView, ${pageName}ApiService apiService) {
    this.iView = iView;
    this.apiService = apiService;
  }

  //修饰方法自动执行
  @Inject
  public void setUpPresenter() {
    iView.setPresenter(this);
  }
  

   @Override
  public void unBindPresent() {
    onUnSubscribe();
  }
}
