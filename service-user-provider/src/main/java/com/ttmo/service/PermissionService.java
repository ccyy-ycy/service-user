package com.ttmo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttmo.domain.Permission;
import com.ttmo.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
 * @author yangqiaoxin
 * @date 2021/02/09
 */
@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> {
}
