package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService extends ServiceImpl<BannerMapper, BannerDO> {
    @Autowired
    private BannerItemMapper bannerItemMapper;
    public void update(BannerDTO bannerDTO, Long id){
        BannerDO bannerDO = this.getById(id);
        if(bannerDO == null){
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        this.updateById(bannerDO);
    }
    public void delete(Long id){
        BannerDO bannerDO = this.getById(id);
        if(bannerDO == null){
            throw new NotFoundException(20000);
        }
        this.getBaseMapper().deleteById(id);
    }
    public BannerWithItemsBO getWithItems(Long id){
        BannerDO bannerDO = this.getById(id);
        if(bannerDO == null){
            throw new NotFoundException(20000);
        }
        QueryWrapper<BannerItemDO> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("banner_id", id);
        queryWrapper.lambda().eq(BannerItemDO::getBannerId, id);
        List<BannerItemDO> bannerItemDOS = this.bannerItemMapper.selectList(queryWrapper);
        //service --> controller BO
        return new BannerWithItemsBO(bannerDO, bannerItemDOS);
        //链式调用
//        List<BannerItemDO> bannerItemDOS1 = new LambdaQueryChainWrapper<>(bannerItemMapper)
//                .eq(BannerItemDO::getBannerId, id).list();
    }
}
