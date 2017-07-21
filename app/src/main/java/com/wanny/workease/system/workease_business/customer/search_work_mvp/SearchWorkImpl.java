package com.wanny.workease.system.workease_business.customer.search_work_mvp;

import com.wanny.workease.system.framework_mvpbasic.BaseOperateImp;
import com.wanny.workease.system.workease_business.customer.main_mvp.WorkResult;
import com.wanny.workease.system.workease_business.customer.register_mvp.CityResult;
import com.wanny.workease.system.workease_business.customer.register_mvp.WorkTypeResult;

/**
 * 文件名： SearchWorkImpl
 * 功能：
 * 作者： wanny
 * 时间： 16:07 2017/7/21
 */
public interface SearchWorkImpl extends BaseOperateImp<WorkResult> {

    void workType(WorkTypeResult entity);
    void getCityValue(CityResult cityResult);




}
