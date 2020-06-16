package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.SpuDO;
import io.github.talelin.latticy.mapper.SpuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.model.SpuDetailDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-06-16
 */
@Service
public class SpuService extends ServiceImpl<SpuMapper, SpuDO> {
    public SpuDetailDO getDetail(Long id){
        return this.baseMapper.getDetail(id);
    }

}
