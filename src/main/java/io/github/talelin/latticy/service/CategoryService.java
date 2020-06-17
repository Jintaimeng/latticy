package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.mapper.CategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-06-17
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, CategoryDO> {
    public CategoryDO getCategoryById(Integer id){
        CategoryDO categoryDO = this.getById(id);
        if(categoryDO == null)
            throw new NotFoundException(40000);
        return categoryDO;
    }
}
