package ${daggertPackageName};

import com.example.sztangli.widgedemo.base.scope.FragmentScoped;
import ${ApiPackageName}.${pageName}ApiService;
import ${mvpPackageName}.${pageName}Contract;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

<#import "root://activities/MVP_Module/globals.xml.ftl" as gb>

<@gb.fileHeader />
@Module
public  class ${pageName}Module {
  private ${pageName}Contract.IView mIView;

  public ${pageName}Module(${pageName}Contract.IView mIView) {
    this.mIView = mIView;
  }

  @FragmentScoped
  @Provides
  ${pageName}Contract.IView provides${pageName}ContractIView() {
    return mIView;
  }

  @FragmentScoped
  @Provides
  ${pageName}ApiService get${pageName}ApiService(Retrofit retrofit) {
    return retrofit.create(${pageName}ApiService.class);
  } 
}