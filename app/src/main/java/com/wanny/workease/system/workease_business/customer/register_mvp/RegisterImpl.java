package com.wanny.workease.system.workease_business.customer.register_mvp;


import com.wanny.workease.system.framework_care.OrdinalResultEntity;
import com.wanny.workease.system.framework_mvpbasic.BaseOperateImp;

/**
 * 文件名： RegisterImpl
 * 功能：
 * 作者： wanny
 * 时间： 14:31 2017/4/6
 */
public interface RegisterImpl extends BaseOperateImp<OrdinalResultEntity> {

    void registerSuccess(RegisterResult entity);
    void workType(WorkTypeResult entity);
    void getCityValue(CityResult cityResult);
}
