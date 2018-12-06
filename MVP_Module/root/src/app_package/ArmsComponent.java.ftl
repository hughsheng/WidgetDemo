package ${daggertPackageName};

import com.example.sztangli.widgedemo.base.scope.FragmentScoped;
import ${activityPackageName}.${pageName}Activity;
import dagger.Subcomponent;

<#import "root://activities/MVP_Module/globals.xml.ftl" as gb>


@FragmentScoped
@Subcomponent(modules = ${pageName}Module.class)
public interface ${pageName}Component {
  void inject(${pageName}Activity mActivity);
}