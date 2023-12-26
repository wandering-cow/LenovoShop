package com.ouc.lenovoshop.service;

import cn.hutool.core.util.ObjectUtil;
import com.ouc.lenovoshop.common.Constants;
import com.ouc.lenovoshop.common.enums.ResultCodeEnum;
import com.ouc.lenovoshop.common.enums.RoleEnum;
import com.ouc.lenovoshop.common.enums.StatusEnum;
import com.ouc.lenovoshop.entity.Account;
import com.ouc.lenovoshop.entity.Business;
import com.ouc.lenovoshop.exception.CustomException;
import com.ouc.lenovoshop.mapper.BusinessMapper;
import com.ouc.lenovoshop.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商家业务处理
 **/
@Service
public class BusinessService {

    @Resource
    private BusinessMapper businessMapper;

    /**
     * 新增
     */
    public void add(Business business) {
        Business dbBusiness = businessMapper.selectByUsername(business.getUsername());
        if (ObjectUtil.isNotNull(dbBusiness)) {
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(business.getPassword())) {
            business.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        if (ObjectUtil.isEmpty(business.getName())) {
            business.setName(business.getUsername());
        }
        if (ObjectUtil.isEmpty(business.getStatus())) {
            business.setStatus(StatusEnum.CHECKING.status);
        }
        business.setRole(RoleEnum.BUSINESS.name());
        businessMapper.insert(business);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        businessMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            businessMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Business business) {
        businessMapper.updateById(business);
    }

    /**
     * 根据ID查询
     */
    public Business selectById(Integer id) {
        return businessMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Business> selectAll(Business business) {
        return businessMapper.selectAll(business);
    }

    /**
     * 分页查询
     */
    public PageInfo<Business> selectPage(Business business, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Business> list = businessMapper.selectAll(business);
        return PageInfo.of(list);
    }

    /**
     * 登录
     */
    public Account login(Account account) {
        Account dbBusiness = businessMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbBusiness)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!account.getPassword().equals(dbBusiness.getPassword())) {
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        // 生成token
        String tokenData = dbBusiness.getId() + "-" + RoleEnum.BUSINESS.name();
        String token = TokenUtils.createToken(tokenData, dbBusiness.getPassword());
        dbBusiness.setToken(token);
        return dbBusiness;
    }

    /**
     * 注册
     */
    public void register(Account account) {
        Business business = new Business();
        BeanUtils.copyProperties(account, business);
        add(business);
    }

    /**
     * 修改密码
     */
    public void updatePassword(Account account) {
        Business dbBusiness = businessMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbBusiness)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!account.getPassword().equals(dbBusiness.getPassword())) {
            throw new CustomException(ResultCodeEnum.PARAM_PASSWORD_ERROR);
        }
        dbBusiness.setPassword(account.getNewPassword());
        businessMapper.updateById(dbBusiness);
    }

}