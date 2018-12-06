<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
<@kt.addAllKotlinDependencies />

    <merge from="root/AndroidManifest.xml.ftl"
           to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <!-- <merge from="root/src/app_package/ApiServiceComponent.${ktOrJavaExt}.ftl"
           to="${projectOut}/src/main/java/com.example.szTangli.widgedemo.base.api/ApiServiceComponent.${ktOrJavaExt}" /> -->


<#-- 界面 -->
<#if activityType=="1">
    <instantiate from="root/src/app_package/ArmsActivity.${ktOrJavaExt}.ftl"
                   to="${projectOut}/src/main/java/${slashedPackageName(activityPackageName)}/${pageName}Activity.${ktOrJavaExt}" />
    <open file="${projectOut}/src/main/java/${slashedPackageName(activityPackageName)}/${pageName}Activity.${ktOrJavaExt}" />
</#if>

<#if fragmentType=="1">
    <instantiate from="root/src/app_package/ArmsFragment.${ktOrJavaExt}.ftl"
                   to="${projectOut}/src/main/java/${slashedPackageName(activityPackageName)}/${pageName}Fragment.${ktOrJavaExt}" />
    <open file="${projectOut}/src/main/java/${slashedPackageName(activityPackageName)}/${pageName}Fragment.${ktOrJavaExt}" />
</#if>

<#-- api包 -->
<instantiate from="root/src/app_package/ArmsApiService.${ktOrJavaExt}.ftl"
                   to="${projectOut}/src/main/java/${slashedPackageName(ApiPackageName)}/${pageName}ApiService.${ktOrJavaExt}" />

<#-- mvp包 -->
    <instantiate from="root/src/app_package/ArmsContract.${ktOrJavaExt}.ftl"
                   to="${projectOut}/src/main/java/${slashedPackageName(mvpPackageName)}/${pageName}Contract.${ktOrJavaExt}" />
    <instantiate from="root/src/app_package/ArmsPresenter.${ktOrJavaExt}.ftl"
                   to="${projectOut}/src/main/java/${slashedPackageName(mvpPackageName)}/${pageName}Presenter.${ktOrJavaExt}" />
    <open file="${projectOut}/src/main/java/${slashedPackageName(mvpPackageName)}/${pageName}Presenter.${ktOrJavaExt}" />


<#-- dagger包 -->
    <instantiate from="root/src/app_package/ArmsComponent.${ktOrJavaExt}.ftl"
                   to="${projectOut}/src/main/java/${slashedPackageName(daggertPackageName)}/${pageName}Component.${ktOrJavaExt}" />
    <instantiate from="root/src/app_package/ArmsModule.${ktOrJavaExt}.ftl"
                   to="${projectOut}/src/main/java/${slashedPackageName(daggertPackageName)}/${pageName}Module.${ktOrJavaExt}" />



</recipe>
