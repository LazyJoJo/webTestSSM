package com.ruijie.rgcc.service;

import com.ruijie.rgcc.dao.QualificationDao;
import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.inter.EfficientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EfficientServiceImpl implements EfficientService {
    @Resource
    private QualificationDao qdao;

    @Override
    public List<Qualification> getAll() {
        return qdao.findAll();
    }
}
